package com.example.sop_final_63070121.repository;

import com.example.sop_final_63070121.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public boolean addProduct(Product product){
        try{
            repository.insert(product);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean updateProduct(Product product){
        try{
            repository.save(product);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean deleteProdcut(Product product){
        try{
            repository.delete(product);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public List<Product> getAllProduct(){
        try{
            return repository.findAll();
        }catch (Exception ex){
            return null;
        }
    }
}
