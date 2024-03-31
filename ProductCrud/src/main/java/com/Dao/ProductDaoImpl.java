package com.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.entity.Product;

import jakarta.transaction.Transactional;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
	private HibernateTemplate hibernateTemplate;

    @Transactional
	@Override
	public Product saveOrUpdate(Product product) {
		Product p = (Product) hibernateTemplate.save(product);
		return p;
	}

	@Override
	public List<Product> getProd() {
		List<Product> list = this.hibernateTemplate.loadAll(Product.class);
		return list;
	}

	@Override
	public Product getProdById(int id) {
		Product product = this.hibernateTemplate.get(Product.class, id);
		return product;
	}

	@Transactional
	@Override
	public void delete(int id) {
		Product product = hibernateTemplate.get(Product.class, id);
		            this.hibernateTemplate.delete(product);

	}
	
    @Transactional
	@Override
	public void update(Product product) {
           this.hibernateTemplate.update(product);
	}

	
}
