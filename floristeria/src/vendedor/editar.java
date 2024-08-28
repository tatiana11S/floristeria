/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendedor;
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
    
    int id_editar=6;
    String new_nombre = "lolita";
    String new_apellido = "perez";
    String new_telefono = "3021456980";
    String new_correo = "lolitap@gmail.com";
    String new_direccion = "calle 20 # 104-25";
    String sql = "UPDATE vendedor set nombre='"+new_nombre+"',apellido='"+new_apellido+"',telefono='"+new_telefono+"',correo='"+new_correo+"',direccion='"+new_direccion+"'where id="+id_editar;
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(cliente.editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM vendedor ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+"-"+rs.getString("apellido")+"-"+rs.getString("telefono")+"-"+rs.getString("correo")+"-"+rs.getString("direccion"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(cliente.editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }     
}
