import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private ThemePark themePark;
    private Visitor visitor;
    private RollerCoaster rollerCoaster;
    private Playground playground;
    private Park park;
    private Dodgems dodgems;
    private TobaccoStall tobaccoStall;
    private IceCreamStall iceCreamStall;
    private CandyflossStall candyflossStall;

    @Before
    public void before() {
        visitor =   new Visitor(25, 160, 20.00);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        playground = new Playground("Fun Zone", 7);
        park = new Park("Leafy Meadows", 9);
        dodgems = new Dodgems("Bumper Cars", 5);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 7);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);

        ArrayList<IReviewed> themeParkContents = new ArrayList<>();
        themeParkContents.add(rollerCoaster);
        themeParkContents.add(playground);
        themeParkContents.add(park);
        themeParkContents.add(dodgems);
        themeParkContents.add(tobaccoStall);
        themeParkContents.add(iceCreamStall);
        themeParkContents.add(candyflossStall);

        themePark = new ThemePark(themeParkContents);

    }

    @Test
    public void canHaveVisitorVisitAttraction() {
        themePark.visit(visitor, rollerCoaster);

        assertEquals(1, visitor.getNumberOfAttractionsVisited());
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void canAddReview() {
        themePark.addReview(rollerCoaster);
        assertEquals(1, themePark.getReviews().size());
    }

    @Test
    public void canCheckAllAllowed() {

        assertEquals(6, themePark.getAllAllowedFor(visitor).size());
    }
}
