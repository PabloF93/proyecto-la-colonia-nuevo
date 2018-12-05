/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
import proyectopolilacolonia2.Alumno;
import proyectopolilacolonia2.FichaMedica;

/**
 *
 * @author Pablo2
 */
public class Registro_FichasMedicas extends javax.swing.JFrame {

    private ResultSet rs = null;
    private Connection conn = null;
    
    public Registro_FichasMedicas() {
        initComponents();
    }

    private void mostrarAlumnos() {
        rs = new Alumno().list();
        
        DefaultTableModel modelo = (DefaultTableModel) this.personasJTable.getModel();
        modelo.setRowCount(0);
        int columnas = modelo.getColumnCount();
        
        try {
            while(rs.next()) {
                Object fila[] = new Object[columnas];
                
                fila[0] = rs.getObject("id");
                fila[1] = rs.getObject("dni");
                fila[2] = rs.getObject("nombreCompleto");
                
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    private void mostrarProfesores() {
        
    }
    
    private void mostrarAdministrativos() {
        
    }
    
    private void limpiarCampos() {
        
        this.enfermedadPadecidaTxtField.setText("");
        this.enfermedadActualTxtField.setText("");
        this.alergiasTxtField.setText("");
        this.medicamentoActualTxtField.setText("");
        this.obraSocialTxtField.setText("");
        this.direccionTxtArea.setText("");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tipoCBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        buscarDniTxtField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        personasJTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        personaLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        enfermedadPadecidaTxtField = new javax.swing.JTextField();
        enfermedadActualTxtField = new javax.swing.JTextField();
        alergiasTxtField = new javax.swing.JTextField();
        medicamentoActualTxtField = new javax.swing.JTextField();
        obraSocialTxtField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        direccionTxtArea = new javax.swing.JTextArea();
        registrarBtn = new javax.swing.JButton();
        editarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(56, 142, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FICHA MÉDICA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel1.setText("Tipo de usuario:");

        tipoCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alumno", "Profesor", "Administrativo" }));
        tipoCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        personasJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "DNI", "Nombre y apellido"
            }
        ));
        personasJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personasJTableMouseClicked(evt);
            }
        });
        personasJTable.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                personasJTableCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(personasJTable);

        jLabel3.setText("Ficha Medica:");

        personaLbl.setText("...");

        jLabel5.setText("Enfermedades padecidas:");

        jLabel6.setText("Enfermedades que padece:");

        jLabel7.setText("Alergías:");

        jLabel8.setText("Medicamentos o tratamiento medico actual:");

        jLabel9.setText("Cobertura medica u obra social:");

        jLabel10.setText("Direccion:");

        direccionTxtArea.setColumns(20);
        direccionTxtArea.setRows(5);
        jScrollPane2.setViewportView(direccionTxtArea);

        registrarBtn.setText("Registrar ficha");
        registrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBtnActionPerformed(evt);
            }
        });

        editarBtn.setText("Modificar ficha");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buscarDniTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tipoCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enfermedadActualTxtField)
                            .addComponent(enfermedadPadecidaTxtField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(medicamentoActualTxtField))
                    .addComponent(registrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(176, 176, 176)
                        .addComponent(alergiasTxtField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(personaLbl))
                            .addComponent(jLabel10))
                        .addGap(0, 462, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(66, 66, 66)
                        .addComponent(obraSocialTxtField)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tipoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(buscarDniTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(personaLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(enfermedadPadecidaTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(enfermedadActualTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(alergiasTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(medicamentoActualTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(obraSocialTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private void registrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBtnActionPerformed
        String enfermedadPadecida = "", enfermedadActual = "", alergias= "", medicamentos= "", obraSocial= "", direccion= "", datos= "";
        int personaId=0;
        
        if(this.enfermedadPadecidaTxtField.getText().trim().equalsIgnoreCase("")) {
            this.enfermedadPadecidaTxtField.setText("Ninguna");
        } else {
             enfermedadPadecida = this.enfermedadPadecidaTxtField.getText().trim() + "@";
            
        }
        
        if(this.enfermedadActualTxtField.getText().trim().equalsIgnoreCase("")) {
            this.enfermedadActualTxtField.setText("Ninguna");
        } else {
            enfermedadActual = this.enfermedadActualTxtField.getText().trim() + "@";
        }
        
        if(this.alergiasTxtField.getText().trim().equalsIgnoreCase("")) {
            this.alergiasTxtField.setText("Ninguna");
        } else {
            alergias = this.alergiasTxtField.getText().trim() + "@";
        }
        
        if(this.medicamentoActualTxtField.getText().trim().equalsIgnoreCase("")) {
            this.medicamentoActualTxtField.setText("Ninguna");
        } else {
            medicamentos = this.medicamentoActualTxtField.getText().trim() + "@";
        }
        
        if(this.obraSocialTxtField.getText().trim().equalsIgnoreCase("")) {
            this.obraSocialTxtField.setText("Ninguna");
        } else {
            obraSocial = this.obraSocialTxtField.getText().trim() + "@";
        }
        
        direccion = this.direccionTxtArea.getText().trim();
        datos = enfermedadPadecida + enfermedadActual + alergias + medicamentos + obraSocial + direccion;
        
        int fila = this.personasJTable.getSelectedRow();
        personaId = Integer.valueOf(this.personasJTable.getValueAt(fila, 0).toString());
        
        System.out.println(personaId);
        FichaMedica ficha = new FichaMedica();
        ficha.setPersonaId(personaId);
        ficha.setCreated_at(LocalDateTime.now());
        ficha.setUpdated_at(LocalDateTime.now());
        ficha.setDatos(datos);
        ficha.save(ficha);
        
    }//GEN-LAST:event_registrarBtnActionPerformed

    private void tipoCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCBoxActionPerformed
        if(this.tipoCBox.getSelectedItem().toString().equalsIgnoreCase("alumno")) {
            mostrarAlumnos();
        } else {
            if(this.tipoCBox.getSelectedItem().toString().equalsIgnoreCase("profesor")){
                mostrarProfesores();
            } else {
                mostrarAdministrativos();
            }
        }
    }//GEN-LAST:event_tipoCBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) this.personasJTable.getModel();
        int filas = modelo.getRowCount();
        
        String dni = this.buscarDniTxtField.getText().trim();
        
        for(int i=0; i < filas; i++) {
            if(dni.equalsIgnoreCase(this.personasJTable.getValueAt(i, 1).toString())) {
                this.personasJTable.setRowSelectionInterval(i, i);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void personasJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personasJTableMouseClicked
        int fila = this.personasJTable.getSelectedRow();
        String nombre = this.personasJTable.getValueAt(fila, 2).toString();
        int personaId = Integer.valueOf(this.personasJTable.getValueAt(fila, 0).toString());
        
        this.personaLbl.setText(nombre);
        
        rs = new FichaMedica().list(personaId);
        this.limpiarCampos();
        
        try {
            
            while(rs.next()) {
                
                String datos[] = new String[10];
                datos = rs.getString("datos").split("@");
                
                this.enfermedadPadecidaTxtField.setText(datos[0]);
                this.enfermedadActualTxtField.setText(datos[1]);
                this.alergiasTxtField.setText(datos[2]);
                this.medicamentoActualTxtField.setText(datos[3]);
                this.obraSocialTxtField.setText(datos[4]);
                this.direccionTxtArea.setText(datos[5]);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }//GEN-LAST:event_personasJTableMouseClicked

    private void personasJTableCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_personasJTableCaretPositionChanged
        int fila = this.personasJTable.getSelectedRow();
        String nombre = this.personasJTable.getValueAt(fila, 2).toString();
        
        this.personaLbl.setText(nombre);
    }//GEN-LAST:event_personasJTableCaretPositionChanged

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        String enfermedadPadecida = "", enfermedadActual = "", alergias= "", medicamentos= "", obraSocial= "", direccion= "", datos= "";
        int personaId=0;
        
        if(this.enfermedadPadecidaTxtField.getText().trim().equalsIgnoreCase("")) {
            this.enfermedadPadecidaTxtField.setText("Ninguna");
        } else {
             enfermedadPadecida = this.enfermedadPadecidaTxtField.getText().trim() + "@";
            
        }
        
        if(this.enfermedadActualTxtField.getText().trim().equalsIgnoreCase("")) {
            this.enfermedadActualTxtField.setText("Ninguna");
        } else {
            enfermedadActual = this.enfermedadActualTxtField.getText().trim() + "@";
        }
        
        if(this.alergiasTxtField.getText().trim().equalsIgnoreCase("")) {
            this.alergiasTxtField.setText("Ninguna");
        } else {
            alergias = this.alergiasTxtField.getText().trim() + "@";
        }
        
        if(this.medicamentoActualTxtField.getText().trim().equalsIgnoreCase("")) {
            this.medicamentoActualTxtField.setText("Ninguna");
        } else {
            medicamentos = this.medicamentoActualTxtField.getText().trim() + "@";
        }
        
        if(this.obraSocialTxtField.getText().trim().equalsIgnoreCase("")) {
            this.obraSocialTxtField.setText("Ninguna");
        } else {
            obraSocial = this.obraSocialTxtField.getText().trim() + "@";
        }
        
        direccion = this.direccionTxtArea.getText().trim();
        datos = enfermedadPadecida + enfermedadActual + alergias + medicamentos + obraSocial + direccion;
        
        int fila = this.personasJTable.getSelectedRow();
        personaId = Integer.valueOf(this.personasJTable.getValueAt(fila, 0).toString());
        
        System.out.println(personaId);
        FichaMedica ficha = new FichaMedica();
        ficha.setPersonaId(personaId);
        ficha.setCreated_at(LocalDateTime.now());
        ficha.setUpdated_at(LocalDateTime.now());
        ficha.setDatos(datos);
        ficha.update(ficha);
    }//GEN-LAST:event_editarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Registro_FichasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_FichasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_FichasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_FichasMedicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_FichasMedicas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alergiasTxtField;
    private javax.swing.JTextField buscarDniTxtField;
    private javax.swing.JTextArea direccionTxtArea;
    private javax.swing.JButton editarBtn;
    private javax.swing.JTextField enfermedadActualTxtField;
    private javax.swing.JTextField enfermedadPadecidaTxtField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField medicamentoActualTxtField;
    private javax.swing.JTextField obraSocialTxtField;
    private javax.swing.JLabel personaLbl;
    private javax.swing.JTable personasJTable;
    private javax.swing.JButton registrarBtn;
    private javax.swing.JComboBox<String> tipoCBox;
    // End of variables declaration//GEN-END:variables
}
