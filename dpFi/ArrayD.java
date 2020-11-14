package com.example.myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayD {
    private static FastScanner fs = new FastScanner();
    private  static  int Mod = 1000000007;
    public static void main(String[] args) {

        int m = fs.nextInt();
        int n = fs.nextInt();
        int a[] = fs.readArray(m);
        int ways =0;
        int dp[][] = new int[m][n+1];
        if(a[0]==0)
            for(int j=1;j<=n;j++)
                dp[0][j] = 1;
         else dp[0][a[0]] =1;
        for(int i=1;i<m;i++)
        {
            int x = a[i];
            if(a[i]==0)
            {
                for(int j =1;j<=n;j++)
                {
                    int check[] = new int []{j-1,j+1,j};
                    for(int k: check)
                    {
                        if(k>=1 && k<= n)
                        {
                            dp[i][j] = (dp[i][j] + dp[i-1][k])%Mod;
                        }
                    }


                }

            }
            else
            {
                int[] check =new int [] {x-1,x,x+1};
                for (int k : check) {
                    if (k >= 1 && k <= n) {
                        dp[i][x] = (dp[i][x] +dp[i-1][k])%Mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int j = 1; j <= n; j++) {
            ans = (ans +dp[m-1][j])% Mod;
        }
        System.out.println(ans);


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

//        private int upper(int arr[],int key){
//            int low = 0;
//            int high = arr.length-1;
//            while(low < high){
//                int mid = low + (high - low+1)/2;
//                if(arr[mid] <= key){
//                    low = mid;
//                }
//                else{
//                    high = mid-1;
//                }
//            }
//            return low;
//        }
//        public int lower(int arr[],int key){
//            int low = 0;
//            int high = arr.length-1;
//            while(low < high){
//                int mid = low + (high - low)/2;
//                if(arr[mid] >= key){
//                    high = mid;
//                }
//                else{
//                    low = mid+1;
//                }
//            }
//            return low;
//        }
    }
}