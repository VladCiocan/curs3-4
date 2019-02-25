package com.vladciocan.Curs3;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;

public class Globals {
	public static HashMap<String,String> users=new HashMap<String,String>();
	public static String getUriValue(HttpExchange t,String nume) {
		String q=t.getRequestURI().getQuery();
		for(String set:q.split("&")) {
			if(set.split("=")[0].equals(nume)) {
				return set.split("=")[1];
			}
		}
		return null;
	}
	@SuppressWarnings("restriction")
	public static void MakeRequest(HttpExchange t, String raspuns) throws IOException {
		t.sendResponseHeaders(200, raspuns.length());
        OutputStream os = t.getResponseBody();
        //send reposnse
        os.write(raspuns.getBytes());
        //close request
        os.close();
	}

}
