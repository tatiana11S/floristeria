/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;
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
    
    String nombre = "alejandro";
    String apellido = "chitiva";
    String telefono = "3152642331";
    String correo = "alejandro@gmail.com";
    String direccion = "calle 27 #06-98";
    String sql = "INSERT INTO cliente (nombre, apellido, telefono, correo, direccion) values ('"+nombre+"','"+apellido+"','"+telefono+"','"+correo+"','"+direccion+"')";

    try{
        
      Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM cliente ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+"-"+rs.getString("apellido")+"-"+rs.getString("telefono")+"-"+rs.getString("correo")+"-"+rs.getString("direccion"));    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }  
  
}
