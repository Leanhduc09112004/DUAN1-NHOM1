
package VIEW;

import MODEL.LoaiSanPham;
import MODEL.ThongKe;
import SERVICE.LoaiSanPhamService;
import SERVICE.ThongKeService;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
public class ViewThongKe extends javax.swing.JFrame {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    ThongKeService service = new ThongKeService();
    ArrayList<ThongKe> list;

    DefaultTableModel mol = new DefaultTableModel();

    DefaultComboBoxModel<LoaiSanPham> molLoaiGiay = new DefaultComboBoxModel<>();
    ArrayList<LoaiSanPham> listLoaiGiay;
    LoaiSanPhamService serviceLoaiGiay = new LoaiSanPhamService();

    public static final int column_index_loaiSP = 0;
    public static final int column_index_maSP = 1;
    public static final int column_index_tenSP = 2;
    public static final int column_index_soLuong = 3;
    public static final int column_index_giaBan = 4;
    public static final int column_index_doanhThu = 5;

    public ViewThongKe() {
        initComponents();
        fillThongKe();

        mol = (DefaultTableModel) tblSP.getModel();
        fillSP();

        molLoaiGiay = (DefaultComboBoxModel) cboLoaiGiay.getModel();
        fillCboLoaiGiay();

        setDataToChart(jPanelDoanhThu);
        setLocationRelativeTo(null);

    }

    void fillThongKe() {
        Date start = java.sql.Date.valueOf("2023-01-01");
        Date end = java.sql.Date.valueOf("2024-12-12");

        dateBatDau.setDate(java.sql.Date.valueOf("2023-01-01"));
        dateKetThuc.setDate(java.sql.Date.valueOf("2023-11-30"));

        int doanhThu = service.getTongDoanhThu((java.sql.Date) start, (java.sql.Date) end);
        txtDoanhThu.setText(formatMoney(doanhThu) + " Đ");

        int tongHoaDon = service.getTongHoaDon((java.sql.Date) start, (java.sql.Date) end);
        txtTongHD.setText(String.valueOf(tongHoaDon));

        int tongSanPham = service.getTongSanPham((java.sql.Date) start, (java.sql.Date) end);
        txtTongSP.setText(String.valueOf(tongSanPham));
    }

    void fillSP() {
        mol.setRowCount(0);
        list = service.getSP("");
        for (ThongKe x : list) {
            int gia = (int) Math.round(x.getGiaBan().getGiaBan());
            mol.addRow(new Object[]{
                x.getTenLoaiSP().getTenLoaiSP(), x.getMaSP().getMaSP(),
                x.getTenSP().getTenSP(), x.getTongSP(), gia + " vnđ",
                x.getTongDTSP()
            });
        }
    }

    void fillCboLoaiGiay() {
        cboLoaiGiay.removeAllItems();
        cboLoaiGiay.addItem("Tất cả");
        listLoaiGiay = serviceLoaiGiay.getAll2();
        for (LoaiSanPham x : listLoaiGiay) {
            cboLoaiGiay.addItem(x.getTenLoaiSP());
        }

        cboThang.removeAllItems();
//        cboThang.addItem("Tất cả");
        for (int i = 1; i < 13; i++) {
            cboThang.addItem(String.valueOf(i));
        }

        cboNam.removeAllItems();
        cboNam.addItem("Tất cả");
        for (int i = 2022; i < 2024; i++) {
            cboNam.addItem(String.valueOf(i));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        txtTongHD = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        txtTongSP = new javax.swing.JLabel();
        btnXuatFile = new javax.swing.JButton();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel52 = new javax.swing.JPanel();
        jPanelDoanhThu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cboThang = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        cboNam = new javax.swing.JComboBox<>();
        jPanel53 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        cboLoaiGiay = new javax.swing.JComboBox<>();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateBatDau = new com.toedter.calendar.JDateChooser();
        dateKetThuc = new com.toedter.calendar.JDateChooser();
        btnLoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel35.setBackground(new java.awt.Color(255, 255, 204));
        jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setText("DOANH THU");

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel36.setBackground(new java.awt.Color(204, 255, 153));
        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel52.setText("SỐ HÓA ĐƠN");

        txtTongHD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(txtTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel37.setBackground(new java.awt.Color(204, 204, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel61.setText("TỔNG SẢN PHẨM");

        txtTongSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txtTongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        jTabbedPane8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));

        jPanelDoanhThu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelDoanhThuLayout = new javax.swing.GroupLayout(jPanelDoanhThu);
        jPanelDoanhThu.setLayout(jPanelDoanhThuLayout);
        jPanelDoanhThuLayout.setHorizontalGroup(
            jPanelDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
        );
        jPanelDoanhThuLayout.setVerticalGroup(
            jPanelDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo tháng"));

        cboThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo năm"));

        cboNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Doanh thu", jPanel52);

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));
        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại giày"));
        jPanel55.setForeground(new java.awt.Color(255, 204, 204));
        jPanel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cboLoaiGiay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiGiayItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboLoaiGiay, 0, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(cboLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Loại sản phẩm", "Mã sản phẩm", "Tên sản phẩm", "Số lượng bán", "Giá bán", "Doanh thu"
            }
        ));
        jScrollPane16.setViewportView(tblSP);
        if (tblSP.getColumnModel().getColumnCount() > 0) {
            tblSP.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Sản phẩm", jPanel53);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo khoảng thời gian"));

        jLabel1.setText("Từ");

        jLabel2.setText("Đến");

        dateBatDau.setDateFormatString("dd-MM-yyyy");

        dateKetThuc.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dateKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoc))
                        .addGap(53, 53, 53)
                        .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiGiayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiGiayItemStateChanged
        changeCboLoaiGiay();
    }//GEN-LAST:event_cboLoaiGiayItemStateChanged

    void changeCboLoaiGiay() {
        String tenLoaiSP = cboLoaiGiay.getSelectedItem().toString();
        if (tenLoaiSP.equalsIgnoreCase("Tất cả")) {
            tenLoaiSP = "";
        }

        java.sql.Date start = null;
        java.sql.Date end = null;
        if (dateBatDau.getDate() != null || dateKetThuc.getDate() != null) {
            start = new java.sql.Date(dateBatDau.getDate().getTime());
            end = new java.sql.Date(dateKetThuc.getDate().getTime());
        }

        mol.setRowCount(0);
        list = service.getSP2(tenLoaiSP, start, end);
        for (ThongKe x : list) {
            int gia = (int) Math.round(x.getGiaBan().getGiaBan());
            mol.addRow(new Object[]{
                x.getTenLoaiSP().getTenLoaiSP(), x.getMaSP().getMaSP(),
                x.getTenSP().getTenSP(), x.getTongSP(), gia + " vnđ",
                x.getTongDTSP()
            });
        }

    }
    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        java.sql.Date start = null;
        java.sql.Date end = null;
        if (dateBatDau.getDate() == null || dateKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(new JFrame(), "Ngày không được để trống", "Dialog", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (dateBatDau.getDate() != null || dateKetThuc.getDate() != null) {
            start = new java.sql.Date(dateBatDau.getDate().getTime());
            end = new java.sql.Date(dateKetThuc.getDate().getTime());
        }
        Integer tongDoanhThu = service.getTongDoanhThu(start, end);
        txtDoanhThu.setText(formatMoney(tongDoanhThu) + " Đ");

        int tongHoaDon = service.getTongHoaDon(start, end);
        txtTongHD.setText(String.valueOf(tongHoaDon));

        int tongSanPham = service.getTongSanPham(start, end);
        txtTongSP.setText(String.valueOf(tongSanPham));

        changeCboLoaiGiay();
        setDataToChart(jPanelDoanhThu);

    }//GEN-LAST:event_btnLocActionPerformed

    private void cboThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangItemStateChanged
        // TODO add your handling code here:
        setDataToChart2(jPanelDoanhThu);

    }//GEN-LAST:event_cboThangItemStateChanged

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        String tenLoaiSP = cboLoaiGiay.getSelectedItem().toString();
        if (tenLoaiSP.equalsIgnoreCase("Tất cả")) {
            tenLoaiSP = "";
        }
        java.sql.Date start = null;
        java.sql.Date end = null;
        if (dateBatDau.getDate() != null || dateKetThuc.getDate() != null) {
            start = new java.sql.Date(dateBatDau.getDate().getTime());
            end = new java.sql.Date(dateKetThuc.getDate().getTime());
        }
        list = service.getSP2(tenLoaiSP, start, end);
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(1);
             cell = row.createCell(0);
            cell.setCellValue("STT");
            
            cell = row.createCell(1);
            cell.setCellValue("Loại sản phẩm");

            cell = row.createCell(2 );
            cell.setCellValue("Mã sản phẩm");

            cell = row.createCell(3);
            cell.setCellValue("Tên sản phẩm");

            cell = row.createCell(4);
            cell.setCellValue("Số lượng đã bán");

            cell = row.createCell(5);
            cell.setCellValue("Giá bán");

            cell = row.createCell(6);
            cell.setCellValue("Doanh thu");
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 2);

                cell = row.createCell(0,CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1,CellType.NUMERIC);
                cell.setCellValue(list.get(i).getTenLoaiSP().getTenLoaiSP());

                cell = row.createCell(2,CellType.STRING);
                cell.setCellValue(list.get(i).getMaSP().getMaSP());

                cell = row.createCell(3,CellType.STRING);
                cell.setCellValue( list.get(i).getTenSP().getTenSP());

                cell = row.createCell(4,CellType.NUMERIC);
                cell.setCellValue(list.get(i).getTongSP());

                cell = row.createCell(5,CellType.NUMERIC);
                cell.setCellValue(list.get(i).getGiaBan().getGiaBan());

                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue(list.get(i).getTongDTSP());
            }
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try (FileOutputStream fos = new FileOutputStream(fileToSave.getAbsolutePath() + ".xlsx")) {
                    wordkbook.write(fos);
                    JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException headlessException) {
                    headlessException.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel:\n" + headlessException.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }    
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void cboNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNamItemStateChanged

    void setDataToChart(JPanel jpanel) {
        java.sql.Date start = null;
        java.sql.Date end = null;
        if (dateBatDau.getDate() != null || dateKetThuc.getDate() != null) {
            start = new java.sql.Date(dateBatDau.getDate().getTime());
            end = new java.sql.Date(dateKetThuc.getDate().getTime());
        }
        list = service.getDoanhThu1(start, end);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (ThongKe x : list) {
                dataset.addValue(x.getTongDT(), "Doanh thu", x.getNgayThanhToan());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê doanh thu theo thời gian".toUpperCase(),
                "Thời gian", "Tổng doanh thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanelDoanhThu.getWidth(), 321));

        jPanelDoanhThu.removeAll();
        jPanelDoanhThu.setLayout(new CardLayout());
        jPanelDoanhThu.add(chartPanel);
        jPanelDoanhThu.validate();
        jPanelDoanhThu.repaint();

    }

    void setDataToChart2(JPanel jpanel) {

        int month = Integer.parseInt(cboThang.getSelectedItem().toString());

        list = service.getDoanhThu2(month);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (ThongKe x : list) {
                dataset.addValue(x.getTongDT(), "Doanh thu", x.getNgayThanhToan());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê doanh thu theo thời gian".toUpperCase(),
                "Thời gian", "Tổng doanh thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanelDoanhThu.getWidth(), 321));

        jPanelDoanhThu.removeAll();
        jPanelDoanhThu.setLayout(new CardLayout());
        jPanelDoanhThu.add(chartPanel);
        jPanelDoanhThu.validate();
        jPanelDoanhThu.repaint();

    }

    void setDataToChart3(JPanel jpanel) {

        int year = Integer.parseInt(cboNam.getSelectedItem().toString());

        list = service.getDoanhThu3(year);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (list != null) {
            for (ThongKe x : list) {
//                dataset.addValue(x.getTongDT().intValue(), "Doanh thu", x.getThangThanhToan());
            }
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ thống kê doanh thu theo thời gian".toUpperCase(),
                "Thời gian", "Tổng doanh thu",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jPanelDoanhThu.getWidth(), 321));

        jPanelDoanhThu.removeAll();
        jPanelDoanhThu.setLayout(new CardLayout());
        jPanelDoanhThu.add(chartPanel);
        jPanelDoanhThu.validate();
        jPanelDoanhThu.repaint();
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThongKe().setVisible(true);
            }
        });
    }

    public String formatMoney(int money) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(money);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cboLoaiGiay;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboThang;
    private com.toedter.calendar.JDateChooser dateBatDau;
    private com.toedter.calendar.JDateChooser dateKetThuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanelDoanhThu;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTable tblSP;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JLabel txtTongHD;
    private javax.swing.JLabel txtTongSP;
    // End of variables declaration//GEN-END:variables

}
