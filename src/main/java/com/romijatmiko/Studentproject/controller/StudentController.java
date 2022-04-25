package com.romijatmiko.Studentproject.controller;

import com.romijatmiko.Studentproject.entity.Student;
import com.romijatmiko.Studentproject.exception.StudentNotFoundException;
import com.romijatmiko.Studentproject.service.framework.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentservice.getAllStudents();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Long id) {
        Student std = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentservice.save(std);
    }

    @PutMapping(value = "/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Student newStd) {
        Student student = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        student.setNama(newStd.getNama());
        student.setNik(newStd.getNik());
        student.setEmail(newStd.getEmail());
        student.setNo_hp(newStd.getNo_hp());
        student.setPendidikan(newStd.getPendidikan());
        student.setAlamat(newStd.getAlamat());
        return studentservice.save(student);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        Student std = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        studentservice.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}

