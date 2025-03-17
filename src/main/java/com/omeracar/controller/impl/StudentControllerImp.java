package com.omeracar.controller.impl;

import com.omeracar.controller.IStudentController;
import com.omeracar.dto.DtoStudent;
import com.omeracar.dto.DtoStudentIU;
import com.omeracar.entities.Student;
import com.omeracar.services.IStudentService;
import com.omeracar.services.impl.StudentServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImp  implements IStudentController {

    @Autowired
    private IStudentService studentService;


    //Normalde DTO kullanilir
    @PostMapping(path = "/save")
    @Override
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "list/{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

	@DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public Student updateStudent(@PathVariable(name = "id") Integer id , @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }


}
