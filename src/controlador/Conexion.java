/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.platform.database.DerbyPlatform;

/**
 *
 * @author ferna
 */
public class Conexion {
    
    private static Conexion ref =  new Conexion();

    public Conexion(){
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("No se ha podido cargar los divers");
        }
    }
//      public static Conexion Conectar() throws SQLException {
//          System.out.println("quiere conectarse");
//    String url = "jdbc:derby://localhost:1527/Alumnocentro";
//	return (Conexion) DriverManager.getConnection(url,"Admin1","Admin");
//  } 
    public static Connection conectar() throws SQLException {
    Connection conn = null;
    
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    } catch (ClassNotFoundException ex) {
        System.out.println("No se ha podido cargar los drivers");
    }
    
    String url = "jdbc:derby://localhost:1527/Alumnocentro";
    String usuario = "Admin1";
    String contrasena = "Admin";
    
    try {
        conn = DriverManager.getConnection(url, usuario, contrasena);
        System.out.println("Conexión exitosa");
    } catch (SQLException ex) {
        System.out.println("Error al conectar a la base de datos");
        throw ex;
    }
    
    return conn;
}
  public static void close(ResultSet rs) {
    try {
      rs.close();
    } catch (Exception ignored) {}
  } 

  public static void close(Statement stmt) {
      try{
          if (stmt != null) {
          stmt.close();
          
         }
      }catch(Exception ignored){}
  } 

  public static void close(Connection conn) {
    try {
      conn.close();
    } catch (Exception ignored) {}
  } 
}
