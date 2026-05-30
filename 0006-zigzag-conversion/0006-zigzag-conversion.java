class Solution {
    public String convert(String s, int numRows) {
        List<List<Character>> hm = new ArrayList<>();
        for(int r = 0;r<numRows;r++)
        {
            hm.add(new ArrayList<>());
        }
        int n = s.length();
        int i = 0;
        while(i<n)
        {
            for(int down = 0;down<numRows && i<n;down++)
            {
                hm.get(down).add(s.charAt(i++));
            }
            for(int up = numRows-2;up>0  && i<n;up--)
            {
                hm.get(up).add(s.charAt(i++));
            }
        }
        String ans = "";
        for(i=0;i<numRows;i++)
        {
            for(int j=0;j<hm.get(i).size();j++)
            ans += hm.get(i).get(j);
        }
        return ans;
    }
}