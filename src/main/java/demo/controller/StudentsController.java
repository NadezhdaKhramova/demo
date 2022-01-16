package demo.controller;

import demo.models.entity.securty.Users;
import demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public ResponseEntity getStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.getStudents());
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PATCH)
    public ResponseEntity editStudent(@PathVariable("id") String fio){
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.studentEdit(fio,date,pass,id));
    }

    private void validateStudent(String studentId) {
        this.studentsService.getStudent(studentId).orElseThrow(
                () -> new UserNotFoundException(studentId));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String edit(@RequestBody @Valid final Users users){
        studentsService.register(users);
        return new ResponseEntity<>(usersService.create(newUser), HttpStatus.CREATED);
    }

}
@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String studentId) {
        super("не удалось найти студента с номером " + studentId + " .");
    }
}