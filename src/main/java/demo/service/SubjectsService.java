package demo.service;

import demo.models.entity.Subjects;
import demo.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsService {

    @Autowired
    SubjectsRepository subjectsRepository;

    public List<Subjects> getSubjectsInOutfit(String name) {
    return subjectsRepository.subjectsInOutfit(name);
    }
}
