class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        boolean turn = false;
        for(int i=10;i>=1;i--)
        {
            if(n-i < 0) return turn;
            n -= i;
            turn = !turn;
        }
        return true;
    }
}

// 22 -> 12 -> 3