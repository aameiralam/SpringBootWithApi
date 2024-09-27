package com.springApaLearning.monster_trainer.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        ////request comes in, grabs the authorization header out of the response/ request head
        final String authHeader = request.getHeader("Authorization");
        final String jwt, username;

        // if the Authorization header is null or does not start with bearer it passes back to the security filer chain
        if (authHeader==null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }
        // here we will seperate the JWT from the extra keyword, so we can verify the token
        jwt = authHeader.substring(7);
        //Extracting the Username from the JWT Payload

        username = jwtService.extractUsername(jwt);

//        if username is not null and securityContextHolder is not holding an authorization
//        start the process setting up a new securityContext

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//            Checking to see if the JWT token is valid by username and expiration

            if (jwtService.isTokenValid(jwt,userDetails)) {

//                Creating an AuthenticationToken to be used to tell the app what this user can do

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(), null, userDetails.getAuthorities()
                );
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
//                Creating the SecurityContext with the AuthenticationToken to tell what the user can do
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
//        Returning back to the SecurityFilterChain

        filterChain.doFilter(request,response);
    }
}
