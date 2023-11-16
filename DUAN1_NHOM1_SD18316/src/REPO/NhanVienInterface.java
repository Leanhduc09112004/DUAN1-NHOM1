package REPO;

import MODEL.NhanVien;
import java.util.ArrayList;

public interface NhanVienInterface {
    public ArrayList<NhanVien> getAll();
    public Integer addNhanVien(NhanVien nv);
    public Integer updateNhanVien(NhanVien nv);
}
