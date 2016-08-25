package org.mel.security.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.mel.framework.request.AbstractPageRequest;
import org.mel.framework.util.DynamicSpecifications;
import org.mel.framework.util.SearchFilter;
import org.mel.security.entity.SecurityRole;
import org.mel.security.repository.SecurityRoleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SecurityRoleService {
	protected final static Logger logger = LoggerFactory.getLogger(SecurityRoleService.class);

	@Resource
	private SecurityRoleDao securityRoleDao;

	public void save(SecurityRole role) {
		if (role.getId() == null) {
			role.setUpdateTime(role.getCreateTime());
		} else {
			role.setUpdateTime(new Date());
		}
		securityRoleDao.save(role);
	}

	public Page<SecurityRole> search(AbstractPageRequest request) {
		String param = request.getParam();// 模糊查询参数
		Map<String, Object> params = request.getParams();// 精确查询参数
		logger.debug("Param->{}", param);
		logger.debug("Params->{}", params);

		if (!StringUtils.isBlank(param)) {
			params.clear();
			params.put("ORLIKE_name", param);
			params.put("ORLIKE_description", param);
			logger.debug("Params->{}", params);
		}
		Map<String, SearchFilter> filters = SearchFilter.parse(params);
		Specification<SecurityRole> spec = DynamicSpecifications.bySearchFilter(filters.values(), SecurityRole.class);
		return securityRoleDao.findAll(spec, request.getPageRequest());
	}
}
