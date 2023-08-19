package com.neobank.spacemoney.api;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

@Path("/api/zipcode")
public class ZipCodeAPI {
	
	@Inject
	private Logger log;
	
	@GET
	@Path("/{zipcode}")
	public Response getZipCode(@PathParam(value = "zipcode") String zipcode) {		
		List<CodigoPostal> codeInfoList = new ArrayList<>();
		
		String lCode;
		
		log.info("ZipCode: " + zipcode);
		
		try {
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(new FileInputStream("/home/eduardo/codigospostales/CPdescarga.txt")));
			
			log.info("ZipCode: " + zipcode);
			
			while((lCode = buffer.readLine())!= null){
				
				//log.info("ZipCode: " + zipcode);
				
				//log.info("LCode: " + lCode);
				String[] codeDetail = lCode.split(Pattern.quote("|")); 
				
				//log.info("Codigos Postales: " + codeDetail);
				if(codeDetail[0].equals(zipcode)) {
					CodigoPostal codigoPostal = new CodigoPostal();
					
					codigoPostal.codigo = codeDetail[0];
					codigoPostal.asenta = codeDetail[1];
					codigoPostal.tipoAsenta = codeDetail[2];
					codigoPostal.municipio = codeDetail[3];
					codigoPostal.estado = codeDetail[4];
					codigoPostal.ciudad = codeDetail[5];
					
					codeInfoList.add(codigoPostal);
				}
				
			}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return Response.status(Status.ACCEPTED).entity(codeInfoList).build();
	}

}
