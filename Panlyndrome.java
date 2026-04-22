import java.util.Scanner;

public class Panlyndrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi can kiem tra");
        String original = scanner.nextLine(); // Nhập chuỗi từ bàn phím

        String str = original.toLowerCase();

        boolean isPanlydrome = true;
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                isPanlydrome = false;
                break;
            }
        }
        if (isPanlydrome) {
            System.out.println("Chuoi " + original + " la chuoi doi xung");
        } else {
            System.out.println("Chuoi " + original + " khong la chuoi doi xung");
        }
        scanner.close();
    }
}