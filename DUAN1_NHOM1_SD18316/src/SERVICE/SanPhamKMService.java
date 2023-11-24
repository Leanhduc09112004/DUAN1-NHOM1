/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.ChiTietSanPham;
import MODEL.HangSX;
import MODEL.MauSac;
import MODEL.SanPhamKhuyenMai;
import MODEL.SizeSP;
import java.util.ArrayList;
import REPO.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class SanPhamKMService {

    public ArrayList<SanPhamKhuyenMai> getList(String loaiSP) {
        ArrayList<SanPhamKhuyenMai> list = new ArrayList<>();
        String sql = "SELECT B.MaSP, B.TenSP, A.GiaBan, S.Size, M.TenMau, H.TenHangSanXuat\n"
                + "FROM ChiTietSanPham A JOIN SanPham B ON A.IdSP = B.IdSP\n"
                + "JOIN HangSanXuat H ON A.IdHang = H.IdHang\n"
                + "JOIN SizeSP S ON A.IdSize = S.IdSize\n"
                + "JOIN LoaiSanPham L ON A.IdLoaiSanPham = L.IdLoaiSanPham\n"
                + "JOIN MauSac M ON A.IdMau = M.IdMau\n"
                + "WHERE L.TenLoaiSanPham LIKE ?";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + loaiSP + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ct = new ChiTietSanPham();
//                ct.setGiaBan(rs.getFloat(3));

                SizeSP s = new SizeSP();
                s.setTenSize(rs.getString(4));

                MauSac m = new MauSac();
                m.setTenMau(rs.getString(5));

                HangSX h = new HangSX();
                h.setTenHangSX(rs.getString(6));

                SanPhamKhuyenMai sp = new SanPhamKhuyenMai();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setGiaBan(ct);
                sp.setSize(s);
                sp.setMau(m);
                sp.setHang(h);
                list.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
