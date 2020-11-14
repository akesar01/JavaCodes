package com.example.myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EditDistance {
    private static FastScanner fs = new FastScanner();
    public static void main(String[] args) {

        String a = fs.next();
        String b = fs.next();
        int res = solve1(a,b,a.length(),b.length());
        System.out.println(res);
/*
We have to do operation on the a
 */


    }
    private static int solve(String a,String b,int a1,int b1)
    {
        if(a1==0) return b1;
        if(b1==0) return a1;
        if(a.charAt(a1-1)== b.charAt(b1-1)) return solve(a,b,a1-1,b1-1);

        else
        {
            //insert
           int first = solve(a,b,a1,b1-1);
           // replace
            int second = solve(a,b,a1-1,b1-1);
            // remove
            int third = solve(a,b,a1-1,b1);

            return Math.min(first,Math.min(second,third)) +1;
        }



    }
    private static int solve1(String a,String b,int n,int m)
    {
        int dp[][] = new int [n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0)
                {       if(j>0)
                       dp[0][j] = j;
                }
                else if(j==0)
                {   if(i>0)
                    dp[i][0] = i;
                }
                else if(a.charAt(i-1)==b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                {
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }


            }
        }
        return dp[n][m];


    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
        int  gcd(int a,int b)
        {
            while (b > 0)
            {
                int  temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
        private int upper(int arr[],int key){
            int low = 0;
            int high = arr.length-1;
            while(low < high){
                int mid = low + (high - low+1)/2;
                if(arr[mid] <= key){
                    low = mid;
                }
                else{
                    high = mid-1;
                }
            }
            return low;
        }
        public int lower(int arr[],int key){
            int low = 0;
            int high = arr.length-1;
            while(low < high){
                int mid = low + (high - low)/2;
                if(arr[mid] >= key){
                    high = mid;
                }
                else{
                    low = mid+1;
                }
            }
            return low;
        }
    }
}