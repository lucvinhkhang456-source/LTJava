package All;

import java.sql.*;
import java.util.Scanner;

public class LibraryManager {
    Scanner sc = new Scanner(System.in);

    // Chức năng thêm (dùng chung cho cả Sách và NXB)
    public void themDuLieu(int loai) {
        try (Connection conn = DBConnection.getConnetion()) {
            if (loai == 1) { // Thêm NXB
                System.out.print("Mã NXB: ");
                String code = sc.nextLine();
                System.out.print("Tên NXB: ");
                String name = sc.nextLine();
                System.out.print("Địa chỉ: ");
                String addr = sc.nextLine();
                System.out.print("SĐT: ");
                String phone = sc.nextLine();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO tblPublisher VALUES (?, ?, ?, ?)");
                ps.setString(1, code);
                ps.setString(2, name);
                ps.setString(3, addr);
                ps.setString(4, phone);
                ps.executeUpdate();
                System.out.println("Thêm NXB thành công!");
            } else { // Thêm Sách
                System.out.print("Mã sách: ");
                String code = sc.nextLine();
                System.out.print("Tên sách: ");
                String name = sc.nextLine();
                System.out.print("Mã NXB: ");
                String pubCode = sc.nextLine();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO tblBook VALUES (?, ?, ?)");
                ps.setString(1, code);
                ps.setString(2, name);
                ps.setString(3, pubCode);
                ps.executeUpdate();
                System.out.println("Thêm sách thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void timKiemSach(String keyword) {
        String sql = "SELECT * FROM tblBook WHERE BookName LIKE ? OR BookCode LIKE ?";
        try (Connection conn = DBConnection.getConnetion();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("BookCode") + " | " + rs.getString("BookName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xemDanhSachNXB() {
        try (Connection conn = DBConnection.getConnetion();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM tblPublisher")) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + " - " + rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void thongKeNXB() {
        String sql = "SELECT p.PublisherName, COUNT(b.BookCode) as SoLuong FROM tblPublisher p " +
                "LEFT JOIN tblBook b ON p.PublisherCode = b.PublisherCode GROUP BY p.PublisherName";
        try (Connection conn = DBConnection.getConnetion();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("NXB: " + rs.getString(1) + " | Sách: " + rs.getInt(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}