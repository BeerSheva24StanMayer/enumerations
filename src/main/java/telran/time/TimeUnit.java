package telran.time;

public enum TimeUnit {
    SECOND(1), MINUTE(60), HOUR(3600);
    private int valueOfSeconds;
    TimeUnit(int valueOfSeconds) {
        this.valueOfSeconds = valueOfSeconds;
    }
    public int getValueOfSeconds() {
        return valueOfSeconds;
    }
    public float beetwen(TimePoint p1, TimePoint p2) {

            float unitP1 = p1.getTimeUnit().getValueOfSeconds() * p1.getAmount();
            float unitP2 = p2.getTimeUnit().getValueOfSeconds() * p2.getAmount();
        return (unitP2 - unitP1) / valueOfSeconds;
    }
 
}