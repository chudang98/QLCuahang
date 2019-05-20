/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.View;

import Control.Nha_Cung_Cap;
import Packages_Dang.Controller.NhaCCDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Duck
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        NhaCCDAO t = new NhaCCDAO();
        
        ArrayList<Nha_Cung_Cap> l = new ArrayList<Nha_Cung_Cap>();
        
        l = NhaCCDAO.getAllNCC();
        
        for(int i = 0; i < l.size(); i++){
            System.out.println(l.get(i).getCmnd() + " " + l.get(i).getTen());
        }
    }
}
