package com.npci.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.assignment.bean.Product;
import com.npci.assignment.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Product added successfully");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/checkout")
    public ResponseEntity<Map<String, Object>> checkout() {
        Map<String, Object> billDetails = productService.generateBills();
        return ResponseEntity.status(HttpStatus.OK).body(billDetails);
    }
    
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
    	productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product deleted successfully");      
    }

}
