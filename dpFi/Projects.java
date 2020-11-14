package com.example.myPackage;

import java.io.*;
import java.util.*;

public class Projects {
    private static FastScanner fs = new FastScanner(System.in);

    public static void main(String[] args) {
        int n = fs.nextInt();
        Node arr[] = new Node[n];
        PrintWriter out = new PrintWriter(System.out);
        for(int i=0;i<n;i++)
        {

            int start = fs.nextInt();
            int end = fs.nextInt();
            int money = fs.nextInt();
            Node node = new Node(start,end,money);
            arr[i] = node;
        }
        List<Node> list = new ArrayList <>();
        for (Node n1 :arr) list.add(n1);

        Collections.sort(list, (o1, o2) -> {
            if(o1.end>o2.end) return 1;
            else if (o1.end <o2.end) return -1;
            else
            {
                return 0;
            }
        });
        for(int i=0;i<n;i++) arr[i] = list.get(i);
        long earn [] = new long[n];
        for(int i=0;i<n;i++) {
            earn[i] = arr[i].money;
            if(lower_bound(arr[i].start,arr )>=0)
            {
                earn[i] +=earn[lower_bound(arr[i].start,arr)];
                if(i>0)
                earn[i] = Math.max(earn[i],earn[i-1]);
            }
            else
            {
                if(i>0) earn[i] = Math.max(earn[i],earn[i-1]);
            }
        }
        out.println(earn[n-1]);
        out.close();
    }
    private static int lower_bound(long key,Node []arr)
    {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid =low+(high-low)/2;
            if(arr[mid].end>= key)
            {
                high = mid-1;
            }
            else if (arr[mid].end <key)
            {
                ans = mid;
                low = mid+1;
            }


        }
        return ans;
    }
    static class Node
    {
        int start;
        int end;
        int money;
        int perDay;

        public Node(int start, int end, int money) {
            this.start = start;
            this.end = end;
            this.money = money;
            this.perDay =  (end == start)?money:money/(end-start);
        }
    }
}
class FastScanner {
    private BufferedReader reader = null;
    private StringTokenizer tokenizer = null;

    public FastScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = null;
    }

    public String next() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken("\n");
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String[] nextArray(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = next();
        return a;
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }
}
