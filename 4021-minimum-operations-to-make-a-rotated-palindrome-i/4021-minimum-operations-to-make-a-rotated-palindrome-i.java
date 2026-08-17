class Solution {
    public int minOperations(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        int ans = Integer.MAX_VALUE;
        for(int rotation = 0 ; rotation < len ; rotation++)
        {
            if(rotation > 0){
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
            }
            int operations = helper(sb.toString() , sb.length());
            //System.out.println(sb.toString()+" "+operations);
            ans = Math.min(ans , rotation+operations);
        }
        return ans;
    }
    static int helper(String s , int len)
    {
        int i = 0 , j = len-1;
        int op = 0;
        while(i<j)
        {
            int a = (int)s.charAt(i);
            int b = (int)s.charAt(j);
            op += Math.min(Math.abs(a-b) , 26 - Math.abs(a-b));
           // System.out.println(op);
            i++;
            j--;
        }
        return op;
    }
}