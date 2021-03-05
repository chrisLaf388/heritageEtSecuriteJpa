package com.ecole.pratique.rapport.securite;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.security.core.AuthenticationException;

@Component
public class AuthenticationEntryPointImpl extends BasicAuthenticationEntryPoint {
 
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
    	System.out.println("AuthenticationEntryPointImpl - commence() - Appelé quand l'utilisateur n'est pas authentifié");
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - Vous devez être authentifié");
    }
 
    @Override
    public void afterPropertiesSet() {
        // RealmName appears in the login window (Firefox).
        setRealmName("gsbRealm");
        super.afterPropertiesSet();
    }
 
}