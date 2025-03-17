package com.omeracar.services;

import com.omeracar.dto.DtoStudent;
import com.omeracar.dto.DtoStudentIU;
import com.omeracar.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IStudentService {


    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();
    public Student getStudentById(Integer id);

    public void deleteStudentById(Integer id);
    public Student updateStudent(Integer id, Student updatedStudent);

}
