package demo.service;

import demo.models.entity.Students;
import demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Students createStudent(Students student) {
       return  studentsRepository.save(student);
    }

    public int  editStudent(Long id, String fio, Date dateOfAdmission, String passport, String name) {
         return studentsRepository.edit(id, fio, dateOfAdmission, passport, name);
      }

    public List<Students> studentsInOutfit(String outfitName) {
        return studentsRepository.findStudentsByOutfitsName(outfitName);
    }

    public int insertStudent(String fio,  Date dateOfAdmission, String passport, String outfit_name) {
        return studentsRepository.insertStudentInOutfitDop(fio, dateOfAdmission, passport, outfit_name);
    }

}