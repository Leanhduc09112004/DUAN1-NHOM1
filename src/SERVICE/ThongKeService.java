package SERVICE;

import MODEL.HoaDon;
import MODEL.LoaiSanPham;
import MODEL.SanPham;
import MODEL.ThongKe;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.*;

public class ThongKeService {

    public Integer getTongDoanhThu(Date start, Date end) {
        try {
            String sql = "SELECT SUM(TongTien-TienGiam)\n"
                    + "FROM HoaDon\n"
                    + "WHERE NgayThanhToan >= ? AND NgayThanhToan<= ? AND TrangThai = 1";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, start);
            ps.setDate(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Integer getTongHoaDon(Date start, Date end) {
        try {
            String sql = "SELECT COUNT(HoaDon.MaHD) AS TongHD\n"
                    + "FROM HoaDon\n"
                    + "WHERE NgayThanhToan >= ? AND NgayThanhToan<= ? AND TrangThai = 1";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, start);
            ps.setDate(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e + "hj");
        }
        return 0;
    }

    public Integer getTongSanPham(Date start, Date end) {
        try {
            String sql = "SELECT SUM(HoaDonChiTiet.SoLuong) AS TongSL\n"
                    + "FROM HoaDonChiTiet join HoaDon on HoaDon.IdHD = HoaDonChiTiet.IdHD\n"
                    + "where NgayThanhToan >= ? and NgayThanhToan <= ? AND TrangThai = 1";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, start);
            ps.setDate(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<ThongKe> getSP(String tenLoaiSP) {
        ArrayList<ThongKe> list = new ArrayList<>();
        try {
            String sql = "SELECT B.TenLoaiSanPham,A.MaSP, A.TenSP, A.GiaBan, SUM(C.DonGia*C.SoLuong) AS TongDT, SUM(C.SoLuong) AS TongSL\n"
                    + "FROM SanPham A JOIN LoaiSanPham B ON A.IdLoaiSanPham = B.IdLoaiSanPham\n"
                    + "				JOIN HoaDonChiTiet C ON C.IdSP = A.IdSP\n"
                    + "				JOIN HoaDon D ON D.IdHD= C.IdHD\n"
                    + "WHERE B.TenLoaiSanPham LIKE ?\n"
                    + "GROUP BY B.TenLoaiSanPham,A.MaSP, A.TenSP, A.GiaBan";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + tenLoaiSP + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe d = new ThongKe();

                LoaiSanPham s = new LoaiSanPham();
                s.setTenLoaiSP(rs.getString(1));

                SanPham p = new SanPham();
                p.setMaSP(rs.getString(2));
                p.setTenSP(rs.getString(3));
                p.setGiaBan(rs.getDouble(4));

                d.setTenLoaiSP(s);
                d.setMaSP(p);
                d.setTenSP(p);
                d.setGiaBan(p);

                d.setTongDTSP(rs.getInt(5));
                d.setTongSP(rs.getInt(6));
                list.add(d);

            }
        } catch (Exception e) {
            System.out.println(e + "hj");
        }
        return list;
    }

    public ArrayList<ThongKe> getSP2(String tenLoaiSP, Date start, Date end) {
        ArrayList<ThongKe> list = new ArrayList<>();
        try {
            String sql = "SELECT B.TenLoaiSanPham,A.MaSP, A.TenSP, A.GiaBan, SUM(C.DonGia*C.SoLuong) AS TongDT, SUM(C.SoLuong) AS TongSL\n"
                    + "FROM SanPham A JOIN LoaiSanPham B ON A.IdLoaiSanPham = B.IdLoaiSanPham\n"
                    + "				JOIN HoaDonChiTiet C ON C.IdSP = A.IdSP\n"
                    + "				JOIN HoaDon D ON D.IdHD= C.IdHD\n"
                    + "WHERE B.TenLoaiSanPham LIKE ? AND \n"
                    + "	D.NgayThanhToan >= ? and NgayThanhToan <= ?\n"
                    + "	AND D.TrangThai = 1\n"
                    + "GROUP BY B.TenLoaiSanPham,A.MaSP, A.TenSP, A.GiaBan";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + tenLoaiSP + "%");
            ps.setDate(2, start);
            ps.setDate(3, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe d = new ThongKe();

                LoaiSanPham s = new LoaiSanPham();
                s.setTenLoaiSP(rs.getString(1));

                SanPham p = new SanPham();
                p.setMaSP(rs.getString(2));
                p.setTenSP(rs.getString(3));
                p.setGiaBan(rs.getDouble(4));

                d.setTenLoaiSP(s);
                d.setMaSP(p);
                d.setTenSP(p);
                d.setGiaBan(p);

                d.setTongDTSP(rs.getInt(5));
                d.setTongSP(rs.getInt(6));
                list.add(d);

            }
        } catch (Exception e) {
            System.out.println(e + "hj");
        }
        return list;
    }

    public ArrayList<ThongKe> getDoanhThu1(Date start, Date end) {
        ArrayList<ThongKe> list = new ArrayList<>();
        try {
            String sql = "SELECT NgayThanhToan, SUM(TongTien-TienGiam) AS TongDT\n"
                    + "FROM HoaDon\n"
                    + "WHERE NgayThanhToan >= ? and NgayThanhToan <= ? AND TrangThai = 1\n"
                    + "GROUP BY NgayThanhToan";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, start);
            ps.setDate(2, end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe d = new ThongKe();
                d.setNgayThanhToan(rs.getDate(1));
                d.setTongDT(rs.getDouble(2));
                list.add(d);
            }
        } catch (Exception e) {
            System.out.println(e + "Loi tinh dt");
        }
        return list;
    }

    public ArrayList<ThongKe> getDoanhThu2(int month) {
        ArrayList<ThongKe> list = new ArrayList<>();
        try {
            String sql = "SELECT NgayThanhToan, SUM(TongTien-TienGiam) AS TongDT\n"
                    + "FROM HoaDon\n"
                    + "WHERE MONTH(NgayThanhToan) = ? and YEAR(NgayThanhToan) = YEAR(GETDATE()) AND TrangThai = 1\n"
                    + "GROUP BY NgayThanhToan";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe d = new ThongKe();
                d.setNgayThanhToan(rs.getDate(1));
                d.setTongDT(rs.getDouble(2));
                list.add(d);
            }
        } catch (Exception e) {
            System.out.println(e + "Loi tinh dt");
        }
        return list;
    }

    public ArrayList<ThongKe> getDoanhThu3(int year) {
        ArrayList<ThongKe> list = new ArrayList<>();
        try {
            String sql = "SELECT SUM(TongTien-TienGiam) AS TongDT, MONTH(NgayThanhToan)\n"
                    + "FROM HoaDon\n"
                    + "WHERE YEAR(NgayThanhToan) = ? AND TrangThai = 1\n"
                    + "GROUP BY MONTH(NgayThanhToan)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe d = new ThongKe();
                d.setTongDT(rs.getDouble(1));
                d.setThangThanhToan(rs.getInt(2));

                list.add(d);
            }
        } catch (Exception e) {
            System.out.println(e + "Loi tinh dt");
        }
        return list;
    }
}
