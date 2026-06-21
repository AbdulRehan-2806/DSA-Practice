class Solution {
    public int maxDistance(String moves) {
        int n = moves.length();
        int x = 0 , y = 0;
        int steps = 0;
        for(char c : moves.toCharArray())
        {
            if(c == 'U') y += 1;
            else if(c=='D') y -= 1;
            else if(c == 'R') x += 1;
            else if(c == 'L') x -= 1;
            else{
                steps++;
            }
        }
        while(steps>0)
        {
            if(x < 0) x -= 1;
            else if(y<0) y -=1 ;
            else if(x>=0) x += 1;
            else y += 1;
            steps--;
        }
        return Math.abs(0-x)+Math.abs(0-y);
    }
}