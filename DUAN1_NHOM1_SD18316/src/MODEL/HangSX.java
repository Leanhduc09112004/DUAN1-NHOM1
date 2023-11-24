/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author DELL
 */
public class HangSX {
    private int idHang;
    private String maHangSX;
    private String tenHangSX;

    public HangSX() {
    }

    public HangSX(int idHang, String maHangSX, String tenHangSX) {
        this.idHang = idHang;
        this.maHangSX = maHangSX;
        this.tenHangSX = tenHangSX;
    }

    public int getIdHang() {
        return idHang;
    }

    public void setIdHang(int idHang) {
        this.idHang = idHang;
    }

    public String getMaHangSX() {
        return maHangSX;
    }

    public void setMaHangSX(String maHangSX) {
        this.maHangSX = maHangSX;
    }

    public String getTenHangSX() {
        return tenHangSX;
    }

    public void setTenHangSX(String tenHangSX) {
        this.tenHangSX = tenHangSX;
    }

    @Override
    public String toString() {
        return tenHangSX;
    }
    
}
