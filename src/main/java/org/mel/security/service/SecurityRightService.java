package org.mel.security.service;

import java.util.List;

import javax.annotation.Resource;

import org.mel.security.entity.SecurityRight;
import org.mel.security.repository.SecurityRightDao;
import org.springframework.stereotype.Service;

@Service
public class SecurityRightService {
	@Resource
	private SecurityRightDao securityRightDao;

	/**
	 * 系统启动时，同步resources.json。
	 * 
	 * @param rights
	 */
	public void syncRights(List<SecurityRight> rights) {
		List<SecurityRight> removeableRights = (List<SecurityRight>) securityRightDao.findAll();

		if (rights != null && !rights.isEmpty()) {
			for (SecurityRight right : rights) {
				SecurityRight foundRight = null;
				for (int i = removeableRights.size() - 1; i >= 0; i--) {
					SecurityRight removeableRight = removeableRights.get(i);
					if (removeableRight.getUri().equals(right.getUri())) {
						right.setId(removeableRight.getId());
						foundRight = removeableRight;
						removeableRights.remove(i);
						break;
					}
				}
				if (!right.equals(foundRight)){
					securityRightDao.save(right);
					System.out.println("save -> " + right.getUri());
				}
				foundRight = null;
			}
		}

		if (removeableRights != null && removeableRights.size() > 0){
			System.out.println("remove " + removeableRights.size());
			securityRightDao.delete(removeableRights);
		}
	}
}
