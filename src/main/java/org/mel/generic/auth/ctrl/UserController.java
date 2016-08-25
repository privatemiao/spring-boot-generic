package org.mel.generic.auth.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.mel.framework.request.AbstractPageRequestAdapter;
import org.mel.framework.response.AbstractListResponse;
import org.mel.generic.auth.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth/user")
public class UserController {

	@RequestMapping(method = RequestMethod.POST)
	public AbstractListResponse<User> searchUser(@RequestBody AbstractPageRequestAdapter request) {
		System.out.println(request);
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
}
