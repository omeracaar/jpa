package com.omeracar.repository;

import com.omeracar.dto.DtoStudent;
import com.omeracar.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {



}
