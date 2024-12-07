package com.genie.JPA_Project01.controller;


import com.genie.JPA_Project01.entity.Student;
import com.genie.JPA_Project01.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/std")
public class StudentController
{
    @Autowired
    private StudentService service;
    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student)
    {
        return service.saveStudent(student);
    }
    @GetMapping("/all")
    public List<Student> getAllStudents(){
       List<Student>allStudentData=  service.getAllStudentData();
       return allStudentData;
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id)
    {
      return  service.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable Integer id){
        return service.deleteStudentById(id);
    }

}
