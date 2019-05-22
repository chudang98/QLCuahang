/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.Controller;

import Control.Cua_Hang;
import Control.San_Pham;
import Control_DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Duck
 */
public class SanphamDAO extends DAO{
    
    private static Statement state;
    public static Cua_Hang shop;
    
    public SanphamDAO() throws ClassNotFoundException, SQLException{
        super();
        state = con.createStatement();
        shop = new Cua_Hang("Team_4 Store", "Ptit - Hà Nội", "19008199", "Chuyên bán quần áo giày");
    }
    
    private static ResultSet executeSelect(String sql) throws SQLException{
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }
    
    public static ArrayList<String[]> lietkeSP() throws SQLException{
        ArrayList<String[]> list = new ArrayList<String[]>();
        
//        String sql = "SELECT san_pham.ma_san_pham, san_pham.ten_san_pham, san_pham.loai_san_pham, san_pham.kick_co, san_pham.mau_sac, san_pham.ten_cua_hang, san_pham.gia_nhap, san_pham.gia_ban, (soluong_nhap.so_luong_nhap - soluong_ban.so_luong_ban) as conlai "
//                + "FROM san_pham, "
//                +       "(SELECT mat_hang_ban.ma_san_pham, COUNT(ma_san_pham) as so_luong_ban FROM mat_hang_ban GROUP BY mat_hang_ban.ma_san_pham ) as soluong_ban, "
//                +       "(SELECT mat_hang_nhap.ma_san_pham, COUNT(ma_san_pham) as so_luong_nhap FROM mat_hang_nhap GROUP BY mat_hang_nhap.ma_san_pham) as soluong_nhap "
//                + "WHERE san_pham.ma_san_pham = soluong_ban.ma_san_pham "
//                + "     AND san_pham.ma_san_pham = soluong_nhap.ma_san_pham "
//                + "     AND soluong_nhap.ma_san_pham = soluong_ban.ma_san_pham";
//        
        String sql = "SELECT  san_pham.ma_san_pham, san_pham.ten_san_pham, san_pham.loai_san_pham, san_pham.kick_co, san_pham.mau_sac, san_pham.ten_cua_hang, san_pham.gia_nhap, san_pham.gia_ban, T.soluong as conlai"
                    + " FROM san_pham, (SELECT san_pham.ma_san_pham, COUNT(san_pham.ma_san_pham) as soluong"
                    + " FROM san_pham, mat_hang_nhap WHERE san_pham.ma_san_pham = mat_hang_nhap.ma_san_pham" 
                    + " GROUP BY mat_hang_nhap.ma_san_pham ) as T"
                    + " WHERE san_pham.ma_san_pham = T.ma_san_pham ";
        ResultSet rs = executeSelect(sql);
        while(rs.next()){
            String ma_sp = rs.getString("ma_san_pham"), ten = rs.getString("ten_san_pham"), loai = rs.getString("loai_san_pham"),
                   size = rs.getString("kick_co"), mau = rs.getString("mau_sac"), tencuahang = rs.getString("ten_cua_hang");
            int gia_nhap = rs.getInt("gia_nhap"), giaban = rs.getInt("gia_ban"), conlai = rs.getInt("conlai");
            String[] sp = {ma_sp, ten, loai, Integer.toString(gia_nhap), Integer.toString(giaban), mau, size, tencuahang, Integer.toString(conlai)};
            list.add(sp);
        }
        return list;
    }
    
    public static String nextID(String type) throws SQLException{
        String sql = "SELECT MAX(T.ma_san_pham) AS id FROM (SELECT san_pham.ma_san_pham FROM san_pham WHERE loai_san_pham = '" + type + "') as T";
        ResultSet rs = executeSelect(sql);
        rs.next();
        String kq = rs.getString("id");
        int i = Integer.valueOf(kq.substring(1));
        i++;
        if(type.compareTo("Áo") == 0){
            if(i < 10){
                String t = "A00" + i;
                return t;
            }
            if(i < 100){
               String t = "A0" + i;
               return t; 
            }
            String t = "A" + i;
            return t;
        }else{
            if(type.compareTo("Quần") == 0){
                if(i < 10){
                    String t = "Q00" + i;
                    return t;
                }
                if(i < 100){
                    String t = "Q0" + i;
                    return t; 
                }
                String t = "Q" + i;
                return t;
            }
            else{
                if(i < 10){
                    String t = "G00" + i;
                    return t;
                }
                if(i < 100){
                    String t = "G0" + i;
                    return t; 
                }
                String t = "G" + i;
                return t;
            }
        }
    }
    
    public static San_Pham getSp(String masp) throws SQLException{
        String sql = "SELECT * FROM San_Pham WHERE ma_san_pham = '" + masp + "'";
        ResultSet rs = executeSelect(sql);
        rs.next();
        San_Pham sp = new San_Pham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(6), rs.getInt(7), rs.getString(4), rs.getString(5), shop);
        return sp;
    }
    
    public static String sinhMasp(String masp) throws SQLException{
        String sql = "SELECT MAX(ma_mat_hang) FROM mat_hang_nhap WHERE ma_san_pham = '" + masp +"'";
        ResultSet rs = executeSelect(sql);
        rs.next();
        String ma = rs.getString(1);
        int x = Integer.valueOf(ma.substring(5));
        x++;
        if(x >= 10)
            return ma.substring(0, 5) + x;
        else
            return ma.substring(0, 5) + "0" + x;            
    }
    
    public static void addSP(San_Pham t) throws SQLException{
        String sql = "INSERT INTO San_Pham(ma_san_pham, ten_San_pham, loai_san_pham, kick_co, mau_sac, gia_nhap, gia_ban, ten_cua_hang)"
                + " VALUE (?,?,?,?,?,?,?,?)";
        PreparedStatement prestate = con.prepareStatement(sql);
        prestate.setString(1, t.getMa_san_pham());
        prestate.setString(2, t.getTen_san_pham());
        prestate.setString(3, t.getLoai_san_pham());
        prestate.setString(4, t.getKich_co());
        prestate.setString(5, t.getMau_sac());
        prestate.setInt(6, t.getGia_nhap());
        prestate.setInt(7, t.getGia_ban());
        prestate.setString(8, t.getTen_cua_hang().getTen_cua_hang());
        prestate.executeUpdate();
    }
    
    
}
