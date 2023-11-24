/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author ferna
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controlador_Centros {
    
    private int Codigo;
    private String foto;
    
    public void Modificar_Centro(String newNombre, String newPassword, String newImagen){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null; 
        
        try{
            conn =(Connection) Conexion.conectar();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_UPDATABLE);
            
            String sql = "Select * from CENTRO Where CODIGO = "+Codigo;
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                //rs.updateInt("CODIGO", newCodigo);
                rs.updateString("NOMBRE", newNombre);
                rs.updateString("PASSWORD", newPassword);
                rs.updateString("IMAGEN", newImagen);
                
                rs.updateRow();
                System.out.println("Fila" + rs.getRow());
                System.out.println("CODIGO: " + rs.getInt("CODIGO") 
                               + ", NOMBRE: " + rs.getString("NOMBRE")
                               + ", PASSWORD: " + rs.getString("PASSWORD")
                               + ", FOTO: " + rs.getString("IMAGEN"));
                setFoto(rs.getString("IMAGEN"));
            }
            conn.commit();
            
        }catch(SQLException Ex){}
        finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
       
    public void setFoto(String x){
        foto = x;
    }
    
    public String getFoto(){
        return foto;
}
    //metodo Para JPANEL Validar
    public boolean entrar(String Usuario, String Contraseña){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs = null; 
        boolean ENTRA = false;
        
        try{
            conn =(Connection) Conexion.conectar();
            stmt = conn.prepareStatement("SELECT CODIGO, NOMBRE,IMAGEN, PASSWORD FROM CENTRO WHERE NOMBRE =? AND PASSWORD=?");
            stmt.setString(1, Usuario);
            stmt.setString(2, Contraseña);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                ENTRA = true;
                Codigo = rs.getInt("CODIGO");
                foto = rs.getString("IMAGEN");
                
            }            
        }catch(SQLException Ex){}
        finally {
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return ENTRA;
    }
    
    public int getCODIGO(){
        return Codigo;
    }
    
}

