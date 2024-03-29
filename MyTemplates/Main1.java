// Working program using Reader Class
// Probably fastest
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
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
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
 
public class Main1 {
    private static PrintWriter out = new PrintWriter(System.out);
    // private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {     
       
    }
   


    interface Input {
        public String next();
        public String nextLine();
        public int nextInt();
        public long nextLong();
        public double nextDouble();
    }
    static class StdIn implements Input {
        final private int BUFFER_SIZE = 1 << 16;
        final private int STRING_SIZE = 1 << 11;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public StdIn() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        
        public StdIn(String filename) {
            try{
                din = new DataInputStream(new FileInputStream(filename));
            } catch(Exception e) {
                throw new RuntimeException();
            }
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        
        public String next() {
            byte[] buf = new byte[STRING_SIZE]; // string length
            int cnt = 0, c;
            while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
            while (c != -1)
            {
                if (c == ' ' || c == '\n'||c=='\r')
                    break;
                buf[cnt++] = (byte) c;
                c=read();
            }
            return new String(buf, 0, cnt);
        }
 
        public String nextLine() {
            byte[] buf = new byte[STRING_SIZE]; // line length
            int cnt = 0, c;
            while((c=read())!=-1&&(c==' '||c=='\n'||c=='\r'));
            while (c != -1)
            {
                if (c == '\n'||c=='\r')
                    break;
                buf[cnt++] = (byte) c;
                c = read();
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
        
        public int[] readIntArray(int n) {
            int[] ar = new int[n];
            for(int i=0; i<n; ++i)
                ar[i]=nextInt();
            return ar;
        }
 
        public long nextLong() {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() {
            try{
                if (bufferPointer == bytesRead)
                    fillBuffer();
                return buffer[bufferPointer++];
            } catch(IOException e) {
                throw new RuntimeException();
            }
        }
 
        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
    private static StdIn fs = new StdIn();
 
   
}