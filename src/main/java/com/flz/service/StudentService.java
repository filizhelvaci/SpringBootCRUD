package com.flz.service;

import com.flz.model.Student;
import com.flz.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Student getOneStudent(Long id){
        return studentRepository.findById(id).get();
    }

    public Student addOneStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public String deleteStudent(Long id){
        //burada verilen id nin olup olmadığı kontrol ettirilmeli
        // varsa silmeli yoksa hata mesajı dönmeli
        // Student student=getStudent(id);
        // student.isEmpty() ise hata dön değilse sil gibi...
      studentRepository.deleteById(id);
      return "Başarılı..." ;
    }
}
