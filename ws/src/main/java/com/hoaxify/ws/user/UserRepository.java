package com.hoaxify.ws.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	Page<User> findByUsernameNot(String username, Pageable page);
	
}
