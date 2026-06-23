class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        Arrays.fill(ans,"#");
        String s = "";
        for(int i=0;i<n;i++)
        {
            s += ".";
        }
        ans[0] = s;
        for(int j=1;j<m;j++)
        {
            s = "";
            for(int i=0;i<n;i++)
            {
                if(i == n-1) s += ".";
                else
                    s += "#";
            }
            ans[j] = s;
        }
        return ans;
        
    }
}