package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	
	private List<Student> data =  new ArrayList<Student>();
		
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return data;
	}

	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student body) {
		
		return body;
	}
	
	 @GetMapping("/student/{studentID}")
	    public Student getStudent(@PathVariable Integer studentID) {
	    	System.out.print("stuudentID = "+studentID);
	    	
	    	
	    	for(int i = 0; i < data.size(); i++)  {
				if (studentID == data.get(i).getStudentID()) {
					return data.get(i);
				}
	    	}
	    	return null;
	    }
	
		
	 @PutMapping("student/{studentID}")
		public ResponseEntity<Object>  updatEmployee(@PathVariable Integer employeeID ,@RequestBody Employee body) {
			
			try {
				
				Optional<Student> employee =student.findById(studentID);
				 	
				 if (student.isPresent()) {
				;
			     student.get().setName(body.getName());
			     student.get().setEmail(body.getEmail());
			    
			      
			     student.save(body);
			     return new ResponseEntity<>(student,HttpStatus.OK);
				}else 
					return new ResponseEntity<>("Student not found", HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				return new ResponseEntity<>("Internal sever erorr", HttpStatus.INTERNAL_SERVER_ERROR );
			}
			
	       
			}

	    @DeleteMapping("student/{studentID}")
	    public ResponseEntity<Object> deleteEmployee(@PathVariable Integer employeeID) {
	    	
	    	try {
	    		Optional<Employee> student =student.findById(employeeID);
	        	
	        	if (student.isPresent()) {
	        		student.delete(employee.get());
	        		
	        		return new ResponseEntity<>("DELETE SUCSESS",HttpStatus.OK);
	        	
	        	}else 
	        		return new ResponseEntity<>("Student not found", HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				return new ResponseEntity<>("Internal sever erorr", HttpStatus.INTERNAL_SERVER_ERROR );
			}
	    	
	    	}
	    
	  

	    
	
	

}

