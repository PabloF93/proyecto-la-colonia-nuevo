/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia2;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo2
 */
public class Profesor extends Persona {
    
    public ResultSet list() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM personas WHERE tipo=? AND isDeleted=?");
            stmt.setString(1, "profesor");
            stmt.setBoolean(2, false);
            
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public Profesor findById(int id) {
        Profesor profesor = new Profesor();
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM personas WHERE id=?");
            stmt.setInt(0, id);
            
            rs = stmt.executeQuery();
            
            if(rs != null) {
                while(rs.next()) {
                    profesor.setId(rs.getInt("id"));
                    profesor.setNombreCompleto(rs.getString("nombreCompleto"));
                    profesor.setDni(rs.getString("dni"));
                    profesor.setCodTarjeta(rs.getString("codTarjeta"));
                    profesor.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    profesor.setSexo(rs.getString("sexo"));
                    profesor.setDeleted(rs.getBoolean("isDeleted"));
                    profesor.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return profesor;
    }
    
    public Profesor findByName(String nombreProfesor) {
        Profesor profesor = new Profesor();
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM personas WHERE nombreCompleto=? AND isDeleted=?");
            stmt.setString(1, nombreProfesor);
            stmt.setBoolean(2, false);
            
            rs = stmt.executeQuery();
            
            if(rs != null) {
                while(rs.next()) {
                    profesor.setId(rs.getInt("id"));
                    profesor.setNombreCompleto(rs.getString("nombreCompleto"));
                    profesor.setDni(rs.getString("dni"));
                    profesor.setCodTarjeta(rs.getString("codTarjeta"));
                    profesor.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    profesor.setSexo(rs.getString("sexo"));
                    profesor.setDeleted(rs.getBoolean("isDeleted"));
                    profesor.setTipo(rs.getString("tipo"));
                    profesor.setTelefono(rs.getString("telefono"));
                    profesor.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return profesor;
        
    }
    
    public Profesor findByCodTarjeta(String codTarjeta) {
        Profesor profesor = new Profesor();
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM personas WHERE codTarjeta=? AND tipo=? AND isDeleted=?");
            stmt.setString(1, codTarjeta);
            stmt.setString(2, "profesor");
            stmt.setBoolean(3, false);
            
            rs = stmt.executeQuery();
            
            if(rs != null) {
                while(rs.next()) {
                    profesor.setId(rs.getInt("id"));
                    profesor.setNombreCompleto(rs.getString("nombreCompleto"));
                    profesor.setDni(rs.getString("dni"));
                    profesor.setCodTarjeta(rs.getString("codTarjeta"));
                    profesor.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    profesor.setSexo(rs.getString("sexo"));
                    profesor.setDeleted(rs.getBoolean("isDeleted"));
                    profesor.setTipo(rs.getString("tipo"));
                    profesor.setTelefono(rs.getString("telefono"));
                    profesor.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return profesor;
    }
    
    public void save(Profesor profesor) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO personas (dni, codTarjeta, nombreCompleto, fechaNacimiento, telefono, sexo, tipo, isDeleted, created_at) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, profesor.getDni());
            stmt.setString(2, profesor.getCodTarjeta());
            stmt.setString(3, profesor.getNombreCompleto());
            stmt.setDate(4, Date.valueOf(profesor.getFechaNacimiento()));
            stmt.setString(5, profesor.getTelefono());
            stmt.setString(6, profesor.getSexo());
            stmt.setString(7, profesor.getTipo());
            stmt.setBoolean(8, profesor.isDeleted());
            stmt.setTimestamp(9, Timestamp.valueOf(profesor.getCreated_at()));
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Profesor registrado con éxito!", "Éxito: profesor registrado.", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        
    }
    
    public void delete() {
        
    }
    
}
