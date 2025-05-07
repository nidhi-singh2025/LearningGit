package com.practice.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.practice.api.entity.Student;
import com.practice.api.repo.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Optional<Student> getById(int id) {
        return repository.findById(id);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
    
}
