package SERVICE;
import MODEL.SizeSP;
import REPO.DBConnect;
import java.sql.*;
import java.util.ArrayList;
public class SizeService {
    public ArrayList<SizeSP>getAll(){
    ArrayList<SizeSP>list = new ArrayList<>();
        try {
            String sql ="SELECT MaSize,Size FROM SizeSP";
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                SizeSP size = new SizeSP();
                size.setMaSizeSP(rs.getString("MaSize"));
                size.setSizeSP(rs.getString("Size"));
                list.add(size);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    return list;
    }
}
