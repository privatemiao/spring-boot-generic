package org.mel.security.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.mel.framework.request.AbstractPageRequest;
import org.mel.framework.response.AbstractPageResponse;
import org.mel.framework.util.BeanMapper;
import org.mel.security.domain.Node;
import org.mel.security.dto.SecurityRoleCreateRequest;
import org.mel.security.dto.SecurityRoleDTO;
import org.mel.security.dto.SecurityRoleUpdateRequest;
import org.mel.security.entity.SecurityRight;
import org.mel.security.entity.SecurityRole;
import org.mel.security.repository.SecurityRightDao;
import org.mel.security.repository.SecurityRoleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	protected final static Logger logger = LoggerFactory.getLogger(SecurityService.class);

	@Resource
	private ResourceService resourceService;

	@Resource
	private SecurityRoleService securityRoleService;

	@Resource
	private SecurityRightDao securityRightDao;

	@Resource
	private SecurityRoleDao securityRoleDao;

	public List<Node> getAllMenu() {
		return resourceService.getAllMenus();
	}

	public void createSecurityRoleService(SecurityRoleCreateRequest request) {
		SecurityRole securityRole = BeanMapper.map(request, SecurityRole.class);

		if (securityRole.getId() != null) {
			throw new IllegalArgumentException("Role.id should be null!");
		}

		Set<Long> rightIds = request.getRightIds();
		Set<SecurityRight> securityRights = new HashSet<>();
		Iterable<SecurityRight> securityRightEntities = securityRightDao.findAll(rightIds);
		for (SecurityRight securityRight : securityRightEntities) {
			securityRights.add(securityRight);
		}
		securityRole.setRights(securityRights);
		logger.debug("Converted SecurityRole ->{}", securityRole);
		securityRoleService.save(securityRole);
	}

	public void updateSecurityRoleService(SecurityRoleUpdateRequest request) {
		createSecurityRoleService(request);
	}

	public SecurityRoleDTO findRoleById(Long id) {
		SecurityRole role = securityRoleDao.findOne(id);
		return BeanMapper.map(role, SecurityRoleDTO.class);
	}
	
	public AbstractPageResponse<SecurityRoleDTO> searchRole(AbstractPageRequest request){
		Page<SecurityRole> pageOfRole = securityRoleService.search(request);
		AbstractPageResponse<SecurityRoleDTO> response = new AbstractPageResponse<>();
		response.setTotalElements(pageOfRole.getTotalElements());
		List<SecurityRoleDTO> dtos = new ArrayList<>();
		for (SecurityRole securityRole : pageOfRole.getContent()) {
			SecurityRoleDTO dto = BeanMapper.map(securityRole, SecurityRoleDTO.class);
			dtos.add(dto);
		}
		response.setData(dtos);
		response.setSuccess(true);
		return response;
	}
}
