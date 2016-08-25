package org.mel.generic.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.mel.framework.request.AbstractPageRequestAdapter;
import org.mel.framework.response.AbstractListResponse;
import org.mel.framework.response.AbstractResponse;
import org.mel.generic.auth.dto.UserCreateRequest;
import org.mel.generic.auth.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	public AbstractListResponse<User> searchUser(AbstractPageRequestAdapter request) {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setEmail("privatemiao@gmail.com");
		user.setMobile("13451567003");
		user.setName("Mel Liu");
		users.add(user);
		return new AbstractListResponse<User>() {

			@Override
			public List<User> getData() {
				return users;
			}

		};
	}

	public AbstractResponse saveUser(UserCreateRequest request) {
		return AbstractResponse.createResponse(Boolean.TRUE);
	}
}
