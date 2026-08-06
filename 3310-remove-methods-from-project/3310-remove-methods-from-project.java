class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
        }
        boolean[] flag = new boolean[n];
        flag[k] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (!flag[v]) {
                    flag[v] = true;
                    queue.offer(v);
                }
            }
        }
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            if (!flag[u] && flag[v]) {
                List<Integer> total = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    total.add(i);
                }
                return total;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                result.add(i);
            }
        }
        return result;
    }
}