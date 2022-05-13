package com.spring;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //it provides functionalities acts as a service provider for class
public class ProductService {
@Autowired  //it is applied to constructor/setter/methods instead of creating obj by using new keyword for every method

private ProductRepository repo;

//display all data
public List<Product>listAll(){
	return repo.findAll();
}
	//insert data
	public void save(Product product) {
		repo.save(product);
	}
	//search by id
	public Product get(Integer id) {
		return repo.findById(id).get();
}
	public List<Product> getByKeyword(String keyword){
		  return repo.findByKeyword(keyword); 
	}
	//delete record
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	 	 
}

	
