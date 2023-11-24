package SERVICE;

import MODEL.ChiTietSanPham;
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

    public ArrayList<ChiTietSanPham> getAll() {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = "SELECT B.MaSP, B.TenSP\n"
                    + ", D.TenLoaiSanPham ,A.GiaBan\n"
                    + ",A.GiaNhap,A.HinhAnh\n"
                    + ",A.Soluong,F.Size\n"
                    + ",C.TenMau,E.TenHangSanXuat\n"
                    + ",A.Mota,G.TenKM,B.TrangThai \n"
                    + "FROM ChiTietSanPham A JOIN SanPham B ON A.IdSP=B.IdSP \n"
                    + "JOIN MauSac C ON C.IdMau=A.IdMau \n"
                    + "JOIN LoaiSanPham D ON D.IdLoaiSanPham=A.IdLoaiSanPham\n"
                    + "JOIN HangSanXuat E ON E.IdHang=A.IdHang \n"
                    + "JOIN SizeSP F ON F.IdSize=A.IdSize \n"
                    + "JOIN KhuyenMai G ON G.IdKM=A.IdKM";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));
                ctsp.setIdSP(sp);

                LoaiSanPham lsp = new LoaiSanPham();
                lsp.setTenLoaiSP(rs.getString("TenLoaiSanPham"));
                ctsp.setIdLoaiSP(lsp);

                ctsp.setGiaBan(rs.getDouble("GiaBan"));
                ctsp.setGiaNhap(rs.getDouble("GiaNhap"));
                ctsp.setHinhAnh(rs.getString("HinhAnh"));
                ctsp.setMoTa(rs.getString("MoTa"));
                ctsp.setSoluong(rs.getInt("SoLuong"));

                MauSac mau = new MauSac();
                mau.setMauSP(rs.getString("TenMau"));
                ctsp.setIdMauSac(mau);

                SizeSP sz = new SizeSP();
                sz.setSizeSP(rs.getString("Size"));
                ctsp.setIdSize(sz);

                HangSX hsx = new HangSX();
                hsx.setTenHangSX(rs.getString("TenHangSanXuat"));
                ctsp.setIdHang(hsx);

                KhuyenMai km = new KhuyenMai();
                km.setTenKM(rs.getString("TenKM"));
                ctsp.setIdKM(km);

                list.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<ChiTietSanPham> getList(String loaiSP) {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
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
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));

                MauSac mau = new MauSac();
                mau.setMauSP(rs.getString(5));

                SizeSP sz = new SizeSP();
                sz.setSizeSP(rs.getString(4));

                HangSX hsx = new HangSX();
                hsx.setTenHangSX(rs.getString(6));

//                KhuyenMai km = new KhuyenMai();
//                km.setTenKM(rs.getString("TenKM"));
                ChiTietSanPham ct = new ChiTietSanPham();
                ct.setIdSP(sp);
                ct.setGiaBan(rs.getDouble(3));
                ct.setIdSize(sz);
                ct.setIdMauSac(mau);
                ct.setIdHang(hsx);
                list.add(ct);
            }
        } catch (Exception e) {
            System.out.println(e + "ff");
        }
        return list;
    }

    public Integer addSanPham(ChiTietSanPham ctsp) {
        Integer row = null;
        try {
            String sql = "INSERT INTO ChiTietSanPham (IdSP, IdLoaiSanPham, GiaBan, GiaNhap, HinhAnh, MoTa, SoLuong, IdMau, IdHang, IdSize, IdKM) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ctsp.getIdSP().getMaSP());
            pst.setString(2, ctsp.getIdSP().getTenSP());
            pst.setString(3, ctsp.getIdLoaiSP().getTenLoaiSP());
            pst.setDouble(4, ctsp.getGiaBan());
            pst.setDouble(5, ctsp.getGiaNhap());
            pst.setString(6, ctsp.getHinhAnh());
            pst.setString(7, ctsp.getMoTa());
            pst.setInt(8, ctsp.getSoluong());
            pst.setString(9, ctsp.getIdMauSac().getMauSP());
            pst.setString(10, ctsp.getIdHang().getTenHangSX());
            pst.setString(11, ctsp.getIdSize().getSizeSP());
            pst.setString(12, ctsp.getIdKM().getTenKM());
            pst.setBoolean(13, ctsp.getIdSP().isTrangThai());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return row;
    }
}
