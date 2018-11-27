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
public class CategoriaDeporte {
    
    private int id, deporteId;
    private String nombre;
    private double valorCuota;
    private boolean deleted = false;
    
    private ResultSet rs = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;

    public int getId() {
        return id;
    }

    public int getDeporteId() {
        return deporteId;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeporteId(int deporteId) {
        this.deporteId = deporteId;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public CategoriaDeporte() {
    }
    
    public ResultSet list(int deporteId) {
        
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM categoriasdeportes WHERE fk_deporte=? AND deleted=?");
            stmt.setInt(1, deporteId);
            stmt.setBoolean(2, false);
            
            rs = stmt.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public ResultSet tableView1() {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT categoriasdeportes.id, deportes.nombre, categoriasdeportes.nombre, categoriasdeportes.valorCuota FROM categoriasdeportes INNER JOIN deportes ON deportes.id = categoriasdeportes.fk_deporte WHERE categoriasdeportes.deleted=?");
            stmt.setBoolean(1, false);
            
            rs = stmt.executeQuery();
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return rs;
    }
    
    public void save(CategoriaDeporte categoria) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("INSERT INTO categoriasdeportes (fk_deporte, nombre, valorCuota, deleted) VALUES (?,?,?,?)");
            stmt.setInt(1, categoria.getDeporteId());
            stmt.setString(2, categoria.getNombre());
            stmt.setDouble(3, categoria.getValorCuota());
            stmt.setBoolean(4, categoria.isDeleted());
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Categoria creada con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //solo se actualiza el nombre y el valor de la cuota.
    public void update(CategoriaDeporte categoria) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("UPDATE categoriasdeportes SET nombre=?, valorCuota=? WHERE id=? AND deleted=?");
            stmt.setString(1, categoria.getNombre());
            stmt.setDouble(2, categoria.getValorCuota());
            stmt.setInt(3, categoria.getId());
            stmt.setBoolean(4, categoria.isDeleted());
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Categoría modificada con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int categoriaId) {
        this.conn = ConexionMySql.getConnection();
        try {
            stmt = conn.prepareStatement("UPDATE categoriasdeportes SET deleted=? WHERE id=?");
            stmt.setBoolean(1, true);
            stmt.setInt(2, categoriaId);
            
            int result = stmt.executeUpdate();
            
            if(result == 1) {
                JOptionPane.showMessageDialog(null, "¡Categoría eliminada con éxito!", "¡Éxito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
