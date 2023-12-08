package com.neobank.spacemoney.orders;

public class OrderSaturno extends Order {

	@Override
	protected void calcularIVA() {
		iva = precioBruto * Iva.SATURNO;
	}
	
	

}
