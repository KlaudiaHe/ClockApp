package Clock;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit4ClockAppTest {


    @Test
    public void createFineEarlyClock() {
        Clock clock = new Clock(0, 0);
        assertEquals(0, clock.getHours());
        assertEquals(0, clock.getMinutes());
    }

    @Test
    public void createFineClock() {
        Clock clock= new Clock(21, 37);
        assertEquals(21, clock.getHours());
        assertEquals(37, clock.getMinutes());
    }

    @Test
    public void createFineLateClock() {
        Clock clock= new Clock(23, 59);
        assertEquals(23, clock.getHours());
        assertEquals(59, clock.getMinutes());
    }

    @Test
    public void checkSetterAndGetterMethods(){
        Clock clock = new Clock(0,0);
        clock.setHours(15);
        clock.setMinutes(23);
        assertEquals(15, clock.getHours());
        assertEquals(23, clock.getMinutes());
    }

    @Test
    public void addAnotherClock(){
        Clock clock= new Clock (12,12);
        Clock clock2= new Clock (12,12);
        Clock updatedClock= clock.addAnotherClockTime(clock2);
        assertEquals(00, updatedClock.getHours());
        assertEquals(24, updatedClock.getMinutes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreatingIllegalLateClock1() {
        Clock clock = new Clock(24,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreatingIllegalLateClock2() {
        Clock clock2 = new Clock(243, 243);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreatingIllegalLateClock3() {
        Clock clock3 = new Clock(25, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreatingIllegalLateClock4() {
        Clock clock4 = new Clock(-15, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCreatingIllegalClock() { Clock clock5 = new Clock(15, -1);
    }
}