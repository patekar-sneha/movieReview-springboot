package com.movie.review.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.movie.review.model.MovieReview;

@Repository
public class MovieRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<MovieReview> getAllData() {
		List<String> movieData = new ArrayList<>();
		//movieData.add(jdbcTemplate.queryForList("select * from movie.movie_review;", new MovieRepo()));
		 return jdbcTemplate.query("select * from Movie.movie_review;", new MovieRepo());
    }
	
	  public MovieReview create(final MovieReview movieReview) 
	    {
	        final String sql = "insert into Movie.movie_review(id, movieName, movieSummary, rating, review) values(?,?,?,?,?)";

	        KeyHolder holder = new GeneratedKeyHolder();
	        jdbcTemplate.update(new PreparedStatementCreator() {
	            @Override
	            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	                ps.setInt(1, movieReview.getId());
	                ps.setString(2, movieReview.getMovieName());
	                ps.setString(3, movieReview.getMovieSummary());
	                ps.setFloat(4, movieReview.getRating());
	                ps.setString(5, movieReview.getReview());
	                return ps;
	            }
	            }, holder);


	        return movieReview;
	    }
	}


