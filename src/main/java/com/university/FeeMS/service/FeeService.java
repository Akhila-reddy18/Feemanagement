package com.university.FeeMS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import javax.naming.InvalidNameException;
import javax.validation.Validator;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.FeeMS.dto.FeeDTO;

import com.university.FeeMS.entity.Fee;

import com.university.FeeMS.repository.FeeRepository;



@Service
public class FeeService {
	private static final Logger logger = LoggerFactory.getLogger(FeeService.class);
	@Autowired
	FeeRepository feerepo;
	
//	@Autowired
//	FeeDTO feeDTO;
	
	
	public FeeDTO getBills(Integer studentid) {
		Fee fee =feerepo.findBystudentid(studentid);
		FeeDTO dto =FeeDTO.valueOf(fee);
		return dto ;
	}


	public String add(FeeDTO fdto) {
		Fee fee =feerepo.findBystudentid(fdto.getStudentid());
		String msg=null;
		if(fee==null) {
			Fee fe=fdto.createEntity();
			feerepo.save(fe);
			 msg="added";
		}
		else {
			msg= "already exist";

		}
		return msg;
	}

	public String payBill(Integer studentid) {
		Fee fee=feerepo.findBystudentid(studentid);
		String msg=null;
		if(fee.getPendingdue()>0) {
			fee.setPendingdue(0.0);
			fee.setExamfee(0.0);
			fee.setLabfee(0.0);
			fee.setSportsfee(0.0);
			fee.setTutionfee(0.0);
			fee.setYogafee(0.0);
			feerepo.saveAndFlush(fee);
			msg="Paid successfully";
		}
		else {
			msg="No due to pay";
		}
		
		return msg;
	}


}
