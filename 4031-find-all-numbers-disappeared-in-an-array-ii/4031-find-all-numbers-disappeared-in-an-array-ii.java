class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int st = lower , ed = upper;
        List<Integer> al = new ArrayList<>();
        if(nums[0] > st)
        {
            al.add(st);
            al.add(Math.min(upper , nums[0]-1));
            ans.add(new ArrayList<>(al));
        }
        for(int i=0;i<n-1;i++)
        {
            int diff = nums[i+1] - nums[i];
            if(nums[i] >= upper) continue;
            func(ans , nums[i] , nums[i+1],lower,upper);
        }
        if(nums[n-1] < upper){
            al.clear();
            al.add(Math.max(nums[n-1]+1 , lower));
            al.add(ed);
            ans.add(new ArrayList<>(al));
        }
        return ans;
    }
    static void func(List<List<Integer>> ans , int st , int ed, int lower , int upper)
    {
        if(ed <= lower || ed-st <= 1) return ;
        List<Integer> al = new ArrayList<>();
        al.add(Math.max(st+1 , lower));
        al.add(Math.min(ed-1,upper));
        ans.add(new ArrayList<>(al));
    }
}