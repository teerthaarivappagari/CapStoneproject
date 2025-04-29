package com.aits.PrepaidRechargeProject.controller;


 
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aits.PrepaidRechargeProject.entity.RechargePlan;
import com.aits.PrepaidRechargeProject.service.RechargePlanService;
 
@RestController
@RequestMapping("/plans")
public class RechargePlanController {
 
    RechargePlanService service;
 
    public RechargePlanController(RechargePlanService service) {
        this.service = service;
    }
 
  /*  @GetMapping
    public List<RechargePlan> getAllPlans() {
        return service.getAllPlans();
    }
 
    @GetMapping("/{category}")
    public List<RechargePlan> getByCategory(@PathVariable String category) {
        return service.getPlansByCategory(category);
    } */
    
    @PostMapping
    public RechargePlan insert(@RequestBody RechargePlan rechargeplan) {
    	return service.insert(rechargeplan);
    	
    	
    }
}
 
 