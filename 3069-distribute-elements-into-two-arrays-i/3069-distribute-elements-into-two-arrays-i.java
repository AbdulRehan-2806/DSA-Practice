class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int a1 = nums[0] , a2 = nums[1];
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(a1);
        b.add(a2);
        for(int i=2;i<n;i++)
        {
            if(a1>a2)
            {
                a1 = nums[i];
                a.add(a1);
            }
            else{
                a2 = nums[i];
                b.add(a2);
            }
        }
        int i = 0;
        for(int ele : a) nums[i++] = ele;
        for(int ele : b) nums[i++] = ele;
        return nums;
    }
}