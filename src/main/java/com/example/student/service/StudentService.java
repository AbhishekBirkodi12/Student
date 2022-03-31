package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
   @Autowired
   private StudentRepository studentRepository;

   public Student registerStudent(Student student) {
      studentRepository.save(student);
      return student;
   }

   public  List<Student> getStudents(){
      return (List<Student>) studentRepository.findAll();
   }

   public void deleteStudent(Integer id){
      studentRepository.deleteById(id);
   }

   public Student updateStudent(Student student) {
    Integer rollno=student.getRollNumber();
    Student std=studentRepository.findById(rollno).get();
    std.setName(student.getName());
    std.setAddress(student.getAddress());
    std.setPercentage(student.getPercentage());
    return studentRepository.save(std);

   }
}
