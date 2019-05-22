/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Mien;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static javax.swing.LayoutStyle.getInstance;

/**
 *
 * @author Binh
 */
public class SanPhamDAO extends DAO_M{
    public SanPhamDAO() throws ClassNotFoundException, SQLException{
        super();
    }
    public ArrayList<ThongKeSPTheoDoanhThu> GetAllSPStat(String startDate, String endDate){
        ArrayList<ThongKeSPTheoDoanhThu> listTK= new ArrayList<ThongKeSPTheoDoanhThu>();
        String sql = "SELECT mat_hang_ban.ma_san_pham, ten_san_pham, loai_san_pham, san_pham.kick_co, san_pham.mau_sac, san_pham.gia_ban, COUNT(mat_hang_ban.ma_san_pham) AS Amount, SUM(san_pham.gia_ban) AS Income From san_pham, mat_hang_ban, hoa_don_ban_hang WHERE san_pham.ma_san_pham = mat_hang_ban.ma_san_pham AND mat_hang_ban.ma_hoa_don = hoa_don_ban_hang.ma_hoa_don AND hoa_don_ban_hang.thoi_gian >= '"+startDate+"' AND hoa_don_ban_hang.thoi_gian <= '"+endDate+ "' GROUP BY mat_hang_ban.ma_san_pham ORDER BY Income DESC ";  
        System.out.println(sql);
        try{ 
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ThongKeSPTheoDoanhThu tk = new ThongKeSPTheoDoanhThu();
                tk.setMaSP(rs.getString("mat_hang_ban.ma_san_pham"));
                tk.setTenSP(rs.getString("san_pham.ten_san_pham"));
                tk.setLoaiSP(rs.getString("san_pham.loai_san_pham"));
                tk.setSize(rs.getString("san_pham.kick_co"));
                tk.setColor(rs.getString("san_pham.mau_sac"));
                tk.setGiaBan(rs.getInt("san_pham.gia_ban"));
                tk.setSoLuong(rs.getInt("Amount"));
                tk.setTongTien(rs.getInt("Income"));
                
                listTK.add(tk);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listTK;
    }

}
