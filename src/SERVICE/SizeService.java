package SERVICE;

import MODEL.SizeSP;
import REPO.DBConnect;
import java.sql.*;
import java.util.ArrayList;

public class SizeService {

    public ArrayList<SizeSP> getAll() {
        ArrayList<SizeSP> list = new ArrayList<>();
        try {
            String sql = "SELECT IdSize, MaSize,Size FROM SizeSP";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SizeSP size = new SizeSP();
                size.setIdSizeSP(rs.getInt("IdSize"));
                size.setMaSizeSP(rs.getString("MaSize"));
                size.setSizeSP(rs.getString("Size"));
                list.add(size);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    public Integer addSizeSP(SizeSP size) {
        Integer row = null;
        try {
            String sql = "INSERT INTO SizeSP (MaSize, Size) VALUES (?,?)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, size.getMaSizeSP());
            pst.setString(2, size.getSizeSP());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public Integer updateSize(SizeSP size) {
        Integer row = null;
        try {
            String sql = "UPDATE SizeSP SET Size = ? WHERE MaSize = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, size.getSizeSP());
            pst.setString(2, size.getMaSizeSP());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public Integer deleteSizeSP(String maSize) {
        Integer row = null;
        try {
            String sql = "DELETE FROM SizeSP WHERE MaSize = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, maSize);
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }
}
