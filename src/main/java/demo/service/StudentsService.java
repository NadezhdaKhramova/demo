package demo.service;

import demo.models.entity.Students;
import demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public List<Students> getStudents() {
        return studentsRepository.getTest();
    }

    public Students getStudent(Long id) {
        return studentsRepository.getById(id);
    }

    public Students getByFio(String fio) {
        return studentsRepository.findByFio(fio);
    }

    public Students getByFioInOut(String fio) {
        return studentsRepository.getStudentsByFio(fio);
    }

  /* public void studentEdit(StudentEdit edit) {
        studentsRepository.edit(fio, dateOfAdmission, passport, name, id);
    }*/

    /*  public void createStudent(String fio,  Date dateOfAdmission, String passport, String outfit_name) {
          studentsRepository.insertStudentInOutfit( fio, dateOfAdmission,  passport,  outfit_name);
      }*/
    public List<Students> studentsInOutfit(String outfitName) {
        return studentsRepository.findStudentsByOutfitsName(outfitName);
    }
}