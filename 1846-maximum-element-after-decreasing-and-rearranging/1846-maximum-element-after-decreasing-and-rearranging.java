class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        if(n==1) return 1;
        Arrays.sort(arr);
        int max = 1;
        arr[0] = 1;
        for(int i=1;i<n;i++)
        {
            if(Math.abs(arr[i]-arr[i-1]) > 1){
                arr[i] = arr[i-1]+1;
            }
            max = Math.max(max,arr[i]);
        }
        return max;
        
    }
}
// [1 , 100 , 1000]
//[9 , 98 , 73]