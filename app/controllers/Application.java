package controllers;

import models.Rating;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.list;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result list() {
		return ok(list.render(Rating.find.all()));
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
		Integer rating = Integer.parseInt(json.findPath("rating").getTextValue());
		if (rating == null) {
			return badRequest("Missing parameter [rating]");
		} else {
			System.out.println(rating);
			Rating.createRating(rating);
			return ok("Added Rating");
		}
	}

}