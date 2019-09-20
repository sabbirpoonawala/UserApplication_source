package com.virtusa.dao;

import java.util.List;

import com.virtusa.entities.User;
import com.virtusa.repository.UserRepository;
import com.virtusa.utilties.UserTypes;

public class UserDAOImpl implements UserDAO {
	private List<User> userList=null;
	
	public UserDAOImpl() {
		
		this.userList=UserRepository.getUserRepository();
	}

	@Override
	public boolean userAuth(String userName, String password) {
		// TODO Auto-generated method stub
		boolean result=false;
		for(User user:userList) {	
			if(user.getUserName().equals(userName)) {
				
				if(user.getPassword().equals(password)) {
					result= true;
										
				}
			}
		}
		
		return result;
	}

	@Override
	public String retrieveUserType(String userName) {
		// TODO Auto-generated method stub
		
		String returnUserType=null;
		for(User user:userList) {
			if(user.getUserName().equals(userName)){
			UserTypes userTypes=user.getUserType();
			
			switch(userTypes) {
			
			case STUDENT:
				returnUserType="STUDENT";
				break;
				
			case ADMIN:
				returnUserType="ADMIN";
				break;
			
			}
			
		}
		}
		return returnUserType;
	}

}
