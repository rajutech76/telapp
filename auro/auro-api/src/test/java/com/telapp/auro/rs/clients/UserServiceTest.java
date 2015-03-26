package com.telapp.auro.rs.clients;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.telapp.auro.models.AuroLog;
import com.telapp.auro.models.User;

public class UserServiceTest
{
		public static void main(String args[])throws Exception{
			
			System.out.println("Testing Rest endpoint");
			
			
			RestTemplate restTemplate = new RestTemplate();
			 String url="http://localhost:8080/auroservice/services/auroLog/auroLogList";
			 List<AuroLog> auroLog=restTemplate.getForObject(url, List.class);
			 	
			for(AuroLog u:auroLog){
				 
				 System.out.println(u);
			 }
			 
			
			System.out.println("Finished testing Rest endpoint");
			
		}

}
