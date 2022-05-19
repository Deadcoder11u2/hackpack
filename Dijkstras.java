import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class D {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        fs.close();
    }

    static class Pair implements Comparable<Pair>{
        int first, second ;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(D.Pair o) {
            if(first != o.first) return Integer.compare(first, o.first);
            return Integer.compare(second, o.second);
        }
    }

    void dijkstra(Pair[][] adj){
        int n = adj.length;

        int distance[] = new int[n];
        int parent[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        int source = 0;
        distance[source] = 0;

        TreeSet<Pair> minpq = new TreeSet<>();
        minpq.add(new Pair(0, source));

        while (minpq.isEmpty() == false){
            int u = minpq.first().second;
            minpq.remove(minpq.first());

            for (Pair x : adj[u]){
                int v = x.first;
                int w = x.second;

                if (distance[v] > distance[u] + w){
                    minpq.remove(new Pair(distance[v], v));
                    distance[v] = distance[u] + w;
                    parent[v] = w;
                    minpq.add(new Pair(distance[v], v));
                }
            }
        }
    }
}
