package com.genie.JPA_Project01.service;

import com.genie.JPA_Project01.entity.Student;
import com.genie.JPA_Project01.repo.StudentRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@Transactional

public class StudentService
{
    @Autowired
    StudentRepo studentRepo;

    public Student saveStudent(Student student)
    {
        return studentRepo.save(student);

    }
    @GetMapping("/all")
    public List<Student>getAllStudentData(){
        List<Student> list = studentRepo.findAll();
        return list;
    }

    public Student getStudentById(Integer id){
        Optional<Student>byId = studentRepo.findById(id);
        Student student = byId.get();
        return student;
    }

    public  Student updateStudent(Integer id,Student student) {
        Optional<Student> byId = studentRepo.findById(id);
        Student stud = null;
        if (byId.isPresent()) {
            Student dbStudentObject = byId.get();
            dbStudentObject.setAge(student.getAge());
            dbStudentObject.setEmail(student.getEmail());
            dbStudentObject.setName(student.getName());
            return studentRepo.save(dbStudentObject);

        } else {
            System.out.println("Data not present in db ");
        }
        return stud;
    }

        public Student deleteStudentById(Integer id) {
        Optional<Student> byId = studentRepo.findById(id);
            Student stud = null;
        if (byId.isPresent()) {
            Student studentToDelete = byId.get();  // Get the student to delete
            studentRepo.deleteById(id);  // Delete the student
            return studentToDelete;
        }else{
            System.out.println("Data not present in db ");
            }
            return stud;
        }

}