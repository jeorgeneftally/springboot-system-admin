package com.system.springboot.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.system.springboot.backend.entity.Role;
import com.system.springboot.backend.entity.UserDetail;
import com.system.springboot.backend.exception.InternalServerErrorException;
import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.repository.RoleRepository;
import com.system.springboot.backend.repository.UserDetailRepository;
import com.system.springboot.backend.validator.Validator;
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
	private final UserDetailRepository userDetailRepository;
	private final RoleRepository roleRepository;

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

	/**
	 *
	 * @param id
	 * @return
	 */
	public User findUserById(Long id){
		return userRepository.findById(id).orElseThrow(()->new NotFoundException("the user does not exist",new Exception()));
	}

	/**
	 *
	 * @param telephone
	 * @return
	 */
	public User findUserByTelephone(String telephone){
		return Optional.ofNullable(userRepository.findUserByTelephone(telephone))
				.orElseThrow(()->new NotFoundException("the user does not exist",new Exception()));
	}

	/**
	 *
	 * @param name
	 * @param surname
	 * @return
	 */
	public List<User> findUsersByNameAndSurnameContaining(String name, String surname){
		List<User> listUsers = new ArrayList<>();

		Optional.of(userRepository.findUsersByNameContainingOrSurnameContaining(name,surname))
				.orElseThrow(()->new NotFoundException("empty list",new Exception("")))
				.forEach(listUsers::add);

		return listUsers;
	}

	/**
	 *
	 * @param user valid email format, length of name between 0 and 50 characters and name, email not null
	 * @return object type user with attributes in json
	 */
	public User saveUser(User user){
		return Optional.of(userRepository.save(user))
				.orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
	}

	/**
	 *
	 * @param id
	 */
	public void deleteUser(Long id){
		User user=findUserById(id);
		 userRepository.delete(user);
	}

	/**
	 * all the users exists
	 * @return list of user or list empty
	 */
	public List<UserDetail> findAllUsersDetail(){
		List<UserDetail> listUsersDetail = new ArrayList<>();

		Optional.ofNullable(userDetailRepository.findAll())
				.orElseThrow(()->new NotFoundException("empty list",new Exception("")))
				.forEach(listUsersDetail::add);

		return listUsersDetail;
	}

	/**
	 *
	 * @param id
	 * @return
	 */
	public UserDetail findUserDetailById(Long id){
		return userDetailRepository.findById(id).orElseThrow(()->new NotFoundException("the userDetail does not exist",new Exception()));
	}

	/**
	 *
	 * @param userDetail
	 * @return object type userDetail with attributes in json
	 */
	public UserDetail saveUserDetail(UserDetail userDetail){
		return Optional.of(userDetailRepository.save(userDetail))
				.orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
	}

	public void deleteUserDetail(Long id){
		UserDetail userDetail=findUserDetailById(id);
		userDetailRepository.delete(userDetail);
	}


	/**
 	* method role
 	*/
	/**
	 *
	 * @return
	 */
	public List<Role> findAllRoles(){
		List<Role> listRoles = new ArrayList<>();

		Optional.ofNullable(roleRepository.findAll())
				.orElseThrow(()->new NotFoundException("empty list",new Exception("")))
				.forEach(listRoles::add);

		return listRoles;
	}

}
