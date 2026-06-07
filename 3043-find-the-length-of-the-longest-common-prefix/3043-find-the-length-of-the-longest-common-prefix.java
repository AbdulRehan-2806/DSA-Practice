class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int ans = 0;
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int num = arr1[i];
            StringBuilder sb = new StringBuilder(Integer.toString(arr1[i]));
            String res = "";
            for(char c : sb.toString().toCharArray())
            {
                res += c;
                hs.add(res);
            }
        }
        for(int i=0;i<m;i++)
        {
            int num = arr2[i];
            StringBuilder sb = new StringBuilder(Integer.toString(arr2[i]));
            String res = "";
            for(char c : sb.toString().toCharArray())
            {
                res += c;
                if(hs.contains(res)) ans = Math.max(ans , res.length());
            }
            
        }
        return ans;
    }
}