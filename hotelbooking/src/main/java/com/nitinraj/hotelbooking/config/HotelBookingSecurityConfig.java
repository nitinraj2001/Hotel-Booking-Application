package com.nitinraj.hotelbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class HotelBookingSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(encodePwD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors();
    	http.csrf().disable();
        http.authorizeRequests()
        .antMatchers("/user/functionality").hasRole("USER")
        .antMatchers("/user/admin/**").hasRole("ADMIN")  
        .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .defaultSuccessUrl("/user/functionality");
          
               
               
	}
	
	
	@Bean
	public BCryptPasswordEncoder encodePwD() {
		return new BCryptPasswordEncoder();
	}

}
