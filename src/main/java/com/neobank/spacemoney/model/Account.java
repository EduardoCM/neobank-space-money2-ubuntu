package com.neobank.spacemoney.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "Accounts")
public class Account extends PanacheEntityBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	public String number;
	
	public Double balance;

	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
	}
	
	

}
