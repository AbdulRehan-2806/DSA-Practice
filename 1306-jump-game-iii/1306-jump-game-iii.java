class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        return func(arr,start,vis);
    }
    static boolean func(int[] arr , int pos, boolean[] vis)
    {
        if(pos<0 || pos>=arr.length) return false;
        if(arr[pos] == 0) return true;
        vis[pos] = true;
        boolean right = false , left = false;
        if(pos+arr[pos] < arr.length && !(vis[pos+arr[pos]])) right =func(arr,pos+arr[pos],vis);
        if(pos-arr[pos] >=0 && !(vis[pos-arr[pos]])) left = func(arr,pos-arr[pos],vis);
        return  left | right;
    }
}