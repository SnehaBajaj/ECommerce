package com.getmyparking.ecommerce.service;

import com.getmyparking.ecommerce.model.Product;
import com.getmyparking.ecommerce.repository.ProductRepository;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.getProducts().put(product.getId(), product);
    }

    public int countProducts() {
        return productRepository.getProducts().size();
    }

    public boolean doesProductExist(int productId) {
        return productRepository.getProducts().get(productId) != null;
    }

    public Product findProduct(int productId) {
        return productRepository.getProducts().get(productId);
    }

    public void updateProduct(int productId, String name, String description, double price) {
        Product productToBeUpdated = productRepository.getProducts().get(productId);
        if (name != null) {
            productToBeUpdated.setName(name);
        }
        if (description != null) {
            productToBeUpdated.setDescription(description);
        }
        if (price > Double.MIN_VALUE) {
            productToBeUpdated.setPrice(price);
        }
    }

    public void deleteProduct(int productId) {
        productRepository.getProducts().remove(productId);
    }

    public void displayAllProducts() {
        System.out.println(productRepository.getProducts());
    }
}
