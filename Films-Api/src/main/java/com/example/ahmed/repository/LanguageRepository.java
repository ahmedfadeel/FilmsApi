package com.example.ahmed.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.ahmed.model.Film;
import com.example.ahmed.model.Language;
@Repository
public interface LanguageRepository extends PagingAndSortingRepository<Language, Long> {
	Page<Language> findAll(Pageable page );  
	// Page<Tutorial> findByTitleContaining(String title, Pageable pageable); 	
	Iterable<Language> findBylanguageName(String name, Sort sort);
	Language      findBylanguageId(long id);
	   
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
