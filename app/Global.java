import json.RatingRequest.RATING;
import models.Rating;
import play.Application;
import play.GlobalSettings;
import play.Logger;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		Rating.createRating(RATING.RATING_5);
		Rating.createRating(RATING.RATING_7);
		Rating.createRating(RATING.RATING_9);
		Logger.info("Application has started");
	}

	@Override
	public void onStop(Application app) {
		Logger.info("Application shutdown...");
	}

}