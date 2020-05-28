/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param points: an array of point
     * @return: An integer
     */
    public int maxPoints(Point[] points) {
        // write your code here
        if(points ==null){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }
        if(points.length ==2){
            return 2;
        }
       
        Map<Double, Integer> slope = new HashMap<>();
        int max = 0;
        for(int i = 0; i < points.length-1; i++){
            int duplicate = 1;
            int vertical = 0;
            //System.out.println("current i is :" + i);
            for(int j= (i+1); j<points.length;j++){
                //System.out.println("i is " + i+"  j is " + j);
                if((points[j].x!=points[i].x)){
                  double k = (points[j].y-points[i].y)*1.0/(points[j].x-points[i].x)*1.0;
                  int count = slope.getOrDefault(k,0);
                    //System.out.println("k is " + k + " count is "+ (count+1));
                    slope.put(k,count+1);
                }else{
                    if(points[j].y == points[i].y){
                        duplicate++;
                        //System.out.println("duplicate is " + duplicate);
                    }else{
                        vertical++;
                    }
                }
            }

            if(!slope.isEmpty()){
                // System.out.println("max is " + max);
                // System.out.println("Collections is " + (Collections.max(slope.values())));
                max= Math.max(max,Collections.max(slope.values())+duplicate);
            }
            max = Math.max(vertical + duplicate, max);
            slope.clear();
            
        }
        return max;
        
    }
}