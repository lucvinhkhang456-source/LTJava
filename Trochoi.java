import java.util.Random;
import java.util.Scanner;

public class Trochoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int numberRand = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttemp = 7;
            boolean won = false;

            System.out.println("\n--- TRO CHOI DOAN SO ---");
            System.out.println("May da chon mot so tu 1-100. Thim co 7 lan de doan.");

            // Vong lap doan so
            while (attempts < maxAttemp) {
                attempts++;
                System.out.print("Lan doan thu " + attempts + ": ");

                // Kiem tra dau vao co phai la so khong
                if (!scanner.hasNextInt()) {
                    System.out.println("Nhap so thim oi dung nhap chu!");
                    scanner.next(); 
                    attempts--; 
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess == numberRand) {
                    System.out.println("Qua dinh! Thim da doan dung so " + numberRand + " o lan thu " + attempts);
                    won = true;
                    break; 
                } else if (guess < numberRand) {
                    System.out.println("Thap qua! So cua may lon hon do.");
                } else {
                    System.out.println("Cao qua! So cua may thap hon do.");
                }

                if (attempts < maxAttemp) {
                    System.out.println("Con " + (maxAttemp - attempts) + " luot doan.");
                }
            }

            // Thong bao ket qua sau khi het luot hoac doan dung
            if (!won) {
                System.out.println("Game over nha thim! So dung la: " + numberRand);
            }

            // Hoi choi tiep hay khong
            System.out.print("Thim co muon choi tiep khong? (C/K): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("C")) {
                playAgain = false;
                System.out.println("Tam biet thim! Hen gap lai.");
            }
        }
        scanner.close();
    }
}