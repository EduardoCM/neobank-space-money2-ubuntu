package com.neobank.spacemoney.orders;

public class OrderSaturno extends Order {

	@Override
	protected void calculaIVA() {
		iva = precioBruto * Iva.SATURNO;	
	}
	
	

}
