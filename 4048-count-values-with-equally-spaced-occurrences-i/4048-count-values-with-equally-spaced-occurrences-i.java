class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        boolean[] flag = new boolean[101];
        for(int i=0;i<n;i++)
        {
            int e = nums[i];
            if(! hm.containsKey(e))
            {
                List<Integer> al = new ArrayList<>();
                al.add(i);
                hm.put(e,al);
            }
            else{
                List<Integer> al = hm.get(e);
                al.add(i);
                hm.put(e,al);
                if(al.size() == 3)
                {
                    if(al.get(1) - al.get(0) == al.get(2) - al.get(1)){
                        if(! vis.contains(e)){
                            flag[e] = true;
                            vis.add(e);
                        }
                    }
                }
                else if(vis.contains(e)) flag[e] = false;
            }
        }
        int cnt = 0;
        for(boolean b : flag) if(b) cnt++;
        return cnt;
    }
}