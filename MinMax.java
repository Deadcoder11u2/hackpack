import java.util.Scanner;
import static java.lang.Math.*;

public class MinMax {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();
        int a[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = fs.nextInt();
        }
        Node ans = minMax(a, 0, n-1);
        System.out.println(ans);
    }

    static Node minMax(int a[], int l, int r) {
        if(l == r) return new Node(a[l], a[r]);
        int mid = (l+r)/2;
        Node left = minMax(a, l, mid);
        Node right = minMax(a, mid+1, r);
        return new Node(min(left.mn, right.mn), max(right.mx, left.mx));
    }

    static class Node {
        int mn, mx;
        Node(int mn, int mx){
            this.mn = mn;
            this.mx = mx;
        }
        public String toString() { return "{" + mn + "," + mx + "}"; }
    }
}
