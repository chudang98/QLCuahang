/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Cuc;

import Control.Khach_Hang;
import Control.Nha_Cung_Cap;
import static Packages_Cuc.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MY LAP
 */
public class ClientDAO extends DAO{
    public ArrayList<Khach_Hang>searchClient(String key){
        ArrayList <Khach_Hang> result=new ArrayList<Khach_Hang>();
        String sql="SELECT * FROM Khach_Hang WHERE ten LIKE? ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, "%" + key + "%");
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 Khach_Hang client =new Khach_Hang();
                 client.setCmnd(rs.getString("cmnd"));
                 client.setTen(rs.getString("ten"));
                 client.setDia_chi(rs.getString("dia_chi"));
                 client.setSdt(rs.getString("sdt"));
                 client.setEmail(rs.getString("email"));
                 result.add(client);
                 
                         
            
        }
         
        }
        catch(Exception e){
            e.printStackTrace();
         }
        return result;
           
    }
    
     public static void addClient(Khach_Hang kh){
        try{
            String $table;
            String sql = "INSERT INTO khach_hang(cmnd, ten, dia_chi, sdt, email) VALUE (?,?,?,?,?)";
            PreparedStatement prestate = con.prepareStatement(sql);
            
            prestate.setString(1, kh.getCmnd());
            prestate.setString(2, kh.getTen());
            prestate.setString(3, kh.getDia_chi());
            prestate.setString(4, kh.getSdt());
            prestate.setString(5, kh.getEmail());

            prestate.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
