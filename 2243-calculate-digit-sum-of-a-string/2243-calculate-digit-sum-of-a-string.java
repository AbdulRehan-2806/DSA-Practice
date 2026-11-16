class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        while(sb.length()>k)
        {
            int len = sb.length();
            int groups = len/k;
            if(len%k != 0) groups += 1;
            int ptr = 0;
            StringBuilder ans = new StringBuilder("");
            for(int i=0;i<groups;i++)
            {
                int end = ptr+k;
                if(ptr+k > sb.length()) end = sb.length();
                String sub = sb.toString().substring(ptr , end);
                int sum = calc(sub);
                String str = Integer.toString(sum);
                ans.append(str);
                ptr += k;
            }
            sb = new StringBuilder("");
            sb.append(ans);
        }
        return sb.toString();
    }
    static int calc(String s)
    {
        int sum = 0;
        for(char c : s.toCharArray())
        {
            sum += (c-'0');
        }
        return sum;
    }
}