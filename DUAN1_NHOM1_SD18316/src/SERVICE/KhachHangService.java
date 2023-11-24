package SERVICE;

import MODEL.HoaDon;
import MODEL.KhachHang;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.*;

public class KhachHangService {

    public ArrayList<KhachHang> getAll(String ten, String ma) {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MaKH, HoTen, GioiTinh, NgaySinh, DiaChi, Sdt, Email\n"
                + "FROM KhachHang\n"
                + "WHERE HoTen LIKE ? OR MaKH LIKE ?";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(7),
                        rs.getString(6),
                        rs.getBoolean(3),
                        rs.getDate(4),
                        rs.getString(5)
                );
                list.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<HoaDon> getHD(String ma) {
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql = "SELECT HoaDon.MaHD, HoaDon.NgayThanhToan, HoaDon.TongTien, HoaDon.TrangThai\n"
                + "FROM KhachHang JOIN HoaDon ON KhachHang.IdKH = HoaDon.IdKH\n"
                + "WHERE KhachHang.MaKH LIKE ?";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + ma + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();      
                hd.setMaHD(rs.getString(1));
                hd.setNgayThanhToan(rs.getDate(2));
                hd.setTongTien(rs.getFloat(3));
                hd.setTrangThai(rs.getBoolean(4));
                list.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Integer addKH(KhachHang k) {
        Integer row = null;
        String sql = "INSERT INTO KhachHang (MaKH, HoTen, Email, Sdt, GioiTinh, NgaySinh, DiaChi)\n"
                + "VALUES (?, ?, ?,?, ?, ?, ?)";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, k.getMaKH());
            ps.setString(2, k.getHoTen());
            ps.setString(3, k.getEmail());
            ps.setString(4, k.getSdt());
            ps.setBoolean(5, k.isGtinh());
            ps.setDate(6, new java.sql.Date(k.getNgSinh().getTime()));
            ps.setString(7, k.getDchi());
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }
        return row;
    }

    public Integer updateKH(KhachHang k) {
        Integer row = null;
        String sql = "UPDATE KhachHang \n"
                + "SET HoTen = ?, Email=?, Sdt=?, GioiTinh=?, NgaySinh=?, DiaChi=?\n"
                + "WHERE MaKH = ?";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(7, k.getMaKH());
            ps.setString(1, k.getHoTen());
            ps.setString(2, k.getEmail());
            ps.setString(3, k.getSdt());
            ps.setBoolean(4, k.isGtinh());
            ps.setDate(5, new java.sql.Date(k.getNgSinh().getTime()));
            ps.setString(6, k.getDchi());
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }
        return row;
    }
}
