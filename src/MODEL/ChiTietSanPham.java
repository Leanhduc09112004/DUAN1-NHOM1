package MODEL;
public class ChiTietSanPham {
  private SanPham idSP;
    private LoaiSanPham idLoaiSP;
    private Double GiaBan;
    private Double GiaNhap;
    private String HinhAnh;
    private String MoTa;
    private int Soluong;
    private MauSac IdMauSac;
    private SizeSP IdSize;
    private HangSX IdHang;
    private KhuyenMai IdKM;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(SanPham idSP, LoaiSanPham idLoaiSP, Double GiaBan, Double GiaNhap, String HinhAnh, String MoTa, int Soluong, MauSac IdMauSac, SizeSP IdSize, HangSX IdHang, KhuyenMai IdKM) {
        this.idSP = idSP;
        this.idLoaiSP = idLoaiSP;
        this.GiaBan = GiaBan;
        this.GiaNhap = GiaNhap;
        this.HinhAnh = HinhAnh;
        this.MoTa = MoTa;
        this.Soluong = Soluong;
        this.IdMauSac = IdMauSac;
        this.IdSize = IdSize;
        this.IdHang = IdHang;
        this.IdKM = IdKM;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public LoaiSanPham getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(LoaiSanPham idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
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
}
