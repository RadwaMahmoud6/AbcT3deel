package com.example.demo.securityconfig;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.demo.service.CustomerDetailsServices;
import com.example.demo.service.JwtUtils;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter{

	private final CustomerDetailsServices custdetserv;

	//private final UserDetailsService userDetailsService;
	private final JwtUtils jwtUtils;
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)throws ServletException, IOException {
		final String authHeader = request.getHeader("AUTHORIZATION");
		final String userName;
		final String jwtToken;
		
	if(authHeader ==  null || !authHeader.startsWith("Bearer"))
	{
		filterChain.doFilter(request, response);
		return;
	}
	
	jwtToken = authHeader.substring(7);
	userName = jwtUtils.extractUsername(jwtToken); 
	
	if(userName != null  && SecurityContextHolder.getContext().getAuthentication() == null)
	{
		UserDetails userDetail = custdetserv.loadUserByUsername(userName);
		if(Boolean.TRUE.equals(jwtUtils.isTokenValid(jwtToken, userDetail)))
		{
			UsernamePasswordAuthenticationToken authToken = 
				new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authToken);
		}
	}
	
		filterChain.doFilter(request, response);

		
	}
}
