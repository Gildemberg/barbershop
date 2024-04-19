package view.barbearia;

import dao.AgendamentoDAO;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Agendamento;

public class TelaAgendamentoBarbearia extends javax.swing.JFrame {
    // VARIAVEIS
    int CODBARBEARIA;
    ArrayList<Integer> CODCLIENTES = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOS = new ArrayList<>();
    List<Agendamento> agendamentos = new ArrayList();
    
    //FORMATOS
    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
    
    //INSTANCIAS
    AgendamentoDAO agendamentoDao = new AgendamentoDAO();
    
    public TelaAgendamentoBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
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
    
    public void receberCodUsr(int CODBARBEARIA, String NOMEBARBEARIA){//receber o cod EMPRESA
        this.CODBARBEARIA = CODBARBEARIA;
        nome_barbearia.setText(NOMEBARBEARIA);
        consultarAgenda();
    }
    
    public void confirmarAgendamento(int CODAGENDAMENTO){
        if(JOptionPane.showConfirmDialog(this, "Confirma a conclusão do serviço?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            agendamentoDao.confirmarAgendamentoCliente(CODAGENDAMENTO, 1);
            consultarAgenda();
        }
    }
    
    public void consultarAgenda(){       
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        
        agendamentos = agendDAO.consultarAgendamentosBarbearia(CODBARBEARIA);
        

        JPanel[] paineisAgendamento = {Agendamento1, Agendamento2, Agendamento3, Agendamento4, Agendamento5};
        JLabel[] labelsCliente = {txtCliente1, txtCliente2, txtCliente3, txtCliente4, txtCliente5};
        JLabel[] labelsHorario = {txtHorario1, txtHorario2, txtHorario3, txtHorario4, txtHorario5};
        JLabel[] labelsServico = {txtServico1, txtServico2, txtServico3, txtServico4, txtServico5};
        JLabel[] labelsConfirmar = {btnConfirmar1, btnConfirmar2, btnConfirmar3, btnConfirmar4, btnConfirmar5};

        // Loop pelos agendamentos e configuração dos componentes
        for (int i = 0; i < agendamentos.size() && i < paineisAgendamento.length; i++) {
            Agendamento agendamento = agendamentos.get(i);
            JPanel painelAgendamento = paineisAgendamento[i];
            JLabel labelCliente = labelsCliente[i];
            JLabel labelHorario = labelsHorario[i];
            JLabel labelServico = labelsServico[i];
            JLabel labelConfirmar = labelsConfirmar[i];

            // Exibir o painel de agendamento correspondente
            painelAgendamento.setVisible(true);

            // Configurar os textos nos labels
            labelCliente.setText(agendamento.getNomecliente());
            labelHorario.setText(dataFormat.format(agendamento.getData()) +" às "+ horaFormat.format(agendamento.getHora()) + "h");
            labelServico.setText("Serviço: "+agendamento.getNomeservico());
            if(agendamento.getStatus()==1){
                labelConfirmar.setVisible(false);
            }

            // Adicionar os códigos de barbearia e agendamento às listas correspondentes
            CODCLIENTES.add(agendamento.getCodcliente());
            CODAGENDAMENTOS.add(agendamento.getCodagendamento());
        }

        // Ocultar os painéis de agendamento restantes (caso o número de agendamentos seja menor que 4)
        for (int i = agendamentos.size(); i < paineisAgendamento.length; i++) {
            paineisAgendamento[i].setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new css.FundoGradiente(70, 130, 180, 25, 25, 112, 0, 0, 1500, 100);
        sair = new javax.swing.JLabel();
        img1 = new javax.swing.JLabel();
        ola1 = new javax.swing.JLabel();
        localizacao1 = new javax.swing.JLabel();
        nome_barbearia = new javax.swing.JLabel();
        Centro = new javax.swing.JPanel();
        Agendamento1 = new css.JPanelArredondadoAgendamentos(30);
        seta1 = new javax.swing.JLabel();
        txtCliente1 = new javax.swing.JLabel();
        txtHorario1 = new javax.swing.JLabel();
        txtServico1 = new javax.swing.JLabel();
        btnConfirmar1 = new javax.swing.JLabel();
        Agendamento2 = new css.JPanelArredondadoAgendamentos(30);
        seta2 = new javax.swing.JLabel();
        txtCliente2 = new javax.swing.JLabel();
        txtHorario2 = new javax.swing.JLabel();
        txtServico2 = new javax.swing.JLabel();
        btnConfirmar2 = new javax.swing.JLabel();
        Agendamento3 = new css.JPanelArredondadoAgendamentos(30);
        seta3 = new javax.swing.JLabel();
        txtCliente3 = new javax.swing.JLabel();
        txtHorario3 = new javax.swing.JLabel();
        txtServico3 = new javax.swing.JLabel();
        btnConfirmar3 = new javax.swing.JLabel();
        Agendamento4 = new css.JPanelArredondadoAgendamentos(30);
        seta4 = new javax.swing.JLabel();
        txtCliente4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        txtServico4 = new javax.swing.JLabel();
        btnConfirmar4 = new javax.swing.JLabel();
        Agendamento5 = new css.JPanelArredondadoAgendamentos(30);
        seta5 = new javax.swing.JLabel();
        txtCliente5 = new javax.swing.JLabel();
        txtHorario5 = new javax.swing.JLabel();
        txtServico5 = new javax.swing.JLabel();
        btnConfirmar5 = new javax.swing.JLabel();
        Barbearias = new css.JPanelArredondadoBarbearias(60);
        jLabel14 = new javax.swing.JLabel();
        dataAtual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(29, 93, 183));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 130));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 130));
        Cima.setPreferredSize(new java.awt.Dimension(1920, 130));

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saida.png"))); // NOI18N
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        img1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        ola1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 36)); // NOI18N
        ola1.setForeground(new java.awt.Color(255, 255, 255));
        ola1.setText("Olá,");

        localizacao1.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 14)); // NOI18N
        localizacao1.setForeground(new java.awt.Color(255, 255, 255));
        localizacao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localizacao.png"))); // NOI18N
        localizacao1.setText("Paulo Afonso - BA");
        localizacao1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        nome_barbearia.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 36)); // NOI18N
        nome_barbearia.setForeground(new java.awt.Color(255, 255, 255));
        nome_barbearia.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(img1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addComponent(ola1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_barbearia, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(localizacao1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sair)
                .addGap(23, 23, 23))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CimaLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(img1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CimaLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nome_barbearia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ola1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(localizacao1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Centro.setBackground(new java.awt.Color(206, 230, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1920, 950));
        Centro.setMinimumSize(new java.awt.Dimension(1920, 950));
        Centro.setPreferredSize(new java.awt.Dimension(1920, 950));

        Agendamento1.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento1.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento1.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento1.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente1.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtCliente1.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente1.setToolTipText("");
        txtCliente1.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico1.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico1.setForeground(new java.awt.Color(255, 255, 255));
        txtServico1.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico1.setPreferredSize(new java.awt.Dimension(300, 30));

        btnConfirmar1.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfirmar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento1Layout = new javax.swing.GroupLayout(Agendamento1);
        Agendamento1.setLayout(Agendamento1Layout);
        Agendamento1Layout.setHorizontalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addComponent(seta1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorario1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(txtServico1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        Agendamento1Layout.setVerticalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addGroup(Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Agendamento1Layout.createSequentialGroup()
                                .addComponent(txtCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento2.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento2.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento2.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento2.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento2.setPreferredSize(new java.awt.Dimension(400, 100));

        seta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente2.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtCliente2.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente2.setToolTipText("");
        txtCliente2.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico2.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico2.setForeground(new java.awt.Color(255, 255, 255));
        txtServico2.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico2.setPreferredSize(new java.awt.Dimension(300, 30));

        btnConfirmar2.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfirmar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento2Layout = new javax.swing.GroupLayout(Agendamento2);
        Agendamento2.setLayout(Agendamento2Layout);
        Agendamento2Layout.setHorizontalGroup(
            Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento2Layout.createSequentialGroup()
                .addComponent(seta2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorario2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(txtServico2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        Agendamento2Layout.setVerticalGroup(
            Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento2Layout.createSequentialGroup()
                .addGroup(Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Agendamento2Layout.createSequentialGroup()
                                .addComponent(txtCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento3.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento3.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento3.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento3.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento3.setPreferredSize(new java.awt.Dimension(400, 100));

        seta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente3.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtCliente3.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente3.setToolTipText("");
        txtCliente3.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico3.setForeground(new java.awt.Color(255, 255, 255));
        txtServico3.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico3.setPreferredSize(new java.awt.Dimension(300, 30));

        btnConfirmar3.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfirmar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento3Layout = new javax.swing.GroupLayout(Agendamento3);
        Agendamento3.setLayout(Agendamento3Layout);
        Agendamento3Layout.setHorizontalGroup(
            Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento3Layout.createSequentialGroup()
                .addComponent(seta3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorario3, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(txtServico3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliente3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        Agendamento3Layout.setVerticalGroup(
            Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento3Layout.createSequentialGroup()
                .addGroup(Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Agendamento3Layout.createSequentialGroup()
                                .addComponent(txtCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento4.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento4.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento4.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento4.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento4.setPreferredSize(new java.awt.Dimension(400, 100));

        seta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente4.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtCliente4.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente4.setToolTipText("");
        txtCliente4.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico4.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico4.setForeground(new java.awt.Color(255, 255, 255));
        txtServico4.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico4.setPreferredSize(new java.awt.Dimension(300, 30));

        btnConfirmar4.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfirmar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento4Layout = new javax.swing.GroupLayout(Agendamento4);
        Agendamento4.setLayout(Agendamento4Layout);
        Agendamento4Layout.setHorizontalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento4Layout.createSequentialGroup()
                .addComponent(seta4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorario4, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(txtServico4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliente4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar4, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        Agendamento4Layout.setVerticalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento4Layout.createSequentialGroup()
                .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Agendamento4Layout.createSequentialGroup()
                                .addComponent(txtCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento5.setBackground(new java.awt.Color(30, 113, 218));
        Agendamento5.setForeground(new java.awt.Color(255, 255, 255));
        Agendamento5.setMaximumSize(new java.awt.Dimension(450, 70));
        Agendamento5.setMinimumSize(new java.awt.Dimension(450, 70));
        Agendamento5.setPreferredSize(new java.awt.Dimension(400, 100));

        seta5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente5.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtCliente5.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente5.setToolTipText("");
        txtCliente5.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHorario5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico5.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtServico5.setForeground(new java.awt.Color(255, 255, 255));
        txtServico5.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico5.setPreferredSize(new java.awt.Dimension(300, 30));

        btnConfirmar5.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfirmar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Agendamento5Layout = new javax.swing.GroupLayout(Agendamento5);
        Agendamento5.setLayout(Agendamento5Layout);
        Agendamento5Layout.setHorizontalGroup(
            Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento5Layout.createSequentialGroup()
                .addComponent(seta5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorario5, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addComponent(txtServico5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliente5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar5, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        Agendamento5Layout.setVerticalGroup(
            Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento5Layout.createSequentialGroup()
                .addGroup(Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Agendamento5Layout.createSequentialGroup()
                                .addComponent(txtCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Barbearias.setBackground(new java.awt.Color(30, 113, 218));
        Barbearias.setMaximumSize(new java.awt.Dimension(500, 45));
        Barbearias.setMinimumSize(new java.awt.Dimension(500, 45));
        Barbearias.setPreferredSize(new java.awt.Dimension(500, 45));

        jLabel14.setBackground(new java.awt.Color(30, 113, 218));
        jLabel14.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("AGENDAMENTOS");

        javax.swing.GroupLayout BarbeariasLayout = new javax.swing.GroupLayout(Barbearias);
        Barbearias.setLayout(BarbeariasLayout);
        BarbeariasLayout.setHorizontalGroup(
            BarbeariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        BarbeariasLayout.setVerticalGroup(
            BarbeariasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        dataAtual.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        dataAtual.setForeground(new java.awt.Color(0, 51, 204));
        dataAtual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dataAtual.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Barbearias, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Agendamento2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Agendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Agendamento3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Agendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Agendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1144, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(Barbearias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Agendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(dataAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, 1935, Short.MAX_VALUE)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, 1935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_sairMouseClicked

    private void btnConfirmar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar1MouseClicked
        confirmarAgendamento(CODAGENDAMENTOS.get(0));
    }//GEN-LAST:event_btnConfirmar1MouseClicked

    private void btnConfirmar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar2MouseClicked
        confirmarAgendamento(CODAGENDAMENTOS.get(1));
    }//GEN-LAST:event_btnConfirmar2MouseClicked

    private void btnConfirmar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar3MouseClicked
        confirmarAgendamento(CODAGENDAMENTOS.get(2));
    }//GEN-LAST:event_btnConfirmar3MouseClicked

    private void btnConfirmar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar4MouseClicked
        confirmarAgendamento(CODAGENDAMENTOS.get(3));
    }//GEN-LAST:event_btnConfirmar4MouseClicked

    private void btnConfirmar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar5MouseClicked
        confirmarAgendamento(CODAGENDAMENTOS.get(4));
    }//GEN-LAST:event_btnConfirmar5MouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgendamentoBarbearia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaAgendamentoBarbearia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agendamento1;
    private javax.swing.JPanel Agendamento2;
    private javax.swing.JPanel Agendamento3;
    private javax.swing.JPanel Agendamento4;
    private javax.swing.JPanel Agendamento5;
    private javax.swing.JPanel Barbearias;
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JLabel btnConfirmar1;
    private javax.swing.JLabel btnConfirmar2;
    private javax.swing.JLabel btnConfirmar3;
    private javax.swing.JLabel btnConfirmar4;
    private javax.swing.JLabel btnConfirmar5;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel localizacao1;
    private javax.swing.JLabel nome_barbearia;
    private javax.swing.JLabel ola1;
    private javax.swing.JLabel sair;
    private javax.swing.JLabel seta1;
    private javax.swing.JLabel seta2;
    private javax.swing.JLabel seta3;
    private javax.swing.JLabel seta4;
    private javax.swing.JLabel seta5;
    private javax.swing.JLabel txtCliente1;
    private javax.swing.JLabel txtCliente2;
    private javax.swing.JLabel txtCliente3;
    private javax.swing.JLabel txtCliente4;
    private javax.swing.JLabel txtCliente5;
    private javax.swing.JLabel txtHorario1;
    private javax.swing.JLabel txtHorario2;
    private javax.swing.JLabel txtHorario3;
    private javax.swing.JLabel txtHorario4;
    private javax.swing.JLabel txtHorario5;
    private javax.swing.JLabel txtServico1;
    private javax.swing.JLabel txtServico2;
    private javax.swing.JLabel txtServico3;
    private javax.swing.JLabel txtServico4;
    private javax.swing.JLabel txtServico5;
    // End of variables declaration//GEN-END:variables
}
