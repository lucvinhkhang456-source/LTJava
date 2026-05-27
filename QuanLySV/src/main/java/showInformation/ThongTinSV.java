package showInformation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class ThongTinSV {
    public void hienThiDanhSach() {
        String sql = "SELECT * FROM SinhVien";

        try (Connection conn = DBConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
                    while (rs.next())
                    {
                        System.out.println(rs.getInt("MaSo")+" - " + rs.getString("HoTen"));
                    }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
