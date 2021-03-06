package com.mvc.reg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	
	@Autowired
	CustomUserDetailsService userDetailsService ;
	
	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;
	
	@Autowired
  	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/authenticate","/register","/logout","login","/api/products/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/api/v1/**","/cart/**").hasAnyRole("ADMIN","USER")
		
		
		
		.anyRequest().authenticated()
		
		//if any exception occurs call this
				.and().exceptionHandling()
		        .authenticationEntryPoint(unauthorizedHandler).and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//		 		Add a filter to validate the tokens with every request
				http.addFilterBefore(customJwtAuthenticationFilter, 
				UsernamePasswordAuthenticationFilter.class);
	}
}
