package org.mel.security.service;

import javax.annotation.Resource;

import org.mel.security.entity.SecurityUser;
import org.mel.security.repository.SecurityUserDao;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService {
	@Resource
	SecurityUserDao securityUserDao;
	
	public void save(SecurityUser securityUser){
		securityUserDao.save(securityUser);
	}
}
