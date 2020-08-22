package com.university.FeeMS.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.FeeMS.dto.FeeDTO;
import com.university.FeeMS.entity.Fee;

@Repository
//@Transactional
public interface FeeRepository extends JpaRepository<Fee, Integer> {

	public Fee findBystudentid(int Id);
	
	public void save(FeeDTO fe);
}
