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
import com.example.restejbjpa.domain.Type;
import com.example.restejbjpa.domain.Pillow;
import com.example.restejbjpa.service.BedManager;


@Path("type")
public class TypeRestService {

	@EJB
	BedManager bm;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Type getType(@PathParam("id") Long id){
		Type retrieved = bm.getType(id);
		
		return retrieved;
	}
	
	
	@DELETE
	public Response deletAllTypes(){
		bm.deletAllTypes();
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Type> getTypes() {
		return bm.getAllTypes();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addType(Type type) {
		bm.addType(type);

		return Response.status(201).entity("Type").build();
	}

}