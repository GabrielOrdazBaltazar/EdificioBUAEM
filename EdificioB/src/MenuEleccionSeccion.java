
import Clases.EdificioB;
import Clases.EdificioBSQL;


public class MenuEleccionSeccion extends javax.swing.JFrame {
    private int id_usuario;

    public MenuEleccionSeccion(int id_usuario) {
        initComponents();
        this.id_usuario = id_usuario;
    }

    public MenuEleccionSeccion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAcervoBibliogafico = new javax.swing.JButton();
        btnAreaAbierta = new javax.swing.JButton();
        btnAreaEstudio = new javax.swing.JButton();
        btnAutoAcceso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SELECCIONA EL LUGAR AL QUE TE DIRIGES ");

        btnAcervoBibliogafico.setText("ACERVO BIBLIOGRAFICO");
        btnAcervoBibliogafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcervoBibliogaficoActionPerformed(evt);
            }
        });

        btnAreaAbierta.setText("AREA ABIERTA (VITRAL)");
        btnAreaAbierta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaAbiertaActionPerformed(evt);
            }
        });

        btnAreaEstudio.setText("AREA ESTUDIO");
        btnAreaEstudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaEstudioActionPerformed(evt);
            }
        });

        btnAutoAcceso.setText("AUTO ACCESO");
        btnAutoAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoAccesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAutoAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAcervoBibliogafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAreaAbierta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAreaEstudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcervoBibliogafico, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAreaAbierta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAreaEstudio, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAutoAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAreaAbiertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaAbiertaActionPerformed
        EdificioB edificioB = new EdificioB(id_usuario,0,1,0,0);
        EdificioBSQL edificioBSQL = new EdificioBSQL();
        
        edificioBSQL.ingresarEdificioB(edificioB);
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_btnAreaAbiertaActionPerformed

    private void btnAcervoBibliogaficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcervoBibliogaficoActionPerformed
        //Instanciando objetos
        EdificioB edificioB = new EdificioB(id_usuario,1,0,0,0);
        EdificioBSQL edificioBSQL = new EdificioBSQL();
        
        edificioBSQL.ingresarEdificioB(edificioB);
        this.setVisible(false);
        System.exit(0);
        
    }//GEN-LAST:event_btnAcervoBibliogaficoActionPerformed

    private void btnAutoAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoAccesoActionPerformed
        EdificioB edificioB = new EdificioB(id_usuario,0,0,1,0);
        EdificioBSQL edificioBSQL = new EdificioBSQL();
        
        edificioBSQL.ingresarEdificioB(edificioB);
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_btnAutoAccesoActionPerformed

    private void btnAreaEstudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaEstudioActionPerformed
        EdificioB edificioB = new EdificioB(id_usuario,0,0,0,1);
        EdificioBSQL edificioBSQL = new EdificioBSQL();
        
        edificioBSQL.ingresarEdificioB(edificioB);
        
        this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_btnAreaEstudioActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEleccionSeccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcervoBibliogafico;
    private javax.swing.JButton btnAreaAbierta;
    private javax.swing.JButton btnAreaEstudio;
    private javax.swing.JButton btnAutoAcceso;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
