class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int time1 = 0;
        int time2 = 0;
        String[] t2 = endTime.split(":");
        String[] t1 = startTime.split(":");
        int hour1 = Integer.parseInt(t1[0]);
        int min1 = Integer.parseInt(t1[1]);
        int sec1 = Integer.parseInt(t1[2]);
        time1 += (hour1*3600)+(min1*60)+sec1;
        int hour2 = Integer.parseInt(t2[0]);
        int min2 = Integer.parseInt(t2[1]);
        int sec2 = Integer.parseInt(t2[2]);
        time2 += (hour2*3600)+(min2*60)+sec2;
        return time2-time1;
    }
}