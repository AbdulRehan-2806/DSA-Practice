class Solution {
    public int passwordStrength(String password) {
        Set<Character> hs = new HashSet<>();
        int ans = 0;
        for(char c : password.toCharArray())
        {
            if(!hs.contains(c) && Character.isLowerCase(c)){
                ans += 1;
                hs.add(c);
            }
            else if(!hs.contains(c) && Character.isUpperCase(c)){
                ans += 2;
                hs.add(c);
            }
            else if(!hs.contains(c) && Character.isDigit(c))
            {
                ans += 3;
                hs.add(c);
            }
            else if(!hs.contains(c) && isSpecial(c))
            {
                ans += 5;
                hs.add(c);
            }
        }
        return ans;
    }
    static boolean isSpecial(char c)
    {
        if(c == '!' || c=='@' || c=='#' || c=='$') return true;
        return false;
    }
}