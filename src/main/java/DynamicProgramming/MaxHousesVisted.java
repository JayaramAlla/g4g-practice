package DynamicProgramming;

public class MaxHousesVisted {
    /*
     * created by Jayaram on 21/12/19
     * array with house garbage , person to collect garbage cannot collect from to adjacent houses
     */



    public int houseCount(int initial ,int[] houses, int capacity,int[][] dp){
        if(capacity <= 0 || initial  >= houses.length){
            return 0;
        }
        if(dp[initial][capacity] != -1){
            return dp[initial][capacity];
        }

        int withConsideration =0 ;
        if(capacity > houses[initial]){
            withConsideration = houseCount(initial + 2, houses, capacity - houses[initial],dp);
        }

        int without = houseCount(initial + 1, houses, capacity,dp);
        dp[initial][capacity] = withConsideration > without ? withConsideration : without;
        return dp[initial][capacity];
    }

    


}
