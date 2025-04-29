package com.aits.PrepaidRechargeProject.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
/*import java.util.*;

import jakarta.persistence.*;

@Entity
public class User {
	@Id
	private int id;
	private String username;
	private String plan;
	private Date expirydate;
   
	public User(){
		
	}

	public User(int id, String username, String plan, Date expirydate) {
		super();
		this.id = id;
		this.username = username;
		this.plan = plan;
		this.expirydate = expirydate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Date getexpiryDate() {
		return expirydate;
	}

	public void setexpiryDate(Date expirydate) {
		this.expirydate = expirydate;
	}
	
}  */

  /*@Data
  @NoArgsConstructor
  @AllArgsConstructor */
  @Entity
  public class User{
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private Long id;
	  private String name;
	  private String mobile;
	  private String email;
	  private String password;
	  
	  @Enumerated(EnumType.STRING)
	  private Role role;
	  
	  @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	  private List<RechargeHistory> history;  //here recharge history owing relationship not user
	  
	  public User() {
		  
	  }

	public User(Long id, String name, String mobile, String email, String password, Role role,
			List<RechargeHistory> history) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.role = role;
		this.history = history;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<RechargeHistory> getHistory() {
		return history;
	}

	public void setHistory(List<RechargeHistory> history) {
		this.history = history;
	}
	  
  }
