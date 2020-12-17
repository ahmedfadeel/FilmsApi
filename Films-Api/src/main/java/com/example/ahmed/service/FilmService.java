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
import com.example.ahmed.repository.FilmRepository;

@Service
public class FilmService {
 @Autowired
 FilmRepository filmrepository;
 
 public Page<Film> findAllInPage(Pageable page){
	 return filmrepository.findAll(page);
 }
 public List<Film> findAll(){
	 return (List<Film>) filmrepository.findAll();
 }
 // add 
 public  Film addFilm(Film film ) {
	 return  filmrepository.save(film);
	 
 }
 //delete 
 public  void deleteFilm(Film film ) {
	   filmrepository.delete(film);
	  
 }
// findByID	
 public Optional<Film> findById(long id ) {
	 return  filmrepository.findById(id);
 }
 
 //findBytitle
 
public Film  findByTitle(String title,Sort sort){
	return  filmrepository.findBytitle(title,  sort);
}	

//findByfilmId
public Film  findByFilmId(long id ) {
	return  filmrepository.findByfilmId(id);
}
}
