class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int cnt = 0;
        for(int ele : nums)
        {
            while(!st.isEmpty() && st.peek() > ele) st.pop();
            if(ele == 0) continue;
            if(st.isEmpty() || st.peek() < ele){
                cnt++;
                st.push(ele);
            }
        }
        return cnt;

    }
}