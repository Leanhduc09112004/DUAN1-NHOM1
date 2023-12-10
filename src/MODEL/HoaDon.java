package MODEL;
import java.util.Date;
public class HoaDon {
      
    private int idHD;
    private String maHD;
    private Date ngayTao;
    private Date ngayThanhToan;
    private float tongTien;
    private float tienGiam;
    private float tienDua;
    private float tongThua;
    private boolean trangThai;
    private String ghiChu;
    private int idNV;
    private int idKH;
    private String hinhThucTT;

    public HoaDon() {
    }

    public HoaDon(int idHD, String maHD, Date ngayTao, Date ngayThanhToan, float tongTien, float tienGiam, float tienDua, float tongThua, boolean trangThai, String ghiChu, int idNV, int idKH, String hinhThucTT) {
        this.idHD = idHD;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.tienGiam = tienGiam;
        this.tienDua = tienDua;
        this.tongThua = tongThua;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.idNV = idNV;
        this.idKH = idKH;
        this.hinhThucTT = hinhThucTT;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getTienGiam() {
        return tienGiam;
    }

    public void setTienGiam(float tienGiam) {
        this.tienGiam = tienGiam;
    }

    public float getTienDua() {
        return tienDua;
    }

    public void setTienDua(float tienDua) {
        this.tienDua = tienDua;
    }

    public float getTongThua() {
        return tongThua;
    }

    public void setTongThua(float tongThua) {
        this.tongThua = tongThua;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public String getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(String hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }
  
}
