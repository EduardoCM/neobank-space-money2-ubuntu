package com.neobank.spacemoney.orders;

import com.neobank.spacemoney.model.Planeta;

public class OrderGaia extends Order {
	
	public OrderGaia(float precioBruto) {
	  this.planeta = Planeta.GAIA;
	  this.precioBruto = precioBruto;
	  this.calculaPrecioNeto();
	}
	

	@Override
	protected void calcularIVA() {
		
		iva = precioBruto * Iva.GAIA;
		
	}
	
	
	

}
