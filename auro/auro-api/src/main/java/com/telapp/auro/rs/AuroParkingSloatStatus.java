/**
 * 
 */
package com.telapp.auro.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author rajunair
 *
 */
@Path("/parkingStatus")
public interface AuroParkingSloatStatus {
	
	@GET
	@Path("/status")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})	
	public Response getParkingStatus();

}
