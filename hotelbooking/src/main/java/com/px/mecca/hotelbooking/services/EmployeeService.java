package com.px.mecca.hotelbooking.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.px.mecca.hotelbooking.enitity.AddressEntity;
import com.px.mecca.hotelbooking.enitity.EmployeeEntity;
import com.px.mecca.hotelbooking.repository.EmployeeRepository;
import com.px.mecca.hotelbooking.request.AddressRequest;
import com.px.mecca.hotelbooking.request.EmployeeRequest;
@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;
	public EmployeeEntity createOrUpdateEmployee(EmployeeRequest empRequest)
	{
		
		System.err.println(empRequest.getEmployeeId()+","+empRequest.getName()+","+empRequest.getPhonenumber());
	
		AddressRequest address=empRequest.getAddress();
		
		AddressEntity adressentity=new AddressEntity();
		adressentity.setState(address.getState());
		adressentity.setPincode(address.getPincode());
		adressentity.setCity(address.getCity());
		
	
		EmployeeEntity entity=new EmployeeEntity();
		entity.setEmailid(empRequest.getEmailid());
		entity.setName(empRequest.getName());
		entity.setPassword(empRequest.getPassword());
		entity.setPhonenumber(empRequest.getPhonenumber());
	   entity.setAddress(adressentity);
		
	    Optional<EmployeeEntity> employee = employeeRepository.findById(entity.getEmployeeId());
		 if(employee.isPresent())
	        {
	            EmployeeEntity newEntity = employee.get();
	        	newEntity.setEmailid(entity.getEmailid());
				newEntity.setName(entity.getName());
				newEntity.setPassword(entity.getPassword());
				newEntity.setPhonenumber(entity.getPhonenumber());
		
	            newEntity = employeeRepository.save(newEntity);	             
	            return newEntity;
	        } else {
	            entity = employeeRepository.save(entity);
	             
	            return entity;
	        }
    } 
	
	public List<EmployeeEntity> getAllEmployee()
	{
		List<EmployeeEntity> employeeList=employeeRepository.findAll();
		
		if(employeeList.size()>0)
		{
			return employeeList;
		}
		else
		{
			return new ArrayList<EmployeeEntity>();	
		}
	}
	
	public EmployeeEntity getParticularRecord(Integer id)
	{
		 Optional<EmployeeEntity> employee = employeeRepository.findById(id);
		
		 if(employee.isPresent())
		 {
				return employee.get();
		 }
		 else
		 {
			System.out.println("No Employee Record");
		 }
		 return employee.get();
	}
	public String deleteParticularRecord(Integer id)
	{
		 Optional<EmployeeEntity> employee =employeeRepository.findById(id);
		 
		 if(employee.isPresent())
		 {
			  employeeRepository.deleteById(id);
			  return "Deleted Succesfully";
		 }
		 else
		 {
			 System.out.println("No employee id matching in employee table.So i cant delete");
			 return "No employee id matching in employee table.So i cant delete";
		 }
	}
}
