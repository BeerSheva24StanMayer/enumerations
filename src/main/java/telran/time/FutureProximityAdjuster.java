package telran.time;

import java.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster{
    TimePoint[] timePoints;
    public FutureProximityAdjuster(TimePoint[] timePoints) {
        //TODO
        //copy a given array
        //sort copy and assign to the field timePoints
        //using Java standart Arrays class
        //repeated time points are posibleint
       timePoints = Arrays.copyOf(timePoints, timePoints.length);
       Arrays.sort(timePoints);
       this.timePoints = timePoints;
    }

    @Override
    public TimePoint adjust(TimePoint timePoint) {
        // TODO
        //returns a time point only in future (greater than a given time point)
        //from the field timePoints nearest to given timePoint
        int startPoint = 0;
        int endPoint = timePoints.length - 1;
        int result = -1;
        while(startPoint <= endPoint) {
            int middlePoint = (startPoint + endPoint) / 2;
            int comparedMiddle = timePoints[middlePoint].compareTo(timePoint);
            // if(comparable)
            if(comparedMiddle > 0){
                endPoint = middlePoint - 1;
                result = middlePoint;
            }

            else {
                startPoint = middlePoint + 1;
            }
        }
       
        return result != -1 ? timePoints[result] : null;
    }

}
