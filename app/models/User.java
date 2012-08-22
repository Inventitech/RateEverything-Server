package models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class User extends Model {

	private static final long serialVersionUID = 1L;

	@Constraints.Required
	public String id;
	
	@Constraints.Required
	public String accessToken;
	
	@Constraints.Required
	public Date registered = new Date();
	
	//@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//public List<Rating> ratings;
	
	public static Finder<Integer, User> find = new Finder<Integer, User>(
			Integer.class, User.class);

}
