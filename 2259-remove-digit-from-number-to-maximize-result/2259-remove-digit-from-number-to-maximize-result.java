class Solution {
    public String removeDigit(String number, char digit) {
        int len = number.length();
        String res = "";
        for(int i=0;i<len;i++)
        {
            char c = number.charAt(i);
            if(c == digit){
                String s = number.substring(0,i) + number.substring(i+1);
                if(s.compareTo(res) > 0) res = s;
            }
        }
        return res;
    }
}