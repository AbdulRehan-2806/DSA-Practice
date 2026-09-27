class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> dq = new ArrayDeque<>();
        dq.push(new StringBuilder());
        for(char c : s.toCharArray())
        {
            if(c == '(') dq.offer(new StringBuilder());
            else if(c == ')'){
                StringBuilder sb = dq.pollLast();
                dq.peekLast().append(sb.reverse());
            }
            else dq.peekLast().append(c);
        }
        return dq.pollLast().toString();
    }
}