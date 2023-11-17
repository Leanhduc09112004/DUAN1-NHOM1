/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class NhanVien {

    private int id;
    private String maNV;
    private String hoTen;
    private String gioiTinh;
    private String sdt;
    private Date NgaySinh;
    private String DiaChi;
    private String Email;
    private Boolean ChucVu;
    private Boolean TrangThai;
    private String MatKhau;

    public NhanVien() {
    }

    public NhanVien(int id, String maNV, String hoTen, String gioiTinh, String sdt, Date NgaySinh, String DiaChi, String Email, Boolean ChucVu, Boolean TrangThai, String MatKhau) {
        this.id = id;
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
        this.MatKhau = MatKhau;
    }

    public NhanVien(String maNV, String hoTen, String gioiTinh, String sdt, Date NgaySinh, String DiaChi, String Email, Boolean ChucVu, Boolean TrangThai, String MatKhau) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.ChucVu = ChucVu;
        this.TrangThai = TrangThai;
        this.MatKhau = MatKhau;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public Boolean getChucVu() {
        return ChucVu;
    }

    public void setChucVu(Boolean ChucVu) {
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
    
    
}
