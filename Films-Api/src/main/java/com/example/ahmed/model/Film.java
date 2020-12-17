package com.example.ahmed.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

 /*i have film object 
  * then i can get all its categories as a list of objects 
  * 
  * 
  * */
@Entity
@Table(name="fims")
public class Film implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long filmId;	
	
     
 
    @Column(unique = true )
	private String title;
	
	private String description ;
	
	private String release_year ;
	
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long film_id) {
		this.filmId = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRelease_year() {
		return release_year;
	}
	public void setRelease_year(String release_year) {
		this.release_year = release_year;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "languageId", nullable = false)
	  private Language language;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	  private Set<FilmCategory> filmCategories = new HashSet<FilmCategory>(0);
	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Set<FilmCategory> getFilmCategories() {
		return filmCategories;
	}
	public void setFilmCategories(Set<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}
	public Set<FilmActor> getFilmActors() {
		return filmActors;
	}
	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film_actor")
	private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);

	 // get All categories of this film 
	public Set<Category>    getCategories( ){
		Set<Category> categories=new HashSet();
		  for (FilmCategory filmCategory:this.filmCategories) {
			  categories.add(filmCategory.getCategory());     
		  }  
		  
		return  categories;
	}
	//get All Actors of this film 
	public Set<Actor> getActors(){
		Set<Actor>  actors=new HashSet();
		  for (FilmActor filmActor:this.filmActors) {
			  actors.add(filmActor.getActor());     
		  }  
		  
		return  actors;
	} 
	/*
	 * implemnt  add , remove to  filmCategories
	 * implemnt  add , remove to  filmActors
	 * */
	public void addFilmCategory(FilmCategory filmCategory) {
		this.filmCategories.add(filmCategory);
		
	}
	public void removeFilmCategory(FilmCategory filmCategory) {
		this.filmCategories.remove(filmCategory);
		
	}
	
	
	public void addFilmActor(FilmActor filmActor) {
		this.filmActors.add(filmActor);
		
	}
	public void removeFilmActor(FilmActor filmActor) {
		this.filmActors.remove(filmActor);
		
	}
	
}
