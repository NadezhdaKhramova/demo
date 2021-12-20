package demo.service;

import demo.entity.Students;
import demo.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    public List<Students> getStudents(String fio) {
        return studentsRepository.getTest();
    }

}
