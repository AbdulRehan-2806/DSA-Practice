class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> st = new Stack<>();
        int j=0;
        for(int i=0;i<n;i++)
        {
            st.push(pushed[i]);
            while(st.size()>0 && popped[j] == st.peek() )
            {
                st.pop();
                j++;
            }
        }
        if(st.isEmpty() && j>=n) return true;
        while(j<n)
        {
            if(st.peek() != popped[j]) return false;
            st.pop();
            j++;
        }
        return (st.isEmpty() && j>=n);
    }
}