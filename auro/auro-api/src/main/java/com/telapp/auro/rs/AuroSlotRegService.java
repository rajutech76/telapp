/**
 * 
 */
package com.telapp.auro.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.telapp.auro.models.AuroSlot;

/**
 * @author rajunair
 *
 */
@Path("/slotreg")
@Produces({"application/xml","application/json","text/xml"})
@Consumes({"application/xml","application/json","text/xml"})
public interface AuroSlotRegService {

	
	@POST
	@Path("/addSlot")
	@Produces({"application/xml","application/json","text/xml"})
	@Consumes({"application/xml","application/json","text/xml"})
	public Response addSlot(AuroSlot slot);
	
	@POST
	@Path("/editSlot")
	@Produces({"application/xml","application/json","text/xml"})
	@Consumes({"application/xml","application/json","text/xml"})
	public Response editSlot(AuroSlot slot);
	
	
	@POST
	@Path("/removeSlot")
	@Produces({"application/xml","application/json","text/xml"})
	@Consumes({"application/xml","application/json","text/xml"})
	public Response removeSlot(AuroSlot slot);
	
	
	
	@GET
	@Path("/getSlot")
	@Produces({"application/xml","application/json","text/xml"})
	@Consumes({"application/xml","application/json","text/xml"})
	public Response getSlot();
	
	
	@GET
	@Path("/findSlot")
	@Produces({"application/xml","application/json","text/xml"})
	@Consumes({"application/xml","application/json","text/xml"})
	public Response getSlot(int id);
	
}
