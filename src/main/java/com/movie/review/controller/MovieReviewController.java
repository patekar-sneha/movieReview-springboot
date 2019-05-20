package com.movie.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.review.model.MovieReview;
import com.movie.review.repo.MovieRepository;

@RestController
@RequestMapping(path = "/movies")
public class MovieReviewController {

	@Autowired()
	MovieRepository movieRepo;
	
	
	@GetMapping(path = "/test", produces = "application/json")
	public String findAll(){
		return "SUCCESS";
	}
	
	@GetMapping(path = "/all", produces = "application/json")
	public List<MovieReview> getAll(){
		return movieRepo.getAllData();
	}
	
	@PostMapping(path = "/review", produces = "application/json")
	public MovieReview createReview(@RequestBody MovieReview movieReview){
		return movieRepo.create(movieReview);
	}
	
	

	
}
