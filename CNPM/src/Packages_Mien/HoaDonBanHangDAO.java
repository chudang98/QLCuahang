/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Mien;

import Control.Hoa_Don_Ban_Hang;
import Control.Khach_Hang;
import Control.Nhan_Vien;
import Control.San_Pham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class HoaDonBanHangDAO extends DAO_M{

    public HoaDonBanHangDAO() throws ClassNotFoundException, SQLException {
        super();
    }
    public ArrayList<HoaDon> getAllHD(String startDate, String endDate, String id){
        ArrayList<HoaDon> listHD = new ArrayList<HoaDon>();
        String sql= "SELECT mat_hang_ban.ma_san_pham, san_pham.ten_san_pham, san_pham.loai_san_pham,san_pham.gia_ban, hoa_don_ban_hang.thoi_gian, COUNT(mat_hang_ban.ma_mat_hang) AS Amount, SUM(san_pham.gia_ban) AS Income" 
                    + " FROM san_pham, hoa_don_ban_hang, mat_hang_ban" 
                    + " WHERE san_pham.ma_san_pham = mat_hang_ban.ma_san_pham \n" 
                    + " AND mat_hang_ban.ma_hoa_don = hoa_don_ban_hang.ma_hoa_don\n" 
                    + " AND mat_hang_ban.ma_san_pham = '" +id
                    + "' AND  hoa_don_ban_hang.thoi_gian >= '"+startDate+"' AND hoa_don_ban_hang.thoi_gian <='" + endDate
                    + "' GROUP BY DATE (hoa_don_ban_hang.thoi_gian);";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setTen(rs.getString("san_pham.ten_san_pham"));
                hd.setId(rs.getString("mat_hang_ban.ma_san_pham"));
                hd.setLoai(rs.getString("san_pham.loai_san_pham"));
                Format fm= new SimpleDateFormat("dd/MM/yyyy");
                hd.setDate(fm.format(rs.getDate("hoa_don_ban_hang.thoi_gian")).toString());
                hd.setAmount(rs.getInt("Amount"));
                hd.setIncome(rs.getInt("Income"));
                
                listHD.add(hd);
            } 
        }catch(Exception e){
            e.printStackTrace();
        }
        return listHD;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        HoaDonBanHangDAO spa= new HoaDonBanHangDAO();
    
        if(spa.getAllHD("2019/5/1", "2019/5/31", "A100").size()>0) {
            System.out.println("Mien xinh");
        }
    } 
}
