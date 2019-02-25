package com.vladciocan.Curs3;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")
public class  HomeHandler implements HttpHandler {
	
	public void handle(HttpExchange t) throws IOException {
		if(Globals.users.containsKey(Globals.getUriValue(t, "username"))) {
			if(Globals.users.get(Globals.getUriValue(t, "username")).equals(Globals.getUriValue(t, "password"))) {
				//set the response as a string containing html code
		        String response = "<html>\r\n" + 
		        		"\r\n" + 
		        		"<body>\r\n" + 
		        		"    <h1>Buna user : "+Globals.getUriValue(t, "username")+"</h1>\r\n" + 
		        		"    <br>\r\n" + 
		        		"    <br>\r\n" + 
		        		"    Ce faci?"+
		        		"</body>\r\n" + 
		        		"\r\n" + 
		        		"</html>";
		        //set heders and status code
		        Globals.MakeRequest(t, response);
			}else {
				Headers responseHeaders = t.getResponseHeaders();
				responseHeaders.set("Location", "/index");
				t.sendResponseHeaders(302,0);
			}
		}else {
			Headers responseHeaders = t.getResponseHeaders();
			responseHeaders.set("Location", "/index");
			t.sendResponseHeaders(302,0);
		}
		
    }
}
