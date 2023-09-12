/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Diego
 */
public class FrmMenuAgregar extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuAgregar
     */
    public FrmMenuAgregar() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú del día (Agregar)");

        jPanel1.setBackground(new java.awt.Color(239, 237, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menú del día");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frames.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(239, 237, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agregar comida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 16), new java.awt.Color(229, 0, 80))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(239, 237, 255));
        btnEliminar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnEliminar.png"))); // NOI18N
        btnEliminar.setText(" Eliminar");
        btnEliminar.setFocusPainted(false);
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 160, -1));

        btnAgregar.setBackground(new java.awt.Color(239, 237, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(51, 51, 51));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnAgregar.png"))); // NOI18N
        btnAgregar.setText(" Agregar");
        btnAgregar.setFocusPainted(false);
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 160, -1));

        btnModificar.setBackground(new java.awt.Color(239, 237, 255));
        btnModificar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(51, 51, 51));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnModificar.png"))); // NOI18N
        btnModificar.setText(" Modificar");
        btnModificar.setFocusPainted(false);
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 160, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tipo de comida:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        comboTipo.setBackground(new java.awt.Color(239, 237, 255));
        comboTipo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo de comida", "Plato Fuerte", "Bebida", "Postre" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        jPanel2.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 350, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombre:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 350, 35));

        txtPrecio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 350, 35));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Precio:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));
        jPanel2.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 100, -1));

        btnConfirmar.setText("Confirmar seleccion tabla");
        jPanel2.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 320, 210, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 790, 360));

        tablaMenu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        tablaMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo de Comida", "Nombre", "Precio"
            }
        ));
        tablaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMenu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 790, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void tablaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMenuMouseClicked
        // TODO add your handling code here:
        int seleccionar = tablaMenu.rowAtPoint(evt.getPoint());
        txtID.setText(String.valueOf(tablaMenu.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_tablaMenuMouseClicked

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
            java.util.logging.Logger.getLogger(FrmMenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuAgregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnConfirmar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaMenu;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}