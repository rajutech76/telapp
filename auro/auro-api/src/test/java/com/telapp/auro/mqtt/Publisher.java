/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.telapp.auro.mqtt;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Random;

import org.fusesource.hawtbuf.AsciiBuffer;
import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.Future;
import org.fusesource.mqtt.client.FutureConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

/**
 * Uses a Future based API to MQTT.
 */
class Publisher {

    public static void main(String []args) throws Exception {

    	String hostId="85.119.83.194";
    	//String hostId="test.mosquitto.org";
    	
        String user = env("ACTIVEMQ_USER", "admin");
        String password = env("ACTIVEMQ_PASSWORD", "password");
        String host = env("ACTIVEMQ_HOST", hostId);
        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "1883"));
        final String destination = arg(args, 0, "auro/mqtt/topic");

        int messages = 10000;
        int size = 256;

        String DATA =getDeviceName()+"_"+getMacId()+ "_sensorstatus_"+getDevicestatus();
        String body = "";
        size = DATA.length();
        System.out.println(" data size : "+size);
        for( int i=0; i < size; i ++) {
            body += DATA.charAt(i%DATA.length());
        }
       Buffer msg = new AsciiBuffer(body);

        MQTT mqtt = new MQTT();
        mqtt.setHost(host, port);
     //   mqtt.setUserName(user);
      //  mqtt.setPassword(password);
        
        
        System.out.println(" connecting to mqtt brocker ....");

        FutureConnection connection = mqtt.futureConnection();
        connection.connect().await();
        
        System.out.println("connection established by  mqtt brocker ....");

        final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
        UTF8Buffer topic = new UTF8Buffer(destination);
      //  for( int i=1; i <= messages; i ++) {

            // Send the publish without waiting for it to complete. This allows us
            // to send multiple message without blocking..
        
        System.out.println(" sending message to the mqtt brocker ...");
            queue.add(connection.publish(topic, msg, QoS.AT_LEAST_ONCE, false));
            
            System.out.println("Message send  to the mqtt brocker ...");

            // Eventually we start waiting for old publish futures to complete
            // so that we don't create a large in memory buffer of outgoing message.s
          /*  if( queue.size() >= 1000 ) {
                queue.removeFirst().await();
            }

            if( i % 1000 == 0 ) {
                System.out.println(String.format("Sent %d messages.", i));
            }
           */ 
        //}

        queue.add(connection.publish(topic, new AsciiBuffer("SHUTDOWN"), QoS.AT_LEAST_ONCE, false));
       while( !queue.isEmpty() ) {
            queue.removeFirst().await();
        }
		
        connection.disconnect().await();

        System.exit(0);
    }

    private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if( rc== null )
            return defaultValue;
        return rc;
    }

    private static String arg(String []args, int index, String defaultValue) {
        if( index < args.length )
            return args[index];
        else
            return defaultValue;
    }
    
    private static int getDevicestatus(){
    	int status=0;
    	 Random randomGenerator = new Random();
    	return status=randomGenerator.nextInt(10);
    }
    
    private static String getDeviceName(){
    	return "TestDevice-1";
    }
    
    
    private static String getMacId(){
    	
    		 
    		InetAddress ip;

			StringBuilder sb =null;
    		try {
    	 
    			ip = InetAddress.getLocalHost();
    			System.out.println("Current IP address : " + ip.getHostAddress());
    	 
    			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
    	 
    			byte[] mac = network.getHardwareAddress();
    			
    			
    	 
    			System.out.print("Current MAC address : ");
    	 
    			 sb = new StringBuilder();
    			for (int i = 0; i < mac.length; i++) {
    				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
    			}
    			//System.out.println(sb.toString());
    	 
    		} catch (UnknownHostException e) {
    			 sb = new StringBuilder("UN-KNOWN-HOST");
    	 
    			e.printStackTrace();
    	 
    		} catch (SocketException e){
    			 sb = new StringBuilder("UN-KNOWN-HOST");
    	 
    			e.printStackTrace();
    	 
    		}catch(Exception exp){
    			 sb = new StringBuilder("UN-KNOWN-HOST");
    			
    		}
    	 
    	   return sb.toString();
    }

}