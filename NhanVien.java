import java.util.Scanner;

public class NhanVien {
    private String ho;
    private String ten;
    private int soSP;

    // Hàm khởi tạo Conctructor(có tham số)
    public NhanVien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        if (soSP >= 0) {
            this.soSP = soSP;
        } else {
            this.soSP = 0;
        }
    }

    // Dùng get và set để dùng các phần tử được khai báo là private
    public String getHo() {
        return ho;
    }

    public String setHo(String ho) {
        return this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public String setTen(String ten) {
        return this.ten = ten;
    }

    public int getSP() {
        return soSP;
    }

    public int setSP(int soSP) {
        if (soSP >= 0) {
            return this.soSP = soSP;
        } else {
            return this.soSP = 0;
        }
    }

    // CT tính Lương =SoSP*Đơn giá
    public double TinhLuong() {
        double Dongia = 1;
        if (soSP >= 1 && soSP <= 199) {
            Dongia = 0.5;
        } else if (soSP >= 200 && soSP <= 399) {
            Dongia = 0.55;
        } else if (soSP >= 400 && soSP <= 599) {
            Dongia = 0.6;
        } else if (soSP >= 600) {
            Dongia = 0.65;
        }
        return (double) soSP * Dongia;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien nv = new NhanVien("Nguyen", "Van A", 250);
        NhanVien nv2 = new NhanVien("Nguyen", "Thi B", 150);
        System.out.println("Nhan vien:" + nv.getHo() + " " + nv.getTen());
        System.out.println("Luong:" + nv.TinhLuong());
        if (nv.getSP() > nv2.getSP()) {
            System.out.println("So san pham cua nhan vien 1 cao hon nhan vien 2");
        } else {
            System.out.println("So san pham cua nhan vien 2 con hon nhan vien 1");
        }
        // Nhập vào 2 nhân viên
        int n = 2;
        NhanVien[] nvArray = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin nhan vien thu " + (i + 1));
            System.out.print("Ho:");
            String ho = sc.nextLine();
            System.out.print("Ten:");
            String ten = sc.nextLine();
            System.out.print("So SP:");
            int sp = sc.nextInt();
            // Chống trôi lệnh
            sc.nextLine();
            // Khơi tạo đối tượng trước khi gán vào mảng
            nvArray[i] = new NhanVien(ho, ten, sp);
        }
        for (NhanVien nv3 : nvArray) {
            System.out.println(nv3.getHo() + " " + nv3.getTen() + " - Luong: " + nv3.TinhLuong());
        }
        sc.close();
    }
}