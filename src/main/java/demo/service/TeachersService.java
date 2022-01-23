package demo.service;

import demo.models.entity.Teachers;
import demo.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class TeachersService {

    @Autowired
    private TeachersRepository teachersRepository;

    public List<Teachers> getTeachers() {
        return  teachersRepository.getAll();
    }

    public List<Teachers> curator(String name) {
        return teachersRepository.findTeachersInOutfits(name);
    }

    public List<Teachers> curatorOut(String name) {
        return teachersRepository.findTeachersInOutfitsDop(name);
    }

    public void editTeacher(String fio, String name, Long id) {
        teachersRepository.edit(fio, name, id);
    }
}
