package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserService {

	User findById(int id);

	User findByEmail(String email);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserByEmail(String email); // o por ID??

	List<User> listAllUsers();

	Boolean isUserEmailUnique(Integer id, String email);

}
