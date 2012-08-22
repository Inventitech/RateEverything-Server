package controllers;

import models.Rating;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.F.Function;
import play.libs.Json;
import play.libs.WS;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.java.SecureSocial;
import securesocial.core.java.SocialUser;
import views.html.index;
import views.html.list;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.User;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	@SecureSocial.Secured
	public static Result list() {
		SocialUser user = (SocialUser) ctx().args.get(SecureSocial.USER_KEY);
		if (verifyFacebookToken(user.id.id, user.oAuth2Info.accessToken)) {
			return ok(list.render(Rating.find.all(), user));
		} else {
			// TODO PRoper error handling
			return badRequest(index.render(""));
		}
	}

	public static Result getRatings() {
		ObjectNode result = Json.newObject();
		result.put("ratings", Json.toJson(Rating.find.all()));
		return ok(result);
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result addRating() {
		JsonNode json = request().body().asJson();
		System.out.println(json);
		Integer rating = Integer.parseInt(json.findPath("rating")
				.getTextValue());
		if (rating == null) {
			return badRequest("Missing parameter [rating]");
		} else {
			System.out.println(rating);
			Rating.createRating(rating);
			return ok("Added Rating");
		}
	}

	/**
	 * Verify if the given id matches the id returned using the accessToken.
	 * THis also checks if the accesstoken is still valid
	 */
	public static boolean verifyFacebookToken(String id, String accessToken) {
		try {
			FacebookClient facebookClient = new DefaultFacebookClient(
					accessToken);
			User user = facebookClient.fetchObject("me", User.class);
			return user.getId().equals(id);
		} catch (FacebookOAuthException e) {
			// Problem with authorization
		}
		return false;
	}

}