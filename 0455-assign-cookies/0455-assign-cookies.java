class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i=n-1 , j = m-1;
        while(i>=0 && j>=0)
        {
            if(s[j] >= g[i]){
                i--;
                j--;
            }
            else{
                i--;
            }
        }
        if(j<0) return m;
        return m-j-1;
    }
}