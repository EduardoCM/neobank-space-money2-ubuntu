package com.neobank.spacemoney.orders;

public class OrderJupiter extends Order {

	@Override
	protected void calcularIVA() {
		iva = precioBruto * Iva.JUPITER;
	}
	

}
