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
}
