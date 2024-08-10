package telran.time;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

public class DayOfWeekTest {
    private final String ISRAEL_WEEKEND = "Israel Weekend day";
    final String WEEKEND = "Weekend";
    private final String MON_ISRAEL_WEEKEND = "Weekend day but noy in Israel";
    private final String WORKING_DAY = "Working day";

String getComment(DayOfWeek dayOfWeek) {
    String comment = switch(dayOfWeek){
        case FRI -> ISRAEL_WEEKEND;
        case SAT -> WEEKEND;
        case SUN -> MON_ISRAEL_WEEKEND;
        default -> WORKING_DAY;
    };
    return comment;
}
@Test
void getCommentTest() {
    assertEquals(WORKING_DAY, getComment(DayOfWeek.THU));
    assertEquals(ISRAEL_WEEKEND, getComment(DayOfWeek.FRI));
assertEquals(WEEKEND, getComment(DayOfWeek.SAT));
assertEquals(MON_ISRAEL_WEEKEND, getComment(DayOfWeek.SUN));
}
@Test
void enumExistingMethodsTest() {
    DayOfWeek[] expected = {DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, 
        DayOfWeek.FRI, DayOfWeek.SAT, DayOfWeek.SUN};
    assertArrayEquals(expected, DayOfWeek.values());
    assertEquals("MON", DayOfWeek.MON.toString());
    assertEquals(DayOfWeek.MON, DayOfWeek.valueOf("MON"));
    assertThrowsExactly(IllegalArgumentException.class, () -> DayOfWeek.valueOf("kuku"));

}
}
