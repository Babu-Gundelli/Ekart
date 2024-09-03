package com.babu.mvc;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.babu.mvc.model.User;
import com.babu.mvc.model.Role;

public class UserPrincipal implements UserDetails{
	
	private User customer;
	public UserPrincipal(User customer) {
		if(customer==null) {
			throw new IllegalArgumentException("customer cant be null");
		}
		this.customer=customer;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = customer.getRoles();
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toUpperCase()))
                .collect(Collectors.toSet());
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getUsername();
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
