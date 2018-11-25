/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo2
 */
public class Contacto {
    
    private String nombre, telefono, relacion;
    private int id, personaId;
    
    
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }

    public int getPersonaId() {
        return personaId;
    }
    
    public String getRelacion() {
        return relacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }
    public Contacto() {
    }
    
    
    
    
    public ResultSet list(int personaId) {
        
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM contactos WHERE fk_persona=?");
            stmt.setInt(1, personaId);
            
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public void save(Contacto contacto) {
        
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO contactos (fk_persona, nombre, telefono, relacion) VALUES (?,?,?,?)");
            stmt.setInt(1, contacto.getPersonaId());
            stmt.setString(2, contacto.getNombre());
            stmt.setString(3, contacto.getTelefono());
            stmt.setString(4, contacto.getRelacion());
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡COntacto registrado con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void delete (int id) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("DELETE FROM contactos WHERE id=?");
            stmt.setInt(1, id);
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Contacto eliminado con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
