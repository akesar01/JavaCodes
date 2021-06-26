
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class Temp {
    private static FastScanner fs = new FastScanner();
    private PrintWriter out=new PrintWriter(System.out);
    // use out.println() 
    public static void main(String[] args) {

        int t = fs.nextInt();
        while(t-->0)
        {


        }
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
        public static int lower_bound(int[] arr, int begin, int end, int tar) {
        while(begin < end) {
            int mid = begin + (end - begin) / 2;
            // When the element is less than the mid tar
            if(arr[mid] < tar)
                         // begin to mid + 1, arr [begin] value is less than or equal tar
                begin = mid + 1; 
                         // When the mid tar element when greater than or equal
            else if(arr[mid] >= tar)
                end = mid;
        }
        return begin;
    }
       public static int upper_bound(int[] arr, int begin, int end, int tar) {
        while(begin < end) {
            int mid = begin + (end - begin) / 2;
            if(arr[mid] <= tar) 
                begin = mid + 1;
            else if(arr[mid] < tar)
                end = mid;
        }
        return begin;
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
