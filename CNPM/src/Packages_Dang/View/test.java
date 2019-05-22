/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.View;

import java.sql.SQLException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 *
 * @author Duck
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        String test = "HDN009";
//        System.out.println(Integer.valueOf(test.substring(3)));
//        System.out.println(test.substring(0, 3));


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
        String kq = dtf.format(localDate);
	System.out.println(dtf.format(localDate));
    }
    private static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');

    }
}
