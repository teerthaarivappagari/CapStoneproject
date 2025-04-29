package com.aits.PrepaidRechargeProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.PrepaidRechargeProject.entity.RechargePlan;

public interface RechargePlanRepository extends JpaRepository<RechargePlan, Integer> {
    List<RechargePlan> findByCategory(String category);
}
