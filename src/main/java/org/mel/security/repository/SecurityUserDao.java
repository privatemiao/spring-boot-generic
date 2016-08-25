package org.mel.security.repository;

import org.mel.security.entity.SecurityUser;
import org.springframework.data.repository.CrudRepository;

public interface SecurityUserDao extends CrudRepository<SecurityUser, Long>{
	
}
