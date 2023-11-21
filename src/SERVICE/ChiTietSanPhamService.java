/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SERVICE;

import MODEL.ChiTietSanPham;
import MODEL.HangSX;
import MODEL.MauSac;
import MODEL.SanPham;

import MODEL.SizeSP;
import REPO.DBConnect;

import java.util.ArrayList;
import java.util.List;

import REPO.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class ChiTietSanPhamService {

    public ArrayList<ChiTietSanPham> getAll() {
        ArrayList<ChiTietSanPham> list = new ArrayList<>();
        try {
            String sql = """
                         select sp.MaSP,
                         		sp.TenSP,
                         		mau.TenMau,
                         		size.Size,
                         		hsx.TenHangSanXuat,
                         		sp.TrangThai
                            from ChiTietSanPham ctsp
                         		join SanPham sp on ctsp.IdSP=sp.IdSP
                         		join HangSanXuat hsx on ctsp.IdHang=hsx.IdHang
                         		join SizeSP size on ctsp.IdSize=size.IdSize
                         		join MauSac mau on ctsp.IdMau = mau.IdMau
                            
                         """;
            Connection cn = DBConnect.getConnection();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ctsp = new ChiTietSanPham();

                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setTrangThai(rs.getBoolean("TrangThai"));

                SizeSP size = new SizeSP();
                size.setSizeSP(rs.getString("Size"));

                MauSac mau = new MauSac();
                mau.setMauSP(rs.getString("TenMau"));

                HangSX hsx = new HangSX();
                hsx.setTenHangSX(rs.getString("TenHangSanXuat"));

                ctsp.setIdSP(sp);
                ctsp.setSize(size);
                ctsp.setMau(mau);
                ctsp.setHang(hsx);
                list.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return list;
    }

}
