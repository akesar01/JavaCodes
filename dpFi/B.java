package com.example.myPackage;
import java.util.Scanner;
public class B {
    private static Scanner s = new Scanner (System.in);
   static   int min = Integer.MAX_VALUE;

    static int solve(int x, int arr[], int n)
    {
        int dp [] = new int [x+1];

        for(int i =1; i<= x; i++)
        {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=x;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[j]<=i)
                {
                    int sub_res = dp[i-arr[j]];

                    if (sub_res != Integer.MAX_VALUE && sub_res +1 <dp[i])
                    {
                        dp[i] = sub_res +1;
                    }
                }
            }

        }
        if(dp[x] != Integer.MAX_VALUE)
        return dp[x];
        else
            return -1;



//        int res =Integer.MAX_VALUE;
//        for(int i=0;i<arr.length;i++)
//        {
//          int sub_res = solve(x-arr[i],arr,dp);
//        }
//
////        dp[x] = min;
////        return dp[x];
//
//            return res;
    }
    public static void main(String[] args) {
        int n = s.nextInt();
        int x = s.nextInt();
        int arr[] = new int [n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();

        int res = solve(x,arr,n);
        System.out.println(res);

    }
}
