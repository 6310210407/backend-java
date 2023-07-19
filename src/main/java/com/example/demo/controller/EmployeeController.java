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

import com.example.demo.model.Employee;

@RestController
public class EmployeeController {

	private List<Employee> data = new ArrayList<Employee>();

	@GetMapping("/employee")
	public List<Employee> getEmployees(){
		return data;
	}
       
	@PostMapping("/employee")
	public Employee adddEmployee(@RequestBody Employee body) {
		
		for(int i = 0; i < data.size(); i++)  {
			if (data.get(i).getEmployeeID() == body.getEmployeeID()) {
				return null;
			}
		}
		 
			
		data.add(body);
		return body;


       }
	    @GetMapping("/employee/{employeeID}")
	    public Employee getEmployeeDetail(@PathVariable Integer employeeID) {
	    	System.out.print("employeeid = "+employeeID);
	    	
	    	
	    	for(int i = 0; i < data.size(); i++)  {
				if (employeeID == data.get(i).getEmployeeID()) {
					return data.get(i);
				}
	    	}
	    	return null;
	    }

	@PutMapping("employee/{employeeID}")
	public Employee updatEmployee(@PathVariable Integer employeeID ,@RequestBody Employee body) {
		
		
    	for(int i = 0; i < data.size(); i++)  {
			if (employeeID == data.get(i).getEmployeeID()) {
				
				data.get(i).setFirstName(body.getFirstName());
				data.get(i).setLastName(body.getLastName());
				data.get(i).setSalary(body.getSalary());
				
				return data.get(i);
			}
         }
	
    	 return null;
	}

    @DeleteMapping("employee/{employeeID}")
    public String deleteEmployee(@PathVariable Integer employeeID) {
    	
    	for(int i = 0; i < data.size(); i++)  {
			if (employeeID == data.get(i).getEmployeeID()) {
				data.remove(i);
				return "delet Sucess";
			}
    	}
    	return "employee not found";
    }
  }
    