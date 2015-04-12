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

import com.telapp.auro.models.AuroDeviceRegModel;

/**
 * @author rajunair
 *
 */

@Path("/devicereg")
@Produces({"application/xml","application/json","text/xml"})
@Consumes({"application/xml","application/json","text/xml"})

	public interface AuroDeviceService {

		
		@POST
		@Path("/addDevice")
		@Produces({"application/xml","application/json","text/xml"})
		@Consumes({"application/xml","application/json","text/xml"})
		public Response addSlot(AuroDeviceRegModel model);
		
		@POST
		@Path("/editDevice")
		@Produces({"application/xml","application/json","text/xml"})
		@Consumes({"application/xml","application/json","text/xml"})
		public Response editSlot(AuroDeviceRegModel model);
		
		
		@POST
		@Path("/removeDevice")
		@Produces({"application/xml","application/json","text/xml"})
		@Consumes({"application/xml","application/json","text/xml"})
		public Response removeSlot(AuroDeviceRegModel model);
		
		
		
		@GET
		@Path("/getDevices")
		@Produces({"application/xml","application/json","text/xml"})
		@Consumes({"application/xml","application/json","text/xml"})
		public Response getSlot();
		
		
		@GET
		@Path("/findDevice")
		@Produces({"application/xml","application/json","text/xml"})
		@Consumes({"application/xml","application/json","text/xml"})
		public Response getSlot(int id);
		
	}



