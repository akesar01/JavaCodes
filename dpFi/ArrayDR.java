package com.example.myPackage;

import java.util.Scanner;

public class ArrayDR {
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int n = s.nextInt();
        int m = s.nextInt();
        int arr[] = new int [n];
        for(int i=0;i<n;i++) arr[i] = s.nextInt();
      int res = solve(arr,n,m);
        System.out.println(res);

    }
    private static int  solve(int arr[],int n,int m)
   {
      return 0;
   }

}
