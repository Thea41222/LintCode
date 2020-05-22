public class Solution {
    /**
     * @param s: a string
     * @return: it's index
     */
    public int firstUniqChar(String s) {
        //check ""
        if(s.length()==0){
            return -1;
        }
        // write your code here
        //use hashmap to store char
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i<s.length(); i++){
            int count = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),count+1);
        }
        int index=0;
        //System.out.println(map);
        for(int i =0; i<s.length();i++){
            //System.out.println("c is "+ c + " " +count);
            if(map.get(s.charAt(i)) == 1) {
                index = i;
                break;
            }
        }
        //check "aa"
        if(index == 0){
            if(map.get(s.charAt(0)) != 1) {
                return -1;
            }
        }
        
        return index;
    }
}