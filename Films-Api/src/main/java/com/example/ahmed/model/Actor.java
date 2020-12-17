package com.example.ahmed.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="actors")
public class Actor implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long actorId;	 
	 
	private String firstName;
	private String last_name;
	private LocalDate lastUpdate;
	public long getActorId() {
		return actorId;
	}
	public void setActorId(long actor_id) {
		this.actorId = actor_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public LocalDate getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "actor")
	private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);
	
	/* me in actor now creating new actor 
	 * this reference has filmActors Set   actor (has many films )
	 *  
	 *  new FilmActor filmActor
	 * filmActot.film(film);
	 * filmActor.actor(actor);
	 * 
	 * */
	
	// getfilms of this actor
	
	public Set<Film> getActorFilms(Set<FilmActor> filmActors){
		Set<Film> films=new HashSet();
		  for (FilmActor filmActor:this.filmActors) {
			  films.add(filmActor.getFilm_actor());     
		  }  
		  
		return  films;
	} 
	public void addFilmActor(FilmActor filmActor) {
		this.filmActors.add(filmActor);
		
	}
	public Set<FilmActor> getFilmActors() {
		return filmActors;
	}
	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}
	public void removeFilmActor(FilmActor filmActor) {
		this.filmActors.remove(filmActor);
		
	}
	
}
