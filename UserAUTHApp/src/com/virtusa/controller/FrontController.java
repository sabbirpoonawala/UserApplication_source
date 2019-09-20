package com.virtusa.controller;

import com.virtusa.exception.UserException;
import com.virtusa.helper.UserFactory;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;
import com.virtusa.view.AdminView;
import com.virtusa.view.ErrorView;
import com.virtusa.view.StudentView;

public class FrontController {
	
	private UserService userService;
	public FrontController() {
		this.userService=UserFactory.createUserService();
		
	}
	
	public void userAuthentication(String userName,String password) {
		
		UserModel userModel=new UserModel();
		userModel.setUserName(userName);
		userModel.setPassword(password);
		try {
		String userType=
				userService.userAuthenticationService(userModel);
		
		if(userType.contentEquals("STUDENT")) {
			StudentView studentView=new StudentView();
			studentView.mainStudentView();
		}else if(userType.contentEquals("ADMIN")) {
			AdminView adminView=new AdminView();
			adminView.mainAdminView();
		}else {
			ErrorView errorView=new ErrorView();
			errorView.authenticationError();
		}
		
		}catch(UserException e) {
			System.out.println("User Authentication failed.");
			
		}
		
	}

}
