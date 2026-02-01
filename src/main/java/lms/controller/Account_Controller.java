package lms.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;

import lms.dao.Account_Service;
import lms.service.Account;

@RestController
@RequestMapping("/LMS/account")
public class Account_Controller {
	
	@Autowired
	private Account_Service dao;
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody Account user) {
		dao.createAccount(user.getUsername(), user.getPassword());
		return "Created account!";
	}
	
	@DeleteMapping("/deleting")
	public String deleteAccount(@RequestBody Account user) {
		dao.deleteAccount(user.getUsername());
		return "Deleted account!";
	}
	
	@PutMapping("/update")
	public String updateAccount(@RequestBody Account user) {
		dao.updateAccount(user.getId(), user.getUsername(), user.getPassword());
		return "try";
	}
	// for checking ng books or account details something ganon
	@GetMapping("/my account")
	public  void test2() {}
}
