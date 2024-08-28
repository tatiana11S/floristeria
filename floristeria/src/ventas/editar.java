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
public class editar {
   public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    int id_editar=1;
    String new_producto = "rosa roja";
    String new_cantidad = "3";
    String new_fecha_compra = "25-07-2024";
    String new_nro_factura = "001";
    String new_total_factura = "75.000";
    String sql = "UPDATE ventas set producto='"+new_producto+"',cantidad='"+new_cantidad+"',fecha_compra='"+new_fecha_compra+"',nro_factura='"+new_nro_factura+"',total_factura='"+new_total_factura+"'where id="+id_editar;
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(cliente.editar.class.getName()).log(Level.SEVERE, null, ex);    
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
        Logger.getLogger(cliente.editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }    
   
}
