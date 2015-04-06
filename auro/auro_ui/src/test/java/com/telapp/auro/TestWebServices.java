/**
 * 
 */
package com.telapp.auro;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.telapp.auro.models.AuroLog;
import com.telapp.auro.models.User;
import com.telapp.auro.models.impl.AuroLogList;

/**
 * @author rajugopi
 *
 */
public class TestWebServices {
	
	public static void main(String args[]) throws Exception 
	{
		
		System.out.println(" Executing main TestWebServices");
		
			
	//	getUserStatus();
		
		addUser();
		
		//get();
		
		System.out.println(" Finished Executing main TestWebServices");
		
	}
	
	public static void addUser(){
		
		RestTemplate restTemplate = new RestTemplate();
		// String url="http://auroservice-telappauro.rhcloud.com/auroservice/services/auroLog/list";
		String url ="http://localhost:8080/auroservice/services/user/addUser";
		
		User user =new User();
		user.setPassword("auro123");
		user.setUserName("auro");
		
		System.out.println(" user : "+user);
		
		
		HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		 headers.setContentType(MediaType.APPLICATION_XML);

		 HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		 
		 
		 
		 ResponseEntity<User> resp=   restTemplate.exchange(url, HttpMethod.POST, entity,
				 User.class);
		 
		 
		 
		 
		// restTemplate.exchange(url, method, requestEntity, responseType, uriVariables)
		 
		 System.out.println(resp);
		System.out.println(" body : "+resp.getBody());
		
	}
	
	
	
	public static void getUserStatus(){
		RestTemplate restTemplate = new RestTemplate();
		// String url="http://auroservice-telappauro.rhcloud.com/auroservice/services/auroLog/list";
		String url ="http://localhost:8080/auroservice/services/user/validateUser";
		
		User user =new User();
		user.setPassword("password");
		user.setUserName("login name");
		
		 
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		 headers.setContentType(MediaType.APPLICATION_XML);

		 HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		 
		 
		 
		 ResponseEntity<String> resp=   restTemplate.exchange(url, HttpMethod.PUT, entity,
				 String.class);
		 
		 
		 
		 
		// restTemplate.exchange(url, method, requestEntity, responseType, uriVariables)
		 
		 System.out.println(resp);
		System.out.println(" body : "+resp.getBody());
		 
	}
	
	
	
	
	public  static void get(){
		RestTemplate restTemplate = new RestTemplate();
		// String url="http://auroservice-telappauro.rhcloud.com/auroservice/services/auroLog/list";
		String url ="http://localhost:8080/auroservice/services/auroLog/auroLogList";
		
		 
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		 headers.setContentType(MediaType.APPLICATION_XML);
		 
		 HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		 
		 
		 
		 ResponseEntity<AuroLogList> resp=   restTemplate.exchange(url, HttpMethod.GET, entity, AuroLogList.class);
		 
		 System.out.println(resp);
		 
		 AuroLogList log =resp.getBody();
		 
		 List<AuroLog> list =log.getAuroLog();
		 
		 for(AuroLog l :list){
			 System.out.println(l);
		 }
		 
		// System.out.println("response body :"+list);
		 				
		 //List<AuroLog> auroLog=restTemplate.getForObject(url, List.class);
	}

}
