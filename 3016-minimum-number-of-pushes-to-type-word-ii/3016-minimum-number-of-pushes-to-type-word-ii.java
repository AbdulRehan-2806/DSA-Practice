class Solution {
    class Pair{
        char key;
        int freq;
        Pair(char key , int freq)
        {
            this.key = key;
            this.freq = freq;
        }
    }
    public int minimumPushes(String word) {
        int n = word.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : word.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        ArrayList<Pair> al = new ArrayList<>();
        for(char key : hm.keySet())
        {
            Pair p = new Pair(key,hm.get(key));
            al.add(p);
        }
        Collections.sort(al,(a,b)->{
            if(a.freq != b.freq) return Integer.compare(b.freq,a.freq);
            else return 0;
        });
        for(int i=0;i<al.size();i++)
        {
            Pair p = al.get(i);
            System.out.println(p.key +" "+ p.freq);
        }
        int moves = 0;
        int p=1;
        for(int i=0;i<al.size();i++)
        {
            if((i%8) == 0 && i>0) p++;
            Pair pair = al.get(i);
            char c = pair.key;
            int f = pair.freq;
            moves += (p*f);
            f -= 8;
        }
        return moves;
    }
}