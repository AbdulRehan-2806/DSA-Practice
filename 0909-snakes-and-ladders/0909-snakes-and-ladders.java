class Solution {
    public int snakesAndLadders(int[][] board) {
        // Step - 1 creating connection array to simplify the board config
        int n = board.length;
        int[] connection = new int[n*n+1];
        Arrays.fill(connection,-1);
        int node = 1;
        boolean flag = true;
        for(int i=n-1;i>=0;i--)
        {
            if(flag)
            {
                for(int j=0;j<n;j++)
                {
                    if(board[i][j] != -1)
                        connection[node] = board[i][j];
                    node++;
                }
            }
            else{
                for(int j=n-1;j>=0;j--)
                {
                    if(board[i][j] != -1)
                        connection[node] = board[i][j];
                    node++;
                }
            }
            flag = !flag;
        }
        // Step - 2 Create a graph using Map storing nbr's for each node .
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1;i<=n*n-1;i++)
        {
            for(int count = 1 ; count <= 6 ; count++)
            {
                int nbr = i+count;
                if(nbr <= n*n)
                {
                    if(connection[nbr] != -1)
                    {
                        map.computeIfAbsent(i,k-> new ArrayList<>()).add(connection[nbr]);
                    }
                    else map.computeIfAbsent(i,k->new ArrayList<>()).add(nbr);
                }
            }
        }
        // Step - 3 Finding shortest path using BFS
        int level = 0;
        boolean[] vis = new boolean[n*n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;
        while(!q.isEmpty())
        {
            int sz = q.size();
            while(sz-->0)
            {
                int src = q.poll();
                if(src == n*n)
                    return level;
                for(int nbr : map.get(src))
                {
                    if(!vis[nbr])
                    {
                        q.offer(nbr);
                        vis[nbr] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}