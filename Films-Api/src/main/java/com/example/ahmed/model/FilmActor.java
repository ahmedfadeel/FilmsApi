package com.example.ahmed.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "film_actor", schema = "public")
public class FilmActor implements Serializable {
     @Id	
	 @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "filmId", nullable = false, insertable = false, updatable = false)
	  private Film film_actor;
     @Id
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "actorId", nullable = false, insertable = false, updatable = false)
	  private Actor actor;
	public Film getFilm_actor() {
		return film_actor;
	}
	public void setFilm_actor(Film film_actor) {
		this.film_actor = film_actor;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	
}
