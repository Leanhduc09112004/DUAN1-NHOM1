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

    public ArrayList<KhachHang> getAllTT(String ten, String ma) {
        ArrayList<KhachHang> listTT = new ArrayList<>();
        String sql = "SELECT DISTINCT KhachHang.MaKH, KhachHang.HoTen, KhachHang.GioiTinh, KhachHang.NgaySinh, KhachHang.DiaChi, KhachHang.Sdt, KhachHang.Email, HoaDon.TrangThai FROM KhachHang JOIN HoaDon ON KhachHang.IdKH = HoaDon.IdKH WHERE KhachHang.HoTen LIKE ? OR KhachHang.MaKH LIKE ?";

        try (Connection cn = DBConnect.getConnection(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, "%" + ten + "%");
            pst.setString(2, "%" + ma + "%");

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setHoTen(rs.getString("HoTen"));
                    kh.setGtinh(rs.getBoolean("GioiTinh"));
                    kh.setNgSinh(rs.getDate("NgaySinh"));
                    kh.setDchi(rs.getString("DiaChi"));
                    kh.setSdt(rs.getString("Sdt"));
                    kh.setEmail(rs.getString("Email"));

                    HoaDon hd = new HoaDon();
                    hd.setTrangThai(rs.getBoolean("TrangThai"));
                    kh.setIdHD(hd);

                    listTT.add(kh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTT;
    }

    public Integer addTTKhachHang(KhachHang kh) {
        Integer result = null;
        String insertKhachHangSQL = "INSERT INTO KhachHang (MaKH, HoTen, GioiTinh, NgaySinh, DiaChi, Sdt, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String insertHoaDonSQL = "INSERT INTO HoaDon (TrangThai, IdKH) VALUES (?, ?)";

        try (Connection cn = DBConnect.getConnection(); PreparedStatement pstKhachHang = cn.prepareStatement(insertKhachHangSQL, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstHoaDon = cn.prepareStatement(insertHoaDonSQL)) {

            pstKhachHang.setString(1, kh.getMaKH());
            pstKhachHang.setString(2, kh.getHoTen());
            pstKhachHang.setBoolean(3, kh.isGtinh());
            pstKhachHang.setDate(4, new java.sql.Date(kh.getNgSinh().getTime()));
            pstKhachHang.setString(5, kh.getDchi());
            pstKhachHang.setString(6, kh.getSdt());
            pstKhachHang.setString(7, kh.getEmail());

            int affectedRows = pstKhachHang.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = pstKhachHang.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idKhachHang = generatedKeys.getInt(1);

                    pstHoaDon.setBoolean(1, kh.getIdHD().isTrangThai());
                    pstHoaDon.setInt(2, idKhachHang);

                    int affectedRowsHoaDon = pstHoaDon.executeUpdate();
                    if (affectedRowsHoaDon > 0) {
                        result = idKhachHang;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<KhachHang> searchKhachHang(String ten, String ma) {
        ArrayList<KhachHang> listTT = new ArrayList<>();
        String sql = "SELECT DISTINCT KhachHang.MaKH, KhachHang.HoTen, KhachHang.GioiTinh, KhachHang.NgaySinh, KhachHang.DiaChi, KhachHang.Sdt, KhachHang.Email, HoaDon.TrangThai FROM KhachHang JOIN HoaDon ON KhachHang.IdKH = HoaDon.IdKH WHERE KhachHang.HoTen LIKE ? OR KhachHang.MaKH = ?";

        try (Connection cn = DBConnect.getConnection(); PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, "%" + ten + "%");
            pst.setString(2, ma);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    KhachHang kh = new KhachHang();
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setHoTen(rs.getString("HoTen"));
                    kh.setGtinh(rs.getBoolean("GioiTinh"));
                    kh.setNgSinh(rs.getDate("NgaySinh"));
                    kh.setDchi(rs.getString("DiaChi"));
                    kh.setSdt(rs.getString("Sdt"));
                    kh.setEmail(rs.getString("Email"));

                    HoaDon hd = new HoaDon();
                    hd.setTrangThai(rs.getBoolean("TrangThai"));
                    kh.setIdHD(hd);

                    listTT.add(kh);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTT;
    }

    public Integer updateTTKhachHang(KhachHang kh) {
        Integer result = null;
        String updateKhachHangSQL = "UPDATE KhachHang SET HoTen=?, GioiTinh=?, NgaySinh=?, DiaChi=?, Sdt=?, Email=? WHERE MaKH=?";
        String updateHoaDonSQL = "UPDATE HoaDon SET TrangThai=? WHERE IdKH=?";

        try (Connection cn = DBConnect.getConnection(); PreparedStatement pstKhachHang = cn.prepareStatement(updateKhachHangSQL); PreparedStatement pstHoaDon = cn.prepareStatement(updateHoaDonSQL)) {

            // Cập nhật thông tin khách hàng
            pstKhachHang.setString(1, kh.getHoTen());
            pstKhachHang.setBoolean(2, kh.isGtinh());
            pstKhachHang.setDate(3, new java.sql.Date(kh.getNgSinh().getTime()));
            pstKhachHang.setString(4, kh.getDchi());
            pstKhachHang.setString(5, kh.getSdt());
            pstKhachHang.setString(6, kh.getEmail());
            pstKhachHang.setString(7, kh.getMaKH());

            int affectedRowsKhachHang = pstKhachHang.executeUpdate();
            if (affectedRowsKhachHang > 0) {
                // Cập nhật thông tin hóa đơn
                pstHoaDon.setBoolean(1, kh.getIdHD().isTrangThai());
                pstHoaDon.setInt(2, getIdKHByMaKH(kh.getMaKH()));

                int affectedRowsHoaDon = pstHoaDon.executeUpdate();
                if (affectedRowsHoaDon > 0) {
                    result = getIdKHByMaKH(kh.getMaKH()); 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private int getIdKHByMaKH(String maKH) {
        int idKH = -1; 

        String sql = "SELECT IdKH FROM KhachHang WHERE MaKH = ?";

        try (Connection cn = DBConnect.getConnection(); PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, maKH);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    idKH = rs.getInt("IdKH");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idKH;
    }
}
