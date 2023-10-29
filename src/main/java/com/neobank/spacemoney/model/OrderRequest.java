package com.neobank.spacemoney.model;

public class OrderRequest {

	public String producto;

	public float precio;

	public String planeta;

	@Override
	public String toString() {
		return "OrderRequest [producto=" + producto + ", precio=" + precio + ", planeta=" + planeta + "]";
	}

	
	
}
