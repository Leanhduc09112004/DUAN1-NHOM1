package VIEW;
//LDA
import MODEL.NhanVien;
import SERVICE.NhanVienService;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ViewNhanVien extends javax.swing.JFrame {

    private DefaultTableModel tblmodel = new DefaultTableModel();
    private NhanVienService service = new NhanVienService();
    private ArrayList<NhanVien> list;

    public ViewNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý nhân viên");
        cboTRANGTHAI.removeAllItems();
        cboTRANGTHAI.addItem("Tất cả");
        cboTRANGTHAI.addItem("Đang làm");
        cboTRANGTHAI.addItem("Đã nghỉ");
        cboCHUCVU.removeAllItems();
        cboCHUCVU.addItem("Tất cả");
        cboCHUCVU.addItem("Quản lí");
        cboCHUCVU.addItem("Nhân viên");
        tblmodel = (DefaultTableModel) tblNhanVien.getModel();
        LoadDataTableNhanVien();
        if (tblNhanVien.getRowCount() > 0) {
            tblNhanVien.setRowSelectionInterval(0, 0);
        }
        ShowNhanVien();
    }

    void LoadDataTableNhanVien() {
        tblmodel.setRowCount(0);
        int i = 1;
        list = service.getAll();
        for (NhanVien nv : list) {
            tblmodel.addRow(new Object[]{i++, nv.getMaNV(),
                nv.getHoTen(), nv.getGioiTinh() ? "Nam" : "Nữ",
                nv.getSĐT(), nv.getNgaySinh(),
                nv.getDiaChi(), nv.getEmail(),
                nv.getChucVu() ? "Quản lí" : "Nhân viên",
                nv.getTrangThai() ? "Đang làm" : "Đã nghỉ", nv.getMatKhau()});
        }
    }

    void ShowNhanVien() {
        int index = tblNhanVien.getSelectedRow();
        if (index != -1) {
            txtMaNV.setText(tblNhanVien.getValueAt(index, 1).toString());
            txtTenNV.setText(tblNhanVien.getValueAt(index, 2).toString());
            boolean gioitinh = tblNhanVien.getValueAt(index, 3).toString().equalsIgnoreCase("Nam") ? true : false;
            rdoNam.setSelected(gioitinh);
            rdoNu.setSelected(!gioitinh);
            txtSoDienThoai.setText(tblNhanVien.getValueAt(index, 4).toString());
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) tblmodel.getValueAt(index, 5).toString());
                JdateChooserNgaySinh.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(ViewNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtDiaChi.setText(tblNhanVien.getValueAt(index, 6).toString());
            txtEmail.setText(tblNhanVien.getValueAt(index, 7).toString());
            boolean vaitro = tblNhanVien.getValueAt(index, 8).toString().equalsIgnoreCase("Quản lí") ? true : false;
            rdoQuanLy.setSelected(vaitro);
            rdoNhanVien.setSelected(!vaitro);
            boolean trangthai = tblNhanVien.getValueAt(index, 9).toString().equalsIgnoreCase("Đang làm") ? true : false;
            rdoDangLam.setSelected(trangthai);
            rdoDaNghi.setSelected(!trangthai);
            txtMatKhau.setText(tblNhanVien.getValueAt(index, 10).toString());
        }
    }

    private NhanVien getFORMINPUT() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText());
        nv.setHoTen(txtTenNV.getText());
        nv.setGioiTinh(rdoNam.isSelected() ? true : false);
        nv.setSĐT(txtSoDienThoai.getText());
        try {
            SimpleDateFormat input = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date date = input.parse(JdateChooserNgaySinh.getDate().toString());
            SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = output.format(date);
            nv.setNgaySinh(output.parse(formattedDate));
        } catch (ParseException ex) {
            Logger.getLogger(ViewNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        nv.setDiaChi(txtDiaChi.getText());
        nv.setEmail(txtEmail.getText());
        nv.setMatKhau(txtMatKhau.getText());
        nv.setChucVu(rdoQuanLy.isSelected());
        nv.setTrangThai(rdoDangLam.isSelected());
        return nv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        txtTIMKIEMMANV = new javax.swing.JTextField();
        btnTrangThai = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        cboTRANGTHAI = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cboCHUCVU = new javax.swing.JComboBox<>();
        jPanel38 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        btnExport = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        rdoDangLam = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        rdoDaNghi = new javax.swing.JRadioButton();
        JdateChooserNgaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM MÃ NV\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        txtTIMKIEMMANV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTIMKIEMMANVActionPerformed(evt);
            }
        });
        txtTIMKIEMMANV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTIMKIEMMANVKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTIMKIEMMANV, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addComponent(txtTIMKIEMMANV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTrangThai.setText("CHUYỂN TRẠNG THÁI");
        btnTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangThaiActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ Tên", "Giới Tính", "SĐT", "Ngày Sinh", "Địa chỉ", "Email", "Chức Vụ", "Trạng Thái", "Mật Khẩu", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tblNhanVien);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRẠNG THÁI\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        cboTRANGTHAI.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboTRANGTHAI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTRANGTHAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTRANGTHAIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboTRANGTHAI, 0, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cboTRANGTHAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHỨC VỤ\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        cboCHUCVU.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboCHUCVU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboCHUCVU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCHUCVUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboCHUCVU, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(cboCHUCVU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnTrangThai)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("DANH SÁCH NHÂN VIÊN", jPanel41);

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setText("Mã nhân viên");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setText("Tên nhân viên");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setText("Giới tính");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel65.setText("Số điện thoại");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel66.setText("Vai trò");

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNu.setText("Nữ");

        buttonGroup2.add(rdoQuanLy);
        rdoQuanLy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoQuanLy.setText("Quản lý");

        buttonGroup2.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoNhanVien.setText("Nhân viên");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setText("Địa Chỉ");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setText("Trạng Thái ");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setText("Email");

        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnExport.setText("EXPORT");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnMoi.setText("CLEAR");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExport, btnMoi, btnSua, btnThem});

        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnMoi)
                    .addComponent(btnExport))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel39Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnExport, btnMoi, btnSua, btnThem});

        buttonGroup3.add(rdoDangLam);
        rdoDangLam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDangLam.setText("Đang Làm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Ngày Sinh");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mật Khẩu");

        buttonGroup3.add(rdoDaNghi);
        rdoDaNghi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDaNghi.setText("Đã Nghỉ");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addComponent(rdoQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMatKhau))))
                .addGap(110, 110, 110)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel68)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel38Layout.createSequentialGroup()
                                    .addComponent(rdoDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoDaNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(JdateChooserNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoDangLam)
                            .addComponent(rdoDaNghi))))
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoQuanLy)
                            .addComponent(rdoNhanVien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addGroup(jPanel38Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JdateChooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel38, jTabbedPane4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel38, jTabbedPane4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn thêm nhân viên này ?");
            if (chon != JOptionPane.YES_OPTION) {
                return;
            }
            if (txtMaNV.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên");
                return;
            }
            if (txtTenNV.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên");
                return;
            }
            if (!txtSoDienThoai.getText().matches("^0\\d{9}$")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                return;
            }
            if (txtSoDienThoai.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
                return;
            }
            if (txtSoDienThoai.getText().length() != 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số");
                return;
            }
            String email = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!txtEmail.getText().matches(email)) {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ");
                return;
            }
            if (txtDiaChi.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền địa chỉ");
                return;
            }
            if (txtMatKhau.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền mật khẩu");
                return;
            }
            if (txtMatKhau.getText().length() < 5) {
                JOptionPane.showMessageDialog(this, "Mật khẩu gồm 5 ký tự trở lên");
                return;
            }
            if (JdateChooserNgaySinh.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
                return;
            }
            NhanVien nv = getFORMINPUT();
            if (service.addNhanVien(nv) != null) {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                LoadDataTableNhanVien();
                sendEmail(nv);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại do lỗi dữ liệu");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi thêm dữ liệu kiểm tra lại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void sendEmail(NhanVien nv) {
        final String username = "leducanh09112004@gmail.com";
        final String password = "ulqh stzj wupo ttcb";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nv.getEmail()));
            message.setSubject("Thông báo nhân viên mới");
            message.setText("Thông tin nhân viên mới:\nMã nhân viên (Tài khoản đăng nhập): " + nv.getMaNV() + "\nMật khẩu: " + nv.getMatKhau() + "\nTrạng thái: " + String.valueOf(nv.getTrangThai() ? "Đang làm" : "Đã nghỉ"));
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Đã gửi email thành công");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    private void btnTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangThaiActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        List<Integer> selectedRows = new ArrayList<>();
        boolean updatedSuccessfully = false;

        for (int i = 0; i < tblNhanVien.getRowCount(); i++) {
            Boolean selected = (Boolean) model.getValueAt(i, 11);
            if (selected != null && selected) {
                selectedRows.add(i);
            }
        }

        if (!selectedRows.isEmpty()) {
            for (int selectedRow : selectedRows) {
                String maNV = tblmodel.getValueAt(selectedRow, 1).toString();
                boolean trangThai = tblmodel.getValueAt(selectedRow, 9).toString().equalsIgnoreCase("Đang làm");
                boolean trangThaiMoi = !trangThai;

                NhanVien selectedNhanVien = new NhanVien();
                selectedNhanVien.setMaNV(maNV);
                selectedNhanVien.setTrangThai(trangThaiMoi);

                NhanVienService service = new NhanVienService();
                Integer updatedRows = service.updateTrangThai(selectedNhanVien);

                if (updatedRows != null && updatedRows > 0) {
                    updatedSuccessfully = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thất bại");
                    break;
                }
            }
            if (updatedSuccessfully) {
                JOptionPane.showMessageDialog(this, "Cập nhật trạng thái thành công");
                LoadDataTableNhanVien();
                sendUpdateEmail(selectedRows);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một hàng để cập nhật trạng thái");
        }
        btnMoiActionPerformed(evt);
    }//GEN-LAST:event_btnTrangThaiActionPerformed
    private void sendUpdateEmail(List<Integer> selectedRows) {
        final String username = "leducanh09112004@gmail.com";
        final String password = "ulqh stzj wupo ttcb";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            for (int selectedRow : selectedRows) {
                String maNV = tblmodel.getValueAt(selectedRow, 1).toString();
                String email = tblmodel.getValueAt(selectedRow, 7).toString();
                boolean trangThai = tblmodel.getValueAt(selectedRow, 9).toString().equalsIgnoreCase("Đang làm");
                String trangThaiCu = trangThai ? "Đang làm" : "Đã nghỉ";
                String trangThaiMoi = trangThai ? "Đã nghỉ" : "Đang làm";

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(username));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                message.setSubject("Thông báo cập nhật trạng thái");
                message.setText("Trạng thái nhân viên với mã " + maNV + " đã được cập nhật từ " + trangThaiCu + " thành " + trangThaiMoi + ".");

                Transport.send(message);
            }

            JOptionPane.showMessageDialog(this, "Đã gửi email cập nhật trạng thái thành công");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        try {
            ShowNhanVien();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu vui lòng kiểm tra lại");
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa nhân viên này ?");
            if (chon != JOptionPane.YES_OPTION) {
                return;
            }
            if (txtMaNV.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên");
                return;
            }
            if (txtTenNV.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên");
                return;
            }
            if (!txtSoDienThoai.getText().matches("^0\\d{9}$")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                return;
            }
            if (txtSoDienThoai.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại");
                return;
            }
            if (txtSoDienThoai.getText().length() != 10) {
                JOptionPane.showMessageDialog(this, "Số điện thoại gồm 10 số");
                return;
            }
            String email = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!txtEmail.getText().matches(email)) {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ");
                return;
            }
            if (txtDiaChi.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền địa chỉ");
                return;
            }
            if (txtMatKhau.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền mật khẩu");
                return;
            }
            if (txtMatKhau.getText().length() < 5) {
                JOptionPane.showMessageDialog(this, "Mật khẩu gồm 5 ký tự trở lên");
                return;
            }
            if (JdateChooserNgaySinh.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh");
                return;
            }
            NhanVien nv = getFORMINPUT();
            if (service.updateNhanVien(nv) != null) {
                JOptionPane.showMessageDialog(this, "Sửa dữ liệu nhân viên thành công");
                LoadDataTableNhanVien();
                sendUpdateEmail(nv);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa dữ liệu thất bại vui lòng kiểm tra lại");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi sửa dữ liệu vui lòng kiểm tra lại");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void sendUpdateEmail(NhanVien nv) {
        final String username = "leducanh09112004@gmail.com";
        final String password = "ulqh stzj wupo ttcb";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            String recipientEmail = nv.getEmail();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Thông báo sửa đổi thông tin nhân viên");
            message.setText("Thông tin nhân viên đã được sửa đổi:\nMã nhân viên (Tài khoản đăng nhập): " + nv.getMaNV() + "\nMật khẩu: " + nv.getMatKhau() + "\nTrạng thái: " + String.valueOf(nv.getTrangThai() ? "Đang làm" : "Đã nghỉ"));
            Transport.send(message);

            JOptionPane.showMessageDialog(this, "Đã gửi email thông báo sửa đổi thành công");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtSoDienThoai.setText("");
        txtEmail.setText("");
        txtMatKhau.setText("");
        txtDiaChi.setText("");
        rdoDangLam.setSelected(true);
        rdoNam.setSelected(true);
        rdoNhanVien.setSelected(true);
        JdateChooserNgaySinh.setDate(null);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void txtTIMKIEMMANVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTIMKIEMMANVKeyTyped
        String tuKhoa = txtTIMKIEMMANV.getText();
        ArrayList<NhanVien> ketQuaTimKiem;
        if (tuKhoa.isEmpty()) {
            LoadDataTableNhanVien();
        } else {
            ketQuaTimKiem = service.timKiemNhanVien(tuKhoa);

            tblmodel.setRowCount(0);
            int x = 1;
            for (NhanVien nv : ketQuaTimKiem) {
                tblmodel.addRow(new Object[]{x++, nv.getMaNV(),
                    nv.getHoTen(), nv.getGioiTinh() ? "Nam" : "Nữ",
                    nv.getSĐT(), nv.getNgaySinh(),
                    nv.getDiaChi(), nv.getEmail(),
                    nv.getChucVu() ? "Quản lí" : "Nhân viên",
                    nv.getTrangThai() ? "Đang làm" : "Đã nghỉ",
                    nv.getMatKhau()});
            }
        }
    }//GEN-LAST:event_txtTIMKIEMMANVKeyTyped

    private void cboTRANGTHAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTRANGTHAIActionPerformed
        boolean trangThai;
        boolean chucVu;
        Object selectedItem = cboTRANGTHAI.getSelectedItem();
        Object selectedItem2 = cboCHUCVU.getSelectedItem();
        if (selectedItem != null && selectedItem2 != null) {
            String tuKhoa = selectedItem.toString();
            String tuKhoa2 = selectedItem2.toString();
            if (tuKhoa.equalsIgnoreCase("Tất cả") && tuKhoa2.equalsIgnoreCase("Tất cả")) {
                LoadDataTableNhanVien();
            } else {
                if (tuKhoa.equalsIgnoreCase("Đang làm") && tuKhoa2.equalsIgnoreCase("Quản lí")) {
                    trangThai = true;
                    chucVu = true;
                } else if (tuKhoa.equalsIgnoreCase("Đã nghỉ") && tuKhoa2.equalsIgnoreCase("Quản lí")) {
                    trangThai = false;
                    chucVu = true;
                } else if (tuKhoa.equalsIgnoreCase("Đang làm") && tuKhoa2.equalsIgnoreCase("Nhân viên")) {
                    trangThai = true;
                    chucVu = false;
                } else if (tuKhoa.equalsIgnoreCase("Đã nghỉ") && tuKhoa2.equalsIgnoreCase("Nhân viên")) {
                    trangThai = false;
                    chucVu = false;
                } else {
                    trangThai = rdoDangLam.isSelected();
                    chucVu = rdoQuanLy.isSelected();
                }

                ArrayList<NhanVien> ketQuaTimKiem = service.timKiemNhanVienTheoDieuKien(trangThai, chucVu);
                tblmodel.setRowCount(0);
                int i = 1;

                for (NhanVien nv : ketQuaTimKiem) {
                    tblmodel.addRow(new Object[]{i++, nv.getMaNV(),
                        nv.getHoTen(), nv.getGioiTinh() ? "Nam" : "Nữ",
                        nv.getSĐT(), nv.getNgaySinh(),
                        nv.getDiaChi(), nv.getEmail(),
                        nv.getChucVu() ? "Quản lí" : "Nhân viên",
                        nv.getTrangThai() ? "Đang làm" : "Đã nghỉ",
                        nv.getMatKhau()});
                }
            }
        }
    }//GEN-LAST:event_cboTRANGTHAIActionPerformed

    private void cboCHUCVUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCHUCVUActionPerformed
        boolean trangThai;
        boolean chucVu;
        Object selectedItem = cboTRANGTHAI.getSelectedItem();
        Object selectedItem2 = cboCHUCVU.getSelectedItem();
        if (selectedItem != null && selectedItem2 != null) {
            String tuKhoa = selectedItem.toString();
            String tuKhoa2 = selectedItem2.toString();
            if (tuKhoa.equalsIgnoreCase("Tất cả") && tuKhoa2.equalsIgnoreCase("Tất cả")) {
                LoadDataTableNhanVien();
            } else {
                if (tuKhoa.equalsIgnoreCase("Đang làm") && tuKhoa2.equalsIgnoreCase("Quản lí")) {
                    trangThai = true;
                    chucVu = true;
                } else if (tuKhoa.equalsIgnoreCase("Đã nghỉ") && tuKhoa2.equalsIgnoreCase("Quản lí")) {
                    trangThai = false;
                    chucVu = true;
                } else if (tuKhoa.equalsIgnoreCase("Đang làm") && tuKhoa2.equalsIgnoreCase("Nhân viên")) {
                    trangThai = true;
                    chucVu = false;
                } else if (tuKhoa.equalsIgnoreCase("Đã nghỉ") && tuKhoa2.equalsIgnoreCase("Nhân viên")) {
                    trangThai = false;
                    chucVu = false;
                } else {
                    trangThai = rdoDangLam.isSelected();
                    chucVu = rdoQuanLy.isSelected();
                }

                ArrayList<NhanVien> ketQuaTimKiem = service.timKiemNhanVienTheoDieuKien(trangThai, chucVu);
                tblmodel.setRowCount(0);
                int i = 1;

                for (NhanVien nv : ketQuaTimKiem) {
                    tblmodel.addRow(new Object[]{i++, nv.getMaNV(),
                        nv.getHoTen(), nv.getGioiTinh() ? "Nam" : "Nữ",
                        nv.getSĐT(), nv.getNgaySinh(),
                        nv.getDiaChi(), nv.getEmail(),
                        nv.getChucVu() ? "Quản lí" : "Nhân viên",
                        nv.getTrangThai() ? "Đang làm" : "Đã nghỉ",
                        nv.getMatKhau()});
                }
            }
        }
    }//GEN-LAST:event_cboCHUCVUActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet worksheet = workbook.createSheet("NhanVienData");
            XSSFRow row = null;
            Cell cell = null;
            row = worksheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("MÃ NHÂN VIÊN");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("HỌ TÊN");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("GIỚI TÍNH");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("SĐT");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("NGÀY SINH");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("ĐỊA CHỈ");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("EMAIL");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("CHỨC VỤ");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("TRẠNG THÁI");

            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue("MẬT KHẨU");
            for (int i = 0; i < list.size(); i++) {
                row = worksheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(list.get(i).getMaNV());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(list.get(i).getHoTen());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(list.get(i).getSĐT());

                cell = row.createCell(3, CellType.BOOLEAN);
                cell.setCellValue(list.get(i).getGioiTinh() ? "Nam" : "Nữ");

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(String.valueOf(list.get(i).getNgaySinh()));

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(list.get(i).getDiaChi());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(list.get(i).getEmail());

                cell = row.createCell(8, CellType.BOOLEAN);
                cell.setCellValue(list.get(i).getChucVu() ? "Quản lí" : "Nhân viên");

                cell = row.createCell(9, CellType.BOOLEAN);
                cell.setCellValue(list.get(i).getTrangThai() ? "Đang làm" : "Đã nghỉ");

                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue(list.get(i).getMatKhau());
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
    }//GEN-LAST:event_btnExportActionPerformed

    private void txtTIMKIEMMANVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTIMKIEMMANVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTIMKIEMMANVActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JdateChooserNgaySinh;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTrangThai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cboCHUCVU;
    private javax.swing.JComboBox<String> cboTRANGTHAI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JRadioButton rdoDaNghi;
    private javax.swing.JRadioButton rdoDangLam;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTIMKIEMMANV;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
