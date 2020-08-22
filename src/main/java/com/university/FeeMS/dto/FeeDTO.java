package com.university.FeeMS.dto;

import javax.persistence.Id;

import com.university.FeeMS.entity.Fee;

public class FeeDTO {
	
	Integer studentid;
	Double tutionfee;
	Double examfee;
	Double labfee;
	Double yogafee;
	Double sportsfee;
	Double pendingdue;
	
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public Double getTutionfee() {
		return tutionfee;
	}
	public void setTutionfee(Double tutionfee) {
		this.tutionfee = tutionfee;
	}
	public Double getExamfee() {
		return examfee;
	}
	public void setExamfee(Double examfee) {
		this.examfee = examfee;
	}
	public Double getLabfee() {
		return labfee;
	}
	public void setLabfee(Double labfee) {
		this.labfee = labfee;
	}
	public Double getYogafee() {
		return yogafee;
	}
	public void setYogafee(Double yogafee) {
		this.yogafee = yogafee;
	}
	public Double getSportsfee() {
		return sportsfee;
	}
	public void setSportsfee(Double sportsfee) {
		this.sportsfee = sportsfee;
	}
	public Double getPendingdue() {
		return pendingdue;
	}
	public void setPendingdue(Double pendingdue) {
		this.pendingdue = pendingdue;
	}

	public FeeDTO() {
		super();
	}
	// Converts Entity into DTO
	public static FeeDTO valueOf(Fee fee) {
		FeeDTO feeDTO= new FeeDTO();
		feeDTO.setStudentid(fee.getStudentid());
		feeDTO.setExamfee(fee.getExamfee());
		feeDTO.setLabfee(fee.getLabfee());
		feeDTO.setPendingdue(fee.getPendingdue());
		feeDTO.setSportsfee(fee.getSportsfee());
		feeDTO.setTutionfee(fee.getTutionfee());
		feeDTO.setYogafee(fee.getTutionfee());
		
		return feeDTO;
	}
	public Fee createEntity() {
		Fee f=new Fee();
		f.setStudentid(this.getStudentid());
		f.setExamfee(this.getExamfee());
		f.setLabfee(this.getLabfee());
		f.setSportsfee(this.getSportsfee());
		f.setTutionfee(this.getTutionfee());
		f.setYogafee(this.getYogafee());
		f.setPendingdue(this.getExamfee()+this.getLabfee()+this.getSportsfee()+this.getTutionfee()+this.getYogafee());
		return f;
	}
		
	
	
}
