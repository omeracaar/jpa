package com.omeracar.controller;

import com.omeracar.dto.DtoStudent;
import com.omeracar.dto.DtoStudentIU;
import com.omeracar.entities.Student;

import java.util.List;

public interface IStudentController{


    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Integer id);
    public void deleteStudentById(Integer id);
    public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU);
}
