package ru.tasha2k7.mail.motordepot.web.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomBasicAuthenticationEntryPoint.class);
	
	@Override
    public void commence(final HttpServletRequest request, 
    		final HttpServletResponse response, 
    		final AuthenticationException authException) throws IOException, ServletException {
    	
    	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    	response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
        
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
        
        LOGGER.debug("CustomBasicAuthentication ontvangt request: "
                + request.getRequestURL() + " met methode: "
                + request.getMethod());
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
    	LOGGER.debug("Creating customBasicAuthenticationEntryPoint");
        setRealmName("MY_TEST_REALM");
        super.afterPropertiesSet();
    }
}
