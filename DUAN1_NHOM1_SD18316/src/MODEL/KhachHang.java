
package MODEL;

import java.util.Date;

public class KhachHang {
    private int idKH;
    private String maKH;
    private String hoTen; 
    private String email; 
    private String sdt; 
    private boolean gtinh; 
    private Date ngSinh ; 
    private String dchi; 

    public KhachHang() {
    }

    public KhachHang(String maKH, String hoTen, String email, String sdt, boolean gtinh, Date ngSinh, String dchi) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.gtinh = gtinh;
        this.ngSinh = ngSinh;
        this.dchi = dchi;
    }

    public KhachHang(int idKH, String maKH, String hoTen, String email, String sdt, boolean gtinh, Date ngSinh, String dchi) {
        this.idKH = idKH;
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.gtinh = gtinh;
        this.ngSinh = ngSinh;
        this.dchi = dchi;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }
    

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGtinh() {
        return gtinh;
    }

    public void setGtinh(boolean gtinh) {
        this.gtinh = gtinh;
    }

    public Date getNgSinh() {
        return ngSinh;
    }

    public void setNgSinh(Date ngSinh) {
        this.ngSinh = ngSinh;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

}
