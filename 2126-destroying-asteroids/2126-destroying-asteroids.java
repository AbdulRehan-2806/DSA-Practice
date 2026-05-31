class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        long ans = mass;
        for(int i=0 ; i<n;i++)
        {
            if(arr[i] > ans) return false;
            else ans += (long)arr[i];
        }
        return true;
    }
}