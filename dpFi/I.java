package com.example.myPackage;


import java.util.Scanner;

public class I {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int x = s.nextInt();
        int cost[] = new int [n+1];
        int pages[] = new int[n+1];
        for(int i=1;i<=n;i++)
        {
            cost[i] = s.nextInt();


        }
        for(int i=1;i<=n;i++)
        {
            pages[i] = s.nextInt();
        }
        // Here we have to maximise the pages
        int dp[][] = new int[n+1][x+1];
        for(int i=1;i<=n;i++)
        {
            for(int w =1;w<=x;w++)
            {
                if(cost[i]<=w)
                {
                    dp[i] [w]= Math.max(/*either we leave the ith page or take it */dp[i-1][w],dp[i-1][w-cost[i]]+ pages[i]);
                }
                else
                {
                    /*
                    if the weight is more than the required the we have to leave the current pages
                     */
                    dp[i][w] = dp[i-1][w];
                }
            }

        }
        System.out.println(dp[n][x]);



    }
}
