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
public class editar {
    public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    int id_editar=8;
    String new_nombre = "juan";
    String new_apellido = "neruda";
    String new_telefono = "3185342012";
    String new_correo = "jneruda@gmail.com";
    String new_direccion = "cra 15 #01-98";
    String sql = "UPDATE cliente set nombre='"+new_nombre+"',apellido='"+new_apellido+"',telefono='"+new_telefono+"',correo='"+new_correo+"',direccion='"+new_direccion+"'where id="+id_editar;
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);    
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
        Logger.getLogger(editar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }    

}
