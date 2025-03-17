package com.omeracar.services.impl;

import com.omeracar.dto.DtoStudent;
import com.omeracar.dto.DtoStudentIU;
import com.omeracar.entities.Student;
import com.omeracar.repository.StudentRepository;
import com.omeracar.services.IStudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response= new DtoStudent();
        Student student=new Student();
        BeanUtils.copyProperties(dtoStudentIU,student);

        Student dbStudent=studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent,response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> studentList=studentRepository.findAll();
		for(Student student:studentList){
            DtoStudent dto=new DtoStudent();
            BeanUtils.copyProperties(student,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        return null;
    }

    @Override
    public void deleteStudentById(Integer id) {
		Student dbStudent=getStudentById(id);
        if (dbStudent!=null){
            studentRepository.deleteById(id);
        }else {
            System.out.println("student bulunamadi");
        }
    }

    @Override
    public Student updateStudent(Integer id, Student updatedStudent) {
        Student dbStudent=getStudentById(id);
        if (dbStudent!=null){
            dbStudent.setFirstName(updatedStudent.getFirstName());
            dbStudent.setLastName(updatedStudent.getLastName());
            dbStudent.setBirthOfDate(updatedStudent.getBirthOfDate());

            return studentRepository.save(dbStudent);
        }
        return null;
    }


}
