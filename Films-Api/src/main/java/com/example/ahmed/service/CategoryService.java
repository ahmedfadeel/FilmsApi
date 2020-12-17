package com.example.ahmed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ahmed.model.Actor;
import com.example.ahmed.model.Category;
import com.example.ahmed.model.Film;
import com.example.ahmed.repository.CategoryRepository;
import com.example.ahmed.repository.FilmRepository;

@Service
public class CategoryService {
 @Autowired
 CategoryRepository categoryRepository;
 
 public Page<Category> findAllInPage(Pageable page){
	 return categoryRepository.findAll(page);
 }
 public List<Category> findAll(){
	 return (List<Category>) categoryRepository.findAll();
 }
 // add 
 public  Category addFilm(Category category ) {
	 return  categoryRepository.save(category);
	 
 }
 //delete 
 public  void deleteFilm(Category category ) {
	 categoryRepository.delete(category);
	  
 }
// findByID	
 public Optional<Category> findById(long id ) {
	 return  categoryRepository.findById(id);
 }
 
 //findBytitle
 
public Category findByTitle(String name,Sort sort){
	return  categoryRepository.findBycategoryName(name,  sort);
}	
public Category findByCategoryId(long id ){
	return  categoryRepository.findBycategoryId(id);
}

}
