class Solution {
    int[] coins;
    int n;
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.n = coins.length;
        this.memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        int res = dfs(amount);
        return res == 10001 ? -1 : res;


    }

    public int dfs(int amount){
        int res = 10001;
        if(memo[amount] != -1)
            return memo[amount];
        for(int i = 0; i<n; i++){
            if(coins[i] > amount) continue;
            res = Math.min(dfs(amount - coins[i]) + 1,res);
        }
        memo[amount] = res;
        return res;
    }
}
