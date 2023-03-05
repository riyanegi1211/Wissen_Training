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


import com.example.demo.Entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {
  @Autowired
  StudentRepository studentRepository;
  
  @GetMapping(path="getAllDetails")
  public List<Student> getAllDetails()
  {
    List<Student>studentList = studentRepository.findAll();
    return studentList;
  }
  
  @GetMapping(path="/getDetailsById/{id}")
  public Object getDetailsById(@PathVariable int Roll_No)
  {
    Optional<Student>person=studentRepository.findById(Roll_No);
    if(person.isPresent())
      return person;
    return "Person with "+Roll_No+"not found";
  }
  
  @PostMapping (path="/insertRecord")
  public String insertRecord(@RequestBody Student personObj)
  {
    System.out.println(" Received Data "+personObj);
    studentRepository.save(personObj);
    return "Record inserted successfully";
  }
  
  @PutMapping (path="/updateRecord")
  public String updateRecord(@RequestBody Student personObj)
  {
    Optional<Student> recordObjOptional = studentRepository.findById(personObj.getRoll_No());
    
    if(recordObjOptional.isPresent())
    {
      Student recordObjToUpdate = recordObjOptional.get();
      recordObjToUpdate.setName(personObj.getName());
      recordObjToUpdate.setStandard(personObj.getStandard());
      recordObjToUpdate.setPercentage(personObj.getPercentage());
      studentRepository.save(recordObjToUpdate);
      return "Record updated successfully";
    }
    return "Unable to update the record";
  }
  
  @DeleteMapping (path="/deleteRecord/{id}")
  public String deleteRecord(@PathVariable int id)
  {
    System.out.println("Given ID is: "+id);
    studentRepository.deleteById(id);
    
    return "Record deleted successfully";
  }
}
