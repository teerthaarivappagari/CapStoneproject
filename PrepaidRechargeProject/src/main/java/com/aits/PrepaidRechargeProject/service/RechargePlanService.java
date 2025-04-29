package com.aits.PrepaidRechargeProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.PrepaidRechargeProject.entity.RechargePlan;
import com.aits.PrepaidRechargeProject.repo.RechargePlanRepository;

@Service
public class RechargePlanService {
	
	@Autowired
	RechargePlanRepository repository;
	
	public List<RechargePlan> getAllPlans(){
		return repository.findAll();		
	}
	public List<RechargePlan> getPlansByCategory(String category){
		return repository.findByCategory(category);
	}
	public RechargePlan insert(RechargePlan rechargeplan) {
		return repository.save(rechargeplan);
	}
}
