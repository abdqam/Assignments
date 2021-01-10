package com.mvc.languages.languages.services;

import com.mvc.languages.languages.models.Language;
import com.mvc.languages.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    // adding the language repository as a dependency
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language L) {
        return languageRepository.save(L);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }

    public void updateLanguage(Language language) {
        Language editedLanguage = languageRepository.findById(language.getId()).orElse(null);
        assert editedLanguage != null;
        editedLanguage.setName(language.getName());
        editedLanguage.setCreator(language.getCreator());
        editedLanguage.setCurrentVersion(language.getCurrentVersion());
        languageRepository.save(editedLanguage);
    }
    public Language updateLanguage(Long id, String name, String creator,Double currentVersion) {
        Language editedLanguage= findLanguage(id);
        if(editedLanguage != null) {
            editedLanguage.setName(name);
            editedLanguage.setCreator(creator);
            editedLanguage.setCurrentVersion(currentVersion);
            languageRepository.save(editedLanguage);
            return editedLanguage;
        } else {
            return null;
        }
    }
}
