/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author DELL
 */
public class SizeSP {
     private int idSize;
    private String maSize;
    private String tenSize;

    public SizeSP() {
    }

    public SizeSP(int idSize, String maSize, String tenSize) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return tenSize;
    }
    
}
