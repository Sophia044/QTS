package gui;

import modelo.Usuario;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;

/**
 * Formulário principal do sistema de Cadastro de Usuário.
 * Gerado pelo NetBeans GUI Builder (Design Visual).
 *
 * Componentes presentes no formulário:
 *   jLabel1      → rótulo "Cadastro de Usuário" (tamanho 18)
 *   jPanel1      → painel com borda "Cadastrar novo usuário"
 *   jLabel2      → rótulo "Nome"
 *   jLabel3      → rótulo "CPF"
 *   jLabel4      → rótulo "Email"
 *   jLabel5      → rótulo "Telefone"
 *   jTextField1  → campo de texto Nome
 *   jTextField2  → campo de texto CPF
 *   jTextField3  → campo de texto Email
 *   jTextField4  → campo de texto Telefone
 *   jButton1     → botão "Cadastrar"
 *   jButton2     → botão "Limpar"
 *   jButton3     → botão "SAIR"
 */
public class UsuarioGUI extends javax.swing.JFrame {

    /**
     * Construtor padrão gerado pelo NetBeans.
     * Chama initComponents() para montar o formulário.
     */
    public UsuarioGUI() {
        initComponents();
    }

    /**
     * Método gerado automaticamente pelo NetBeans GUI Builder.
     * NÃO edite este método manualmente pelo editor de código-fonte;
     * use o Design Visual do NetBeans.
     *
     * Aqui são criados e posicionados todos os componentes do formulário.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        // ── Instanciação dos componentes ───────────────────────────────────────
        jLabel1     = new javax.swing.JLabel();
        jPanel1     = new javax.swing.JPanel();
        jLabel2     = new javax.swing.JLabel();
        jLabel3     = new javax.swing.JLabel();
        jLabel4     = new javax.swing.JLabel();
        jLabel5     = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1    = new javax.swing.JButton();
        jButton2    = new javax.swing.JButton();
        jButton3    = new javax.swing.JButton();

        // ── Título da janela ───────────────────────────────────────────────────
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Usuário");

        // ── jLabel1: rótulo principal "Cadastro de Usuário" (fonte tamanho 18) ─
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18));
        jLabel1.setText("Cadastro de Usuário");

        // ── jPanel1: painel com borda de título ────────────────────────────────
        jPanel1.setBorder(
            javax.swing.BorderFactory.createTitledBorder("Cadastrar novo usuário")
        );

        // ── Rótulos dentro do painel ───────────────────────────────────────────
        jLabel2.setText("Nome");
        jLabel3.setText("CPF");
        jLabel4.setText("Email");
        jLabel5.setText("Telefone");

        // ── Botões ─────────────────────────────────────────────────────────────
        jButton1.setText("Cadastrar");
        jButton2.setText("Limpar");
        jButton3.setText("SAIR");

        // ── Eventos dos botões ─────────────────────────────────────────────────

        // Evento do botão Cadastrar (jButton1)
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        // Evento do botão Limpar (jButton2)
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        // Evento do botão SAIR (jButton3)
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        // ── Layout do painel interno (jPanel1) via GroupLayout ─────────────────
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE,
                                      javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE,
                                      javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE,
                                      javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE,
                                      javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // ── Layout da janela principal via GroupLayout ──────────────────────────
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                      javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3)))
                    .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                  javax.swing.GroupLayout.DEFAULT_SIZE,
                                  javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null); // centraliza a janela na tela
    }

    // =========================================================================
    //  Passo 9: Evento CADASTRAR (jButton1)
    // =========================================================================
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        // instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
        Usuario usuarios = new Usuario();
        usuarios.setNome(jTextField1.getText());
        usuarios.setCpf(jTextField2.getText());
        usuarios.setEmail(jTextField3.getText());
        usuarios.setTelefone(jTextField4.getText());

        // fazendo a validação dos dados
        if ((jTextField1.getText().isEmpty()) || (jTextField2.getText().isEmpty()) ||
            (jTextField3.getText().isEmpty()) || (jTextField4.getText().isEmpty())) {

            JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");

        } else {

            // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
            UsuarioDAO dao = new UsuarioDAO();
            dao.adiciona(usuarios);
            JOptionPane.showMessageDialog(null, "Usuário " + jTextField1.getText() + " inserido com sucesso!");
        }
    }

    // =========================================================================
    //  Passo 8: Evento LIMPAR (jButton2)
    // =========================================================================
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        // apaga os dados preenchidos nos campos de texto
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

    // =========================================================================
    //  Passo 7: Evento SAIR (jButton3)
    // =========================================================================
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        // Este comando fecha a janela em execução
        System.exit(0);
    }

    // =========================================================================
    //  Método main – ponto de entrada da aplicação
    // =========================================================================
    public static void main(String args[]) {

        // Garante que a GUI seja criada na Event Dispatch Thread (EDT)
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioGUI().setVisible(true);
            }
        });
    }

    // =========================================================================
    //  Declaração das variáveis dos componentes (gerada pelo NetBeans)
    //  NÃO modifique esta seção manualmente
    // =========================================================================
    private javax.swing.JButton    jButton1;    // Cadastrar
    private javax.swing.JButton    jButton2;    // Limpar
    private javax.swing.JButton    jButton3;    // SAIR
    private javax.swing.JLabel     jLabel1;     // título "Cadastro de Usuário"
    private javax.swing.JLabel     jLabel2;     // "Nome"
    private javax.swing.JLabel     jLabel3;     // "CPF"
    private javax.swing.JLabel     jLabel4;     // "Email"
    private javax.swing.JLabel     jLabel5;     // "Telefone"
    private javax.swing.JPanel     jPanel1;     // painel "Cadastrar novo usuário"
    private javax.swing.JTextField jTextField1; // campo Nome
    private javax.swing.JTextField jTextField2; // campo CPF
    private javax.swing.JTextField jTextField3; // campo Email
    private javax.swing.JTextField jTextField4; // campo Telefone
}
