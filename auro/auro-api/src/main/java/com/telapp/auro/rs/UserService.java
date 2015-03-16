/**
 * 
 */
package com.telapp.auro.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.telapp.auro.beans.User;

/**
 * @author rajunair
 *
 */
@Path("/user")
@Produces({"application/xml","application/json"})
@Consumes({"application/xml","application/json"})

public interface UserService {

	@GET
	@Path("/validateUser")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public boolean validateUser(@PathParam("validateUser") User user);
	
	@POST
	@Path("/addUser")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public Response addUser(@PathParam("addUser") User user);
	
	@GET
	@Path("/listUser")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public List<User> getUser();
	
}
