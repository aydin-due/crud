/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author aydin
 */
@Entity
@Table(name = "cuentas", catalog = "prueba", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Cuentas.findAll", query = "SELECT c FROM Cuentas c")
    , @NamedQuery(name = "Cuentas.findByPlataforma", query = "SELECT c FROM Cuentas c WHERE c.plataforma = :plataforma")
    , @NamedQuery(name = "Cuentas.findByUsuario", query = "SELECT c FROM Cuentas c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "Cuentas.findByContrase\u00f1a", query = "SELECT c FROM Cuentas c WHERE c.contrase\u00f1a = :contrase\u00f1a")})
public class Cuentas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "plataforma")
    private String plataforma;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contrase\u00f1a")
    private String contraseña;

    public Cuentas() {
    }

    public Cuentas(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        String oldPlataforma = this.plataforma;
        this.plataforma = plataforma;
        changeSupport.firePropertyChange("plataforma", oldPlataforma, plataforma);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        String oldUsuario = this.usuario;
        this.usuario = usuario;
        changeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        String oldContraseña = this.contraseña;
        this.contraseña = contraseña;
        changeSupport.firePropertyChange("contrase\u00f1a", oldContraseña, contraseña);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plataforma != null ? plataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuentas)) {
            return false;
        }
        Cuentas other = (Cuentas) object;
        if ((this.plataforma == null && other.plataforma != null) || (this.plataforma != null && !this.plataforma.equals(other.plataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crud.Cuentas[ plataforma=" + plataforma + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
