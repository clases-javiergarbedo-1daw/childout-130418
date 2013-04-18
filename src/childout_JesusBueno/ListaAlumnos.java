/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_JesusBueno;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author DAW
 */
public class ListaAlumnos extends javax.swing.JPanel {

    int index;
    GestionAlumno gestionAlumno = new GestionAlumno();
    ArrayList<Alumno> listaAlumnosSeleccionada;
    
    

    public ListaAlumnos() {
        Conexion.conectar("localhost", "root", "");
        initComponents();       
        
        if (!java.beans.Beans.isDesignTime()) {

            int numElementos = gestionAlumno.findGrupos().size();
            System.out.println("NumeroElementos" + numElementos);
            String[] arrayParaJComboBox = new String[numElementos];
            gestionAlumno.findGrupos().toArray(arrayParaJComboBox);
            ComboBoxModel c = new DefaultComboBoxModel(arrayParaJComboBox);
            jComboBox1.setModel(c);
            DefaultListModel model = new DefaultListModel();
            jList1.setModel(model);
           this.listarDeNuevo();

        }
    }
    private void listarDeNuevo(){
     DefaultListModel listModel = new DefaultListModel();
        Alumno alumno = null;
        String gruposSeleccionados = jComboBox1.getSelectedItem().toString();
        listaAlumnosSeleccionada = gestionAlumno.findByGrupo(gruposSeleccionados);
        System.out.println(listaAlumnosSeleccionada.size());
        for (int i = 0; i < listaAlumnosSeleccionada.size(); i++) {
           
            String nombreApellidos = listaAlumnosSeleccionada.get(i).getNombre();
            System.out.println(nombreApellidos);

            listModel.add(i, nombreApellidos);
        }

        jList1.setModel(listModel);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jComboBox1 = new javax.swing.JComboBox();
        anadir = new javax.swing.JButton();
        editar = new javax.swing.JButton();

        suprimir.setText("Suprimir");
        suprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suprimirActionPerformed(evt);
            }
        });

        jLabel1.setText("Grupo");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        anadir.setText("Añadir");
        anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(anadir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suprimir))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(anadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suprimir))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void suprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suprimirActionPerformed
        
        
        
        try {
            if (!jList1.isSelectionEmpty()) {
                index = jList1.getSelectedIndex();
                System.out.println("Index: " + index);
                Alumno alumno = listaAlumnosSeleccionada.get(index);

                int id_alumno = alumno.getId_alumno();
                int numeroJoption =JOptionPane.showConfirmDialog(jComboBox1,"Estás seguro que deseas eliminar a "+alumno.getNombre(),"Confirmacion",JOptionPane.OK_CANCEL_OPTION);
                if(numeroJoption==JOptionPane.OK_OPTION){
                
                String sql = "delete  from alumno where id_alumno = '" + id_alumno + "'";

                Statement sentenciaSQL = Conexion.conexion.createStatement();
                sentenciaSQL.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
          
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.listarDeNuevo();


    }//GEN-LAST:event_suprimirActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        this.listarDeNuevo();        

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirActionPerformed
        JDialog Ventana_Detalles_Alumno = new JDialog();
        Ventana_Detalles_Alumno.setLocationRelativeTo(null);
        Ventana_Detalles_Alumno.setVisible(true);

        // Alumno alumnoNuevo = Ventana_Detalles_Alumno.getAlumno();

    }//GEN-LAST:event_anadirActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        if (!jList1.isSelectionEmpty()) {
            index = jList1.getSelectedIndex();
            System.out.println("Index: " + index);
            Alumno alumno = listaAlumnosSeleccionada.get(index);
            System.out.println("Id del Alumno: " + alumno.getId_alumno());
            JDialog Ventana_Detalles_Alumno = new JDialog();
            //Ventana_Detalles_Alumno.setAlumno(alumno);
            Ventana_Detalles_Alumno.setLocationRelativeTo(null);
            Ventana_Detalles_Alumno.setVisible(true);
            

            // Alumno alumnoNuevo = Ventana_Detalles_Alumno.getAlumno();

        }
        
       


        // TODO add your handling code here:
    }//GEN-LAST:event_editarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anadir;
    private javax.swing.JButton editar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton suprimir;
    // End of variables declaration//GEN-END:variables
}
