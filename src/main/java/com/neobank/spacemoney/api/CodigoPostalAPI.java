package com.neobank.spacemoney.api;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import com.neobank.spacemoney.model.CodigoPostal;

@Path("/api/codigopostal")
public class CodigoPostalAPI {
	
	@Inject
	private Logger log;
	
	
	@GET
	@Path("/{codigopostal}")
	public Response getCodigoPostal(@PathParam(value = "codigopostal") String codigopostal) {
		List<CodigoPostal> codigosInfo = new ArrayList<>();
		
		log.info("Buscando codigo postal: " + codigopostal);
		
		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(new FileInputStream("/home/eduardo/Descargas/CPdescarga.txt"), StandardCharsets.ISO_8859_1));
		
			String lineaCP;
			
			while((lineaCP = buffer.readLine()) != null) {
				
				String[] detalle = lineaCP.split(Pattern.quote("|"));
				
				if(detalle[0].equals(codigopostal)) {
					CodigoPostal codigoPostal = new CodigoPostal();
					
					codigoPostal.codigo = detalle[0];
					codigoPostal.asenta = detalle[1];
					codigoPostal.tipoAsenta = detalle[2];
					codigoPostal.municipio = detalle[3];
					codigoPostal.estado = detalle[4];
					codigoPostal.ciudad = detalle[5];
					
					codigosInfo.add(codigoPostal);
				}
				
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return Response.status(Status.ACCEPTED).entity(codigosInfo).build();
	}
	
	
	
	
	

}
