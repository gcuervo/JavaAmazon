package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserDao {

	User findById(int id);

	User findUserByEmail(String email);

	void saveUser(User user);

	void deleteUserByEmail(String email); // o por ID??

	List<User> findAllUsers();
}
