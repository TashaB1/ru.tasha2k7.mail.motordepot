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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

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

    private String[] resolveCredentials(HttpServletRequest req) {
        try {
            Enumeration<String> headers = req.getHeaders("Authorization");
            String nextElement = headers.nextElement();
            String base64Credentials = nextElement.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));           
            return credentials.split(":", 2);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void destroy() {
    }

}