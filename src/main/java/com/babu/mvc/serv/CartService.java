package com.babu.mvc.serv;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babu.mvc.model.Cart;
import com.babu.mvc.repo.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public void addToCart(Cart cart) {
        cartRepository.save(cart);
    }
    public List<Cart> cart(){
    	return cartRepository.findAll();
    }
}
