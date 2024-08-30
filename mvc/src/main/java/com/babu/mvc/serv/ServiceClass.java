package com.babu.mvc.serv;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.babu.mvc.model.User;
import com.babu.mvc.repo.CustomerRepo;

@Service
public class ServiceClass {
	@Autowired
	private CustomerRepo customrepo;
	@Autowired
    private PasswordEncoder passwordEncoder;
	public void save(User customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customrepo.save(customer);
	}
	
	 public List<User> listUsers() {
	        return customrepo.findAll();
	    }	
	 public User findByUsername(String username) {
        return customrepo.findByusername(username);
    }
}
