/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import modelo.Alumno;
import modelo.Centro;

/**
 *
 * @author ferna
 */
public class Collection {

    ArrayList<Centro> a;
    ArrayList<Alumno> x;

    public Collection() {
        this.a = new ArrayList<>();
        this.x=new ArrayList<>();
    }

    public ArrayList<Centro> collCentro() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        //Conexion c = new Conexion();
        try {
            conn = (Connection) Conexion.conectar();

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String aux = "select * from Centro";
            rset = stmt.executeQuery(aux);

            while (rset.next()) {
                Centro c = new Centro(rset.getInt("CODIGO"), rset.getString("NOMBRE"), rset.getString("PASSWORD"), rset.getString("IMAGEN"));
                //System.out.println(c);
                a.add(c);
            }

        } catch (Exception e) {
            System.out.println("algo");
        } finally {
            Conexion.close(rset);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        System.out.println(a.size());
        return a;
    }

    public ArrayList<Alumno> collAlumno(int codcentro) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        //Conexion c = new Conexion();
        try {
            conn = (Connection) Conexion.conectar();

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String aux = "select * from Alumno where CODIGO_CENTRO= "+codcentro;
            rset = stmt.executeQuery(aux);

            while (rset.next()) {
                int obtenerCodigo = rset.getInt(1);
                String nombre = rset.getString(2);
                Date Fecha = rset.getDate(3);
                Double notaMedia = rset.getDouble(4);
                GregorianCalendar date = new GregorianCalendar();
                date.setTime(Fecha);
                Alumno a = new Alumno(obtenerCodigo, nombre, date, notaMedia);
                x.add(a);
            }

        } catch (Exception e) {
            System.out.println("me peta");
        } finally {
            Conexion.close(rset);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
//        System.out.println(x.size());
        System.out.println("Hecho");
        System.out.println(x.size());
        return x;
    }
}
