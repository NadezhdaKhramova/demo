package demo.controller;

import demo.models.entity.Students;
import demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/edit")
    public ResponseEntity editStudent(@RequestParam Long id,
                                      @RequestParam (required = false) String fio,
                                      @RequestParam (required = false) Date dateOfAdmission,
                                      @RequestParam (required = false) String passport,
                                      @RequestParam (required = false) String name){
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.editStudent(id, fio, dateOfAdmission, passport, name));
    }

    private void validateStudent(Long studentId) {
        Optional.of(studentsService.getStudent(studentId)).orElseThrow(
                () -> new UserNotFoundException(studentId));
    }
    @PostMapping ("/students/create") //
    public ResponseEntity createStudents(@RequestBody Students student) {
        //student.setOutfits(nameOutfit);
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.createStudent(student));
    }


    @RequestMapping(value = "/edit/dop", method = RequestMethod.POST)
    public ResponseEntity insertStudents(@RequestParam  String fio,
                                         @RequestParam (required = false) Date dateOfAdmission,
                                         @RequestParam  String passport,
                                         @RequestParam  String outfitName){
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.insertStudent(fio, dateOfAdmission, passport, outfitName));
    }


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