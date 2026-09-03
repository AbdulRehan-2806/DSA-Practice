class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        Arrays.sort(nums1);
        int odd = 0 , even = 0;
        for(int i=0;i<n;i++)
        {
            if(nums1[i]%2 == 1) even++;
            else odd++;
        }
        if(odd==0 || even==0) return true;
        odd = 0;
        for(int i=0;i<n;i++)
        {
            if(nums1[i]%2 == 1){
                odd++;
            }
            else{
                if(odd<=0) return false;
            }
        }
        return true;
    }
}