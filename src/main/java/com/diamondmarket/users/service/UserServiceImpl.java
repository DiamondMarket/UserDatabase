package com.diamondmarket.users.service;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diamondmarket.users.model.User;
import com.diamondmarket.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User returnMessage=null;
		try {
				user.set_id(user.getUserRole().substring(0, 1)+LocalDateTime.now());
				returnMessage = userRepository.save(user);
				
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		return returnMessage;
	}

	@Override
	public User getUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		User user= null;
		try {
			user = userRepository.findOne(userId);
			if(user==null) {
				throw new Exception("UserId: "+userId+" does not exist");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		return user;
	
	}

	@Override
	public String deleteUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		String returnMessage =null;
		try {
			if(userRepository.findOne(userId)!=null) {
				userRepository.delete(userId);
				returnMessage = userId +" deleted successfully";
			}
			else {
				throw new Exception("UserId: "+userId+" does not exist");
			}
		}
		catch(IllegalArgumentException e) {
			throw new Exception("Illegal arguments");
		}
		catch(Exception e) {
			throw e;
		}
		
		
		return returnMessage;
	}

	@Override
	public User updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		User returnMessage =null;
		try {
			if(userRepository.exists(user.get_id())) {
				returnMessage = userRepository.save(user);
			}
			else {
				throw new Exception("UserId: "+user.get_id()+" does not exist");
			}
			
		}
		catch(IllegalArgumentException e) {
			throw new Exception("UserId can not be null");
		}
		catch(Exception e) {
			throw e;
		}
		return returnMessage;
	
	}

	@Override
	public User loginUser(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		
		User returnUser =null;
		try {
			if(userRepository.findByUsername(username)!=null) {
				User save = userRepository.findByUsername(username);
				if(save.getPassword().equals(password)) {
					returnUser = save;
				}
				else {
					throw new Exception("Password mismatch");
				}
			}
			else {
				throw new Exception("Username not found");
			}
			
		}
		catch(IllegalArgumentException e) {
			throw new Exception("UserId can not be null");
		}
		catch(Exception e) {
			throw e;
		}
		return returnUser;
	}
	
	

}
