class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int res = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        generate( 0 ,  nums , subset ,  ans);
        int max = 0;
        for(List<Integer> al : ans)
        {
            int or = 0;
            for(int num : al){
                or |= num;
            }
            max = Math.max(max,or);
        }
        for(List<Integer> al : ans)
        {
            int or = 0;
            for(int num : al){
                or |= num;
            }
            if(or == max)
            {
                res++;
            }
        }
        return res;           
    }
    static void generate(int i , int[] arr , List<Integer> subset , List<List<Integer>> ans)
    {
            if(i == arr.length)
            {
                ans.add(new ArrayList<>(subset));
                return ;
            }
            subset.add(arr[i]);
            generate(i+1,arr,subset,ans);
            subset.remove(subset.size()-1);
            generate(i+1,arr,subset,ans);
    }
}