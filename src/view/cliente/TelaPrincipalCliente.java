package view.cliente;

import dao.AgendamentoDAO;
import dao.BarbeariaDAO;
import dao.ClienteDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Agendamento;
import model.Barbearia;
import model.TransfCod;


public final class TelaPrincipalCliente extends javax.swing.JFrame {
    
    int CODCLIENTE;
    ArrayList<Integer> CODBARBEARIAS = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOS = new ArrayList<>();
    String NOMECLIENTE;
    
    public TelaPrincipalCliente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        
        //Inserindo horario atual na tela principal
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String horario = hoje.format(formato);
        dataAtual.setText(horario);
        //Ocultando inicialmente todas as empresa e agendamentos
        barbearia01.setVisible(false);
        barbearia02.setVisible(false);
        barbearia03.setVisible(false);
        barbearia04.setVisible(false);
        barbearia05.setVisible(false);
        Agendamento01.setVisible(false);
        Agendamento02.setVisible(false);
        Agendamento03.setVisible(false);
        consultarBarbearia();
    }
      
    public void consultarBarbearia(){
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
        }
    }
    
    public void consultarAgendamento(){
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        List<Agendamento> agendamentos = new ArrayList();
        agendamentos = agendDAO.read(CODCLIENTE);
        if(!agendamentos.isEmpty()){//so executa se a lista nao tiver vazia
            if(agendamentos.size() >= 1){  //so executa se tiver um item     
                Agendamento01.setVisible(true);
                txtBarbearia01.setText(agendamentos.get(0).getNomebarbearia());
                txtHorario01.setText(agendamentos.get(0).getHora()+"h  "+ agendamentos.get(0).getData().toString());
                CODBARBEARIAS.add(agendamentos.get(0).getCodbarbearia());
                CODAGENDAMENTOS.add(agendamentos.get(0).getId());
            }else{
                Agendamento01.setVisible(false);
                txtBarbearia01.setText("");
                txtHorario01.setText("");
            } if(agendamentos.size() >= 2){ //so executa se tiver dois item             
                Agendamento02.setVisible(true);
                txtBarbearia02.setText(agendamentos.get(1).getNomebarbearia());
                txtHorario02.setText(agendamentos.get(1).getHora()+"h  "+ agendamentos.get(1).getData().toString());
                CODBARBEARIAS.add(agendamentos.get(1).getCodbarbearia());
                CODAGENDAMENTOS.add(agendamentos.get(1).getId());
            }else{
                Agendamento02.setVisible(false);
                txtBarbearia02.setText("");
                txtHorario02.setText("");
            }if(agendamentos.size() >= 3){ //so executa se tiver tres item                    
                Agendamento03.setVisible(true);
                txtBarbearia03.setText(agendamentos.get(2).getNomebarbearia());
                txtHorario03.setText(agendamentos.get(2).getHora()+"h  "+ agendamentos.get(2).getData().toString());
                CODBARBEARIAS.add(agendamentos.get(2).getCodbarbearia());
                CODAGENDAMENTOS.add(agendamentos.get(2).getId());
            }else{
                Agendamento03.setVisible(false);
                txtBarbearia03.setText("");
                txtHorario03.setText("");
            } 
        }
    }
    
    public void receberCodUsr(TransfCod TCU){//receber o cod USUÁRIO
        this.CODCLIENTE = TCU.getCod(); //recebendo o cod usr
        imprimirNomeCliente(CODCLIENTE);
        consultarAgendamento();
    }

    public void imprimirNomeCliente (int CODCLIENTE){//consultando o nome USUÁRIO
        ClienteDAO ClienteDao = new ClienteDAO();
        this.NOMECLIENTE=ClienteDao.retornoNome(CODCLIENTE);
        nome_usr.setText(NOMECLIENTE); //imprimendo o nome usr
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new css.FundoGradiente(0, 255, 255, 30, 144, 255, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();
        Centro = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        ola = new javax.swing.JLabel();
        nome_usr = new javax.swing.JLabel();
        localizacao = new javax.swing.JLabel();
        barbearia01 = new javax.swing.JPanel();
        nome_barbearia01 = new javax.swing.JLabel();
        logo01 = new javax.swing.JLabel();
        barbearia02 = new javax.swing.JPanel();
        nome_barbearia02 = new javax.swing.JLabel();
        logo02 = new javax.swing.JLabel();
        barbearia03 = new javax.swing.JPanel();
        nome_barbearia03 = new javax.swing.JLabel();
        logo03 = new javax.swing.JLabel();
        barbearia04 = new javax.swing.JPanel();
        nome_barbearia04 = new javax.swing.JLabel();
        logo04 = new javax.swing.JLabel();
        barbearia05 = new javax.swing.JPanel();
        nome_barbearia05 = new javax.swing.JLabel();
        logo05 = new javax.swing.JLabel();
        Direita = new javax.swing.JPanel();
        MeusAgendamentos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LogoMA = new javax.swing.JLabel();
        Agendamento01 = new javax.swing.JPanel();
        txtBarbearia01 = new javax.swing.JLabel();
        txtHorario01 = new javax.swing.JLabel();
        btnAlterar1 = new javax.swing.JLabel();
        btnExcluir1 = new javax.swing.JLabel();
        Agendamento02 = new javax.swing.JPanel();
        txtBarbearia02 = new javax.swing.JLabel();
        txtHorario02 = new javax.swing.JLabel();
        btnAlterar2 = new javax.swing.JLabel();
        btnExcluir2 = new javax.swing.JLabel();
        Agendamento03 = new javax.swing.JPanel();
        txtBarbearia03 = new javax.swing.JLabel();
        txtHorario03 = new javax.swing.JLabel();
        btnAlterar3 = new javax.swing.JLabel();
        btnExcluir3 = new javax.swing.JLabel();

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

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1395, Short.MAX_VALUE)
                .addComponent(sair)
                .addGap(23, 23, 23))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Centro.setBackground(new java.awt.Color(206, 230, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1420, 980));
        Centro.setMinimumSize(new java.awt.Dimension(1420, 980));
        Centro.setPreferredSize(new java.awt.Dimension(1420, 980));

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

        barbearia01.setBackground(new java.awt.Color(122, 188, 255));
        barbearia01.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia01.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia01.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia01.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia01MouseClicked(evt);
            }
        });

        nome_barbearia01.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome_barbearia01.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia01.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia01.setMaximumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia01.setMinimumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia01.setPreferredSize(new java.awt.Dimension(1027, 55));

        logo01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        javax.swing.GroupLayout barbearia01Layout = new javax.swing.GroupLayout(barbearia01);
        barbearia01.setLayout(barbearia01Layout);
        barbearia01Layout.setHorizontalGroup(
            barbearia01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia01Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome_barbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo01)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        barbearia01Layout.setVerticalGroup(
            barbearia01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nome_barbearia01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logo01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        barbearia02.setBackground(new java.awt.Color(122, 188, 255));
        barbearia02.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia02.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia02.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia02.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia02MouseClicked(evt);
            }
        });

        nome_barbearia02.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome_barbearia02.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia02.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia02.setMaximumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia02.setMinimumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia02.setPreferredSize(new java.awt.Dimension(1027, 55));

        logo02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        javax.swing.GroupLayout barbearia02Layout = new javax.swing.GroupLayout(barbearia02);
        barbearia02.setLayout(barbearia02Layout);
        barbearia02Layout.setHorizontalGroup(
            barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia02Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome_barbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo02)
                .addContainerGap())
        );
        barbearia02Layout.setVerticalGroup(
            barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia02Layout.createSequentialGroup()
                .addGroup(barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nome_barbearia02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia03.setBackground(new java.awt.Color(122, 188, 255));
        barbearia03.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia03.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia03.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia03.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia03MouseClicked(evt);
            }
        });

        nome_barbearia03.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome_barbearia03.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia03.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia03.setMaximumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia03.setMinimumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia03.setPreferredSize(new java.awt.Dimension(1027, 55));

        logo03.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        javax.swing.GroupLayout barbearia03Layout = new javax.swing.GroupLayout(barbearia03);
        barbearia03.setLayout(barbearia03Layout);
        barbearia03Layout.setHorizontalGroup(
            barbearia03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia03Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome_barbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo03)
                .addContainerGap())
        );
        barbearia03Layout.setVerticalGroup(
            barbearia03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia03Layout.createSequentialGroup()
                .addGroup(barbearia03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia03, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo03, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia04.setBackground(new java.awt.Color(122, 188, 255));
        barbearia04.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia04.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia04.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia04.setPreferredSize(new java.awt.Dimension(1150, 55));
        barbearia04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia04MouseClicked(evt);
            }
        });

        nome_barbearia04.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome_barbearia04.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia04.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia04.setMaximumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia04.setMinimumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia04.setPreferredSize(new java.awt.Dimension(1027, 55));

        logo04.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        javax.swing.GroupLayout barbearia04Layout = new javax.swing.GroupLayout(barbearia04);
        barbearia04.setLayout(barbearia04Layout);
        barbearia04Layout.setHorizontalGroup(
            barbearia04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia04Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome_barbearia04, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo04)
                .addContainerGap())
        );
        barbearia04Layout.setVerticalGroup(
            barbearia04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia04Layout.createSequentialGroup()
                .addGroup(barbearia04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo04, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        barbearia05.setBackground(new java.awt.Color(122, 188, 255));
        barbearia05.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barbearia05.setMaximumSize(new java.awt.Dimension(1150, 55));
        barbearia05.setMinimumSize(new java.awt.Dimension(1150, 55));
        barbearia05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barbearia05MouseClicked(evt);
            }
        });

        nome_barbearia05.setFont(new java.awt.Font("SimSun", 0, 24)); // NOI18N
        nome_barbearia05.setForeground(new java.awt.Color(29, 93, 183));
        nome_barbearia05.setBorder(new javax.swing.border.MatteBorder(null));
        nome_barbearia05.setMaximumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia05.setMinimumSize(new java.awt.Dimension(1027, 55));
        nome_barbearia05.setPreferredSize(new java.awt.Dimension(1027, 55));

        logo05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_barbearia_men_space.png"))); // NOI18N

        javax.swing.GroupLayout barbearia05Layout = new javax.swing.GroupLayout(barbearia05);
        barbearia05.setLayout(barbearia05Layout);
        barbearia05Layout.setHorizontalGroup(
            barbearia05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia05Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(nome_barbearia05, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo05)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        barbearia05Layout.setVerticalGroup(
            barbearia05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia05Layout.createSequentialGroup()
                .addGroup(barbearia05Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nome_barbearia05, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logo05, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barbearia02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(img)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(ola)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome_usr, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(localizacao))))
                .addContainerGap(418, Short.MAX_VALUE))
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
                .addGap(18, 75, Short.MAX_VALUE)
                .addComponent(barbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1229, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(122, 188, 255));
        Direita.setMaximumSize(new java.awt.Dimension(500, 980));
        Direita.setMinimumSize(new java.awt.Dimension(500, 980));
        Direita.setPreferredSize(new java.awt.Dimension(500, 980));

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

        LogoMA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon2_TESTE.png"))); // NOI18N

        Agendamento01.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento01.setForeground(new java.awt.Color(255, 255, 255));

        txtBarbearia01.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtBarbearia01.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia01.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario01.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario01.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario01.setBorder(new javax.swing.border.MatteBorder(null));

        btnAlterar1.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alterar.png"))); // NOI18N
        btnAlterar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar1MouseClicked(evt);
            }
        });

        btnExcluir1.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario01, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir1)
                .addContainerGap())
        );
        Agendamento01Layout.setVerticalGroup(
            Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento01Layout.createSequentialGroup()
                .addComponent(txtBarbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario01, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Agendamento01Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento02.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento02.setForeground(new java.awt.Color(255, 255, 255));

        txtBarbearia02.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtBarbearia02.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia02.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario02.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario02.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario02.setBorder(new javax.swing.border.MatteBorder(null));

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

        javax.swing.GroupLayout Agendamento02Layout = new javax.swing.GroupLayout(Agendamento02);
        Agendamento02.setLayout(Agendamento02Layout);
        Agendamento02Layout.setHorizontalGroup(
            Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento02Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario02, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir2)
                .addContainerGap())
        );
        Agendamento02Layout.setVerticalGroup(
            Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento02Layout.createSequentialGroup()
                .addComponent(txtBarbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario02, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Agendamento02Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento03.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento03.setForeground(new java.awt.Color(255, 255, 255));

        txtBarbearia03.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtBarbearia03.setForeground(new java.awt.Color(255, 255, 255));
        txtBarbearia03.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario03.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario03.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario03.setBorder(new javax.swing.border.MatteBorder(null));

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

        javax.swing.GroupLayout Agendamento03Layout = new javax.swing.GroupLayout(Agendamento03);
        Agendamento03.setLayout(Agendamento03Layout);
        Agendamento03Layout.setHorizontalGroup(
            Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento03Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorario03, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAlterar3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir3)
                .addContainerGap())
        );
        Agendamento03Layout.setVerticalGroup(
            Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento03Layout.createSequentialGroup()
                .addComponent(txtBarbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario03, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento03Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(LogoMA)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agendamento01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agendamento02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Agendamento03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(MeusAgendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Agendamento01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Agendamento02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(Agendamento03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 823, Short.MAX_VALUE)
                .addComponent(LogoMA)
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, 2161, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, 1661, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(Direita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Direita, javax.swing.GroupLayout.DEFAULT_SIZE, 1739, Short.MAX_VALUE)
                    .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, 1739, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        this.dispose();
        new TelaLoginCliente().setVisible(true);
    }//GEN-LAST:event_sairMouseClicked

    private void barbearia01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia01MouseClicked
        TransfCod TC = new TransfCod(); // Instanciando o model transfCod
        TC.setCod(1); //setando o valor do cod da EMP
        TC.setCod1(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente(); // Instanciando a View Agendamento
        TA.receberCodAgend(TC); // transferindo o cod da empresa
        TA.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_barbearia01MouseClicked

    private void barbearia02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia02MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(2);
        TC.setCod1(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente();
        TA.receberCodAgend(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia02MouseClicked

    private void barbearia03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia03MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(3);
        TC.setCod1(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente();
        TA.receberCodAgend(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia03MouseClicked

    private void barbearia04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia04MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(4);
        TC.setCod1(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente();
        TA.receberCodAgend(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia04MouseClicked

    private void barbearia05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia05MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(5);
        TC.setCod1(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente();
        TA.receberCodAgend(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia05MouseClicked

    private void btnAlterar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar1MouseClicked
        int CODAGENDAMENTO = CODAGENDAMENTOS.get(0);
        int CODBARBEARIA = CODBARBEARIAS.get(0);
        TransfCod TC = new TransfCod(); // Instanciando o model transfCod
        TC.setCod(CODAGENDAMENTO); //setando o valor do cod do AGEND
        TC.setCod1(CODBARBEARIA); //setando o valor do cod da EMP
        TC.setCod2(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente(); // Instanciando a View Agendamento
        TA.receberCodReAgend(TC); // transferindo o cod da empresa
        TA.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnAlterar1MouseClicked

    private void btnAlterar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar2MouseClicked
        int CODAGENDAMENTO = CODAGENDAMENTOS.get(1);
        int CODBARBEARIA = CODBARBEARIAS.get(1);
        TransfCod TC = new TransfCod(); // Instanciando o model transfCod
        TC.setCod(CODAGENDAMENTO); //setando o valor do cod do AGEND
        TC.setCod1(CODBARBEARIA); //setando o valor do cod da EMP
        TC.setCod2(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente(); // Instanciando a View Agendamento
        TA.receberCodReAgend(TC); // transferindo o cod da empresa
        TA.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnAlterar2MouseClicked

    private void btnAlterar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar3MouseClicked
        int CODAGENDAMENTO = CODAGENDAMENTOS.get(1);
        int CODBARBEARIA = CODBARBEARIAS.get(2);
        TransfCod TC = new TransfCod(); // Instanciando o model transfCod
        TC.setCod(CODAGENDAMENTO); //setando o valor do cod do AGEND
        TC.setCod1(CODBARBEARIA); //setando o valor do cod da EMP
        TC.setCod2(CODCLIENTE); //setando o valor do cod do USR
        TelaAgendamentoCliente TA = new TelaAgendamentoCliente(); // Instanciando a View Agendamento
        TA.receberCodReAgend(TC); // transferindo o cod da empresa
        TA.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnAlterar3MouseClicked

    private void btnExcluir1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir1MouseClicked
        int CODAGENDAMENTO = CODAGENDAMENTOS.get(1);
        AgendamentoDAO a = new AgendamentoDAO();
        a.delete(CODAGENDAMENTO);
        consultarAgendamento();
    }//GEN-LAST:event_btnExcluir1MouseClicked

    private void btnExcluir2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir2MouseClicked
        int CODAGENDAMENTO = CODAGENDAMENTOS.get(1);
        AgendamentoDAO a = new AgendamentoDAO();
        a.delete(CODAGENDAMENTO);
        consultarAgendamento();
    }//GEN-LAST:event_btnExcluir2MouseClicked

    private void btnExcluir3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluir3MouseClicked
        int CODAGENDAMENTO = CODAGENDAMENTOS.get(1);
        AgendamentoDAO a = new AgendamentoDAO();
        a.delete(CODAGENDAMENTO);
        consultarAgendamento();
    }//GEN-LAST:event_btnExcluir3MouseClicked

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
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Direita;
    private javax.swing.JLabel LogoMA;
    private javax.swing.JPanel MeusAgendamentos;
    private javax.swing.JPanel barbearia01;
    private javax.swing.JPanel barbearia02;
    private javax.swing.JPanel barbearia03;
    private javax.swing.JPanel barbearia04;
    private javax.swing.JPanel barbearia05;
    private javax.swing.JLabel btnAlterar1;
    private javax.swing.JLabel btnAlterar2;
    private javax.swing.JLabel btnAlterar3;
    private javax.swing.JLabel btnExcluir1;
    private javax.swing.JLabel btnExcluir2;
    private javax.swing.JLabel btnExcluir3;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel localizacao;
    private javax.swing.JLabel logo01;
    private javax.swing.JLabel logo02;
    private javax.swing.JLabel logo03;
    private javax.swing.JLabel logo04;
    private javax.swing.JLabel logo05;
    private javax.swing.JLabel nome_barbearia01;
    private javax.swing.JLabel nome_barbearia02;
    private javax.swing.JLabel nome_barbearia03;
    private javax.swing.JLabel nome_barbearia04;
    private javax.swing.JLabel nome_barbearia05;
    private javax.swing.JLabel nome_usr;
    private javax.swing.JLabel ola;
    private javax.swing.JLabel sair;
    private javax.swing.JLabel txtBarbearia01;
    private javax.swing.JLabel txtBarbearia02;
    private javax.swing.JLabel txtBarbearia03;
    private javax.swing.JLabel txtHorario01;
    private javax.swing.JLabel txtHorario02;
    private javax.swing.JLabel txtHorario03;
    // End of variables declaration//GEN-END:variables
}
