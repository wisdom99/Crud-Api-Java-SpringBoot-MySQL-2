package com.wisdomcalm.springbootcrudsrm.controller;

import com.wisdomcalm.springbootcrudsrm.model.Student;
import com.wisdomcalm.springbootcrudsrm.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/portal", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){

        this.studentService = studentService;
    }

    @PostMapping("/createOne")
    public  Student createStudent (@RequestBody Student student){
        return  studentService.saveStudent(student);

    }

    @PostMapping("/createMany")
    public List<Student> createStudents (@RequestBody List<Student> students){
        return studentService.saveStudents(students);
    }

    @GetMapping("/readAll")
    public List<Student> readAllStudents (){
        return studentService.getStudents();
    }

    @GetMapping("/readOneById/{Id}")
    public Student readAStudentById (@PathVariable int Id){
        return studentService.getStudentById(Id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping ("/delete{Id}")
    public String deleteStudent(@PathVariable int Id){
        return studentService.deleteStudentById(Id);
    }
}
