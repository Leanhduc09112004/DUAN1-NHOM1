/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.KhuyenMai;
import MODEL.LoaiSanPham;
import MODEL.SanPham;
import REPO.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class KhuyenMaiService {

    public ArrayList<KhuyenMai> getAll(String ten, String ma) {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "SELECT A.MaKM, A.TenKM, A.NgayBatDau, A.NgayKetThuc, S.MaSP, A.TienGiam, A.TrangThai\n"
                + "FROM KhuyenMai A JOIN ChiTietSanPham B ON A.IdSP = B.IdSP\n"
                + "                JOIN SanPham S ON B.IdSP= S.IdSP\n"
                + "                JOIN LoaiSanPham L ON B.IdLoaiSanPham=L.IdLoaiSanPham\n"
                + "WHERE A.MaKM LIKE ? OR A.TenKM LIKE ?";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setMaSP(rs.getString(5));

                KhuyenMai k = new KhuyenMai();
                k.setMaKM(rs.getString(1));
                k.setTenKM(rs.getString(2));
                k.setNgayBatDau(rs.getDate(3));
                k.setNgayKetThuc(rs.getDate(4));
                k.setIdSp(s);
                k.setTienGiam(rs.getDouble(6));
                k.setTrangThai(rs.getBoolean(7));
                list.add(k);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<KhuyenMai> getKhuyenMai(String ten, String ma) {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        String sql = "SELECT * FROM KhuyenMai";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setIdSP(rs.getInt("IdSP"));

                KhuyenMai k = new KhuyenMai();
                k.setIdKM(rs.getInt("IdKM"));
                k.setMaKM(rs.getString("MaKM"));
                k.setTenKM(rs.getString("TenKM"));
                k.setNgayBatDau(rs.getDate("NgayBatDau"));
                k.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                k.setDieuKien(rs.getString("DieuKien"));
                k.setIdSp(s);
                k.setTienGiam(rs.getDouble("TienGiam"));
                k.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(k);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public Integer addKhuyenMai() {
        Integer row = null;
        String sql = "SELECT * FROM KhuyenMai";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setIdSP(rs.getInt("IdSP"));

                KhuyenMai k = new KhuyenMai();
                k.setIdKM(rs.getInt("IdKM"));
                k.setMaKM(rs.getString("MaKM"));
                k.setTenKM(rs.getString("TenKM"));
                k.setNgayBatDau(rs.getDate("NgayBatDau"));
                k.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                k.setDieuKien(rs.getString("DieuKien"));
                k.setIdSp(s);
                k.setTienGiam(rs.getDouble("TienGiam"));
                k.setTrangThai(rs.getBoolean("TrangThai"));
                row= ps.executeUpdate();
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }
}
