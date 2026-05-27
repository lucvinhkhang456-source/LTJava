package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Connection.DBConnection;
import model.MonAn;

public class MonAnDao {
    public static void themMon(MonAn mon) {
        String sql = "INSERT INTO MONAN(MAMON,TENMON,DONGIA)" +
                "VALUES (?,?,?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mon.getMaMon());
            ps.setString(2, mon.getTenMon());
            ps.setInt(3, mon.getDonGia());
            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("Them mon thanh cong !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hienThiMenu() {
        String sql = "SELECT * FROM MONAN";

        try (
                Connection conn = DBConnection.getConnection();

                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql)) {
            System.out.println("===== Meunu =====");
            while (rs.next()) {
                System.out.println(rs.getString("MAMON")
                        + " | "
                        + rs.getString("TENMON")
                        + "|"
                        + rs.getString("DONGIA"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
