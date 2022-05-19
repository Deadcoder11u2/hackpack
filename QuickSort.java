import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        quicksort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
        fs.close();
    }

    public static void quicksort(int a[], int l, int r) {
        if (l < r) {
            int p = pivot(a, l, r);
            quicksort(a, l, p - 1);
            quicksort(a, p + 1, r);
        }
    }

    public static int pivot(int a[], int l, int r) {
        int x = a[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] < x) {
                i++;
                swap(a, i, j);
            }
        }
        System.out.println(Arrays.toString(a));
        swap(a, i + 1, r);
        return i + 1;
    }

    public static void swap(int a[], int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
