package view.cliente;

import controller.AgendamentoController;
import css.CustomScrollPaneConfigurator;
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
import java.awt.Color;
import java.awt.Toolkit;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Cliente;


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
    AgendamentoDAO agendDAO = new AgendamentoDAO();
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
        preencherDadosCliente();
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
    
    public void preencherDadosCliente (){
        List<Cliente> clientes = new ArrayList();
        clientes=ClienteDao.read(CODCLIENTE);
        nome_usr.setText(clientes.get(CODCLIENTE-1).getNome()); //imprimendo o nome usr
        localizacao.setText(clientes.get(CODCLIENTE-1).getCidade()+" - "+clientes.get(CODCLIENTE-1).getUf());
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
    List<Agendamento> agendamentos = agendDAO.consultarAgendamentosCliente(CODCLIENTE);

    JPanel[] paineisAgendamento = {Agendamento1, Agendamento2, Agendamento3, Agendamento4, Agendamento5, Agendamento6, Agendamento7, Agendamento8};
    JLabel[] labelsBarbearia = {txtBarbearia1, txtBarbearia2, txtBarbearia3, txtBarbearia4, txtBarbearia5, txtBarbearia6, txtBarbearia7, txtBarbearia8};
    JLabel[] labelsHorario = {txtHorario1, txtHorario2, txtHorario3, txtHorario4, txtHorario5, txtHorario6, txtHorario7, txtHorario8};
    JLabel[] labelsServico = {txtServico1, txtServico2, txtServico3, txtServico4, txtServico5, txtServico6, txtServico7, txtServico8};
    
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
        Barbearias = new css.JPanelArredondadoBarbearias(60);
        jLabel14 = new javax.swing.JLabel();
        jScrollPaneBarbearia = new css.ScrollPaneWin11();
        jPanelBarbearia = new javax.swing.JPanel();
        barbearia1 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia1 = new javax.swing.JLabel();
        logo01 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        barbearia4 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia4 = new javax.swing.JLabel();
        logo04 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        barbearia5 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia5 = new javax.swing.JLabel();
        logo05 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        barbearia8 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia8 = new javax.swing.JLabel();
        logo8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        barbearia3 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia3 = new javax.swing.JLabel();
        logo03 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        barbearia7 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia7 = new javax.swing.JLabel();
        logo7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        barbearia2 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia2 = new javax.swing.JLabel();
        logo02 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barbearia11 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia11 = new javax.swing.JLabel();
        logo11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        barbearia10 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia10 = new javax.swing.JLabel();
        logo10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        barbearia6 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia6 = new javax.swing.JLabel();
        logo06 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        barbearia9 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia9 = new javax.swing.JLabel();
        logo9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        MeusAgendamentos = new css.JPanelArredondadoBarbearias(60);
        jLabel1 = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();
        jScrollPaneAgendamentos = new css.ScrollPaneWin11();
        jPanelAgendamentos = new javax.swing.JPanel();
        Agendamento1 = new css.JPanelArredondadoAgendamentos(30);
        seta = new javax.swing.JLabel();
        txtBarbearia1 = new javax.swing.JLabel();
        txtHorario1 = new javax.swing.JLabel();
        txtServico1 = new javax.swing.JLabel();
        btnAlterar1 = new javax.swing.JLabel();
        btnExcluir1 = new javax.swing.JLabel();
        Agendamento2 = new css.JPanelArredondadoAgendamentos(30);
        seta1 = new javax.swing.JLabel();
        txtBarbearia2 = new javax.swing.JLabel();
        txtHorario2 = new javax.swing.JLabel();
        txtServico2 = new javax.swing.JLabel();
        btnAlterar2 = new javax.swing.JLabel();
        btnExcluir2 = new javax.swing.JLabel();
        Agendamento3 = new css.JPanelArredondadoAgendamentos(30);
        seta2 = new javax.swing.JLabel();
        txtBarbearia3 = new javax.swing.JLabel();
        txtHorario3 = new javax.swing.JLabel();
        txtServico3 = new javax.swing.JLabel();
        btnAlterar3 = new javax.swing.JLabel();
        btnExcluir3 = new javax.swing.JLabel();
        Agendamento4 = new css.JPanelArredondadoAgendamentos(30);
        seta3 = new javax.swing.JLabel();
        txtBarbearia4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        txtServico4 = new javax.swing.JLabel();
        btnAlterar4 = new javax.swing.JLabel();
        btnExcluir4 = new javax.swing.JLabel();
        Agendamento5 = new css.JPanelArredondadoAgendamentos(30);
        seta4 = new javax.swing.JLabel();
        txtBarbearia5 = new javax.swing.JLabel();
        txtHorario5 = new javax.swing.JLabel();
        txtServico5 = new javax.swing.JLabel();
        btnAlterar5 = new javax.swing.JLabel();
        btnExcluir5 = new javax.swing.JLabel();
        Agendamento6 = new css.JPanelArredondadoAgendamentos(30);
        seta5 = new javax.swing.JLabel();
        txtBarbearia6 = new javax.swing.JLabel();
        txtHorario6 = new javax.swing.JLabel();
        txtServico6 = new javax.swing.JLabel();
        btnAlterar6 = new javax.swing.JLabel();
        btnExcluir6 = new javax.swing.JLabel();
        Agendamento7 = new css.JPanelArredondadoAgendamentos(30);
        seta6 = new javax.swing.JLabel();
        txtBarbearia7 = new javax.swing.JLabel();
        txtHorario7 = new javax.swing.JLabel();
        txtServico7 = new javax.swing.JLabel();
        btnAlterar7 = new javax.swing.JLabel();
        btnExcluir7 = new javax.swing.JLabel();
        Agendamento8 = new css.JPanelArredondadoAgendamentos(30);
        seta7 = new javax.swing.JLabel();
        txtBarbearia8 = new javax.swing.JLabel();
        txtHorario8 = new javax.swing.JLabel();
        txtServico8 = new javax.swing.JLabel();
        btnAlterar8 = new javax.swing.JLabel();
        btnExcluir8 = new javax.swing.JLabel();

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

        jPanelBarbearia.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanelBarbeariaLayout = new javax.swing.GroupLayout(jPanelBarbearia);
        jPanelBarbearia.setLayout(jPanelBarbeariaLayout);
        jPanelBarbeariaLayout.setHorizontalGroup(
            jPanelBarbeariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarbeariaLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanelBarbeariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanelBarbeariaLayout.setVerticalGroup(
            jPanelBarbeariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarbeariaLayout.createSequentialGroup()
                .addContainerGap()
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneBarbearia.setViewportView(jPanelBarbearia);

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneBarbearia, javax.swing.GroupLayout.DEFAULT_SIZE, 1308, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Barbearias, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(Barbearias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneBarbearia, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneBarbearia.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

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

        dataAtual.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        dataAtual.setForeground(new java.awt.Color(255, 255, 255));
        dataAtual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dataAtual.setToolTipText("");
        dataAtual.setBorder(new javax.swing.border.MatteBorder(null));
        dataAtual.setMaximumSize(new java.awt.Dimension(300, 30));
        dataAtual.setMinimumSize(new java.awt.Dimension(300, 30));
        dataAtual.setPreferredSize(new java.awt.Dimension(300, 30));

        jScrollPaneAgendamentos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelAgendamentos.setBackground(new java.awt.Color(30, 113, 218));

        Agendamento1.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento1.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento1.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento1.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento1.setPreferredSize(new java.awt.Dimension(400, 70));

        seta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia1.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia1.setToolTipText("");
        txtBarbearia1.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario1.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico1.setForeground(new java.awt.Color(0, 51, 102));
        txtServico1.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico1.setPreferredSize(new java.awt.Dimension(300, 30));

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

        javax.swing.GroupLayout Agendamento1Layout = new javax.swing.GroupLayout(Agendamento1);
        Agendamento1.setLayout(Agendamento1Layout);
        Agendamento1Layout.setHorizontalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addComponent(seta, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir1)
                .addContainerGap())
        );
        Agendamento1Layout.setVerticalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Agendamento2.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento2.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento2.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento2.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento2.setPreferredSize(new java.awt.Dimension(450, 70));

        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia2.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia2.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario2.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico2.setForeground(new java.awt.Color(0, 51, 102));
        txtServico2.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico2.setPreferredSize(new java.awt.Dimension(300, 30));

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

        javax.swing.GroupLayout Agendamento2Layout = new javax.swing.GroupLayout(Agendamento2);
        Agendamento2.setLayout(Agendamento2Layout);
        Agendamento2Layout.setHorizontalGroup(
            Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento2Layout.createSequentialGroup()
                .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir2)
                .addContainerGap())
        );
        Agendamento2Layout.setVerticalGroup(
            Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(btnAlterar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Agendamento3.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento3.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento3.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento3.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento3.setPreferredSize(new java.awt.Dimension(450, 70));
        Agendamento3.setRequestFocusEnabled(false);

        seta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia3.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia3.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario3.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico3.setForeground(new java.awt.Color(0, 51, 102));
        txtServico3.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico3.setPreferredSize(new java.awt.Dimension(300, 30));

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

        javax.swing.GroupLayout Agendamento3Layout = new javax.swing.GroupLayout(Agendamento3);
        Agendamento3.setLayout(Agendamento3Layout);
        Agendamento3Layout.setHorizontalGroup(
            Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento3Layout.createSequentialGroup()
                .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir3)
                .addContainerGap())
        );
        Agendamento3Layout.setVerticalGroup(
            Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcluir3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Agendamento3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        Agendamento5.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento5.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento5.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento5.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento5.setPreferredSize(new java.awt.Dimension(400, 70));

        seta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia5.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia5.setToolTipText("");
        txtBarbearia5.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario5.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico5.setForeground(new java.awt.Color(0, 51, 102));
        txtServico5.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico5.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAlterar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar5MouseClicked(evt);
            }
        });

        btnExcluir5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExcluir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento5Layout = new javax.swing.GroupLayout(Agendamento5);
        Agendamento5.setLayout(Agendamento5Layout);
        Agendamento5Layout.setHorizontalGroup(
            Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento5Layout.createSequentialGroup()
                .addComponent(seta4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir5)
                .addContainerGap())
        );
        Agendamento5Layout.setVerticalGroup(
            Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Agendamento5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Agendamento6.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento6.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento6.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento6.setMinimumSize(new java.awt.Dimension(450, 70));

        seta5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia6.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia6.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia6.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario6.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario6.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario6.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico6.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico6.setForeground(new java.awt.Color(0, 51, 102));
        txtServico6.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico6.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar6.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar6MouseClicked(evt);
            }
        });

        btnExcluir6.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnExcluir6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento6Layout = new javax.swing.GroupLayout(Agendamento6);
        Agendamento6.setLayout(Agendamento6Layout);
        Agendamento6Layout.setHorizontalGroup(
            Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento6Layout.createSequentialGroup()
                .addComponent(seta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtHorario6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBarbearia6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir6)
                .addContainerGap())
        );
        Agendamento6Layout.setVerticalGroup(
            Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcluir6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAlterar6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento6Layout.createSequentialGroup()
                .addGroup(Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Agendamento6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBarbearia6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento7.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento7.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento7.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento7.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento7.setRequestFocusEnabled(false);

        seta6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia7.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia7.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia7.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario7.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario7.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario7.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico7.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico7.setForeground(new java.awt.Color(0, 51, 102));
        txtServico7.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico7.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar7.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar7MouseClicked(evt);
            }
        });

        btnExcluir7.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnExcluir7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento7Layout = new javax.swing.GroupLayout(Agendamento7);
        Agendamento7.setLayout(Agendamento7Layout);
        Agendamento7Layout.setHorizontalGroup(
            Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento7Layout.createSequentialGroup()
                .addComponent(seta6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico7, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir7)
                .addContainerGap())
        );
        Agendamento7Layout.setVerticalGroup(
            Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcluir7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Agendamento7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(btnAlterar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Agendamento8.setBackground(new java.awt.Color(255, 255, 255));
        Agendamento8.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento8.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento8.setMinimumSize(new java.awt.Dimension(450, 70));

        seta7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtBarbearia8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtBarbearia8.setForeground(new java.awt.Color(0, 51, 102));
        txtBarbearia8.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia8.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario8.setForeground(new java.awt.Color(0, 51, 102));
        txtHorario8.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario8.setPreferredSize(new java.awt.Dimension(300, 30));

        txtServico8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico8.setForeground(new java.awt.Color(0, 51, 102));
        txtServico8.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico8.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar8.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterarr.png"))); // NOI18N
        btnAlterar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar8MouseClicked(evt);
            }
        });

        btnExcluir8.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnExcluir8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluir8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento8Layout = new javax.swing.GroupLayout(Agendamento8);
        Agendamento8.setLayout(Agendamento8Layout);
        Agendamento8Layout.setHorizontalGroup(
            Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento8Layout.createSequentialGroup()
                .addComponent(seta7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBarbearia8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHorario8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(txtServico8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir8)
                .addContainerGap())
        );
        Agendamento8Layout.setVerticalGroup(
            Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBarbearia8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtServico8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(btnAlterar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelAgendamentosLayout = new javax.swing.GroupLayout(jPanelAgendamentos);
        jPanelAgendamentos.setLayout(jPanelAgendamentosLayout);
        jPanelAgendamentosLayout.setHorizontalGroup(
            jPanelAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendamentosLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanelAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Agendamento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agendamento3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Agendamento4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Agendamento8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agendamento7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Agendamento6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        jPanelAgendamentosLayout.setVerticalGroup(
            jPanelAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAgendamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jScrollPaneAgendamentos.setViewportView(jPanelAgendamentos);

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataAtual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneAgendamentos))
                .addContainerGap())
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPaneAgendamentos.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

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

    private void btnAlterar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar5MouseClicked

    private void btnExcluir5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluir5MouseClicked

    private void btnAlterar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar6MouseClicked

    private void btnExcluir6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluir6MouseClicked

    private void btnAlterar7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar7MouseClicked

    private void btnExcluir7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluir7MouseClicked

    private void btnAlterar8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar8MouseClicked

    private void btnExcluir8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluir8MouseClicked

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
    private javax.swing.JPanel Agendamento1;
    private javax.swing.JPanel Agendamento2;
    private javax.swing.JPanel Agendamento3;
    private javax.swing.JPanel Agendamento4;
    private javax.swing.JPanel Agendamento5;
    private javax.swing.JPanel Agendamento6;
    private javax.swing.JPanel Agendamento7;
    private javax.swing.JPanel Agendamento8;
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
    private javax.swing.JLabel btnAlterar5;
    private javax.swing.JLabel btnAlterar6;
    private javax.swing.JLabel btnAlterar7;
    private javax.swing.JLabel btnAlterar8;
    private javax.swing.JButton btnAlterarCadastro;
    private javax.swing.JLabel btnExcluir1;
    private javax.swing.JLabel btnExcluir2;
    private javax.swing.JLabel btnExcluir3;
    private javax.swing.JLabel btnExcluir4;
    private javax.swing.JLabel btnExcluir5;
    private javax.swing.JLabel btnExcluir6;
    private javax.swing.JLabel btnExcluir7;
    private javax.swing.JLabel btnExcluir8;
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
    private javax.swing.JPanel jPanelAgendamentos;
    private javax.swing.JPanel jPanelBarbearia;
    private javax.swing.JScrollPane jScrollPaneAgendamentos;
    private javax.swing.JScrollPane jScrollPaneBarbearia;
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
    private javax.swing.JLabel seta4;
    private javax.swing.JLabel seta5;
    private javax.swing.JLabel seta6;
    private javax.swing.JLabel seta7;
    private javax.swing.JLabel txtBarbearia1;
    private javax.swing.JLabel txtBarbearia2;
    private javax.swing.JLabel txtBarbearia3;
    private javax.swing.JLabel txtBarbearia4;
    private javax.swing.JLabel txtBarbearia5;
    private javax.swing.JLabel txtBarbearia6;
    private javax.swing.JLabel txtBarbearia7;
    private javax.swing.JLabel txtBarbearia8;
    private javax.swing.JLabel txtHorario1;
    private javax.swing.JLabel txtHorario2;
    private javax.swing.JLabel txtHorario3;
    private javax.swing.JLabel txtHorario4;
    private javax.swing.JLabel txtHorario5;
    private javax.swing.JLabel txtHorario6;
    private javax.swing.JLabel txtHorario7;
    private javax.swing.JLabel txtHorario8;
    private javax.swing.JLabel txtServico1;
    private javax.swing.JLabel txtServico2;
    private javax.swing.JLabel txtServico3;
    private javax.swing.JLabel txtServico4;
    private javax.swing.JLabel txtServico5;
    private javax.swing.JLabel txtServico6;
    private javax.swing.JLabel txtServico7;
    private javax.swing.JLabel txtServico8;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
