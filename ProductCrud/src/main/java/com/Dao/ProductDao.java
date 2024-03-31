package com.Dao;

import java.util.List;

import com.entity.Product;

public interface ProductDao {
	
	public Product saveOrUpdate(Product product);
	
	public List <Product> getProd();
	
	public Product getProdById(int id);
	
	public void delete(int id);
	
	public  void update(Product product) ;

}
