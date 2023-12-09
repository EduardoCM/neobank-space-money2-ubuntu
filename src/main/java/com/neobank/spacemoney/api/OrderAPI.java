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
import com.neobank.spacemoney.service.OrderService;
import com.neobank.spacemoney.service.impl.OrderServiceImpl;


@Transactional
@Path("/api/orders")
public class OrderAPI {

	@Inject
	private Logger log;
	
	private OrderService service = new OrderServiceImpl();

	@POST
	public Response createOrder(OrderRequest order) {

		log.info("Order: " + order);

		Order newOrder = null;
		
		switch(order.planeta) {
		
		case "gaia" -> newOrder = new OrderGaia(order.precio);
		
		case "jupiter" -> newOrder = new OrderJupiter(order.precio);
			
		case "saturno" -> newOrder = new OrderSaturno(order.precio);
							
		}
		
		if(newOrder == null) {
			return Response.status(Status.NOT_ACCEPTABLE).entity("Aun no contamos con servicios para el planeta: " + order.planeta).build();
		}
		
		
		log.info("Guardando información");
		
		service.saveOrder(newOrder);

		return Response.status(Status.ACCEPTED).build();

	}

}
