package SERVICE;

import MODEL.MauSac;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.*;

public class MauSacService {

    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> list = new ArrayList<>();
        try {
            String sql = "SELECT  MaMau,TenMau FROM MauSac";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                MauSac mau = new MauSac();
                mau.setMaMauSP(rs.getString("MaMau"));
                mau.setMauSP(rs.getString("TenMau"));
                list.add(mau);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    public Integer addMauSac(MauSac mauSac) {
        Integer row = null;
        try {
            String sql = "INSERT INTO MauSac (MaMau, TenMau) VALUES (?, ?)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, mauSac.getMaMauSP());
            pst.setString(2, mauSac.getMauSP());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public Integer updateMauSac(MauSac mauSac) {
        Integer row = null;
        try {
            String sql = "UPDATE MauSac SET TenMau = ? WHERE MaMau = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, mauSac.getMauSP());
            pst.setString(2, mauSac.getMaMauSP());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }
}
