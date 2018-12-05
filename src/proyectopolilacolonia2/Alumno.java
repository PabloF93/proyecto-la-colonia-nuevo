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
public class Alumno extends Persona {
    
    public ResultSet list() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM personas WHERE tipo=? ORDER BY nombreCompleto");
            stmt.setString(1, "alumno");
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return rs;
    }
    
    public Alumno findByCodTarjeta(String codTarjeta) {
        Alumno alumno = new Alumno();
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM personas WHERE codTarjeta=? AND tipo=? AND isDeleted=?");
            stmt.setString(1, codTarjeta);
            stmt.setString(2, "alumno");
            stmt.setBoolean(3, false);
            
            rs = stmt.executeQuery();
            
            if(rs != null) {
                while(rs.next()) {
                    alumno.setId(rs.getInt("id"));
                    alumno.setCodTarjeta(rs.getString("codTarjeta"));
                    alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                    alumno.setNombreCompleto(rs.getString("nombreCompleto"));
                    alumno.setSexo(rs.getString("sexo"));
                    alumno.setTelefono(rs.getString("telefono"));
                    alumno.setTipo(rs.getString("tipo"));
                    alumno.setDni(rs.getString("dni"));
                    alumno.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                    
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return alumno;
    }
    
    public void save(Alumno alumno) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO personas (dni, codTarjeta, nombreCompleto, fechaNacimiento, telefono, sexo, tipo, isDeleted, created_at) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, alumno.getDni());
            stmt.setString(2, alumno.getCodTarjeta());
            stmt.setString(3, alumno.getNombreCompleto());
            stmt.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            stmt.setString(5, alumno.getTelefono());
            stmt.setString(6, alumno.getSexo());
            stmt.setString(7, alumno.getTipo());
            stmt.setBoolean(8, alumno.isDeleted());
            stmt.setTimestamp(9, Timestamp.valueOf(alumno.getCreated_at()));
            
            int result = stmt.executeUpdate();
            
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Alumno registrado con éxito!", "¡Alumno registrado!", JOptionPane.INFORMATION_MESSAGE);
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("DELETE FROM personas WHERE tipo=? AND id=?");
            stmt.setString(1, "alumno");
            stmt.setInt(1, id);
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Alumno eliminado con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
