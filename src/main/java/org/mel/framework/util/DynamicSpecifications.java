package org.mel.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicSpecifications {
	protected static final Logger logger = LoggerFactory.getLogger(DynamicSpecifications.class);

	public static <T> Specification<T> bySearchFilter(final Collection<SearchFilter> filters,
			final Class<T> entityClazz) {
		return new Specification<T>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (filters != null && !filters.isEmpty()) {
					List<Predicate> predicates = new ArrayList<>();
					List<Predicate> orPredicates = new ArrayList<>();
					for (SearchFilter filter : filters) {
						// nested path translate, 如Task的名为"user.name"的filedName,
						// 转换为Task.user.name属性
						String[] names = StringUtils.split(filter.fieldName, ".");
						Path expression = root.get(names[0]);
						for (int i = 1; i < names.length; i++) {
							expression = expression.get(names[i]);
						}

						// logic operator
						switch (filter.operator) {
						case EQ:
							predicates.add(builder.equal(expression, filter.value));
							break;
						case LIKE:
							predicates.add(builder.like(expression, "%" + filter.value + "%"));
							break;
						case ORLIKE:
							orPredicates.add(builder.like(expression, "%" + filter.value + "%"));
							break;
						case GT:
							predicates.add(builder.greaterThan(expression, (Comparable) filter.value));
							break;
						case LT:
							predicates.add(builder.lessThan(expression, (Comparable) filter.value));
							break;
						case GTE:
							predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filter.value));
							break;
						case LTE:
							predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filter.value));
							break;
						case NEQ:
							predicates.add(builder.notEqual(expression, filter.value));
							break;
						case OREQ:
							orPredicates.add(builder.equal(expression, filter.value));
							break;
						case IN:
							predicates.add(builder.in(expression).value(filter.value));
							break;

						}
					}

					// 将所有条件用 and 联合起来
					if (!predicates.isEmpty() && orPredicates.isEmpty()) {
						return builder.and(predicates.toArray(new Predicate[predicates.size()]));
					} else if (predicates.isEmpty() && !orPredicates.isEmpty()) {
						return builder.or(orPredicates.toArray(new Predicate[orPredicates.size()]));
					} else if (!predicates.isEmpty() && !orPredicates.isEmpty()) {
						Predicate orPredicate = builder.or(orPredicates.toArray(new Predicate[orPredicates.size()]));
						return builder.and(builder.and(predicates.toArray(new Predicate[predicates.size()])),
								orPredicate);
					}
				}
				return builder.conjunction();
			}
		};
	}
}
