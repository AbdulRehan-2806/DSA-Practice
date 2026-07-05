class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int x=0 , y=0;
        for(int j=0;j<m;j++)
            {
                char c = t.charAt(j);
                int x1 = x;
                int y1 = y;
                if(y < n && s.charAt(y) == c)
                    y1 = Math.max(y1,y+1);
                if(x < n)
                    y1 = Math.max(y1,x+1);
                if(x < n && s.charAt(x) == c)
                        x1 = Math.max(x1,x+1);
                x = x1;
                y = y1;
                if(x == n || y==n) return true;
                    
            }
        return x == n || y == n;
    }
}