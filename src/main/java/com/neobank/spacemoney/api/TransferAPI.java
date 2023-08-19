package com.neobank.spacemoney.api;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.neobank.spacemoney.model.Transfer;


@Transactional
@Path("/api/transfer")
public class TransferAPI {
	
	
	@POST
	public Response transferAPI(Transfer transfer) {
		
		String respuesta = "";
		Status status = Status.CREATED;
		
		switch(transfer.destinationBank) {
		
		case "SpaceMoney":			
			respuesta += "Transferencia exitosa al banco " + transfer.destinationBank;
			transfer.persist();
			
			break;
		case "Banco Azteca":
			respuesta += "Transferencia exitosa al banco " + transfer.destinationBank;
			transfer.persist();
			break;
		case "Bancolombia":
			respuesta += "Transferencia exitosa al banco " + transfer.destinationBank;
			transfer.persist();
			break;
		case "Banco de Credito del Peru":
			respuesta += "Transferencia exitosa al banco " + transfer.destinationBank;
			transfer.persist();
			break;
		case "Banco do Brasil":
			respuesta += "Transferencia exitosa al banco " + transfer.destinationBank;
			transfer.persist();
			break;
		
			default:
				respuesta += "Aun no contamos con transferencias para el banco " + transfer.destinationBank;
				status = Status.NOT_ACCEPTABLE;
				transfer.persist();
		}
		
		return Response.status(status).entity(respuesta).build();
	}

}
