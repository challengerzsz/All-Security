/**
 * 
 */
package com.bsb.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.bsb.dto.UserQueryCondition;
import com.bsb.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.bsb.dto.User;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	@JsonView(User.UserSimpleView.class)
	@ApiOperation(value = "用户查询服务")
	public List<User> query(UserQueryCondition userQueryCondition,
							@PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable) {

		System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}

	@GetMapping("/{id:\\d+}")
	@JsonView(User.UserDetailViewView.class)
	public User getInfo(@ApiParam(value = "用户查询id") @PathVariable("id") String id) {

//		throw new UserNotExistException(id);

		System.out.println("进入getUserInfo");
		User user = new User();
		user.setUsername("tom");
		return user;
	}

	@PostMapping
	public User create(@Valid @RequestBody User user) {

		user.setId("1");
		System.out.println(user.getBirthday());
		return user;
	}

	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user, BindingResult errors){
		if (errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> {
				System.out.println(error.getDefaultMessage());
			});
		}
		user.setId("1");
		System.out.println(user.getBirthday());
		return user;
	}

	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable("id") String id) {
		System.out.println(id);
	}

}
