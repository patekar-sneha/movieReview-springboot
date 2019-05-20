package com.movie.review.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.movie.review.model.MovieReview;

class MovieRepo implements RowMapper<MovieReview> {

	@Override
	public MovieReview mapRow(ResultSet rs, int rowNum) throws SQLException {
		MovieReview movieReview = new MovieReview();
		movieReview.setId(rs.getInt("id"));
		movieReview.setMovieName(rs.getString("movieName"));
		movieReview.setMovieSummary(rs.getString("movieSummary"));
		movieReview.setRating(rs.getFloat("rating"));
		movieReview.setReview(rs.getString("review"));

	   return movieReview;
	}
}