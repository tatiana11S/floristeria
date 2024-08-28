/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proveedor;
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
    String new_nombre = "sofia";
    String new_apellido = "arenas";
    String new_telefono = "3102365542";
    String new_correo = "sofiar@gmail.com";
    String new_direccion = "calle 07 #06-12";
    String sql = "UPDATE proveedor set nombre='"+new_nombre+"',apellido='"+new_apellido+"',telefono='"+new_telefono+"',correo='"+new_correo+"',direccion='"+new_direccion+"'where id="+id_editar;
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(cliente.editar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
    st.executeUpdate(sql);
    rs=st.executeQuery("SELECT * FROM proveedor ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("nombre")+"-"+rs.getString("apellido")+"-"+rs.getString("telefono")+"-"+rs.getString("correo")+"-"+rs.getString("direccion"));
    
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(cliente.editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }     
}
