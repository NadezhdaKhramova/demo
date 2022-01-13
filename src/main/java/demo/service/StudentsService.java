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

}
