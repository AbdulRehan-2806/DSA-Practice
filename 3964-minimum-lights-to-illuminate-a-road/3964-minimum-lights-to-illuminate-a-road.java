class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int[] max = new int[n];
        Arrays.fill(max,-1);
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            if(lights[i]>0)
            {
                int l = Math.max(0,i-lights[i]);
                int r = Math.min(n-1,i+lights[i]);
                max[l] = Math.max(max[l],r);
            }
        }
        int c = -1;
        for(int i=0;i<n;i++)
        {
            if(i>c)
            {
                if(max[i] == -1)
                {
                    ans++;
                    c = Math.min(n-1,i+2);
                }
                else c = max[i];
            }
            else{
                if(max[i] != -1)
                    c = Math.max(c,max[i]);
            }
        }
        //if(cur< n-1) ans++;
        return ans;
    }
}