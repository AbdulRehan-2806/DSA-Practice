class Solution {
    public boolean isPalindromic(String s) {
        int len = s.length();
        String bin = "";
        for(char c : s.toCharArray())
        {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString((int)c));
            while(sb.length() < 8) sb.insert(0,'0');
            while(sb.length() > 8) sb.deleteCharAt(sb.length()-1);
            bin = bin + sb;
        }
        System.out.println(bin);
        StringBuilder rev = new StringBuilder(bin);
        return (bin.equals(rev.reverse().toString()));
    }
}