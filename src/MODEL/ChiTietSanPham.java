package MODEL;
public class ChiTietSanPham {
    private int idctsp;
    private SanPham idSP;
    private int idLoaiSanPham;
    private float giaBan;
    private float giaNhap;
    private String anh;
    private String mota;
    private int soLuong;
    private NhanVien nv;
    private HangSX hang;
    private MauSac mau;
    private SizeSP size;
    //LE DUC ANH
    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int idctsp, SanPham idSP, int idLoaiSanPham, float giaBan, float giaNhap, String anh, String mota, int soLuong, NhanVien nv, HangSX hang, MauSac mau, SizeSP size) {
        this.idctsp = idctsp;
        this.idSP = idSP;
        this.idLoaiSanPham = idLoaiSanPham;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.anh = anh;
        this.mota = mota;
        this.soLuong = soLuong;
        this.nv = nv;
        this.hang = hang;
        this.mau = mau;
        this.size = size;
    }

    public int getIdctsp() {
        return idctsp;
    }

    public void setIdctsp(int idctsp) {
        this.idctsp = idctsp;
    }

    public SanPham getIdSP() {
        return idSP;
    }

    public void setIdSP(SanPham idSP) {
        this.idSP = idSP;
    }

    public int getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(int idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public HangSX getHang() {
        return hang;
    }

    public void setHang(HangSX hang) {
        this.hang = hang;
    }

    public MauSac getMau() {
        return mau;
    }

    public void setMau(MauSac mau) {
        this.mau = mau;
    }

    public SizeSP getSize() {
        return size;
    }

    public void setSize(SizeSP size) {
        this.size = size;
    }

    
   
}
