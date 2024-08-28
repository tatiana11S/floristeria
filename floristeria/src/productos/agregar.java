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
public class agregar {
    public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    String nombre = "primavera";
    String precio = "33.000";
    String stock = "15";                
    String proveedor = "jose casas";
    String sql = "INSERT INTO productos (nombre, precio, stock, proveedor) values ('"+nombre+"','"+precio+"','"+stock+"','"+proveedor+"')";

    try{
        
      Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
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
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
}
