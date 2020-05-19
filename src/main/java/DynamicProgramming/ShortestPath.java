package DynamicProgramming;

class ShortestPath {
    public boolean canJump(int[] nums) {
        return minJumps(nums,0,new int[nums.length]) != Integer.MAX_VALUE;
    }
    //2,3,1,1,4
    public int minJumps(int[] nums,int i,int[] dp) {//1
        // System.out.println(i);
        if(i >= nums.length-1){
            return 0;
        }
        // System.out.println(nums[i]);
        if(dp[i] != 0){
            return dp[i];
        }
        
        int min = Integer.MAX_VALUE;
        for(int j= 1;j <= nums[i];j++){
            int jumps = minJumps(nums,i+j,dp);
            if(jumps != Integer.MAX_VALUE){
                min = Math.min(jumps+1,min);   
            }
        }
        if(dp[i] == 0){
            dp[i] = min;
        }else {
            dp[i] = Math.min(dp[i],min);   
        }
        return dp[i];
    }

    int jump(int A[], int n) {
        if(n<2)return 0;
        int level=0,currentMax=0,i=0,nextMax=0;

        while(currentMax-i+1>0){		//nodes count of current level>0
            level++;
            for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
                nextMax=Math.max(nextMax,A[i]+i);
                if(nextMax>=n-1)return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax=nextMax;
        }
        return 0;
    }
}