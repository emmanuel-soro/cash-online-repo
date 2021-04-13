package com.cash_online.service;

import java.util.Optional;

import com.cash_online.model.User;

public interface IUserService {

	public Optional<User> findById(Long id);

	public User createUser(User user);

}
