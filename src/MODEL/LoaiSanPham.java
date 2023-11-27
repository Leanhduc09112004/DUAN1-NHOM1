package MODEL;
public class LoaiSanPham {
    private int IdLoaiSP;
    private String MaLoaiSP;
    private  String TenLoaiSP;

    public LoaiSanPham(int IdLoaiSP) {
        this.IdLoaiSP = IdLoaiSP;
    }

    
    public LoaiSanPham() {
    }

    public LoaiSanPham(int IdLoaiSP, String MaLoaiSP, String TenLoaiSP) {
        this.IdLoaiSP = IdLoaiSP;
        this.MaLoaiSP = MaLoaiSP;
        this.TenLoaiSP = TenLoaiSP;
    }

    public int getIdLoaiSP() {
        return IdLoaiSP;
    }

    public void setIdLoaiSP(int IdLoaiSP) {
        this.IdLoaiSP = IdLoaiSP;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public void setTenLoaiSP(String TenLoaiSP) {
        this.TenLoaiSP = TenLoaiSP;
    }

    @Override
    public String toString() {
        return TenLoaiSP;
    }
  
}
