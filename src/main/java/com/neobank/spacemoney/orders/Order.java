package com.neobank.spacemoney.orders;

import com.neobank.spacemoney.model.OrderResponse;

public abstract class Order {
	
	protected float precioBruto;
	protected float iva;
	protected float precioNeto;
	
	protected abstract void calculaIVA();
	
	public void calculaPrecioNeto() {
		this.calculaIVA();
		precioNeto = precioBruto + iva;
	}
	
	
	public void setPrecioBruto(float precioBruto) {
		this.precioBruto = precioBruto;
	}
	
	
	
	
	
	
	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getPrecioNeto() {
		return precioNeto;
	}

	public void setPrecioNeto(float precioNeto) {
		this.precioNeto = precioNeto;
	}

	public float getPrecioBruto() {
		return precioBruto;
	}
	
	
	public OrderResponse getResponse() {
		OrderResponse response = new OrderResponse();
		response.precioBruto = this.precioBruto;
		response.iva = this.iva;
		response.precioNeto = this.precioNeto;
		return response;		
	}
	

	@Override
	public String toString() {
		return "Precio Bruto: " + precioBruto 
				+ " Precio Neto: " + precioNeto
				+ " IVA: " + iva;
	}
	
	
	

}
