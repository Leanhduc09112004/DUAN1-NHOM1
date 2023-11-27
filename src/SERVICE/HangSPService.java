package SERVICE;

import MODEL.HangSX;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.*;

public class HangSPService {

    public ArrayList<HangSX> getAll() {
        ArrayList<HangSX> list = new ArrayList<>();
        try {
            String sql = "SELECT IdHang, MaHangSanXuat, TenHangSanXuat FROM HangSanXuat ";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HangSX hsx = new HangSX();
                hsx.setIdHangSX(rs.getInt("IdHang"));
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

    public Integer addHangSX(HangSX hangSX) {
        Integer row = null;
        try {
            String sql = "INSERT INTO HangSanXuat (MaHangSanXuat, TenHangSanXuat) VALUES (?, ?)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, hangSX.getMaHangSX());
            pst.setString(2, hangSX.getTenHangSX());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public Integer updateHangSX(HangSX hangSX) {
        Integer row = null;
        try {
            String sql = "UPDATE HangSanXuat SET TenHangSanXuat = ? WHERE MaHangSanXuat = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, hangSX.getTenHangSX());
            pst.setString(2, hangSX.getMaHangSX());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public Integer deleteHangSX(String maHangSX) {
        Integer row = null;
        try {
            String sql = "DELETE FROM HangSanXuat WHERE MaHangSanXuat = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, maHangSX);
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }
}
