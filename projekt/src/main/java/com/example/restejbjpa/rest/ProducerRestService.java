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
import com.example.restejbjpa.domain.Producer;
import com.example.restejbjpa.domain.Type;
import com.example.restejbjpa.domain.Pillow;
import com.example.restejbjpa.service.BedManager;


@Path("producer")
public class ProducerRestService {

	@EJB
	BedManager bm;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producer getProducer(@PathParam("id") Long id){
		Producer retrieved = bm.getProducer(id);
		
		return retrieved;
	}
	
	@GET
	@Path("/mostColorfull")
	@Produces(MediaType.APPLICATION_JSON)
	public Producer getMostColorfull(){
		Producer retrieved = bm.findMostColorfullProducer();
		return retrieved;
	}
	
	@GET
	@Path("/manyPillows")
	@Produces(MediaType.APPLICATION_JSON)
	public Producer getManyPillows(){
		Producer retrieved = bm.findManyPillows();
		return retrieved;
	}
	
	@GET
	@Path("/manyPillows/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producer> getManyPillows(@PathParam("id") Long id){
		List<Producer> retrieved = bm.findManyPillows(id.intValue());
		return retrieved;
	}
	
	
	@DELETE
	public Response deletAllProducers(){
		bm.deletAllProducers();
		return Response.status(Response.Status.OK).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producer> getProducers() {
		return bm.getAllProducers();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProducer(Producer producer) {
		bm.addProducer(producer);

		return Response.status(201).entity("Producer").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProducers(List<Producer> list) {
		for(Producer o : list)
			bm.addProducer(o);

		return Response.status(201).entity("Producer").build();
	}

}