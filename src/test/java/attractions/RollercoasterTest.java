package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor youngVisitor;
    Visitor oldTallVisitor;
    Visitor oldAverageVisitor;
    Visitor oldShortVisitor;
    Visitor poorVisitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        youngVisitor = new Visitor(8, 150, 10.00);
        oldTallVisitor = new Visitor(20, 210, 10.00);
        oldAverageVisitor = new Visitor(20, 170, 10.00);
        oldShortVisitor = new Visitor(20, 130, 10.00);
        poorVisitor = new Visitor(20, 170, 1.00);

    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void rejectsTooShort() {
        assertEquals(false, rollerCoaster.isAllowedTo(oldShortVisitor));
    }

    @Test
    public void rejectsTooYoung() {
        assertEquals(false, rollerCoaster.isAllowedTo(youngVisitor));
    }

    @Test
    public void allowsTallVisitor() {
        assertEquals(true, rollerCoaster.isAllowedTo(oldAverageVisitor));
    }

    @Test
    public void chargesTallDouble(){
        assertEquals(16.80, rollerCoaster.priceFor(oldTallVisitor), 0.01);
    }

    @Test
    public void canIncrementVisitCount() {

        rollerCoaster.incrementVisitCount();
        assertEquals(1, rollerCoaster.getVisitCount());
    }
}
