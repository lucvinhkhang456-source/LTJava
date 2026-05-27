package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Connection.DBConnection;

public class OrderService {
    public static void taoDonHang(String maNV, String maBan) {
        String sql = "INSERT INTO DONHANG(MANV,MABAN,THOIGIAN,TRANGTHAI) " +
                "VALUES(?,?,?,?)";
        int maDH = -1;
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, maNV);
            ps.setString(2, maBan);
            ps.setString(3, "Da gui bep");
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                maDH = rs.getInt(1);
            }
            System.out.println("Tao don hang thanh cong !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
