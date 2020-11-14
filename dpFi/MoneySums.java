package com.example.myPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MoneySums {

    private static FastScanner fs=new FastScanner();
    // private static Set<Integer> set = new HashSet<>();
    // private static int arr[];
    // private static int n;
    public static void main(String[] args) {

        int n = fs.nextInt();
        int []arr = fs.readArray(n);
        // solve(arr,0,n,0);
        solve(arr,n);


    }
    // This gives TLE as it is a plain recursion
    // private static void solve (int [] arr,int curr,int size,int sum)
    // {
    // 	if(curr==size)
    // 	{
    // 		// System.out.println(curr);
    // 	set.add(sum);
    // 	 return;
    // 	}
    // 	set.add(sum);
    // 	solve(arr,curr+1,size,sum+arr[curr]);


    // 	solve(arr,curr+1,size,sum);

    // }
    private static void solve (int [] arr,int size)
    {

        Set<Integer> list = new HashSet<>();
        list.add(0);
        Set<Integer> list2 = new HashSet<>();
        for(int i=0;i<size;i++)
        {
            for(int j :list)
            {
                list2.add(j+arr[i]);

            }
            for(int k :list2) list.add(k);
            list2.clear();

        }
        ArrayList<Integer> list1 = new ArrayList<>(list);
        Collections.sort(list1);
        System.out.println(list1.size() -1);
        for(int i : list1)
        {
            if( i !=0) System.out.print(i+" ");
        }
        System.out.println();


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
