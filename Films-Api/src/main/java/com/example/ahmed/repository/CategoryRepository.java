package com.example.ahmed.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Actor;
import com.example.ahmed.model.Category;
import com.example.ahmed.model.Film;
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
	Page<Category> findAll(Pageable page );  
	// Page<Tutorial> findByTitleContaining(String title, Pageable pageable); 	
	Category findBycategoryName(String name, Sort sort);
	
	Category findBycategoryId(long id );
	/*   {in rest controller }
	 *   // order by 'published' column - ascending
List<Tutorial> tutorials =
     tutorialRepository.findAll(Sort.by("published"));

// order by 'published' column, descending
List<Tutorial> tutorials =
     tutorialRepository.findAll(Sort.by("published").descending());

// order by 'published' column - descending, then order by 'title' - ascending
List<Tutorial> tutorials =
     tutorialRepository.findAll(Sort.by("published").descending().and(Sort.by("title")));
	 * 
	 * 
	 * */
}
