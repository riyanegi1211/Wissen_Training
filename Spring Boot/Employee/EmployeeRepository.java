package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	@Query(value="select * from employee order by id", nativeQuery=true)
	public List<Employee>getAllEmployeesById();
}
