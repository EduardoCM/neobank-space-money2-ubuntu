package com.neobank.spacemoney.orders;

public class OrderGaia extends Order {

	@Override
	protected void calcularIVA() {
		
		iva = precioBruto * Iva.GAIA;
		
	}
	
	
	

}
