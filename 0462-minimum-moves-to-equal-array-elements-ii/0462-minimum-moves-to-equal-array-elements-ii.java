class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <=1) return 0;
        int moves = 0;
        int tar = nums[nums.length/2];
        for(int n : nums)
        {
            moves += Math.abs(n-tar);
        }
        return moves;
    }
}