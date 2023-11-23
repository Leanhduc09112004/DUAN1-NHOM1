package MODEL;
public class MauSac {
    private int IdMauSP;
    private String MaMauSP;
    private String MauSP;

    public MauSac() {
    }

    public MauSac(int IdMauSP, String MaMauSP, String MauSP) {
        this.IdMauSP = IdMauSP;
        this.MaMauSP = MaMauSP;
        this.MauSP = MauSP;
    }

    public int getIdMauSP() {
        return IdMauSP;
    }

    public void setIdMauSP(int IdMauSP) {
        this.IdMauSP = IdMauSP;
    }

    public String getMaMauSP() {
        return MaMauSP;
    }

    public void setMaMauSP(String MaMauSP) {
        this.MaMauSP = MaMauSP;
    }

    public String getMauSP() {
        return MauSP;
    }

    public void setMauSP(String MauSP) {
        this.MauSP = MauSP;
    }

    @Override
    public String toString() {
        return  MauSP ;
    }
     
}
