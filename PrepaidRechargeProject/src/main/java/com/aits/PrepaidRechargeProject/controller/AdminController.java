package com.aits.PrepaidRechargeProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aits.PrepaidRechargeProject.entity.RechargeHistory;
import com.aits.PrepaidRechargeProject.entity.User;
import com.aits.PrepaidRechargeProject.repo.UserRepository;
import com.aits.PrepaidRechargeProject.service.AdminService;
import com.aits.PrepaidRechargeProject.service.RechargeService;

@RestController
public class AdminController {

	
	@Autowired
	AdminService adminservice;
	
	@Autowired 
	RechargeService rechargeservice;
	
	@Autowired 
	UserRepository userrepository;
	
	
	@GetMapping("/admin/usersexpiring")
	public List<User> getAllUsersExpiring(){
		return adminservice.getAllUsersExpiring();
	}
	
	//the above method gives the list of users whose recharge is going to expire in next three days.
	@GetMapping("admin/allusers")
	public List<User> getallusers(){
		return userrepository.findAll();
	}
	
	 @GetMapping("admin/recharge_history/{userId}")
	    public List<RechargeHistory> getHistory(@PathVariable Long userId) {
	        return rechargeservice.getUserHistory(userId);
	    }
	
	//the above methods returns the recharge history of the selected subscriber  
	
}
 

