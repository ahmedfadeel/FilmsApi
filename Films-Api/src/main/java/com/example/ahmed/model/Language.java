package com.example.ahmed.model;

import java.io.Serializable;
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
@Table(name="languages")
public class Language implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long languageId;	 
    
	private String languageName;

	public long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(long language_id) {
		this.languageId = language_id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String language_name) {
		this.languageName = language_name;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "language")
	  private Set<Film> films;
	 /*implment  addFilm()
	 * implement removeFilm()
	 * 
* */ 
	
	
	public void affFilm(Film film) 
	{
		this.films.add(film);
	}
	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}

	public void removeFilm(Film film ) {
		this.films.remove(film);
	}
	
	
}
