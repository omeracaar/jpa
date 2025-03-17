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
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dto =new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            Student dbStudent=optional.get();

            BeanUtils.copyProperties(dbStudent,dto);
        }
        return dto;
    }

    @Override
    public void deleteStudentById(Integer id) {
        Optional<Student> optional=studentRepository.findById(id);
		//DtoStudent dtoStudent=getStudentById(id);
        if (optional!=null){
            studentRepository.delete(optional.get());
        }else {
            System.out.println("student bulunamadi");
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        DtoStudent dto=new DtoStudent();

		Optional<Student> optional=studentRepository.findById(id);
        if (optional.isPresent()){
            Student dbStudent=optional.get();

            dbStudent.setFirstName(dbStudent.getFirstName());
            dbStudent.setLastName(dbStudent.getLastName());
            dbStudent.setBirthOfDate(dbStudent.getBirthOfDate());

            Student updatedStudent=studentRepository.save(dbStudent);

            BeanUtils.copyProperties(updatedStudent,dto);
            return dto;

        }else return null ;
    }


}
