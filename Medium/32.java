import java.lang.*;
public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        int source_length = source.length();
        int target_length = target.length();
        if(source_length < target_length){
            return "";
        }
        String result = "";
        Map<Character, Integer> hash_source = new HashMap< Character, Integer>();
        Map<Character, Integer> hash_target = new HashMap< Character, Integer>();
        for (int i = 0; i< target_length;i++){
            int count = hash_target.getOrDefault(target.charAt(i),0);
            hash_target.put(target.charAt(i),count+1);

        } 
        
        int total = 0;
        int min_size = Integer.MAX_VALUE;
        //left, right
        int l = 0;
        for(int r = 0; r < source_length; r++){
            char c = source.charAt(r);
            if(!hash_target.containsKey(c)){
                continue;
            }
            int count = hash_source.getOrDefault(source.charAt(r),0);
            if(count < hash_target.get(c)){
                total ++ ;
            }
            // System.out.println("total " + total);
            // System.out.println("target" +  target_length);
            hash_source.put(c,count+1);
            if(total == target_length){
            // System.out.println("TEST:"+ l + "  " + r);
                while(!hash_target.containsKey(source.charAt(l)) || hash_source.get(source.charAt(l))>hash_target.get(source.charAt(l)) ){

                    char t = source.charAt(l);
                    if(hash_target.containsKey(t) && hash_source.get(t) > hash_target.get(t)){
                        hash_source.put(t,hash_source.get(t)-1);
                    }
                    l++;
                }
                if(min_size > r-l+1){
                    min_size = r-l+1;
                    result = source.substring(l,r+1);
                }

            }
            
        }

        return result;
    }
}