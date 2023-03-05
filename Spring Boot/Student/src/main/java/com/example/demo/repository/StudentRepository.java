package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	@Query(value="select * from Student order by Roll_No",nativeQuery=true)
	public List<Student>getAllDetails();
	
	@Query(value="select * from Student where Roll_No = ?1", nativeQuery=true)
	public Student getDetailsById(int id);
	
	@Query(value="Delete * from Student where Roll_No = ?1", nativeQuery=true)
	public Student deleteRecord(int id);
}
