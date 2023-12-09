package com.neobank.spacemoney.orders;

import com.neobank.spacemoney.model.Planeta;

public class OrderSaturno extends Order {
	
	public OrderSaturno(float precioBruto) {
		this.planeta = Planeta.SATURNO;
		this.precioBruto = precioBruto;
		this.calculaPrecioNeto();
		
	}

	@Override
	protected void calcularIVA() {
		iva = precioBruto * Iva.SATURNO;
	}
	
	

}
