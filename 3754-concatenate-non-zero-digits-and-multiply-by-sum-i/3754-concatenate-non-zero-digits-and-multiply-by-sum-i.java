class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder num = new StringBuilder("");
        long sum = 0;
        long t = (long)n;
        while(t>0)
            {
                int rem = (int)t%10;
                if(rem != 0){
                    sum += rem;
                    num.append(Integer.toString(rem));
                }
                t = t/10;
            }
        if(num.length() == 0) return 0;
        num.reverse();
        long ans = (long)Integer.parseInt(num.toString());
        return ans*sum;
    }
}