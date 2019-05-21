/*package com.movie.review.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.movie.review.model.MovieReview;
import com.movie.review.repo.IMovieRepo;
import com.movie.review.repo.MovieJPARepo;

@Service
public class MovieJPARepository {

	@Autowired
	private MovieJPARepo repository;
	
	public List<MovieReview> findAll() {
	    return repository.findAll();
	}
	
	public MovieReview save(MovieReview movieReview) {
	    return repository.save(movieReview);
	}
	

}
*/