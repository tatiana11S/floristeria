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
public class consultar {
    public static void main (String[] args){
    conexion con=new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    
    try{
     Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException ex){
        Logger.getLogger(cliente.consultar.class.getName()).log(Level.SEVERE, null, ex);    
    }
    try{
    cn=con.getConection();
    st=cn.createStatement();
      rs=st.executeQuery("SELECT * FROM ventas ");
    rs.next();
    
    do{
    System.out.println(rs.getInt("id")+":"+rs.getString("producto")+"-"+rs.getString("cantidad")+"-"+rs.getString("fecha_compra")+"-"+rs.getString("nro_factura")+"-"+rs.getString("total_factura"));    

   
    }while (rs.next());
    
    
    }catch (SQLException ex){
        Logger.getLogger(cliente.consultar.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    } 
}
