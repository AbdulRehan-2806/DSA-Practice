class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        List<Character> al = new ArrayList<>();
        int max = 0 , cnt=0;
        int i=0;
        for(i=0;i<k;i++)
        {
            if(isVowel(s.charAt(i))) cnt++;
        }
        max = Math.max(max,cnt);
        while(i<n)
        {
            if(isVowel(s.charAt(i-k))) cnt--;
            if(isVowel(s.charAt(i))) cnt++;
            max = Math.max(max,cnt);
            i++;
        }
        return max;
        
    }
    static boolean isVowel(char c)
    {
        return "aeiou".indexOf(c) != -1;
    }
}