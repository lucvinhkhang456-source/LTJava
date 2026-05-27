package All;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager manager = new LibraryManager();
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm NXB | 2. Thêm Sách | 3. Tìm Sách | 4. Xem NXB | 5. Thống kê | 0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.themDuLieu(1);
                    break;
                case 2:
                    manager.themDuLieu(2);
                    break;
                case 3:
                    System.out.print("Từ khóa: ");
                    manager.timKiemSach(sc.nextLine());
                    break;
                case 4:
                    manager.xemDanhSachNXB();
                    break;
                case 5:
                    manager.thongKeNXB();
                    break;
            }
        } while (choice != 0);
        sc.close();
    }
}