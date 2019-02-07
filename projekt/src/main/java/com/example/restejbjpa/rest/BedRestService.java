package com.example.restejbjpa.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.restejbjpa.domain.Bed;
import com.example.restejbjpa.service.BedManager;


@Path("bed")
public class BedRestService {
	
	@EJB
	BedManager bm;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bed getBed(@PathParam("id") Long id){
		
		Bed retrieved = bm.getBed(id);
		
		//retrieved.setAuthors(bm.getAuthorsOfBook(id));
		
		//System.out.println("Authors :" + retrieved.getAuthors().size());
		
		return retrieved;
	}
	
	
	@DELETE
	public Response deletAll(){
		bm.deletAllBeds();
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bed> getBeds() {
		return bm.getAllBeds();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBed(Bed bed) {
		bm.addBed(bed);

		return Response.status(201).entity("Bed").build();
	}
//
//	@GET
//	@Path("/test")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test() {
//		return "REST API /bed is running today!";
//	}
//
//	@DELETE
//	public Response clearBeds() {
//		bm.deleteAllBeds();
//		return Response.status(200).build();
//	}
	
	@DELETE
	@Path("/{bedId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBed(@PathParam("bedId") Integer id) {
		//bm.deleteBed(id);
		return Response.status(200).build();
	}

}
