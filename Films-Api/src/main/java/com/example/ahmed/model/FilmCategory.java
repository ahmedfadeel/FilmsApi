package com.example.ahmed.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "film_category", schema = "public")
public class FilmCategory implements Serializable {
	  @Id
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "filmId", nullable = false, insertable = false, updatable = false)
	  private Film film;
	  
	  @Id
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "categoryId", nullable = false, insertable = false, updatable = false)
	  private Category category;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	   
}
