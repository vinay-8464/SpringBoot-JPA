package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentServiceImpl;

@RestController
@RequestMapping("/entries")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	//Get Mapping
	@GetMapping("/")
	public List<Student> findAllEntries() {
		List<Student> entriesList= studentService.findAllEntry();
		return entriesList;
	}
	
	@GetMapping("/{id}")
	public Student getSingleStud(@PathVariable("id") Long id) {
	 	Student getSingleEntry= studentService.findById(id);
		return getSingleEntry;
	}
	
	//Post Mapping
	@PostMapping("/")
	public Student insertStud(@RequestBody Student student) {
		Student savedEntry= studentService.saveStudent(student);
		return savedEntry;
	}
	
//	//we can also used it for..updating
	@PostMapping("/{id}")	//we can also use patchMapping
	public Student updateParticularColVal(@PathVariable("id") Long id,@RequestBody Student student) {
		
		Student entry= studentService.findById(id);
		
		String firstName= student.getFirstname();
		String lastName= student.getLastname();
		
		if(firstName!=null && firstName.length() > 0) {
			entry.setFirstname(firstName);
		}
		if(lastName!= null && lastName.length() > 0) {
			entry.setLastname(lastName);
		}
		Student updatedEntry= studentService.updateStudent(entry);
		return updatedEntry;
	}
	
	//Put Mapping
	@PutMapping("/")
	//you must specify all column details in JSON format in POSTMAN
	public Student updateStud(@RequestBody Student student) {
		Student updatedStudent= studentService.updateStudent(student);
		return updatedStudent;
	}
	
//	@PutMapping("/{id}")
//	//Here we specify "id in url" and other columns in "Reuestbody" in POSTMAN
//	public Student updateStud(@PathVariable Long id,@RequestBody Student student) {
//		Student entry1= studentService.findById(id);
//		entry1.setFirstname(student.getFirstname());
//		entry1.setLastname(student.getLastname());
//		entry1.setId(student.getId());
//		
//		Student updatedStudent= studentService.updateStudent(entry1);
//		return updatedStudent;
//	}
	
	@PutMapping("/{id}")
	//Here we specify "id in url" and other columns in "Reuestbody" in POSTMAN
	public Student updateSingleCol(@PathVariable Long id,@RequestBody Student student) {
		Student entry1= studentService.findById(id);
		String firstName= student.getFirstname();
		String lastName= student.getLastname();
		
		if(firstName!=null && firstName.length() > 0) {
			entry1.setFirstname(firstName);
		}
		if(lastName!= null && lastName.length() > 0) {
			entry1.setLastname(lastName);
		}
		Student updatedEntry= studentService.updateStudent(entry1);
		return updatedEntry;
	}
	
	//Delete Mapping
	@DeleteMapping("/{id}")
	public void deleteStud(@PathVariable("id") Long id) {
		//Here we can't delete by id..so we need to pass the object of that id
		Student getSingleEntry= studentService.findById(id);
		studentService.deleteStudent(getSingleEntry);
	}	
}