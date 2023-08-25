package com.app.restapi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.restapi.entity.Student;
import com.app.restapi.exceptions.StudentNotFoundException;
import com.app.restapi.repo.StudentRepository;
import com.app.restapi.service.IStudentService;

@Service
public class IStudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Integer saveStudent(Student student) {
		Integer id = studentRepository.save(student).getStdId();
		return id;
	}

	
	public List<Student> getAllStudent() {
		List<Student> list =  studentRepository.findAll();
		return list;
	}

	
	public Student getOneStudent(Integer id) {
		return studentRepository.findById(id).
				orElseThrow(()-> new StudentNotFoundException("Student'"+id+"' Not Exist"));
	}

	
	public void deleteStudent(Integer id) {
			studentRepository.delete(getOneStudent(id));

	}

	
	public void updateStudent(Student student) {
		if(student.getStdId()== null || !studentRepository.existsById(student.getStdId()))
		{
			throw new StudentNotFoundException("Student'"+student.getStdId()+"' Not Exist");
		}
		else
		{
				studentRepository.save(student);
		}

	}

}
