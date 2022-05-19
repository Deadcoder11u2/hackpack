import static java.lang.Math.max;

import java.util.Scanner;

public class LCSS {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        char a[] = fs.next().toCharArray();
        char b[] = fs.next().toCharArray();
        int ans = LCS(a, b);
        System.out.println("Answer: " + ans);
    }

    public static int LCS(char a[], char b[]) {
        int n = a.length, m = b.length;
        int dp[][] = new int[n + 1][m];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= m; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (a[i - 1] == b[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}
