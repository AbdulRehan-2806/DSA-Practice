class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> l = new ArrayList<>();
        if(n<10) return l;
        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("");
        int i=0;
        for(i=0;i<=9;i++)
        {
            char c = s.charAt(i);
            sb.append(c);
        }
        String str = sb.toString();
        map.put(str,map.getOrDefault(str,0)+1);
        while(i<n)
        {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String st = sb.toString();
            map.put(st,map.getOrDefault(st,0)+1);
            i++;
        }
        for(String string : map.keySet())
        {
            if(map.get(string)>1) l.add(string);
        }
        return l;
    }
}