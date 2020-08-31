package com.example.myPackage;

import java.util.Scanner;

public class J {
    private static Scanner s = new Scanner(System.in);
    final static int mod = 1000000007;
    private static void printArray(int [][] arr)
    {
        System.out.println("Printing the DP");
        for(int[] i : arr) {
            for (int j : i)
                System.out.print(j);
            System.out.println();
        }



    }

    public static void main(String[] args) {

        int n = s.nextInt();
        int m = s.nextInt();
        int arr[] = new int[n+1];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
        solve(n,m,arr);

    }
    static void solve(int n,int m,int arr[])
    {
        int [][] dp = new int [n][m+1];

        /*
        Here x is elements of array
        and m is upper limit of the array
         */
        if(arr[0] ==0)
            for(int i=1;i<=m;i++)
                dp[0][i] =1;


        else
        dp[0] [arr[0]] =1;


        for (int i = 1; i < n; i++) {
            int x;
           x = arr[i];
            if (x == 0) {
                for (int j = 1; j <= m; j++) {
                    int[] check =new int [] {j-1,j,j+1};
                    for (int k : check) {
                        if (k >= 1 && k <= m) {
                            dp[i][j] = (dp[i][j]+dp[i-1][k] % mod);
                        }
                    }
                }
            } else {
                int[] check =new int [] {x-1,x,x+1};
                for (int k : check) {
                    if (k >= 1 && k <= m) {
                        dp[i][x] = (dp[i][x]+dp[i-1][k])% mod;
                    }
                }
            }
        }
//        printArray(dp);
        int  ans = 0;
        for (int j = 1; j <= m; j++) {
            ans = (ans+dp[n-1][j])%mod;
        }
        System.out.println(ans);


   }
}
