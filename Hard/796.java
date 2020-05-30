public class Solution {
    /**
     * @param deadends: the list of deadends
     * @param target: the value of the wheels that will unlock the lock
     * @return: the minimum total number of turns 
     */
    public int openLock(String[] deadends, String target) {
        // Write your code here
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> lock = new LinkedList<> ();
        if (dead.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;
        int time = 0;
        //start from 0000
        lock.addAll(Arrays.asList("0000"));
        while(!lock.isEmpty()){
            time++;
            for(int n = lock.size(); n > 0; n--){
                String node = lock.poll();
                if(node == target){
                    return time;
                }
                for(int j = 0; j<4; j++){
                    for(int dif = 1; dif <=9; dif+=8){
                        char[] current = node.toCharArray();
                        current[j]= (char)((current[j] - '0' + dif) % 10 + '0');
                        String s = new String(current);
                        //System.out.println(current);
                        if(target.equals(s)){
                            return time;
                        }
                        if(!dead.contains(s) && !visited. contains(s)){
                            lock.add(s);
                        }
                        visited.add(s);
                        //System.out.println(lock);
                    }
                }
            }
        }

        return -1;
    }
}