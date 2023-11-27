package MODEL;

public class SanPham {

    private int IdSP;
    private String MaSP;
    private String TenSP;
    private LoaiSanPham IdLoaiSP;
    private Double GiaBan;
    private Double GiaNhap;
    private String HinhAnh;
    private String MoTa;
    private int Soluong;
    private MauSac IdMauSac;
    private SizeSP IdSize;
    private HangSX IdHang;
    private KhuyenMai IdKM;
    private boolean TrangThai;

    public SanPham() {
    }

    public SanPham(int IdSP, String MaSP, String TenSP, LoaiSanPham IdLoaiSP, Double GiaBan, Double GiaNhap, String HinhAnh, String MoTa, int Soluong, MauSac IdMauSac, SizeSP IdSize, HangSX IdHang, KhuyenMai IdKM, boolean TrangThai) {
        this.IdSP = IdSP;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.IdLoaiSP = IdLoaiSP;
        this.GiaBan = GiaBan;
        this.GiaNhap = GiaNhap;
        this.HinhAnh = HinhAnh;
        this.MoTa = MoTa;
        this.Soluong = Soluong;
        this.IdMauSac = IdMauSac;
        this.IdSize = IdSize;
        this.IdHang = IdHang;
        this.IdKM = IdKM;
        this.TrangThai = TrangThai;
    }

    public int getIdSP() {
        return IdSP;
    }

    public void setIdSP(int IdSP) {
        this.IdSP = IdSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public LoaiSanPham getIdLoaiSP() {
        return IdLoaiSP;
    }

    public void setIdLoaiSP(LoaiSanPham IdLoaiSP) {
        this.IdLoaiSP = IdLoaiSP;
    }

    public Double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(Double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public MauSac getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(MauSac IdMauSac) {
        this.IdMauSac = IdMauSac;
    }

    public SizeSP getIdSize() {
        return IdSize;
    }

    public void setIdSize(SizeSP IdSize) {
        this.IdSize = IdSize;
    }

    public HangSX getIdHang() {
        return IdHang;
    }

    public void setIdHang(HangSX IdHang) {
        this.IdHang = IdHang;
    }

    public KhuyenMai getIdKM() {
        return IdKM;
    }

    public void setIdKM(KhuyenMai IdKM) {
        this.IdKM = IdKM;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
