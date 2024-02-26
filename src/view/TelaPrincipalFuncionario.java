package view;

import dao.AgendamentoDAO;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import dao.UsuarioDAO;
import model.Agendamento;
import model.TransfCodFun;

public class TelaPrincipalFuncionario extends javax.swing.JFrame {

    int COD_FUN;
    
    public TelaPrincipalFuncionario() {
        initComponents();
    }
public void transferirCodFun(TransfCodFun TCF){
        COD_FUN = TCF.getCod_fun();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnConsultClient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        btnConsultAgend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAgendamento = new javax.swing.JTable();
        btnConsultAgend1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empresa");
        setMinimumSize(new java.awt.Dimension(960, 650));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnConsultClient.setBackground(new java.awt.Color(51, 51, 51));
        btnConsultClient.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnConsultClient.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultClient.setText("CONSULTAR CLIENTE");
        btnConsultClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultClientActionPerformed(evt);
            }
        });

        jtClientes.setBackground(new java.awt.Color(153, 153, 153));
        jtClientes.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jtClientes.setForeground(new java.awt.Color(255, 255, 255));
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código do Usuário", "Nome", "Tel", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtClientes);

        btnConsultAgend.setBackground(new java.awt.Color(51, 51, 51));
        btnConsultAgend.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnConsultAgend.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultAgend.setText("CONSULTAR AGENDA");
        btnConsultAgend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultAgendActionPerformed(evt);
            }
        });

        jtAgendamento.setBackground(new java.awt.Color(153, 153, 153));
        jtAgendamento.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        jtAgendamento.setForeground(new java.awt.Color(255, 255, 255));
        jtAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Mês", "Hora", "Código do Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtAgendamento);

        btnConsultAgend1.setBackground(new java.awt.Color(51, 51, 51));
        btnConsultAgend1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnConsultAgend1.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultAgend1.setText("SAIR");
        btnConsultAgend1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultAgend1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btnConsultClient, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultAgend, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConsultAgend1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(433, 433, 433))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultClient, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultAgend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btnConsultAgend1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultAgendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultAgendActionPerformed
        exibirAgenda();
    }//GEN-LAST:event_btnConsultAgendActionPerformed
    public void exibirAgenda(){
    DefaultTableModel modelo = (DefaultTableModel) jtAgendamento.getModel();
        modelo.setNumRows(0);
        AgendamentoDAO adao = new AgendamentoDAO();
        
        for(Agendamento a: adao.read(COD_FUN)){
            modelo.addRow(new String[]{
                Integer.toString(a.getDia()),
                Integer.toString(a.getMes()),
                a.getHora(),
                Integer.toString(a.getCod_usr()),
            });
        }
    }
    private void btnConsultClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultClientActionPerformed
        exibirUsuarios();
    }//GEN-LAST:event_btnConsultClientActionPerformed

    private void btnConsultAgend1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultAgend1ActionPerformed
        this.setVisible(false);
        new TelaLoginFuncionario().setVisible(true);
    }//GEN-LAST:event_btnConsultAgend1ActionPerformed

    public void exibirUsuarios(){
        DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
        modelo.setNumRows(0);
        UsuarioDAO cdao = new UsuarioDAO();
        
        for(Usuario c: cdao.read()){
            modelo.addRow(new String[]{
                Integer.toString(c.getId()),
                c.getNome(),
                c.getTel(),
                c.getEmail()
            });
        }
    }
    
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
            java.util.logging.Logger.getLogger(TelaPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultAgend;
    private javax.swing.JButton btnConsultAgend1;
    private javax.swing.JButton btnConsultClient;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtAgendamento;
    private javax.swing.JTable jtClientes;
    // End of variables declaration//GEN-END:variables
}
