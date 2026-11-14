package com.example.mensware.Controller;

import com.example.mensware.Entity.Product;
import com.example.mensware.Repository.ProductRepository;


import com.example.mensware.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Stack;

@RestController
@RequestMapping("/MansWare")
public class ProductController {

    private final ProductRepository repository;
   public final ProductService productservice;
    public ProductController(ProductRepository repository,ProductService productservice){

        this.repository=repository;
        this.productservice=productservice;
    }
//
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){

        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){

       repository.save(product);
       return "Add Items and products";

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        if (!repository.existsById(id)){
            return ResponseEntity. status(HttpStatus.NOT_FOUND).body("product not found");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("product is deleted");
    }
    @GetMapping("/stock")
    public Map<String, Object> getTotalStock(){
        return productservice.getTotalStock();

    }


    @GetMapping("/test")
    public String test() {

        return "MansWare API Working!";
    }
}
