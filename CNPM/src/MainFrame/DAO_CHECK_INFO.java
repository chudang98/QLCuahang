/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFrame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HuyKa
 */
public class DAO_CHECK_INFO extends DAO{
    public String get_vi_tri(String tai_khoan, String mat_khau) {
        String vi_tri = "";
        String sql = "SELECT * FROM nhan_vien";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String tk_real = rs.getString("nhan_vien.ten_dang_nhap");
                String mk_real = rs.getString("nhan_vien.mat_khau");
                if (tk_real.compareTo(tai_khoan) == 0 && mk_real.compareTo(mat_khau) == 0) {
                    return rs.getString("nhan_vien.vi_tri");
                }
            }
        }catch (Exception e) {
            System.out.println("Erro");
            e.printStackTrace();
        }
        return vi_tri;
    }
}
