package com.crud.simpleCrud.service;

import com.crud.simpleCrud.entity.product;
import com.crud.simpleCrud.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    public product saveProduct(product product){
        return productRepository.save(product);
    }
    public List<product> saveProducts(List<product> products){
        return productRepository.saveAll(products);
    }
    public List<product> getProducts(){
        return productRepository.findAll();
    }
    public product getProduct(int id){
        return productRepository.findById(id).orElse(null);
    }
    public product getProduct(String name){
        return productRepository.findByName(name);
    }
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "product deleted"+ id;
    }
    public product updateProduct(product product){
        product existingProduct= productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

}
