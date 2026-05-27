package CRUD;

import java.sql.*;

public class NamCNTT {
	public static void listNamCNNT() {
		String sql = "SELECT GV.HOTEN, GV.GIOITINH, K.MAKHOA " +
				"FROM GIAOVIEN GV " +
				"JOIN KHOA K ON GV.MAKHOA = K.MAKHOA " +
				"WHERE GV.GIOITINH='Nam' " +
				"AND K.MAKHOA='CNNT'";
		try (Connection conn = DBConnection.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			System.out.println("Danh sach giao vien");
			while (rs.next()) {
				String hoTen = rs.getString("HOTEN");
				String gioiTinh = rs.getString("GIOITINH");

				System.out.println("Họ tên: " + hoTen + "| Giới tính:" + gioiTinh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
