package com.neobank.spacemoney.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;

	public String planeta;

	public String pais;

	public String estado;

	public String municipio;
	
	public String localidad;

	public String codigoPostal;
	
	public String calle;

	public String numero;

	
	/*
	@OneToOne
	@JoinColumn(name = "user_direccion", nullable = false)
	public User user;
	*/

}
