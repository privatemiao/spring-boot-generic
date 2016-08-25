package org.mel.security.controller;

import java.util.List;

import javax.annotation.Resource;

import org.mel.framework.response.AbstractListResponse;
import org.mel.security.domain.Node;
import org.mel.security.service.ResourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityController {

	@Resource
	private ResourceService resourceService;

	@RequestMapping("allmenu")
	public AbstractListResponse<Node> getAllMenu() {
		return new AbstractListResponse<Node>() {

			@Override
			public List<Node> getData() {
				return resourceService.getAllMenus();
			}

			@Override
			public boolean isSuccess() {
				return Boolean.TRUE;
			}

		};
	}
}
