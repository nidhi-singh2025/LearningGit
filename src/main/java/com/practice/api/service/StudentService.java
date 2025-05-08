package com.practice.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.practice.api.entity.Student;
import com.practice.api.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	public Student save(Student student) {
		return studentRepo.save(student);
	}

	public Optional<Student> getById(int id) {
		return studentRepo.findById(id);
	}

	public Optional<Student> delete(int id) {
		Optional<Student> stu = studentRepo.findById(id);
		stu.ifPresent(s -> studentRepo.deleteById(id));
		return stu;
	}

	public Student update(int id, Student student) {
		Optional<Student> existing = studentRepo.findById(id);

		if (existing.isPresent()) {
			Student s = existing.get();
			s.setName(student.getName());
			s.setEmail(student.getEmail());
			s.setAge(student.getAge());

			return studentRepo.save(s); 
		} else {
			return null; 
		}
	}

}
