/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo2
 */
public class Inscripcion {
    
    private int alumnoId, claseId;
    private LocalDateTime created_at;
    private boolean deleted = false;
    
    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;

    public int getAlumnoId() {
        return alumnoId;
    }

    public int getClaseId() {
        return claseId;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
    
    public boolean isDeleted() {
        return deleted;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public void setClaseId(int claseId) {
        this.claseId = claseId;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    public Inscripcion() {
    }
    
    public ResultSet list() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM clase_persona");
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public ResultSet findByAlumnoId(int alumnoId) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM clase_persona WHERE fk_persona=?");
            stmt.setInt(1, alumnoId);
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public ResultSet tableView1(int alumnoId) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT clases.id, categoriasdeportes.nombre, deportes.nombre, categoriasdeportes.valorCuota FROM clase_persona INNER JOIN clases ON clases.id = clase_persona.fk_clase INNER JOIN categoriasdeportes ON categoriasdeportes.id = clases.fk_categoria INNER JOIN deportes ON deportes.id = categoriasdeportes.fk_deporte WHERE clase_persona.fk_persona=?");
            stmt.setInt(1, alumnoId);
            
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        
        return rs;
    }
    
    public ResultSet tableView2() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT clase_persona.fk_persona, personas.nombreCompleto, clase_persona.fk_clase, clase_persona.created_at FROM clase_persona INNER JOIN personas ON personas.id = clase_persona.fk_persona WHERE clase_persona.deleted=? ORDER BY personas.nombreCompleto");
            stmt.setBoolean(1, false);
            
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    
    public void save(Inscripcion inscripcion) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO clase_persona (fk_persona, fk_clase, deleted, created_at) VALUES (?,?,?,?)");
            stmt.setInt(1, inscripcion.getAlumnoId());
            stmt.setInt(2, inscripcion.getClaseId());
            stmt.setBoolean(3, inscripcion.isDeleted());
            stmt.setTimestamp(4, Timestamp.valueOf(inscripcion.getCreated_at()));
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Clase registrada con éxito!", "Éxito: clase creada.", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }
    
    public void update() {
        
    }
    
    public void delete(Inscripcion inscripcion) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("UPDATE clase_persona SET deleted=? WHERE fk_persona=? AND fk_clase=?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, inscripcion.getAlumnoId());
            stmt.setInt(3, inscripcion.getClaseId());
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Clase eliminada con éxito!", "Éxito: clase eliminada.", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
