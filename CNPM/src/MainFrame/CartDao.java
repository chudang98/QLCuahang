/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame;

import Control.Khach_Hang;
import Control.Nhan_Vien;
import Control.San_Pham;
import Packages_Cuc.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MY LAP
 */
public class CartDao extends DAO {

    public boolean insertToCart(San_Pham product, Khach_Hang user, String taikhoan, String description,String maMH) {
//        Nhan_Vien nv = getNV(taikhoan);
        try {
            String sql = "INSERT INTO hoa_don_ban_hang(ma_hoa_don,thoi_gian,ghi_chu,cmnd_nv_ban,kh_cmnd)"
                + " values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            long maHD = System.currentTimeMillis();
            ps.setString(1, String.valueOf(maHD));
            ps.setString(2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            ps.setString(3, description);
            ps.setString(4, "12288551");
            
            System.out.println(user.getCmnd());
            ps.setString(5, user.getCmnd());
            ps.execute();
            
            //insert 
            String sql2 = "INSERT INTO mat_hang_ban(ma_hoa_don,ma_mat_hang,ma_san_pham)"
                + " values(?,?,?)";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setString(1, String.valueOf(maHD));
            ps2.setString(2, maMH);
            ps2.setString(3, product.getMa_san_pham());
            ps2.execute();
            
            return true;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return false;
    }

//    private Nhan_Vien getNV(String taikhoan) {
//        Nhan_Vien nv = new Nhan_Vien();
//        String sql = "SELECT * from nhan_vien where ten_dang_nhap = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            int count = 1;
//            ps.setString(count, taikhoan);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                nv.setCmnd(rs.getString("cmnd"));
//                nv.setHo_ten(rs.getString("ho_ten"));
//            }
//          
//        } catch (Exception e) {
//            System.out.println("Error");
//            e.printStackTrace();
//        }
//          return nv;
//    }
}
