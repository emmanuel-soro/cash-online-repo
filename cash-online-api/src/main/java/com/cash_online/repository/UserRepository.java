package com.cash_online.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cash_online.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
