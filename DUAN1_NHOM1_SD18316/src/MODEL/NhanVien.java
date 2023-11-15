package MODEL;

import java.util.Date;

public class NhanVien {

    private int ID;
    private String MaNV;
    private String HoTen;
    private String GioiTinh;
    private String SĐT;
    private Date NgaySinh;
    private String DiaChi;
    private String Email;
    private String ChucVu;
    private Boolean TrangThai;   
    private String MatKhau;

    public NhanVien() {
    }

    public NhanVien(int ID, String MaNV, String HoTen, String GioiTinh, String SĐT, Date NgaySinh, String DiaChi, String Email, String ChucVu, Boolean TrangThai, String MatKhau) {
        this.ID = ID;
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.SĐT = SĐT;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
        this.MatKhau = MatKhau;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSĐT() {
        return SĐT;
    }

    public void setSĐT(String SĐT) {
        this.SĐT = SĐT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "ID=" + ID + ", MaNV=" + MaNV + ", HoTen=" + HoTen + ", GioiTinh=" + GioiTinh + ", S\u0110T=" + SĐT + ", NgaySinh=" + NgaySinh + ", DiaChi=" + DiaChi + ", Email=" + Email + ", ChucVu=" + ChucVu + ", TrangThai=" + TrangThai + ", MatKhau=" + MatKhau + '}';
    }
    
}
