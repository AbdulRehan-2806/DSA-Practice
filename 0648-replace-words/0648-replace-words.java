class Solution {
    public String replaceWords(List<String> d, String s) {
        int n = d.size();
        String[] w = s.split(" ");
        String ans = "";
        HashMap<String,String> hm = new HashMap<>();
        for(String str : w)
        {
            hm.put(str,"");
        }
        for(String str : d)
        {
            for(String key : hm.keySet())
            {
                if(key.startsWith(str))
                {
                    if(hm.get(key) == "") hm.put(key,str);
                    else if(str.length() < hm.get(key).length()) hm.put(key,str);
                }
            }
        }
        for(String word : w)
        {
            if(hm.get(word).equals("")) ans += word+" ";
            else ans += hm.get(word)+" ";
        }
        return ans.substring(0,ans.length()-1);

    }
}