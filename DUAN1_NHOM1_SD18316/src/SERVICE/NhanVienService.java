package SERVICE;

import MODEL.NhanVien;
import REPO.DBConnect;
import REPO.NhanVienInterface;
import java.sql.*;
import java.util.ArrayList;

public class NhanVienService implements NhanVienInterface {

    @Override
    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql = "SELECT IdNV,MaNV,HoTen,GioiTinh,Sdt,NgaySinh, DiaChi, Email, ChucVu,TrangThai, MatKhau FROM NhanVien";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setID(rs.getInt("IdNV"));
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

    @Override
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
            String sql = "UPDATE NhanVien SET MaNV = ?, HoTen = ?, GioiTinh = ?, Sdt = ?, NgaySinh = ?, DiaChi = ?, Email = ?, ChucVu = ?, TrangThai = ?, MatKhau = ? WHERE IdNV=? ";
            Connection cn = DBConnect.getConnection();
//            System.out.println("SQL Statement: " + sql); 
//             System.out.println("ID before update: " + nv.getID());
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
            pst.setInt(11, nv.getID());
            cn.commit();
            row = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error updating NhanVien: " + e.getMessage());
        }
        return row;
    }
}
