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
public class Deporte {
    
    private int id;
    private String nombre;
    private boolean deleted = false;
    
    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isDeleted() {
        return deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Deporte() {
    }
    
    public ResultSet list() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM deportes WHERE deleted=?");
            stmt.setBoolean(1, false);
            
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    public Deporte findByName(String nombreDeporte) {
        Deporte deporte = new Deporte();
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM deportes WHERE nombre=?");
            stmt.setString(1, nombreDeporte);
            
            rs = stmt.executeQuery();
            
            if(rs != null) {
                while(rs.next()) {
                    deporte.setId(rs.getInt("id"));
                    deporte.setNombre(rs.getString("nombre"));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return deporte;
    }
    
    public void save(Deporte deporte) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO deportes (nombre, deleted) VALUES (?,?)");
            stmt.setString(1, deporte.getNombre());
            stmt.setBoolean(2, deporte.isDeleted());
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Deporte creado con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int deporteId) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("UPDATE deportes SET deleted=? WHERE id=?");
            stmt.setBoolean(1, false);
            stmt.setInt(2, deporteId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
