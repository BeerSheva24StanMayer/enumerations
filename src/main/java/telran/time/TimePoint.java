package telran.time;

public class TimePoint implements Comparable<TimePoint>{
    private float amount;
    private TimeUnit timeUnit;
    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }
    @Override
    public int compareTo(TimePoint timePoint) {
        //TODO
        return (int)timeUnit.SECOND.beetwen(timePoint, this);
        
    }
    public float getAmount() {
        return amount;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    @Override
    public boolean equals(Object obj) {
        //TODO        
        return this.compareTo((TimePoint) obj) == 0;
    }
    public TimePoint convert(TimeUnit timeUnit) {
        //TODO
        //returns new TimePoint object equaled to "this" object
        //but with a given timeUnit
        return new TimePoint((this.timeUnit.getValueOfSeconds() * amount) / timeUnit.getValueOfSeconds(), timeUnit);
    }
    public TimePoint with(TimePointAdjuster adjuster) {
        return adjuster.adjust(this);
}
}
