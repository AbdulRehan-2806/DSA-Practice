class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int key = nums[i];
            hm.computeIfAbsent(key , k-> new ArrayList<>()).add(i);
        }
        int cnt = 0;
        for(int key : hm.keySet())
        {
            List<Integer> al = hm.get(key);
            if(al.size()<3) continue;
            int diff = al.get(1) - al.get(0);
            boolean flag = true;
            for(int i=2;i<al.size();i++){
                if(al.get(i)-al.get(i-1) != diff){
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        return cnt;
    }
}