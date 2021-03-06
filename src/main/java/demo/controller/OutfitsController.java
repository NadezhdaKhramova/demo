package demo.controller;

import demo.service.OutfitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutfitsController {

    @Autowired
    private OutfitsService outfitsService;

    @GetMapping("/outfits")
    public ResponseEntity NameAndFacultyOutfits() {
        return ResponseEntity.status(HttpStatus.OK).body(outfitsService.NameAndFacultyOutfits());
    }
}
