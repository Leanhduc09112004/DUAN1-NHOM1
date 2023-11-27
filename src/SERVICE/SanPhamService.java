package SERVICE;

import MODEL.HangSX;
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
            String sql = "UPDATE SanPham SET TenSP=?, IdLoaiSanPham = ?, GiaBan = ?, GiaNhap = ?, HinhAnh = ?, Mota = ?, Soluong = ?, IdMau = ?, IdHang = ?, IdSize = ?,TrangThai = ? WHERE MaSP = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, sp.getTenSP());
            pst.setInt(2, sp.getIdLoaiSP().getIdLoaiSP());
            pst.setDouble(3, sp.getGiaBan());
            pst.setDouble(4, sp.getGiaNhap());
            pst.setString(5, sp.getHinhAnh());
            pst.setString(6, sp.getMoTa());
            pst.setInt(7, sp.getSoluong());
            pst.setInt(8, sp.getIdMauSac().getIdMauSP());
            pst.setInt(9, sp.getIdHang().getIdHangSX());
            pst.setInt(10, sp.getIdSize().getIdSizeSP());
            pst.setBoolean(11, sp.isTrangThai());
            pst.setString(12, sp.getMaSP());

            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
        return row;
    }

    public Integer updateTrangThai(SanPham sp) {
        Integer row = null;
        try {
            String sql = "UPDATE SanPham SET TrangThai=? WHERE MaSP=? ";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setBoolean(1, sp.isTrangThai());
            pst.setString(2, sp.getMaSP());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return row;
    }

    public ArrayList<SanPham> timKiemTrangThai(boolean TrangThai) {
        ArrayList<SanPham> ketQuanTimKiem = new ArrayList<>();
        try {
            String sql = "SELECT A.MaSP, A.TenSP, B.TenLoaiSanPham, A.GiaBan, A.GiaNhap, A.HinhAnh, A.Mota, A.Soluong,C.TenMau,D.TenHangSanXuat,E.Size,A.TrangThai \n"
                    + "FROM SanPham A JOIN LoaiSanPham B ON A.IdLoaiSanPham=B.IdLoaiSanPham JOIN MauSac C ON A.IdMau=C.IdMau \n"
                    + "JOIN HangSanXuat D ON A.IdHang=D.IdHang JOIN SizeSP E ON A.IdSize=E.IdSize WHERE A.TrangThai = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setBoolean(1, TrangThai);
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
                ketQuanTimKiem.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return ketQuanTimKiem;
    }
}
