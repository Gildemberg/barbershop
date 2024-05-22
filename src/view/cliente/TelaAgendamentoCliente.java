
package view.cliente;

import com.raven.datechooser.SelectedDate;
import controller.AgendamentoController;
import css.BordaArredondada;
import dao.BarbeariaDAO;
import dao.ExpedienteDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import model.Barbearia;
import java.sql.Time;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import model.Agendamento;
import model.Expediente;
import model.Servico;



public class TelaAgendamentoCliente extends javax.swing.JFrame{

    int CODCLIENTE, CODBARBEARIA, CODAGENDAMENTO, STATUS;
    String DESCRICAO;
    AgendamentoController agendamentoController = new AgendamentoController();
    Agendamento agendamento = new Agendamento();
    SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    BarbeariaDAO barbeariaDao = new BarbeariaDAO();
    List<Servico> servicos = new ArrayList();
    List<Barbearia> barbearias = new ArrayList();  
    
    
    
    public TelaAgendamentoCliente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
    
    public void receberCodAdicionarAgend(Agendamento a){
        this.CODBARBEARIA = a.getCodbarbearia();
        this.CODCLIENTE = a.getCodcliente();
        this.STATUS = a.getStatus();
        this.DESCRICAO = a.getDescricao();
        consultarDadosBarbearia(a.getCodbarbearia());
    }
    
    public void receberCodAlterarAgend(Agendamento a){
        Agendamento.setText("Reagendamento");
        this.CODAGENDAMENTO = a.getCodagendamento();
        this.CODBARBEARIA = a.getCodbarbearia();
        this.CODCLIENTE = a.getCodcliente();
        this.STATUS = a.getStatus();
        this.DESCRICAO = a.getDescricao();
        consultarDadosBarbearia(a.getCodbarbearia());
    }
    
    public void consultarDadosBarbearia (int CODBARBEARIA){
        barbearias=barbeariaDao.readDados(CODBARBEARIA);
        StringBuilder textHtml = new StringBuilder("<html><div style='text-align: justify;'>");
        StringBuilder textHtmlfim = new StringBuilder("</div></html>");
        String textEspaco = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        
        txtBarbearia.setText(barbearias.get(0).getNome());
        txtDescricao.setText("<html><div style='text-align: justify;'>"+textEspaco+barbearias.get(0).getDescricao()+"</div></html>"); //inserir a tag HTML server para qubrar a linha do JLabel
        txtEndereco.setText(textHtml+barbearias.get(0).getRua()+", "
                                                    +barbearias.get(0).getNumero()+", "
                                                    +barbearias.get(0).getBairro()+", "
                                                    +barbearias.get(0).getCidade()+"/"
                                                    +barbearias.get(0).getUf()+textHtmlfim);     
        
        servicos = barbeariaDao.readServico(CODBARBEARIA);
        for (Servico servico : servicos) { 
            selectServicos.addItem(servico.getNome()); //adicionando os serviços á JComboBox
            textHtml.append(servico.getNome()).append(" | R$").append(servico.getValor().toString()).append("<br>"); //adicionando os serviços á descricao
        }
     
        textHtml.append("</div></html>");
        txtServicos.setText(textHtml.toString());
      }
    
    
    /*==========================================================================AGENDAMENTO==========================================================================*/
    public void adicionarAgendamento(){
        try {
            boolean check;
            int servicoSelecionado;
            int servico = selectServicos.getSelectedIndex();
            
            if(servico>0){
                servicoSelecionado = servicos.get(servico-1).getCodservico();
            }else{
                servicoSelecionado=0;
            }
            
            SelectedDate dataCalendar = calendario.getSelectedDate(); //Selecionando DATA no CALENDARIO
            String dataString = dataCalendar.getDay()+"/"+dataCalendar.getMonth()+"/"+dataCalendar.getYear(); //Pegando a DATA em STRING
            String horaString = selectHorario.getItemAt(selectHorario.getSelectedIndex());
            
            if(horaString.equals("Sem horário") || horaString.equals("Selecione")){
                JOptionPane.showMessageDialog(null, "Selecione um horário valido", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }else{
                //convertendo do tipo STRING para DATE
                Date data = new Date(dataFormatada.parse(dataString).getTime());
                Date Horario = new Date(horaFormatada.parse(horaString).getTime()); //TIME DATE
                Time hora = new Time(Horario.getTime()); //Pegando o TIME da DATE

                agendamento.setData(data);
                agendamento.setHora(hora);
                agendamento.setServico(servicoSelecionado);
                agendamento.setCodagendamento(CODAGENDAMENTO);
                agendamento.setCodbarbearia(CODBARBEARIA);
                agendamento.setCodcliente(CODCLIENTE);
                agendamento.setStatus(STATUS);
                agendamento.setDescricao(DESCRICAO);

                check = agendamentoController.controller(agendamento);

                if(check){ // LIMPANDO OS CAMPOS EM CASO DE CADASTRO REALIZADO
                    TelaPrincipalCliente TP = new TelaPrincipalCliente();
                    TP.receberCodCliente(CODCLIENTE); 
                    TP.setVisible(true);
                    this.setVisible(false);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(TelaAgendamentoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Esquerda = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        txtBarbearia = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JLabel();
        txtServicos = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JLabel();
        txtRegra5 = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        Agendamento = new javax.swing.JLabel();
        Servico = new javax.swing.JLabel();
        selectServicos = new javax.swing.JComboBox<>();
        Hora = new javax.swing.JLabel();
        selectHorario = new javax.swing.JComboBox<>();
        Data = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        calendario = new com.raven.datechooser.DateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Agendamento");
        setMinimumSize(new java.awt.Dimension(1280, 960));

        Esquerda.setBackground(new java.awt.Color(0, 51, 102));
        Esquerda.setMaximumSize(new java.awt.Dimension(960, 1080));
        Esquerda.setMinimumSize(new java.awt.Dimension(960, 1080));
        Esquerda.setPreferredSize(new java.awt.Dimension(960, 1080));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        txtBarbearia.setFont(new java.awt.Font("Caladea", 1, 60)); // NOI18N
        txtBarbearia.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBarbearia.setText("NOME DA BARBERAIA");
        txtBarbearia.setBorder(new javax.swing.border.MatteBorder(null));

        txtDescricao.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        txtDescricao.setForeground(new java.awt.Color(255, 255, 255));
        txtDescricao.setText("Descricao Barbearia");
        txtDescricao.setToolTipText("");
        txtDescricao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txtDescricao.setBorder(new javax.swing.border.MatteBorder(null));
        txtDescricao.setMaximumSize(new java.awt.Dimension(765, 62));
        txtDescricao.setMinimumSize(new java.awt.Dimension(765, 62));
        txtDescricao.setPreferredSize(new java.awt.Dimension(765, 62));

        txtServicos.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        txtServicos.setForeground(new java.awt.Color(255, 255, 255));
        txtServicos.setText("serviços");
        txtServicos.setBorder(new javax.swing.border.MatteBorder(null));

        txtEndereco.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        txtEndereco.setForeground(new java.awt.Color(255, 255, 255));
        txtEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localizacao.png"))); // NOI18N
        txtEndereco.setText("Localização da Barbearia");
        txtEndereco.setBorder(new javax.swing.border.MatteBorder(null));

        txtRegra5.setFont(new java.awt.Font("Caladea", 1, 32)); // NOI18N
        txtRegra5.setForeground(new java.awt.Color(255, 255, 255));
        txtRegra5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegra5.setText("Serviços Oferecidos");
        txtRegra5.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRegra5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(91, 91, 91))
                    .addComponent(txtBarbearia, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(icon)
                .addGap(47, 47, 47)
                .addComponent(txtBarbearia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(txtRegra5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
        );

        Direita.setBackground(new java.awt.Color(255, 255, 255));
        Direita.setMaximumSize(new java.awt.Dimension(960, 1080));
        Direita.setMinimumSize(new java.awt.Dimension(960, 1080));
        Direita.setPreferredSize(new java.awt.Dimension(960, 1080));

        Agendamento.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        Agendamento.setForeground(new java.awt.Color(0, 51, 102));
        Agendamento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Agendamento.setText("Agendamento");

        Servico.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        Servico.setForeground(new java.awt.Color(0, 51, 102));
        Servico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Servico.setText("Serviço");

        selectServicos.setFont(new java.awt.Font("DejaVu Sans Light", 0, 20)); // NOI18N
        selectServicos.setForeground(new java.awt.Color(0, 51, 102));
        selectServicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        selectServicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectServicos.setBackground(new Color(220, 220, 220, 220));
        // Definir uma borda de 3px para o JComboBox

        BordaArredondada bordaa = new BordaArredondada(new Color(0, 51, 102), 3, 10);
        Border bordaInternaa = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        Border bordaCompostaa = BorderFactory.createCompoundBorder(bordaa, bordaInternaa);
        selectServicos.setBorder(bordaCompostaa);

        //selectServicos.setBorder(new LineBorder(new Color(0, 51, 102), 3));
        // Personalizar o Botão de Seta
        selectServicos.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                // Personalizar o botão da seta
                JButton button = new JButton();
                button.setBackground(new Color(0, 51, 102));
                button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png")));
                button.setPreferredSize(new Dimension(40, 70));
                return button;
            }
        });

        Hora.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        Hora.setForeground(new java.awt.Color(0, 51, 102));
        Hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Hora.setText("Horário");

        selectHorario.setFont(new java.awt.Font("DejaVu Sans Light", 0, 20)); // NOI18N
        selectHorario.setForeground(new java.awt.Color(0, 51, 102));
        selectHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        selectHorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectHorario.setBackground(new Color(220, 220, 220, 220));
        // Definir uma borda de 3px para o JComboBox

        selectHorario.setBorder(bordaCompostaa);

        // Personalizar o Botão de Seta
        selectHorario.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                // Personalizar o botão da seta
                JButton buttonHorario = new JButton();
                buttonHorario.setBackground(new Color(0, 51, 102));
                buttonHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png")));
                buttonHorario.setPreferredSize(new Dimension(40, 70));
                return buttonHorario;
            }
        });

        Data.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        Data.setForeground(new java.awt.Color(0, 51, 102));
        Data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Data.setText("Data");

        btnAgendar.setBackground(new java.awt.Color(0, 51, 102));
        btnAgendar.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnAgendar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendar.setText("Concluir");
        btnAgendar.setBorderPainted(false);
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(0, 36, 73));
        btnVoltar.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar-branco.png"))); // NOI18N
        btnVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar.setBorderPainted(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        calendario.setForeground(new java.awt.Color(0, 51, 102));
        calendario.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                calendarioMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(Agendamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(btnAgendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(169, 169, 169))))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Hora, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addContainerGap(222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))
                    .addComponent(Servico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(selectHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(333, 333, 333))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Agendamento))
                    .addGroup(DireitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Servico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Hora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        adicionarAgendamento();
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipalCliente TP = new TelaPrincipalCliente();
        TP.receberCodCliente(CODCLIENTE); 
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void calendarioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarioMouseMoved
        try {
                    SelectedDate dataCalendar = calendario.getSelectedDate(); //Selecionando DATA no CALENDARIO
                    String dataString = dataCalendar.getDay()+"/"+dataCalendar.getMonth()+"/"+dataCalendar.getYear(); //Pegando a DATA em STRING
                    Date data = new Date(dataFormatada.parse(dataString).getTime());
                    List<Expediente> horarios = new ArrayList();
                    ExpedienteDAO expedDao = new ExpedienteDAO();

                    if(dataCalendar!=null){
                        horarios = expedDao.readHorarios(CODBARBEARIA, data);
                        selectHorario.removeAllItems();
                        selectHorario.addItem("Selecione");
                        if(horarios.isEmpty()){
                            selectHorario.addItem("Sem horário");
                        }else{
                            for (Expediente h : horarios) {
                                selectHorario.addItem(h.getHoraInicial().toString()); //adicionando os serviços á JComboBox
                            }
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(TelaAgendamentoCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_calendarioMouseMoved

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
    private javax.swing.JButton btnVoltar;
    private com.raven.datechooser.DateChooser calendario;
    private javax.swing.JLabel icon;
    private javax.swing.JComboBox<String> selectHorario;
    private javax.swing.JComboBox<String> selectServicos;
    private javax.swing.JLabel txtBarbearia;
    private javax.swing.JLabel txtDescricao;
    private javax.swing.JLabel txtEndereco;
    private javax.swing.JLabel txtRegra5;
    private javax.swing.JLabel txtServicos;
    // End of variables declaration//GEN-END:variables

private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }

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
}
