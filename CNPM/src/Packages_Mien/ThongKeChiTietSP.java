/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Mien;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Binh
 */
public class ThongKeChiTietSP extends javax.swing.JFrame {

    ThongKeSPFrame GDTKe;

    public ThongKeChiTietSP() throws HeadlessException {
    }
    String startDate;
    String endDate;
    public ThongKeChiTietSP(ThongKeSPFrame aThis, ThongKeSPTheoDoanhThu get, String id, String startDate, String endDate) throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        HoaDonBanHangDAO hdDAO = new HoaDonBanHangDAO();
        ArrayList<HoaDon> listHD = hdDAO.getAllHD(startDate, endDate, id);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        this.startDate = startDate;
        this.endDate = endDate;
        
        int sl=0, tt=0;
        for(HoaDon hd: listHD){
            jlbTime.setText("Ngày bắt đầu :" + convertDate(startDate) + ", Ngày kết thúc : "+convertDate(endDate));
            jlbDetail.setText( "Mã sản phẩm: "+hd.getId()+ ", tên sản phẩm: "+hd.getTen()+ ", loại sản phẩm: "+hd.getLoai());
            Object[] obj = { hd.getDate(), hd.getAmount(), hd.getIncome()};
            sl += hd.getAmount();
            tt += hd.getIncome();
            
            model.addRow(obj);
        }
        jlbTongSL.setText("Tổng số lượng: " +String.valueOf(sl));
        jlbTongTien.setText("Tổng tiền: " +String.valueOf(tt));
    }
    public String convertDate(String a){
        String test = a;
        String[] output = test .split("/");
        String b = output[2]+"/"+ output[1]+"/"+ output[0];
       return b;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jlbTime = new javax.swing.JLabel();
        jlbDetail = new javax.swing.JLabel();
        jlbTongSL = new javax.swing.JLabel();
        jlbTongTien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jlbTime.setText("Ngày bắt đầu: 1/3/2019, Ngày kết thúc: 31/3/2019 ");

        jlbDetail.setText("Mã sản phẩm: 1233, Tên sản phẩm: Áo thun Adidas, loại snar pham: ao ");

        jlbTongSL.setText("Tổng số lượng: 5");

        jlbTongTien.setText("Tổng tiền: 1000 (nghìn đồng)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ngày giao dịch", "Số lượng", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbTime)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnBack)
                        .addGap(128, 128, 128)
                        .addComponent(jlbTongSL)
                        .addGap(41, 41, 41)
                        .addComponent(jlbTongTien))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jlbDetail)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTongSL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        GDTKe = new ThongKeSPFrame();
        this.setVisible(false);
        GDTKe.setVisible(true);
        try {
            GDTKe.push_data_on_table(startDate, endDate);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThongKeChiTietSP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeChiTietSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongKeChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeChiTietSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlbDetail;
    private javax.swing.JLabel jlbTime;
    private javax.swing.JLabel jlbTongSL;
    private javax.swing.JLabel jlbTongTien;
    // End of variables declaration//GEN-END:variables
}
