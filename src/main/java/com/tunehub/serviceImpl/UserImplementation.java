package com.tunehub.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entity.Song;
import com.tunehub.entity.User;
import com.tunehub.repository.UserRepository;
import com.tunehub.service.UserService;
@Service
public class UserImplementation implements UserService {


	@Autowired
	UserRepository ur;
	@Override
	public void saveUser(User user) {

		ur.save(user);		
	}
	@Override
	public User emailExists(User user) {

		if( ur.findByEmail(user.getEmail()) != null) {
			System.out.println("Present");
			return user;
		}
		else {
			System.out.println("Absent");
		}
		return null;
	}
	@Override
	public boolean validUser(String email, String password) {
		
		User user = ur.findByEmail(email);
		if(user==null) {
			return false;
		}
		String dbpwd=user.getPassword();
		
		if(password.equals(dbpwd)) {
			return true;
		}
 		return false;
	}
	@Override
	public String getRole(String email) {
		User user = ur.findByEmail(email);
		return user.getRole();
     		
	}
	@Override
	public User getUser(String mail) {

		return ur.findByEmail(mail);
	}
	@Override
	public void updateUser(User user) {
        ur.save(user)	;	
	}
	
	
	

}
