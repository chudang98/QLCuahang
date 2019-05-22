
import Control.Nha_Cung_Cap;
import Packages_Dang.Controller.NhaCCDAO;
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
public class TestNhaCCDAO {
    @Test
    public void testGetallncc() throws ClassNotFoundException, SQLException{
        new NhaCCDAO();
        ArrayList<Nha_Cung_Cap> list = NhaCCDAO.getAllNCC();
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 9);
    }
    
    @Test
    public void testGetallIdNV() throws ClassNotFoundException, SQLException{
        new NhaCCDAO();
        ArrayList<String>list = NhaCCDAO.getAllIDNV();
        
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 10);
    }
    
    @Test
    public void testGetallIdNCC() throws ClassNotFoundException, SQLException{
        new NhaCCDAO();
        ArrayList<String> list = NhaCCDAO.getAllIDNCC();
        
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(), 9);
    }
}
