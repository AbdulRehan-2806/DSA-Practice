class Solution {
    static int[][] t = new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() , m = text2.length();
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                t[i][j] = 0;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    t[i][j] = t[i-1][j-1]+1;
                else
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
            }
        }
        return t[n][m];
    }
}