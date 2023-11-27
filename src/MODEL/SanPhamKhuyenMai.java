package MODEL;

public class SanPhamKhuyenMai {

    private String maSP;
    private String tenSP;
    private SanPham giaBan;
    private SanPham giaNhap;
    private MauSac mau;
    private HangSX hang;
    private SizeSP size;
    private KhuyenMai maKM;

    public SanPhamKhuyenMai() {
    }

    public SanPhamKhuyenMai(String maSP, String tenSP, SanPham giaBan, SanPham giaNhap, MauSac mau, HangSX hang, SizeSP size, KhuyenMai maKM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.mau = mau;
        this.hang = hang;
        this.size = size;
        this.maKM = maKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public SanPham getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(SanPham giaBan) {
        this.giaBan = giaBan;
    }

    public SanPham getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(SanPham giaNhap) {
        this.giaNhap = giaNhap;
    }

    public MauSac getMau() {
        return mau;
    }

    public void setMau(MauSac mau) {
        this.mau = mau;
    }

    public HangSX getHang() {
        return hang;
    }

    public void setHang(HangSX hang) {
        this.hang = hang;
    }

    public SizeSP getSize() {
        return size;
    }

    public void setSize(SizeSP size) {
        this.size = size;
    }

    public KhuyenMai getMaKM() {
        return maKM;
    }

    public void setMaKM(KhuyenMai maKM) {
        this.maKM = maKM;
    }
}
