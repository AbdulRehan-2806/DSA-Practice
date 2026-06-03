class Solution {
    static void generatePerm(int[] nums , int idx ,List<List<Integer>> ans)
    {
        if(idx == nums.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int n : nums) ds.add(n);
            ans.add(ds);
            return ;
        }
        for(int i=idx;i<nums.length;i++)
        {
            swap(nums , i , idx);
            generatePerm(nums , idx+1 ,ans);
            swap(nums , i , idx);
        }
    }
    static void swap(int[] arr , int i , int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generatePerm(nums , 0 , ans);
        HashSet<List<Integer>> hs = new HashSet<>();
        for(List<Integer> l : ans)
        {
            hs.add(l);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> l : hs)
        {
            res.add(l);
        }
        return res;
    }
}