class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = lights.length;
        int time = 0;
        int max = 0;
        for(int l : lights) max = Math.max(max,l);
        for(int t : arrivalTime)
        {
            int r = t % period;
            if(r >= max){
                time = Math.max(time , period - r);
            }
        }
        return time;
    }
}