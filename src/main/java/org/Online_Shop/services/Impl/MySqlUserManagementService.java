package org.Online_Shop.services.Impl;


import org.Online_Shop.dao.UserDao;
import org.Online_Shop.dao.impl.MySqlJdbcUserDao;
import org.Online_Shop.dto.UserDto;
import org.Online_Shop.dto.converter.UserDtoToUserConverter;
import org.Online_Shop.enteties.User;
import org.Online_Shop.services.UserManagementService;
import org.Online_Shop.utils.mail.MailSender;
import org.Online_Shop.utils.mail.impl.DefaultMailSender;

import java.util.List;

public class MySqlUserManagementService implements UserManagementService {

	public static final String SUCCESSFULL_REGISTRATION_MESSAGE = "User is registered!";
	private static final String REGISTRATION_ERROR_MESSAGE = "The email is already in use by other user.";
	
	private UserDao userDao;
	private UserDtoToUserConverter userConverter;
	
	private MailSender mailSender;

	{
		userDao = new MySqlJdbcUserDao();
		userConverter = new UserDtoToUserConverter();
		mailSender = DefaultMailSender.getInstance();
	}
	
	@Override
	public String registerUser(User user) {
		boolean isCreated = userDao.saveUser(userConverter.convertUserToUserDto(user));
		
		if (isCreated) {
			return SUCCESSFULL_REGISTRATION_MESSAGE;
		} else {
			return REGISTRATION_ERROR_MESSAGE;
		}
	}

	@Override
	public List<User> getUsers() {
		List<UserDto> userDtos = userDao.getUsers();
		return userConverter.convertUserDtosToUsers(userDtos);
	}

	@Override
	public User getUserByEmail(String userEmail) {
		UserDto userDto = userDao.getUserByEmail(userEmail);
		return userConverter.convertUserDtoToUser(userDto);
	}

	@Override
	public void resetPasswordForUser(User user) {
		mailSender.sendEmail(user.getEmail(), "Please, use this password to login: " + user.getPassword());
	}

}
