import java.util.Scanner;
import static java.lang.Math.*;

public class Knapsack {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();
        int capacity = fs.nextInt();
        int profit[] = new int[n];
        int weight[] = new int[n];
        int ans = Knapsack(profit, weight, capacity);
        System.out.println("Answer: " + ans);
        fs.close();
    }


    public static int Knapsack(int profit[], int weight[], int capacity){
        int n = profit.length;

        int dp[][] = new int[n+1][capacity];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= capacity; i++)
            dp[0][capacity] = 0;

        for (int i = 1; i <= n ; i++)
            for (int j = 1; j <= capacity; j++)
                if (weight[i - 1] <= j)
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + profit[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];

        for(int i = 0 ; i <= n ; i++) {
            for(int j = 0 ; j <= capacity ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][capacity];
    }
}
