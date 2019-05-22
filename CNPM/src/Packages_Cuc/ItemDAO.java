/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Cuc;

import Control.Hoa_Don_Nhap_Hang;
import Control.Khach_Hang;
import Control.Mat_Hang_Nhap;
import Control.San_Pham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MY LAP
 */
public class ItemDAO  extends DAO{
  
    
     /**
      * search all clients in the tblClient whose name contains the @key
      * @param key
      * @return list of client whose name contains the @key
      */
    
     public ArrayList<Mat_Hang_Nhap> searchItem(String key){
         ArrayList<Mat_Hang_Nhap> result = new ArrayList<Mat_Hang_Nhap>();
         String sql = "SELECT * FROM mat_hang_nhap WHERE ma_mat_hang LIKE ?";
                 
         try{
             
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, "%" + key + "%");

                          
             ResultSet rs = ps.executeQuery();
 
             while(rs.next()){
                 San_Pham sp = new San_Pham();
                 Hoa_Don_Nhap_Hang hd = new Hoa_Don_Nhap_Hang();
                 Mat_Hang_Nhap item = new Mat_Hang_Nhap();
                 item.setMa_mat_hang(rs.getString("ma_mat_hang"));
                 sp.setMa_san_pham(rs.getString("mat_hang_nhap.ma_san_pham"));
                 hd.setMa_HD_nhap(rs.getString("mat_hang_nhap.hd_nhap"));
                 item.setMa_san_pham(sp);
                 item.setHD_nhap(hd);
                 
                 result.add(item);//
             }
         }catch(Exception e){
             e.printStackTrace();
         }    
         return result;     }
 
//    public static void main(String[] args) {
//        new DAO();
//        ItemDAO it = new ItemDAO();
//        if(it.searchItem("A100_05"))
//        ArrayList<Mat_Hang_Nhap> l = searchItem("A100_01"); // cho nay phải truyển vào mã chứ? sao để tn @@
//        System.out.println(l.size());    }
}
