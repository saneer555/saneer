package com.saneer.SpringBoot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saneer.SpringBoot.enity.Product;
import com.saneer.SpringBoot.repository.ProductRepository;

@Service
public class ProductServices {
	
	private ProductRepository productrepo;

	@Autowired
	public ProductServices(ProductRepository productrepo) {
		super();
		this.productrepo = productrepo;
	}
	
	public List<Product>getAllProducts(){
		 return productrepo.findAll();
	}
	
	public Product getById(Long id) {
		return productrepo.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
	}
	
	public Product createProduct(Product product) {
		return productrepo.save(product);
	}
	
	public Product updateProduct(Long id, Product product) {
		System.out.println("before"+ product);
		Product exProduct = getById(id);
		System.out.println("after"+exProduct);
		exProduct.setBrand(product.getBrand());
		exProduct.setPrice(product.getPrice());
		System.out.println("Ater the Update"+exProduct);
		return productrepo.save(exProduct);
	}
	
	public void deleteById(Long id) {
	  productrepo.deleteById(id);
	}

}
