import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void main(String args[]) {
        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        int x = mergeSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(x);
        fs.close();
    }

    public static int mergeSort(int a[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            int left = mergeSort(a, l, mid);
            int right = mergeSort(a, mid + 1, r);
            System.out.println(left + " " + right + " " + "{" + l + "," + r + "}");
            return left + right + merge(a, l, r);
        }
        return 0;
    }

    public static int merge(int a[], int l, int r) {
        int mid = (l + r) / 2;
        int temp[] = new int[r - l + 1];
        int k = 0;
        int i = l, j = mid + 1;
        int invCount = 0;
        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                if (a[i] != a[j]) {
                    invCount += i - l;
                }
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            invCount += r - mid;
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }
        for (int p = 0; p < r - l + 1; p++) {
            a[p + l] = temp[p];
        }
        System.out.println(invCount);
        return invCount;
    }
}
