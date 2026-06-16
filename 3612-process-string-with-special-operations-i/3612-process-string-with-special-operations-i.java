class Solution {
    public String processStr(String s) {
        StringBuilder res = new StringBuilder();
        int sz=0;
        for(char ch : s.toCharArray())
            {
                if(Character.isLowerCase(ch)){
                    res.append(ch);
                    sz++;
                }
                else if(ch == '*'){
                    if(sz>0){
                        res.deleteCharAt(sz-1);
                        sz--;
                    }
                }
                else if(ch == '#'){
                    if(res.length()>0){
                    res.append(res);
                    sz=res.length();}
                }
                else if(ch == '%') res.reverse();
            }
        return res.toString();
    }
}