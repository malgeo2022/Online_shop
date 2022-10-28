package org.Online_Shop.dao;

import org.Online_Shop.dto.UserDto;

import java.util.List;

public interface UserDao {
	
	boolean saveUser(UserDto user);
	
	List<UserDto> getUsers();

	UserDto getUserByEmail(String userEmail);

	UserDto getUserById(int id);

}
