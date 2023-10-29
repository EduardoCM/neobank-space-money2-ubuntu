package com.neobank.spacemoney.orders;

public class OrderTierra extends Order {

	@Override
	protected void calculaIVA() {
		iva = precioBruto * Iva.TIERRA;	
	}
	
	

}
