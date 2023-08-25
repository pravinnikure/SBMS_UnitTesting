package com.app.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.restapi.entity.Student;
import com.app.restapi.exceptions.StudentNotFoundException;
import com.app.restapi.impl.IStudentServiceImpl;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {

	@Autowired
	IStudentServiceImpl service;

	@PostMapping("/save")
	//@ApiOperation("Insert Student details")
	public ResponseEntity<String> saveStudent(@RequestBody @Valid Student student) {

		Integer id = service.saveStudent(student);
		return new ResponseEntity<String>("Student'" + id + "'create", HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = service.getAllStudent();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchOneStudent(@PathVariable Integer id)

	{
		ResponseEntity<?> response = null;
		try {
			Student s1 = service.getOneStudent(id);
			response = new ResponseEntity<Student>(s1, HttpStatus.OK);
		} catch (StudentNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
		}

		return response;

	}
	
	//@ApiIgnore
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		ResponseEntity<String> response = null;
		try {

			service.deleteStudent(id);
		
			response = new ResponseEntity<String>("Student'" + id+ "' deleted Successfully ", HttpStatus.OK);

		} catch (StudentNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
		}
		return response;
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(@RequestBody Student student)
	{
		ResponseEntity<String> response = null;
		try {

			service.updateStudent(student);
		
			response = new ResponseEntity<String>("Student'" + student.getStdId() + "' updated Successfully ", HttpStatus.OK);

		} catch (StudentNotFoundException snfe) {
			snfe.printStackTrace();
			throw snfe;
			//response = new ResponseEntity<String>(snfe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}

}
