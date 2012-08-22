package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import json.RatingRequest;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Rating extends Model {

	private static final long serialVersionUID = 1L;

	@Constraints.Required
	public RatingRequest.RATING rating;

	@Constraints.Required
	public Date recorded = new Date();
	
	//@ManyToOne
	//public User user;

	public static Finder<Integer, Rating> find = new Finder<Integer, Rating>(
			Integer.class, Rating.class);

	public static Rating createRating(RatingRequest.RATING rating) {
		Rating newRating = new Rating();
		newRating.rating = rating;
		newRating.save();
		return newRating;
	}

}
