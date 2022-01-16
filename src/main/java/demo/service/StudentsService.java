package demo.service;

import demo.models.entity.Students;
import demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public List<Students> getStudents() {
        return studentsRepository.getTest();
    }

    public Students getStudent(String id) {
        return studentsRepository.findById(id);
    }

    public void studentEdit(String fio, Date dateOfAdmission, String passport, String name, Long id) {
        studentsRepository.edit(fio, dateOfAdmission, passport, name, id);
    }
}
