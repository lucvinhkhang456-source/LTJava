import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class menuArrayList {
    // Set sửa
    // Remove xóa
    // Contains kiểm tra tồn tại (tìm kiếm)
    // Sort sắp xếp
    static ArrayList<String> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== QUAN LY ARRAYLIST =====");
            System.out.println("1. Them so vao danh sach");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Sua phan tu");
            System.out.println("4. Xoa phan tu");
            System.out.println("5. Tim kiem");
            System.out.println("6. Sap xep");
            System.out.println("7. Dem so luong sinh vien");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    themSinhVien();
                    break;

                case 2:
                    xuatSinhVien();
                    break;
                case 3:
                    suaSinhVien();
                    break;
                case 4:
                    xoaSinhVien();
                    break;
                case 5:
                    timKiemSinhVien();
                    break;
                case 6:
                    sapXep();
                    break;
                case 7:
                    demSinhVien();
                    break;
                default:
                    System.out.println("Tam biet ! Hen gap lai");
                    break;
            }
        } while (chon != 0);
    }

    public static void themSinhVien() {
        System.out.println("Nhap ten sinh vien: ");
        String val = sc.nextLine();
        list.add(val);
        System.out.println("Da them sinh vien " + list + " thanh cong !");
    }

    public static void xuatSinhVien() {
        if (list.isEmpty()) {
            System.out.println("Danh sach dang rong");
        } else {
            System.out.println("Danh sach" + list + " ");
        }
    }

    public static void suaSinhVien() {
        System.out.print("Nhap vi tri can sua (index):");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index <= list.size()) {
            System.out.print("Nhap ten moi:");
            String newVal = sc.nextLine();
            list.set(index, newVal);
            System.out.println("Da sua thanh cong !");
        } else {
            System.out.println("Vi tri khong ton tai !");
        }
    }

    public static void xoaSinhVien() {
        System.out.println("Nhap vi can xoa (index): ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index >= 0 && index <= list.size()) {
            list.remove(index);
            System.out.println("Da xoa thanh cong !");
        } else {
            System.out.println("Vi tri khong ton tai !");
        }
    }

    public static void timKiemSinhVien() {
        System.out.println("Nhap ten can tim kiem (value):");
        String val = sc.nextLine();
        if (list.contains(val)) {
            System.out.println("Tim thay sinh vien ten " + val + " tai vi tri " + list.indexOf(val));
        } else {
            System.out.println("Khong tim thay sinh vien ten " + val);
        }
    }

    public static void sapXep() {
        Collections.sort(list);
        System.out.println("Da sap xep tang dan (A-Z):" + list);
    }

    public static void demSinhVien() {
        int soluong = list.size();
        if (soluong == 0) {
            System.out.println("Danh sach rong !");
        } else {
            System.out.println("So luong sinh vien:" + soluong);
        }
    }
}
