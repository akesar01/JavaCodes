package com.example.myPackage;

import java.util.Scanner;

public class TwoSet {
    private static Scanner fs = new Scanner(System.in);
    private static int Mod = (int) 1e9 +7;

    public static void main(String[] args) {
        int n = fs.nextInt();

        long sum = n*(n+1)/2;
        if((sum &1)==1) {
            System.out.println(0);
            return;
        }


        long [] dp = new long[(int)sum+1];
        sum /=2;
        dp[0] =1;
        for (int i=1;i<=n;i++)
        {
            for(int j=i*(i+1)/2;j>=0;j--)
            {
                if(j>=i)
                dp[j] = (dp[j-i]%Mod + dp[j]%Mod)%Mod;

            }
        }
        System.out.println(dp[(int)sum]*((Mod+1)/2)%Mod);

    }
}
