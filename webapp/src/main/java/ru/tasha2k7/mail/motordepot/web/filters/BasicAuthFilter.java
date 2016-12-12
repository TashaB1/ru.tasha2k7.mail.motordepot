package ru.tasha2k7.mail.motordepot.web.filters;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;
import ru.tasha2k7.mail.motordepot.services.RegistrationDataService;

public class BasicAuthFilter implements Filter {
	
    private RegistrationDataService registrationDataService;

    @Override
    public void init(FilterConfig config) throws ServletException {
        registrationDataService = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext()).getBean(
                RegistrationDataService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {
    	
        org.eclipse.jetty.server.Request req = (org.eclipse.jetty.server.Request) request;
        org.eclipse.jetty.server.Response res = (org.eclipse.jetty.server.Response) response;
        
        String email1 = (String) req.getAttribute("email");
        String pas1 = (String) req.getAttribute("password");
        
        String em2pas = email1+":" + pas1;
        
        String enc = "Basic " + Base64.getEncoder().encodeToString(em2pas.getBytes("utf-8"));

        req.setAttribute("Authorization", enc);
        
        String[] credentials = resolveCredentials(req);

        boolean isCredentialsResolved = credentials != null && credentials.length == 2;
        if (!isCredentialsResolved) {
            res.sendError(401);
            return;
        }

        String email = credentials[0];
        String password = credentials[1];
        if (registrationDataService.validateEmailPassword(email, password)) {
        	//res.sendError(200);
        	chain.doFilter(request, response);
        } else {
            res.sendError(401);
        }

    }

    private String[] resolveCredentials(org.eclipse.jetty.server.Request req) {
        try {
            Enumeration<String> headers = req.getHeaders("Authorization");
            String nextElement = headers.nextElement();
            String base64Credentials = nextElement.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));           
            
            String headerValue	= "Basic "	+ Base64.getEncoder().encodeToString("email".getBytes("utf-8"));
            return credentials.split(":", 2);
            
            		
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void destroy() {
    }

}