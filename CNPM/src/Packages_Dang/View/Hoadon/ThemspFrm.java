/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.View.Hoadon;

import Control.Cua_Hang;
import Control.San_Pham;
import Packages_Dang.Controller.SanphamDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Duck
 */
public class ThemspFrm extends javax.swing.JFrame {

    /**
     * Creates new form ThemspFrm
     */
    public ThemspFrm(LaphoadonFrm host) throws ClassNotFoundException, SQLException {
        initComponents();
        
        this.host = host;
        txtMa.setText(SanphamDAO.nextID("Áo"));
        setLocationRelativeTo(null);
        txtMa.setEditable(false);
        this.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxShop = new javax.swing.JComboBox<>();
        txtTen = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        txtMau = new javax.swing.JTextField();
        txtGianhap = new javax.swing.JTextField();
        cbxLoai = new javax.swing.JComboBox<>();
        txtMa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nhập thông tin sản phẩm mới");

        jLabel2.setText("Tên sản phẩm");

        jLabel4.setText("Mã sản phẩm");

        jLabel5.setText("Loại sản phẩm");

        jLabel6.setText("Kích cỡ");

        jLabel7.setText("Màu sắc");

        jLabel8.setText("Giá nhập");

        btnAdd.setText("Thêm sản phẩm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel9.setText("Cửa hàng");

        cbxShop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Team_4 Store" }));

        cbxLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo", "Quần", "Giày" }));
        cbxLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(35, 35, 35)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSize, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addComponent(txtMau)
                                .addComponent(txtGianhap)
                                .addComponent(txtTen))
                            .addComponent(cbxShop, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnAdd)
                        .addGap(96, 96, 96)
                        .addComponent(btnBack)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addComponent(txtGianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxShop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnBack))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLoaiActionPerformed
        // TODO add your handling code here:
        int t = cbxLoai.getSelectedIndex();
        switch(t){
            case 0 : {
                try {
                    txtMa.setText(SanphamDAO.nextID("Áo"));
                } catch (SQLException ex) {
                    Logger.getLogger(ThemspFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 1 : {
                try {
                    txtMa.setText(SanphamDAO.nextID("Quần"));
                }catch (SQLException ex) {
                    Logger.getLogger(ThemspFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case 2 : {
                try {
                    txtMa.setText(SanphamDAO.nextID("Giày"));
                }catch (SQLException ex) {
                    Logger.getLogger(ThemspFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
    }//GEN-LAST:event_cbxLoaiActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(checkInfor() == -1){
            JOptionPane.showMessageDialog(this, "Không được để thông tin được trống !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(checkInfor() == -2){
            JOptionPane.showMessageDialog(this, "Thông tin vượt quá giới hạn hoặc không đúng định dạng, vui lòng kiểm tra lại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String ten = txtTen.getText(), masp = txtMa.getText(), size = txtSize.getText(), mau = txtMau.getText(), gia = txtGianhap.getText();
        Cua_Hang t = new Cua_Hang("Team_4 Store", "Ptit - Hà Nội", "19008199", "Chuyên bán quần áo giày");
        String loai = cbxLoai.getItemAt(cbxLoai.getSelectedIndex());
        San_Pham sp = new  San_Pham(masp, ten, loai, Integer.valueOf(gia), 0, mau, size, t);
        
        host.setSPmoi(sp);
        JOptionPane.showMessageDialog(this, "Thêm sản phẩm mới thành công !");
        Back();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Back();
    }//GEN-LAST:event_btnBackActionPerformed

    private void Back(){
        host.setVisible(true);
        host.setEnabled(true);
        this.dispose();
    }
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThemspFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThemspFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThemspFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThemspFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new ThemspFrm().setVisible(true);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(ThemspFrm.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ThemspFrm.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    private int checkInfor(){
        String ten = txtTen.getText(), masp = txtMa.getText(), size = txtSize.getText(), mau = txtMau.getText(), gia = txtGianhap.getText();
        
        if(ten.compareTo("") == 0 || size.compareTo("") == 0 || mau.compareTo("") == 0 || gia.compareTo("") == 0)
            return -1;
        if(ten.length() > 50|| size.length() > 20|| mau.length() > 20|| gia.length() > 11)
            return -2;
        try{
            int x = Integer.valueOf(gia);
        }catch(Exception e){
            return -2;
        }
        
        return 1;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cbxLoai;
    private javax.swing.JComboBox<String> cbxShop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtGianhap;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMau;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

    private LaphoadonFrm host;
}
