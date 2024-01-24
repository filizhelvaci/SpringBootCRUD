package com.flz.controller;

import com.flz.model.Student;
import com.flz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//  http://localhost:8090/api/v1/hello

@RestController
@RequestMapping("/api/v1")
public class StudentController {

   @Autowired
   StudentService studentService;

    //@RequestMapping(path = "/hello",method = RequestMethod.GET) //Eskiden bu şekilde kullanılıyprmuş
    //Artık aşağıdaki gibi kullanılıyor

    @GetMapping("/hello")
    public String hello() {
        return "Slm";
    }

    // GET - SELECT * FROM WHERE
    //  http://localhost:8090/api/v1/student/1
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable(name="id") Long id) {
        return studentService.getOneStudent(id);
    }

    // GET - SELECT * FROM
    //  http://localhost:8090/api/v1/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudent() ;
    }

    // POST - INSERT
    //  http://localhost:8090/api/v1/student
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addOneStudent(student);
    }

    // PUT - UPDATE
    //  http://localhost:8090/api/v1/student/1
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable(name="id") Long id,
                                @RequestBody Student student) {

        Student studentInfo=studentService.getOneStudent(id);

       if(studentInfo != null) {
           studentInfo.setId(id);
           studentInfo.setFirst_name(student.getFirst_name());
           studentInfo.setLast_name(student.getLast_name());
           studentInfo.setEmail(student.getEmail());
           return studentService.updateStudent(studentInfo);
       }
       return null;
    }

    //  DELETE
    //  http://localhost:8090/api/v1/student
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable(value="id") Long id) {
        return studentService.deleteStudent(id);
    }

}
