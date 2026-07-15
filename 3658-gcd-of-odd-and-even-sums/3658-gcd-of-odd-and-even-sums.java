class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0 , sumEven = 0;
        int i = 1 , cnt = 0;
        while(cnt < n)
            {
                sumOdd += i;
                sumEven += (i+1);
                i+=2;
                cnt++;
            }
        return Gcd(sumOdd,sumEven);
    }
    static int Gcd(int a , int b)
    {
        if(b == 0) return a;
        else return Gcd(b,(a%b));
    }
}