/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.View;

import Control.Nha_Cung_Cap;
import Packages_Dang.Controller.NhaCCDAO;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Duck
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String test = "A009";
        System.out.println(test.compareTo("A008"));
    }
    private static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');

    }
}
