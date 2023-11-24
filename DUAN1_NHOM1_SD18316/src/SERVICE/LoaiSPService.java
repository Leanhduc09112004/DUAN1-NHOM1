package SERVICE;

import MODEL.ChiTietSanPham;
import MODEL.LoaiSanPham;
import REPO.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoaiSPService {

    public ArrayList<LoaiSanPham> getAll() {
        ArrayList<LoaiSanPham> list = new ArrayList<>();
        String sql = "SELECT TenLoaiSanPham\n"
                + "FROM LoaiSanPham";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiSanPham sp = new LoaiSanPham();
                sp.setTenLoaiSP(rs.getString(1));
                list.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


}
