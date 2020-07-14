package com.system.springboot.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.validator.Validator;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import com.system.springboot.backend.entity.User;
import com.system.springboot.backend.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	/**
	 * Injection of dependency
	 */
	private final UserRepository userRepository;
	private final Validator validator;

	/**
	 * all the users exists
	 * @return list of user or list empty
	 */
	public List<User> findAllUsers(){
		List<User> listUsers = new ArrayList<>();

		Optional.ofNullable(userRepository.findAll())
				.orElseThrow(()->new NotFoundException("empty list",new Exception("")))
				.forEach(listUsers::add);

		return listUsers;
	}

	public User findById(Long id){
		return userRepository.findById(id).orElseThrow(()->new NotFoundException("the user does not exist",new Exception()));
	}

	public User findByTelephone(String telephone){
		return Optional.ofNullable(userRepository.findUserByTelephone(telephone))
				.orElseThrow(()->new NotFoundException("the user does not exist",new Exception()));
	}

	public List<User> findByNameContaining(String name){
		List<User> listUsers = new ArrayList<>();

		Optional.of(userRepository.findUserByNameContaining(name))
				.orElseThrow(()->new NotFoundException("empty list",new Exception("")))
				.forEach(listUsers::add);

		return listUsers;
	}

	public User saveUser(User user){
		validator.validator(user);
		return userRepository.save(user);
	}
}
