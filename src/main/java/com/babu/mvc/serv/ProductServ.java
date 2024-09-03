package com.babu.mvc.serv;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.babu.mvc.repo.ProductRepo;
import com.babu.mvc.model.Products;
import java.util.*;
@Service
public class ProductServ {
@Autowired
	private ProductRepo produ;

	public void addProduct(Products products) {
		produ.save(products);
	}
	public List<Products> getProducts(){
		return produ.findAll();
	}
}
