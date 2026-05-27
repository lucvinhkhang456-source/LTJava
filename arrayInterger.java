import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class arrayInterger {
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

    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu:");
        int n = sc.nextInt();
        int[] a = new int[n];
        // Nhập mảng
        for (int i = 0; i < n; i++) {
            Random rd = new Random(); // Khởi tạo mỗi lần chạy chương trình để tạo ra số ngẫu nhiên mỗi lần chạy
            a[i] = rd.nextInt(100);
        }
        // Xuất mảng
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        // Tổng mảng
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        System.out.print("\nTong phan tu trong mang la:" + sum);
        // Đếm phần tử K xuất hiện trọng mảng
        System.out.print("\nNhap phan tu can dem trong mang:");
        int K = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (K == a[i]) {
                count++;
            }
        }
        System.out.print("Phan tu " + K + " xuat hien " + count + " lan");
        // Tìm phần tử lớn nhất
        int lon_nhat = a[0];
        for (int i = 0; i < n; i++) {
            if (lon_nhat < a[i]) {
                lon_nhat = a[i];
            }
        }
        System.out.println("\nPhan tu lon nhat trong mang la:" + lon_nhat);
        // Tìm phần tử nhỏ nhất
        int nho_nhat = a[0];
        for (int i = 0; i < n; i++) {
            if (nho_nhat > a[i]) {
                nho_nhat = a[i];
            }
        }
        System.out.println("Phan tu nho nhat trong mang la:" + nho_nhat);
        // Tìm số nguyên tố
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (isPrime(a[i])) {
                System.out.print(a[i] + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay so nguyen to nao !");
        }
        System.out.println();
        // Sắp xếp tăng dần
        Arrays.sort(a);
        System.out.print("Sau khi sap xep tang dan:" + Arrays.toString(a));
        // Sắp xếp giảm dần
        Integer[] numbersObj = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.sort(numbersObj, Collections.reverseOrder());
        System.out.print("\nSau khi sap xep giam dan:" + Arrays.toString(numbersObj));
        sc.close();
    }
}