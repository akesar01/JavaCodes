package com.example.myPackage;
/*
This is CSES Set 5 Question Removing Elements
 */



import java.util.Scanner;

public class E {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
//        while(true) {
            int n = s.nextInt();
            int dp[] = new int[n + 1];
            int res = solve(n, dp);
            System.out.println(res);

//        }
    }

 static int solve(int n,int[]dp)
    {
//        if(n==0) return 0;
//        if(n<0) return 0;
//
//
//        if(dp[n] !=0) return dp[n];
//
//        int b = Integer.MAX_VALUE;
//        int temp =n;
//        while(temp>0)
//        {
//            int rem  = temp %10;
//            if(rem !=0) {
//                b= Math.min(solve(n - rem, dp)+1 , b);
//
//            }
//            temp = temp/10;
//
//        }
//        dp[n] =b;
//        return b;


        for(int i =1;i<=n;i++)
        {
            int temp =i;
            int b = Integer.MAX_VALUE;
            while(temp>0)
            {
                int rem = temp%10;
                if(rem !=0)
                    b =Math.min(dp[i-rem]+1,b);
                temp /=10;

            }
            dp[i] = b;

        }
        return  dp[n];

    }


}
