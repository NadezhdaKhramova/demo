package demo.controller;

import demo.models.entity.Students;
import demo.models.entity.securty.Users;
import demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")//http://localhost:8080/students
    public ResponseEntity getStudent() {
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.getStudents());
    }

    @GetMapping("/students/{name}") //http://localhost:8080/students/1ИТ
    public ResponseEntity getStudentsInOutfit(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.studentsInOutfit(name));
    }

    @GetMapping("/students/fio")  //http://localhost:8080/students/fio?fio=elena
    public ResponseEntity getStudentByFio(@RequestParam String fio){
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.getByFio(fio));
    }

  /*  @Secured()
    @PostMapping(value = "/edit")
    public ResponseEntity editStudent(@RequestBody EditUser editUser ){
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.studentEdit(editUser));
    }*/

    private void validateStudent(Long studentId) {
        Optional.of(studentsService.getStudent(studentId)).orElseThrow(
                () -> new UserNotFoundException(studentId));
    }



  /*  @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createStudent(String fio,  Date dateOfAdmission, String passport, String outfit_name){
        createStudent(fio, dateOfAdmission, passport, outfit_name);
      //  return new ResponseEntity<>(studentsService.createStudent(fio,  dateOfAdmission, passport, outfit_name), HttpStatus.CREATED);
    }*/

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(Long studentId) {
            super("не удалось найти студента с номером " + studentId + " .");
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    class UserNameNotFoundException extends RuntimeException {

        public UserNameNotFoundException(String fio) {
            super("не удалось найти студента с именем  " + fio + " .");
        }
    }
}