package com.aits.PrepaidRechargeProject.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/

import com.aits.PrepaidRechargeProject.entity.User;

/*public interface UserRepository extends JpaRepository<User,Integer> {
	@Query("select u from User u where u.expirydate BETWEEN :startDate AND :endDate")
	List <User> findUsersWithExpiringPlans(@Param("startDate") Date startDate,@Param("endDate") Date endDate);

}*/
public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findByMobile(String mobile);
	
	Optional<User>  findByEmail(String email);
	
}
