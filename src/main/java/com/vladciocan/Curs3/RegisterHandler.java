package com.vladciocan.Curs3;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class RegisterHandler  implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		String username=Globals.getUriValue(t, "username");
		String password=Globals.getUriValue(t, "password");
		if(username!=null &&password!=null) {
			Globals.users.put(username, password);
			String response = "<html>\r\n" + 
	        		"\r\n" + 
	        		"<body>\r\n" + 
	        		"    <h1>Register user</h1>\r\n" + 
	        		"    <br>\r\n" + 
	        		"    <br>\r\n" + 
	        		"       <h2>Utilizator inregistrat cu success</h2>"+
	        		"    <p>-SAU-</p>\r\n" + 
	        		"    <span>\r\n" + 
	        		"        <input onclick=\"window.location.href = '/login'\" type=\"button\" name=\"Button\" value=\"Du-te la login\"/></span>\r\n" + 
	        		"</body>\r\n" + 
	        		"\r\n" + 
	        		"</html>";
			 t.sendResponseHeaders(200, response.length());
			 OutputStream os = t.getResponseBody();
		        //send reposnse
		        os.write(response.getBytes());
		        //close request
		        os.close();
		}else {
			String response = "<html>\r\n" + 
	        		"\r\n" + 
	        		"<body>\r\n" + 
	        		"    <h1>Register user</h1>\r\n" + 
	        		"    <br>\r\n" + 
	        		"    <br>\r\n" + 
	        		"       <a hreff=\"/\"><input type=\"button\" name=\"Button\" value=\"Du-te la register\\\"/></a>"+
	        		"    <p>-SAU-</p>\r\n" + 
	        		"    <span>\r\n" + 
	        		"        <input onclick=\"window.location.href = 'localhost:8001/login';\" type=\"button\" name=\"Button\" value=\"Du-te la login\"/></span>\r\n" + 
	        		"</body>\r\n" + 
	        		"\r\n" + 
	        		"</html>";
			 t.sendResponseHeaders(200, response.length());
			 OutputStream os = t.getResponseBody();
		        //send reposnse
		        os.write(response.getBytes());
		        //close request
		        os.close();
		}
		
		
       
    }
}
