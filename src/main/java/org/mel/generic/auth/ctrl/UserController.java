package org.mel.generic.auth.ctrl;

import javax.annotation.Resource;

import org.mel.framework.request.AbstractPageRequestAdapter;
import org.mel.framework.response.AbstractListResponse;
import org.mel.framework.response.AbstractResponse;
import org.mel.generic.auth.dto.UserCreateRequest;
import org.mel.generic.auth.entity.User;
import org.mel.generic.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public AbstractListResponse<User> searchUser(@RequestBody AbstractPageRequestAdapter request) {
		logger.debug("Query user by {}.", request);
		return userService.searchUser(request);
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public AbstractResponse create(@RequestBody UserCreateRequest request) {
		logger.debug("Create user by {}.", request);
		return userService.saveUser(request);
	}

}
