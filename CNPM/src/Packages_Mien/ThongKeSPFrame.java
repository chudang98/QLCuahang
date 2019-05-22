/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Mien;

import MainFrame.MainLogin;
import Packages_Hung.Frame_Chon_Thong_Ke;
import Packages_Hung.Frame_NV_Quan_Ly;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ThongKeSPFrame extends JFrame implements ActionListener{
    ThongKeChiTietSP GDTKChiTiet;
    Packages_Hung.Frame_Chon_Thong_Ke GDChonTK;
    Frame_NV_Quan_Ly ql;
    MainFrame.MainLogin login;
    private ArrayList<ThongKeSPTheoDoanhThu> listSP;
    private ArrayList<JButton> listOtp;
    public JTextField txtSD;
    public JTextField txtED;
    private JButton btnTKe, btnBack;
    private JTable tblResult;
    public int id;
    String startDate, endDate;
    public ThongKeSPFrame() {
        listSP = new ArrayList<ThongKeSPTheoDoanhThu>();
        listOtp = new ArrayList<JButton>();
        JPanel pnMain = new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);        
        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.Y_AXIS));
 
        JPanel pn1 = new JPanel();
        pn1.setLayout(new BoxLayout(pn1,BoxLayout.X_AXIS));
        pn1.setSize(this.getSize().width-5, 20);
        pn1.add(new JLabel("StartDate: "));
        txtSD = new JTextField();
        pn1.add(txtSD);
        pn1.add(new JLabel("EndDate: "));
        txtED = new JTextField();
        pn1.add(txtED);
        btnTKe = new JButton("Thống Kê");
        btnTKe.addActionListener(this);
        pn1.add(btnTKe);
        pnMain.add(pn1);
 
        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2,BoxLayout.Y_AXIS));
        tblResult = new JTable(new SPTableModel());
        JScrollPane scrollPane= new  JScrollPane(tblResult);
        tblResult.setFillsViewportHeight(false); 
        scrollPane.setPreferredSize(new Dimension(scrollPane.getPreferredSize().width, 250));
 
        JPanel pn3 = new JPanel();
        pn3.setLayout(new BoxLayout(pn3,BoxLayout.X_AXIS));
        btnBack = new JButton("Quay lại");
        btnBack.addActionListener(this);
        pn3.add(btnBack);
        
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        tblResult.getColumn("Option").setCellRenderer(buttonRenderer);
        tblResult.addMouseListener(new JTableButtonMouseListener(tblResult));
        
        pn2.add(scrollPane);
        pnMain.add(pn2);  
        pnMain.add(pn3);
        this.add(pnMain);
        pnMain.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.setSize(800,300);                
        this.setVisible(true);                
        this.setLocationRelativeTo(null);
        
    }
    public void actionPerformed(ActionEvent e) {
        
        // TODO Auto-generated method stub
        JButton btnClicked = (JButton)e.getSource();
        
        if(btnClicked.equals(btnBack)){
            System.out.println("back");
            try {
                login= new MainLogin();
                ql= new Frame_NV_Quan_Ly(login);
                GDChonTK = new Frame_Chon_Thong_Ke(ql);
                setVisible(false);
                GDChonTK.setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeSPFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeSPFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(btnClicked.equals(btnTKe)){
            try {
                btnTKeClick();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeSPFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeSPFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        if(listOtp.size()>0){
        for(int i=0; i<listOtp.size(); i++)
            if(btnClicked.equals(listOtp.get(i))){
            try {
                btnTKeClick(i);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThongKeSPFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeSPFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            return;
            }
        }
        
    }
   
    public void push_data_on_table(String startDate, String endDate) throws ClassNotFoundException, SQLException {
         SanPhamDAO spDAO= new SanPhamDAO();
        listSP = spDAO.GetAllSPStat(startDate, endDate);
        if(listSP.size()>0){
            for(int i=0; i<listSP.size(); i++){
                JButton btn = new JButton("Xem chi tiết");
                btn.addActionListener(this);
                listOtp.add(btn);
            }
        } 
        ((DefaultTableModel)tblResult.getModel()).fireTableDataChanged();
        this.startDate = startDate;
        this.endDate = endDate;
        txtSD.setText(startDate);
        txtED.setText(endDate);
    }
    
    private void btnTKeClick() throws ClassNotFoundException, SQLException{
        if((txtSD.getText() == null)||(txtSD.getText().length() == 0)){
            JOptionPane.showMessageDialog(this, "Nhập ngày bắt đầu và ngày kết thúc");
            return;
        }
            
        else if((txtED.getText() == null)||(txtED.getText().length() == 0)){
            JOptionPane.showMessageDialog(this, "Nhập ngày kết thúc và ngày kết thúc");
        }
        SanPhamDAO spDAO= new SanPhamDAO();
        startDate = convertDate(txtSD.getText().trim());
        endDate = convertDate(txtED.getText().trim());
        listSP = spDAO.GetAllSPStat(startDate, endDate);
        //System.out.println(startDate + " " + endDate);
        if(listSP.size()>0){
            //System.out.println("Mien");
            for(int i=0; i<listSP.size(); i++){
                JButton btn = new JButton("Xem chi tiết");
                btn.addActionListener(this);
                listOtp.add(btn);
            }
        } 
        //System.out.println("xin chào");
        ((DefaultTableModel)tblResult.getModel()).fireTableDataChanged();
    }
    private void btnTKeClick(int index) throws ClassNotFoundException, SQLException{
       (new ThongKeChiTietSP(this, listSP.get(index), listSP.get(index).getMaSP(), startDate, endDate)).setVisible(true);
        setVisible(false);
    }
    public String convertDate(String a){
        String test = a;
        String[] output = test .split("/");
        String b = output[2]+"/"+ output[1]+"/"+ output[0];
       return b;
    }
    
    class JTableButtonRenderer implements TableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton btn = (JButton) value;
            return btn;
        }
    }
    class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;
 
        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }
        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
            int row    = e.getY()/table.getRowHeight(); //get the row of the button
 
                    //*Checking the row or column is valid or not
            if (row < table.getRowCount() && row >= 0  && column < table.getColumnCount() && column >= 0)  {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    //perform a click event
                    ((JButton)value).doClick();
                }
            }
        }
    }
    class SPTableModel extends DefaultTableModel{
        private String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm","Kích cỡ", "Màu sắc", "Giá bán", "Số lượng", "Tổng tiền", "Option"};
        private final Class<?>[] columnTypes = new Class<?>[]{ String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, JButton.class};
        @Override public int getColumnCount() {
            return columnNames.length;
        }
        @Override public int getRowCount() {
            return listSP.size();
        }
 
        @Override public String getColumnName(int columnIndex) {
            return columnNames[columnIndex];
        }
 
        @Override public Class<?> getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
                /*Adding components*/
            switch (columnIndex) {
                //case 0: 
                    // số int tăng dần
                case 0: 
                    return listSP.get(rowIndex).getMaSP();
                case 1:  
                    return listSP.get(rowIndex).getTenSP();
                case 2: 
                    return listSP.get(rowIndex).getLoaiSP();
                case 3:
                    return listSP.get(rowIndex).getSize();
                case 4:
                    return listSP.get(rowIndex).getColor();
                case 5:
                    return listSP.get(rowIndex).getGiaBan();
                case 6: 
                    return listSP.get(rowIndex).getSoLuong();
                case 7: 
                    return listSP.get(rowIndex).getTongTien();
                case 8: 
                    return listOtp.get(rowIndex);                   
                default: return "Error";
            }
        } 
    }  
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//       ThongKeSPFrame myFrame = new ThongKeSPFrame();
//        myFrame.setSize(800,300);                
//        myFrame.setVisible(true);                
//        myFrame.setLocation(200,10);
    }
}