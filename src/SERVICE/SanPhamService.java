package SERVICE;

import MODEL.HangSX;
import MODEL.KhuyenMai;
import MODEL.LoaiSanPham;
import MODEL.MauSac;
import MODEL.SanPham;
import MODEL.SizeSP;
import REPO.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class SanPhamService {

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT A.MaSP, A.TenSP, B.TenLoaiSanPham, A.GiaBan, A.GiaNhap, A.HinhAnh, A.Mota, A.Soluong,C.TenMau,D.TenHangSanXuat,E.Size,A.TrangThai FROM \n"
                    + "SanPham A JOIN LoaiSanPham B ON A.IdLoaiSanPham=B.IdLoaiSanPham JOIN MauSac C ON A.IdMau=C.IdMau \n"
                    + "JOIN HangSanXuat D ON A.IdHang=D.IdHang JOIN SizeSP E ON A.IdSize=E.IdSize";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));

                LoaiSanPham lsp = new LoaiSanPham();
                lsp.setTenLoaiSP(rs.getString("TenLoaiSanPham"));
                sp.setIdLoaiSP(lsp);

                sp.setGiaBan(rs.getDouble("GiaBan"));
                sp.setGiaNhap(rs.getDouble("GiaNhap"));
                sp.setHinhAnh(rs.getString("HinhAnh"));
                sp.setMoTa(rs.getString("MoTa"));
                sp.setSoluong(rs.getInt("SoLuong"));

                MauSac mau = new MauSac();
                mau.setMauSP(rs.getString("TenMau"));
                sp.setIdMauSac(mau);

                SizeSP sz = new SizeSP();
                sz.setSizeSP(rs.getString("Size"));
                sp.setIdSize(sz);

                HangSX hsx = new HangSX();
                hsx.setTenHangSX(rs.getString("TenHangSanXuat"));
                sp.setIdHang(hsx);

                sp.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    public Integer addSanPham(SanPham sp) {
        Integer row = null;
        try {
            int idLoaiSP = sp.getIdLoaiSP().getIdLoaiSP();
            int idMau = sp.getIdMauSac().getIdMauSP();
            int idSize = sp.getIdSize().getIdSizeSP();
            int idHang = sp.getIdHang().getIdHangSX();

            System.out.println("idLoaiSP: " + idLoaiSP);
            System.out.println("idMau: " + idMau);
            System.out.println("idSize: " + idSize);
            System.out.println("idHang: " + idHang);

            String sql = "INSERT INTO SanPham (MaSP, TenSP, IdLoaiSanPham, GiaBan, GiaNhap, HinhAnh, Mota, Soluong, IdMau, IdHang, IdSize, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, sp.getMaSP());
            pst.setString(2, sp.getTenSP());
            pst.setInt(3, sp.getIdLoaiSP().getIdLoaiSP());
            pst.setDouble(4, sp.getGiaBan());
            pst.setDouble(5, sp.getGiaNhap());
            pst.setString(6, sp.getHinhAnh());
            pst.setString(7, sp.getMoTa());
            pst.setInt(8, sp.getSoluong());
            pst.setInt(9, sp.getIdMauSac().getIdMauSP());
            pst.setInt(10, sp.getIdHang().getIdHangSX());
            pst.setInt(11, sp.getIdSize().getIdSizeSP());
            pst.setBoolean(12, sp.isTrangThai());

            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return row;
    }

    public Integer updateSanPham(SanPham sp) {
        Integer row = null;
        try {
            String sql = "UPDATE SanPham SET IdLoaiSanPham = ?, GiaBan = ?, GiaNhap = ?, HinhAnh = ?, Mota = ?, Soluong = ?, IdMau = ?, IdHang = ?, IdSize = ?, IdKM = ?, TrangThai = ? WHERE MaSP = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, sp.getIdLoaiSP().getIdLoaiSP());
            pst.setDouble(2, sp.getGiaBan());
            pst.setDouble(3, sp.getGiaNhap());
            pst.setString(4, sp.getHinhAnh());
            pst.setString(5, sp.getMoTa());
            pst.setInt(6, sp.getSoluong());
            pst.setInt(7, sp.getIdMauSac().getIdMauSP());
            pst.setInt(8, sp.getIdHang().getIdHangSX());
            pst.setInt(9, sp.getIdSize().getIdSizeSP());
            pst.setInt(10, sp.getIdKM().getIdKM());
            pst.setBoolean(11, sp.isTrangThai());
            pst.setString(12, sp.getMaSP());

            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return row;
    }

}
