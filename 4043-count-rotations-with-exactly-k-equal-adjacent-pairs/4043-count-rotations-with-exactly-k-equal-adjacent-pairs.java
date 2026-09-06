class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int score = 0;
        for(int i=0;i<n;i++)
        {
            int cnt =0;
            for(int j=i+1;j<(i+n);j++)
            {
                if(s.charAt((j-1)%n) == s.charAt(j%n)) cnt++;
            }
            if(cnt == k) score++;
        }
        return score;
    }
}