package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor youngVisitor;
    Visitor oldVisitor;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 3);
        youngVisitor = new Visitor(8, 150, 10.00);
        oldVisitor = new Visitor(28, 150, 10.00);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void rejectsTooYoung() {
        assertEquals(false, tobaccoStall.isAllowedTo(youngVisitor));
    }

    @Test
    public void allowsOver18() {
        assertEquals(true, tobaccoStall.isAllowedTo(oldVisitor));
    }
}