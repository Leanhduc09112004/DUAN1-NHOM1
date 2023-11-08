package VIEW;
public class ViewLogin extends javax.swing.JFrame {
    public ViewLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("CHILL AND FREE");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTITLE = new javax.swing.JLabel();
        txtTENTAIKHOAN = new javax.swing.JTextField();
        txtMATKHAU = new javax.swing.JPasswordField();
        lblTENTAIKHOAN = new javax.swing.JLabel();
        lblMATKHAU = new javax.swing.JLabel();
        btnDANGNHAP = new javax.swing.JButton();
        btnTHOAT = new javax.swing.JButton();
        btnQUENMATKHAU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoda.png"))); // NOI18N

        lblTITLE.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTITLE.setForeground(new java.awt.Color(0, 0, 255));
        lblTITLE.setText("ĐĂNG NHẬP");

        lblTENTAIKHOAN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTENTAIKHOAN.setText("TÊN TÀI KHOẢN");

        lblMATKHAU.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMATKHAU.setText("MẬT KHẨU ");

        btnDANGNHAP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDANGNHAP.setText("ĐĂNG NHẬP");

        btnTHOAT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTHOAT.setText("THOÁT");

        btnQUENMATKHAU.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQUENMATKHAU.setText("QUÊN MẬT KHẨU");
        btnQUENMATKHAU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQUENMATKHAUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(148, 148, 148))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDANGNHAP)
                        .addGap(18, 18, 18)
                        .addComponent(btnQUENMATKHAU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTHOAT)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTENTAIKHOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTENTAIKHOAN, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lblTITLE, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(93, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDANGNHAP, btnQUENMATKHAU, btnTHOAT});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTITLE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTENTAIKHOAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTENTAIKHOAN))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMATKHAU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDANGNHAP)
                    .addComponent(btnTHOAT)
                    .addComponent(btnQUENMATKHAU))
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDANGNHAP, btnQUENMATKHAU, btnTHOAT});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQUENMATKHAUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQUENMATKHAUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQUENMATKHAUActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDANGNHAP;
    private javax.swing.JButton btnQUENMATKHAU;
    private javax.swing.JButton btnTHOAT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMATKHAU;
    private javax.swing.JLabel lblTENTAIKHOAN;
    private javax.swing.JLabel lblTITLE;
    private javax.swing.JPasswordField txtMATKHAU;
    private javax.swing.JTextField txtTENTAIKHOAN;
    // End of variables declaration//GEN-END:variables
}
