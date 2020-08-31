package com.example.myPackage;

import java.util.Scanner;

public class F {
    private static Scanner s = new Scanner(System.in);
    final static int Mod = 1000000007;

    public static void main(String[] args) {
        int n = s.nextInt();
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++)
        {
            String st = s.next();
            for(int j =0;j<n;j++)
            {
                arr[i] [j] = st.charAt(j);
            }
        }
        int  dp[][] = new int[n+1][n+1];
       int res = solve(arr,n/*,0,0,*/,dp);
        System.out.println(res);
    }
    static int  solve(char arr[][],int n/*,int i,int j,*/,int [][]dp)
    {




//        if(i>=n) return 0;
//        if(j>=n) return 0;
//        if(arr[i][j] == '*')
//        {
//            return 0;
//        }
//        if(i==n-1 && j== n-1)
//        {
//            return 1;
//        }
//        if(dp[i][j] !=0) return dp[i][j];
//
//        int a =0;
//
//        a  =(a+ solve(arr,n,i+1,j,dp))%Mod;
//        a  =(a+solve(arr,n,i,j+1,dp))%Mod;
//
//         dp[i][j] =a ;
//         return a;

/*
instead of Finding the path from the start We are starting to search the
path from the end and trying to reach the starting points
 */

        for(int l=n;l>=1;l--) {
            for (int m = n; m >= 1; m--) {
                if (l == n && m == n) dp[l][m] = 1;
               else if (arr[l-1][m-1] == '*')//if we get * we can't go there
                    dp[l][m] = 0;

               else if (arr[l-1][m-1] != '*') {
                    int a=0,b=0;
                    if(m<n) a= dp[l][m+1];


                    if(l<n) b= dp[l+1][m];
//                    int a = (m==n) ? 0:dp[l][m+1];
//                    int b =(l==n) ? 0:dp[l+1][m];
//                    System.out.println(a);
//                    System.out.println(b);
                    dp[l][m] = (a+b)%Mod;


                }

            }
        }
        int flag=0;
        if(arr[n-1][n-1] =='*')
        {

            return 0;
        }

        else {

            return dp[1][1];

        }





    }
}