package com.example.demo.responseentity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/students")
	public ResponseEntity<ApiStatus<List<Student>>> getAllStudents() {
		List<Student> list = studentRepository.getAllStudents();
		ApiStatus<List<Student>> apiStatus = new ApiStatus<List<Student>>(HttpStatus.OK, "SUCCESS", "LIST OF STUDENTS ",
				list);
		return new ResponseEntity<ApiStatus<List<Student>>>(apiStatus, HttpStatus.OK);
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<ApiStatus<List<Student>>> getStudent(@PathVariable("id") int id) {
	List<Student> std = studentRepository.getStudentByid(id);
		ApiStatus<List<Student>> apiStatus = new ApiStatus<List<Student>>(
			HttpStatus.OK, "SUCCESS", "STUDENT BY ID",
				std);
		return new ResponseEntity<ApiStatus<List<Student>>>(apiStatus, HttpStatus.OK);
	}

	@PostMapping("/join")
	public ResponseEntity<ApiStatus<Student>> saveStudent(@RequestBody Student student) {
		Student updated = studentRepository.saveStudent(student);
		ApiStatus<Student> apiStatus = new ApiStatus<Student>(HttpStatus.OK, "UPDATE", " STUDENT WILL JOINED", updated);
		return new ResponseEntity<ApiStatus<Student>>(apiStatus, HttpStatus.OK);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<ApiStatus<Student>> deleteStudent(@PathVariable int id, Student std) {
		Student student = studentRepository.deleteStudent(id, std);
		ApiStatus<Student> apiStatus = new ApiStatus<Student>(HttpStatus.OK, "DELETE", " STUDENT WILL DELETED BY ID",
				student);
		return new ResponseEntity<ApiStatus<Student>>(apiStatus, HttpStatus.OK);
	}


	
}
