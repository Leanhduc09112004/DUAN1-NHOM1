package SERVICE;

import MODEL.HoaDon;
import REPO.DBConnect;
import java.util.ArrayList;
import java.sql.*;

public class HoaDonService {
//public ArrayList<HoaDon> getAll( String ma) {
//        ArrayList<HoaDon> listHD = new ArrayList<>();
//        String sql = "SELECT * from HoaDon";
//        try {
//            Connection cn = DBConnect.getConnection();
//            PreparedStatement ps = cn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                HoaDon hd = new HoaDon(
//                        rs.getInt(1)
//                        rs.getString(2),
//                        rs.getDate(3),
//                        rs.getDate(4),
//                        rs.getFloat(5),
//                        rs.getFloat(6),
//                        rs.getFloat(7),
//                        rs.getFloat(8),
//                        rs.getBoolean(9),
//                        rs.getString(10),
//                        rs.getInt(11),
//                        rs.getInt(12)        
//                );
//                listHD.add(hd);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return listHD;
//    }
public Integer addHD(HoaDon hd) {
        Integer row = null;
        String sql = "INSERT INTO HoaDon (MaHD, NgayTao, NgayThanhToan, TongTien, TienGiam, TienDua, TongThua,TrangThai,GhiChu)\n"
                + "VALUES (?, ?, ?,?, ?, ?, ?,?,?)";
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setDate(2, new java.sql.Date(hd.getNgayTao().getTime()));
            ps.setDate(3, new java.sql.Date(hd.getNgayThanhToan().getTime()));
            ps.setFloat(4, hd.getTongTien());
            ps.setFloat(5, hd.getTienGiam());
            ps.setFloat(6, hd.getTienDua());
            ps.setFloat(7, hd.getTongThua());
            ps.setBoolean(8, hd.isTrangThai());
            ps.setString(9, hd.getGhiChu());
            row = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi: " + e);
        }
        return row;
    }
   }

