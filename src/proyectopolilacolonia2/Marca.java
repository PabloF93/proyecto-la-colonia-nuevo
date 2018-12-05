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

/**
 *
 * @author Pablo2
 */
public class Marca {
    
    private int id, personaId;
    private LocalDateTime created_at;
    
    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;

    public int getId() {
        return id;
    }

    public int getPersonaId() {
        return personaId;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Marca() {
    }
    
    
    
    public ResultSet findByPersonaId(int personaId) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM marcas WHERE fk_persona=? ORDER BY created_at");
            stmt.setInt(1, personaId);
            
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return rs;
    }
    
    public void save(Marca marca) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO marcas (fk_persona, created_at) VALUES (?,?)");
            stmt.setInt(1, marca.getPersonaId());
            stmt.setTimestamp(2, Timestamp.valueOf(marca.getCreated_at()));
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
