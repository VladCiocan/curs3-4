package com.vladciocan.Curs3;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
public class App 
{
	
    @SuppressWarnings("restriction")
	public static void main( String[] args ) throws IOException
    {
    	 //create webserver service
    	 HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
    	 //set handler to specified path
    	 server.createContext("/", new IndexHandler());
    	 server.createContext("/register", new RegisterHandler()); 
    	 server.createContext("/login", new LoginHandler()); 
    	 server.createContext("/home", new HomeHandler()); 
    	 
         //creates a default executor
         server.setExecutor(null);
         //start the server
         server.start();
         System.out.println("Server Started on port 8001");
         DBConnection connection=new DBConnection();
         try {
			connection.selectExample("client");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
}
