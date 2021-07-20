package com.atguigu.crowd.entity;

import java.util.List;
import java.util.Map;

public class Student {
	
	private Integer studId;
	private String stuName;
	private Address address;
	private List<Subject> subjectList;
	private Map<String, String> map;
	public Student(Integer studId, String stuName, Address address,
			List<Subject> subjectList, Map<String, String> map) {
		super();
		this.studId = studId;
		this.stuName = stuName;
		this.address = address;
		this.subjectList = subjectList;
		this.map = map;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", stuName=" + stuName
				+ ", address=" + address + ", subjectList=" + subjectList
				+ ", map=" + map + "]";
	}
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	

}
