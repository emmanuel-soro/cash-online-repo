package com.cash_online.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cash_online.model.User;
import com.cash_online.repository.UserRepository;
import com.cash_online.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findById(final Long id) {

		return this.userRepository.findById(id);
	}

	@Override
	@Transactional
	public User createUser(final User user) {

		return this.userRepository.save(user);
	}
}
