package com.cash_online.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cash_online.dto.UserDTO;
import com.cash_online.exception.UserNotFoundException;
import com.cash_online.model.User;
import com.cash_online.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
public class UserController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IUserService userService;

	@GetMapping(value = "/users/{id}")
	public UserDTO findById(@PathVariable("id") final Long id) {

		final Optional<User> user = this.userService.findById(id);

		if (user.isPresent()) {
			log.info("User found");
			return this.modelMapper.map(user.get(), UserDTO.class);
		}

		log.error("User Not Found");
		throw new UserNotFoundException();

	}

	@PostMapping(value = "/users")
	public UserDTO createUser(@RequestBody final UserDTO userDTO) {
		final User user = this.modelMapper.map(userDTO, User.class);
		final User userSaved = this.userService.createUser(user);
		return this.modelMapper.map(userSaved, UserDTO.class);
	}

}
