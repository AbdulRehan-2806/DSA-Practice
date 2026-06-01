class Solution {
    public void nextPermutation(int[] nums) {
        int p=-1;
        for (int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                p=i;
                break;
            }
        }
        if (p==-1)
        {
            int i=0,j=nums.length-1;
            while(i<j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
            return ;
        }
        for(int i=nums.length-1;i>p;i--)
        {
            if(nums[i]>nums[p])
            {
                int temp=nums[i];
                nums[i]=nums[p];
                nums[p]=temp;
                break;
            }
        }
        int i=p+1,j=nums.length-1;
        while(i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        
    }
}