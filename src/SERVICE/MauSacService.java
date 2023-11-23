package SERVICE;

import MODEL.MauSac;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.*;
public class MauSacService {

    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            String sql = "SELECT MaMau, TenMau FROM MauSac";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                MauSac mau = new MauSac();
                mau.setMaMauSP("MaMau");
                mau.setMauSP(rs.getString("TenMau"));
                list.add(mau);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }
}
