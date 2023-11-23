package MODEL;
public class SizeSP {
    private int IdSizeSP;
    private String MaSizeSP;
    private String SizeSP;

    public SizeSP() {
    }

    public SizeSP(int IdSizeSP, String MaSizeSP, String SizeSP) {
        this.IdSizeSP = IdSizeSP;
        this.MaSizeSP = MaSizeSP;
        this.SizeSP = SizeSP;
    }

    public int getIdSizeSP() {
        return IdSizeSP;
    }

    public void setIdSizeSP(int IdSizeSP) {
        this.IdSizeSP = IdSizeSP;
    }

    public String getMaSizeSP() {
        return MaSizeSP;
    }

    public void setMaSizeSP(String MaSizeSP) {
        this.MaSizeSP = MaSizeSP;
    }

    public String getSizeSP() {
        return SizeSP;
    }

    public void setSizeSP(String SizeSP) {
        this.SizeSP = SizeSP;
    }

    @Override
    public String toString() {
        return SizeSP ;
    }  
}
