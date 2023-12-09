package com.neobank.spacemoney.orders;

import com.neobank.spacemoney.model.Planeta;

public class OrderGaia extends Order {
	
	public OrderGaia(float precioBruto) {
		this.precioBruto = precioBruto;
		this.planeta = Planeta.GAIA;
		this.calculaPrecioNeto();
	}

	@Override
	protected void calcularIVA() {
		iva = precioBruto * Iva.GAIA;
	}
	
	
	

}
