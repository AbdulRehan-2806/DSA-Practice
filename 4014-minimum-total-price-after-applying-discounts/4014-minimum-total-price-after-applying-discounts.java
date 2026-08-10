class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i= n-1;
        int j = m-1;
        double price = 0.0;
        while(i>=0 && j>=0)
        {
            double d = (double)((prices[i] * (100-discounts[j]*1.0))/100.0);
            price += d;
            i--;
            j--;
        }
        while(i>=0)
        {
            price += (double)(prices[i--]*1.0);
        }
        return price;
    }
}