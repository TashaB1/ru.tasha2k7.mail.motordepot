package ru.tasha2k7.mail.motordepot.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;

import ru.tasha2k7.mail.motordepot.daoapi.IClientDao;

@SuppressWarnings("serial")
public class ServletExample extends HttpServlet {
	
	@Inject
	private IClientDao clientService;
	
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/basicAuthSecured";
	 
    /*
     * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
     */
  /*  private static HttpHeaders getHeaders(){
    	String plainCredentials="client09:rrrrrrr";
    	String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Authorization", "Basic " + base64Credentials);
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	return headers;
    }*/
	
	
	
    
	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {

		request.getRequestDispatcher("/views/welcome1.jsp").forward(request, response);
  	}
	
	
	
}
