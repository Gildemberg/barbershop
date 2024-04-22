
package view.cliente;

import com.raven.datechooser.SelectedDate;
import controller.AgendamentoController;
import dao.BarbeariaDAO;
import java.util.ArrayList;
import java.util.List;
import model.Barbearia;
import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import model.Servico;


public class TelaAgendamentoCliente extends javax.swing.JFrame{

    int CODCLIENTE, CODBARBEARIA, CODAGENDAMENTO;
    AgendamentoController agendamentoController = new AgendamentoController();
    SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    BarbeariaDAO barbeariaDao = new BarbeariaDAO();
    List<Servico> servicos = new ArrayList();
    List<Barbearia> barbearias = new ArrayList();
    
    public TelaAgendamentoCliente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
    }
    
    
    public void receberCodAgend(int CODBARBEARIA, int CODCLIENTE){
        this.CODBARBEARIA = CODBARBEARIA;
        this.CODCLIENTE = CODCLIENTE;
        consultarDadosBarbearia(CODBARBEARIA);
    }
    
    public void receberCodReAgend(int CODAGENDAMENTO, int CODBARBEARIA, int CODCLIENTE){
        Agendamento.setText("REAGENDAMENTO");
        btnAgendar.setText("REAGENDAR");
        this.CODAGENDAMENTO = CODAGENDAMENTO;
        this.CODBARBEARIA = CODBARBEARIA;
        this.CODCLIENTE = CODCLIENTE;
        consultarDadosBarbearia(CODBARBEARIA);
    }
    
    public void consultarDadosBarbearia (int CODBARBEARIA){
        barbearias=barbeariaDao.read();
        StringBuilder textHtml = new StringBuilder("<html><div style='text-align: justify;'>");
        
        txtBarbearia.setText(barbearias.get(CODBARBEARIA-1).getNome());
        txtDescricao.setText(textHtml+"    "+barbearias.get(CODBARBEARIA-1).getDescricao()+"</div></html>"); //inserir a tag HTML server para qubrar a linha do JLabel
        txtEmail.setText(textHtml+barbearias.get(CODBARBEARIA-1).getEmail()+"</div></html>");
        txtEndereco.setText(textHtml+barbearias.get(CODBARBEARIA-1).getRua()+", "
                                                    +barbearias.get(CODBARBEARIA-1).getNumero()+", "
                                                    +barbearias.get(CODBARBEARIA-1).getBairro()+", "
                                                    +barbearias.get(CODBARBEARIA-1).getCidade()+"/"
                                                    +barbearias.get(CODBARBEARIA-1).getUf()+"</div></html>");
        txtRegra1.setText(textHtml+"• "+barbearias.get(CODBARBEARIA-1).getRegra1()+"</div></html>");
        txtRegra2.setText(textHtml+"• "+barbearias.get(CODBARBEARIA-1).getRegra2()+"</div></html>");
        txtRegra3.setText(textHtml+"• "+barbearias.get(CODBARBEARIA-1).getRegra3()+"</div></html>");
        txtRegra4.setText(textHtml+"• "+barbearias.get(CODBARBEARIA-1).getRegra4()+"</div></html>");
        
        
        servicos = barbeariaDao.readServico(CODBARBEARIA);
        for (Servico servico : servicos) { //adicionando os serviços á JComboBox
            selectServicos.addItem(servico.getNome());
        }
        
        for (Servico servico : servicos) {
            textHtml.append("• ").append(servico.getNome()).append(" | R$").append(servico.getValor().toString()).append("<br>");
        }
        textHtml.append("</div></html>");
        txtServicos.setText(textHtml.toString());
      }
    
    public void agendar(){
        try {
            boolean check;
            int status=0;
            int servicoSelecionado;
            int servico = selectServicos.getSelectedIndex();
            if(servico>0){
                servicoSelecionado = servicos.get(servico-1).getId();
            }else{
                servicoSelecionado=0;
            }
            
            SelectedDate dataCalendar = calendario.getSelectedDate(); //Selecionando DATA no CALENDARIO
            String dataString = dataCalendar.getDay()+"-"+dataCalendar.getMonth()+"-"+dataCalendar.getYear(); //Pegando a DATA em STRING
            String horaString = txtHora.getText()+":"+txtMinuto.getText(); //Pegando a HORA em STRING

            //convertendo do tipo STRING para DATE
            Date data = new Date(dataFormatada.parse(dataString).getTime());
            Date Horario = new Date(horaFormatada.parse(horaString).getTime()); //TIME DATE
            Time hora = new Time(Horario.getTime()); //Pegando o TIME da DATE
            

            check = agendamentoController.verificarAgendamento(servicoSelecionado, data, hora, CODBARBEARIA, CODCLIENTE, CODAGENDAMENTO, status);
            
            if(check){ // LIMPANDO OS CAMPOS EM CASO DE CADASTRO REALIZADO
                txtHora.setText("");
                txtMinuto.setText("");
            }
        } catch (ParseException ex) {
            Logger.getLogger(TelaAgendamentoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new css.FundoGradiente(0, 51, 102, 0, 0, 0, 0, 0, 1500, 100);
        icon = new javax.swing.JLabel();
        txtBarbearia = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JLabel();
        txtEmail = new javax.swing.JLabel();
        txtServicos = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JLabel();
        txtRegra = new javax.swing.JLabel();
        txtRegra1 = new javax.swing.JLabel();
        txtRegra2 = new javax.swing.JLabel();
        txtRegra3 = new javax.swing.JLabel();
        txtRegra4 = new javax.swing.JLabel();
        Direita = new css.FundoGradiente(0, 191, 255, 65, 105, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        Agendamento = new javax.swing.JLabel();
        Servico = new javax.swing.JLabel();
        selectServicos = new javax.swing.JComboBox<>();
        Hora = new javax.swing.JLabel();
        txtHora = new css.ArrendondarBordas();
        txtMinuto = new css.ArrendondarBordas();
        Data = new javax.swing.JLabel();
        calendario = new com.raven.datechooser.DateChooser();
        btnAgendar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Agendamento");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        txtBarbearia.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        txtBarbearia.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBarbearia.setBorder(new javax.swing.border.MatteBorder(null));

        txtDescricao.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(255, 255, 255));
        txtDescricao.setToolTipText("");
        txtDescricao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txtDescricao.setBorder(new javax.swing.border.MatteBorder(null));

        txtEmail.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/email.png"))); // NOI18N
        txtEmail.setBorder(new javax.swing.border.MatteBorder(null));

        txtServicos.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtServicos.setForeground(new java.awt.Color(255, 255, 255));
        txtServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tesoura.png"))); // NOI18N
        txtServicos.setBorder(new javax.swing.border.MatteBorder(null));

        txtEndereco.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtEndereco.setForeground(new java.awt.Color(255, 255, 255));
        txtEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localizacao.png"))); // NOI18N
        txtEndereco.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra.setText("REGRAS DO ESTABELECIMENTO:");
        txtRegra.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra1.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra1.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra2.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra2.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra2.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra3.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra3.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra3.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra4.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        txtRegra4.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra4.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBarbearia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EsquerdaLayout.createSequentialGroup()
                                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRegra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRegra1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRegra2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRegra3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRegra4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(txtBarbearia, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addComponent(txtRegra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRegra1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRegra2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(txtRegra3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txtRegra4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(0, 153, 255));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        Agendamento.setFont(new java.awt.Font("Segoe UI Semibold", 1, 48)); // NOI18N
        Agendamento.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Agendamento.setText("AGENDAMENTO");

        Servico.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Servico.setForeground(new java.awt.Color(255, 255, 255));
        Servico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Servico.setText("SERVIÇO");

        selectServicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Serviço" }));

        Hora.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Hora.setForeground(new java.awt.Color(255, 255, 255));
        Hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Hora.setText("HORÁRIO");

        txtHora.setBorder(null);
        txtHora.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        txtMinuto.setBorder(null);
        txtMinuto.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtMinuto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtMinuto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMinuto.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        Data.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        Data.setForeground(new java.awt.Color(255, 255, 255));
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data.setText("DATA");

        calendario.setForeground(new java.awt.Color(0, 51, 102));
        calendario.setToolTipText("");
        calendario.setPreferredSize(new java.awt.Dimension(500, 500));

        btnAgendar.setBackground(new java.awt.Color(0, 51, 102));
        btnAgendar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setText("AGENDAR");
        btnAgendar.setBorderPainted(false);
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 41)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(":");

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Agendamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addGap(0, 104, Short.MAX_VALUE)
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(sair)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(237, 237, 237))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calendario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                        .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131)))
                                .addGap(97, 97, 97))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(DireitaLayout.createSequentialGroup()
                                        .addComponent(txtHora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Hora, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                    .addComponent(selectServicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Servico, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                                .addGap(169, 169, 169))))))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sair)
                .addGap(87, 87, 87)
                .addComponent(Agendamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(Servico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(Hora)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(Data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        TelaPrincipalCliente TP = new TelaPrincipalCliente();
        TP.receberCodCliente(CODCLIENTE); 
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sairMouseClicked

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        agendar();
    }//GEN-LAST:event_btnAgendarActionPerformed

    public class LimitaNroCaracteres extends PlainDocument {
        private final int iMaxLength;
        public LimitaNroCaracteres(int maxlen) {
            super();
            iMaxLength = maxlen;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (iMaxLength <= 0){
                super.insertString(offset, str.toUpperCase(), attr);
                return;
            }

            int ilen = (getLength() + str.length());
            if (ilen <= iMaxLength){
                super.insertString(offset, str.toUpperCase(), attr);   // ...aceita str
            }
        }
    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamentoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAgendamentoCliente().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agendamento;
    private javax.swing.JLabel Data;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JLabel Hora;
    private javax.swing.JLabel Servico;
    private javax.swing.JButton btnAgendar;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel sair;
    private javax.swing.JComboBox<String> selectServicos;
    private javax.swing.JLabel txtBarbearia;
    private javax.swing.JLabel txtDescricao;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEndereco;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JFormattedTextField txtMinuto;
    private javax.swing.JLabel txtRegra;
    private javax.swing.JLabel txtRegra1;
    private javax.swing.JLabel txtRegra2;
    private javax.swing.JLabel txtRegra3;
    private javax.swing.JLabel txtRegra4;
    private javax.swing.JLabel txtServicos;
    // End of variables declaration//GEN-END:variables
}
