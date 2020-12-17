package com.example.ahmed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ahmed.model.Actor;
import com.example.ahmed.model.Film;
import com.example.ahmed.model.Language;
import com.example.ahmed.repository.FilmRepository;
import com.example.ahmed.repository.LanguageRepository;

@Service
public class LanguageService {
 @Autowired
 LanguageRepository languageRepository;
 
 public Page<Language> findAllInPage(Pageable page){
	 return languageRepository.findAll(page);
 }
 public List<Language> findAll(){
	 return (List<Language>) languageRepository.findAll();
 }
 // add 
 public  Language addFilm(Language language ) {
	 return  languageRepository.save(language);
	 
 }
 //delete 
 public  void deleteFilm(Language language ) {
	 languageRepository.delete(language);
	  
 }
// findByID	
 public Optional<Language> findById(long id ) {
	 return  languageRepository.findById(id);
 }
 
 //findBytitle
 
public List<Language>  findByTitle(String name,Sort sort){
	return (List<Language>) languageRepository.findBylanguageName(name,  sort);
}	
// findBylanguageId
public Language findByLanguageId(long id ) {
	return languageRepository.findBylanguageId(id);
}

}
