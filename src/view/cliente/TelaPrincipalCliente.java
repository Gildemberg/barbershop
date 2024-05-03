package view.cliente;

import controller.AgendamentoController;
import dao.AgendamentoDAO;
import dao.BarbeariaDAO;
import dao.ClienteDAO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Agendamento;
import model.Barbearia;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public final class TelaPrincipalCliente extends javax.swing.JFrame {
    //VARIAVEIS
    int CODCLIENTE;
    int STATUS=0;
    ArrayList<Integer> AGEND_CODBARBEARIAS = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOS = new ArrayList<>();
    ArrayList<Integer> CODBARBEARIAS = new ArrayList<>();
    
    //FORMATOS
    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
    
    //INSTANCIAS
    TelaAgendamentoCliente TAC = new TelaAgendamentoCliente();
    Agendamento agendamento = new Agendamento();
    AgendamentoDAO AgendamentoDao = new AgendamentoDAO();
    AgendamentoController AgendamentoController = new AgendamentoController();
    ClienteDAO ClienteDao = new ClienteDAO();
    BarbeariaDAO BarberDao = new BarbeariaDAO();
    
    public TelaPrincipalCliente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
      
    public void receberCodCliente(int CODCLIENTE){
        this.CODCLIENTE = CODCLIENTE;
        exibirNomeCliente();
        consultarAgendamento();
        consultarBarbearia();
        inserirDataHora();
    }

    public void inserirDataHora(){
        LocalDate data = LocalDate.now();
        LocalDateTime hora = LocalDateTime.now();
        DayOfWeek dia = hora.getDayOfWeek();
        DateTimeFormatter formatoDATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHORA = DateTimeFormatter.ofPattern("HH:mm a");
        String DATA = data.format(formatoDATA);
        String HORA = hora.format(formatoHORA);
        String DIA = dia.getDisplayName(TextStyle.SHORT, Locale.getDefault());
        DIA = DIA.replace(".", "");
        DIA = DIA.toUpperCase();
        dataAtual.setText(DIA+" - "+DATA +" - "+ HORA);
    }
    
    public void exibirNomeCliente (){
        nome_usr.setText("Olá, "+ClienteDao.retornoNome(CODCLIENTE));
      }
    
    public void consultarBarbearia(){
        List<Barbearia> barbearias = BarberDao.read();
        
        JPanel[] paineisBarbearia = {barbearia1, barbearia2, barbearia3, barbearia4, barbearia5, barbearia6, barbearia7, barbearia8, barbearia9, barbearia10, barbearia11};
        JLabel[] labelsNomeBarbearia = {nome_barbearia1, nome_barbearia2, nome_barbearia3, nome_barbearia4, nome_barbearia5, nome_barbearia6, nome_barbearia7, nome_barbearia8, nome_barbearia9, nome_barbearia10, nome_barbearia11};
        
        for(int i=0; i<barbearias.size() && i<paineisBarbearia.length; i++){
            Barbearia barbearia = barbearias.get(i);
            
            JPanel painelBarbearia = paineisBarbearia[i];
            JLabel labelNomeBarbearia = labelsNomeBarbearia[i];
            
            painelBarbearia.setVisible(true);
            
            labelNomeBarbearia.setText(barbearia.getNome());   
            CODBARBEARIAS.add(barbearia.getId());
        }
        for (int i = barbearias.size(); i < paineisBarbearia.length; i++) {
            paineisBarbearia[i].setVisible(false);
        }
    }
    
    public void consultarAgendamento(){
    
    AgendamentoDAO agendDAO = new AgendamentoDAO();
    List<Agendamento> agendamentos = agendDAO.consultarAgendamentosCliente(CODCLIENTE);

    JPanel[] paineisAgendamento = {Agendamento01, Agendamento02, Agendamento03, Agendamento4};
    JLabel[] labelsBarbearia = {txtBarbearia01, txtBarbearia02, txtBarbearia03, txtBarbearia4};
    JLabel[] labelsHorario = {txtHorario01, txtHorario02, txtHorario03, txtHorario4};
    JLabel[] labelsServico = {txtServico01, txtServico02, txtServico03, txtServico4};
    
    // Loop pelos agendamentos e configuração dos componentes
    for (int i = 0; i < agendamentos.size() && i < paineisAgendamento.length; i++) {
        Agendamento agendamento = agendamentos.get(i);
        JPanel painelAgendamento = paineisAgendamento[i];
        JLabel labelBarbearia = labelsBarbearia[i];
        JLabel labelHorario = labelsHorario[i];
        JLabel labelServico = labelsServico[i];
        
        // Exibir o painel de agendamento correspondente
        painelAgendamento.setVisible(true);
        
        // Configurar os textos nos labels
        labelBarbearia.setText(agendamento.getNomebarbearia());
        labelHorario.setText(dataFormat.format(agendamento.getData()) +" às "+ horaFormat.format(agendamento.getHora()) + "h");
        labelServico.setText("Serviço: "+agendamento.getNomeservico());
        
        // Adicionar os códigos de barbearia e agendamento às listas correspondentes
        AGEND_CODBARBEARIAS.add(agendamento.getCodbarbearia());
        CODAGENDAMENTOS.add(agendamento.getCodagendamento());
    }
    
    // Ocultar os painéis de agendamento restantes (caso o número de agendamentos seja menor que 4)
    for (int i = agendamentos.size(); i < paineisAgendamento.length; i++) {
        paineisAgendamento[i].setVisible(false);
    }
    }
    
    public void abrirBarbearia(int CODBARBEARIA){
        agendamento.setCodbarbearia(CODBARBEARIA);
        agendamento.setCodcliente(CODCLIENTE);
        agendamento.setDescricao("AGENDADO");
        agendamento.setStatus(0);
        TAC.receberCodAdicionarAgend(agendamento); // transferindo o cod da empresa
        TAC.setVisible(true);
        this.dispose();
    }
    
    public void alterarAgendamento(int CODAGENDAMENTO, int CODBARBEARIA){
        String DESCRICAO = JOptionPane.showInputDialog(null,"Informe o motivo:", "Reagendamento", JOptionPane.INFORMATION_MESSAGE);
        if(DESCRICAO != null){
            agendamento.setCodagendamento(CODAGENDAMENTO);
            agendamento.setCodbarbearia(CODBARBEARIA);
            agendamento.setCodcliente(CODCLIENTE);
            agendamento.setDescricao(DESCRICAO);
            agendamento.setStatus(1);
            TAC.receberCodAlterarAgend(agendamento); 
            TAC.setVisible(true);
            this.dispose(); 
        }
    }
    
    public void excluirAgendamento(int CODAGENDAMENTO){
        if(JOptionPane.showConfirmDialog(this, "Você deseja realmente deletar o agendamento?", "Remover", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){            
            String DESCRICAO = JOptionPane.showInputDialog(null,"Informe o motivo:", "Cancelar agendamento", JOptionPane.INFORMATION_MESSAGE);
            if(DESCRICAO != null){
                agendamento.setCodagendamento(CODAGENDAMENTO);
                agendamento.setDescricao(DESCRICAO);
                agendamento.setStatus(2);
                if(AgendamentoController.cancelarAgendamento(agendamento)){
                    consultarAgendamento();
                }
            }else{
                JOptionPane.showMessageDialog(null, "É obrigatório informar o motivo.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void alterarCadastroCliente(){
        TelaCadastroCliente TCC = new TelaCadastroCliente();
        TCC.alterarCadastro(CODCLIENTE);
        TCC.setVisible(true);
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        localizacao = new javax.swing.JLabel();
        nome_usr = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnAlterarCadastro = new javax.swing.JButton();
        Centro = new javax.swing.JPanel();
        barbearia1 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia1 = new javax.swing.JLabel();
        logo01 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        barbearia2 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia2 = new javax.swing.JLabel();
        logo02 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barbearia3 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia3 = new javax.swing.JLabel();
        logo03 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        barbearia4 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia4 = new javax.swing.JLabel();
        logo04 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        barbearia5 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia5 = new javax.swing.JLabel();
        logo05 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        barbearia6 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia6 = new javax.swing.JLabel();
        logo06 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        barbearia7 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia7 = new javax.swing.JLabel();
        logo7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        barbearia8 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia8 = new javax.swing.JLabel();
        logo8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        barbearia9 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia9 = new javax.swing.JLabel();
        logo9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        barbearia10 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia10 = new javax.swing.JLabel();
        logo10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        barbearia11 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia11 = new javax.swing.JLabel();
        logo11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Barbearias = new css.JPanelArredondadoBarbearias(60);
        jLabel14 = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        MeusAgendamentos = new css.JPanelArredondadoBarbearias(60);
        jLabel1 = new javax.swing.JLabel();
        Agendamento01 = new css.JPanelArredondadoAgendamentos(30);
        seta = new javax.swing.JLabel();
        txtBarbearia01 = new javax.swing.JLabel();
        txtHorario01 = new javax.swing.JLabel();
        txtServico01 = new javax.swing.JLabel();
        btnAlterar1 = new javax.swing.JLabel();
        btnExcluir1 = new javax.swing.JLabel();
        Agendamento02 = new css.JPanelArredondadoAgendamentos(30);
        seta1 = new javax.swing.JLabel();
        txtBarbearia02 = new javax.swing.JLabel();
        txtHorario02 = new javax.swing.JLabel();
        txtServico02 = new javax.swing.JLabel();
        btnAlterar2 = new javax.swing.JLabel();
        btnExcluir2 = new javax.swing.JLabel();
        Agendamento03 = new css.JPanelArredondadoAgendamentos(30);
        seta2 = new javax.swing.JLabel();
        txtBarbearia03 = new javax.swing.JLabel();
        txtHorario03 = new javax.swing.JLabel();
        txtServico03 = new javax.swing.JLabel();
        btnAlterar3 = new javax.swing.JLabel();
        btnExcluir3 = new javax.swing.JLabel();
        Agendamento4 = new css.JPanelArredondadoAgendamentos(30);
        seta3 = new javax.swing.JLabel();
        txtBarbearia4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        txtServico4 = new javax.swing.JLabel();
        btnAlterar4 = new javax.swing.JLabel();
        btnExcluir4 = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal Cliente");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 100));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));
        Cima.setPreferredSize(new java.awt.Dimension(1920, 150));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N

        localizacao.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        localizacao.setForeground(new java.awt.Color(255, 255, 255));
        localizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localizacao.png"))); // NOI18N
        localizacao.setText("Paulo Afonso - BA");
        localizacao.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        nome_usr.setFont(new java.awt.Font("Caladea", 0, 48)); // NOI18N
        nome_usr.setForeground(new java.awt.Color(255, 255, 255));
        nome_usr.setText("Olá, usuário");
        nome_usr.setBorder(new javax.swing.border.MatteBorder(null));

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar-azul.png"))); // NOI18N
        btnVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnVoltar.setBorderPainted(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAlterarCadastro.setBackground(new java.awt.Color(255, 255, 255));
        btnAlterarCadastro.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        btnAlterarCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterar_user.png"))); // NOI18N
        btnAlterarCadastro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAlterarCadastro.setBorderPainted(false);
        btnAlterarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(img)
                .addGap(18, 18, 18)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(localizacao)
                    .addComponent(nome_usr, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nome_usr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localizacao)
                .addGap(24, 24, 24))
            .addGroup(CimaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Centro.setBackground(new java.awt.Color(255, 255, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1320, 960));
        Centro.setMinimumSize(new java.awt.Dimension(1320, 960));
        Centro.setPreferredSize(new java.awt.Dimension(1320, 960));

        barbearia1.setLayout(new BorderLayout());
        barbearia1.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia1.setBackground(new java.awt.Color(30, 113, 218));
        barbearia1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia1.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia1.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia1.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia1MouseClicked(evt);
            }
        });

        nome_barbearia1.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia1.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia1.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia1.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia1.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia1.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia1Layout = new javax.swing.GroupLayout(barbearia1);
        barbearia1.setLayout(barbearia1Layout);
        barbearia1Layout.setHorizontalGroup(
            barbearia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo01)
                .addContainerGap())
        );
        barbearia1Layout.setVerticalGroup(
            barbearia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nome_barbearia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        barbearia2.setLayout(new BorderLayout());
        barbearia2.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia2.setBackground(new java.awt.Color(30, 113, 218));
        barbearia2.setForeground(new java.awt.Color(0, 0, 0));
        barbearia2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia2.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia2.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia2.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia2MouseClicked(evt);
            }
        });

        nome_barbearia2.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia2.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia2.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia2.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia2.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia2.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia2Layout = new javax.swing.GroupLayout(barbearia2);
        barbearia2.setLayout(barbearia2Layout);
        barbearia2Layout.setHorizontalGroup(
            barbearia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nome_barbearia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo02)
                .addContainerGap())
        );
        barbearia2Layout.setVerticalGroup(
            barbearia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia2Layout.createSequentialGroup()
                .addGroup(barbearia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nome_barbearia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barbearia3.setLayout(new BorderLayout());
        barbearia3.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia3.setBackground(new java.awt.Color(30, 113, 218));
        barbearia3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia3.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia3.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia3.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia3MouseClicked(evt);
            }
        });

        nome_barbearia3.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia3.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia3.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia3.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia3.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia3.setName(""); // NOI18N
        nome_barbearia3.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia3Layout = new javax.swing.GroupLayout(barbearia3);
        barbearia3.setLayout(barbearia3Layout);
        barbearia3Layout.setHorizontalGroup(
            barbearia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo03)
                .addContainerGap())
        );
        barbearia3Layout.setVerticalGroup(
            barbearia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia3Layout.createSequentialGroup()
                .addGroup(barbearia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo03, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barbearia4.setLayout(new BorderLayout());
        barbearia4.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia4.setBackground(new java.awt.Color(30, 113, 218));
        barbearia4.setForeground(new java.awt.Color(0, 0, 0));
        barbearia4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia4.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia4.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia4.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia4MouseClicked(evt);
            }
        });

        nome_barbearia4.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia4.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia4.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia4.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia4.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia4.setName(""); // NOI18N
        nome_barbearia4.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia4Layout = new javax.swing.GroupLayout(barbearia4);
        barbearia4.setLayout(barbearia4Layout);
        barbearia4Layout.setHorizontalGroup(
            barbearia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo04)
                .addContainerGap())
        );
        barbearia4Layout.setVerticalGroup(
            barbearia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia4Layout.createSequentialGroup()
                .addGroup(barbearia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barbearia5.setLayout(new BorderLayout());
        barbearia5.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia5.setBackground(new java.awt.Color(30, 113, 218));
        barbearia5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia5.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia5.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia5MouseClicked(evt);
            }
        });

        nome_barbearia5.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia5.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia5.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia5.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia5.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia5.setName(""); // NOI18N
        nome_barbearia5.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia5Layout = new javax.swing.GroupLayout(barbearia5);
        barbearia5.setLayout(barbearia5Layout);
        barbearia5Layout.setHorizontalGroup(
            barbearia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo05)
                .addContainerGap())
        );
        barbearia5Layout.setVerticalGroup(
            barbearia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia5Layout.createSequentialGroup()
                .addGroup(barbearia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo05, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia6.setLayout(new BorderLayout());
        barbearia6.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia6.setBackground(new java.awt.Color(30, 113, 218));
        barbearia6.setForeground(new java.awt.Color(0, 0, 0));
        barbearia6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia6.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia6.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia6MouseClicked(evt);
            }
        });

        nome_barbearia6.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia6.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia6.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia6.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia6.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia6.setName(""); // NOI18N
        nome_barbearia6.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia6Layout = new javax.swing.GroupLayout(barbearia6);
        barbearia6.setLayout(barbearia6Layout);
        barbearia6Layout.setHorizontalGroup(
            barbearia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo06)
                .addContainerGap())
        );
        barbearia6Layout.setVerticalGroup(
            barbearia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia6Layout.createSequentialGroup()
                .addGroup(barbearia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo06, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        barbearia7.setLayout(new BorderLayout());
        barbearia7.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia7.setBackground(new java.awt.Color(30, 113, 218));
        barbearia7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia7.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia7.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia7MouseClicked(evt);
            }
        });

        nome_barbearia7.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia7.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia7.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia7.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia7.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia7.setName(""); // NOI18N
        nome_barbearia7.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia7Layout = new javax.swing.GroupLayout(barbearia7);
        barbearia7.setLayout(barbearia7Layout);
        barbearia7Layout.setHorizontalGroup(
            barbearia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nome_barbearia7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo7)
                .addContainerGap())
        );
        barbearia7Layout.setVerticalGroup(
            barbearia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia7Layout.createSequentialGroup()
                .addGroup(barbearia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia8.setLayout(new BorderLayout());
        barbearia8.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia8.setBackground(new java.awt.Color(30, 113, 218));
        barbearia8.setForeground(new java.awt.Color(0, 0, 0));
        barbearia8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia8.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia8.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia8MouseClicked(evt);
            }
        });

        nome_barbearia8.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia8.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia8.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia8.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia8.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia8.setName(""); // NOI18N
        nome_barbearia8.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia8Layout = new javax.swing.GroupLayout(barbearia8);
        barbearia8.setLayout(barbearia8Layout);
        barbearia8Layout.setHorizontalGroup(
            barbearia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo8)
                .addContainerGap())
        );
        barbearia8Layout.setVerticalGroup(
            barbearia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia8Layout.createSequentialGroup()
                .addGroup(barbearia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia9.setLayout(new BorderLayout());
        barbearia9.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia9.setBackground(new java.awt.Color(30, 113, 218));
        barbearia9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia9.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia9.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia9MouseClicked(evt);
            }
        });

        nome_barbearia9.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia9.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia9.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia9.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia9.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia9.setName(""); // NOI18N
        nome_barbearia9.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia9Layout = new javax.swing.GroupLayout(barbearia9);
        barbearia9.setLayout(barbearia9Layout);
        barbearia9Layout.setHorizontalGroup(
            barbearia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nome_barbearia9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo9)
                .addContainerGap())
        );
        barbearia9Layout.setVerticalGroup(
            barbearia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia9Layout.createSequentialGroup()
                .addGroup(barbearia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia10.setLayout(new BorderLayout());
        barbearia10.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia10.setBackground(new java.awt.Color(30, 113, 218));
        barbearia10.setForeground(new java.awt.Color(0, 0, 0));
        barbearia10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia10.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia10.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia10MouseClicked(evt);
            }
        });

        nome_barbearia10.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia10.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia10.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia10.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia10.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia10.setName(""); // NOI18N
        nome_barbearia10.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia10Layout = new javax.swing.GroupLayout(barbearia10);
        barbearia10.setLayout(barbearia10Layout);
        barbearia10Layout.setHorizontalGroup(
            barbearia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo10)
                .addContainerGap())
        );
        barbearia10Layout.setVerticalGroup(
            barbearia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia10Layout.createSequentialGroup()
                .addGroup(barbearia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia11.setLayout(new BorderLayout());
        barbearia11.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia11.setBackground(new java.awt.Color(30, 113, 218));
        barbearia11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia11.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia11.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia11MouseClicked(evt);
            }
        });

        nome_barbearia11.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        nome_barbearia11.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia11.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia11.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia11.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia11.setName(""); // NOI18N
        nome_barbearia11.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia11Layout = new javax.swing.GroupLayout(barbearia11);
        barbearia11.setLayout(barbearia11Layout);
        barbearia11Layout.setHorizontalGroup(
            barbearia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(nome_barbearia11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo11)
                .addContainerGap())
        );
        barbearia11Layout.setVerticalGroup(
            barbearia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia11Layout.createSequentialGroup()
                .addGroup(barbearia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Barbearias.setBackground(new java.awt.Color(0, 51, 102));
        Barbearias.setMaximumSize(new java.awt.Dimension(700, 45));
        Barbearias.setMinimumSize(new java.awt.Dimension(700, 45));
        Barbearias.setPreferredSize(new java.awt.Dimension(700, 45));

        jLabel14.setBackground(new java.awt.Color(0, 51, 102));
        jLabel14.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Barbearias");

        javax.swing.GroupLayout BarbeariasLayout = new javax.swing.GroupLayout(Barbearias);
        Barbearias.setLayout(BarbeariasLayout);
        BarbeariasLayout.setHorizontalGroup(
            BarbeariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BarbeariasLayout.setVerticalGroup(
            BarbeariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barbearia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                        .addComponent(Barbearias, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304))))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(Barbearias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(barbearia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(30, 113, 218));
        Direita.setMaximumSize(new java.awt.Dimension(600, 960));
        Direita.setMinimumSize(new java.awt.Dimension(600, 960));
        Direita.setPreferredSize(new java.awt.Dimension(600, 960));

        MeusAgendamentos.setBackground(new java.awt.Color(0, 51, 102));
        MeusAgendamentos.setMinimumSize(new java.awt.Dimension(300, 45));
        MeusAgendamentos.setPreferredSize(new java.awt.Dimension(300, 45));

        jLabel1.setBackground(new java.awt.Color(0, 51, 102));
        jLabel1.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Meus Agendamentos");

        javax.swing.GroupLayout MeusAgendamentosLayout = new javax.swing.GroupLayout(MeusAgendamentos);
        MeusAgendamentos.setLayout(MeusAgendamentosLayout);
        MeusAgendamentosLayout.setHorizontalGroup(
            MeusAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        MeusAgendamentosLayout.setVerticalGroup(
            MeusAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        Agendamento01.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento01.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento01.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento01.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento01.setPreferredSize(new java.awt.Dimension(450, 70));

        seta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia01.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia01.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia01.setToolTipText("");
        txtBarbearia01.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia01.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia01.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia01.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario01.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario01.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario01.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario01.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario01.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario01.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario01.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico01.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico01.setForeground(new java.awt.Color(0, 51, 102));
        txtServico01.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico01.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico01.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico01.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar1MouseClicked(evt);
            }
        });

        btnExcluir1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento01Layout = new javax.swing.GroupLayout(Agendamento01);
        Agendamento01.setLayout(Agendamento01Layout);
        Agendamento01Layout.setHorizontalGroup(
            Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento01Layout.createSequentialGroup()
                .addComponent(seta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario01, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico01, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir1)
                .addContainerGap())
        );
        Agendamento01Layout.setVerticalGroup(
            Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Agendamento01Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario01, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico01, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Agendamento02.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento02.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento02.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento02.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento02.setPreferredSize(new java.awt.Dimension(450, 70));

        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia02.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia02.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia02.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia02.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia02.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia02.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario02.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario02.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario02.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario02.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario02.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario02.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico02.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico02.setForeground(new java.awt.Color(0, 51, 102));
        txtServico02.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico02.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico02.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico02.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar2.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar2MouseClicked(evt);
            }
        });

        btnExcluir2.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnExcluir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento02Layout = new javax.swing.GroupLayout(Agendamento02);
        Agendamento02.setLayout(Agendamento02Layout);
        Agendamento02Layout.setHorizontalGroup(
            Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento02Layout.createSequentialGroup()
                .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario02, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico02, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir2)
                .addContainerGap())
        );
        Agendamento02Layout.setVerticalGroup(
            Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario02, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico02, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(btnAlterar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Agendamento03.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento03.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento03.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento03.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento03.setPreferredSize(new java.awt.Dimension(450, 70));
        Agendamento03.setRequestFocusEnabled(false);

        seta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia03.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia03.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia03.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia03.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia03.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia03.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario03.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario03.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario03.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario03.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario03.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario03.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico03.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico03.setForeground(new java.awt.Color(0, 51, 102));
        txtServico03.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico03.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico03.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico03.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar3.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar3MouseClicked(evt);
            }
        });

        btnExcluir3.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnExcluir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento03Layout = new javax.swing.GroupLayout(Agendamento03);
        Agendamento03.setLayout(Agendamento03Layout);
        Agendamento03Layout.setHorizontalGroup(
            Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento03Layout.createSequentialGroup()
                .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario03, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico03, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir3)
                .addContainerGap())
        );
        Agendamento03Layout.setVerticalGroup(
            Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcluir3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Agendamento03Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario03, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico03, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(btnAlterar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Agendamento4.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento4.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento4.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento4.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento4.setPreferredSize(new java.awt.Dimension(450, 70));

        seta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia4.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia4.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario4.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico4.setForeground(new java.awt.Color(0, 51, 102));
        txtServico4.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico4.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar4.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar4MouseClicked(evt);
            }
        });

        btnExcluir4.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnExcluir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento4Layout = new javax.swing.GroupLayout(Agendamento4);
        Agendamento4.setLayout(Agendamento4Layout);
        Agendamento4Layout.setHorizontalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento4Layout.createSequentialGroup()
                .addComponent(seta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBarbearia4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir4)
                .addContainerGap())
        );
        Agendamento4Layout.setVerticalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcluir4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAlterar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento4Layout.createSequentialGroup()
                .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Agendamento4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBarbearia4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        dataAtual.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        dataAtual.setForeground(new java.awt.Color(255, 255, 255));
        dataAtual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dataAtual.setToolTipText("");
        dataAtual.setBorder(new javax.swing.border.MatteBorder(null));
        dataAtual.setMaximumSize(new java.awt.Dimension(300, 30));
        dataAtual.setMinimumSize(new java.awt.Dimension(300, 30));
        dataAtual.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DireitaLayout.createSequentialGroup()
                        .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Agendamento02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Agendamento03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Agendamento01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Agendamento4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Agendamento01, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento02, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento03, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void barbearia1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia1MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(0));
    }//GEN-LAST:event_barbearia1MouseClicked

    private void barbearia2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia2MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(1));
    }//GEN-LAST:event_barbearia2MouseClicked

    private void barbearia3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia3MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(2));
    }//GEN-LAST:event_barbearia3MouseClicked

    private void barbearia4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia4MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(3));
    }//GEN-LAST:event_barbearia4MouseClicked

    private void barbearia5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia5MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(4));
    }//GEN-LAST:event_barbearia5MouseClicked

    private void barbearia6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia6MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(5));
    }//GEN-LAST:event_barbearia6MouseClicked

    private void barbearia7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia7MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(6));
    }//GEN-LAST:event_barbearia7MouseClicked

    private void barbearia8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia8MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(7));
    }//GEN-LAST:event_barbearia8MouseClicked

    private void barbearia9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia9MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(8));
    }//GEN-LAST:event_barbearia9MouseClicked

    private void barbearia10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia10MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(9));
    }//GEN-LAST:event_barbearia10MouseClicked

    private void barbearia11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia11MouseClicked
        abrirBarbearia(CODBARBEARIAS.get(10));
    }//GEN-LAST:event_barbearia11MouseClicked

    private void btnAlterar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar1MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(0), AGEND_CODBARBEARIAS.get(0));
    }//GEN-LAST:event_btnAlterar1MouseClicked

    private void btnAlterar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar2MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(1), AGEND_CODBARBEARIAS.get(1));
    }//GEN-LAST:event_btnAlterar2MouseClicked

    private void btnAlterar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar3MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(2), AGEND_CODBARBEARIAS.get(2)); 
    }//GEN-LAST:event_btnAlterar3MouseClicked

    private void btnExcluir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir1MouseClicked
        excluirAgendamento(CODAGENDAMENTOS.get(0));
    }//GEN-LAST:event_btnExcluir1MouseClicked

    private void btnExcluir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir2MouseClicked
        excluirAgendamento(CODAGENDAMENTOS.get(1));
    }//GEN-LAST:event_btnExcluir2MouseClicked

    private void btnExcluir3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir3MouseClicked
        excluirAgendamento(CODAGENDAMENTOS.get(2));
    }//GEN-LAST:event_btnExcluir3MouseClicked

    private void btnExcluir4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir4MouseClicked
        excluirAgendamento(CODAGENDAMENTOS.get(3));
    }//GEN-LAST:event_btnExcluir4MouseClicked

    private void btnAlterar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar4MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(3), AGEND_CODBARBEARIAS.get(3));
    }//GEN-LAST:event_btnAlterar4MouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        new TelaLoginCliente().setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAlterarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarCadastroActionPerformed
        alterarCadastroCliente();
    }//GEN-LAST:event_btnAlterarCadastroActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipalCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agendamento01;
    private javax.swing.JPanel Agendamento02;
    private javax.swing.JPanel Agendamento03;
    private javax.swing.JPanel Agendamento4;
    private javax.swing.JPanel Barbearias;
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel MeusAgendamentos;
    private javax.swing.JPanel barbearia1;
    private javax.swing.JPanel barbearia10;
    private javax.swing.JPanel barbearia11;
    private javax.swing.JPanel barbearia2;
    private javax.swing.JPanel barbearia3;
    private javax.swing.JPanel barbearia4;
    private javax.swing.JPanel barbearia5;
    private javax.swing.JPanel barbearia6;
    private javax.swing.JPanel barbearia7;
    private javax.swing.JPanel barbearia8;
    private javax.swing.JPanel barbearia9;
    private javax.swing.JLabel btnAlterar1;
    private javax.swing.JLabel btnAlterar2;
    private javax.swing.JLabel btnAlterar3;
    private javax.swing.JLabel btnAlterar4;
    private javax.swing.JButton btnAlterarCadastro;
    private javax.swing.JLabel btnExcluir1;
    private javax.swing.JLabel btnExcluir2;
    private javax.swing.JLabel btnExcluir3;
    private javax.swing.JLabel btnExcluir4;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel localizacao;
    private javax.swing.JLabel logo01;
    private javax.swing.JLabel logo02;
    private javax.swing.JLabel logo03;
    private javax.swing.JLabel logo04;
    private javax.swing.JLabel logo05;
    private javax.swing.JLabel logo06;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo11;
    private javax.swing.JLabel logo7;
    private javax.swing.JLabel logo8;
    private javax.swing.JLabel logo9;
    private javax.swing.JLabel nome_barbearia1;
    private javax.swing.JLabel nome_barbearia10;
    private javax.swing.JLabel nome_barbearia11;
    private javax.swing.JLabel nome_barbearia2;
    private javax.swing.JLabel nome_barbearia3;
    private javax.swing.JLabel nome_barbearia4;
    private javax.swing.JLabel nome_barbearia5;
    private javax.swing.JLabel nome_barbearia6;
    private javax.swing.JLabel nome_barbearia7;
    private javax.swing.JLabel nome_barbearia8;
    private javax.swing.JLabel nome_barbearia9;
    private javax.swing.JLabel nome_usr;
    private javax.swing.JLabel seta;
    private javax.swing.JLabel seta1;
    private javax.swing.JLabel seta2;
    private javax.swing.JLabel seta3;
    private javax.swing.JLabel txtBarbearia01;
    private javax.swing.JLabel txtBarbearia02;
    private javax.swing.JLabel txtBarbearia03;
    private javax.swing.JLabel txtBarbearia4;
    private javax.swing.JLabel txtHorario01;
    private javax.swing.JLabel txtHorario02;
    private javax.swing.JLabel txtHorario03;
    private javax.swing.JLabel txtHorario4;
    private javax.swing.JLabel txtServico01;
    private javax.swing.JLabel txtServico02;
    private javax.swing.JLabel txtServico03;
    private javax.swing.JLabel txtServico4;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
