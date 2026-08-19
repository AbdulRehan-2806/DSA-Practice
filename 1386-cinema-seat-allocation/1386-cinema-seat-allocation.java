class Solution {
    public int maxNumberOfFamilies(int n, int[][] reserved) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int[] seat : reserved) {
            hm.computeIfAbsent(seat[0], k -> new ArrayList<>())
              .add(seat[1]);
        }
        int ways = (n - hm.size()) * 2;
        for (List<Integer> seats : hm.values()) {
            boolean left = true;   
            boolean middle = true; 
            boolean right = true;  
            for (int seat : seats) {
                if (seat >= 2 && seat <= 5)
                    left = false;

                if (seat >= 4 && seat <= 7)
                    middle = false;

                if (seat >= 6 && seat <= 9)
                    right = false;
            }
            if (left && right) {
                ways += 2;
            } else if (left || middle || right) {
                ways += 1;
            }
        }
        return ways;
    }
}