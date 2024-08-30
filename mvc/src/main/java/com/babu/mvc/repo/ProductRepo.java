package com.babu.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.babu.mvc.model.Products;
import com.babu.mvc.model.User;
@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {

}
