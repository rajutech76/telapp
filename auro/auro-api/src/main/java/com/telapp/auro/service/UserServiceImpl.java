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

import com.telapp.auro.converter.AuroConverter;
import com.telapp.auro.models.AuroSlotstatus;
import com.telapp.auro.models.User;
import com.telapp.auro.models.impl.UserList;
import com.telapp.auro.persist.dao.AuroAuthHome;
import com.telapp.auro.persist.entities.AuroAuth;
import com.telapp.auro.rs.UserService;

public class UserServiceImpl implements UserService{

	private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired  AuroAuthHome  auroUser ;
	
	@Override
	public Response validateUser(User user) {
	
		boolean flag =false;
		log.info("Executing the method validateUser "+user );
		
		ResponseBuilder builder = new ResponseBuilderImpl();
		AuroAuth auth = null;
		
		try{		
				
				auth =auroUser.findUser(AuroConverter.toAuroAuth(user));
				if(auth.getAuthId()>0){
					flag =true;					
				}
				
				builder.entity(flag);
				builder.status(Status.OK);
		}catch(Exception exp){
			builder.status(Status.BAD_REQUEST);
				builder.type("application/xml");
					builder.entity("<error>Category"+ exp.getMessage() +"</error>");
								
		}finally{
			auth =null;
		}
		log.info("Finished executing the method validateUser "+flag);
		return builder.build();
	}

	@Override
	public Response addUser(User user) {
		log.info("Executing the method addUser : "+user);
		ResponseBuilder builder =null;
	
		try{
				auroUser.persist(AuroConverter.toAuroAuth(user));
				builder=Response.status(Status.OK);
				builder.entity(user);
		
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);
			//builder.type("application/xml");
			//builder.entity("<error>Category"+ exp.getMessage() +"</error>");
							
		}
		log.info("Finished executing the method addUser : "+user);
		return  builder.build();		
	}

	@Override
	public Response getUser() {
		
		log.info("Executing the method getUser");
		ResponseBuilder builder =null; 
		List<AuroAuth> userList =null;
		List<User> user =null;
		UserList ul =null;
		try{
				userList = auroUser.getAllUser(0, 0);
				user =AuroConverter.toUserList(userList);
				ul =new UserList();
				ul.setUserList(user);
				builder=Response.status(Status.OK);
				builder.entity(ul);				
				
		}catch(Exception exp){
			log.error(exp.getMessage(),exp);
			builder =Response.status(Status.BAD_REQUEST);
		}finally{
			userList =null;
			user =null;
			ul =null;
		}
		
		log.info(" Finished executing the method getUser");
		
		return builder.build();
	}

	

}
