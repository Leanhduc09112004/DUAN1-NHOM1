/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import MODEL.KhuyenMai;

/**
 *
 * @author DELL
 */
public class ChiTietSanPham {
    private int idCTSP;
    private SanPham idSP;
    private LoaiSanPham idLoai;
    private Double giaBan;
    private Double giaNhap;
    private String hinhAnh;
    private String moTa;
    private int soLuong;
    private NhanVien idNV;
    private MauSac idMau;
    private HangSX idHang;
    private SizeSP idSize;
    private KhuyenMai idKM;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int idCTSP, SanPham idSP, LoaiSanPham idLoa, Double giaBan, Double giaNhap, String hinhAnh, String moTa, int soLuong, NhanVien idNV, MauSac idMau, HangSX idHang, SizeSP idSize, KhuyenMai idKM) {
        this.idCTSP = idCTSP;
        this.idSP = idSP;
        this.idLoai = idLoa;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.hinhAnh = hinhAnh;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.idNV = idNV;
        this.idMau = idMau;
        this.idHang = idHang;
        this.idSize = idSize;
        this.idKM = idKM;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public LoaiSanPham getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(LoaiSanPham idLoai) {
        this.idLoai = idLoai;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public MauSac getIdMau() {
        return idMau;
    }

    public void setIdMau(MauSac idMau) {
        this.idMau = idMau;
    }

    public HangSX getIdHang() {
        return idHang;
    }

    public void setIdHang(HangSX idHang) {
        this.idHang = idHang;
    }

    public SizeSP getIdSize() {
        return idSize;
    }

    public void setIdSize(SizeSP idSize) {
        this.idSize = idSize;
    }

    public KhuyenMai getIdKM() {
        return idKM;
    }

    public void setIdKM(KhuyenMai idKM) {
        this.idKM = idKM;
    }

//    public void setIdLoaiSP(LoaiSanPham lsp) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public void setSoluong(int aInt) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public void setIdMauSac(SERVICE.MauSac mau) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    

}
