package com.aits.PrepaidRechargeProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aits.PrepaidRechargeProject.entity.RechargePlan;
import com.aits.PrepaidRechargeProject.entity.User;
import com.aits.PrepaidRechargeProject.repo.UserRepository;
import com.aits.PrepaidRechargeProject.service.RechargePlanService;
import com.aits.PrepaidRechargeProject.service.RechargeService;
import com.aits.PrepaidRechargeProject.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
 
	@Autowired
	private UserService userservice;
	
	@Autowired
	private RechargePlanService rechargeplanservice;
	
	@Autowired 
	private RechargeService rechargeservice; 
	
	@Autowired
	private UserRepository userrepository;
	
	/* @PostMapping("/users")
	public User insert(@RequestBody User user) {
		
		return userservice.insert(user);
	} 
	@GetMapping("/users")
	public List<User> fetchAllUsers(){
		return userservice.fetchAllUsers();
	} */
	
    //@GetMapping("/mobile_validation/{mobile}")
	@GetMapping("/api/auth/login/{mobile}")
    public Long validatenumber(@PathVariable String mobile) {
    	boolean numberis=userservice.validatenumber(mobile);
    	Optional<User> user=userrepository.findByMobile(mobile);
    	if(numberis==true) {
    		return user.get().getId();
    	}
    	else {
    		return -1L;
    	}
    	
    }    // to validate mobile number
    
    @GetMapping("/available_plans")
    public List<RechargePlan> getAllPlans() {
        return rechargeplanservice.getAllPlans();
    }  //to get all the plans
 
    @GetMapping("available_plans/{category}")
    public List<RechargePlan> getByCategory(@PathVariable String category) {
        return rechargeplanservice.getPlansByCategory(category);
    }  // to get the plans by category
    
     @PostMapping("/makerecharge")
    public String recharge(
            @RequestParam Long userId,
            @RequestParam Integer planId,
            @RequestParam String paymentMethod) {
        return rechargeservice.recharge(userId, planId, paymentMethod);
    }  // make the dummy recharge
    
}

 
 
