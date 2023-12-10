package com.neobank.spacemoney.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "Transactions")
public class Transactions extends PanacheEntityBase  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	public String numberAccount;
	
	@Enumerated(EnumType.STRING)
	public Operation operation;
	
	public Double amount;
	
	
}
