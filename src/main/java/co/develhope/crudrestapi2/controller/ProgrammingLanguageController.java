package co.develhope.crudrestapi2.controller;

import co.develhope.crudrestapi2.entity.ProgrammingLanguage;
import co.develhope.crudrestapi2.repository.ProgrammingLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguageController {

    @Autowired
    private ProgrammingLanguageRepository programmingLanguageRepository;

    @PostMapping
    public ResponseEntity<ProgrammingLanguage> addLanguage(@RequestBody ProgrammingLanguage language) {
        ProgrammingLanguage savedLanguage = programmingLanguageRepository.save(language);
        return new ResponseEntity<>(savedLanguage, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<ProgrammingLanguage>> getAllLanguages(Pageable pageable) {
        return new ResponseEntity<>(programmingLanguageRepository.findAll(pageable), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProgrammingLanguage> updateLanguageInventor(@PathVariable Long id, @RequestBody ProgrammingLanguage updatedLanguage) {
        Optional<ProgrammingLanguage> languageOptional = programmingLanguageRepository.findById(id);
        if (languageOptional.isPresent()) {
            ProgrammingLanguage language = languageOptional.get();
            language.setInventor(updatedLanguage.getInventor());
            ProgrammingLanguage savedLanguage = programmingLanguageRepository.save(language);
            return new ResponseEntity<>(savedLanguage, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
