package com.babu.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.babu.mvc.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
