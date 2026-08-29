class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int row = target[0];
        int col = target[1];
        int r = source[0];
        int c = source[1];
        char bishop = 'N';
        char tar = 'N';
        if((row%2) == 1)
        {
            if((col%2) == 1) tar = 'W';
            else tar = 'B';
        }
        else{
            if((col%2) == 1) tar = 'B';
            else tar = 'W';
        }
        if((r%2) == 1)
        {
            if((c%2) == 1) bishop = 'W';
            else bishop = 'B';
        }
        else{
            if((c%2) == 1) bishop = 'B';
            else bishop = 'W';
        }
        if(bishop != tar) return -1;
        else{
            if((col-row == c-r) || (row+col == r+c)) return 1;
        }
        return 2;
    }
}