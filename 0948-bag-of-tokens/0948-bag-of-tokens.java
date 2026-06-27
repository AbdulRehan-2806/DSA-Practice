class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int score = 0;
        int i=0 , j = n-1;
        while(i<=j)
        {
            if(power >= tokens[i]){
                score++;
                power -= tokens[i++];
            }
            else if(i<j && score > 0)
            {
                score--;
                power += tokens[j--];
            }
            else return score;
        }
        return score;
    }
}