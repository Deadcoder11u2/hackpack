import static java.lang.Math.*;
import java.util.*;
import java.io.*;
public class RabinKarp {
    static Scanner fs;
    static PrintWriter out;
    static char a[], b[];
    static void init() {
        fs = new Scanner(System.in);
        out = new PrintWriter(System.out);
    }
    static int hash() {
        int ans = 0;
        return 0;
    }
    static int mod = 1_000_000_007;
    static int h(char x, int i, int len) {
        return ((int)pow(len, i)*(a[i]-'a'+1));
    }
    public static void main(String args[]) {
        init();
        a = fs.next().toCharArray();
        int n = a.length;
        b = fs.next().toCharArray();
        int m = b.length;
        long h_b = 0;
        long h_a = 0;
        for(int i = 0; i < m ; i++) {
            h_b += ((int)pow(m, i)*(b[i]-'a'+1));
            h_b %= mod;
            h_a += ((int)pow(m, i)*(a[i]-'a'+1));
            h_a %= mod;
        }
        for(int i = 0 ; i < n - m; i++) {
            if(h_b == h_a) {
                boolean eq = true;
                for(int j = 0 ; j < m ; j++) {
                    eq &= a[i+j] == b[j];
                }
                if(eq) {
                    out.println("String matched: " + i);
                }
            }
            else {
                h_a -= a[i]-'a'+1;
                h_a /= m;
                h_a += ((int)pow(m, m-1)*(a[i+m]-'a'+1));
                h_a %= mod;
            }
        }
        out.println(h_b);
        out.println(Arrays.toString(a)+ " " + Arrays.toString(b));
        out.close();
    }
}
