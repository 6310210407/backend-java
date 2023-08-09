package com.example.demo.controller;

import java.lang.foreign.Linker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	
	private static final Employee Employee = null;

	@Autowired
	EmployeeRepository employeeRepository;
	
	private List<Employee> data = new ArrayList<Employee>();

	@GetMapping("/employee")
	public ResponseEntity<Object> getEmployees(){
		
		try {
			List<Employee> employees = employeeRepository.findAll();
			
			return new ResponseEntity<>(employees,HttpStatus.OK);
			
		} catch (Exception e) {
		   
			return new ResponseEntity<>("Internal sever erorr", HttpStatus.INTERNAL_SERVER_ERROR );
		}
		
		
	}
       
	@PostMapping("/employee")
	public Employee adddEmployee(@RequestBody Employee body) {
		
				return employeeRepository.save(body);
			
		}
		 
			
	    @GetMapping("/employee/{employeeID}")
	    public Optional<Employee> getEmployeeDetail(@PathVariable Integer employeeID) {
	    	
	    	Optional<Employee> employee =employeeRepository.findById(employeeID);
	    	
	    	
	    		return employee;
			
	    }

	@PutMapping("employee/{employeeID}")
	public Employee updatEmployee(@PathVariable Integer employeeID ,@RequestBody Employee body) {
		
         Optional<Employee> employee =employeeRepository.findById(employeeID);
		
		 if (employee.isPresent()) {
		 employee.get().setFirstName(body.getFirstName());
	     employee.get().setLastName(body.getLastName());
	     employee.get().setSalary(body.getSalary());
	     employee.get().setEmployeeID(body.getEmployeeID());
	        
	        return employeeRepository.save(employee.get());
		}else {
			return null;
		}
		
	}

    @DeleteMapping("employee/{employeeID}")
    public String deleteEmployee(@PathVariable Integer employeeID) {
    	
    	Optional<Employee> employee =employeeRepository.findById(employeeID);
    	
    	if (employee.isPresent()) {
    	
    		employeeRepository.delete(employee.get());
    		
    		return "DELETE SUCSESS";
    	
    	}else {
    	
    	return "employee not found";
    	}
    
  }
}
    