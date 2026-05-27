package CRUD;

public class Main {

    public static void main(String[] args) {

        // ================= THÊM KHOA =================
        QuanLyKhoa.themKhoa(
                "CNTT",
                "Cong nghe thong tin",
                "2025",
                "Nguyen Van A");

        // ================= SỬA KHOA =================
        QuanLyKhoa.suaKhoa(
                "CNTT",
                "Khoa CNTT",
                "2025",
                "Tran Van B");

        // ================= THÊM GIÁO VIÊN =================
        QuanLyGiaoVien.themGV(
                "GV01",
                "Nguyen Van Nam",
                "Tien si",
                "Pho giao su",
                "Nam",
                3.5,
                15000000,
                "CNTT");

        // ================= SỬA GIÁO VIÊN =================
        QuanLyGiaoVien.suaGV(
                "GV01",
                "Le Van B",
                "Thac si",
                "Giang vien",
                "Nam",
                2.5,
                12000000,
                "CNTT");
        // ================= XÓA GIÁO VIÊN =================
        // QuanLyGiaoVien.xoaGV("GV01");

        // // ================= XÓA KHOA =================
        // QuanLyKhoa.xoaKhoa("CNTT");
    }
}