package com.babu.mvc;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	UserDetailsService userDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                		.requestMatchers("/api/reg").permitAll()
                		.requestMatchers("/api/products").permitAll()
                		.requestMatchers("/api/addproducts").authenticated()
                		.requestMatchers("/api/customers").hasRole("ADMIN")
                		.requestMatchers("/api/admin/register").permitAll()
                		.requestMatchers("/api/cart").authenticated()
                                .anyRequest().permitAll()
                ).httpBasic(Customizer.withDefaults())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
    @Bean
    public AuthenticationProvider authenticatioProvide() {
    	DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(passwordEncoder());
    	provider.setUserDetailsService(userDetailService);
    	return provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

       }
