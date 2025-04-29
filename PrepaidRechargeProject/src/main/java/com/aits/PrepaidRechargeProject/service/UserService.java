package com.aits.PrepaidRechargeProject.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.PrepaidRechargeProject.entity.RechargeHistory;
import com.aits.PrepaidRechargeProject.entity.User;
import com.aits.PrepaidRechargeProject.repo.RechargeHistoryRepository;
import com.aits.PrepaidRechargeProject.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	RechargeHistoryRepository rechargehistoryrepository;
	
	/*public User insert(User user) {
		return userrepository.save(user);
	}

	public List<User> fetchAllUsers(){
		List<User> users=userrepository.findAll();
		return users;
	}
 */ 
	public boolean validatenumber(String mobileno) {
        boolean activenumber=false;
		if(mobileno.matches("[6-9]\\d{9}")){ // this says that mobile no starts with 6/7//8/9 and the next 9 digits are in range from 0-10
		  activenumber=isactivenumber(mobileno);
		}
		 if(activenumber==true) {
			  activenumber=true;
		  }
		return activenumber;
	}
	
	
	public boolean isactivenumber(String mobileno) {
		Optional<User> user=userrepository.findByMobile(mobileno);
		boolean flag=false;
		if(user.isEmpty()) {
			flag=false;
		}
		long daysdifference=0;
		List<RechargeHistory> recharges=rechargehistoryrepository.findByUserId(user.get().getId());
		if(!recharges.isEmpty()) {
			RechargeHistory recentrecharge=recharges.get(recharges.size()-1);	
			LocalDateTime paymentdate=recentrecharge.getRechargeDate();
		    LocalDateTime expirydate=paymentdate.plusDays(recentrecharge.getPlan().getValidityInDays());
		    
		    LocalDateTime todaysdate=LocalDateTime.now();
		    daysdifference=ChronoUnit.DAYS.between(expirydate, todaysdate);
		}
		  if(daysdifference>=90) {
		    	flag=false;   //says that the number is inactive
		    	System.out.println("mobile number is deactivated");
		    	Long id=user.get().getId();        // if the number is deactivated ,it is removed from the database
		    	userrepository.deleteById(id);
		    	
		    }
		    else {
		  flag=true;  //says that the number is active 
	 
		    }
		  return flag;
	}
}
