package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor youngVisitor;
    Visitor oldVisitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        youngVisitor = new Visitor(8, 140, 10.0);
        oldVisitor = new Visitor(28, 150, 10.00);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void chargedYoungVisitorCorrectly() {
        assertEquals(2.25, dodgems.priceFor(youngVisitor), 0.01);
    }

    @Test
    public void chargesOldVisitorCorrectly() {
        assertEquals(4.50, dodgems.priceFor(oldVisitor), 0.01);
    }
}
