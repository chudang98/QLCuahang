/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hunglv
 */
public class DAO {
    protected static Connection con;
    
    
    // CONFIG
    private static int $PORT = 3306;
    private static String $DBName = "CUAHANG";
    private static String $host = "localhost";
    private static String $user = "root";
    private static String $pass = "";
   
    public DAO() throws ClassNotFoundException, SQLException{
        if(con != null)
            return;
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + $host + ":" + $PORT  + "/" + $DBName + "?useUnicode=true&characterEncoding=utf-8";
        con = DriverManager.getConnection(url, $user, $pass);
        con.setAutoCommit(true);   

    }
}
