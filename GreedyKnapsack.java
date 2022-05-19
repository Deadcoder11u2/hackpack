import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyKnapsack {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();
        int capacity = fs.nextInt();
        double profit[] = new double[n], weight[] = new double[n];
        for(int i = 0 ; i < n ; i++) {
            profit[i] = fs.nextDouble();
        }
        for(int i = 0 ; i < n ; i++) {
            weight[i] = fs.nextDouble();
        }

        System.out.println(greedy_Knapsack(profit, weight, capacity));
        fs.close();
    }

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int greedy_Knapsack(double profit[], double weight[], int capacity) {
        int n = profit.length;
        int answer = 0;
        PriorityQueue<Pair> minpq = new PriorityQueue<Pair>();
        for (int i = 0; i < n; i++)
            minpq.add(new Pair((int) profit[i] / (int) weight[i], i));
        while (capacity > 0 && minpq.isEmpty() == false) {
            Pair itr = minpq.peek();
            minpq.poll();
            if (weight[itr.second] <= capacity) {
                capacity -= weight[itr.second];
                answer += profit[itr.second];
            } else {
                answer += profit[itr.second] * (capacity / weight[itr.second]);
                capacity = 0;
            }
        }
        return answer;
    }
}
