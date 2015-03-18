package com.telapp.auro.mqtt;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MacAddress {

	
	public static void main(String args[]) throws Exception
	{
		String str = getMacId();
		System.out.println("macid:"+str);
	}
	
	
	 private static String getMacId(){
	    	
		 
 		InetAddress ip;

			StringBuilder sb =null;
 		try {
 	 
 			ip = InetAddress.getLocalHost();
 			System.out.println("Current IP address : " + ip.getHostAddress());
 	 
 			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
 	 
 			byte[] mac = network.getHardwareAddress();
 			
 			
 	 
 			System.out.print("Current MAC address : "+mac.toString());
 	 
 			 sb = new StringBuilder();
 			for (int i = 0; i < mac.length; i++) {
 				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
 			}
 			System.out.println(sb.toString());
 	 
 		} catch (UnknownHostException e) {
 	 
 			e.printStackTrace();
 	 
 		} catch (SocketException e){
 	 
 			e.printStackTrace();
 	 
 		}
 	 
 	   return sb.toString();
 }
}
