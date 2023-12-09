package com.neobank.spacemoney.api;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.neobank.spacemoney.model.OrderRequest;
import com.neobank.spacemoney.model.OrderResponse;
import com.neobank.spacemoney.orders.Order;
import com.neobank.spacemoney.orders.OrderGaia;
import com.neobank.spacemoney.orders.OrderJupiter;
import com.neobank.spacemoney.orders.OrderSaturno;


@Transactional
@Path("/api/orders")
public class OrderAPI {

	@Inject
	private Logger log;

	@POST
	public Response createOrder(OrderRequest order) {

		log.info("Order: " + order);

		Order newOrder = null;
		
		
		switch(order.planeta) {
		
		case "gaia":
			newOrder = new OrderGaia();
			newOrder.setPrecioBruto(order.precio);
			newOrder.calculaPrecioNeto();
			
			break;
			
		case "jupiter":
			newOrder = new OrderJupiter();
			newOrder.setPrecioBruto(order.precio);
			newOrder.calculaPrecioNeto();
			
			break;
			
		case "saturno":
			newOrder = new OrderSaturno();
			newOrder.setPrecioBruto(order.precio);
			newOrder.calculaPrecioNeto();
			
			break;
			
		default:
			return Response.status(Status.NOT_ACCEPTABLE).entity("Aun no contamos con servicios para el planeta: " + order.planeta).build();
		}
		
		
		log.info("Guardando información");
		OrderResponse response = newOrder.getResponse();
		response.persist();
		

		return Response.status(Status.ACCEPTED).entity(response).build();

	}

}
