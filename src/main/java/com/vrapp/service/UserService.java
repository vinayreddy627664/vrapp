package com.vrapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrapp.repositories.UserRepository;
import com.vrapp.domain.User;
import com.vrapp.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) throws Exception{
		return userRepository.save(user);
	}

	public void delete(Integer u_id) throws Exception{
		User user = userRepository.findOne(u_id);
		if(user==null){
			throw new ResourceNotFoundException("User with "+u_id+" Not Found");
		}else{
			userRepository.delete(u_id);
		}
	}
	
	public User findUserByName(String userName) throws Exception {
		return userRepository.findByUserName(userName);
	}
	
	public void delete(String userName) throws Exception{
		User user = userRepository.findByUserName(userName);
		if(user==null){
			throw new ResourceNotFoundException("User with "+userName+" Not Found");
		}else{
			userRepository.deleteUser(userName);
		}
	}
	
	public User getUser(Integer u_id) throws Exception{
		User user = userRepository.findOne(u_id);
		if(user==null){
			throw new ResourceNotFoundException("User with "+u_id+" Not Found");
		}else{
			return user;
		}
	}
	
	public List<User> getAllUsers() throws Exception{
		return userRepository.findAll();
	}
}
