package com.wisdomcalm.springbootcrudsrm.service;

import com.wisdomcalm.springbootcrudsrm.model.Student;
import com.wisdomcalm.springbootcrudsrm.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public  StudentService (StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student saveStudent (Student student){
        return  studentRepository.save(student);
    }

    public List <Student> saveStudents (List<Student> students){
        return  studentRepository.saveAll(students);
    }

    public List <Student> getStudents (){
        return  studentRepository.findAll();
    }

    public Student getStudentById(int Id){
        return  studentRepository.findById(Id).orElse(null) ;
    }
    public Student getStudentByName(String name){
        return  studentRepository.findByFullName(name) ;
    }

    public Student updateStudent(Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setFullName(student.getFullName());
        existingStudent.setDept(student.getDept());
        existingStudent.setRegNumber(student.getRegNumber());

        return  studentRepository.save(existingStudent);
    }

    public String deleteStudentById(int Id){
        studentRepository.deleteById(Id);
        return  "deleted student has this : " + Id + "should be placed out of class";
    }
}

