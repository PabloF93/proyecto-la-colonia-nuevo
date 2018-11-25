/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Pablo2
 */
public abstract class Persona {
    
    private int id, edad;
    private String nombreCompleto, sexo, dni, tipo, codTarjeta, telefono;
    private LocalDate fechaNacimiento;
    private boolean deleted = false;
    private LocalDateTime created_at;
    
    public Connection conn = null;
    public PreparedStatement stmt = null;
    public ResultSet rs = null;

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getCodTarjeta() {
        return codTarjeta;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Persona() {
    }

    public Persona(int id, int edad, String nombreCompleto, String sexo, String dni, String tipo, String codTarjeta, String telefono, LocalDate fechaNacimiento, LocalDateTime created_at) {
        this.id = id;
        this.edad = edad;
        this.nombreCompleto = nombreCompleto;
        this.sexo = sexo;
        this.dni = dni;
        this.tipo = tipo;
        this.codTarjeta = codTarjeta;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.created_at = created_at;
    }

    
    
    
        
    
    
    
}
