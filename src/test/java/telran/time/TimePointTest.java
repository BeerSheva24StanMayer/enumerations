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

}