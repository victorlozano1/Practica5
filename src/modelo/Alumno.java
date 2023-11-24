/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "ALUMNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
    , @NamedQuery(name = "Alumno.findByCodigo", query = "SELECT a FROM Alumno a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alumno.findByFechaNacimiento", query = "SELECT a FROM Alumno a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Alumno.findByNotaMedia", query = "SELECT a FROM Alumno a WHERE a.notaMedia = :notaMedia")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private GregorianCalendar fechaNacimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA_MEDIA")
    private Double notaMedia;
    @JoinColumn(name = "CODIGO_CENTRO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Centro codigoCentro;

    public Alumno() {
    }

    public Alumno(Integer codigo) {
        this.codigo = codigo;
    }

    public Alumno(Integer codigo, String nombre, GregorianCalendar fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

        public Alumno(Integer codigo, String nombre, GregorianCalendar fechaNacimiento, double nota) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.notaMedia=nota;
        //this.codigoCentro=codigo_c;
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public Centro getCodigoCentro() {
        return codigoCentro;
    }

    public void setCodigoCentro(Centro codigoCentro) {
        this.codigoCentro = codigoCentro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controlador.Alumno[ codigo=" + codigo + " ]";
    }
    
}
