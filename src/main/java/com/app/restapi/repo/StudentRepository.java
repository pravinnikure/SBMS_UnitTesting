package com.app.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
