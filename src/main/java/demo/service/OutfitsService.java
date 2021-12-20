package demo.service;

import demo.repository.OutfitsRepository;
import demo.entity.Outfits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutfitsService {
    @Autowired
    private OutfitsRepository outfitsRepository;

    public List<Outfits> NameAndFacultyOutfits() {
        return outfitsRepository.getNameAndFaculty();
    }
    public List<Outfits> AllByFacultyNotNullAndNameNotNull() {
        return outfitsRepository.getAllByFacultyNotNullAndNameNotNull();
    }
}
