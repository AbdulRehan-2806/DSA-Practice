class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        int correct = 0;
        while(i<nums.length)
        {
             correct = nums[i]-1;
            if(correct >= nums.length || correct<0){
                i++;
                continue;}
            if(nums[i] != nums[correct])
            {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else i++;
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i] != i+1){
                correct = i+1;
                break;}
            else{
                continue;
            }
        }
        if(i==nums.length)
            correct = nums.length+1;
        return correct;
    }
}