/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import modelo.Alumno;
import sun.util.calendar.Gregorian;
import vista.principal;

/**
 *
 * @author Víctor
 */
public class Detalle {

    private Connection conexion;
    private Statement statementDetalle;
    private Statement statementResumen;
    private ResultSet rs;

    public Detalle() {
        try {

            conexion = Conexion.conectar();

            statementDetalle = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // statementResumen = conexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet ejecutarConsulta(String consulta) throws SQLException {
        rs = statementDetalle.executeQuery(consulta);
        return rs;
    }

    public void avanzar() throws SQLException {
        rs.next();
    }

    public void retroceder() throws SQLException {
        rs.previous();
    }

    public Alumno obtenerDatos() throws SQLException {
        int obtenerCodigo = rs.getInt(1);
        String nombre = rs.getString(2);
        Date Fecha = rs.getDate(3);
        Double notaMedia = rs.getDouble(4);
        int obtenerCodCentro = rs.getInt(5);
        GregorianCalendar date = new GregorianCalendar();
        date.setTime(Fecha);
        Alumno a = new Alumno(obtenerCodigo, nombre, date, notaMedia);
        return a;
        // Puedes hacer algo con los datos obtenidos
    }

    public void irAlPrincipio() throws SQLException {
        rs.first();
    }

    public void irAlFinal() throws SQLException {
        rs.last();
    }

    public boolean esUltimo() throws SQLException {
        return rs.isLast();
    }

    public boolean esPrimero() throws SQLException {
        return rs.isFirst();
    }

    public void guardarRegistro(String nuevoNombre, Date nuevaFechaNacimiento, double nuevaMedia, int codCentro) throws SQLException {
        rs.updateString(2, nuevoNombre);
        //new java.sql.Date = nuevaFechaNacimiento;
        rs.updateDate(3, new java.sql.Date(nuevaFechaNacimiento.getTime()));
        rs.updateDouble(4, nuevaMedia);
        //rs.updateInt(5, codCentro);
        rs.updateRow();
    }

    public void cerrarConexion() {
        try {
            if (statementDetalle != null) {
                statementDetalle.close();
            }
            if (statementResumen != null) {
                statementResumen.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
