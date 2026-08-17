class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int floor = 0;
        int time = 0;
        for(int f : requests)
        {
            time += Math.abs(f - floor);
            floor = f;
        }
        return time;
    }
}