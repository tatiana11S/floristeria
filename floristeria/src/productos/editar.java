/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos;
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
    
    int id_editar=3;
    String new_nombre = "orquidea";
    String new_precio = "85.000";
    String new_stock = "25";
    String new_proveedor = "jose casas";
    String sql = "UPDATE productos set nombre='"+new_nombre+"',precio='"+new_precio+"',stock='"+new_stock+"',proveedor='"+new_proveedor+"'where id="+id_editar;
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM productos ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+"-"+rs.getString("precio")+"-"+rs.getString("stock")+"-"+rs.getString("proveedor"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }    

}
