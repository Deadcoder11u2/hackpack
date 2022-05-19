import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Krushkal {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();
        ArrayList<Edge> G = new ArrayList<Edge>();
        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int c = fs.nextInt();
            G.add(new Edge(u, v, c));
        }
        Collections.sort(G, (p1, p2) -> Integer.compare(p1.c, p2.c));
        Collections.reverse(G);
        System.out.println(G);
        ArrayList<Edge> ans = new ArrayList<Edge>();
        DSU dsu = new DSU(n);
        while (ans.size() < n - 1) {
            Edge e = G.remove(G.size() - 1);
            if (!dsu.isConnected(e.u, e.v)) {
                ans.add(e);
                dsu.merge(e.u, e.v);
            }
        }
        System.out.println(ans);
    }

    static class Edge {
        int u, v, c;

        Edge(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }

        public String toString() {
            return "{" + u + "," + v + "," + c + "}";
        }
    }

    static class DSU {
        int dsu[], rank[];

        DSU(int N) {
            dsu = new int[N + 1];
            rank = new int[N + 1];
            for (int i = 0; i < N + 1; i++) {
                dsu[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (dsu[i] == i)
                return i;
            return find(dsu[i]);
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }

        public void merge(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int t = a;
                    a = b;
                    b = t;
                }
                dsu[b] = a;
                if (rank[a] == rank[b]) {
                    rank[a]++;
                }
            }
        }
    }
}
