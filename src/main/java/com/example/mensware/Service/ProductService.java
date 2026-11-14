package com.example.mensware.Service;

import com.example.mensware.Entity.Product;
import com.example.mensware.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service

public class ProductService {
    private final ProductRepository repositoery;
    //private final ProductService productservice;

    public ProductService(ProductRepository repository){
        this.repositoery=repository;
        //this.productservice=productservice;
    }

    public Product addproduct(Product product){
        return repositoery.save(product);
    }
     public void deleteProduct(int id){

        repositoery.deleteById(id);
     }

    public Map<String, Object> getTotalStock(){
        List<Product> products=repositoery.findAll();
        Map<String,Integer> ShirtSizes=products.stream()
                .filter(p->"SHIRT".equalsIgnoreCase(p.getCategory()))
                .collect(Collectors.groupingBy(
                        Product::getSize,
                        LinkedHashMap::new,
                        Collectors.summingInt(Product::getStock)
                        ));

        Map<String,Integer> PantSizes=products.stream()
                .filter(p->"PANT".equalsIgnoreCase(p.getCategory()))
                .collect(Collectors.groupingBy(
                        Product::getSize,
                        LinkedHashMap::new,
                        Collectors.summingInt(Product::getStock)
                ));

        int ShirtStock =products.stream()
                .filter(p->"SHIRT".equalsIgnoreCase(p.getCategory()))
                .mapToInt(Product::getStock)
                .sum();
        int PantStock=products.stream()
                .filter(p->"PANT".equalsIgnoreCase(p.getCategory()))
                .mapToInt(Product::getStock)
                .sum();

        Map<String,Object> resutl= new LinkedHashMap<>();
        resutl.put("Shirt Stock",ShirtStock);
        resutl.put("Shirt size based stock",ShirtSizes);
        resutl.put("Pant Stock",PantStock);
        resutl.put("Pant size based stock",PantSizes);
        resutl.put("Total Stock",ShirtStock+PantStock);
        return resutl;


    }

}
