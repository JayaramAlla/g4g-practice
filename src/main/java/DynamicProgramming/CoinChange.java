package DynamicProgramming;
/*
You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.
 */
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        int[] dp = new int[amount+1];
        for(int i =1;i<=amount;i++){
            for(int j=coins.length-1;j>=0;j--){
                if(i-coins[j] >= 0 && (dp[i-coins[j]] > 0 || i-coins[j] ==0)){
                    if(dp[i] > 0 ){
                        if(dp[i] > dp[i-coins[j]]+1)
                            dp[i] = dp[i-coins[j]]+1;
                    }else{
                        dp[i] = dp[i-coins[j]]+1;    
                    }
                }       
            }
        }
        return dp[amount] > 0? dp[amount]: -1;
    }
}