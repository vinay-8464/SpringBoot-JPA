package com.example.demo.Repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}