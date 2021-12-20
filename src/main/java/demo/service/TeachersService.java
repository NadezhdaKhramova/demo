package demo.service;

import demo.entity.Teachers;
import demo.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    public List<Teachers> getTeachers() {
        return  teachersRepository.getAll();
    }
}
