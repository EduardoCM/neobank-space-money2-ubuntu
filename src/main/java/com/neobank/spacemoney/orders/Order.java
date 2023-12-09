package com.neobank.spacemoney.orders;

import com.neobank.spacemoney.model.OrderResponse;
import com.neobank.spacemoney.model.Planeta;

public abstract class Order {

	public Planeta planeta;
	
    protected float precioBruto;
    protected float iva;
    protected float precioNeto;
    
	
	protected abstract void calcularIVA();
	
	public void calculaPrecioNeto() {
		this.calcularIVA();
		precioNeto = precioBruto + iva;
	}
	
	public void setPrecioBruto(float precioBruto) {
		this.precioBruto = precioBruto;
	}
	
	
	public OrderResponse getResponse() {
		OrderResponse response = new OrderResponse();
		response.precioBruto = this.precioBruto;
		response.iva = this.iva;
		response.precioNeto = this.precioNeto;
		response.planeta = this.planeta.toString();
		return response;
	}

}
