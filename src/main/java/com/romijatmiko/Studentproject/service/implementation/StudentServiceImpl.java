package com.romijatmiko.Studentproject.service.implementation;

import com.romijatmiko.Studentproject.entity.Student;
import com.romijatmiko.Studentproject.repository.StudentRepository;
import com.romijatmiko.Studentproject.service.framework.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student save(Student std) {
        return studentRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}

