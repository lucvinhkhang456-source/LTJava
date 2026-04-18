import java.util.Scanner;

public class PTB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a:");
        double a = scanner.nextDouble();
        System.out.print("Nhập b:");
        double b = scanner.nextDouble();
        System.out.print("Nhập c:");
        double c = scanner.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println(c == 0 ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm");
            } else {
                System.out.println("Phương trình bậc 1  có nghiệm là x= " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm ");
            } else if (delta == 0) {
                System.out.println("Phương trình có nghiệm kép: x= " + (-b / (2 * a)));
            } else if (delta > 0) {
                System.out.println("Phương trình có 2 nghiệm phân biệt:");
                System.out.println("x1= " + ((-b + Math.sqrt(delta)) / (2 * a)));
                System.out.println("x2= " + ((-b - Math.sqrt(delta)) / (2 * a)));
            }
        }
        scanner.close();
    }
}