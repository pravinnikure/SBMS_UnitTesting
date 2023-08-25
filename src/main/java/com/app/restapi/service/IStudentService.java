package com.app.restapi.service;

import java.util.List;

import com.app.restapi.entity.Student;

public interface IStudentService 
{
	
	Integer saveStudent(Student student);
	
	List<Student> getAllStudent();
	
	Student getOneStudent(Integer id);
	
	void deleteStudent(Integer id);
	
	void updateStudent(Student student);

}
