package com.aravind.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.model.Product;
import com.aravind.repo.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	public Product save(Product product) {
		Product pro = repo.save(product);
		return pro;
	}
	
	public List<Product> getAll(){
		return repo.findAll();
	}
	
	public boolean deleteById(Integer id) {
	    Optional<Product> res = repo.findById(id);
	    if (res.isPresent()) {
	        repo.deleteById(id);
	        return true;
	    } else {
	        return false;
	    }
	}

	
	public Product findById(int id) {
		return repo.findById(id).get();
	}
	
	
}
