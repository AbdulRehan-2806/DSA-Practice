class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String digits = "123456789";
        int k = func(low);
        int hi = func(high);
        if(k==10) return ans;
        if(hi == 10) hi--;
        int i=0;
        while(k<=hi)
        {
            StringBuilder res = new StringBuilder("");
            for(i=0;i<k;i++)
            {
                res.append(digits.charAt(i));
            }
            int val = Integer.parseInt(res.toString());
            if(low<=val && val<=high) ans.add(val);
            i=k;
            while(i<9)
            {
                res.deleteCharAt(0);
                res.append(digits.charAt(i));
                val = Integer.parseInt(res.toString());
                if(low<=val && val<=high) ans.add(val);
                else if(val > high) break;
                i++;
            }
            k++;
        }
        return ans;
    }
    static int func(int n)
    {
        int cnt = 0;
        while(n>0)
        {
            n /= 10;
            cnt++;
        }
        return cnt;
    }
}