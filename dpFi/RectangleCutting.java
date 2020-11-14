package com.example.myPackage;
import java.util.Scanner;

public class RectangleCutting {
    private static Scanner fs = new Scanner(System.in);

    public static void main(String[] args) {
        int a = fs.nextInt();
        int b = fs.nextInt();
        int dp[][] = new int [a+1][b+1];
        for(int i=0;i<=a;i++)
        {
            for(int j=0;j<=b;j++)
            {
                if(i==j) dp[i][j] =0;
                else
                {
                    dp[i][j] = Integer.MAX_VALUE-1000;
                    for(int k=1;k<i;k++)
                    {
                        dp[i][j] = Math.min(dp[i][j],dp[k][j]+dp[i-k][j]+1);
                    }
                    for(int k=1;k<j;k++)
                    {
                        dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[i][j-k]+1);
                    }
                }
            }
        }
        System.out.println(dp[a][b]);
    }
}
