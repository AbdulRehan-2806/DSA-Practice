class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i=0,j=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int sum = 0;
        while(j<n)
        {
            hm.put(s.charAt(j),hm.getOrDefault(s.charAt(j),0)+1);
            while(i<n && hm.size() >= 3)
            {
                sum += n-j;
                hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)-1);
                if(hm.get(s.charAt(i)) == 0) hm.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return sum;
    }
}