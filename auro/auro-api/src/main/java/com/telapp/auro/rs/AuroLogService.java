/**
 * 
 */
package com.telapp.auro.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.telapp.auro.models.AuroLog;

/**
 * @author rajunair
 *
 */
@Path("/auroLog")
public interface AuroLogService {
	
	
	@GET
	@Path("/list")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public List<AuroLog> getAuroLog();
	
	@GET
	@Path("/auroLogList")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public Response getAuroLogList();

}
