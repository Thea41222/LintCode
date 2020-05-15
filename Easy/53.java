public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        String result = "" ;
        for(int i = words.length-1; i>= 0 ; i--){
            result = result + words[i] + " ";
             
        }
        return result.trim();
    }
}