package VIEW;

import MODEL.KhuyenMai;
import SERVICE.KhuyenMaiService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ViewKhuyenMai extends javax.swing.JFrame {
    
    private int index = -1;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    KhuyenMaiService service = new KhuyenMaiService();
    ArrayList<KhuyenMai> list;
    DefaultTableModel mol = new DefaultTableModel();
    public ViewKhuyenMai() {
        initComponents();
        cbx_trangthai.removeAllItems();
        cbx_trangthai.addItem("Tất cả");
        cbx_trangthai.addItem("Đang hoạt động");
        cbx_trangthai.addItem("Ngừng hoạt động");
        setLocationRelativeTo(null);
        mol = (DefaultTableModel) tbl_km.getModel();

        fillTable();

    }
    private void fillTable() {
        mol.setRowCount(0);
        int i = 1;
        list = service.getAll("", "");
        for (KhuyenMai km : list) {
            mol.addRow(new Object[]{
                i++,
                km.getMaKM(),
                km.getTenKM(),
                km.getNgayBatDau(),
                km.getNgayKetThuc(),
                km.getDieuKien(),
                km.getTienGiam(),
                km.getGhiChu(),
                km.getTrangThai() ? "Đang hoạt động" : "Ngừng hoạt động"

            });
        }
    }

    void showData() {
        int i = tbl_km.getSelectedRow();
        txt_maKM.setText(tbl_km.getValueAt(i, 1).toString());
        txt_tenKM.setText(tbl_km.getValueAt(i, 2).toString());
        try {
            Date ngayBD = format.parse(tbl_km.getValueAt(i, 3).toString());
            Date_ngayBD.setDate(ngayBD);
        } catch (Exception e) {
            System.out.println("Loi date");
        }
        try {
            Date ngayKT = format.parse(tbl_km.getValueAt(i, 4).toString());
            Date_ngayKT.setDate(ngayKT);
        } catch (Exception e) {
            System.out.println("Loi date");
        }
        txt_dieuKien.setText(tbl_km.getValueAt(i, 5).toString());
        txt_mucGiam.setText(tbl_km.getValueAt(i, 6).toString());
        txt_ghichu.setText(tbl_km.getValueAt(i, 7).toString());
        String tt = tbl_km.getValueAt(i, 8).toString();
        if (tt.equals("Đang hoạt động")) {
            rd_dangHD.setSelected(true);
        } else {
            rd_ngungHD.setSelected(true);
        }

    }
    private void fillTableFind() {
        mol.setRowCount(0);
        int i = 1;
        String ma = txt_timKiem.getText().trim();
        String ten = txt_timKiem.getText().trim();
        list = service.getAll(ten, ma);
        for (KhuyenMai km : list) {
            mol.addRow(new Object[]{
                i++,
                km.getMaKM(),
                km.getTenKM(),
                km.getNgayBatDau(),
                km.getNgayKetThuc(),
                km.getDieuKien(),
                km.getTienGiam(),
                km.getGhiChu(),
                km.getTrangThai() ? "Đang hoạt động" : "Ngừng hoạt động"

            });
        }
    }

    KhuyenMai getData() {
        KhuyenMai km = new KhuyenMai();

        km.setMaKM(txt_maKM.getText());
        km.setTenKM(txt_tenKM.getText());
        km.setTienGiam(Double.parseDouble(txt_mucGiam.getText()));
        km.setNgayBatDau(Date_ngayBD.getDate());
        km.setNgayKetThuc(Date_ngayKT.getDate());
        km.setDieuKien(txt_dieuKien.getText());
        km.setGhiChu(txt_ghichu.getText());
        if (rd_dangHD.isSelected()) {
            km.setTrangThai(true);
        } else {
            km.setTrangThai(false);
        }

        return km;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_tenKM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_capnhat = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        txt_maKM = new javax.swing.JTextField();
        txt_mucGiam = new javax.swing.JTextField();
        Date_ngayBD = new com.toedter.calendar.JDateChooser();
        Date_ngayKT = new com.toedter.calendar.JDateChooser();
        rd_dangHD = new javax.swing.JRadioButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txt_timKiem = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_km = new javax.swing.JTable();
        cbx_trangthai = new javax.swing.JComboBox<>();
        btn_chuyentrangthai = new javax.swing.JButton();
        rd_ngungHD = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txt_ghichu = new java.awt.TextArea();
        txt_dieuKien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thiết lập khuyến mãi"));

        jLabel1.setText("Tên khuyến mãi:");

        jLabel2.setText("Mã khuyến mãi:");

        jLabel3.setText("Mức giảm: ");

        jLabel4.setText("Thời gian bắt đầu:");

        jLabel5.setText("Thời gian kết thúc: ");

        jLabel6.setText("Điều kiện:");

        jLabel7.setText("Trạng thái: ");

        btn_them.setText("THÊM");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_capnhat.setText("CẬP NHẬT");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        btn_moi.setText("MỚI");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_dangHD);
        rd_dangHD.setSelected(true);
        rd_dangHD.setText("Đang hoạt động");
        rd_dangHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_dangHDActionPerformed(evt);
            }
        });

        btn_timKiem.setText("TÌM KIẾM");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        tbl_km.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KM", "Tên KM", "Ngày bắt đầu", "Ngày kết thúc", "Điều kiện", "Mức giảm", "Ghi chú", "Trạng thái", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_km.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kmMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_km);

        cbx_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang hoạt động", "Ngừng hoạt động" }));
        cbx_trangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_trangthaiActionPerformed(evt);
            }
        });

        btn_chuyentrangthai.setText("CHUYỂN TRẠNG THÁI");
        btn_chuyentrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chuyentrangthaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timKiem)
                        .addGap(30, 30, 30)
                        .addComponent(cbx_trangthai, 0, 114, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_chuyentrangthai)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timKiem)
                    .addComponent(cbx_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chuyentrangthai))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Danh sách khuyến mãi", jPanel2);

        buttonGroup1.add(rd_ngungHD);
        rd_ngungHD.setText("Ngừng hoạt động");

        jLabel8.setText("Ghi chú: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Date_ngayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Date_ngayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel3))
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_mucGiam)
                                            .addComponent(txt_maKM)
                                            .addComponent(txt_tenKM)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(txt_dieuKien))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_them, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(btn_moi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_capnhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_ngungHD)
                            .addComponent(rd_dangHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_maKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_mucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Date_ngayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Date_ngayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_dieuKien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_ghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(rd_dangHD))
                .addGap(18, 18, 18)
                .addComponent(rd_ngungHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_capnhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_moi)
                .addGap(22, 22, 22))
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("Danh sách khuyến mãi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rd_dangHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_dangHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_dangHDActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        // TODO add your handling code here:
        try {
            clearForm();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_moiActionPerformed

    void clearForm() throws ParseException {

        txt_maKM.setText("");
        txt_tenKM.setText("");
        txt_mucGiam.setText("");
        txt_dieuKien.setText("");
        txt_ghichu.setText("");

        Date_ngayBD.setCalendar(null);

        Date_ngayKT.setCalendar(null);

        rd_dangHD.setSelected(true);
        rd_ngungHD.setSelected(false);

    }
    boolean checkData() {

        if (txt_maKM.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khuyến mãi");
            return false;
        }
        if (txt_tenKM.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khuyến mãi");
            return false;
        }
        if (txt_mucGiam.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mức giảm không được để trống!");
            return false;
        } else {
            try {
                double mucGiam = Double.parseDouble(txt_mucGiam.getText());
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(this, "Mức giảm phải là số!");
                return false;
            }

        }

        if (txt_dieuKien.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập điều kiện");
            return false;
        }

        if (Date_ngayBD.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu");
            return false;
        }
        if (Date_ngayKT.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày kết thúc");
            return false;
        }

        return true;

    }

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        int i;
        if (checkData()) {
            try {
                KhuyenMai k = getData();
                if (service.updateKM(k) != null) {
                    i = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
                    if (i != JOptionPane.YES_OPTION) {
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                        fillTable();
                        clearForm();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_capnhatActionPerformed
    boolean checkMaKM() {
        list = service.getAll("", "");
        for (KhuyenMai x : list) {
            if (txt_maKM.getText().equalsIgnoreCase(x.getMaKM())) {
                JOptionPane.showMessageDialog(this, "Mã khuyến mãi đã được sử dụng");
                txt_maKM.requestFocus();
                return false;
            }

        }
        return true;
    }

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        int i;
        if (checkData() && checkMaKM()) {
            try {
                KhuyenMai k = getData();
                if (service.addKM(k) != null) {
                    i = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
                    if (i != JOptionPane.YES_OPTION) {
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        fillTable();
                        clearForm();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_kmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kmMouseClicked
        index = tbl_km.getSelectedRow();
        showData();

    }//GEN-LAST:event_tbl_kmMouseClicked
    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
        try {
            fillTableFind();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_timKiemActionPerformed
    private void btn_chuyentrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chuyentrangthaiActionPerformed

        DefaultTableModel model = (DefaultTableModel) tbl_km.getModel();
        List<Integer> selectedRows = new ArrayList<>();
        boolean updatedSuccessfully = false;

        for (int i = 0; i < tbl_km.getRowCount(); i++) {
            Boolean selected = (Boolean) model.getValueAt(i, 9);
            if (selected != null && selected) {
                selectedRows.add(i);
            }
        }

        if (!selectedRows.isEmpty()) {
            for (int selectedRow : selectedRows) {
                String maKM = tbl_km.getValueAt(selectedRow, 1).toString();
                boolean trangThai = tbl_km.getValueAt(selectedRow, 8).toString().equalsIgnoreCase("Đang hoạt động");
                boolean trangThaiMoi = !trangThai;

                KhuyenMai selectKM = new KhuyenMai();

                selectKM.setMaKM(maKM);
                selectKM.setTrangThai(trangThaiMoi);

                KhuyenMaiService kms = new KhuyenMaiService();

                Integer updatedRows = service.updateTrangThai(selectKM);

                if (updatedRows != null && updatedRows > 0) {
                    updatedSuccessfully = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thất bại");
                    break;
                }
            }
            if (updatedSuccessfully) {
                JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thành công");
                fillTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một hàng để cập nhật trạng thái");
        }
    }//GEN-LAST:event_btn_chuyentrangthaiActionPerformed
    private void cbx_trangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_trangthaiActionPerformed

        boolean trangThai;
        Object selectedItem = cbx_trangthai.getSelectedItem();
        if (selectedItem != null) {
            String tuKhoa = selectedItem.toString();
            if (tuKhoa.equalsIgnoreCase("Tất cả")) {
                fillTable();
            } else {
                if (tuKhoa.equalsIgnoreCase("Đang hoạt động")) {
                    trangThai = true;
                } else if (tuKhoa.equalsIgnoreCase("Ngừng hoạt động")) {
                    trangThai = false;
                } else {
                    trangThai = rd_dangHD.isSelected();
                }
                ArrayList<KhuyenMai> ketQuaTimKiem = service.timKiemKMTheoTT(trangThai);
                mol.setRowCount(0);
                int i = 0;
                for (KhuyenMai km : ketQuaTimKiem) {
                    mol.addRow(new Object[]{
                        i++,
                        km.getMaKM(),
                        km.getTenKM(),
                        km.getNgayBatDau(),
                        km.getNgayKetThuc(),
                        km.getDieuKien(),
                        km.getTienGiam(),
                        km.getGhiChu(),
                        km.getTrangThai() ? "Đang hoạt động" : "Ngừng hoạt động"
                    });
                }
            }
        }
    }//GEN-LAST:event_cbx_trangthaiActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhuyenMai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_ngayBD;
    private com.toedter.calendar.JDateChooser Date_ngayKT;
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_chuyentrangthai;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbx_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton rd_dangHD;
    private javax.swing.JRadioButton rd_ngungHD;
    private javax.swing.JTable tbl_km;
    private javax.swing.JTextField txt_dieuKien;
    private java.awt.TextArea txt_ghichu;
    private javax.swing.JTextField txt_maKM;
    private javax.swing.JTextField txt_mucGiam;
    private javax.swing.JTextField txt_tenKM;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
