package com.saneer.SpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saneer.SpringBoot.Services.ProductServices;
import com.saneer.SpringBoot.enity.Product;

@RestController
public class ProductController {
	private ProductServices productserv;

	@Autowired
	public ProductController(ProductServices productserv) {
		super();
		this.productserv = productserv;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>>getAllproducts(){
		List<Product> allProducts = productserv.getAllProducts();
		return ResponseEntity.ok(allProducts);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product>getByid(@PathVariable Long id){
		    Product byId = productserv.getById(id);
		    return ResponseEntity.ok(byId);
	}
	@PostMapping("/create")
	public ResponseEntity<Product>createproduct(@RequestBody Product product){
		  Product createProduct = productserv.createProduct(product);
		  return ResponseEntity.ok(createProduct);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product>updateproduct(@RequestBody Product product , @PathVariable Long id){
		Product updateProduct = productserv.updateProduct(id, product);
		return ResponseEntity.ok(updateProduct);
	}
	
	 @DeleteMapping("/delete/{id}")
	public ResponseEntity<Void>deleteproduct(@PathVariable Long id){
		productserv.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
