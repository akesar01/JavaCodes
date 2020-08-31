package com.example.myPackage;

import java.util.Scanner;

public class D {
    private static Scanner s = new Scanner(System.in);
    private final static int Mod = 1000000007;
    public static void main(String[] args) {
        int n = s.nextInt();
        int x = s.nextInt();
        int coins[] = new int [n+1];
        for(int i=1;i<=n;i++) coins[i] = s.nextInt();
        int  dp [][]= new int[n+1][x+1];
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        for(int i=1;i<=x;i++)
            dp[0][i] =0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=x;j++)
            {
                if(j>= coins[i])
                dp[i][j] = (dp[i][j-coins[i]] + dp[i-1][j])%Mod;
                else
                    dp[i][j] = dp[i-1][j];

            }
        }
        System.out.println(dp[n][x]);

    }
}
