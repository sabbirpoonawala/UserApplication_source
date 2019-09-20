package com.virtusa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.virtusa.exception.UserException;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserServiceImpl;

class TestUserServiceImpl {
	

	
	@Test
	void testUserAuthenticationService_positive() {
		 UserServiceImpl userServiceImpl=new UserServiceImpl();
		try {
		UserModel userModel=new UserModel();
		userModel.setUserName("sabbirpoonawala");
		userModel.setPassword("sabbir@123");
		String actual=userServiceImpl.userAuthenticationService(userModel);
		String expected="STUDENT";
		assertEquals(expected,actual);
		}catch(UserException e) {
			assertTrue(false);
		}
	}
	
	@Test
	void testUserAuthenticationService_negative() {
		 UserServiceImpl userServiceImpl=new UserServiceImpl();
		try {
		UserModel userModel=new UserModel();
		userModel.setUserName("sabbirpoonawaladfdfdf");
		userModel.setPassword("sabbir@123");
		String actual=userServiceImpl.userAuthenticationService(userModel);
		String expected="STUDENT";
		assertTrue(false);
		}catch(UserException e) {
			assertTrue(true);
		}
	}

}
