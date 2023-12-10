package VIEW;

import MODEL.HoaDon;
import MODEL.KhachHang;
import SERVICE.KhachHangService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewKhachHangChiTiet extends javax.swing.JFrame {

    private KhachHangService service = new KhachHangService();
    private DefaultTableModel tblmodel = new DefaultTableModel();
    private ArrayList<KhachHang> listKH;
    private ArrayList<HoaDon> listHD;

    public ViewKhachHangChiTiet() {
        initComponents();
        setTitle("Danh sách khách hàng");
        tblmodel = (DefaultTableModel) tblTTKhachHang.getModel();
        setLocationRelativeTo(null);
        LoadDataTable();
        ShowTTKhachHang();
    }

    private String[] thongTinKhachHang;

    public String[] getThongTinKhachHang() {
        return thongTinKhachHang;
    }

    void LoadDataTable() {
        tblmodel.setRowCount(0);
        listKH = service.getAllTT("", "");
        for (KhachHang kh : listKH) {
            tblmodel.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), kh.isGtinh() ? "Nam" : "Nữ", kh.getEmail(), kh.getSdt(), kh.getDchi(), kh.getNgSinh(), kh.getIdHD().isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    void TimKiem() {
        String timKiem = txtTIMKIEM.getText();
        listKH = service.searchKhachHang(timKiem, timKiem);
        tblmodel.setRowCount(0);
        for (KhachHang kh : listKH) {
            tblmodel.addRow(new Object[]{kh.getMaKH(), kh.getHoTen(), kh.isGtinh() ? "Nam" : "Nữ", kh.getEmail(), kh.getSdt(), kh.getDchi(), kh.getNgSinh(), kh.getIdHD().isTrangThai() ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    void ShowTTKhachHang() {
        int index = tblTTKhachHang.getSelectedRow();
        if (index != -1) {
            txtMaKH.setText(tblTTKhachHang.getValueAt(index, 0).toString());
            txtTenKH.setText(tblTTKhachHang.getValueAt(index, 1).toString());
            boolean gtinh = tblTTKhachHang.getValueAt(index, 2).toString().equalsIgnoreCase("Nam") ? true : false;
            rdoNam.setSelected(gtinh);
            rdoNu.setSelected(!gtinh);
            txtEmail.setText(tblTTKhachHang.getValueAt(index, 3).toString());
            txtSoDienThoai.setText(tblTTKhachHang.getValueAt(index, 4).toString());
            txtDiaChi.setText(tblTTKhachHang.getValueAt(index, 5).toString());
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) tblmodel.getValueAt(index, 6).toString());
                JdateNgaySinh.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(ViewNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean trangThai = tblTTKhachHang.getValueAt(index, 7).toString().equalsIgnoreCase("Đã thanh toán") ? true : false;
            rdoDaThanhToan.setSelected(trangThai);
            rdoChuaThanhToan.setSelected(!trangThai);
        }
    }

    private KhachHang getFORMINPUT() {
        KhachHang kh = new KhachHang();
        kh.setMaKH(txtMaKH.getText());
        kh.setHoTen(txtTenKH.getText());
        kh.setGtinh(rdoNam.isSelected() ? true : false);
        HoaDon hd = new HoaDon();
        hd.setTrangThai(rdoDaThanhToan.isSelected() ? true : false);
        kh.setIdHD(hd);
        kh.setDchi(txtDiaChi.getText());
        kh.setEmail(txtEmail.getText());
        kh.setSdt(txtSoDienThoai.getText());
        try {
            SimpleDateFormat input = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date date = input.parse(JdateNgaySinh.getDate().toString());
            SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = output.format(date);
            kh.setNgSinh(output.parse(formattedDate));
        } catch (ParseException ex) {
            Logger.getLogger(ViewNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTTKhachHang = new javax.swing.JTable();
        btnTHEM = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        rdoChuaThanhToan = new javax.swing.JRadioButton();
        btnSUA = new javax.swing.JButton();
        txtTIMKIEM = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        JdateNgaySinh = new com.toedter.calendar.JDateChooser();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        btnCHON = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");

        jLabel2.setText("Mã Khách Hàng:");

        jLabel4.setText("Tên Khách Hàng:");

        jLabel5.setText("Giới tính:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel6.setText("Email:");

        jLabel3.setText("Số điện thoại:");

        jLabel7.setText("Địa chỉ:");

        jLabel8.setText("Ngày sinh:");

        tblTTKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ KH", "TÊN KH", "GIỚI TÍNH", "EMAIL", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ", "NGÀY SINH", "TRẠNG THÁI HÓA ĐƠN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTTKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTTKhachHang);

        btnTHEM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnTHEM.setText("THÊM");
        btnTHEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTHEMActionPerformed(evt);
            }
        });

        jLabel9.setText("Trạng thái :");

        buttonGroup2.add(rdoDaThanhToan);
        rdoDaThanhToan.setText("Đã thanh toán");

        buttonGroup2.add(rdoChuaThanhToan);
        rdoChuaThanhToan.setText("Chưa thanh toán");

        btnSUA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        btnSUA.setText("SỬA");

        txtTIMKIEM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTIMKIEMKeyTyped(evt);
            }
        });

        jLabel10.setText("TÌM KIẾM");

        btnCHON.setText("CHỌN");
        btnCHON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCHONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoChuaThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaKH)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JdateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(txtSoDienThoai)
                            .addComponent(txtDiaChi)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTHEM, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSUA, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCHON)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(txtTIMKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSUA, btnTHEM});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(rdoNam)
                                .addComponent(rdoNu))
                            .addComponent(jLabel7)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(JdateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(rdoDaThanhToan)
                        .addComponent(rdoChuaThanhToan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSUA)
                        .addComponent(btnTHEM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTIMKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(btnCHON, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSUA, btnTHEM});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTTKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTKhachHangMouseClicked
        try {
            ShowTTKhachHang();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu");
        }
    }//GEN-LAST:event_tblTTKhachHangMouseClicked

    private void btnTHEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTHEMActionPerformed
        try {
            KhachHang kh = getFORMINPUT();
            if (service.addKH(kh) != null) {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng mới thành công");
                LoadDataTable();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng mới thất bại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng mới thất bại");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTHEMActionPerformed

    private void txtTIMKIEMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTIMKIEMKeyTyped
        TimKiem();
    }//GEN-LAST:event_txtTIMKIEMKeyTyped

    private void btnCHONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCHONActionPerformed
        thongTinKhachHang = new String[]{txtTenKH.getText(), txtSoDienThoai.getText(),rdoNam.isSelected()?"Nam":"Nữ"};
        this.dispose();
    }//GEN-LAST:event_btnCHONActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHangChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHangChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JdateNgaySinh;
    private javax.swing.JButton btnCHON;
    private javax.swing.JButton btnSUA;
    private javax.swing.JButton btnTHEM;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoChuaThanhToan;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblTTKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTIMKIEM;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
