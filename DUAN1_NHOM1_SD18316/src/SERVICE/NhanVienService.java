package SERVICE;

import MODEL.NhanVien;
import REPO.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

public class NhanVienService {

    String SQL_SELECT_BY_Ma = "SELECT HoTen, GioiTinh, Sdt, NgaySinh, DiaChi, Email, ChucVu, TrangThai, MatKhau\n"
            + "FROM NhanVien\n"
            + "where MaNV = ?";
    
    public NhanVien selectByMa(String ma){
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement pm = cn.prepareStatement(SQL_SELECT_BY_Ma);
            pm.setString(1, ma);
            ResultSet rs = pm.executeQuery();
            NhanVien nv = null;
            while(rs.next()){
                String hoTen = rs.getString(1);
                String gtinh = rs.getString(2);
                String sdt = rs.getString(3);
                Date ngSinh = rs.getDate(4);
                String dchi = rs.getString(5);
                String email = rs.getString(6);
                boolean chucVu = rs.getBoolean(7);
                Boolean trangThai = rs.getBoolean(8);
                String pass = rs.getString(9);
                nv = new NhanVien(ma, hoTen, gtinh, sdt, ngSinh, 
                        dchi, email, chucVu, trangThai, pass);
                return nv;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
            
}
