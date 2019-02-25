package com.vladciocan.Curs3;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class LoginHandler  implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		System.out.println(t.getRequestURI().getQuery());
		
		//set the response as a string containing html code
        String response = "<html>\r\n" + 
        		"\r\n" + 
        		"<body>\r\n" + 
        		"    <h1>Register user</h1>\r\n" + 
        		"    <br>\r\n" + 
        		"    <br>\r\n" + 
        		"    <form action=\"/home\" method=\"GET\">\r\n" + 
        		"    <input type=\"text\" name=\"username\" placeholder=\"Baga un username\"/>\r\n" + 
        		"    <input type=\"password\" name=\"password\" placeholder=\"Baga o parola\"/>\r\n" + 
        		"    <input onclick=\"window.location.href = 'localhost:8001/home';\"  type=\"submit\" value=\"Login\">\r\n" + 
        		"        \r\n" + 
        		"    \r\n" + 
        		"    </form>\r\n" + 
        		"</body>\r\n" + 
        		"\r\n" + 
        		"</html>";
        //set heders and status code
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        //send reposnse
        os.write(response.getBytes());
        //close request
        os.close();
    }
}
