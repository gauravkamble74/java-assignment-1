package com.npci.assignment.service;

import java.util.List;
import java.util.Map;
import com.npci.assignment.bean.Product;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getProducts();
    Map<String, Object> generateBills();
	void deleteProduct(String productId);
}
