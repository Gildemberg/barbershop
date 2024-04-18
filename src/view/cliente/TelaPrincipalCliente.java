package view.cliente;

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
import css.*;
import java.awt.BorderLayout;
import javax.swing.JButton;


public final class TelaPrincipalCliente extends javax.swing.JFrame {
    TelaAgendamentoCliente TAC = new TelaAgendamentoCliente();
    AgendamentoDAO agendamentoDao = new AgendamentoDAO();
    int CODCLIENTE;
    ArrayList<Integer> CODBARBEARIAS = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOS = new ArrayList<>();
    String NOMECLIENTE;
    
    public TelaPrincipalCliente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        consultarBarbearia();
        
        //Inserindo horario atual na tela principal
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String horario = hoje.format(formato);
        dataAtual.setText(horario);
    }
      
    public void receberCodCliente(int CODCLIENTE){//receber o cod USUÁRIO
        this.CODCLIENTE = CODCLIENTE; //recebendo o cod usr
        exibirNomeCliente(CODCLIENTE);
        consultarAgendamento();
    }

    public void exibirNomeCliente (int CODCLIENTE){//consultando o nome USUÁRIO
        ClienteDAO ClienteDao = new ClienteDAO();
        this.NOMECLIENTE=ClienteDao.retornoNome(CODCLIENTE);
        nome_usr.setText(NOMECLIENTE); //imprimendo o nome usr
      }
    
    public void consultarBarbearia(){
        barbearia01.setVisible(false);
        barbearia02.setVisible(false);
        barbearia03.setVisible(false);
        barbearia04.setVisible(false);
        barbearia05.setVisible(false);
        barbearia06.setVisible(false);
        barbearia7.setVisible(false);
        barbearia8.setVisible(false);
        barbearia9.setVisible(false);
        barbearia10.setVisible(false);
        barbearia11.setVisible(false);
        
        BarbeariaDAO BarberDao = new BarbeariaDAO();
        List<Barbearia> barbearias = new ArrayList();
        barbearias = BarberDao.read();
        if(!barbearias.isEmpty()){
            if(barbearias.size()>=1){
                barbearia01.setVisible(true);
                nome_barbearia01.setText(barbearias.get(0).getNome());
            }
            if(barbearias.size()>=2){
                barbearia02.setVisible(true);
                nome_barbearia02.setText(barbearias.get(1).getNome());
            }
            if(barbearias.size()>=3){
                barbearia03.setVisible(true);
                nome_barbearia03.setText(barbearias.get(2).getNome());
            }
            if(barbearias.size()>=4){
                barbearia04.setVisible(true);
                nome_barbearia04.setText(barbearias.get(3).getNome());
            }
            if(barbearias.size()>=5){
                barbearia05.setVisible(true);
                nome_barbearia05.setText(barbearias.get(4).getNome());
            }
            if(barbearias.size()>=6){
                barbearia06.setVisible(true);
                nome_barbearia06.setText(barbearias.get(5).getNome());
            }
            if(barbearias.size()>=7){
                barbearia7.setVisible(true);
                nome_barbearia7.setText(barbearias.get(6).getNome());
            }
            if(barbearias.size()>=8){
                barbearia8.setVisible(true);
                nome_barbearia8.setText(barbearias.get(7).getNome());
            }
            if(barbearias.size()>=9){
                barbearia9.setVisible(true);
                nome_barbearia9.setText(barbearias.get(8).getNome());
            }
            if(barbearias.size()>=10){
                barbearia10.setVisible(true);
                nome_barbearia10.setText(barbearias.get(9).getNome());
            }
            if(barbearias.size()>=11){
                barbearia11.setVisible(true);
                nome_barbearia11.setText(barbearias.get(10).getNome());
            }
        }
    }
    
    public void consultarAgendamento(){
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        List<Agendamento> agendamentos = new ArrayList();
        agendamentos = agendDAO.consultarAgendamentosCliente(CODCLIENTE);
        
        Agendamento01.setVisible(false);
        Agendamento02.setVisible(false);
        Agendamento03.setVisible(false);
        Agendamento4.setVisible(false);
        
        if(!agendamentos.isEmpty()){//so executa se a lista nao tiver vazia
            if(agendamentos.size() >= 1){  //so executa se tiver um item     
                Agendamento01.setVisible(true);
                txtBarbearia01.setText(agendamentos.get(0).getNomebarbearia());
                txtHorario01.setText(hora.format(agendamentos.get(0).getHora())+"h  "+data.format(agendamentos.get(0).getData()));
                CODBARBEARIAS.add(agendamentos.get(0).getCodbarbearia());
                CODAGENDAMENTOS.add(agendamentos.get(0).getId());
            }if(agendamentos.size() >= 2){ //so executa se tiver dois item             
                Agendamento02.setVisible(true);
                txtBarbearia02.setText(agendamentos.get(1).getNomebarbearia());
                txtHorario02.setText(hora.format(agendamentos.get(1).getHora())+"h  "+ data.format(agendamentos.get(1).getData()));
                CODBARBEARIAS.add(agendamentos.get(1).getCodbarbearia());
                CODAGENDAMENTOS.add(agendamentos.get(1).getId());
            }if(agendamentos.size() >= 3){ //so executa se tiver tres item                    
                Agendamento03.setVisible(true);
                txtBarbearia03.setText(agendamentos.get(2).getNomebarbearia());
                txtHorario03.setText(hora.format(agendamentos.get(2).getHora())+"h  "+ data.format(agendamentos.get(2).getData()));
                CODBARBEARIAS.add(agendamentos.get(2).getCodbarbearia());
                CODAGENDAMENTOS.add(agendamentos.get(2).getId());
            }if(agendamentos.size() >= 4){ //so executa se tiver tres item                    
                Agendamento4.setVisible(true);
                txtBarbearia4.setText(agendamentos.get(3).getNomebarbearia());
                txtHorario4.setText(hora.format(agendamentos.get(3).getHora())+"h  "+ data.format(agendamentos.get(3).getData()));
                CODBARBEARIAS.add(agendamentos.get(3).getCodbarbearia());
                CODAGENDAMENTOS.add(agendamentos.get(3).getId());
            }
        }
    }
    
    public void abrirBarbearia(int CODBARBEARIA){
        TAC.receberCodAgend(CODBARBEARIA, CODCLIENTE); // transferindo o cod da empresa
        TAC.setVisible(true);
        this.dispose();
    }
    
    public void alterarAgendamento(int CODAGENDAMENTO, int CODBARBEARIA){
        TAC.receberCodReAgend(CODAGENDAMENTO, CODBARBEARIA, CODCLIENTE); 
        TAC.setVisible(true);
        this.dispose(); 
    }
    
    public void excluirAgendamento(int CODAGENDAMENTO){
        if(JOptionPane.showConfirmDialog(this, "Você deseja realmente deletar o agendamento?", "Remover", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            agendamentoDao.deleteAgendamentoCliente(CODAGENDAMENTO);
            consultarAgendamento();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new css.FundoGradiente(0, 255, 255, 30, 144, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();
        alterarCadastro = new javax.swing.JLabel();
        Centro = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        ola = new javax.swing.JLabel();
        nome_usr = new javax.swing.JLabel();
        localizacao = new javax.swing.JLabel();
        barbearia01 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia01 = new javax.swing.JLabel();
        logo01 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        barbearia02 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia02 = new javax.swing.JLabel();
        logo02 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barbearia03 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia03 = new javax.swing.JLabel();
        logo03 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        barbearia04 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia04 = new javax.swing.JLabel();
        logo04 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        barbearia05 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia05 = new javax.swing.JLabel();
        logo05 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        barbearia06 = new css.JPanelArredondadoBarbearias(30);
        nome_barbearia06 = new javax.swing.JLabel();
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
        LogoFundoCenter = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        MeusAgendamentos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Agendamento01 = new css.JPanelArredondadoAgendamentos(30);
        txtBarbearia01 = new javax.swing.JLabel();
        txtHorario01 = new javax.swing.JLabel();
        btnAlterar1 = new javax.swing.JLabel();
        btnExcluir1 = new javax.swing.JLabel();
        seta = new javax.swing.JLabel();
        Agendamento02 = new css.JPanelArredondadoAgendamentos(30);
        txtBarbearia02 = new javax.swing.JLabel();
        txtHorario02 = new javax.swing.JLabel();
        btnAlterar2 = new javax.swing.JLabel();
        btnExcluir2 = new javax.swing.JLabel();
        seta1 = new javax.swing.JLabel();
        Agendamento03 = new css.JPanelArredondadoAgendamentos(30);
        txtBarbearia03 = new javax.swing.JLabel();
        txtHorario03 = new javax.swing.JLabel();
        btnAlterar3 = new javax.swing.JLabel();
        btnExcluir3 = new javax.swing.JLabel();
        seta2 = new javax.swing.JLabel();
        Agendamento4 = new css.JPanelArredondadoAgendamentos(30);
        txtBarbearia4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        btnAlterar4 = new javax.swing.JLabel();
        btnExcluir4 = new javax.swing.JLabel();
        seta3 = new javax.swing.JLabel();
        LogoMA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(29, 93, 183));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 100));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 100));
        Cima.setPreferredSize(new java.awt.Dimension(1920, 100));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sair2.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        dataAtual.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        dataAtual.setForeground(new java.awt.Color(0, 51, 204));
        dataAtual.setBorder(new javax.swing.border.MatteBorder(null));

        alterarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editarcadastro.png"))); // NOI18N
        alterarCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        alterarCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alterarCadastroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1086, Short.MAX_VALUE)
                .addComponent(alterarCadastro)
                .addGap(18, 18, 18)
                .addComponent(sair)
                .addGap(23, 23, 23))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alterarCadastro)
                    .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dataAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Centro.setBackground(new java.awt.Color(206, 230, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1320, 980));
        Centro.setMinimumSize(new java.awt.Dimension(1320, 980));
        Centro.setPreferredSize(new java.awt.Dimension(1320, 980));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_user.png"))); // NOI18N

        ola.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        ola.setForeground(new java.awt.Color(0, 51, 204));
        ola.setText("Olá,");

        nome_usr.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        nome_usr.setForeground(new java.awt.Color(0, 51, 204));
        nome_usr.setBorder(new javax.swing.border.MatteBorder(null));

        localizacao.setFont(new java.awt.Font("Mongolian Baiti", 0, 18)); // NOI18N
        localizacao.setForeground(new java.awt.Color(0, 51, 204));
        localizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone_local.png"))); // NOI18N
        localizacao.setText("Paulo Afonso - BA");

        barbearia01.setLayout(new BorderLayout());
        barbearia01.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia01.setBackground(new java.awt.Color(122, 177, 255));
        barbearia01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia01.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia01.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia01.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia01MouseClicked(evt);
            }
        });

        nome_barbearia01.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia01.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia01.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia01.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia01.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia01.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia01Layout = new javax.swing.GroupLayout(barbearia01);
        barbearia01.setLayout(barbearia01Layout);
        barbearia01Layout.setHorizontalGroup(
            barbearia01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia01Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo01)
                .addContainerGap())
        );
        barbearia01Layout.setVerticalGroup(
            barbearia01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nome_barbearia01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        barbearia02.setLayout(new BorderLayout());
        barbearia02.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia02.setBackground(new java.awt.Color(122, 177, 255));
        barbearia02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia02.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia02.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia02.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia02MouseClicked(evt);
            }
        });

        nome_barbearia02.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia02.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia02.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia02.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia02.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia02.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia02Layout = new javax.swing.GroupLayout(barbearia02);
        barbearia02.setLayout(barbearia02Layout);
        barbearia02Layout.setHorizontalGroup(
            barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia02Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nome_barbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo02)
                .addContainerGap())
        );
        barbearia02Layout.setVerticalGroup(
            barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia02Layout.createSequentialGroup()
                .addGroup(barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nome_barbearia02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barbearia03.setLayout(new BorderLayout());
        barbearia03.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia03.setBackground(new java.awt.Color(122, 177, 255));
        barbearia03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia03.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia03.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia03.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia03MouseClicked(evt);
            }
        });

        nome_barbearia03.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia03.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia03.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia03.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia03.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia03.setName(""); // NOI18N
        nome_barbearia03.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia03Layout = new javax.swing.GroupLayout(barbearia03);
        barbearia03.setLayout(barbearia03Layout);
        barbearia03Layout.setHorizontalGroup(
            barbearia03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia03Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo03)
                .addContainerGap())
        );
        barbearia03Layout.setVerticalGroup(
            barbearia03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia03Layout.createSequentialGroup()
                .addGroup(barbearia03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia03, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo03, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barbearia04.setLayout(new BorderLayout());
        barbearia04.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia04.setBackground(new java.awt.Color(122, 177, 255));
        barbearia04.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia04.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia04.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia04.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia04MouseClicked(evt);
            }
        });

        nome_barbearia04.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia04.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia04.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia04.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia04.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia04.setName(""); // NOI18N
        nome_barbearia04.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia04Layout = new javax.swing.GroupLayout(barbearia04);
        barbearia04.setLayout(barbearia04Layout);
        barbearia04Layout.setHorizontalGroup(
            barbearia04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia04Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo04)
                .addContainerGap())
        );
        barbearia04Layout.setVerticalGroup(
            barbearia04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia04Layout.createSequentialGroup()
                .addGroup(barbearia04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        barbearia05.setLayout(new BorderLayout());
        barbearia05.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia05.setBackground(new java.awt.Color(122, 177, 255));
        barbearia05.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia05.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia05.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia05MouseClicked(evt);
            }
        });

        nome_barbearia05.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia05.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia05.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia05.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia05.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia05.setName(""); // NOI18N
        nome_barbearia05.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia05Layout = new javax.swing.GroupLayout(barbearia05);
        barbearia05.setLayout(barbearia05Layout);
        barbearia05Layout.setHorizontalGroup(
            barbearia05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia05Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo05)
                .addContainerGap())
        );
        barbearia05Layout.setVerticalGroup(
            barbearia05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia05Layout.createSequentialGroup()
                .addGroup(barbearia05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia05, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo05, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia06.setLayout(new BorderLayout());
        barbearia06.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia06.setBackground(new java.awt.Color(122, 177, 255));
        barbearia06.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia06.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia06.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia06MouseClicked(evt);
            }
        });

        nome_barbearia06.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia06.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia06.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia06.setMaximumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia06.setMinimumSize(new java.awt.Dimension(1000, 55));
        nome_barbearia06.setName(""); // NOI18N
        nome_barbearia06.setPreferredSize(new java.awt.Dimension(1000, 55));

        logo06.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N

        javax.swing.GroupLayout barbearia06Layout = new javax.swing.GroupLayout(barbearia06);
        barbearia06.setLayout(barbearia06Layout);
        barbearia06Layout.setHorizontalGroup(
            barbearia06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia06Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(nome_barbearia06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo06)
                .addContainerGap())
        );
        barbearia06Layout.setVerticalGroup(
            barbearia06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia06Layout.createSequentialGroup()
                .addGroup(barbearia06Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia06, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo06, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        barbearia7.setLayout(new BorderLayout());
        barbearia7.add(new JButton("Meu Botão"), BorderLayout.CENTER);
        barbearia7.setBackground(new java.awt.Color(122, 177, 255));
        barbearia7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia7.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia7.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia7MouseClicked(evt);
            }
        });

        nome_barbearia7.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia7.setForeground(new java.awt.Color(29, 93, 183));
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
        barbearia8.setBackground(new java.awt.Color(122, 177, 255));
        barbearia8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia8.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia8.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia8MouseClicked(evt);
            }
        });

        nome_barbearia8.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia8.setForeground(new java.awt.Color(29, 93, 183));
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
        barbearia9.setBackground(new java.awt.Color(122, 177, 255));
        barbearia9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia9.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia9.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia9MouseClicked(evt);
            }
        });

        nome_barbearia9.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia9.setForeground(new java.awt.Color(29, 93, 183));
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
        barbearia10.setBackground(new java.awt.Color(122, 177, 255));
        barbearia10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia10.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia10.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia10MouseClicked(evt);
            }
        });

        nome_barbearia10.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia10.setForeground(new java.awt.Color(29, 93, 183));
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
        barbearia11.setBackground(new java.awt.Color(122, 177, 255));
        barbearia11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia11.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia11.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia11MouseClicked(evt);
            }
        });

        nome_barbearia11.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        nome_barbearia11.setForeground(new java.awt.Color(29, 93, 183));
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

        LogoFundoCenter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoFundoCenter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon2__1_-removebg-preview.png"))); // NOI18N
        LogoFundoCenter.setLabelFor(Centro);

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(img)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(ola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_usr, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(localizacao))
                .addContainerGap(602, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barbearia02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barbearia11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
            .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CentroLayout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(LogoFundoCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(176, Short.MAX_VALUE)))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nome_usr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localizacao)))
                .addGap(26, 26, 26)
                .addComponent(barbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CentroLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(LogoFundoCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(107, Short.MAX_VALUE)))
        );

        Direita.setBackground(new java.awt.Color(122, 177, 255));
        Direita.setMaximumSize(new java.awt.Dimension(600, 980));
        Direita.setMinimumSize(new java.awt.Dimension(600, 980));
        Direita.setPreferredSize(new java.awt.Dimension(600, 980));

        MeusAgendamentos.setBackground(new java.awt.Color(206, 230, 255));

        jLabel1.setBackground(new java.awt.Color(29, 93, 183));
        jLabel1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 93, 183));
        jLabel1.setText("MEUS AGENDAMENTOS");

        javax.swing.GroupLayout MeusAgendamentosLayout = new javax.swing.GroupLayout(MeusAgendamentos);
        MeusAgendamentos.setLayout(MeusAgendamentosLayout);
        MeusAgendamentosLayout.setHorizontalGroup(
            MeusAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MeusAgendamentosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        MeusAgendamentosLayout.setVerticalGroup(
            MeusAgendamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MeusAgendamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        Agendamento01.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento01.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento01.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento01.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento01.setPreferredSize(new java.awt.Dimension(450, 70));

        txtBarbearia01.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtBarbearia01.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia01.setToolTipText("");
        txtBarbearia01.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia01.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia01.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia01.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario01.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario01.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario01.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario01.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario01.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario01.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario01.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        btnAlterar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterar.png"))); // NOI18N
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

        seta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        javax.swing.GroupLayout Agendamento01Layout = new javax.swing.GroupLayout(Agendamento01);
        Agendamento01.setLayout(Agendamento01Layout);
        Agendamento01Layout.setHorizontalGroup(
            Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento01Layout.createSequentialGroup()
                .addComponent(seta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBarbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario01, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir1)
                .addContainerGap())
        );
        Agendamento01Layout.setVerticalGroup(
            Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento01Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBarbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario01, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(btnAlterar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Agendamento02.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento02.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento02.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento02.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento02.setPreferredSize(new java.awt.Dimension(450, 70));

        txtBarbearia02.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtBarbearia02.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia02.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia02.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia02.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia02.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario02.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario02.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario02.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario02.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario02.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario02.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar2.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterar.png"))); // NOI18N
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

        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        javax.swing.GroupLayout Agendamento02Layout = new javax.swing.GroupLayout(Agendamento02);
        Agendamento02.setLayout(Agendamento02Layout);
        Agendamento02Layout.setHorizontalGroup(
            Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento02Layout.createSequentialGroup()
                .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBarbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario02, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(btnAlterar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnExcluir2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Agendamento03.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento03.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento03.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento03.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento03.setPreferredSize(new java.awt.Dimension(450, 70));
        Agendamento03.setRequestFocusEnabled(false);

        txtBarbearia03.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtBarbearia03.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia03.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia03.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia03.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia03.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario03.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario03.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario03.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario03.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario03.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario03.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar3.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterar.png"))); // NOI18N
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

        seta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        javax.swing.GroupLayout Agendamento03Layout = new javax.swing.GroupLayout(Agendamento03);
        Agendamento03.setLayout(Agendamento03Layout);
        Agendamento03Layout.setHorizontalGroup(
            Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento03Layout.createSequentialGroup()
                .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBarbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario03, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(btnAlterar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Agendamento4.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento4.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento4.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento4.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento4.setPreferredSize(new java.awt.Dimension(450, 70));

        txtBarbearia4.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtBarbearia4.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia4.setBorder(new javax.swing.border.MatteBorder(null));
        txtBarbearia4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtBarbearia4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtBarbearia4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setPreferredSize(new java.awt.Dimension(300, 30));

        btnAlterar4.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterar.png"))); // NOI18N
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

        seta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        javax.swing.GroupLayout Agendamento4Layout = new javax.swing.GroupLayout(Agendamento4);
        Agendamento4.setLayout(Agendamento4Layout);
        Agendamento4Layout.setHorizontalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento4Layout.createSequentialGroup()
                .addComponent(seta3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBarbearia4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir4)
                .addContainerGap())
        );
        Agendamento4Layout.setVerticalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtBarbearia4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12))
                .addComponent(btnExcluir4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Agendamento4Layout.createSequentialGroup()
                .addComponent(seta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        LogoMA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon2_TESTE.png"))); // NOI18N

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Agendamento02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agendamento03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Agendamento01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Agendamento4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 75, Short.MAX_VALUE))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(Agendamento01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogoMA)
                .addGap(59, 59, 59))
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
                    .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void alterarCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alterarCadastroMouseClicked
        TelaCadastroCliente TCC = new TelaCadastroCliente();
        TCC.alterarCadastro(CODCLIENTE);
        TCC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_alterarCadastroMouseClicked

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        this.dispose();
        new TelaLoginCliente().setVisible(true);
    }//GEN-LAST:event_sairMouseClicked

    private void barbearia01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia01MouseClicked
        abrirBarbearia(1);
    }//GEN-LAST:event_barbearia01MouseClicked

    private void barbearia02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia02MouseClicked
        abrirBarbearia(2);
    }//GEN-LAST:event_barbearia02MouseClicked

    private void barbearia03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia03MouseClicked
        abrirBarbearia(3);
    }//GEN-LAST:event_barbearia03MouseClicked

    private void barbearia04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia04MouseClicked
        abrirBarbearia(4);
    }//GEN-LAST:event_barbearia04MouseClicked

    private void barbearia05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia05MouseClicked
        abrirBarbearia(5);
    }//GEN-LAST:event_barbearia05MouseClicked

    private void barbearia06MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia06MouseClicked
        abrirBarbearia(6);
    }//GEN-LAST:event_barbearia06MouseClicked

    private void barbearia7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia7MouseClicked
        abrirBarbearia(7);
    }//GEN-LAST:event_barbearia7MouseClicked

    private void barbearia8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia8MouseClicked
        abrirBarbearia(8);
    }//GEN-LAST:event_barbearia8MouseClicked

    private void barbearia9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia9MouseClicked
        abrirBarbearia(9);
    }//GEN-LAST:event_barbearia9MouseClicked

    private void barbearia10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia10MouseClicked
        abrirBarbearia(10);
    }//GEN-LAST:event_barbearia10MouseClicked

    private void barbearia11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia11MouseClicked
        abrirBarbearia(11);
    }//GEN-LAST:event_barbearia11MouseClicked

    private void btnAlterar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar1MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(0), CODBARBEARIAS.get(0));
    }//GEN-LAST:event_btnAlterar1MouseClicked

    private void btnAlterar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar2MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(1), CODBARBEARIAS.get(1));
    }//GEN-LAST:event_btnAlterar2MouseClicked

    private void btnAlterar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar3MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(2), CODBARBEARIAS.get(2)); 
    }//GEN-LAST:event_btnAlterar3MouseClicked

    private void btnAlterar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar4MouseClicked
        alterarAgendamento(CODAGENDAMENTOS.get(3), CODBARBEARIAS.get(3)); 
    }//GEN-LAST:event_btnAlterar4MouseClicked

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
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Direita;
    private javax.swing.JLabel LogoFundoCenter;
    private javax.swing.JLabel LogoMA;
    private javax.swing.JPanel MeusAgendamentos;
    private javax.swing.JLabel alterarCadastro;
    private javax.swing.JPanel barbearia01;
    private javax.swing.JPanel barbearia02;
    private javax.swing.JPanel barbearia03;
    private javax.swing.JPanel barbearia04;
    private javax.swing.JPanel barbearia05;
    private javax.swing.JPanel barbearia06;
    private javax.swing.JPanel barbearia10;
    private javax.swing.JPanel barbearia11;
    private javax.swing.JPanel barbearia7;
    private javax.swing.JPanel barbearia8;
    private javax.swing.JPanel barbearia9;
    private javax.swing.JLabel btnAlterar1;
    private javax.swing.JLabel btnAlterar2;
    private javax.swing.JLabel btnAlterar3;
    private javax.swing.JLabel btnAlterar4;
    private javax.swing.JLabel btnExcluir1;
    private javax.swing.JLabel btnExcluir2;
    private javax.swing.JLabel btnExcluir3;
    private javax.swing.JLabel btnExcluir4;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel nome_barbearia01;
    private javax.swing.JLabel nome_barbearia02;
    private javax.swing.JLabel nome_barbearia03;
    private javax.swing.JLabel nome_barbearia04;
    private javax.swing.JLabel nome_barbearia05;
    private javax.swing.JLabel nome_barbearia06;
    private javax.swing.JLabel nome_barbearia10;
    private javax.swing.JLabel nome_barbearia11;
    private javax.swing.JLabel nome_barbearia7;
    private javax.swing.JLabel nome_barbearia8;
    private javax.swing.JLabel nome_barbearia9;
    private javax.swing.JLabel nome_usr;
    private javax.swing.JLabel ola;
    private javax.swing.JLabel sair;
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
    // End of variables declaration//GEN-END:variables
}
