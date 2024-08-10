package telran.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TimePointTest {
    TimePoint point120Seconds = new TimePoint(120, TimeUnit.SECOND);
    TimePoint point2Minutes = new TimePoint(2, TimeUnit.MINUTE);
    TimePoint point2Hours = new TimePoint(2, TimeUnit.HOUR);
    TimePoint point3Hours = new TimePoint(3, TimeUnit.HOUR);
    TimePoint point7200Seconds = new TimePoint(7200, TimeUnit.SECOND);
    TimePoint pointMinus2Hours = new TimePoint(-2, TimeUnit.HOUR);
    TimePoint pointMinus2Minutes = new TimePoint(-2, TimeUnit.MINUTE);
    TimePoint pointMinus3Hours = new TimePoint(-3, TimeUnit.HOUR);

    TimePoint point2Seconds = new TimePoint(2, TimeUnit.SECOND);
    TimePoint point20Seconds = new TimePoint(20, TimeUnit.SECOND);
    TimePoint point0Seconds = new TimePoint(0, TimeUnit.SECOND);

    @Test
    void convertTest() {
        assertEquals(2, point120Seconds.convert(TimeUnit.MINUTE).getAmount());
        assertEquals(120, point2Minutes.convert(TimeUnit.SECOND).getAmount());
        assertEquals(7200, point2Hours.convert(TimeUnit.SECOND).getAmount());
        assertEquals(2, point7200Seconds.convert(TimeUnit.HOUR).getAmount());
    }

    @Test
    void compareToTest() {
        assertTrue(0 == point7200Seconds.compareTo(point2Hours));
        assertTrue(0 == point120Seconds.compareTo(point2Minutes));

        assertTrue(0 > point120Seconds.compareTo(point7200Seconds));
        assertTrue(0 > point120Seconds.compareTo(point2Hours));
        assertTrue(0 > point120Seconds.compareTo(point3Hours));
        assertTrue(0 > point2Hours.compareTo(point3Hours));

        assertTrue(0 < point7200Seconds.compareTo(point120Seconds));
        assertTrue(0 < point2Hours.compareTo(point120Seconds));
        assertTrue(0 < point3Hours.compareTo(point2Hours));
        assertTrue(0 < point3Hours.compareTo(point120Seconds));
    }

    @Test
    void equalsTest() {
        assertTrue(point7200Seconds.equals(point2Hours));
        assertTrue(point120Seconds.equals(point2Minutes));

        assertFalse(point2Minutes.equals(point7200Seconds));
        assertFalse(point3Hours.equals(point7200Seconds));
    }

    @Test
    void withAdjusterTest() {
        // time plus
        PlusTimePointAdjuster plus2Hours = new PlusTimePointAdjuster(2, TimeUnit.HOUR);
        PlusTimePointAdjuster plus600Minutes = new PlusTimePointAdjuster(600, TimeUnit.MINUTE);
        PlusTimePointAdjuster plus7200Seconds = new PlusTimePointAdjuster(7200, TimeUnit.SECOND);
        PlusTimePointAdjuster minus120Minutes = new PlusTimePointAdjuster(-120, TimeUnit.MINUTE);

        assertEquals(4, point2Hours.with(plus2Hours).getAmount());
        assertEquals(13, point3Hours.with(plus600Minutes).getAmount());
        assertEquals(0, pointMinus2Hours.with(plus7200Seconds).getAmount());
        assertEquals(0, point2Hours.with(minus120Minutes).getAmount());

        // time future
        TimePoint[] timePoints = { point120Seconds, point2Hours, pointMinus2Hours, point7200Seconds,
                point2Minutes, point20Seconds, point0Seconds 
            };

        FutureProximityAdjuster futureProx = new FutureProximityAdjuster(timePoints);


        assertEquals(pointMinus2Hours, pointMinus3Hours.with(futureProx));
        assertEquals(point20Seconds, point2Seconds.with(futureProx));
        assertEquals(point0Seconds, pointMinus2Minutes.with(futureProx));
        assertEquals(point0Seconds, pointMinus2Minutes.with(futureProx));
        assertEquals(null, point2Hours.with(futureProx));
    
    }

}