package com.example.demo.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.repository.EmployeeRepository;

//http://localhost:8082/hello-->
@RestController
public class HelloWorldController {
	
	@Autowired
	EmployeeRepository empRepository;
	
	//GetMapping -> it is used to create GET REQUESTS for fetching data from server
	@GetMapping (path="/getAllEmployees")
	public List<Employee> getAllEmployee()
	{
		List<Employee>empList = empRepository.findAll();
		return empList;
	}
	//RequestParam -> Picking up values from the URL
	@GetMapping(path="/get/{id}")
	public Object getEmployeeById(@PathVariable int id)
	{
		Optional<Employee>emp=empRepository.findById(id);
		if(emp.isPresent())
			return emp;
		return "Employee "+id+"not found";
	}
	
	@PostMapping (path="/insertEmployee")
	public String insertEmployee(@RequestBody Employee empObj)
	{
		System.out.println(" Received Data "+empObj);
		empRepository.save(empObj);
		return "Record inserted successfully";
	}
	@PutMapping (path="/updateEmployee")
	public String updateEmployee(@RequestBody Employee empObj)
	{
		Optional<Employee> empObjOptional = empRepository.findById(empObj.getId());
		
		if(empObjOptional.isPresent())
		{
			Employee empObjToUpdate = empObjOptional.get();
			empObjToUpdate.setName(empObj.getName());
			empObjToUpdate.setDept(empObj.getDept());
			empObjToUpdate.setDesignation(empObj.getDesignation());
			empRepository.save(empObjToUpdate);
			return "Record updated successfully";
		}
		return "Unable to updated the record";
	}
	//https://localhost:8082/deleteRecord/101
	@DeleteMapping (path="/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		System.out.println("Given ID is: "+id);
		empRepository.deleteById(id);
		
		return "Record deleted successfully";
	}
}
