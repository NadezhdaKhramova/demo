package demo.service;

import demo.models.entity.Teachers;
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

    public void editTeacher(String fio, String name, Long id) {
        teachersRepository.edit(fio, name, id);
    }
}
