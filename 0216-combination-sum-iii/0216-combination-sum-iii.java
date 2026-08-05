class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        func(k,1,n,new ArrayList<>() , ans);
        return ans;
    }
    static void func(int k , int num , int target , ArrayList<Integer> al , List<List<Integer>> ans)
    {
        if(k == 0 && target == 0){
            ans.add(new ArrayList<>(al));
            return ;
        }
        for(int i=num;i<10;i++)
        {
            if(i>target || k<=0) break;
            al.add(i);
            func(k-1,i+1,target-i,al,ans);
            al.remove(al.size()-1);
        }
    }
}