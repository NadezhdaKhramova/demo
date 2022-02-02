package demo.controller;

import demo.models.entity.Students;
import demo.models.entity.Teachers;
import demo.repository.TeachersRepository;
import demo.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @GetMapping("/teachers")
    public ResponseEntity getTeachers() {
        return  ResponseEntity.status(HttpStatus.OK).body(teachersService.getTeachers());
    }

    @GetMapping("/teachers/fio")
    public ResponseEntity curatorOutfits(String fio) {
        return ResponseEntity.status(HttpStatus.OK).body(fio);
    }

    @GetMapping("/teachers/name")
    public ResponseEntity curatorTeacherOut (String name) {
        return ResponseEntity.status(HttpStatus.OK).body(name);
    }

    @PostMapping("/teachers/create") //
    public void createTeachers(@RequestBody Teachers teacher) {
        teachersService.createTeacher(teacher);
    }
}
