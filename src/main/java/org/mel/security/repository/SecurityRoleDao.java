package org.mel.security.repository;

import org.mel.security.entity.SecurityRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SecurityRoleDao extends PagingAndSortingRepository<SecurityRole, Long>, JpaSpecificationExecutor<SecurityRole> {
	public Page<SecurityRole> findByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase(String name, String desc, Pageable page);
}
