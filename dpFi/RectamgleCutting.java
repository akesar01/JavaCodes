package com.example.myPackage;
/*
This is good Question
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RectamgleCutting {
    private static FastScanner fs = new FastScanner();
    public static void main(String[] args) {
    /*
    Here a and b are the sides
     */
        int a = fs.nextInt(); // a  is vertical Side
        int b = fs.nextInt(); // b is horizontal Side
        /*
        Consider a w×h piece. If it is already square (w = h),
         we need 0 cuts. Otherwise, we need to make the first cut
         either horizontally or vertically. Say we make it horizontally
          then we can cut at any position 1,2,..,h-1. If we cut at position k,
          then we are left with two pieces of sizes w×k and w×h−k.
          We can look up the number of moves to reduce these to squares in
           the dp array. We loop over all
        possibilities k and take the best one. Similarly for vertical cuts.
        The complexity is O(a2⋅b+a⋅b2).
         */
        int dp[][] = new int [a+1][b+1];
        for(int i=0;i<=a;i++ )
        {
            for(int j =0;j<=b;j++)
            {
                if(i==j) dp[i][j] =0;
                else
                {
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=1;k<i;k++)
                    {
                        dp[i][j] = Math.min(dp[i][j],(dp[k][j]+dp[i-k][j]+1)); // This is cutting the horizontal Side
                    }
                    for(int k=1;k<j;k++)
                    {
                        dp[i][j] =  Math.min(dp[i][j],dp[i][k]+dp[i][j-k]+1);
                    }
                }
            }
        }
        System.out.println(dp[a][b]);

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
        public String nextLine() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    return br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken("\n");
        }
    }
}