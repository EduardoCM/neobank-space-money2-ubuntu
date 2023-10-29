package com.neobank.spacemoney.orders;

public class OrderJupiter extends Order {

	@Override
	protected void calculaIVA() {
		iva = precioBruto * Iva.JUPITER;	
	}

}
