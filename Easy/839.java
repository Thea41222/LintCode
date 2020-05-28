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
public class Solution {

    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public void merge (List<Interval> list, Interval previous, Interval current){
                /*
                list = (1,2) previous = (1,2) current = (2,3)
                current.start<=previous.end merge-> (1,3)
                previous
                [(1,2),(3,4)]
                [(2,3),(5,6)]
                */
                // System.out.println("start "+ current.start);
                // System.out.println("end: "+ previous.end);
                if(current.start<=previous.end){
                    previous.end= Math.max(previous.end,current.end);
                }else{
                    list.add(current);
                }
    }
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        //step 1: sort 
        if(list1 ==null || list1.size()==0){
            return list2;
        }
        if(list2 ==null || list2.size()==0){
            return list1;
        }
        
        int i = 0, j= 0;
        Interval current = null;
        List<Interval> mergeList = new ArrayList<>();
                
        while(i < list1.size() && j< list2.size()){
            //step 1: get interval from list1 and list 2 and compare 
            Interval i1 = list1.get(i), i2 = list2.get(j);
            if(i1.start <= i2.start){
                /*
                [(1,2),(3,4)]
                [(2,3),(5,6)]
                1<4 current = (1,2)
                */
                current = i1;
                i++;
            }else{
                current = i2;
                j++;
            }
            //step 2: merge
            if(mergeList.isEmpty()){
                mergeList.add(current);
            }else{
                //merge with previous
                merge(mergeList, mergeList.get(mergeList.size()-1), current);
            }
        }
        //remain list1
        while(i<list1.size()){
             merge(mergeList, mergeList.get(mergeList.size()-1), list1.get(i++));
        }
        //remain list2
        while(j<list2.size()){
            //System.out.println("test");
            merge(mergeList, mergeList.get(mergeList.size()-1), list2.get(j++));
        }
        
        return mergeList;
    }
}