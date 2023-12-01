
package MODEL;
import java.util.Date;

public class ThongKe {

    private Double tongDT;
    private int tongHD;
    private int tongSP;
    private SanPham maSP;
    private SanPham tenSP;
    private SanPham giaBan;
    private LoaiSanPham tenLoaiSP;
    private int tongDTSP;
    private Date ngayThanhToan;
    private int thangThanhToan;

    public ThongKe() {
    }

    public ThongKe(Double tongDT, int tongHD, int tongSP, SanPham maSP, SanPham tenSP, SanPham giaBan, LoaiSanPham tenLoaiSP, int tongDTSP, Date ngayThanhToan) {
        this.tongDT = tongDT;
        this.tongHD = tongHD;
        this.tongSP = tongSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.tenLoaiSP = tenLoaiSP;
        this.tongDTSP = tongDTSP;
        this.ngayThanhToan = ngayThanhToan;
    }

    public ThongKe(Double tongDT, int tongHD, int tongSP, SanPham maSP, SanPham tenSP, SanPham giaBan, LoaiSanPham tenLoaiSP, int tongDTSP, Date ngayThanhToan, int thangThanhToan) {
        this.tongDT = tongDT;
        this.tongHD = tongHD;
        this.tongSP = tongSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.tenLoaiSP = tenLoaiSP;
        this.tongDTSP = tongDTSP;
        this.ngayThanhToan = ngayThanhToan;
        this.thangThanhToan = thangThanhToan;
    }

    public int getThangThanhToan() {
        return thangThanhToan;
    }

    public void setThangThanhToan(int thangThanhToan) {
        this.thangThanhToan = thangThanhToan;
    }


    

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }


    public Double getTongDT() {
        return tongDT;
    }

    public void setTongDT(Double tongDT) {
        this.tongDT = tongDT;
    }

    public int getTongHD() {
        return tongHD;
    }

    public void setTongHD(int tongHD) {
        this.tongHD = tongHD;
    }

    public int getTongSP() {
        return tongSP;
    }

    public void setTongSP(int tongSP) {
        this.tongSP = tongSP;
    }

    public SanPham getMaSP() {
        return maSP;
    }

    public void setMaSP(SanPham maSP) {
        this.maSP = maSP;
    }

    public SanPham getTenSP() {
        return tenSP;
    }

    public void setTenSP(SanPham tenSP) {
        this.tenSP = tenSP;
    }

    public SanPham getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(SanPham giaBan) {
        this.giaBan = giaBan;
    }

    public LoaiSanPham getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(LoaiSanPham tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public int getTongDTSP() {
        return tongDTSP;
    }

    public void setTongDTSP(int tongDTSP) {
        this.tongDTSP = tongDTSP;
    }

}
