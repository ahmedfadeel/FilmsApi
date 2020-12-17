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
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="categories")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long categoryId;	
	
	@Column(unique = true)
	private String categoryName;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long category_id) {
		this.categoryId = category_id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String category_name) {
		this.categoryName = category_name;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	  private Set<FilmCategory> filmCategories = new HashSet<FilmCategory>(0);
	/*implement add filmcategories 
	 * implement remove filmCategories
	 * 
	 * */
	
	public Set<FilmCategory> getFilmCategories() {
		return filmCategories;
	}

	public void setFilmCategories(Set<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	// get films of this categories 
	public Set<Film>  getFilms(){
		Set<Film> films =new HashSet();
		 for (FilmCategory filmCategory:this.filmCategories ) {
			 films.add(filmCategory.getFilm());
		 }
	  return films ;	
	}  
	
	public void addFilmCategory(FilmCategory filmCategory) {
		this.filmCategories.add(filmCategory);
		
	}
	public void removeFilmCategory(FilmCategory filmCategory) {
		this.filmCategories.remove(filmCategory);
		
	}
	
	
}
