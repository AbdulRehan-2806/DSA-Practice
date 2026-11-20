class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int num : nums)
        {
            hm.put(num+1,hm.getOrDefault(num,0)+1);
            hm.put(num,hm.getOrDefault(num-1,0)+1);
            max = Math.max(max , Math.max(hm.get(num),hm.get(num+1)));
        }        
        return max;
    }
}