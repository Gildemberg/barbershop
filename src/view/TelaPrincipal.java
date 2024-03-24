package view;

import dao.BarbeariaDAO;
import dao.UsuarioDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Barbearia;
import model.ConsultarNome;
import model.TransfCod;


public final class TelaPrincipal extends javax.swing.JFrame {
    
    int COD_USR;
    String NOME_USR;
    String[] NOME_BARBER = new String[10];
    
      public TelaPrincipal() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        
        //Inserindo horario atual na tela principal
        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String horario = hoje.format(formato);
        dataAtual.setText(horario);
        //Ocultando inicialmente todas as linhas de empresa
        barbearia01.setVisible(false);
        barbearia02.setVisible(false);
        barbearia03.setVisible(false);
        barbearia04.setVisible(false);
        barbearia05.setVisible(false);
        consultarBarbearia();
    }
      
    public void consultarBarbearia(){
        BarbeariaDAO BarberDao = new BarbeariaDAO();
        int i=0;
        for(Barbearia b: BarberDao.read()){
            NOME_BARBER[i]=b.getNome();
            i++;
        }
        //Imprimindo as barbearias disponiveis
        barbearia01.setVisible(true);
        nome_barbearia01.setText(NOME_BARBER[0]);
        barbearia02.setVisible(true);
        nome_barbearia02.setText(NOME_BARBER[1]);
        barbearia03.setVisible(true);
        nome_barbearia03.setText(NOME_BARBER[2]);
        barbearia04.setVisible(true);
        nome_barbearia04.setText(NOME_BARBER[3]);
    }
    
    public void receberCodUsr(TransfCod TCU){//receber o cod USUÁRIO
        this.COD_USR = TCU.getCod(); //recebendo o cod usr
        UsuarioDAO UserDao = new UsuarioDAO();
        ConsultarNome CNU = new ConsultarNome();
        CNU = UserDao.retornoNome(COD_USR); //consultando o nome usr
        consultarNomeUsr(CNU);
    }

    public void consultarNomeUsr (ConsultarNome CNU){//consultando o nome USUÁRIO
        NOME_USR = CNU.getNome(); //recebendo o nome usr
        nome_usr.setText(NOME_USR); //imprimendo o nome usr
      }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new javax.swing.JPanel();
        sair = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();
        Centro = new css.FundoGradiente(0, 191, 255, 65, 105, 255, 0, 0, 1500, 100);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(29, 93, 183));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_sair2.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        dataAtual.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        dataAtual.setForeground(new java.awt.Color(255, 255, 255));
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
            .addGroup(barbearia01Layout.createSequentialGroup()
                .addComponent(logo01)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logo02)
                .addContainerGap())
        );
        barbearia02Layout.setVerticalGroup(
            barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barbearia02Layout.createSequentialGroup()
                .addGroup(barbearia02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo02)
                    .addComponent(nome_barbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(78, 78, 78)
                        .addComponent(img)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(ola)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome_usr, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(localizacao)))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barbearia02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barbearia05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(554, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nome_usr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localizacao)))
                .addGap(72, 72, 72)
                .addComponent(barbearia01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(barbearia05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Direita.setBackground(new java.awt.Color(65, 105, 255));

        jPanel1.setBackground(new java.awt.Color(206, 230, 255));

        jLabel1.setBackground(new java.awt.Color(29, 93, 183));
        jLabel1.setFont(new java.awt.Font("SimSun", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(29, 93, 183));
        jLabel1.setText("MEUS AGENDAMENTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon2_TESTE.png"))); // NOI18N

        javax.swing.GroupLayout DireitaLayout = new javax.swing.GroupLayout(Direita);
        Direita.setLayout(DireitaLayout);
        DireitaLayout.setHorizontalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DireitaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())))
        );
        DireitaLayout.setVerticalGroup(
            DireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DireitaLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1273, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
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

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        this.dispose();
        new TelaLogin().setVisible(true);
    }//GEN-LAST:event_sairMouseClicked

    private void barbearia01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia01MouseClicked
        TransfCod TC = new TransfCod(); // Instanciando o model transfCod
        TC.setCod(1); //setando o valor do cod da EMP
        TC.setCod1(COD_USR); //setando o valor do cod do USR
        TelaAgendamento TA = new TelaAgendamento(); // Instanciando a View Agendamento
        TA.receberCod(TC); // transferindo o cod da empresa
        TA.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_barbearia01MouseClicked

    private void barbearia02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia02MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(2);
        TC.setCod1(COD_USR); //setando o valor do cod do USR
        TelaAgendamento TA = new TelaAgendamento();
        TA.receberCod(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia02MouseClicked

    private void barbearia03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia03MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(3);
        TC.setCod1(COD_USR); //setando o valor do cod do USR
        TelaAgendamento TA = new TelaAgendamento();
        TA.receberCod(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia03MouseClicked

    private void barbearia04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia04MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(4);
        TC.setCod1(COD_USR); //setando o valor do cod do USR
        TelaAgendamento TA = new TelaAgendamento();
        TA.receberCod(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia04MouseClicked

    private void barbearia05MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barbearia05MouseClicked
        TransfCod TC = new TransfCod();
        TC.setCod(5);
        TC.setCod1(COD_USR); //setando o valor do cod do USR
        TelaAgendamento TA = new TelaAgendamento();
        TA.receberCod(TC);
        TA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barbearia05MouseClicked

        public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Direita;
    private javax.swing.JPanel barbearia01;
    private javax.swing.JPanel barbearia02;
    private javax.swing.JPanel barbearia03;
    private javax.swing.JPanel barbearia04;
    private javax.swing.JPanel barbearia05;
    private javax.swing.JPanel barbearia10;
    private javax.swing.JPanel barbearia11;
    private javax.swing.JPanel barbearia12;
    private javax.swing.JPanel barbearia13;
    private javax.swing.JPanel barbearia14;
    private javax.swing.JPanel barbearia15;
    private javax.swing.JPanel barbearia16;
    private javax.swing.JPanel barbearia17;
    private javax.swing.JPanel barbearia18;
    private javax.swing.JPanel barbearia5;
    private javax.swing.JPanel barbearia6;
    private javax.swing.JPanel barbearia7;
    private javax.swing.JPanel barbearia8;
    private javax.swing.JPanel barbearia9;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel localizacao;
    private javax.swing.JLabel logo01;
    private javax.swing.JLabel logo02;
    private javax.swing.JLabel logo03;
    private javax.swing.JLabel logo04;
    private javax.swing.JLabel logo05;
    private javax.swing.JLabel logo10;
    private javax.swing.JLabel logo11;
    private javax.swing.JLabel logo12;
    private javax.swing.JLabel logo13;
    private javax.swing.JLabel logo14;
    private javax.swing.JLabel logo15;
    private javax.swing.JLabel logo16;
    private javax.swing.JLabel logo17;
    private javax.swing.JLabel logo18;
    private javax.swing.JLabel logo5;
    private javax.swing.JLabel logo6;
    private javax.swing.JLabel logo7;
    private javax.swing.JLabel logo8;
    private javax.swing.JLabel logo9;
    private javax.swing.JLabel nome_barbearia01;
    private javax.swing.JLabel nome_barbearia02;
    private javax.swing.JLabel nome_barbearia03;
    private javax.swing.JLabel nome_barbearia04;
    private javax.swing.JLabel nome_barbearia05;
    private javax.swing.JLabel nome_barbearia10;
    private javax.swing.JLabel nome_barbearia11;
    private javax.swing.JLabel nome_barbearia12;
    private javax.swing.JLabel nome_barbearia13;
    private javax.swing.JLabel nome_barbearia14;
    private javax.swing.JLabel nome_barbearia15;
    private javax.swing.JLabel nome_barbearia16;
    private javax.swing.JLabel nome_barbearia17;
    private javax.swing.JLabel nome_barbearia18;
    private javax.swing.JLabel nome_barbearia5;
    private javax.swing.JLabel nome_barbearia6;
    private javax.swing.JLabel nome_barbearia7;
    private javax.swing.JLabel nome_barbearia8;
    private javax.swing.JLabel nome_barbearia9;
    private javax.swing.JLabel nome_usr;
    private javax.swing.JLabel ola;
    private javax.swing.JLabel sair;
    // End of variables declaration//GEN-END:variables

}
