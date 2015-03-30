package com.telapp.auro.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.telapp.auro.models.AuroSlotstatus;
import com.telapp.auro.models.User;
import com.telapp.auro.persist.dao.AuroAuthHome;
import com.telapp.auro.rs.UserService;

public class UserServiceImpl implements UserService{

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	//@Autowired  AuroAuthHome  auroUser ;
	
	@Override
	public Response validateUser(User user) {
	
		boolean flag =true;
		log.info("Executing the method validateUser "+user );
		
		ResponseBuilder builder = new ResponseBuilderImpl();
		
		try{		
				flag =true;
				builder.entity(flag);
				builder.status(Status.OK);
		}catch(Exception exp){
			builder.status(Status.BAD_REQUEST);
				builder.type("application/xml");
					builder.entity("<error>Category"+ exp.getMessage() +"</error>");
					//throw new WebApplicationException(builder.build());
			 
			
			
		}
		log.info("Finished executing the method validateUser "+flag);
		return builder.build();
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
	public Response getUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setPassword("user123");
		user.setUserName("user");
		List<User> list =new ArrayList<User>();
		list.add(user);
		
		return Response.status(200).entity(new GenericEntity<List<User>>(list) {}).build();
		//return list;
	}

	

}
