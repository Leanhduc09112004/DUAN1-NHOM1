package MODEL;
import java.util.Date;
public class KhuyenMai {
    private int IdKM;
    private String MaKM;
    private String TenKM;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private  String DieuKien;
    private Double TienGiam;
    private Boolean TrangThai;
    private String GhiChu;

    public KhuyenMai() {
    }

    public KhuyenMai(int IdKM, String MaKM, String TenKM, Date NgayBatDau, Date NgayKetThuc, String DieuKien, Double TienGiam, Boolean TrangThai, String GhiChu) {
        this.IdKM = IdKM;
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.DieuKien = DieuKien;
        this.TienGiam = TienGiam;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public int getIdKM() {
        return IdKM;
    }

    public void setIdKM(int IdKM) {
        this.IdKM = IdKM;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
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

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
}
