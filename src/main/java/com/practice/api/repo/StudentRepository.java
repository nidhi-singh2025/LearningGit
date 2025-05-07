package com.practice.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practice.api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
