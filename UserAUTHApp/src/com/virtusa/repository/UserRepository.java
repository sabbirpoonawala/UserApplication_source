package com.virtusa.repository;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Admin;
import com.virtusa.entities.Student;
import com.virtusa.entities.User;
import com.virtusa.utilties.UserTypes;

public class UserRepository {
	private static List<User> userRepository=
			new ArrayList<User>();
	static{
		
		Student student=new Student();
		student.setUserName("sabbirpoonawala");
		student.setPassword("sabbir@123");
		student.setFirstName("sabbir");
		student.setLastName("poonawala");
		student.setEmailAddress("sabbirpoonawala@hotmail.com");
		student.setPhoneNumber("9892937467");
		student.setDateOfBirth("01-10-1977");
		student.setStudentId("S001");
		student.setUserType(UserTypes.STUDENT);
		userRepository.add(student);
		
		Admin admin=new Admin();
		admin.setUserName("admin");
		admin.setPassword("admin");
		admin.setFirstName("Ritesh");
		admin.setLastName("Desai");
		admin.setEmailAddress("admin@virtusa.com");
		admin.setPhoneNumber("7741973507");
		admin.setDateOfBirth("01-10-1986");
		admin.setAdminId("A001");
		admin.setUserType(UserTypes.ADMIN);
		userRepository.add(admin);	
	}
	public static List<User> getUserRepository() {
		return userRepository;
	}
}
