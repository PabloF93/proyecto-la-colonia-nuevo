/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import proyectopolilacolonia2.Alumno;
import proyectopolilacolonia2.Inscripcion;
import proyectopolilacolonia2.Marca;
import proyectopolilacolonia2.Profesor;

public class Principal extends javax.swing.JFrame {

    private Scanner lector = new Scanner(System.in);
    private ResultSet rs = null;
    
    public Principal() {
        initComponents();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        habilitarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        horaEventoTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tipoTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inscripcionesJTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        usuariosJMenu = new javax.swing.JMenu();
        administrarUsuariosJMenuItem = new javax.swing.JMenuItem();
        contactosUsuariosJMenuItem = new javax.swing.JMenuItem();
        fichasMedicasJMenuItem = new javax.swing.JMenuItem();
        deportesCategoriasJMenu = new javax.swing.JMenu();
        administrarDeportesJMenuItem = new javax.swing.JMenuItem();
        clasesJMenu = new javax.swing.JMenu();
        administrarClasesJMenuItem = new javax.swing.JMenuItem();
        inscripcionesJMenuItem = new javax.swing.JMenuItem();
        marcasJMenu = new javax.swing.JMenu();
        administrarMarcasJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        habilitarBtn.setText("Habilitar paso de tarjeta");
        habilitarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre y apellido:");

        nombreTxtField.setEditable(false);

        jLabel2.setText("Hora del evento:");

        horaEventoTxtField.setEditable(false);

        jLabel3.setText("Tipo:");

        tipoTxtField.setEditable(false);

        jLabel4.setText("Listado de inscripciones a clases:");

        inscripcionesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº de clase", "Deporte", "Categoría", "Cuota mensual"
            }
        ));
        jScrollPane1.setViewportView(inscripcionesJTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(habilitarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoTxtField)
                            .addComponent(horaEventoTxtField)
                            .addComponent(nombreTxtField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(habilitarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(horaEventoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tipoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem7.setText("Salir...");
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        usuariosJMenu.setText("Usuarios");

        administrarUsuariosJMenuItem.setText("Administrar usuarios");
        administrarUsuariosJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarUsuariosJMenuItemActionPerformed(evt);
            }
        });
        usuariosJMenu.add(administrarUsuariosJMenuItem);

        contactosUsuariosJMenuItem.setText("Contactos de usuarios");
        contactosUsuariosJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactosUsuariosJMenuItemActionPerformed(evt);
            }
        });
        usuariosJMenu.add(contactosUsuariosJMenuItem);

        fichasMedicasJMenuItem.setText("Fichas Médicas");
        fichasMedicasJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fichasMedicasJMenuItemActionPerformed(evt);
            }
        });
        usuariosJMenu.add(fichasMedicasJMenuItem);

        jMenuBar1.add(usuariosJMenu);

        deportesCategoriasJMenu.setText("Deportes y categorias");

        administrarDeportesJMenuItem.setText("Administrar...");
        administrarDeportesJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarDeportesJMenuItemActionPerformed(evt);
            }
        });
        deportesCategoriasJMenu.add(administrarDeportesJMenuItem);

        jMenuBar1.add(deportesCategoriasJMenu);

        clasesJMenu.setText("Clases");

        administrarClasesJMenuItem.setText("Administrar clases...");
        administrarClasesJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarClasesJMenuItemActionPerformed(evt);
            }
        });
        clasesJMenu.add(administrarClasesJMenuItem);

        inscripcionesJMenuItem.setText("Inscripciones de alumnos");
        inscripcionesJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inscripcionesJMenuItemActionPerformed(evt);
            }
        });
        clasesJMenu.add(inscripcionesJMenuItem);

        jMenuBar1.add(clasesJMenu);

        marcasJMenu.setText("Entradas y salidas");

        administrarMarcasJMenuItem.setText("Administrar...");
        administrarMarcasJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administrarMarcasJMenuItemActionPerformed(evt);
            }
        });
        marcasJMenu.add(administrarMarcasJMenuItem);

        jMenuBar1.add(marcasJMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void administrarUsuariosJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarUsuariosJMenuItemActionPerformed
        Registro_Personas f1 = new Registro_Personas();
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_administrarUsuariosJMenuItemActionPerformed

    private void contactosUsuariosJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactosUsuariosJMenuItemActionPerformed
        Registro_Contactos f1 = new Registro_Contactos();
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_contactosUsuariosJMenuItemActionPerformed

    private void fichasMedicasJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fichasMedicasJMenuItemActionPerformed
        Registro_FichasMedicas f1 = new Registro_FichasMedicas();
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_fichasMedicasJMenuItemActionPerformed

    private void administrarDeportesJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarDeportesJMenuItemActionPerformed
        Registro_Deportes_Categorias f1 = new Registro_Deportes_Categorias();
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_administrarDeportesJMenuItemActionPerformed

    private void administrarClasesJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarClasesJMenuItemActionPerformed
        Registro_Clases f1 = new Registro_Clases();
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_administrarClasesJMenuItemActionPerformed

    private void inscripcionesJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inscripcionesJMenuItemActionPerformed
        Registro_Inscripciones f1 = new Registro_Inscripciones();
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_inscripcionesJMenuItemActionPerformed

    private void habilitarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarBtnActionPerformed
        
        
        System.out.println("Por favor pase la tarjeta.");
        String codigo = lector.nextLine();
        
        this.nombreTxtField.setText("");
        this.horaEventoTxtField.setText("");
        this.tipoTxtField.setText("");
        
        DefaultTableModel modelo = (DefaultTableModel) this.inscripcionesJTable.getModel();
        int columnas = modelo.getColumnCount();
        modelo.setRowCount(0);
        
        
        Alumno alumno = new Alumno().findByCodTarjeta(codigo);
        this.horaEventoTxtField.setText(LocalDateTime.now().toString());
        
        Marca marca = new Marca();
        
        if(alumno.getId() != 0) {
            
            this.nombreTxtField.setText(alumno.getNombreCompleto());
            
            this.tipoTxtField.setText(alumno.getTipo());

            Inscripcion inscripcion = new Inscripcion();

            rs = inscripcion.tableView1(alumno.getId());

            try {
                while(rs.next()) {
                    Object fila[] = new Object[columnas];

                    for(int i=0; i < fila.length; i++) {
                        fila[i] = rs.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            
            marca.setPersonaId(alumno.getId());
            marca.setCreated_at(LocalDateTime.now());
            marca.save(marca);
            
        } else {
            Profesor profesor = new Profesor().findByCodTarjeta(codigo);
            
            if(profesor.getId() != 0) {
                this.nombreTxtField.setText(profesor.getNombreCompleto());
                this.tipoTxtField.setText(profesor.getTipo());

                marca.setPersonaId(profesor.getId());
                marca.setCreated_at(LocalDateTime.now());
                marca.save(marca);
            }
            
            
        }
        
        
    }//GEN-LAST:event_habilitarBtnActionPerformed

    private void administrarMarcasJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administrarMarcasJMenuItemActionPerformed
        Administrar_Marcas f1 = new Administrar_Marcas();
        f1.setVisible(true);
        f1.setLocationRelativeTo(null);
    }//GEN-LAST:event_administrarMarcasJMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal p1 = new Principal();
                p1.setVisible(true);
                p1.setLocationRelativeTo(null);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem administrarClasesJMenuItem;
    private javax.swing.JMenuItem administrarDeportesJMenuItem;
    private javax.swing.JMenuItem administrarMarcasJMenuItem;
    private javax.swing.JMenuItem administrarUsuariosJMenuItem;
    private javax.swing.JMenu clasesJMenu;
    private javax.swing.JMenuItem contactosUsuariosJMenuItem;
    private javax.swing.JMenu deportesCategoriasJMenu;
    private javax.swing.JMenuItem fichasMedicasJMenuItem;
    private javax.swing.JButton habilitarBtn;
    private javax.swing.JTextField horaEventoTxtField;
    private javax.swing.JMenuItem inscripcionesJMenuItem;
    private javax.swing.JTable inscripcionesJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu marcasJMenu;
    private javax.swing.JTextField nombreTxtField;
    private javax.swing.JTextField tipoTxtField;
    private javax.swing.JMenu usuariosJMenu;
    // End of variables declaration//GEN-END:variables
}
