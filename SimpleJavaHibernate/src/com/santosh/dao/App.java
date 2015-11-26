package com.santosh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.santosh.model.User;

public class App {

	public static void main(String[] args) {
		UserDao dao = new UserDao();

		// Add new user
		User user = new User();
		user.setFirstName("test");
		user.setLastName("test1");
		try {
			Date dob = (Date) new SimpleDateFormat("yyyy-MM-dd")
					.parse("1986-01-02");
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail("test@test1.com");
		dao.addUser(user);
		//
		// // Update user
		user.setEmail("test@test.com");
		user.setUserid(1);
		dao.updateUser(user);

		// Delete user
		// dao.deleteUser(2);

		// Get all users
		for (User iter : dao.getAllUsers()) {
			System.out.println(iter);
		}

		// Get user by id
		System.out.println(dao.getUserById(1));

	}

}
