package com.babu.mvc.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.babu.mvc.model.Cart;
import com.babu.mvc.model.User;
import com.babu.mvc.model.Products;
import com.babu.mvc.serv.CartService;
import com.babu.mvc.serv.ProductServ;
import com.babu.mvc.serv.ServiceClass;

@RestController
@RequestMapping("/api")
public class MvcController {
    
    @Autowired
    private ServiceClass customerService;

    @Autowired
    private ProductServ productServ;
    
    @Autowired
    private CartService cartService;



    @GetMapping("/customers")
    public ResponseEntity<List<User>> getAllCustomers() {
        List<User> customers = customerService.listUsers();
        return ResponseEntity.ok(customers);
    }

     @PostMapping
    @PreAuthorize("hasRole('ADMIN')")   
     public ResponseEntity<String> addProduct(@RequestBody Products product) {
    	try {
            productServ.addProduct(product);
            return ResponseEntity.ok("Product inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting product");
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productServ.getProducts();
        return ResponseEntity.ok(products);
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody User customer) {
        if (customerService.findByUsername(customer.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        customerService.save(customer);
        return ResponseEntity.ok("Customer registered successfully");
    }
        @PostMapping("/cart")
    public void addToCart(@RequestBody Cart cart) {
        cartService.addToCart(cart);
    }
    
}
