package com.omeracar.controller;

import com.omeracar.dto.DtoStudent;
import com.omeracar.dto.DtoStudentIU;
import com.omeracar.entities.Student;

import java.util.List;

public interface IStudentController{


    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudents();
    public Student getStudentById(Integer id);
    public void deleteStudentById(Integer id);
    public Student updateStudent(Integer id,Student updateStudent);
}
