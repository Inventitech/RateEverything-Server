package models;

import java.util.Date;

import javax.persistence.Entity;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Rating extends Model {

	private static final long serialVersionUID = 1L;

	@Constraints.Required
	public Integer rating;

	@Constraints.Required
	public Date recorded = new Date();

	public static Finder<Integer, Rating> find = new Finder<Integer, Rating>(
			Integer.class, Rating.class);

	public static Rating createRating(int rating) {
		Rating newRating = new Rating();
		newRating.rating = rating;
		newRating.save();
		return newRating;
	}

}
