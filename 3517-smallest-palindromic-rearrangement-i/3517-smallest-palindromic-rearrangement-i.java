class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray())
        {
            int val = c - 'a';
            freq[val]++;
        }
        String res = "";
        char mid = 0;
        for(int i=0;i<26;i++)
        {
            int half = freq[i]/2;
            while(half-->0)
                res += (char)(i+'a');
            if(freq[i]%2 == 1) mid = (char)(i+'a');
        }
        String rev = new StringBuilder(res).reverse().toString();
        return mid == 0 ? res+rev : res+mid+rev;
    }
}