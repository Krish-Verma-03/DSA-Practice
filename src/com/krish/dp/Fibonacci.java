package com.krish.dp;

public class Fibonacci {
    public static void main(String[] args) {
        int [] dp = {-1,-1,-1,-1,-1,-1,-1};
        System.out.println(fibMemoization(6,dp));
        System.out.println(fibTabulation(6,dp));
        System.out.println(fibTabulationOptimised(6));
    }

    private static int fibTabulation(int num, int[] dp) {
        //Bottom up approach
        //tc--> O(n) and sc--> o(n)
        dp[0]=0;
        dp[1]=1;
            for(int i=2;i<=num;i++){
                dp[i]=dp[i-1]+dp[i-2];
            }
            return dp[num];

    }private static int fibTabulationOptimised(int num) {
        //Bottom up approach
        //tc--> O(n) and sc--> o(1)
        //space optimised
        int prev2=0;
        int prev=1;
            for(int i=2;i<=num;i++){
                int curr=prev+prev2;
                prev2=prev;
                prev=curr;
            }
            return prev;

    }

    private static int fibMemoization(int num,int[] dp) {
        //Top down approach
        //tc--> O(n) and sc--> o(n+n)
        if(num<=1){
            return num;
        }
        //checking of prev storage for particular call
        if(dp[num]!=-1){
            return dp[num];
        }
        //storing the result of call
        return dp[num]=fibMemoization(num-1,dp)+fibMemoization(num-2,dp);

    }
}
