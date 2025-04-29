package com.aits.PrepaidRechargeProject.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*import java.util.Date;

import jakarta.persistence.*;

@Entity
public class RechargeHistory {
	@Id
	private int id;
	private String plan;
	private Date date;
	private String paymentmode;
	private int user;
	private Long mobileNum;
	public RechargeHistory() {
		
	}
	public RechargeHistory(int id, String plan, Date date, String paymentmode, int user, Long mobileNum) {
		super();
		this.id = id;
		this.plan = plan;
		this.date = date;
		this.paymentmode = paymentmode;
		this.user = user;
		this.mobileNum = mobileNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public Long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}
	

}*/

/*@Data
@NoArgsConstructor
@AllArgsConstructor */

@Entity
public class RechargeHistory{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	@ManyToOne
	private RechargePlan plan;
	
	private String paymentMethod;
	private LocalDateTime rechargeDate;
	public RechargeHistory(){
		
	}
	public RechargeHistory(Long id, User user, RechargePlan plan, String paymentMethod, LocalDateTime rechargeDate) {
		super();
		this.id = id;
		this.user = user;
		this.plan = plan;
		this.paymentMethod = paymentMethod;
		this.rechargeDate = rechargeDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public RechargePlan getPlan() {
		return plan;
	}
	public void setPlan(RechargePlan plan) {
		this.plan = plan;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public LocalDateTime getRechargeDate() {
		return rechargeDate;
	}
	public void setRechargeDate(LocalDateTime rechargeDate) {
		this.rechargeDate = rechargeDate;
	}
	
	
	
}
