package com.example.myPackage;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;
public class RemovalGame {
    private static FastScanner fs=new FastScanner();
    public static void main(String[] args) {
        int n = fs.nextInt();
        int [] arr = fs.readArray(n);

        Node [][] dp = new Node[n+1][n+1];
        for(int i=n-1;i>=0;i--)
        {
            for(int j = i;j<n;j++)
            {
                Node n1 = new Node();
                if(i==j)
                {
                    n1.a = arr[i];
                    n1.b =0;
                }
                else
                {
                    if(dp[i+1][j].b+arr[i]>dp[i][j-1].b+arr[j])
                    {
                        n1.a = dp[i+1][j].b+arr[i];
                        n1.b = dp[i+1][j].a;
                    }
                    else
                    {
                        n1.a = dp[i][j-1].b +arr[j];
                        n1.b = dp[i][j-1].a;

                    }


                }
                dp[i][j] = n1;
            }

        }



        System.out.println(dp[0][n-1].a);



    }
    static class Node
    {
        long a;
        long b;
    }
    static final Random random=new Random();

    static void ruffleSort(long[] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n); long temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        int [] sort(int [] arr)
        {
            List<Integer> list = new ArrayList<>();
            for(int i : arr) list.add(i);

            Collections.sort(list);
            int res[] = new int[arr.length];
            for(int i=0;i<arr.length;i++) res[i] = list.get(i);


            return res;
        }
    }


}
