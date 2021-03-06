/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Cuc;

import Control.Mat_Hang_Nhap;
import Control.San_Pham;
import MainFrame.MainLogin;
import Packages_Hung.Frame_Thong_Ke_Theo_Ngay;
import Packages_Hung.Frame_Thong_Ke_Theo_Thang;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author MY LAP
 */
public class SearchItem extends javax.swing.JFrame {

    /**
     * Creates new form SearchItem
     */
   DefaultTableModel model;
      
    public SearchItem() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
      
    }

//    SearchItem(sellerHome aThis) {
//    new SearchItem().setVisible(true);
//    }

//    SearchItem() {
//          new SearchItem().setVisible(true);
//    }
    

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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SearchItem");

        jLabel2.setText("mamathang");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "mamat hang", "masanpham", "maHD", "chon"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(87, 87, 87)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //bắt sự kiện button sreach item
        ItemDAO idao = new ItemDAO();
        String key = jTextField1.getText();
        ArrayList<Mat_Hang_Nhap> list = idao.searchItem(key);
        Confirm.listMHN = list;
        push_data_on_table(list);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         Back();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void Back(){
         new sellerHome().setVisible(true);
                setVisible(false);
    }
    private void push_data_on_table(ArrayList<Mat_Hang_Nhap> list) {
        int num_row = model.getRowCount();
        for (int i=0; i<list.size(); i++) {
            Mat_Hang_Nhap mhn = list.get(i);
            
            model.addRow(new Object[] {
                (num_row + 1), mhn.getMa_mat_hang(), mhn.getMa_san_pham().getMa_san_pham(),
                mhn.getHD_nhap().getMa_HD_nhap(), "Select " + (num_row + 1)
            });
        }
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        
        jTable1.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));
    }
    
    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(SearchItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SearchItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SearchItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SearchItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SearchItem(  new MainLogin()).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

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
                // mở giao diện sellerhome
                String[] s = lbl.split(" ");
                int row = Integer.parseInt(s[1])-1;
                int column = 1;
                new sellerHome().setVisible(true);
                setVisible(false);
                System.out.println(row);
                // lấy thông tin từ sp được chọn cho vào mặt hàng bán
                
            }
            clicked = false;
            return new String(lbl);
        }

        @Override
        public boolean stopCellEditing() {
            
            return super.stopCellEditing();
        }
        
    }
}
