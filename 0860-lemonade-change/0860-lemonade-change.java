class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0;
        int t = 0;
        int tw = 0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i] == 5)
            {
                f++;
                continue;
            }
            else if(bills[i] == 10)
            {
                t++;
                if(f>0)
                {
                    f--;
                    continue;
                }
                else return false;
            }
            else{
                tw++;
                if(f>0 && t>0 || t==0 && f>2)
                {
                    if(t>0){
                        f--;
                        t--;
                        continue;}
                    if(t==0)
                    {
                        f = f-3;
                        continue;
                    }
                }
                else return false;
            }
        }
        return true;
    }
}