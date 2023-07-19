package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

@RestController
public class ProductController {
	private List<Product> data = new ArrayList<Product>();

	@GetMapping("/product")
	public List<Product> getProduct(){
		return data;
	}
       
	@PostMapping("/product")
	public Product adddProduct(@RequestBody Product body) {
		
		for(int i = 0; i < data.size(); i++)  {
			if (data.get(i).getProductID() == body.getProductID()) {
				return null;
			}
		}
		 
			
		data.add(body);
		return body;


       }
	    @GetMapping("/product/{productID}")
	    public Product getProduct(@PathVariable Integer productID) {
	    	System.out.print("productID = "+productID);
	    	
	    	
	    	for(int i = 0; i < data.size(); i++)  {
				if (productID == data.get(i).getProductID()) {
					return data.get(i);
				}
	    	}
	    	return null;
	    }

	@PutMapping("/product/{productID}")
	public Product updatProduct(@PathVariable Integer productID ,@RequestBody Product body) {
		
		
    	for(int i = 0; i < data.size(); i++)  {
			if (productID == data.get(i).getProductID()) {
				
				data.get(i).setProductName(body.getProductName());
				data.get(i).setProductPrice(body.getProductPrice());
				data.get(i).setProductAmount(body.getProductAmount());
				data.get(i).setProductDetail(body.getProductDetail());
				
				return data.get(i);
			}
         }
	
    	 return null;
	}

    @DeleteMapping("/product/{productID}")
    public String deleteProduct(@PathVariable Integer productID) {
    	
    	for(int i = 0; i < data.size(); i++)  {
			if (productID == data.get(i).getProductID()) {
				data.remove(i);
				return "delet Sucess";
			}
    	}
    	return "product not found";
    }
}
