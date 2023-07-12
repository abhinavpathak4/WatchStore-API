//package com.watches.loginRegisterApi.controller;
//
//import org.springframework.web.bind.annotation.RestController;
//
//import com.watches.loginRegisterApi.model.Response;
//import com.watches.loginRegisterApi.model.Users;
//import com.watches.loginRegisterApi.service.LoginService;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@RestController
//@CrossOrigin
//public class Controller {
//	@Autowired
//	LoginService loginService;
//	
//	
//	@GetMapping("/getAll")
//	public List<Users> getAllUsers() {
//		return this.loginService.getAllEntities() ;
//	}
//	
//	@PostMapping("/auth")
//	public Response authenticate(@RequestBody Users user) {
//		String res =  loginService.authenticate(user.getEmail(), user.getPassword());
//		return  new Response(res);
//	}
//	
//	@PostMapping("/register")
//	public Response register(@RequestBody Users user) {
////		Users user = new Users(email, firstName, password);
//		String res = this.loginService.saveEntity(user);
//		return new Response(res);
//	}
//}





package com.watches.loginRegisterApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.watches.loginRegisterApi.model.Users;
import com.watches.loginRegisterApi.service.LoginService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class Controller {
	@Autowired
	LoginService loginService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = loginService.getAllEntities();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<String> authenticate(@RequestBody Users user) {
		String res = loginService.authenticate(user.getEmail(), user.getPassword());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Users user) {
		String res = loginService.saveEntity(user);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
