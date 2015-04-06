/**
 * 
 */
package com.telapp.auro.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import com.telapp.auro.models.User;

/**
 * @author rajunair
 *
 */
@Path("/user")
@Produces({"application/xml","application/json","text/xml"})
@Consumes({"application/xml","application/json","text/xml"})

public interface UserService {

	@PUT
	@Path("/validateUser")
	@Produces({"application/xml","application/json","text/xml"})
	@Consumes({"application/xml","application/json","text/xml"})
	public Response validateUser(User user);
	
	@POST
	@Path("/addUser")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public Response addUser(User user);
	
	@GET
	@Path("/listUser")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	public Response getUser();
	
}
