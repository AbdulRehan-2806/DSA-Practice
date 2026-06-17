class Solution {
    public char processStr(String s, long k) {
        StringBuilder res = new StringBuilder();
        long sz = 0;
        char ans = '.';
        long[] len = new long[s.length()];
        for(int i=0;i<s.length();i++)
            {
                char ch  = s.charAt(i);
                if(Character.isLowerCase(ch)){
                    sz++;
                }
                else if(ch == '*'){
                    sz = Math.max(0,sz-1);
                }
                else if(ch == '#'){
                    sz *= 2;
                }
                len[i] = sz;
            }
        if(k>=sz) return '.';
        for(int i=s.length()-1;i>=0;i--)
            {
                char ch = s.charAt(i);
                long prev = (i==0)? 0 : len[i-1];
                long cur = len[i];
                switch(ch) {
                    case '%':
                        k = cur-1-k;
                        break;
                    case '#':
                        if(k>=prev) k-= prev;
                        break;
                    case '*':
                        if(k==cur) return '.';
                        break;
                    default:
                        if(k==cur-1) return ch;
                        break;
                }
            }
        return '.';
    }
}
