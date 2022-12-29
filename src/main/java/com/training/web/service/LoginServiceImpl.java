package com.training.web.service;

import java.util.List;

import com.training.web.dao.LoginDao;
import com.training.web.dao.LoginDaoImpl;
import com.training.web.model.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean isValidUser(String username, String password) {
		LoginDao dao = new LoginDaoImpl();
		boolean isValid = false;
		List<User> userList = dao.getUsers();
		for (User user : userList) {
			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
				isValid = true;
			}
		}
		return isValid;
	}
}
