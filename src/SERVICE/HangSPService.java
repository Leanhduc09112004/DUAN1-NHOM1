package SERVICE;

import MODEL.HangSX;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.*;
public class HangSPService {
    public ArrayList<HangSX> getAll(){
        ArrayList<HangSX> list = new ArrayList<>();
        try {
            String sql = "SELECT MaHangSanXuat, TenHangSanXuat FROM HangSanXuat ";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                HangSX hsx = new HangSX();
                hsx.setMaHangSX(rs.getString("MaHangSanXuat"));
                hsx.setTenHangSX(rs.getString("TenHangSanXuat"));
                list.add(hsx);
            }
        } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
        }
        return list;
    }
}
