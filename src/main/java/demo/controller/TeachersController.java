package demo.controller;

import demo.repository.TeachersRepository;
import demo.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @GetMapping("/teachers")
    public ResponseEntity getTeachers() {
        return  ResponseEntity.status(HttpStatus.OK).body(teachersService.getTeachers());
    }
}
