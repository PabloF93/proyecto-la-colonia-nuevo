/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia2;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pablo2
 */
public class ConexionMySql {
    
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/lacoloniabd";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Conectado con éxito!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return conn;
    }
}
