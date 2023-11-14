package SERVICE;
import MODEL.NhanVien;
import REPO.DBConnect;
import REPO.NhanVienInterface;
import java.sql.*;
import java.util.ArrayList;
public class NhanVienService implements NhanVienInterface{
    @Override
    public ArrayList<NhanVien>getAll(){
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String sql ="SELECT * FROM NhanVien";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setID(rs.getInt("IdNV"));
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setSĐT(rs.getString("Sdt"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setChucVu(rs.getString("ChucVu"));
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
}
