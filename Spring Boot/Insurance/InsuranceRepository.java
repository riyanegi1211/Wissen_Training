package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Insurance;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<Insurance,Integer>{
	@Query(value="select * from Insurance order by PolicyId",nativeQuery=true)
	public List<Insurance>getAllInsuranceById();

}
