class Solution {
    public double angleClock(int hour, int minutes) {
        double h = (hour%12)*5*6 + (minutes*0.5);
        double m = minutes*6;
        double ans = Math.abs(h-m);
        return Math.min(ans,360-ans);

    }
}


// 30*6 = 180

// 1min = 6 deg
// 1hr = 30 deg
// every 1 min = hr hand move by 0.5 deg


// 180 - 90 = 90

// 30 * 0.5 = 15



// 15min = 15*6 = 90
// 15 * 0.5 = 7.5


// 30 = 180
// 30*0.5 = 15