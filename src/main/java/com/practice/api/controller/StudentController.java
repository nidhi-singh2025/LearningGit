package com.practice.api.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.api.entity.Student;
import com.practice.api.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentServ;

	@GetMapping("get/data")
	public List<Student> getAll() {
		return studentServ.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable int id) {
		return studentServ.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/create/data")
	public Student create(@RequestBody Student student) {
		return studentServ.save(student);
	}

	@PutMapping("/{id}")
	public Student update(@PathVariable int id, @RequestBody Student student) {
		return studentServ.update(id,student);
	}

	@DeleteMapping("/{id}")
	public Optional<Student> delete(@PathVariable int id) {
		return studentServ.delete(id);
	}

}
