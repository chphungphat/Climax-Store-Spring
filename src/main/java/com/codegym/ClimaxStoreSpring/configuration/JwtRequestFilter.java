//package com.codegym.ClimaxStoreSpring.configuration;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.r2s.constraint.ERole;
//import com.r2s.entity.User;
//import com.r2s.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.r2s.service.JwtUserDetailsService;
//
//import io.jsonwebtoken.ExpiredJwtException;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//	private static final String AUTHORIZATION = "Authorization";
//
//	private static final String BEARER = "Bearer ";
//
//
//	@Autowired
//	private JwtUserDetailsService jwtUserDetailsService;
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//
//		final String requestTokenHeader = request.getHeader(AUTHORIZATION);
//
//		String username = null;
//		String jwtToken = null;
//		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
//		if (requestTokenHeader != null && requestTokenHeader.startsWith(BEARER)) {
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//				if(jwtTokenUtil.isTokenExpired(jwtToken)){
//					throw new ExpiredJwtException(null, null, "Jwt expired");
//				}
//				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//
//			} catch (IllegalArgumentException e) {
//				System.out.println("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//				System.out.println("JWT Token has expired");
//			}
//		} else {
//			logger.warn("JWT Token does not begin with Bearer String");
//		}
//
//		//Once we get the token validate it.
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			User user = userRepository.findByUserName(username)
//					.orElseThrow(() -> new UsernameNotFoundException("User Not found"));
//			//filterPermissionAndPath(request.getRequestURL(), request.getMethod(), user.getRoles());
//
//			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//					user,
//					null,
//					Collections.singleton(new SimpleGrantedAuthority(user.getRoles().toString())));
//			usernamePasswordAuthenticationToken
//					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//			// After setting the Authentication in the context, we specify
//			// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
//			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//		}
//		chain.doFilter(request, response);
//	}
//
//	private void filterPermissionAndPath(StringBuffer requestURL, String method, ERole roles) {
//
//	}
//
//}
