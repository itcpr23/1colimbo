
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author for sale
 */
public class prodClass {
    
    public int addprod(String pname, int quant, Object price){
        int x =0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/colimboreg?","root","");
            String sql = "insert into product values(null,?,?,?);";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, pname);
            pstmt.setInt(2, quant);
            pstmt.setObject(3, price);
            
            x = pstmt.executeUpdate();
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(prodClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(prodClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return x;
    }
    public int addQuantity(int id, Object quant){
        int x = 0;
            try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/colimboreg?","root","");
            String sql = "update product set quantity = quantity + ? where prod_id=?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, quant.toString());
            pstmt.setInt(2, id);
            
            
            x = pstmt.executeUpdate();
            
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(prodClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(prodClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return x;
    }
    
    
    
}
