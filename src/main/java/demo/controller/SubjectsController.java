package demo.controller;

import demo.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectsController {

    @Autowired
    SubjectsService  subjectsService;

    @GetMapping("/subjects")  //http://localhost:8080/subjects?name=3%D0%AD

    public ResponseEntity planEducation(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(subjectsService.getSubjectsInOutfit(name));
    }
}
