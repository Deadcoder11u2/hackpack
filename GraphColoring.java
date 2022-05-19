import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class GraphColoring {
    static Reader fs;
    static PrintWriter pw;
    static int color[] = new int[1000+1];
    static Vector<Integer> adj[] = new Vector[1000+1];
    static int n = 0, edge = 0;
    static int m = 0;
    static void solve() throws IOException{
        n = fs.nextInt();
        edge = fs.nextInt();
        m = fs.nextInt();
        System.out.println(n + " " + edge + " " + m);
        for(int i = 1 ; i <= n ; i++) {
            adj[i] = new Vector<Integer>();
        }
        while(edge-- > 0) {
            int u = fs.nextInt(), v = fs.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        mcoloring(1);
    }
    static boolean NextValue(int k) {
        while(true) {
            color[k] = (color[k]+1)%(m+1);
            System.err.println(color[k]);
            if(color[k] == 0) return false;
            boolean pos = true;
            for(int x : adj[k]) {
                pos &= color[k] != color[x];
            }
            if(pos) break;
        }
        return true;
    }
    static void mcoloring(int k) {
        while(true) {
            if(!NextValue(k)) return;
            if(k == n) {
                for(int i = 1 ; i <= n ; i++) {
                    System.out.print(color[i] + " ");
                }
                System.out.println();
                return;
            }
            else {
                mcoloring(k+1);
            }
        }
    }
    public static void main(String args[]) throws Exception{
        System.setErr(new PrintStream("error.txt"));
        fs = new Reader();
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;
        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }
        void fill() throws IOException{
            st = new StringTokenizer(br.readLine());
        }
        void check() throws IOException{
            if(!st.hasMoreTokens()) fill();
        }
        int nextInt() throws IOException{
            check();
            return Integer.parseInt(st.nextToken());
        }
        double nextDouble() throws IOException{
            check();
            return Double.parseDouble(st.nextToken());
        }
        long nextLong() throws IOException {
            check();
            return Long.parseLong(st.nextToken());
        }
        int [] readArray(int n) throws IOException{
            int a[] = new int[n];
            for(int i = 0 ; i < n ;i++) a[i] = nextInt();
            return a;
        }
        String next() throws IOException {
            check();
            return st.nextToken();
        }
    }
}
