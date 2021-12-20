package demo.controller;

import demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public ResponseEntity getStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.getStudents("Матвеева Анна"));
    }


}
