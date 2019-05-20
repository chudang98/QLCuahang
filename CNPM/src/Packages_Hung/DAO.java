/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Hung;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HuyKa
 */
public class DAO {
    static Connection con;
    public DAO(){
        if(con==null) {
            String dbClass = "com.mysql.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/CuaHang";
           try{
               Class.forName(dbClass);
               con = DriverManager.getConnection(dbUrl,"root","vanhuy1998");
               System.out.println("Access to DAO");
           }catch(Exception e){
               System.out.println("DAO Error");
               e.printStackTrace();
           } 
        }
    }
}
