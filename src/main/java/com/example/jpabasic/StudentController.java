package com.example.jpabasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String responce = studentService.addStudent(student);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @PostMapping("/get_by_id")
    public  ResponseEntity getStudentById(@RequestParam("rollNo") int rollNo){
        Student student = studentService.getStudentById(rollNo);
        if(student==null){
            return new ResponseEntity<>("Invalid Roll no ",HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(student,HttpStatus.FOUND);
    }
}
