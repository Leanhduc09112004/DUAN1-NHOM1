package VIEW;

import MODEL.HangSX;
import MODEL.LoaiSanPham;
import MODEL.MauSac;
import MODEL.SanPham;
import MODEL.SizeSP;
import SERVICE.HangSPService;
import SERVICE.LoaiSanPhamService;
import SERVICE.MauSacService;
import SERVICE.SanPhamService;
import SERVICE.SizeService;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ViewSanPham extends javax.swing.JFrame {

    private SanPhamService service = new SanPhamService();
    private DefaultComboBoxModel<HangSX> cbomodelHang = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<MauSac> cbomodelMau = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<LoaiSanPham> cbomodelLoaiSP = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<SizeSP> cbomodelSIZE = new DefaultComboBoxModel<>();
    private ArrayList<SanPham> list;
    private ArrayList<HangSX> listHang;
    private ArrayList<MauSac> listMau;
    private ArrayList<SizeSP> listSize;
    private ArrayList<LoaiSanPham> listLoaiSP;
    private DefaultTableModel tblmodel = new DefaultTableModel();
    private DefaultTableModel tblmodel2 = new DefaultTableModel();
    private HangSPService serviceHang = new HangSPService();
    private MauSacService serviceMau = new MauSacService();
    private SizeService serviceSize = new SizeService();
    private LoaiSanPhamService serviceLoaiSP = new LoaiSanPhamService();
    private String strHinhAnh = null;

    public ViewSanPham() {
        initComponents();
        setLocationRelativeTo(null);
        tblmodel = (DefaultTableModel) tblSANPHAM.getModel();
        tblmodel2 = (DefaultTableModel) tblThuocTinh.getModel();
        cboTRANGTHAI.removeAllItems();
        cboTRANGTHAI.addItem("Tất cả");
        cboTRANGTHAI.addItem("Còn hàng");
        cboTRANGTHAI.addItem("Hết hàng");
        cboHANGSP.setModel((DefaultComboBoxModel) cbomodelHang);
        cboMauSac.setModel((DefaultComboBoxModel) cbomodelMau);
        cboSize.setModel((DefaultComboBoxModel) cbomodelSIZE);
        cboLOAISP.setModel((DefaultComboBoxModel) cbomodelLoaiSP);
        LoadDataComboHang();
        LoadDataComboMau();
        LoadDataComboSize();
        LoadDataComboLoaiSP();
        LoadDataTableSize();
        LoadDataTableMau();
        LoadDataTableHang();
        LoadDataTableLoaiSP();
        LoadDataTableSP();
        ShowThuocTinh();
        if (tblSANPHAM.getRowCount() > 0) {
            tblSANPHAM.setRowSelectionInterval(0, 0);
        }
        ShowSanPham();
    }

    void LoadDataTableSize() {
        tblmodel2.setRowCount(0);
        listSize = serviceSize.getAll();
        for (SizeSP size : listSize) {
            tblmodel2.addRow(new Object[]{size.getMaSizeSP(), size.getSizeSP()});
        }
    }

    void LoadDataTableMau() {
        tblmodel2.setRowCount(0);
        listMau = serviceMau.getAll();
        for (MauSac mau : listMau) {
            tblmodel2.addRow(new Object[]{mau.getMaMauSP(), mau.getMauSP()});
        }
    }

    void LoadDataTableHang() {
        tblmodel2.setRowCount(0);
        listHang = serviceHang.getAll();
        for (HangSX hang : listHang) {
            tblmodel2.addRow(new Object[]{hang.getMaHangSX(), hang.getTenHangSX()});
        }
    }

    void LoadDataTableLoaiSP() {
        tblmodel2.setRowCount(0);
        listLoaiSP = serviceLoaiSP.getAll();
        for (LoaiSanPham loai : listLoaiSP) {
            tblmodel2.addRow(new Object[]{loai.getMaLoaiSP(), loai.getTenLoaiSP()});
        }
    }

    void LoadDataComboHang() {
        cbomodelHang.removeAllElements();
        listHang = serviceHang.getAll();
        for (HangSX hsx : listHang) {
            cbomodelHang.addElement(hsx);
        }
    }

    void LoadDataComboMau() {
        cbomodelMau.removeAllElements();
        listMau = serviceMau.getAll();
        for (MauSac mauSac : listMau) {
            cbomodelMau.addElement(mauSac);
        }
    }

    void LoadDataComboSize() {
        cbomodelSIZE.removeAllElements();
        listSize = serviceSize.getAll();
        for (SizeSP sizeSP : listSize) {
            cbomodelSIZE.addElement(sizeSP);
        }
    }

    void LoadDataComboLoaiSP() {
        cbomodelLoaiSP.removeAllElements();
        listLoaiSP = serviceLoaiSP.getAll();
        for (LoaiSanPham lsp : listLoaiSP) {
            cbomodelLoaiSP.addElement(lsp);
        }
    }

    void LoadDataTableSP() {
        tblmodel.setRowCount(0);
        list = service.getAll();
        int i = 1;
        for (SanPham sp : list) {
            tblmodel.addRow(new Object[]{i++, sp.getMaSP(),
                sp.getTenSP(),
                sp.getIdLoaiSP().getTenLoaiSP(),
                sp.getGiaBan(), sp.getGiaNhap(),
                sp.getHinhAnh(), sp.getMoTa(),
                sp.getSoluong(), sp.getIdMauSac().getMauSP(),
                sp.getIdSize().getSizeSP(),
                sp.getIdHang().getTenHangSX(),
                sp.isTrangThai() ? "Còn hàng" : "Hết hàng"});
        }
    }

    void ShowThuocTinh() {
        int index2 = tblThuocTinh.getSelectedRow();
        if (index2 != -1) {
            txtMATHUOCTINH.setText(tblThuocTinh.getValueAt(index2, 0).toString());
            txtTENTHUOCTINH.setText(tblThuocTinh.getValueAt(index2, 1).toString());
        }
    }

    void ShowSanPham() {
        int index = tblSANPHAM.getSelectedRow();
        if (index != -1) {
            txtMASP.setText(tblSANPHAM.getValueAt(index, 1).toString());
            txtTENSP.setText(tblSANPHAM.getValueAt(index, 2).toString());

            txtGiaBan.setText(tblSANPHAM.getValueAt(index, 4).toString());
            txtGiaNhap.setText(tblSANPHAM.getValueAt(index, 5).toString());
            updateHinh(tblmodel.getValueAt(index, 6).toString());
            txtMoTa.setText(tblSANPHAM.getValueAt(index, 7).toString());
            txtSoLuong.setText(tblSANPHAM.getValueAt(index, 8).toString());

            Object valueLoaiSP = tblSANPHAM.getValueAt(index, 3);
            LoaiSanPham loaiSP = null;
            if (valueLoaiSP instanceof LoaiSanPham) {
                loaiSP = (LoaiSanPham) valueLoaiSP;
            } else if (valueLoaiSP instanceof String) {
                String tenLoaiSP = (String) valueLoaiSP;
                for (LoaiSanPham loai : listLoaiSP) {
                    if (loai.getTenLoaiSP().equals(tenLoaiSP)) {
                        loaiSP = loai;
                        break;
                    }
                }
            }
            cbomodelLoaiSP.setSelectedItem(loaiSP);

            Object valueMau = tblSANPHAM.getValueAt(index, 9);
            MauSac mau = null;
            if (valueMau instanceof MauSac) {
                mau = (MauSac) valueMau;
            } else if (valueMau instanceof String) {
                String tenMau = (String) valueMau;
                for (MauSac mauSac : listMau) {
                    if (mauSac.getMauSP().equals(tenMau)) {
                        mau = mauSac;
                        break;
                    }
                }
            }
            cbomodelMau.setSelectedItem(mau);

            Object valueSize = tblSANPHAM.getValueAt(index, 10);
            SizeSP size = null;
            if (valueSize instanceof SizeSP) {
                size = (SizeSP) valueSize;
            } else if (valueSize instanceof String) {
                String sizeSP = (String) valueSize;
                for (SizeSP sizeItem : listSize) {
                    if (sizeItem.getSizeSP().equals(sizeSP)) {
                        size = sizeItem;
                        break;
                    }
                }
            }

            cbomodelSIZE.setSelectedItem(size);

            Object valueHang = tblSANPHAM.getValueAt(index, 11);
            HangSX hang = null;
            if (valueHang instanceof HangSX) {
                hang = (HangSX) valueHang;
            } else if (valueHang instanceof String) {
                String tenHang = (String) valueHang;
                for (HangSX hangSX : listHang) {
                    if (hangSX.getTenHangSX().equals(tenHang)) {
                        hang = hangSX;
                        break;
                    }
                }
            }
            cbomodelHang.setSelectedItem(hang);

            boolean trangThai = tblSANPHAM.getValueAt(index, 12).toString().equalsIgnoreCase("Còn hàng") ? true : false;
            rdoConHang.setSelected(trangThai);
            rdoHetHang.setSelected(!trangThai);
        }
    }

    public void updateHinh(String image) {
        ImageIcon icon1 = new ImageIcon("src/img/" + image);
        Image im = icon1.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), im.SCALE_SMOOTH));
        lblHinhAnh.setIcon(icon);
    }

    private SanPham getFORMINPUT() {
        SanPham sp = new SanPham();

        sp.setMaSP(txtMASP.getText());
        sp.setTenSP(txtTENSP.getText());

        LoaiSanPham loaiSP = (LoaiSanPham) cboLOAISP.getSelectedItem();
        sp.setIdLoaiSP(loaiSP);

        sp.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
        sp.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));

        sp.setHinhAnh(strHinhAnh);

        sp.setMoTa(txtMoTa.getText());
        sp.setSoluong(Integer.parseInt(txtSoLuong.getText()));
        int idLoaiSP = ((LoaiSanPham) cboLOAISP.getSelectedItem()).getIdLoaiSP();
        int idMau = ((MauSac) cboMauSac.getSelectedItem()).getIdMauSP();
        int idSize = ((SizeSP) cboSize.getSelectedItem()).getIdSizeSP();
        int idHang = ((HangSX) cboHANGSP.getSelectedItem()).getIdHangSX();

        sp.setIdLoaiSP(new LoaiSanPham(idLoaiSP));
        sp.setIdMauSac(new MauSac(idMau));
        sp.setIdSize(new SizeSP(idSize));
        sp.setIdHang(new HangSX(idHang));

        boolean trangThai = rdoConHang.isSelected();
        sp.setTrangThai(trangThai);
        return sp;
    }

    private MauSac getFORMINPUTMAU() {
        MauSac mau = new MauSac();
        String maMau = txtMATHUOCTINH.getText().trim();
        String tenMau = txtTENTHUOCTINH.getText().trim();
        if (maMau.isEmpty() || tenMau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin cho thuộc tính màu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        mau.setMaMauSP(maMau);
        mau.setMauSP(tenMau);
        return mau;
    }

    private SizeSP getFORMINPUTSIZE() {
        SizeSP size = new SizeSP();
        String maSize = txtMATHUOCTINH.getText().trim();
        String tenSize = txtTENTHUOCTINH.getText().trim();
        if (maSize.isEmpty() || tenSize.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin cho thuộc tính size.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        size.setMaSizeSP(maSize);
        size.setSizeSP(tenSize);
        return size;
    }

    private LoaiSanPham getFORMINPUTLoaiSanPham() {
        LoaiSanPham loai = new LoaiSanPham();
        String maLoai = txtMATHUOCTINH.getText().trim();
        String tenLoai = txtTENTHUOCTINH.getText().trim();
        if (maLoai.isEmpty() || tenLoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin cho loại sản phẩm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        loai.setMaLoaiSP(maLoai);
        loai.setTenLoaiSP(tenLoai);
        return loai;
    }

    private HangSX getFORMINPUTHang() {
        HangSX hang = new HangSX();
        String maHang = txtMATHUOCTINH.getText().trim();
        String tenHang = txtTENTHUOCTINH.getText().trim();
        if (maHang.isEmpty() || tenHang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin cho hãng sản xuất.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        hang.setMaHangSX(maHang);
        hang.setTenHangSX(tenHang);
        return hang;
    }

    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int startIndex = 0;
        if (str.charAt(0) == '-') {
            startIndex = 1;
        }
        for (int i = startIndex; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtMASP = new javax.swing.JTextField();
        cboMauSac = new javax.swing.JComboBox<>();
        cboHANGSP = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        rdoConHang = new javax.swing.JRadioButton();
        rdoHetHang = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        cboLOAISP = new javax.swing.JComboBox<>();
        lblHinhAnh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTENSP = new javax.swing.JTextField();
        cboSize = new javax.swing.JComboBox<>();
        txtGiaBan = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btnTHEMSP = new javax.swing.JButton();
        btnSUASP = new javax.swing.JButton();
        btnCLEARFORM = new javax.swing.JButton();
        btnTRANGTHAI = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        cboTRANGTHAI = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txtTIMKIEM = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSANPHAM = new javax.swing.JTable();
        btnXUATFILE = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtMATHUOCTINH = new javax.swing.JTextField();
        txtTENTHUOCTINH = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        rdoHANG = new javax.swing.JRadioButton();
        rdoMAUSAC = new javax.swing.JRadioButton();
        rdoLOAISANPHAM = new javax.swing.JRadioButton();
        rdoSize = new javax.swing.JRadioButton();
        jPanel23 = new javax.swing.JPanel();
        btnTHEMTHUOCTINH = new javax.swing.JButton();
        btnSUATHUOCTINH = new javax.swing.JButton();
        btnCLEARFORMTHUOCTINH = new javax.swing.JButton();
        btnXOA = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));

        jPanel14.setForeground(new java.awt.Color(255, 204, 204));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Mã sản phẩm");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Tên sản phẩm");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Màu sắc");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Size");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Hãng");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Trạng Thái");

        buttonGroup2.add(rdoConHang);
        rdoConHang.setText("Còn hàng");

        buttonGroup2.add(rdoHetHang);
        rdoHetHang.setText("Hết hàng");
        rdoHetHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHetHangActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Loại SP");

        lblHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Giá Bán");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Giá Nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Số Lượng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Mô Tả");

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoConHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdoHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMASP, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(txtTENSP)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMoTa)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboMauSac, 0, 241, Short.MAX_VALUE)
                            .addComponent(cboSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLOAISP, 0, 241, Short.MAX_VALUE)
                            .addComponent(cboHANGSP, 0, 241, Short.MAX_VALUE))))
                .addGap(19, 19, 19))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboHANGSP, cboLOAISP, cboMauSac});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMASP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTENSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboHANGSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cboLOAISP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdoConHang))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdoHetHang)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtMoTa)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboHANGSP, cboLOAISP, cboMauSac});

        btnTHEMSP.setText("THÊM");
        btnTHEMSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTHEMSPActionPerformed(evt);
            }
        });

        btnSUASP.setText("SỬA");
        btnSUASP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSUASPActionPerformed(evt);
            }
        });

        btnCLEARFORM.setText("CLEAR");
        btnCLEARFORM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARFORMActionPerformed(evt);
            }
        });

        btnTRANGTHAI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Unlock.png"))); // NOI18N
        btnTRANGTHAI.setText("ĐỔI TRẠNG THÁI");
        btnTRANGTHAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTRANGTHAIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTRANGTHAI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCLEARFORM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSUASP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTHEMSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnTHEMSP)
                .addGap(18, 18, 18)
                .addComponent(btnSUASP)
                .addGap(18, 18, 18)
                .addComponent(btnCLEARFORM)
                .addGap(18, 18, 18)
                .addComponent(btnTRANGTHAI)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCLEARFORM, btnSUASP, btnTHEMSP, btnTRANGTHAI});

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Trạng thái");
        jLabel35.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cboTRANGTHAI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTRANGTHAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTRANGTHAIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(cboTRANGTHAI, 0, 115, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTRANGTHAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Tìm kiếm: ");

        txtTIMKIEM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTIMKIEMKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTIMKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTIMKIEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        tblSANPHAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Loại Sản Phẩm", "Giá Bán", "Giá Nhập", "Hình Ảnh", "Mô Tả", "Số Lượng", "Màu sắc", "Size", "Hãng", "Trạng thái", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSANPHAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSANPHAMMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSANPHAM);

        btnXUATFILE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnXUATFILE.setText("EXCEL ");
        btnXUATFILE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXUATFILEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnXUATFILE, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnXUATFILE, jPanel17, jPanel18});

        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnXUATFILE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel17, jPanel18});

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel11);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Mã thuộc tính");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Tên thuộc tính");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTENTHUOCTINH))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMATHUOCTINH, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMATHUOCTINH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTENTHUOCTINH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdoHANG);
        rdoHANG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoHANG.setText("Hãng");
        rdoHANG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoHANGMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoMAUSAC);
        rdoMAUSAC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoMAUSAC.setText("Màu sắc");
        rdoMAUSAC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoMAUSACMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoLOAISANPHAM);
        rdoLOAISANPHAM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoLOAISANPHAM.setText("Loại sản phẩm");
        rdoLOAISANPHAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoLOAISANPHAMMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoSize);
        rdoSize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdoSize.setText("Size");
        rdoSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoSizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoHANG, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoSize, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoMAUSAC, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoLOAISANPHAM))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoMAUSAC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoSize))
                .addGap(28, 28, 28)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHANG, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoLOAISANPHAM))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        btnTHEMTHUOCTINH.setText("THÊM");
        btnTHEMTHUOCTINH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTHEMTHUOCTINHActionPerformed(evt);
            }
        });

        btnSUATHUOCTINH.setText("SỬA");
        btnSUATHUOCTINH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSUATHUOCTINHActionPerformed(evt);
            }
        });

        btnCLEARFORMTHUOCTINH.setText("CLEAR");
        btnCLEARFORMTHUOCTINH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARFORMTHUOCTINHActionPerformed(evt);
            }
        });

        btnXOA.setText("XÓA");
        btnXOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXOAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCLEARFORMTHUOCTINH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSUATHUOCTINH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTHEMTHUOCTINH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXOA, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel23Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCLEARFORMTHUOCTINH, btnSUATHUOCTINH, btnTHEMTHUOCTINH, btnXOA});

        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnTHEMTHUOCTINH)
                .addGap(18, 18, 18)
                .addComponent(btnSUATHUOCTINH)
                .addGap(18, 18, 18)
                .addComponent(btnCLEARFORMTHUOCTINH)
                .addGap(18, 18, 18)
                .addComponent(btnXOA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCLEARFORMTHUOCTINH, btnSUATHUOCTINH, btnTHEMTHUOCTINH});

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã thuộc tính", "Tên thuộc tính"
            }
        ));
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thuộc tính Sản Phẩm", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSANPHAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSANPHAMMouseClicked
        try {
            ShowSanPham();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lối dữ liệu vui lòng kiểm tra lại");
        }
    }//GEN-LAST:event_tblSANPHAMMouseClicked

    private void btnTHEMSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTHEMSPActionPerformed
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm sản phẩm này ?");
            if (chon != JOptionPane.YES_OPTION) {
                return;
            }
            if (txtMASP.getText().isEmpty() || txtTENSP.getText().isEmpty()
                    || txtGiaBan.getText().isEmpty() || txtGiaNhap.getText().isEmpty()
                    || txtSoLuong.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sản phẩm");
                return;
            }
            if (!isNumeric(txtGiaBan.getText()) || !isNumeric(txtGiaNhap.getText()) || !isNumeric(txtSoLuong.getText())) {
                JOptionPane.showMessageDialog(this, "Giá bán, giá nhập và số lượng phải là số");
                return;
            }
            SanPham sp = getFORMINPUT();
            if (service.addSanPham(sp) != null) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                LoadDataTableSP();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Thêm bị lỗi vui lòng kiểm tra lại");
        }
        btnCLEARFORMActionPerformed(evt);
    }//GEN-LAST:event_btnTHEMSPActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            strHinhAnh = file.getName();
            lblHinhAnh.setText("");
            int width = lblHinhAnh.getWidth();
            int height = lblHinhAnh.getHeight();
            lblHinhAnh.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void rdoSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoSizeMouseClicked
        LoadDataTableSize();
    }//GEN-LAST:event_rdoSizeMouseClicked

    private void rdoMAUSACMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoMAUSACMouseClicked
        LoadDataTableMau();
    }//GEN-LAST:event_rdoMAUSACMouseClicked

    private void rdoHANGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoHANGMouseClicked
        LoadDataTableHang();
    }//GEN-LAST:event_rdoHANGMouseClicked

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        try {
            ShowThuocTinh();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu vui lòng kiểm tra");
        }
    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void rdoLOAISANPHAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoLOAISANPHAMMouseClicked
        LoadDataTableLoaiSP();
    }//GEN-LAST:event_rdoLOAISANPHAMMouseClicked

    private void btnTHEMTHUOCTINHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTHEMTHUOCTINHActionPerformed
        if (rdoMAUSAC.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                MauSac mau = getFORMINPUTMAU();
                if (serviceMau.addMauSac(mau) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính màu thành công");
                    LoadDataTableMau();
                    LoadDataComboMau();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính màu bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm thuộc tính màu bị lỗi");
            }
        } else if (rdoSize.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                SizeSP size = getFORMINPUTSIZE();
                if (serviceSize.addSizeSP(size) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính size thành công");
                    LoadDataTableSize();
                    LoadDataComboSize();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính size bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm thuộc tính size bị lỗi");
            }
        } else if (rdoLOAISANPHAM.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                LoaiSanPham loai = getFORMINPUTLoaiSanPham();
                if (serviceLoaiSP.addLoaiSanPham(loai) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính loại sản phẩm thành công");
                    LoadDataTableLoaiSP();
                    LoadDataTableLoaiSP();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính loại sản phẩm bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm thuộc tính loại sản phẩm bị lỗi");
            }
        } else if (rdoHANG.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                HangSX hang = getFORMINPUTHang();
                if (serviceHang.addHangSX(hang) != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính hãng sản xuất thành công");
                    LoadDataTableHang();
                    LoadDataComboHang();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thuộc tính hãng sản xuất bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Thêm thuộc tính hãng sản xuất bị lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một loại thuộc tính.");
        }
        btnCLEARFORMTHUOCTINHActionPerformed(evt);
    }//GEN-LAST:event_btnTHEMTHUOCTINHActionPerformed

    private void btnSUATHUOCTINHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSUATHUOCTINHActionPerformed
        if (rdoMAUSAC.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                MauSac mau = getFORMINPUTMAU();
                if (serviceMau.updateMauSac(mau) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính màu thành công");
                    LoadDataTableMau();
                    LoadDataComboMau();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính màu bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Sửa thuộc tính màu bị lỗi");
            }
        } else if (rdoSize.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                SizeSP size = getFORMINPUTSIZE();
                if (serviceSize.updateSize(size) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính size thành công");
                    LoadDataTableSize();
                    LoadDataComboSize();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính size bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Sửa thuộc tính size bị lỗi");
            }
        } else if (rdoLOAISANPHAM.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                LoaiSanPham loai = getFORMINPUTLoaiSanPham();
                if (serviceLoaiSP.updateLoaiSanPham(loai) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính loại sản phẩm thành công");
                    LoadDataTableLoaiSP();
                    LoadDataTableLoaiSP();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính loại sản phẩm bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Sửa thuộc tính loại sản phẩm bị lỗi");
            }
        } else if (rdoHANG.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                HangSX hang = getFORMINPUTHang();
                if (serviceHang.updateHangSX(hang) != null) {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính hãng sản xuất thành công");
                    LoadDataTableHang();
                    LoadDataComboHang();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thuộc tính hãng sản xuất bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Sửa thuộc tính hãng sản xuất bị lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một loại thuộc tính.");
        }
        btnCLEARFORMTHUOCTINHActionPerformed(evt);
    }//GEN-LAST:event_btnSUATHUOCTINHActionPerformed

    private void btnXOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXOAActionPerformed
        if (rdoMAUSAC.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                String maMau = txtMATHUOCTINH.getText();
                if (serviceMau.deleteMauSac(maMau) != null) {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính màu thành công");
                    LoadDataTableMau();
                    LoadDataComboMau();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính màu bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thuộc tính màu bị lỗi");
            }
        } else if (rdoSize.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                String maSize = txtMATHUOCTINH.getText();
                if (serviceSize.deleteSizeSP(maSize) != null) {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính size thành công");
                    LoadDataTableSize();
                    LoadDataComboSize();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính size bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thuộc tính size bị lỗi");
            }
        } else if (rdoLOAISANPHAM.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                String maLoaiSP = txtMATHUOCTINH.getText();
                if (serviceLoaiSP.deleteLoaiSanPham(maLoaiSP) != null) {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính loại sản phẩm thành công");
                    LoadDataTableLoaiSP();
                    LoadDataComboLoaiSP();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính loại sản phẩm bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thuộc tính loại sản phẩm bị lỗi");
            }
        } else if (rdoHANG.isSelected()) {
            try {
                int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa thuộc tính này ?");
                if (chon != JOptionPane.YES_OPTION) {
                    return;
                }
                String maHang = txtMATHUOCTINH.getText();
                if (serviceHang.deleteHangSX(maHang) != null) {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính hãng sản xuất thành công");
                    LoadDataTableHang();
                    LoadDataComboHang();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thuộc tính hãng sản xuất bị lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thuộc tính hãng sản xuất bị lỗi");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một loại thuộc tính.");
        }
        btnCLEARFORMTHUOCTINHActionPerformed(evt);
    }//GEN-LAST:event_btnXOAActionPerformed

    private void btnCLEARFORMTHUOCTINHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARFORMTHUOCTINHActionPerformed
        txtMATHUOCTINH.setText("");
        txtTENTHUOCTINH.setText("");
    }//GEN-LAST:event_btnCLEARFORMTHUOCTINHActionPerformed

    private void btnSUASPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSUASPActionPerformed
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa sản phẩm này ?");
            if (chon != JOptionPane.YES_OPTION) {
                return;
            }
            if (txtMASP.getText().isEmpty() || txtTENSP.getText().isEmpty()
                    || txtGiaBan.getText().isEmpty() || txtGiaNhap.getText().isEmpty()
                    || txtSoLuong.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sản phẩm");
                return;
            }
            if (!isNumeric(txtGiaBan.getText()) || !isNumeric(txtGiaNhap.getText()) || !isNumeric(txtSoLuong.getText())) {
                JOptionPane.showMessageDialog(this, "Giá bán, giá nhập và số lượng phải là số");
                return;
            }
            SanPham sp = getFORMINPUT();
            if (service.updateSanPham(sp) != null) {
                JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công");
                LoadDataTableSP();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa sản phẩm thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Sửa bị lỗi vui lòng kiểm tra lại");
        }
        btnCLEARFORMActionPerformed(evt);
    }//GEN-LAST:event_btnSUASPActionPerformed

    private void btnCLEARFORMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLEARFORMActionPerformed
        txtMASP.setText("");
        txtTENSP.setText("");
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtMoTa.setText("");
        txtSoLuong.setText("");
        cboHANGSP.setSelectedIndex(0);
        cboLOAISP.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
    }//GEN-LAST:event_btnCLEARFORMActionPerformed

    private void btnTRANGTHAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTRANGTHAIActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblSANPHAM.getModel();
        List<Integer> selectedRows = new ArrayList<>();
        boolean updateSuccessfully = false;

        for (int i = 0; i < tblSANPHAM.getRowCount(); i++) {
            Boolean selected = (Boolean) model.getValueAt(i, 13);
            if (selected != null && selected) {
                selectedRows.add(i);
            }
        }
        if (!selectedRows.isEmpty()) {
            for (int selectedRow : selectedRows) {
                String MaSP = tblSANPHAM.getValueAt(selectedRow, 1).toString();
                boolean TrangThai = tblSANPHAM.getValueAt(selectedRow, 12).toString().equalsIgnoreCase("Còn hàng");
                boolean TrangThaiMoi = !TrangThai;

                SanPham selectedSanPham = new SanPham();
                selectedSanPham.setMaSP(MaSP);
                selectedSanPham.setTrangThai(TrangThaiMoi);

                SanPhamService service = new SanPhamService();
                Integer updateRows = service.updateTrangThai(selectedSanPham);
                if (updateRows != null && updateRows > 0) {
                    updateSuccessfully = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thất bại");
                    break;
                }
            }
            if (updateSuccessfully) {
                JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thành công");
                LoadDataTableSP();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một hàng để cập nhật trạng thái");
        }
    }//GEN-LAST:event_btnTRANGTHAIActionPerformed

    private void cboTRANGTHAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTRANGTHAIActionPerformed
        boolean trangThai;
        Object selectedItem = cboTRANGTHAI.getSelectedItem();
        if (selectedItem != null) {
            String tuKhoa = selectedItem.toString();
            if (tuKhoa.equalsIgnoreCase("Tất cả")) {
                LoadDataTableSP();
            } else {
                if (tuKhoa.equalsIgnoreCase("Còn hàng")) {
                    trangThai = true;
                } else if (tuKhoa.equalsIgnoreCase("Hết hàng")) {
                    trangThai = false;
                } else {
                    trangThai = rdoConHang.isSelected();
                }
                ArrayList<SanPham> ketQuaTimKiem = service.timKiemTrangThai(trangThai);
                tblmodel.setRowCount(0);
                int i = 1;
                for (SanPham sp : ketQuaTimKiem) {
                    tblmodel.addRow(new Object[]{i++, sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getIdLoaiSP().getTenLoaiSP(),
                        sp.getGiaBan(), sp.getGiaNhap(),
                        sp.getHinhAnh(), sp.getMoTa(),
                        sp.getSoluong(), sp.getIdMauSac().getMauSP(),
                        sp.getIdSize().getSizeSP(),
                        sp.getIdHang().getTenHangSX(),
                        sp.isTrangThai() ? "Còn hàng" : "Hết hàng"});
                }
            }
        }
    }//GEN-LAST:event_cboTRANGTHAIActionPerformed

    private void txtTIMKIEMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTIMKIEMKeyTyped
        String tuKhoa = txtTIMKIEM.getText().trim();
        ArrayList<SanPham> ketQuaTimKiem;
        if (tuKhoa.isEmpty()) {
            LoadDataTableSP();
        } else {
            SanPhamService service = new SanPhamService();
            ketQuaTimKiem = service.timKiemSanPham(tuKhoa);
            tblmodel.setRowCount(0);
            int i = 1;
            for (SanPham sp : ketQuaTimKiem) {
                tblmodel.addRow(new Object[]{i++, sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getIdLoaiSP().getTenLoaiSP(),
                    sp.getGiaBan(), sp.getGiaNhap(),
                    sp.getHinhAnh(), sp.getMoTa(),
                    sp.getSoluong(), sp.getIdMauSac().getMauSP(),
                    sp.getIdSize().getSizeSP(),
                    sp.getIdHang().getTenHangSX(),
                    sp.isTrangThai() ? "Còn hàng" : "Hết hàng"});
            }
        }
    }//GEN-LAST:event_txtTIMKIEMKeyTyped

    private void rdoHetHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHetHangActionPerformed

    }//GEN-LAST:event_rdoHetHangActionPerformed

    private void btnXUATFILEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXUATFILEActionPerformed
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet worksheet = workbook.createSheet("SanPhamData");
            XSSFRow row = null;
            Cell cell = null;
            row = worksheet.createRow(3);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("MÃ SẢN PHẨM");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("TÊN SẢN PHẨM");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("LOẠI SẢN PHẨM");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("GIÁ BÁN");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("GIÁ NHẬP");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("HÌNH ẢNH");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("MÔ TẢ");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("SỐ LƯỢNG");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("MÀU SẮC");

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("SIZE");

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("HÃNG");

            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("TRẠNG THÁI");

            for (int i = 0; i < list.size(); i++) {
                row = worksheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(list.get(i).getMaSP());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(list.get(i).getTenSP());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(list.get(i).getIdLoaiSP().getTenLoaiSP());

                cell = row.createCell(4, CellType.NUMERIC);
                cell.setCellValue(list.get(i).getGiaBan());

                cell = row.createCell(5, CellType.NUMERIC);
                cell.setCellValue(list.get(i).getGiaNhap());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(list.get(i).getHinhAnh());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(list.get(i).getMoTa());

                cell = row.createCell(8, CellType.NUMERIC);
                cell.setCellValue(list.get(i).getSoluong());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(list.get(i).getIdMauSac().getMauSP());

                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(list.get(i).getIdSize().getSizeSP());

                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue(list.get(i).getIdHang().getTenHangSX());

                cell = row.createCell(12, CellType.BOOLEAN);
                cell.setCellValue(list.get(i).isTrangThai() ? "Còn hàng" : "Hết hàng");
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (FileOutputStream fos = new FileOutputStream(fileToSave.getAbsolutePath() + ".xlsx")) {
                    workbook.write(fos);
                    JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel:\n" + headlessException.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel:\n" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnXUATFILEActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCLEARFORM;
    private javax.swing.JButton btnCLEARFORMTHUOCTINH;
    private javax.swing.JButton btnSUASP;
    private javax.swing.JButton btnSUATHUOCTINH;
    private javax.swing.JButton btnTHEMSP;
    private javax.swing.JButton btnTHEMTHUOCTINH;
    private javax.swing.JButton btnTRANGTHAI;
    private javax.swing.JButton btnXOA;
    private javax.swing.JButton btnXUATFILE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboHANGSP;
    private javax.swing.JComboBox<String> cboLOAISP;
    private javax.swing.JComboBox<MauSac> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboTRANGTHAI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoHANG;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JRadioButton rdoLOAISANPHAM;
    private javax.swing.JRadioButton rdoMAUSAC;
    private javax.swing.JRadioButton rdoSize;
    private javax.swing.JTable tblSANPHAM;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMASP;
    private javax.swing.JTextField txtMATHUOCTINH;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTENSP;
    private javax.swing.JTextField txtTENTHUOCTINH;
    private javax.swing.JTextField txtTIMKIEM;
    // End of variables declaration//GEN-END:variables
}
