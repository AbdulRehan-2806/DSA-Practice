class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        int len = (int)Math.pow(2,n);
        for(int i=0;i<len;i++)
        {
            String s = Integer.toBinaryString(i);
            StringBuilder sb = new StringBuilder(s);
            while(sb.length() > n) sb.deleteCharAt(0);
            while(sb.length() < n) sb.insert(0,'0');
            s = sb.reverse().toString();
            if(valid(s,k)) ans.add(s);
        }
        return ans;
    }
    static boolean valid(String s, int k)
    {
        int cost = 0;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i) == '1' && s.charAt(i+1) == '1') return false;
        }
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '1') cost += i;
            if(cost > k) return false;
        }
        return true;
    }
}