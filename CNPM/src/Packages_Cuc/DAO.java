/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Cuc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hunglv
 */
public class DAO {
    public static Connection con;
    public DAO(){
        if(con==null) {
            String dbClass = "com.mysql.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/cuahang?useUnicode=true&characterEncoding=utf-8";
           try{
               Class.forName(dbClass);
               con = DriverManager.getConnection(dbUrl,"root","");
               System.out.println("Access to DAO");
           }catch(Exception e){
               System.out.println("DAO Error");
               e.printStackTrace();
           } 
        }
    }
    public static void main(String[] args) {
        new DAO();
    }
}
