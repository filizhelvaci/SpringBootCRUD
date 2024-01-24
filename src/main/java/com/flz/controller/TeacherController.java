package com.flz.controller;

import com.flz.model.Teacher;
import com.flz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//  http://localhost:8090/api/v1/hello

@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    @Autowired
    TeacherService teacherService;


    // GET - SELECT * from where
    //  http://localhost:8090/api/v1/teacher/1
    @GetMapping("/teacher/{id}")
    public Teacher getTeacher(@PathVariable(name="id") Long id) {
        return teacherService.getOneTeacher(id);
    }

    // GET - SELECT * FROM
    //  http://localhost:8090/api/v1/teachers
    @GetMapping("/teachers")
    public List<Teacher> getTeacher() {
        return teacherService.getAllTeacher() ;
    }

    // POST - INSERT
    //  http://localhost:8090/api/v1/teacher
    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addOneTeacher(teacher);
    }

    // PUT - UPDATE
    //  http://localhost:8090/api/v1/teacher/1
    @PutMapping("/teacher/{id}")
    public Teacher updateTeacher(@PathVariable(name="id") Long id,
                                 @RequestBody Teacher teacher) {

        Teacher teacherInfo=teacherService.getOneTeacher(id);

        if(teacherInfo != null) {
            teacherInfo.setId(id);
            teacherInfo.setFirst_name(teacher.getFirst_name());
            teacherInfo.setLast_name(teacher.getLast_name());
            teacherInfo.setEmail(teacher.getEmail());
            return teacherService.updateTeacher(teacherInfo);
        }
        return null;
    }

    //  DELETE
    //  http://localhost:8090/api/v1/teacher
    @DeleteMapping("/teacher/{id}")
    public String deleteTeacher(@PathVariable(value="id") Long id) {
        return teacherService.deleteTeacher(id);
    }

}
