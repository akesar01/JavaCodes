package com.example.myPackage;

import java.util.Scanner;

public class C {
    final static int Mod = 1000000007;
    private static Scanner s = new Scanner (System.in);

    public static void main(String[] args) {

        int n = s.nextInt();
        int x = s.nextInt();
        int coins[] = new int [n];
        for(int i=0;i<n;i++) coins[i] = s.nextInt();

        long dp [] = new long [x+1];
     long res =   solve(n,x,coins,dp);
        System.out.println(res);
//        printArray(dp);


    }

    static void printArray(long arr[])
    {
        System.out.println("Printing the requested array");
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+"->");
        System.out.println();
    }

    static long solve(int n,int x,int [] coins,long dp[])
    {
//        if(x==0) return 1; This creates the Time Limit Exceeded Error
//        if(x<0) return 0;
//        if(dp[x] != 0) return  dp[x];
//        int ways =0;
//        for(int i=0;i<n;i++)
//        {
//            ways +=(solve(n,x-coins[i],coins,dp));
//        }
//        dp[x] = ways;
//        return  dp[x];
        dp[0] =1;
        for(int i=1;i<= x;i++) {
            long  ways =0;
            for (int j = 0; j < n; j++) {
                if (i - coins[j]>=0)
                {
                    ways =(ways + (dp[i-coins[j]]))%Mod;

                }
            }
            dp[i] = ways;

        }
        return dp[x];


    }
}
