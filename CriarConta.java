/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import java.sql.*;
import connection.ModuloConexao;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaAcesso;
import java.util.Random;


/**
 *
 * @author Dhiego
 */
public class CriarConta extends javax.swing.JFrame {

    //USar a variável de conexão
    Connection conexao = null;
    //Preparando conexão (FRAMEWORK) MANIPULA AS INSTRUÇÕES.
    PreparedStatement pst = null;
    ResultSet rs = null; //EXIBI OS RESULTADOS DAS INSTRUÇÕES SQL
    
    
    //CRIAÇÃO DE VARIÁVEIS
    public int numerocontafinal = 0;
    public int idcliente = 0; //ID DO CLIENTE CRIADO == ID DA CONTA DO CLIENTE CRIADO
    public String nome;
    
    
    
    

    public void gerandonumeroconta(){//GERANDO O NÚMERO DA CONTA DE MANEIRA ALEATÓRIA
   
        Random geranumerocc = new Random();
        int numerogerado = geranumerocc.nextInt(10000);
        
        while (true)
            if(numerogerado < 1000){
                numerogerado = geranumerocc.nextInt(10000);
                
            } else {
                numerocontafinal = numerogerado;
                break;
            }
         
    }
    
    
    
    
  

    
      
    
    
    public void CadastroCliente(){ //CRIANDO O CLIENTE PARA DEPOIS CRIAR A CONTA
        
        
        
        try {
            pst = conexao.prepareStatement("INSERT INTO cliente (Nome, Cpf, Numeroconta) VALUES (?, ?, ?)",Statement.RETURN_GENERATED_KEYS );
            pst.setString(1, txtconfirmanome.getText());
            pst.setString(2, txtconfirmacpf.getText());
            pst.setString(3, null);
            
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                idcliente = rs.getInt(1);
                System.out.println(idcliente);
                
                
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CriarConta.class.getName()).log(Level.SEVERE, null, ex);
        
        
        }
        
    }
    
    
    public void varrenumerocc(){
        String sql = "Select * From conta WHERE Numero = ? ";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numerocontafinal);
            
            rs = pst.executeQuery();
            if(rs.next()){
                gerandonumeroconta();
                numerocontafinal = numerocontafinal;
                atualizandonumerocc();
            }
            
        } catch (Exception e) {
        }
    }
    
 /////////////////////////////////////////////////////////////////////////////////////   
    public void atualizandonumerocc(){
        String sql = "update conta set Numero = ? where Id_conta = ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numerocontafinal);
            pst.setInt(2, idcliente);
            pst.executeUpdate();
            
        } catch (Exception e) {
        }
        
        
        
        
    }
    
    
    
    
    //ESSE MÉTOD PEGA O ID DO CLIENTE CADASTRADO PARA USAR NA CRIAÇÃO DA CONTA.
    
    public void CadastroConta(){
        
        String sql = "INSERT INTO conta (Numero, Senha, Saldo) VALUES (?, ?, ?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numerocontafinal);
            pst.setInt(2, Integer.parseInt(txtcriandosenha.getText()));
            pst.setDouble(3, 0);
            pst.executeUpdate();

            
            
        } catch (SQLException ex) {
            Logger.getLogger(CriarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       


    }

    
 


    
    
    //ESSE MÉTODO ATRIBUI O ÚLTIMO ID CRIADO A CHAVE ESTRANGEIRA (Numeroconta)
    public void attidclient(){
        String attid = "update cliente set Numeroconta=? where Id_cliente = ? ";
        try {
            pst = conexao.prepareStatement(attid);
            pst.setInt(1, idcliente);
            pst.setInt(2, idcliente);
            pst.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println(e);
            
        }

        
    }
    
    
    
    
    
    
    
    
    
    public CriarConta() {
        initComponents();
        //Chamando o modulo CONECTOR 
        conexao = ModuloConexao.conector();
        System.out.println(conexao);
        
        
    
    
    
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtconfirmanome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtconfirmacpf = new javax.swing.JFormattedTextField();
        txtcriandosenha = new javax.swing.JPasswordField();
        txtconfirmasenha = new javax.swing.JPasswordField();
        botaosaircriarconta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jTextField4.setText("jTextField4");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField6.setText("jTextField6");

        jLabel8.setText("jLabel8");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Informe seu nome completo:");

        txtconfirmanome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmanomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Informe seu CPF");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Informe sua senha: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Confirmar senha: ");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 255, 0));
        jButton1.setText("Criar Conta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/9c1a0590528c68138bc08d9df0942f9d - -cone-da-moeda-do-d - lar-by-vexels.png"))); // NOI18N

        try {
            txtconfirmacpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtconfirmacpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmacpfActionPerformed(evt);
            }
        });

        txtcriandosenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcriandosenhaActionPerformed(evt);
            }
        });

        txtconfirmasenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfirmasenhaActionPerformed(evt);
            }
        });

        botaosaircriarconta.setForeground(new java.awt.Color(255, 0, 0));
        botaosaircriarconta.setText("Sair");
        botaosaircriarconta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaosaircriarcontaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(txtcriandosenha)
                        .addComponent(txtconfirmacpf, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(txtconfirmanome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtconfirmasenha, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(botaosaircriarconta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(195, 195, 195))))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtconfirmanome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtconfirmacpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcriandosenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtconfirmasenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaosaircriarconta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("CADASTRO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      
            
        gerandonumeroconta();
        CadastroCliente();
        CadastroConta(); 
        attidclient();  
        atualizandonumerocc();
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso." + 
             "O numero da sua conta é: "+ numerocontafinal);
        txtconfirmacpf.setText("");
        txtconfirmanome.setText("");
        txtconfirmasenha.setText("");
        txtcriandosenha.setText("");

            
        
    

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcriandosenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcriandosenhaActionPerformed
    
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcriandosenhaActionPerformed

    private void botaosaircriarcontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaosaircriarcontaActionPerformed
      
          // TODO add your handling code here:
    }//GEN-LAST:event_botaosaircriarcontaActionPerformed

    private void txtconfirmanomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmanomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmanomeActionPerformed

    private void txtconfirmacpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmacpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfirmacpfActionPerformed

    private void txtconfirmasenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfirmasenhaActionPerformed
       
    }//GEN-LAST:event_txtconfirmasenhaActionPerformed

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
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaosaircriarconta;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JFormattedTextField txtconfirmacpf;
    private javax.swing.JTextField txtconfirmanome;
    private javax.swing.JPasswordField txtconfirmasenha;
    private javax.swing.JPasswordField txtcriandosenha;
    // End of variables declaration//GEN-END:variables
}
