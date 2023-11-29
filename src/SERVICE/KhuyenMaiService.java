/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.KhuyenMai;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.*;

public class KhuyenMaiService {

    //van2811
    public ArrayList<KhuyenMai> getAll(String ten, String ma) {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "SELECT MaKM,TenKM, NgayBatDau, NgayKetThuc, DieuKien, TienGiam, GhiChu, TrangThai FROM KhuyenMai\n"
                + "WHERE TenKM LIKE ? OR MaKM LIKE ?";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString("MaKM"));
                km.setTenKM(rs.getString("TenKM"));
                km.setNgayBatDau(rs.getDate("NgayBatDau"));
                km.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                km.setDieuKien(rs.getString("DieuKien"));
                km.setTienGiam(rs.getDouble("TienGiam"));
                km.setGhiChu(rs.getString("GhiChu"));
                km.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(km);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    //van2811
    public Integer addKM(KhuyenMai km) {
        Integer row = null;
        String sql = "INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc, DieuKien, TienGiam,GhiChu, TrangThai)\n"
                + "VALUES (?, ?, ?, ?, ?,?,?,?)";

        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, km.getMaKM());
            ps.setString(2, km.getTenKM());
            ps.setDate(3, new java.sql.Date(km.getNgayBatDau().getTime()));
            ps.setDate(4, new java.sql.Date(km.getNgayKetThuc().getTime()));
            ps.setString(5, km.getDieuKien());
            ps.setString(6, km.getTienGiam() + "");
            ps.setString(7, km.getGhiChu());
            ps.setBoolean(8, km.isTrangThai());

            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }
        return row;
    }

    //van
    public Integer updateKM(KhuyenMai km) {
        Integer row = null;

        try {
            String sql = "UPDATE KhuyenMai SET TenKM=?, NgayBatDau=?,  NgayKetThuc=?, DieuKien=?, TienGiam=?,GhiChu=?, TrangThai=? WHERE MaKM = ?";

            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, km.getTenKM());
            ps.setDate(2, new java.sql.Date(km.getNgayBatDau().getTime()));
            ps.setDate(3, new java.sql.Date(km.getNgayKetThuc().getTime()));
            ps.setString(4, km.getDieuKien());
            ps.setString(5, km.getTienGiam() + "");
            ps.setString(6, km.getGhiChu());
            ps.setBoolean(7, km.isTrangThai());
            ps.setString(8, km.getMaKM());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating KhuyenMai: " + e.getMessage());
        }
        return row;
    }
    //van28/11

    public Integer updateTrangThai(KhuyenMai km) {
        Integer row = null;
        try {
            String sql = "UPDATE KhuyenMai SET TrangThai= ? WHERE MaKM=?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setBoolean(1, km.isTrangThai());
            pst.setString(2, km.getMaKM());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return row;
    }
    //van2811

    public ArrayList<KhuyenMai> timKiemKMTheoTT(boolean TrangThai) {
        ArrayList<KhuyenMai> ketQuaTimKiem = new ArrayList<>();
        try {
            String sql = "SELECT MaKM,TenKM, NgayBatDau, NgayKetThuc, DieuKien, TienGiam, GhiChu, TrangThai FROM KhuyenMai WHERE TrangThai=?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setBoolean(1, TrangThai);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();

                km.setMaKM(rs.getString("MaKM"));
                km.setTenKM(rs.getString("TenKM"));
                km.setNgayBatDau(rs.getDate("NgayBatDau"));
                km.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                km.setDieuKien(rs.getString("DieuKien"));
                km.setTienGiam(rs.getDouble("TienGiam"));
                km.setGhiChu(rs.getString("GhiChu"));
                km.setTrangThai(rs.getBoolean("TrangThai"));
                ketQuaTimKiem.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return ketQuaTimKiem;
    }

//     28/11van
    public Boolean delete(KhuyenMai km) {
        String sql = """
           DELETE FROM KhuyenMai WHERE MaKM = ?
              """;

        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            ps.setObject(1, km.getMaKM());
            ps.executeUpdate();

            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
