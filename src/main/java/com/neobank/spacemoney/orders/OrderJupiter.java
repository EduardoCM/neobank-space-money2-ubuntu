package com.neobank.spacemoney.orders;

import com.neobank.spacemoney.model.Planeta;

public class OrderJupiter extends Order {
	
	public OrderJupiter(float precioBruto) {
		this.planeta = Planeta.JUPITER;
		this.precioBruto =precioBruto;
		this.calculaPrecioNeto();
	}

	@Override
	protected void calcularIVA() {
		iva = precioBruto * Iva.JUPITER;
	}
	

}
