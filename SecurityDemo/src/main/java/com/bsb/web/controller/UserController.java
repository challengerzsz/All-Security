/**
 * 
 */
package com.bsb.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.bsb.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import com.bsb.dto.User;


@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition userQueryCondition,
							@PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {

		System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}

	@GetMapping("/user/{id:\\d+}")
	@JsonView(User.UserDetailViewView.class)
	public User getInfo(@PathVariable("id") String id) {
		User user = new User();
		user.setUsername("tom");
		return user;
	}

}
