package org.mel.security.service;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.mel.GenericApplicationTests;
import org.mel.security.dto.SecurityRoleCreateRequest;

public class SecurityServiceTest extends GenericApplicationTests {

	@Resource
	private SecurityService securityService;

	@Test
	public void testGetAllMenu() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateSecurityRoleService() {
		SecurityRoleCreateRequest request = new SecurityRoleCreateRequest();
		request.setDescription("Administrator");
		request.setName("Admin");

		Set<Long> rightIds = new HashSet<>();
		rightIds.add(1L);
		rightIds.add(2L);
		rightIds.add(3L);
		rightIds.add(4L);
		rightIds.add(1L);
		rightIds.add(1L);
		rightIds.add(4L);

		request.setRightIds(rightIds);
		
		securityService.createSecurityRoleService(request);
	}

	@Test
	public void testUpdateSecurityRoleService() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRoleById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchRole() {
		fail("Not yet implemented");
	}

}
