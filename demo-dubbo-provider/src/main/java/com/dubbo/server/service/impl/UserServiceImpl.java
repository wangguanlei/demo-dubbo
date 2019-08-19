package com.dubbo.server.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.UserService;
import com.dubbo.entity.UserDO;

@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

	@SuppressWarnings("serial")
	private List<UserDO> users = new ArrayList<UserDO>() {
		{
			add(new UserDO(1L, "熊大", "123"));
			add(new UserDO(2L, "熊二", "234"));
			add(new UserDO(3L, "熊三", "456"));
		}
	};

	@Override
	public UserDO findById(@NotBlank Long id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().get();
	}

	@Override
	public List<UserDO> listUser() {
		return users;
	}

}
