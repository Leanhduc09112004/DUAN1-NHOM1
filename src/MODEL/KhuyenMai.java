package MODEL;
import java.util.Date;
public class KhuyenMai {
    private int IdKM;
    private String TenKM;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private  String DieuKien;
    private Double TienGiam;
    private Boolean TrangThai;
    private SanPham IdSp;

    public KhuyenMai() {
    }

    public KhuyenMai(int IdKM, String TenKM, Date NgayBatDau, Date NgayKetThuc, String DieuKien, Double TienGiam, Boolean TrangThai, SanPham IdSp) {
        this.IdKM = IdKM;
        this.TenKM = TenKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.DieuKien = DieuKien;
        this.TienGiam = TienGiam;
        this.TrangThai = TrangThai;
        this.IdSp = IdSp;
    }

    public int getIdKM() {
        return IdKM;
    }

    public void setIdKM(int IdKM) {
        this.IdKM = IdKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(String DieuKien) {
        this.DieuKien = DieuKien;
    }

    public Double getTienGiam() {
        return TienGiam;
    }

    public void setTienGiam(Double TienGiam) {
        this.TienGiam = TienGiam;
    }

    public Boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public SanPham getIdSp() {
        return IdSp;
    }

    public void setIdSp(SanPham IdSp) {
        this.IdSp = IdSp;
    }
    
}
