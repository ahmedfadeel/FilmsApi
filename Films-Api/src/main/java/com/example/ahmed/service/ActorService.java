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
import com.example.ahmed.repository.ActorRepository;
import com.example.ahmed.repository.FilmRepository;

@Service
public class ActorService {
 @Autowired
 ActorRepository actorRepository;
 
 public Page<Actor> findAllInPage(Pageable page){
	 return actorRepository.findAll(page);
 }
 public List<Actor> findAll(){
	 return (List<Actor>) actorRepository.findAll();
 }
 // add 
 public  Actor addActor(Actor actor ) {
	 return  actorRepository.save(actor);
	 
 }
 //delete 
 public  void deleteActor(Actor actor ) {
	 actorRepository.delete(actor);
	  
 }
// findByID	
 public Optional<Actor> findById(long id ) {
	 return  actorRepository.findById(id);
 }
 
 //findBytitle
 
public List<Actor>  findByFirst_Name(String firstName,Sort sort){
	return (List<Actor>) actorRepository.findByfirstName(firstName, sort);
}	
// findByactorId
public Actor findByActorId(long id ) {
	 return actorRepository.findByactorId(id);
}

}
