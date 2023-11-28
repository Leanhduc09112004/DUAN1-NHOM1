package SERVICE;

import MODEL.NhanVien;
import REPO.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class NhanVienService {

    String SQL_SELECT_BY_Ma = "SELECT HoTen, GioiTinh, Sdt, NgaySinh, DiaChi, Email, ChucVu, TrangThai, MatKhau\n"
            + "FROM NhanVien\n"
            + "where MaNV = ?";

    public NhanVien selectByMa(String ma) {
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement pm = cn.prepareStatement(SQL_SELECT_BY_Ma);
            pm.setString(1, ma);
            ResultSet rs = pm.executeQuery();
            NhanVien nv = null;
            while (rs.next()) {
                String hoTen = rs.getString(1);
                Boolean gtinh = rs.getBoolean(2);
                String sdt = rs.getString(3);
                Date ngSinh = rs.getDate(4);
                String dchi = rs.getString(5);
                String email = rs.getString(6);
                Boolean chucVu = rs.getBoolean(7);
                Boolean trangThai = rs.getBoolean(8);
                String pass = rs.getString(9);
                nv = new NhanVien(ma, hoTen, gtinh, sdt, ngSinh, dchi, email, chucVu, trangThai, pass);
                return nv;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT MaNV,HoTen,GioiTinh,Sdt,NgaySinh, DiaChi, Email, ChucVu,TrangThai, MatKhau FROM NhanVien";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSĐT(rs.getString("Sdt"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setChucVu(rs.getBoolean("ChucVu"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                nv.setMatKhau(rs.getString("MatKhau"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

    public Integer addNhanVien(NhanVien nv) {
        Integer row = null;
        try {
            String sql = " INSERT INTO NhanVien (MaNV, HoTen, GioiTinh, Sdt, NgaySinh, DiaChi, Email, ChucVu, TrangThai, MatKhau)VALUES(?,?,?,?,?,?,?,?,?,?)";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nv.getMaNV());
            pst.setString(2, nv.getHoTen());
            pst.setBoolean(3, nv.getGioiTinh());
            pst.setString(4, nv.getSĐT());
            pst.setDate(5, new java.sql.Date(nv.getNgaySinh().getTime()));
            pst.setString(6, nv.getDiaChi());
            pst.setString(7, nv.getEmail());
            pst.setBoolean(8, nv.getChucVu());
            pst.setBoolean(9, nv.getTrangThai());
            pst.setString(10, nv.getMatKhau());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return row;
    }

    public Integer updateNhanVien(NhanVien nv) {
        Integer row = null;
        try {
            String sql = "UPDATE NhanVien SET HoTen = ?, GioiTinh = ?, Sdt = ?, NgaySinh = ?, DiaChi = ?, Email = ?, ChucVu = ?, TrangThai = ?, MatKhau = ? WHERE MaNV=? ";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nv.getHoTen());
            pst.setBoolean(2, nv.getGioiTinh());
            pst.setString(3, nv.getSĐT());
            pst.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
            pst.setString(5, nv.getDiaChi());
            pst.setString(6, nv.getEmail());
            pst.setBoolean(7, nv.getChucVu());
            pst.setBoolean(8, nv.getTrangThai());
            pst.setString(9, nv.getMatKhau());
            pst.setString(10, nv.getMaNV());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating NhanVien: " + e.getMessage());
        }
        return row;
    }

    public ArrayList<NhanVien> timKiemNhanVien(String maNV, String tenNV) {
        ArrayList<NhanVien> ketQuaTimKiem = new ArrayList<>();
        try {
            String sql = "SELECT MaNV, HoTen, GioiTinh, Sdt, NgaySinh, DiaChi, Email, ChucVu, TrangThai, MatKhau FROM NhanVien WHERE MaNV = ? AND HoTen LIKE ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, maNV); // Tìm tuyệt đối cho mã nhân viên
            pst.setString(2, "%" + tenNV + "%"); // Tìm tương đối cho tên nhân viên

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSĐT(rs.getString("Sdt"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setChucVu(rs.getBoolean("ChucVu"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                nv.setMatKhau(rs.getString("MatKhau"));
                ketQuaTimKiem.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return ketQuaTimKiem;
    }

    public ArrayList<NhanVien> timKiemNhanVienTheoDieuKien(boolean trangThai, boolean chucVu) {
        ArrayList<NhanVien> ketQuaTimKiem = new ArrayList<>();
        try {
            String sql = "SELECT MaNV, HoTen, GioiTinh, Sdt, NgaySinh, DiaChi, Email, ChucVu, TrangThai, MatKhau FROM NhanVien WHERE TrangThai = ? AND ChucVu = ?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setBoolean(1, trangThai);
            pst.setBoolean(2, chucVu);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setSĐT(rs.getString("Sdt"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setChucVu(rs.getBoolean("ChucVu"));
                nv.setTrangThai(rs.getBoolean("TrangThai"));
                nv.setMatKhau(rs.getString("MatKhau"));
                ketQuaTimKiem.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return ketQuaTimKiem;
    }

    public Integer updateTrangThai(NhanVien nv) {
        Integer row = null;
        try {
            String sql = "UPDATE NhanVien SET TrangThai=? WHERE MaNV=?";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setBoolean(1, nv.getTrangThai());
            pst.setString(2, nv.getMaNV());
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return row;
    }
}
