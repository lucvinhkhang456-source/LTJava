import java.util.Scanner;

public class Bai4 {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        int dem_le = 0;
        int dem_chan = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                dem_le++;
            } else {
                dem_chan++;
            }
        }
        System.out.print("Tong cong co:" + dem_le + " so le");
        System.out.print(("\nTong cong co " + dem_chan + " so chan"));
        System.out.print("\nCac so nguyen to la:");
        for (int i = 0; i < n; i++) {
            if (isPrime(a[i])) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.print("\nCac so khong phai la so nguyen to la:");
        for (int i = 0; i < n; i++) {
            if (!isPrime(a[i])) {
                System.out.print(a[i] + " ");
            }
        }
        sc.close();
    }
}
