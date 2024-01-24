package com.flz.service;


import com.flz.model.Teacher;
import com.flz.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public Teacher getOneTeacher(Long id) {
        return teacherRepository.findById(id).get();

    }

    public Teacher addOneTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public String deleteTeacher(Long id) {
        //burada verilen id nin olup olmadığı kontrol ettirilmeli
        // varsa silmeli yoksa hata mesajı dönmeli
        // Student student=getStudent(id);
        // student.isEmpty() ise hata dön değilse sil gibi...
        teacherRepository.deleteById(id);
        return "Başarılı...";
    }
}