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
public class FichaMedica {
    
    private int id, personaId;
    private String datos;
    private LocalDateTime created_at, updated_at;
    
    private ResultSet rs = null;
    private PreparedStatement stmt = null;
    private Connection conn = null;

    public int getId() {
        return id;
    }

    public int getPersonaId() {
        return personaId;
    }

    public String getDatos() {
        return datos;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public FichaMedica() {
    }
    
    public ResultSet list(int personaId) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM fichasmedicas WHERE fk_persona=?");
            stmt.setInt(1, personaId);
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
        
    }
    
    public void save(FichaMedica ficha) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO fichasmedicas (fk_persona, datos, created_at, updated_at) VALUES (?,?,?,?)");
            stmt.setInt(1, ficha.getPersonaId());
            stmt.setString(2, ficha.getDatos());
            stmt.setTimestamp(3, Timestamp.valueOf(ficha.getCreated_at()));
            stmt.setTimestamp(4, Timestamp.valueOf(ficha.getUpdated_at()));
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Ficha médica creada con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public void update(FichaMedica ficha) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("UPDATE fichasmedicas SET datos=?, updated_at=? WHERE fk_persona=?");
            stmt.setString(1, ficha.getDatos());
            stmt.setTimestamp(2, Timestamp.valueOf(ficha.getUpdated_at()));
            stmt.setInt(3, ficha.getPersonaId());
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Ficha médica modificada con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
