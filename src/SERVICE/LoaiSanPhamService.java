package SERVICE;
import MODEL.LoaiSanPham;
import REPO.DBConnect;
import java.sql.*;
import java.util.ArrayList;
public class LoaiSanPhamService {
    public ArrayList<LoaiSanPham>getAll(){
    ArrayList<LoaiSanPham> list = new ArrayList<>();
        try {
        String sql = "SELECT MaLoaiSanPham, TenLoaiSanPham FROM LoaiSanPham";
        Connection cn = DBConnect.getConnection();
        PreparedStatement pst = cn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                LoaiSanPham lsp = new LoaiSanPham();
                lsp.setMaLoaiSP(rs.getString("MaLoaiSanPham"));
                lsp.setTenLoaiSP(rs.getString("TenLoaiSanPham"));
                list.add(lsp);
            }
        } catch (Exception e) {
        e.printStackTrace();
        System.out.println(e);
        }
    return list;
    }
}
