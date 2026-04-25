import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// put sửa
public class hashMap {
    static HashMap<Integer, String> dsSach = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n=====MENU QUAN LY SACH ======");
            System.out.println("1.Them sach moi");
            System.out.println("2.Xuat danh sach moi");
            System.out.println("3.Sua ten sach");
            System.out.println("4.Xoa sach");
            System.out.println("5.Tim kiem sach theo ma");
            System.out.println("0.Thoat");
            System.out.print("Moi ban chon chuc nang (0-5:)");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    themSach();
                    break;
                case 2:
                    xuatSach();
                    break;
                case 3:
                    suaSach();
                    break;
                case 4:
                    xoaSach();
                    break;
                case 5:
                    timKiem();
                    break;
                default:
                    System.out.println("Tam biet ! Hen gap lai");
                    break;
            }
        } while (chon != 0);
    }

    public static void themSach() {
        System.out.println("Nhap ma sach:");
        int ma = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten sach:");
        String tenSach = sc.nextLine();
        dsSach.put(ma, tenSach);
        System.out.println("Da them thanh cong !");
    }

    public static void xuatSach() {
        if (dsSach.isEmpty()) {
            System.out.println("Danh sach dang rong");
        } else {
            System.out.println("Danh sach hien tai:");
            for (Map.Entry<Integer, String> entry : dsSach.entrySet()) {
                System.out.println("ID:" + entry.getKey() + "-Ten:" + entry.getValue());
            }
        }
    }

    public static void suaSach() {
        System.out.println("Nhap ma sach can sua (key):");
        int ma = sc.nextInt();
        sc.nextLine();
        if (dsSach.containsKey(ma)) {
            System.out.println("Nhap ten sach moi:");
            String tenMoi = sc.nextLine();
            dsSach.put(ma, tenMoi);
            System.out.println("Sua thanh cong !");
        } else {
            System.out.println("Khong tim thay ma sach:" + ma);
        }
    }

    public static void xoaSach() {
        System.out.println("Nhap ma sach can xoa (key):");
        int ma = sc.nextInt();
        if (dsSach.containsKey(ma)) {
            dsSach.remove(ma);
            System.out.println("Da xoa thanh cong !");
        } else {
            System.out.println("Khong tim thay ma de xoa");
        }
    }

    public static void timKiem() {
        System.out.println("Nhap ten sach can tim kiem (value):");
        String tenMoi = sc.nextLine();
        if (dsSach.containsValue(tenMoi)) {
            System.out.println("Da tim duoc sach " + tenMoi);
        } else {
            System.out.println("Rat tiec ,khong tim thay sach !");
        }
    }
}
