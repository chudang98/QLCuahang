/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.Controller;

import Control.Nha_Cung_Cap;
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
public class NhaCCDAO extends DAO{
    
    private static String $table = "Nha_Cung_Cap";
    private static Statement state;
    
    public NhaCCDAO() throws ClassNotFoundException, SQLException{
        super();
        state = con.createStatement();
    }
    
    private static ResultSet executeSelect(String sql) throws SQLException{
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }
    
    public static String[] convertString(Nha_Cung_Cap v){
        String t[] = {v.getCmnd(), v.getTen(), v.getDia_chi(), v.getSdt(), v.getEmail()};
        return t;
    }
        
    public static ArrayList<Nha_Cung_Cap> getAllNCC() throws SQLException{
        ArrayList<Nha_Cung_Cap> list = new ArrayList<Nha_Cung_Cap>();
        String sql = "SELECT * FROM " + $table;
     
        ResultSet rs = executeSelect(sql);
        
        while(rs.next()){
            String cmnd = rs.getString("cmnd"), ten = rs.getString("ten"),
                    diachi = rs.getString("dia_chi"), sdt = rs.getString("sdt"), email = rs.getString("email");
            Nha_Cung_Cap t = new Nha_Cung_Cap(cmnd, ten, diachi, sdt, email);
            list.add(t);
        }    
        return list;
    }
    
    public static void editNCC(String CMND, Nha_Cung_Cap ncc) throws SQLException{
        try{
            String sql = "UPDATE " + $table + " SET cmnd = '" + ncc.getCmnd() + "', ten = '" + ncc.getTen() +
                "', dia_chi = '" + ncc.getDia_chi() + "', sdt = '" + ncc.getSdt() + "', email = '" + ncc.getEmail() + "'"
                + " WHERE cmnd = '" + CMND + "'";
            state.executeUpdate(sql);
        }catch(Exception e){
            throw e;
        }
    }
    
    public static void addNCC(Nha_Cung_Cap ncc) throws Exception{
        try{
            String sql = "INSERT INTO " + $table + "(cmnd, ten, dia_chi, sdt, email) VALUE (?,?,?,?,?)";
            PreparedStatement prestate = con.prepareStatement(sql);
            
            prestate.setString(1, ncc.getCmnd());
            prestate.setString(2, ncc.getTen());
            prestate.setString(3, ncc.getDia_chi());
            prestate.setString(4, ncc.getSdt());
            prestate.setString(5, ncc.getEmail());

            prestate.executeUpdate();
        }catch(Exception e){
            throw e;
        }
    }
    
    public static ArrayList<String> getAllIDNCC() throws SQLException{
        String sql = "SELECT nha_cung_cap.cmnd FROM nha_cung_cap";
        ResultSet rs = executeSelect(sql);
        ArrayList<String> list = new ArrayList<String>();
        while(rs.next()){
            list.add(rs.getString(1));
        }
        return list;
    }
    public static ArrayList<String> getAllIDNV() throws SQLException{
        String sql = "SELECT nhan_vien.cmnd from nhan_vien";
        ResultSet rs = executeSelect(sql);
        ArrayList<String> list = new ArrayList<String>();
        while(rs.next()){
            list.add(rs.getString(1));
        }
        return list;
    }
    
    
}
