public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }
       int[] result = new int[nums.length-k+1];

        //for 0 to size-k
        for (int i=0; i<nums.length-k+1; i++){
            int sum = 0;
            for(int j=0; j<k; j++){
                sum = sum + nums[i+j];
              
            }
            // System.out.println(sum);
            result[i]=sum;
            // System.out.println("i is : " + i);
        }
        
        return result;
    }
}