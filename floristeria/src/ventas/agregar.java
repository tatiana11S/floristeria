/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tatia
 */
public class agregar {
  public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String producto = "primavera";
    String cantidad = "2";
    String fecha_compra = "1-07-2024";
    String nro_factura = "010";
    String total_factura = "66.000";
    String sql = "INSERT INTO ventas (producto, cantidad, fecha_compra, nro_factura, total_factura) values ('"+producto+"','"+cantidad+"','"+fecha_compra+"','"+nro_factura+"','"+total_factura+"')";

    try{
        
      Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(cliente.agregar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM ventas ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("producto")+"-"+rs.getString("cantidad")+"-"+rs.getString("fecha_compra")+"-"+rs.getString("nro_factura")+"-"+rs.getString("total_factura"));    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(cliente.agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }    
}
