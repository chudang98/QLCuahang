
import Packages_Dang.Controller.HoadonDAO;
import Packages_Mien.HoaDon;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duck
 */
public class TestHoaDonDAO {
    @Test
    public void testGetHoaDon() throws ClassNotFoundException, SQLException{
        new HoadonDAO();
        ArrayList<String[]> list = HoadonDAO.getHoadon();
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 9);
    }
    
    @Test
    public void testMathangnhap() throws ClassNotFoundException, SQLException{
        new HoadonDAO();
        ArrayList<String[]> list = HoadonDAO.getMathangHDN("HDN004");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 21);
    }
    
    @Test
    public void testInforHDN() throws ClassNotFoundException, SQLException{
        new HoadonDAO();
        String[] t = HoadonDAO.getInforHDN("HDN004");
        Assert.assertNotNull(t);
        Assert.assertEquals(t.length, 4);
        Assert.assertTrue(t[0].compareTo("Nguyễn Văn Định") == 0);
        Assert.assertTrue(t[1].compareTo("Bò Sữa By Boo") == 0);
        Assert.assertTrue(t[2].compareTo("2019-02-28") == 0);
        Assert.assertTrue(t[3].compareTo("") == 0);
    }
    
    @Test
    public void testNextID() throws ClassNotFoundException, SQLException{
        new HoadonDAO();
        String t = HoadonDAO.nextID();
        Assert.assertNotNull(t);
        Assert.assertTrue(t.compareTo("HDN010") == 0);
    }
}
