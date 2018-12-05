/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo2
 */
public class Clase {
    private int id, profesorId, categoriaId;
    private boolean deleted = false;
    private String horario;
    private LocalDateTime created_at;
    
    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;

    public int getId() {
        return id;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public String getHorario() {
        return horario;
    }
    
    public boolean isDeleted() {
        return deleted;
    }
    
    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
    
    public Clase() {
    }
    
    public ResultSet list() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM clases");
            rs = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public ResultSet tableView1() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT clases.id, personas.nombreCompleto, categoriasdeportes.nombre, deportes.nombre, clases.horario, categoriasdeportes.valorCuota FROM clases INNER JOIN personas ON personas.id = clases.fk_persona INNER JOIN categoriasdeportes ON categoriasdeportes.id = clases.fk_categoria INNER JOIN deportes ON deportes.id = categoriasdeportes.fk_deporte WHERE clases.deleted=? ORDER BY personas.nombreCompleto");
            stmt.setBoolean(1, false);
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return rs;
    }
    
    public void save(Clase clase) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO clases (fk_persona, fk_categoria, horario, deleted) VALUES (?,?,?,?)");
            stmt.setInt(1, clase.getProfesorId());
            stmt.setInt(2, clase.getCategoriaId());
            stmt.setString(3, clase.getHorario());
            stmt.setBoolean(4, clase.isDeleted());
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Clase registrada con éxito!", "Éxito: clase registrada.", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        
    }
    
    public void delete(int claseId) {
        
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareCall("UPDATE clases SET deleted=? WHERE id=?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, claseId);
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Clase eliminada con éxito!", "Éxito: clase eliminada.", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
