/**
 * 
 */
package com.telapp.auro.ctl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.telapp.auro.models.AuroLog;
import com.telapp.auro.models.impl.AuroLogList;

/**
 * @author rajugopi
 *
 */
public class TestWebServices {
	
	public static void main(String args[]) throws Exception 
	{
		
		System.out.println(" Executing main TestWebServices");
		
		RestTemplate restTemplate = new RestTemplate();
		// String url="http://auroservice-telappauro.rhcloud.com/auroservice/services/auroLog/list";
		String url ="http://localhost:8080/auroservice/services/auroLog/auroLogList";
		
		 
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));

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
		
	
		
		
		System.out.println(" Finished Executing main TestWebServices");
		
	}

}
