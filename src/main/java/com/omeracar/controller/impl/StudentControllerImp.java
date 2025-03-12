package com.omeracar.controller.impl;

import com.omeracar.controller.IStudentController;
import com.omeracar.entities.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImp implements IStudentController {

    //Normalde DTO kullanılır
    @PostMapping(path = {"/save"})
    @Override
    public Student saveStudent(@RequestBody Student student){
        return null;
    }

}
