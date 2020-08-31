/*
dynamic programming
Dice change
 */

package com.example.myPackage;
import java.util.Scanner;
public class Main {
    private static Scanner s = new Scanner(System.in);
    final static int Mod = 1000000007;
    public static void main(String[] args) {
            int n = s.nextInt();
            long dp[] = new long [n+1];
            long res = solve(n,dp);
            System.out.println(res);
    }

   static long solve(int n,long dp[])
    {

//        if(n==1 || n==0) This is alternate approach but give rUn time error on the higher input
//            return 1;
//        if(n<0)
//            return 0;
//        if(dp[n] != -1l)
//            return  dp[n];
//        long best = 0l;
//        for(int i=1;i<=6;i++)
//        {
//            best = (best %Mod+ solve(n-i,dp))%Mod;
//        }
//        dp[n] = best;
//
//        return best;
        if(n>=0)
        dp[n] =1;
        if(n>=1)
        dp[1] =1;
        if(n>=2)
        dp[2] =2;
        if(n>=3)
        dp[3] =4;
        if(n>=4)
        dp[4] = 8;
        if(n>=5)
        dp[5] = 16;
        if(n>=6)
        dp[6] = 32;
        for(int i=7;i<=n;i++)
        {
            long a = dp[i-1];
            long b = dp[i-2];
            long c = dp[i-3];
            long d = dp[i-4];
            long e = dp[i-5];
            long f = dp[i-6];
            dp[i] = (a+b+c+d+e+f)%Mod;
        }

        return dp[n];


    }
}
