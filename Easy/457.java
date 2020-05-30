public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left +1 < right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid]>target){
                right = mid;
            }else{
                left = mid;
            }
        }
        
        if(nums[right] == target){
            return right;
        }
        if(nums[left] ==target ){
            return left;
        }
        
        return -1;
    }
}