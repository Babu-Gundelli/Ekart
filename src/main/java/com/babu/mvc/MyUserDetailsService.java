package com.babu.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.babu.mvc.model.User;
import com.babu.mvc.repo.CustomerRepo;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
private CustomerRepo cRepo;
		@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User customer=cRepo.findByusername(username);

		if(username==null) {
			throw new UsernameNotFoundException("Invalid  User"+username);
		}
		return new UserPrincipal(customer);
	}

}
