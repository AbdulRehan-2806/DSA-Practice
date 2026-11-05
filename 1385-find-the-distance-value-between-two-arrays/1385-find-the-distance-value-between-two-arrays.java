class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++)
        {
            if(notInRange(arr1[i]-d , arr1[i]+d , arr2)) cnt++;
        }
        return cnt;
    }
    static boolean notInRange(int st , int ed , int[] arr)
    {
        int lo = 0 , hi = arr.length-1;
        while(lo<=hi)
        {
            int m = lo+(hi-lo)/2;
            if(st<=arr[m] && arr[m] <= ed) return false;
            else if(arr[m] < st) lo = m+1;
            else hi = m-1;
        }
        return true;
    }
}