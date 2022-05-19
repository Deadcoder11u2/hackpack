import java.io.*;
import java.util.*;
import static java.lang.Math.*;
public class KnapsackMine {
    static Reader fs;
    static PrintWriter pw;
    static void solve() throws IOException{
        int n = fs.nextInt();
        int w = fs.nextInt();
        int wt[] = fs.readArray(n);
        int val[] = fs.readArray(n);
        int dp[][] = new int[n+1][w+1];
        // for(int i = 0 ; i <= n ; i++) {
        // Arrays.fill(dp[i], -1);
        // }
        for(int i = 0 ; i <= n ; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0 ; i <= w ; i++) {
            dp[0][i] = 0;
        }
        pw.println("Max Value: " + go(dp, wt, val, w));
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= w ; j++) {
                System.err.print(dp[i][j] + " ");
            }
            System.err.println();
        }
    }
    static int go(int dp[][], int weight[], int v[], int w) {
        int n = weight.length;
        int wt[] = new int[weight.length+1];
        int val[] = new int[weight.length+1];
        for(int i = 1 ; i < wt.length ; i++) {
            wt[i] = weight[i-1];
        }
        for(int i = 1 ; i < wt.length ; i++) {
            val[i] = v[i-1];
        }
        System.err.println(Arrays.toString(wt));
        System.err.println(Arrays.toString(val));
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 0 ; j <= w ; j++) {
                if(wt[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = max(dp[i-1][j],val[i] + dp[i-1][j-wt[i]]);
                }
            }
        }
        int i = n, k = w;
        boolean taken[] = new boolean[n+1];
        while(i > 0 && k > 0) {
            if(dp[i][k] != dp[i-1][k]) {
                taken[i] = true;
                i -= 1;
                k -= wt[i];
            }
            else {
                i--;
            }
        }
        System.out.println("Objects Taken:");
        for(i = 0 ; i <= n ; i++) {
            if(taken[i]) System.out.print(i + " ");
        }
        System.out.println();
        return dp[n][w];
    }
    public static void main(String args[]) throws Exception{
        System.setErr(new PrintStream("error.txt"));
        fs = new Reader();
        pw = new PrintWriter(System.out);
        // int t = 1;
        // t = fs.nextInt();
        // while(t-- > 0) {
        solve();
        // }
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

