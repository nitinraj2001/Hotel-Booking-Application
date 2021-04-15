package com.nitinraj.hotelbooking.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nitinraj.hotelbooking.model.Users;


public class CustomUserDetails implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	private Users user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
		    if (isEnabled()) {
		        if (user.getUserprofile().getUserRole().equalsIgnoreCase("ADMIN")) {
		            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		        }
		        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		    }
		System.out.println(authorities);
		return authorities;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
