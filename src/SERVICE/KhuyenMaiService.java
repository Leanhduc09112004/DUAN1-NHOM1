package SERVICE;

import MODEL.KhuyenMai;
import REPO.DBConnect;
import java.sql.*;
import java.util.ArrayList;

public class KhuyenMaiService {

    public ArrayList<KhuyenMai> getAll() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        try {
            String sql ="SELECT MaKM,TenKM, NgayBatDau, NgayKetThuc, DieuKien, TienGiam, TrangThai FROM KhuyenMai";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn .prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString("MaKM"));
                km.setTenKM(rs.getString("TenKM"));
                km.setNgayBatDau(rs.getDate("NgayBatDau"));
                km.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                km.setDieuKien(rs.getString("DieuKien"));
                km.setTienGiam(rs.getDouble("TienGiam"));
                km.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }
}
