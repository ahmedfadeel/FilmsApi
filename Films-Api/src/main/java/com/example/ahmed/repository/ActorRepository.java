package com.example.ahmed.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Actor;
import com.example.ahmed.model.Film;
@Repository
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long> {
	
	 
	  
	Page<Actor> findAll(Pageable page );  
	// Page<Tutorial> findByTitleContaining(String title, Pageable pageable); 	
	Iterable<Actor> findByfirstName(String first_name, Sort sort);
	Actor findByactorId(long id );
	 
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
