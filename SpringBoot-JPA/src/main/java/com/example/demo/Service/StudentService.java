package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;

@Service
public interface StudentService {
	
	public Student saveStudent(Student student);
	public Student updateStudent(Student student);
	public void deleteStudent(Student student);
	public Student findById(Long id);
	public List<Student> findAllEntry();
	
}