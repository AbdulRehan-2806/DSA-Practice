class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;
        int min = Integer.MAX_VALUE;
        int mini = -1;
        int i = 0;
        for(int[] d : drones)
        {
            int dist = (Math.abs(d[0]-target[0]) + Math.abs(d[1]-target[1]));
            if(dist <= d[2] && dist < min)
            {
                min = dist;
                mini = i;
            }
            i++;
        }
        return mini;
    }
}