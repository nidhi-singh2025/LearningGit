package com.practice.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practice.api.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
