class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> h1 = new HashMap<>();
        HashMap<Character,Integer> h2 = new HashMap<>();
        for(char c : word1.toCharArray())
        {
            h1.put(c,h1.getOrDefault(c,0)+1);
        }
        for(char c : word2.toCharArray())
        {
            h2.put(c,h2.getOrDefault(c,0)+1);
        }
        if (!h1.keySet().equals(h2.keySet()))
            return false;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(char key : h1.keySet())
        {
            l1.add(h1.get(key));
        }
        for(char key : h2.keySet())
        {
            l2.add(h2.get(key));
        }
        if(l1.size() != l2.size()) return false;
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}