/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
import java.util.*; 
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
     
//查找通用一区间内max存在的数

    public int minMeetingRooms(List<Interval> intervals) {
        //reorder List
        int length = intervals.size();
        int[] startTime = new int[length];
        int[] endTime = new int[length];
        
        for(int i =0 ; i<length;i++){
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }
        
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int counter = 0;
        int j = 0;
        for( int i = 0; i < startTime.length;i++){
            
            if(endTime[j]>startTime[i]){
              counter ++ ; 
            }else{
                j++;
            }
        }
        return counter;
        
    }
}