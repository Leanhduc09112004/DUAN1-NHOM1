package VIEW;

import java.awt.Color;

public class ViewQuenMatKhau extends javax.swing.JFrame {
    public ViewQuenMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("QUÊN MẬT KHẨU");
        setBackground(Color.green);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMATKHAUCU = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMATKHAUMOI = new javax.swing.JPasswordField();
        txtXACNHANMATKHAU = new javax.swing.JPasswordField();
        btnXACNHAN = new javax.swing.JButton();
        btnDANGNHAP = new javax.swing.JButton();
        btnTHOAT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoda.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("MẬT KHẨU CŨ ");

        txtMATKHAUCU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMATKHAUCUActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("MẬT KHẨU MỚI ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("XÁC NHẬN MẬT KHẨU ");

        btnXACNHAN.setBackground(new java.awt.Color(102, 255, 153));
        btnXACNHAN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXACNHAN.setForeground(new java.awt.Color(0, 0, 0));
        btnXACNHAN.setText("XÁC NHẬN");

        btnDANGNHAP.setBackground(new java.awt.Color(102, 255, 153));
        btnDANGNHAP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDANGNHAP.setForeground(new java.awt.Color(0, 0, 0));
        btnDANGNHAP.setText("ĐĂNG NHẬP");

        btnTHOAT.setBackground(new java.awt.Color(102, 255, 153));
        btnTHOAT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTHOAT.setForeground(new java.awt.Color(0, 0, 0));
        btnTHOAT.setText("THOÁT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMATKHAUCU)
                    .addComponent(txtMATKHAUMOI)
                    .addComponent(txtXACNHANMATKHAU, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnXACNHAN)
                        .addGap(18, 18, 18)
                        .addComponent(btnDANGNHAP)
                        .addGap(18, 18, 18)
                        .addComponent(btnTHOAT))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDANGNHAP, btnTHOAT, btnXACNHAN});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMATKHAUCU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMATKHAUMOI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtXACNHANMATKHAU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXACNHAN)
                    .addComponent(btnDANGNHAP)
                    .addComponent(btnTHOAT))
                .addGap(0, 62, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDANGNHAP, btnTHOAT, btnXACNHAN});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMATKHAUCUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMATKHAUCUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMATKHAUCUActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewQuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDANGNHAP;
    private javax.swing.JButton btnTHOAT;
    private javax.swing.JButton btnXACNHAN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtMATKHAUCU;
    private javax.swing.JPasswordField txtMATKHAUMOI;
    private javax.swing.JPasswordField txtXACNHANMATKHAU;
    // End of variables declaration//GEN-END:variables
}
