class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        HashSet<Integer> hs = new HashSet<>();
        int prev = 0;
        for(int i=0;i<n;i++)
        {
            if(hs.contains(A[i])) prev++;
            else hs.add(A[i]);
            if(hs.contains(B[i])) prev++;
            else hs.add(B[i]);
            C[i] = prev;
        }
        return C;
    }
}