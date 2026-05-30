class Solution {

    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount + 1];
        int i = 1;

        while(i <= amount){
            int res = 10001;
            for(int coin : coins){
                if(i < coin) continue;
                res = Math.min(res, dp[i - coin] + 1);
            }
            dp[i] = res;
            i++;
        }



        return dp[amount] == 10001 ? -1 : dp[amount];


    }
}
