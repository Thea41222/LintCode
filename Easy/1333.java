public class Solution {
    /**
     * @param n: an integer
     * @return: return an integer
     */
    public long reverseBits(long n) {
        // write your code here
        long result =0;
        for (int i =0; i<32; i++){
            //e.g -2>>1 = -1
            result = (result<<1)|(n&1);
            n>>=1;
        }
        
        return result;
        
    }
}