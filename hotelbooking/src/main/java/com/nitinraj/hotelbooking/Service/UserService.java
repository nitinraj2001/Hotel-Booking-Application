package com.nitinraj.hotelbooking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nitinraj.hotelbooking.model.Users;

@Service
public interface UserService {
	
	public void save(Users user);
	
	public Users findUser(String username);
	
	public List<Users> FindAllUsers();

}
