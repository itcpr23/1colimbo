
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author for sale
 */
public class pos {
     public void getProduct(int barc, JTable table){
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/colimboreg?", "root", "");
            
            String sql = "SELECT * FROM product where prod_id=?;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, barc);
            
            ResultSet rs = pstmt.executeQuery();
            DefaultTableModel mod = (DefaultTableModel)table.getModel();
            if(rs.next()){
                mod.addRow(new Object[]{rs.getString("prod_id"),rs.getString("productname"),rs.getString("quantity"),rs.getString("price")});

            }else{
                JOptionPane.showMessageDialog(table, "No Result Found!");
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(pos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(pos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
