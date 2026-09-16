class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        helper(1,al,ans,n,k);
        return ans;
    }
    static void helper(int st , List<Integer> al , List<List<Integer>> ans , int n , int k)
    {
        if(al.size() == k)
        {
            ans.add(new ArrayList<>(al));
            return ;
        }
        for(int i=st;i<=n;i++)
        {
            al.add(i);
            helper(i+1,al,ans,n,k);
            al.remove(al.size()-1);
        }
    }
}