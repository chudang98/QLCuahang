/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Cuc;

import Control.Hoa_Don_Ban_Hang;
import Control.Khach_Hang;
import Control.Nhan_Vien;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author MY LAP
 */
public class HD_BanDAO  extends DAO{
    public HD_BanDAO(){
        super();
        
    }
    public void addHD(Hoa_Don_Ban_Hang hd){
         String sql = "INSERT INTO Hoa_Don_Ban_Hang(ma_hoa_don, thoi_gian, ghi_chu,cmnd_nv_ban, kh_cmnd) VALUES(?,?,?,?,?)";
        try{
            Nhan_Vien nv=new Nhan_Vien();
            Khach_Hang kh= new Khach_Hang();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hd.getMa_hoa_don());
            ps.setDate(2, (Date) hd.getThoi_gian());
            ps.setString(3, hd.getGhi_chu());
            nv.setCmnd(ps.toString());
            kh.setCmnd(ps.toString());
 
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }       
        
    }
 
    
}
