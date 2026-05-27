package CRUD;

import java.sql.*;

public class QuanLyGiaoVien {

    // Thêm giáo viên
    public static void themGV(String magv, String hoten, String hocvi, String hocham, String gioitinh, double heso,
            int mucluong, String makhoa) {
        String sql = "INSERT INTO GIAOVIEN(MAGV,HOTEN,HOCVI,HOCHAM,GIOITINH,HESO,MUCLUONG,MAKHOA)" +
                "VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, magv);
            ps.setString(2, hoten);
            ps.setString(3, hocvi);
            ps.setString(4, hocham);
            ps.setString(5, gioitinh);
            ps.setDouble(6, heso);
            ps.setInt(7, mucluong);
            ps.setString(8, makhoa);

            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Them giao vien thanh cong !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xoaGV(String magv) {
        String sql = "DELETE FROM GIAOVIEN WHERE MAGV=?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, magv);
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Xoa giao vien thanh cong !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void suaGV(
            String magv,
            String hoten,
            String hocvi,
            String hocham,
            String gioitinh,
            double heso,
            int mucluong,
            String makhoa) {

        String sql = "UPDATE GIAOVIEN " +
                "SET HOTEN=?, HOCVI=?, HOCHAM=?, GIOITINH=?, " +
                "HESO=?, MUCLUONG=?, MAKHOA=? " +
                "WHERE MAGV=?";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, hoten);
            ps.setString(2, hocvi);
            ps.setString(3, hocham);
            ps.setString(4, gioitinh);
            ps.setDouble(5, heso);
            ps.setInt(6, mucluong);
            ps.setString(7, makhoa);
            ps.setString(8, magv);

            int row = ps.executeUpdate();

            if (row > 0) {
                System.out.println("Sửa giáo viên thành công");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}