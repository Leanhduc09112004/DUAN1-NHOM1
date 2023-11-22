package MODEL;
public class HangSX {
    private int IdHangSX;
    private String MaHangSX;
    private String TenHangSX;

    public HangSX() {
    }

    public HangSX(int IdHangSX, String MaHangSX, String TenHangSX) {
        this.IdHangSX = IdHangSX;
        this.MaHangSX = MaHangSX;
        this.TenHangSX = TenHangSX;
    }

    public int getIdHangSX() {
        return IdHangSX;
    }

    public void setIdHangSX(int IdHangSX) {
        this.IdHangSX = IdHangSX;
    }

    public String getMaHangSX() {
        return MaHangSX;
    }

    public void setMaHangSX(String MaHangSX) {
        this.MaHangSX = MaHangSX;
    }

    public String getTenHangSX() {
        return TenHangSX;
    }

    public void setTenHangSX(String TenHangSX) {
        this.TenHangSX = TenHangSX;
    }

    @Override
    public String toString() {
        return TenHangSX ;
    }
}
