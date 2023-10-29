package com.neobank.spacemoney.orders;

public class Test {

	public static void main(String[] args) {
		Order orderTierra = new OrderTierra();
		orderTierra.setPrecioBruto(100);
		orderTierra.calculaPrecioNeto();
		
		orderTierra.calculaIVA();
		
		System.out.println(orderTierra);
		
		System.out.println("=============");
		
		Order orderJupiter = new OrderJupiter();
		orderJupiter.setPrecioBruto(100);
		orderJupiter.calculaPrecioNeto();
		
		System.out.println(orderJupiter);
		
		System.out.println("=============");
		
		Order orderSaturno = new OrderSaturno();
		orderSaturno.setPrecioBruto(100);
		orderSaturno.calculaPrecioNeto();
		
		System.out.println(orderSaturno);
		
		
	}
}
