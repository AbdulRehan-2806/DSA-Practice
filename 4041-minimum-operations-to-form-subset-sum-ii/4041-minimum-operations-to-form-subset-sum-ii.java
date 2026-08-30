class Solution {
    public int minOperations(int[] nums, int sum) {
        int INF = 1000000;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int x : nums) {
            int[] cost = getCosts(x, sum);
            int[] newDp = dp.clone();
            for (int value = 1; value <= sum; value++) {
                if (cost[value] == INF)
                    continue;
                for (int s = 0; s + value <= sum; s++) {
                    if (dp[s] != INF) {
                        newDp[s + value] = Math.min(
                            newDp[s + value],
                            dp[s] + cost[value]
                        );
                    }
                }
            }
            dp = newDp;
        }
        return dp[sum] == INF ? -1 : dp[sum];
    }
    private int[] getCosts(int x, int sum) {
        int INF = 1000000;
        int[] cost = new int[sum + 1];
        Arrays.fill(cost, INF);
        Queue<Integer> q = new LinkedList<>();
        if (x <= sum) {
            cost[x] = 0;
            q.add(x);
        } else {
            int value = x;
            int operations = 0;
            while (value > sum) {
                value /= 2;
                operations++;
            }
            if (value > 0) {
                cost[value] = operations;
                q.add(value);
            }
        }
        while (!q.isEmpty()) {
            int value = q.poll();
            int operations = cost[value];
            int next = value * 2;
            if (next <= sum && cost[next] > operations + 1) {
                cost[next] = operations + 1;
                q.add(next);
            }
            next = value / 2;
            if (next > 0 && cost[next] > operations + 1) {
                cost[next] = operations + 1;
                q.add(next);
            }
        }
        return cost;
    }
}