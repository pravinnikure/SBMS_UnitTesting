package com.app.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name="student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	private Integer stdId;
	@Column(name="sname")
	
	//@NotNull(message = "stdname cannot be empty")
	@NotBlank(message = "Name should not be blank")
	private String stdName;
	@Column(name="sgen")
	private String stdGen;
	@Column(name="scourse")
	private String stdCourse;
	@Column(name="sadd")
	
	//Regular expression
	
	@NotBlank(message = "stdAdd cannot be blank")
	//@Pattern(regexp = "[A-Za-z0-9\\.\\s\\?\\.\\,\\]")
	private String stdAdd;
	public Student() {
		super();
	}
	public Student(Integer stdId, String stdName, String stdGen, String stdCourse, String stdAdd) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdGen = stdGen;
		this.stdCourse = stdCourse;
		this.stdAdd = stdAdd;
	}
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdGen() {
		return stdGen;
	}
	public void setStdGen(String stdGen) {
		this.stdGen = stdGen;
	}
	public String getStdCourse() {
		return stdCourse;
	}
	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}
	public String getStdAdd() {
		return stdAdd;
	}
	public void setStdAdd(String stdAdd) {
		this.stdAdd = stdAdd;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdGen=" + stdGen + ", stdCourse=" + stdCourse
				+ ", stdAdd=" + stdAdd + "]";
	}

	
	
}
