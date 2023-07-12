package com.watches.loginRegisterApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watches.loginRegisterApi.model.Users;
import com.watches.loginRegisterApi.repository.LoginDao;



@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	
	/**
	 * method to obtain the list of all the users present in the database
	 * @return
	 */
	public List<Users> getAllEntities(){
		return loginDao.findAll();
	}
	
	
	/**
	 * method to verify entered credentials
	 * @param username
	 * @param password
	 * @return
	 */
	public String authenticate(String username, String password) {
		List<Users> users = getAllEntities();
		for(Users usr : users) {
			if(username.equals(usr.getEmail()) && password.equals(usr.getPassword())) {
				if(usr.getAdmin())
				return "admin" ;
				else return  "user";
			}
		}
		return "invalid";
	}
	
	
	/**
	 * method to save new user information in the database
	 * @param user
	 * @return
	 */
	public String saveEntity(Users user) {
		loginDao.save(user);
		return "added";
	}
	
}
