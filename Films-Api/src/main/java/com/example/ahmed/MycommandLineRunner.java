package com.example.ahmed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.ahmed.service.ActorService;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ahmed.service.ActorService;
import com.example.ahmed.service.CategoryService;
import com.example.ahmed.service.FilmService;
import com.example.ahmed.model.*;
import com.example.ahmed.service.LanguageService;
@Component
@Order(1)
public class MycommandLineRunner implements CommandLineRunner {
	 Logger  logger=LoggerFactory.getLogger(MycommandLineRunner.class);
	@Autowired
	  ActorService actorService;
	
	@Autowired
	 CategoryService categoryService;
	@Autowired
	 FilmService filmService;
	@Autowired
	 LanguageService languageService;

	@Override
	public void run(String... args) throws Exception {
		/*//logger.info(" in main method   ");
    	  System.out.println( actorService.findByActorId(2).getFirstName());
    	  */
      getFilmsOCategory();
   	 
	}
//	com.example.ahmed.model.FilmActor@7c367139]
//	 A different object with the same identifier value was already associated with the session : [com.example.ahmed.model.FilmActor#com.example.ahmed.model.FilmActor@7984de05]
	   void saveFilm () {
		   Film film=new Film();
		   
		   Set<FilmActor> filmActors=new HashSet();
		   FilmActor fAc1=new FilmActor();
		     fAc1.setFilm_actor(film);
		     fAc1.setActor(actorService.findByActorId(1));
		   FilmActor fAc2=new FilmActor();
		     fAc2.setFilm_actor(film);
		     fAc2.setActor(actorService.findByActorId(2));
	     	filmActors.add(fAc1);
		    filmActors.add(fAc2);
			logger.info(fAc1.toString());
			logger.info(fAc2.toString());
			logger.info(filmActors.toString());
			
			Set<FilmCategory> filmCategories=new HashSet(); 
			FilmCategory fcat1=new FilmCategory();
			   fcat1.setFilm(film);
			   fcat1.setCategory(categoryService.findByCategoryId(1));
			FilmCategory fcatc2=new FilmCategory();
			   fcatc2.setFilm(film); 
			   fcatc2.setCategory(categoryService.findByCategoryId(2));
			filmCategories.add(fcat1);
			filmCategories.add(fcatc2);
			
			 film.setTitle("lord of the rings ");
			 film.setFilmActors(filmActors);
			 film.setFilmCategories(filmCategories);
			 filmService.addFilm(film);
		   
		
			
     }
	    
	  void  getFilmsOCategory(){
		   
		   Film film= filmService.findByFilmId(14);
		     for(Category cat: film.getCategories()) 
		     {
		    	 System.out.println(cat.getCategoryName());
	    	 
		     }
   
	   }
	  void getFilmsofActor() {}
	  void getCategories() {
		  
	  }
	  void getFilms() {}
	  
	  void getActorsOffilm() {}
	  
}
