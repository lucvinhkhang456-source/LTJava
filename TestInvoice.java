import java.util.ArrayList;
import java.util.Scanner;

public class TestInvoice {
    private static ArrayList<Invoice> invoicesList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initMockData();
        int choice;
        do {
            System.out.println("\n========= MENU QUAN LY HOA DON =========");
            System.out.println("1. Nhap them hoa don vao danh sach");
            System.out.println("2. Xuat danh sach hoa don");
            System.out.println("3. Sap xep danh sach (Ma MH tang dan, trung thi theo So luong)");
            System.out.println("4. Tim kiem hoa don theo Ma mat hang");
            System.out.println("5. Xoa hoa don theo Ma mat hang");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Chon chuc nang (0-5): ");

            while (!sc.hasNextInt()) {
                System.out.println("Vui long nhap so hop le từ 0 den 5:");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // Doc bo dong trong sau khi nhap so

            switch (choice) {
                case 1:
                    inputInvoice();
                    break;
                case 2:
                    displayInvoices();
                    break;
                case 3:
                    sortInvoice();
                    break;
                case 4:
                    searchInvoice();
                    break;
                case 5:
                    deleteInvoice();
                    break; // DA THEM: Tranh troi xuong case 0
                case 0:
                    System.out.println("Da thoat chuong trinh !");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai !");
                    break;
            }
        } while (choice != 0);
    }

    private static void initMockData() {
        invoicesList.add(new Invoice("MSI01", "Chuot Gaming MSI", 5, 25.5));
        invoicesList.add(new Invoice("LOG02", "Ban phim Logitech", 12, 45.0));
        invoicesList.add(new Invoice("ASU01", "Man hinh Asus 24 inch", 3, 150.0));
        invoicesList.add(new Invoice("COR01", "RAM Corsair 16GB", 20, 65.0));
        invoicesList.add(new Invoice("SAM01", "SSD Samsung 1TB", 8, 89.9));
        invoicesList.add(new Invoice("LOG02", "Trung ma test", 2, 10.0));
        invoicesList.add(new Invoice("GIG01", "Mainboard Gigabyte", 4, 120.0));
        invoicesList.add(new Invoice("COR02", "Nguon Corsair 750W", 15, 75.0));
        invoicesList.add(new Invoice("DEL01", "Laptop Dell Vostro", 2, 700.0));
        invoicesList.add(new Invoice("KIN01", "USB Kingston 64GB", 50, 5.5));
        invoicesList.add(new Invoice("ASU01", "Man hinh Asus mau 2", 1, 150.0));
    }

    // Nhap them hoa don (va dam bao khong trung ma)
    private static void inputInvoice() {
        System.out.println("Nhap ma mat hang:");
        String partNumber = sc.nextLine().trim();

        // Kiem tra trung ma
        for (Invoice inv : invoicesList) {
            if (inv.getpartNumber().equalsIgnoreCase(partNumber)) {
                System.out.println("Loi: Mat hang nay da ton tai trong danh sach!");
                return; // DA SUA: Dung ham luon chu khong cho nhap tiep
            }
        }

        System.out.println("Nhap mo ta mat hang:");
        String partDescription = sc.nextLine();

        System.out.println("Nhap vao so luong:");
        int quanlity = sc.nextInt();

        System.out.println("Nhap gia moi mat hang:");
        double princePerItem = sc.nextDouble();
        sc.nextLine(); // DA THEM: Tranh troi lenh cho lan nhap sau

        Invoice newInvoice = new Invoice(partNumber, partDescription, quanlity, princePerItem);
        invoicesList.add(newInvoice);
        System.out.println("Them hoa don thanh cong!");
    }

    // In thong tin
    private static void displayInvoices() {
        if (invoicesList.isEmpty()) {
            System.out.println("Danh sach rong !");
            return;
        }
        System.out.println("\n=== Danh sach hoa don ===");
        for (Invoice inv : invoicesList) {
            System.out.println(inv);
        }
    }

    // Ham hoan doi vi tri
    public static void swap(int i, int j) {
        Invoice temp = invoicesList.get(i);
        invoicesList.set(i, invoicesList.get(j)); // DA SUA: Gan gia tri tai j vao i
        invoicesList.set(j, temp);
    }

    // Sap xep noi bot
    private static void sortInvoice() {
        int n = invoicesList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Invoice inv1 = invoicesList.get(j);
                Invoice inv2 = invoicesList.get(j + 1);

                int compResult = inv1.getpartNumber().compareToIgnoreCase(inv2.getpartNumber());

                if (compResult > 0) {
                    swap(j, j + 1);
                } else if (compResult == 0) {
                    if (inv1.getQuanlity() > inv2.getQuanlity()) {
                        swap(j, j + 1);
                    }
                }
            }
        }
        System.out.println("Da sap xep danh sach theo thu tu tang dan !");
    }

    // Ham Tim Kiem
    private static void searchInvoice() {
        System.out.println("Nhap ma can tim kiem:");
        String searchCode = sc.nextLine().trim();
        boolean found = false;

        for (Invoice inv : invoicesList) {
            if (inv.getpartNumber().equalsIgnoreCase(searchCode)) {
                System.out.println("Ket qua tim thay: " + inv);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay hoa don nao co ma: " + searchCode);
        }
    }

    // Xoa hoa don
    private static void deleteInvoice() {
        System.out.println("Nhap ma hang can xoa:");
        String deleteCode = sc.nextLine().trim();
        boolean removed = false;

        for (int i = invoicesList.size() - 1; i >= 0; i--) {
            if (invoicesList.get(i).getpartNumber().equalsIgnoreCase(deleteCode)) {
                invoicesList.remove(i);
                removed = true;
            }
        }

        if (removed) {
            System.out.println("Da xoa cac mat hang co ma la: " + deleteCode);
        } else {
            System.out.println("Khong tim thay mat hang nao co ma tuong ung de xoa !");
        }
    }
}