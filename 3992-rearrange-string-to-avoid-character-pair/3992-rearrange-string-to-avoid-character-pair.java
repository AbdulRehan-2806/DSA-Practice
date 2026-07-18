class Solution {
    public String rearrangeString(String s, char x, char y) {
        String res = "";
        int cnt = 0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == x){
                cnt++;
            }
            else res += c;
        }
        while(cnt>0){
            res += x;
            cnt--;
        }
        return res;
    }
}