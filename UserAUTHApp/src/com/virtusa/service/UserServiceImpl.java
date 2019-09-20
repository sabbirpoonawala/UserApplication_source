package com.virtusa.service;

import com.virtusa.dao.UserDAO;
import com.virtusa.exception.UserException;
import com.virtusa.helper.UserFactory;
import com.virtusa.model.UserModel;

public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO=null;
	
	public UserServiceImpl() {
		this.userDAO=UserFactory.createUserDAO();
	}
	
	@Override
	public String userAuthenticationService(UserModel userModel) {
		// TODO Auto-generated method stub
		boolean userValid=
				userDAO.userAuth(userModel.getUserName(), userModel.getPassword());
		String userType=null;
		if(userValid) {
			userType=userDAO.retrieveUserType(userModel.getUserName());	
		}
		else {
			throw new UserException("Invalid username or password");
		}

		return userType;
	}

}
