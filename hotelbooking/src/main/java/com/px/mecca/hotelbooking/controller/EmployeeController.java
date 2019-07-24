package com.px.mecca.hotelbooking.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.px.mecca.hotelbooking.enitity.EmployeeEntity;
import com.px.mecca.hotelbooking.request.EmployeeRequest;
import com.px.mecca.hotelbooking.services.EmployeeService;

@RestController

public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	@PostMapping("/CreateEmployee") 
	 public ResponseEntity<EmployeeEntity> createorUpdateEmployee(@Valid @RequestBody EmployeeRequest employee)
	 {
		
		 EmployeeEntity created=employeeService.createOrUpdateEmployee(employee);
	     return new ResponseEntity<EmployeeEntity>(created, new HttpHeaders(), HttpStatus.OK);
	 }
	@GetMapping("/SelectAllEmployee")
	 public ResponseEntity<List<EmployeeEntity>> getAllEmployee() 
	{
		List<EmployeeEntity> listOfEmployee=employeeService.getAllEmployee();
	
	     return new ResponseEntity<List<EmployeeEntity>>(listOfEmployee, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/getRecord/{id}")
		public ResponseEntity<EmployeeEntity> getParticularRecord(@Valid @PathVariable(required = false) @NotNull(message="Please provide id correctly") @Size(max=1, message="pleaze give 2 value")  Integer id )
		{
		System.err.println("id:::"+id);

		 EmployeeEntity getParticularRecord=employeeService.getParticularRecord(id);

	     return new ResponseEntity<EmployeeEntity>(getParticularRecord, new HttpHeaders(), HttpStatus.OK);

		}
	@DeleteMapping("/deleteRecord/{id}")
	public String deleteParticularRecord(@PathVariable("id") Integer id)
	{
       String reponse=employeeService.deleteParticularRecord(id);
	  return reponse;
	}
	

}
