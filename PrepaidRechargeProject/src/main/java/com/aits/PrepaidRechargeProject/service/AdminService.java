package com.aits.PrepaidRechargeProject.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.PrepaidRechargeProject.repo.RechargeHistoryRepository;
import com.aits.PrepaidRechargeProject.repo.UserRepository;
import com.aits.PrepaidRechargeProject.entity.RechargeHistory;
import com.aits.PrepaidRechargeProject.entity.User;
import java.util.*;

@Service
public class AdminService {
	
	@Autowired
	RechargeHistoryRepository rechargehistoryrepository;
	
	@Autowired
	UserRepository userrepository;

	public List<User> getAllUsersExpiring() {

		
		//GetAll the UserDetails.
		    
		 List<User> users= userrepository.findAll();
		 
		 List<User> usersExpiring=new ArrayList<>();
		 
		 //filter the details of the users whose recharge is expiring in the next 3 days
		 
		
		 for(User u:users) {
			 
			 List<RechargeHistory> recharges= rechargehistoryrepository.findByUserId(u.getId());
				 
			//u1->recharges 
			 //recharges->[29/03/2023,29/06/2023,.......29/02/2025]
				
			 if(!recharges.isEmpty()) {
				 
				 //get the last rechargedateObject from the list of recharges
				 
			 RechargeHistory thatmightexpire=recharges.get(recharges.size()-1);
			 
			 LocalDateTime paymentdate=thatmightexpire.getRechargeDate();
			 
			 LocalDateTime expirydate=paymentdate.plusDays(thatmightexpire.getPlan().getValidityInDays());
			 
		  //I got the expirydate of the rechargehistory
			 	
			//I have to check whether the expiry date is within the range of today and next 3 days
			 
			 	
			 	LocalDateTime todaysdate=LocalDateTime.now();
			 
			 	if( !expirydate.isBefore(todaysdate) && expirydate.isBefore(todaysdate.plusDays(4))) {
			 		
			 		usersExpiring.add(u);	
			 	}	 
			 
		 }
		 }
		 
		 // in this code what is happening means , so first in the users table it takes all  users, 
		 //for each user the rechargeplanhistory is taken from the history the last recharge is taken(because all the other recharges are expired)
		 //it checks all the last recharges and find which recharges are going to be expiry in three days and stores the users in userexipiring list
			 
	    return usersExpiring;       
		
	}

	public Optional<User> getUserDetails(Long id) {
	    return  userrepository.findById(id);

	}

	
	
	
}

 
 