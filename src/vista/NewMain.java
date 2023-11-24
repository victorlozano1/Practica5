/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Collection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import controlador.Conexion;
import java.sql.SQLException;
import modelo.Centro;
import java.util.ArrayList;

/**
 *
 * @author ferna
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Collection c = new Collection();
        ArrayList<Centro> a = c.coll();
        System.out.println(a.toString());
    }

}
