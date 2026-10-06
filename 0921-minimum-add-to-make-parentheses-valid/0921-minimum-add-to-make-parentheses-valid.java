class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open = 0 , close = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(') open++;
            else if (c == ')' && open>0) open--;
            else close++;
        }
        return open+close;
    }
}