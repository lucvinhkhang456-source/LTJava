package CRUD;

import java.sql.*;

public class QuanLyKhoa {
    public static void themKhoa(String maKhoa, String tenKhoa, String ngayLap, String truongKhoa) {
        String sql = "INSERT INTO KHOA(MAKHOA,TENKHOA,NGTLAP,TRGKHOA) VALUES(?,?,?,?)";
        // Dùng PreparedStatement để gửi biến sql xuống DB
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maKhoa);
            ps.setString(2, tenKhoa);
            ps.setString(3, ngayLap);
            ps.setString(4, truongKhoa);
            // Dùng executeUpdate vì đó dùng để thực thi các lệnh
            // INSERT,UPDATE,DELETE
            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Thêm khoa thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Xóa khoa
    public static void xoaKhoa(String maKhoa) {
        String sql = "DELETE FROM KHOA WHERE MAKHOA=?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maKhoa);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Đã xóa khoa thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void suaKhoa(
            String maKhoa,
            String tenKhoa,
            String ngayLapMoi,
            String truongKhoa) {

        String sql = "UPDATE KHOA " +
                "SET TENKHOA=?, NGTLAP=?, TRGKHOA=? " +
                "WHERE MAKHOA=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tenKhoa);
            ps.setString(2, ngayLapMoi);
            ps.setString(3, truongKhoa);
            ps.setString(4, maKhoa);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Đã sửa khoa thành công");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
