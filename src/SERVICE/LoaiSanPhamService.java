package SERVICE;

import MODEL.LoaiSanPham;
import REPO.DBConnect;
import java.sql.*;
import java.util.ArrayList;

public class LoaiSanPhamService {

    public ArrayList<LoaiSanPham> getAll() {
        ArrayList<LoaiSanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT IdLoaiSanPham, MaLoaiSanPham, TenLoaiSanPham FROM LoaiSanPham";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                LoaiSanPham lsp = new LoaiSanPham();
                lsp.setIdLoaiSP(rs.getInt("IdLoaiSanPham"));
                lsp.setMaLoaiSP(rs.getString("MaLoaiSanPham"));
                lsp.setTenLoaiSP(rs.getString("TenLoaiSanPham"));
                list.add(lsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<LoaiSanPham> getAll2() {
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

    public Integer addLoaiSanPham(LoaiSanPham loaiSanPham) {
        Integer row = null;
        try {
            String sql = "INSERT INTO LoaiSanPham (MaLoaiSanPham, TenLoaiSanPham) VALUES (?, ?)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, loaiSanPham.getMaLoaiSP());
            pst.setString(2, loaiSanPham.getTenLoaiSP());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public Integer updateLoaiSanPham(LoaiSanPham loaiSanPham) {
        Integer row = null;
        try {
            String sql = "UPDATE LoaiSanPham SET TenLoaiSanPham = ? WHERE MaLoaiSanPham = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, loaiSanPham.getTenLoaiSP());
            pst.setString(2, loaiSanPham.getMaLoaiSP());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }

    public Integer deleteLoaiSanPham(String maLoaiSP) {
        Integer row = null;
        try {
            String sql = "DELETE FROM LoaiSanPham WHERE MaLoaiSanPham = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, maLoaiSP);
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }
}
