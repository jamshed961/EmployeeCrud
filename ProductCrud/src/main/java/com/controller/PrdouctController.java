package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.Dao.ProductDao;
import com.entity.Product;

@Controller
public class PrdouctController {
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productDao.getProd();
		m.addAttribute("product", products);
		return "index";
	}
	
	@RequestMapping("add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	@RequestMapping("/handle-product")
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		RedirectView  redirectView = new RedirectView();
		System.out.println(product);
		Product save = productDao.saveOrUpdate(product);
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("delete/{pid}")
	public RedirectView deleteProduct(@PathVariable int pid, HttpServletRequest request ) {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
	}
	
	// here first get the product based on id and then update it
	@RequestMapping("/update{pid}")
	public String updateProduct(@PathVariable int id, Model m) {
		Product prodById = productDao.getProdById(id);
		m.addAttribute("product", prodById);
		
		return "update_form";
		
	}

}
