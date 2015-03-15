package com.telapp.auro.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService{

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public boolean validateUser(User user) {
		boolean flag =true;
		log.info("Executing the method validateUser "+user );
		
		try{
			
			
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			ResponseBuilder builder =
					Response.status(Status.BAD_REQUEST);
					builder.type("application/xml");
					builder.entity("<error>Category"+ exp.getMessage() +"</error>");
					throw new WebApplicationException(builder.build());
		}
		
		log.info("Finished executing the method validateUser "+flag);
		return flag;
	}

	@Override
	public Response addUser(User user) {
		log.info("Executing the method addUser : "+user);
		
		try{
				
			user.setUserId(0);
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			ResponseBuilder builder =
					Response.status(Status.BAD_REQUEST);
			builder.type("application/xml");
			builder.entity("<error>Category"+ exp.getMessage() +"</error>");
			return builder.build();
			
		}
		
		// TODO Auto-generated method stub
		log.info("Finished executing the method addUser : "+user);
		return Response.ok(user).build();		
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setPassword("user123");
		user.setUserName("user");
		List<User> list =new ArrayList<User>();
		
		return list;
	}

	

}
