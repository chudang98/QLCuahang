/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Hung;

import Control.Hoa_Don_Ban_Hang;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author HuyKa
 */
public class Frame_Thong_Ke_Theo_Nam extends javax.swing.JFrame {

    /**
     * Creates new form Frame_Thong_Ke_Theo_Nam
     */
    Frame_Thong_Ke_Thoi_Gian thong_Ke_Thoi_Gian;
    Frame_Thong_Ke_Theo_Thang thong_Ke_Theo_Thang;
    DefaultTableModel model;
    public Frame_Thong_Ke_Theo_Nam(Frame_Thong_Ke_Thoi_Gian thong_Ke_Thoi_Gian) throws ClassNotFoundException, SQLException {
        initComponents();
        setLocationRelativeTo(null);
        this.thong_Ke_Thoi_Gian = thong_Ke_Thoi_Gian;
        model = (DefaultTableModel) jTable1.getModel();
        push_data_on_table();
    }

    private Frame_Thong_Ke_Theo_Nam() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void push_data_on_table() throws ClassNotFoundException, SQLException {
        DAO_Hoa_Don_Ban_Hang daohdbh = new DAO_Hoa_Don_Ban_Hang();
        int num_row = model.getRowCount();
        int tong_doanh_thu = 0;
        for(int i=0; i<5; i++) {
            String date_year = (2019 - i) + "";
            int tong_tien = daohdbh.get_tong_tien_from_year(date_year);
            if (tong_tien > 0) {
                model.addRow(new Object[] {
                    (num_row+1), (2019 - i), tong_tien, "Detail " + (num_row+1)
                });
                num_row += 1;
                tong_doanh_thu += tong_tien;
            }
        }
        jLabel3.setText("" + tong_doanh_thu);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        jTable1.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Quay Lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Năm", "Tổng Tiền", "Xem Chi Tiết"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("GD Thống Kê theo năm ");

        jLabel2.setText("Tổng Doanh Thu :");

        jLabel3.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        thong_Ke_Thoi_Gian.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Thong_Ke_Theo_Nam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Thong_Ke_Theo_Nam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Thong_Ke_Theo_Nam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Thong_Ke_Theo_Nam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Thong_Ke_Theo_Nam().setVisible(true);
            }
        });
    }
    
    class ButtonRenderer extends JButton implements  TableCellRenderer {
        //CONSTRUCTOR
        public ButtonRenderer() {
            //SET BUTTON PROPERTIES
            setOpaque(true);
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
                boolean selected, boolean focused, int row, int col) {
            //SET PASSED OBJECT AS BUTTON TEXT
                setText((obj==null) ? "":obj.toString());
            return this;
        }
    }
    //BUTTON EDITOR CLASS
    class ButtonEditor extends DefaultCellEditor {
        protected JButton btn;
        private String lbl;
        private Boolean clicked;
        public ButtonEditor(JTextField txt) {
            super(txt);
            btn=new JButton();
            btn.setOpaque(true);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj,
            boolean selected, int row, int col) {
            //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
                lbl=(obj==null) ? "":obj.toString();
                btn.setText(lbl);
                clicked=true;
                return btn;
        }
        @Override
        public Object getCellEditorValue() {
            if (clicked == true) {
                String[] s = lbl.split(" ");
                int row = Integer.parseInt(s[1])-1;
                int column = 1;
                String time_year = String.valueOf(jTable1.getValueAt(row, column));
                setVisible(false);
                try {
                    thong_Ke_Theo_Thang = new Frame_Thong_Ke_Theo_Thang(thong_Ke_Thoi_Gian, time_year, 1);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Frame_Thong_Ke_Theo_Nam.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Frame_Thong_Ke_Theo_Nam.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("time_year: "+ time_year);
                thong_Ke_Theo_Thang.setVisible(true);
            }
            clicked = false;
            return new String(lbl);
        }

        @Override
        public boolean stopCellEditing() {
            
            return super.stopCellEditing();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
