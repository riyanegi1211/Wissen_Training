package com.example.demo.controller;

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

import com.example.demo.Entity.Insurance;
import com.example.demo.repository.InsuranceRepository;

//http://localhost:8082/hello-->
@RestController
public class InsuranceController {
	
	@Autowired
	InsuranceRepository insuranceRepository;
	
	//GetMapping -> it is used to create GET REQUESTS for fetching data from server
	@GetMapping (path="/getAllInsurances")
	public List<Insurance> getAllInsurance()
	{
		List<Insurance>insuranceList = insuranceRepository.findAll();
		return insuranceList;
	}
	//RequestParam -> Picking up values from the URL
	@GetMapping(path="/get/{id}")
	public Object getInsuranceById(@PathVariable int policyId)
	{
		Optional<Insurance>person=insuranceRepository.findById(policyId);
		if(person.isPresent())
			return person;
		return "Person with "+policyId+"not found";
	}
	
	@PostMapping (path="/insertRecord")
	public String insertEmployee(@RequestBody Insurance personObj)
	{
		System.out.println(" Received Data "+personObj);
		insuranceRepository.save(personObj);
		return "Record inserted successfully";
	}
	@PutMapping (path="/updateRecord")
	public String updateRecord(@RequestBody Insurance personObj)
	{
		Optional<Insurance> recordObjOptional = insuranceRepository.findById(personObj.getId());
		
		if(recordObjOptional.isPresent())
		{
			Insurance recordObjToUpdate = recordObjOptional.get();
			recordObjToUpdate.setName(personObj.getName());
			recordObjToUpdate.setPolicyAmt(personObj.getPolicyAmt());
			recordObjToUpdate.setEmi(personObj.getEmi());
			insuranceRepository.save(recordObjToUpdate);
			return "Record updated successfully";
		}
		return "Unable to updated the record";
	}
	//https://localhost:8082/deleteRecord/101
	@DeleteMapping (path="/deleteRecord/{id}")
	public String deleteRecord(@PathVariable int id)
	{
		System.out.println("Given ID is: "+id);
		insuranceRepository.deleteById(id);
		
		return "Record deleted successfully";
	}
}
