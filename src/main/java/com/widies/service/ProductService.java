package com.widies.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.widies.entity.Product;
import com.widies.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Iterable<Product> findAll() {
        return repo.findAll();
    }

    public void addProduct(Product product) {
        repo.save(product);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }

    public Optional<Product> findById(long id) {
        return repo.findById(id);
    }

    public void updateProduct(Product product) {
        repo.save(product);
    }
}
