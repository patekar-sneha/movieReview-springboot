package com.movie.review.repo;

import com.movie.review.model.MovieReview;

public interface IMovieRepo {
	
	//public List<MovieReview> findAll();
	Iterable<MovieReview> findAll();
	public <S extends MovieReview> S save(S arg0);
}
