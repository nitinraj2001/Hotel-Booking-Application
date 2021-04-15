package com.nitinraj.hotelbooking.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nitinraj.hotelbooking.model.Users;
import com.nitinraj.hotelbooking.repository.UserRepository;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

	private UserRepository theUserRepo;
	
	public UserServiceImplementation(UserRepository UserRepo) {
		theUserRepo=UserRepo;
	}
	@Override
	public void save(Users user) {
		theUserRepo.save(user);
		
	}
	@Override
	public Users findUser(String username) {
		Users theUser=theUserRepo.findByUsername(username);
		return theUser;
	}
	@Override
	public List<Users> FindAllUsers() {
		
		return theUserRepo.findAll();
	}

}
