class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n = series1.length;
        int m = series2.length;
        TreeSet<Integer> list = new TreeSet<>();
        for(int[] arr : series1)
        {
            int t = arr[0];
            list.add(t);
        }
        for(int[] arr : series2)
        {
            int t = arr[0];
            list.add(t);
        }
        List<List<Integer>> ans = new ArrayList<>();
        int j = 0 , k = 0;
        for(int i : list)
        {
            int t1 = 0 , t2 = 0 , val1 = 0 , val2 = 0;
            if(j>=n)
            {
                t1 = i;
                val1 = 0;
            }
            else{
                t1 = series1[j][0];
                val1 = series1[j][1];
            }
            if(k>=m)
            {
                t2 = i;
                val2 = 0;
            }
            else{
                t2 = series2[k][0];
                val2 = series2[k][1];
            }
            int sum = val1+val2;
            List<Integer> al = new ArrayList<>();
            al.add(i);
            al.add(sum);
            ans.add(al);
            if(t1 == i) j++;
            if(t2 == i) k++;
        }
        return ans;
    }
}