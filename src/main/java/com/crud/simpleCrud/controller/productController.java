package com.crud.simpleCrud.controller;

import com.crud.simpleCrud.entity.product;
import com.crud.simpleCrud.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {
    @Autowired
    private productService productService;
    @PostMapping("/addProduct")
public product addProduct(@RequestBody product product){
    return productService.saveProduct(product);

}
@PostMapping("/addProducts")
public List<product> addProducts(@RequestBody List<product> products){
    return productService.saveProducts(products);

}
@GetMapping("/getProduct/{id}")
    public product getProduct(@PathVariable Integer id){
        return productService.getProduct(id);

}
    @GetMapping("/getProducts")
    public List<product> getProduct(){
        return productService.getProducts();

    }
    @PutMapping("/update")
    public product updateProduct(@RequestBody product product){
        return productService.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
}




}
