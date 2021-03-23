import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> allReviewed;
    private HashMap<String, Integer> reviews;

    public ThemePark(ArrayList<IReviewed> themeParkContents) {
        this.allReviewed = themeParkContents;
        this.reviews = new HashMap<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return allReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {

        visitor.addVisitedAttraction(attraction);
        attraction.incrementVisitCount();

    }

    public HashMap<String, Integer> getReviews() {
        return reviews;
    }

    public void addReview(IReviewed review) {
        this.reviews.put(review.getName(), review.getRating());
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {

        ArrayList<IReviewed> returnList = new ArrayList<>();

        for (IReviewed item: this.allReviewed)
        {
            if (!(item instanceof ISecurity))
            {
                returnList.add(item);
            }
            else if (((ISecurity) item).isAllowedTo(visitor))
            {
                returnList.add(item);
            }
        }

        return returnList;
    }
}
