/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhuyenMai {
//van2811
    private int IdKM;
    private String MaKM;
    private String TenKM;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private String DieuKien;
    private Double TienGiam;
    private String GhiChu;
    private boolean TrangThai;
    private SanPham IdSP;
    
    

    public KhuyenMai() {
    }
//van2811
    public KhuyenMai(int IdKM, String MaKM, String TenKM, Date NgayBatDau, Date NgayKetThuc, String DieuKien, Double TienGiam, String GhiChu, boolean TrangThai, SanPham IdSP) {
        this.IdKM = IdKM;
        this.MaKM = MaKM;
        this.TenKM = TenKM;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.DieuKien = DieuKien;
        this.TienGiam = TienGiam;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
        this.IdSP = IdSP;
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

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public SanPham getIdSP() {
        return IdSP;
    }

    public void setIdSP(SanPham IdSP) {
        this.IdSP = IdSP;
    }
    

}
