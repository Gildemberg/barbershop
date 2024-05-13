package view.barbearia;

import dao.AgendamentoDAO;
import dao.ExtratoDAO;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;
import model.Extrato;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class TelaCaixa extends javax.swing.JFrame {
    
    int CODBARBEARIA;
    int extratoOp=1;
    ArrayList<Integer> CODCLIENTESPENDENTE = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOSPENDENTE = new ArrayList<>();
    List<Agendamento> agendamentosPendentes = new ArrayList();
    
    
    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
    
    AgendamentoDAO agendDAO = new AgendamentoDAO();
    ExtratoDAO extratoDAO = new ExtratoDAO();
    
    public TelaCaixa() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        
    }
    
    public void receberCod(int CODBARBEARIA){//receber o cod EMPRESA
        this.CODBARBEARIA = CODBARBEARIA;
        consultarAgendamentosPendentes();
        listarExtrato();
    }
    
    public void confirmarAtendimento(int CODAGENDAMENTO){
        if(JOptionPane.showConfirmDialog(this, "Confirma a conclusão do serviço?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            agendDAO.confirmarAgendamentoCliente(CODAGENDAMENTO, 3, "Serviço Realizado");
            consultarAgendamentosPendentes();
            LocalDate today = LocalDate.now();
            LocalTime hour = LocalTime.now();
            Date hoje = Date.valueOf(today);
            
            Time hora = Time.valueOf(hour);
            
            Extrato e = new Extrato();
            e.setCodbarbearia(CODBARBEARIA);
            e.setCodagendamento(CODAGENDAMENTO);
            e.setData(hoje);
            e.setHora(hora);
            e.setValorPago(50);
            extratoDAO.create(e);
            listarExtrato();
        }
    }
    
    public void consultarAgendamentosPendentes(){
        agendamentosPendentes = agendDAO.consultarAgendamentosPendentes(CODBARBEARIA);
        
        JPanel[] paineisAgendamento = {AgendamentoPen1, AgendamentoPen2, AgendamentoPen3, AgendamentoPen4, AgendamentoPen5};
        JLabel[] labelsCliente = {txtCliente1, txtCliente2, txtCliente3, txtCliente4, txtCliente5};
        JLabel[] labelsHorario = {txtHorario1, txtHorario2, txtHorario3, txtHorario4, txtHorario5};
        JLabel[] labelsServico = {txtServico1, txtServico2, txtServico3, txtServico4, txtServico5};
        JLabel[] labelsConfirmar = {btnConfirmar1, btnConfirmar2, btnConfirmar3, btnConfirmar4, btnConfirmar5};

        // Loop pelos agendamentosAbertos e configuração dos componentes
        for (int i = 0; i < agendamentosPendentes.size() && i < paineisAgendamento.length; i++) {
            Agendamento agendamento = agendamentosPendentes.get(i);
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
            if(agendamento.getStatus()==3){
                labelConfirmar.setVisible(false);
            }

            // Adicionar os códigos de barbearia e agendamento às listas correspondentes
            CODCLIENTESPENDENTE.add(agendamento.getCodcliente());
            CODAGENDAMENTOSPENDENTE.add(agendamento.getCodagendamento());
        }

        // Ocultar os painéis de agendamento restantes (caso o número de agendamentosAbertos seja menor que 4)
        for (int i = agendamentosPendentes.size(); i < paineisAgendamento.length; i++) {
            paineisAgendamento[i].setVisible(false);
        }
    }
    
    public void listarExtrato(){
        ExtratoDAO extratoDao = new ExtratoDAO();
        List<Extrato> extrato = new ArrayList();
        
        LocalDate today = LocalDate.now();
        Date dataIni;
        Date dataFin;
        float valorT=0;
        
        switch (extratoOp) {
            case 1 -> {
                LocalDate dataInicio = today;
                LocalDate dataFim = today;
                dataIni = Date.valueOf(dataInicio);
                dataFin = Date.valueOf(dataFim);
                extrato = extratoDao.read(CODBARBEARIA, dataIni, dataFin);
            }
            case 2 -> {
                LocalDate dataInicio = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
                LocalDate dataFim = today.with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SUNDAY));
                dataIni = Date.valueOf(dataInicio);
                dataFin = Date.valueOf(dataFim);
                extrato = extratoDao.read(CODBARBEARIA, dataIni, dataFin);
            }
            case 3 -> {
                LocalDate dataInicio = today.with(TemporalAdjusters.firstDayOfMonth());
                LocalDate dataFim = today.with(TemporalAdjusters.lastDayOfMonth());
                dataIni = Date.valueOf(dataInicio);
                dataFin = Date.valueOf(dataFim);
                extrato = extratoDao.read(CODBARBEARIA, dataIni, dataFin);
            }
        }
        
        String[] colunas = {"Cliente", "Serviço", "Valor do Serviço", "Data", "Hora", "Valor Pago"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        for (Extrato e : extrato) {
            Object[] row = {
                e.getCliente(),
                e.getServico(),
                e.getValorServico(),
                e.getData(),
                e.getHora(),
                e.getValorPago()
            };
            tableModel.addRow(row);
            valorT=valorT+e.getValorPago();
        }
        jTableDiario.setModel(tableModel);
        labelTotal.setText("Total: R$"+valorT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        Centro = new javax.swing.JPanel();
        Esquerda = new javax.swing.JPanel();
        labelExtratos = new javax.swing.JLabel();
        labelOpcao = new javax.swing.JLabel();
        jScrollPaneDiario = new css.ScrollPaneWin11();
        jTableDiario = new css.TableDark();
        labelTotal = new javax.swing.JLabel();
        btnDiario = new javax.swing.JButton();
        btnSemanal = new javax.swing.JButton();
        btnMenal = new javax.swing.JButton();
        labelConfirmacao = new javax.swing.JLabel();
        jScrollPane2 = new css.ScrollPaneWin11();
        jPanel2 = new javax.swing.JPanel();
        Pendentes = new css.JPanelArredondadoBarbearias(20);
        pendentes = new javax.swing.JLabel();
        AgendamentoPen1 = new css.JPanelArredondadoAgendamentos(30);
        seta1 = new javax.swing.JLabel();
        txtCliente1 = new javax.swing.JLabel();
        txtHorario1 = new javax.swing.JLabel();
        txtServico1 = new javax.swing.JLabel();
        btnConfirmar1 = new javax.swing.JLabel();
        AgendamentoPen2 = new css.JPanelArredondadoAgendamentos(30);
        seta2 = new javax.swing.JLabel();
        txtCliente2 = new javax.swing.JLabel();
        txtHorario2 = new javax.swing.JLabel();
        txtServico2 = new javax.swing.JLabel();
        btnConfirmar2 = new javax.swing.JLabel();
        AgendamentoPen3 = new css.JPanelArredondadoAgendamentos(30);
        seta3 = new javax.swing.JLabel();
        txtCliente3 = new javax.swing.JLabel();
        txtHorario3 = new javax.swing.JLabel();
        txtServico3 = new javax.swing.JLabel();
        btnConfirmar3 = new javax.swing.JLabel();
        AgendamentoPen4 = new css.JPanelArredondadoAgendamentos(30);
        seta4 = new javax.swing.JLabel();
        txtCliente4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        txtServico4 = new javax.swing.JLabel();
        btnConfirmar4 = new javax.swing.JLabel();
        AgendamentoPen5 = new css.JPanelArredondadoAgendamentos(30);
        seta5 = new javax.swing.JLabel();
        txtCliente5 = new javax.swing.JLabel();
        txtHorario5 = new javax.swing.JLabel();
        txtServico5 = new javax.swing.JLabel();
        btnConfirmar5 = new javax.swing.JLabel();
        btnConfirmar6 = new javax.swing.JLabel();
        labelTotal1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        titulo.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Caixa");
        titulo.setBorder(new javax.swing.border.MatteBorder(null));

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

        javax.swing.GroupLayout CimaLayout = new javax.swing.GroupLayout(Cima);
        Cima.setLayout(CimaLayout);
        CimaLayout.setHorizontalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addComponent(icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        CimaLayout.setVerticalGroup(
            CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CimaLayout.createSequentialGroup()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(CimaLayout.createSequentialGroup()
                .addGroup(CimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon)
                    .addGroup(CimaLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Centro.setBackground(new java.awt.Color(255, 255, 255));
        Centro.setMaximumSize(new java.awt.Dimension(1920, 930));
        Centro.setMinimumSize(new java.awt.Dimension(1920, 930));

        Esquerda.setBackground(new java.awt.Color(102, 153, 255));

        labelExtratos.setFont(new java.awt.Font("Caladea", 1, 48)); // NOI18N
        labelExtratos.setForeground(new java.awt.Color(255, 255, 255));
        labelExtratos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExtratos.setText("Extratos");
        labelExtratos.setBorder(new javax.swing.border.MatteBorder(null));

        labelOpcao.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        labelOpcao.setForeground(new java.awt.Color(255, 255, 255));
        labelOpcao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOpcao.setText("Diario");
        labelOpcao.setBorder(new javax.swing.border.MatteBorder(null));

        jScrollPaneDiario.setBackground(new java.awt.Color(102, 153, 255));

        jTableDiario.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jTableDiario.setForeground(new java.awt.Color(255, 255, 255));
        jTableDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cliente", "Serviço", "Valor do Serviço", "Data", "Hora", "Valor Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneDiario.setViewportView(jTableDiario);
        if (jTableDiario.getColumnModel().getColumnCount() > 0) {
            jTableDiario.getColumnModel().getColumn(0).setResizable(false);
            jTableDiario.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableDiario.getColumnModel().getColumn(1).setResizable(false);
            jTableDiario.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTableDiario.getColumnModel().getColumn(2).setResizable(false);
            jTableDiario.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTableDiario.getColumnModel().getColumn(3).setResizable(false);
            jTableDiario.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTableDiario.getColumnModel().getColumn(4).setResizable(false);
            jTableDiario.getColumnModel().getColumn(4).setPreferredWidth(20);
            jTableDiario.getColumnModel().getColumn(5).setResizable(false);
            jTableDiario.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        labelTotal.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(255, 255, 255));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("Total: R$");
        labelTotal.setBorder(new javax.swing.border.MatteBorder(null));

        btnDiario.setBackground(new java.awt.Color(0, 51, 102));
        btnDiario.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        btnDiario.setForeground(new java.awt.Color(255, 255, 255));
        btnDiario.setText("Diario");
        btnDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiarioActionPerformed(evt);
            }
        });

        btnSemanal.setBackground(new java.awt.Color(0, 51, 102));
        btnSemanal.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        btnSemanal.setForeground(new java.awt.Color(255, 255, 255));
        btnSemanal.setText("Semanal");
        btnSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSemanalActionPerformed(evt);
            }
        });

        btnMenal.setBackground(new java.awt.Color(0, 51, 102));
        btnMenal.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        btnMenal.setForeground(new java.awt.Color(255, 255, 255));
        btnMenal.setText("Mensal");
        btnMenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EsquerdaLayout = new javax.swing.GroupLayout(Esquerda);
        Esquerda.setLayout(EsquerdaLayout);
        EsquerdaLayout.setHorizontalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EsquerdaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EsquerdaLayout.createSequentialGroup()
                        .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EsquerdaLayout.createSequentialGroup()
                                    .addGap(446, 446, 446)
                                    .addComponent(labelOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(btnDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnMenal, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(EsquerdaLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPaneDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(labelExtratos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        EsquerdaLayout.setVerticalGroup(
            EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EsquerdaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelExtratos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSemanal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMenal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jScrollPaneDiario.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        labelConfirmacao.setFont(new java.awt.Font("Caladea", 1, 48)); // NOI18N
        labelConfirmacao.setForeground(new java.awt.Color(0, 51, 102));
        labelConfirmacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelConfirmacao.setText("Agendamentos");
        labelConfirmacao.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        Pendentes.setBackground(new java.awt.Color(255, 153, 0));
        Pendentes.setMaximumSize(new java.awt.Dimension(500, 45));
        Pendentes.setMinimumSize(new java.awt.Dimension(500, 45));
        Pendentes.setPreferredSize(new java.awt.Dimension(550, 45));

        pendentes.setBackground(new java.awt.Color(30, 113, 218));
        pendentes.setFont(new java.awt.Font("Caladea", 1, 28)); // NOI18N
        pendentes.setForeground(new java.awt.Color(255, 255, 255));
        pendentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pendentes.setText("Pendentes");

        javax.swing.GroupLayout PendentesLayout = new javax.swing.GroupLayout(Pendentes);
        Pendentes.setLayout(PendentesLayout);
        PendentesLayout.setHorizontalGroup(
            PendentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pendentes, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        PendentesLayout.setVerticalGroup(
            PendentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pendentes, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        AgendamentoPen1.setBackground(new java.awt.Color(255, 153, 0));
        AgendamentoPen1.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoPen1.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen1.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta4.png"))); // NOI18N

        txtCliente1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente1.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente1.setToolTipText("");
        txtCliente1.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoPen1Layout = new javax.swing.GroupLayout(AgendamentoPen1);
        AgendamentoPen1.setLayout(AgendamentoPen1Layout);
        AgendamentoPen1Layout.setHorizontalGroup(
            AgendamentoPen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen1Layout.createSequentialGroup()
                .addComponent(seta1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoPen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addComponent(btnConfirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoPen1Layout.setVerticalGroup(
            AgendamentoPen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen1Layout.createSequentialGroup()
                .addGroup(AgendamentoPen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoPen1Layout.createSequentialGroup()
                        .addComponent(txtCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btnConfirmar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AgendamentoPen2.setBackground(new java.awt.Color(255, 153, 0));
        AgendamentoPen2.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoPen2.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen2.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen2.setPreferredSize(new java.awt.Dimension(400, 100));

        seta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta4.png"))); // NOI18N

        txtCliente2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente2.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente2.setToolTipText("");
        txtCliente2.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoPen2Layout = new javax.swing.GroupLayout(AgendamentoPen2);
        AgendamentoPen2.setLayout(AgendamentoPen2Layout);
        AgendamentoPen2Layout.setHorizontalGroup(
            AgendamentoPen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen2Layout.createSequentialGroup()
                .addComponent(seta2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoPen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addComponent(btnConfirmar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoPen2Layout.setVerticalGroup(
            AgendamentoPen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen2Layout.createSequentialGroup()
                .addGroup(AgendamentoPen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoPen2Layout.createSequentialGroup()
                        .addComponent(txtCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoPen3.setBackground(new java.awt.Color(255, 153, 0));
        AgendamentoPen3.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoPen3.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen3.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen3.setPreferredSize(new java.awt.Dimension(400, 100));

        seta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta4.png"))); // NOI18N

        txtCliente3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente3.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente3.setToolTipText("");
        txtCliente3.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoPen3Layout = new javax.swing.GroupLayout(AgendamentoPen3);
        AgendamentoPen3.setLayout(AgendamentoPen3Layout);
        AgendamentoPen3Layout.setHorizontalGroup(
            AgendamentoPen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen3Layout.createSequentialGroup()
                .addComponent(seta3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoPen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addComponent(btnConfirmar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoPen3Layout.setVerticalGroup(
            AgendamentoPen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen3Layout.createSequentialGroup()
                .addGroup(AgendamentoPen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoPen3Layout.createSequentialGroup()
                        .addComponent(txtCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(btnConfirmar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AgendamentoPen4.setBackground(new java.awt.Color(255, 153, 0));
        AgendamentoPen4.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoPen4.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen4.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen4.setPreferredSize(new java.awt.Dimension(400, 100));

        seta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta4.png"))); // NOI18N

        txtCliente4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente4.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente4.setToolTipText("");
        txtCliente4.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoPen4Layout = new javax.swing.GroupLayout(AgendamentoPen4);
        AgendamentoPen4.setLayout(AgendamentoPen4Layout);
        AgendamentoPen4Layout.setHorizontalGroup(
            AgendamentoPen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen4Layout.createSequentialGroup()
                .addComponent(seta4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoPen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addComponent(btnConfirmar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoPen4Layout.setVerticalGroup(
            AgendamentoPen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen4Layout.createSequentialGroup()
                .addGroup(AgendamentoPen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoPen4Layout.createSequentialGroup()
                        .addComponent(txtCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoPen5.setBackground(new java.awt.Color(255, 153, 0));
        AgendamentoPen5.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoPen5.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen5.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoPen5.setPreferredSize(new java.awt.Dimension(400, 100));

        seta5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta4.png"))); // NOI18N

        txtCliente5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente5.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente5.setToolTipText("");
        txtCliente5.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoPen5Layout = new javax.swing.GroupLayout(AgendamentoPen5);
        AgendamentoPen5.setLayout(AgendamentoPen5Layout);
        AgendamentoPen5Layout.setHorizontalGroup(
            AgendamentoPen5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen5Layout.createSequentialGroup()
                .addComponent(seta5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoPen5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(67, 67, 67)
                .addComponent(btnConfirmar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoPen5Layout.setVerticalGroup(
            AgendamentoPen5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoPen5Layout.createSequentialGroup()
                .addGroup(AgendamentoPen5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoPen5Layout.createSequentialGroup()
                        .addComponent(txtCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgendamentoPen5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AgendamentoPen1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Pendentes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoPen2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoPen3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoPen4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Pendentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(AgendamentoPen1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoPen2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoPen3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoPen4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoPen5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        btnConfirmar6.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfirmar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar6MouseClicked(evt);
            }
        });

        labelTotal1.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        labelTotal1.setForeground(new java.awt.Color(0, 51, 102));
        labelTotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal1.setText("Confirmar atendimento");
        labelTotal1.setBorder(new javax.swing.border.MatteBorder(null));
        labelTotal1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addComponent(Esquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelConfirmacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnConfirmar6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotal1)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Esquerda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelConfirmacao, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmar6)
                    .addComponent(labelTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Centro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnConfirmar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar1MouseClicked
        confirmarAtendimento(CODAGENDAMENTOSPENDENTE.get(0));
    }//GEN-LAST:event_btnConfirmar1MouseClicked

    private void btnConfirmar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar2MouseClicked
        confirmarAtendimento(CODAGENDAMENTOSPENDENTE.get(1));
    }//GEN-LAST:event_btnConfirmar2MouseClicked

    private void btnConfirmar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar3MouseClicked
        confirmarAtendimento(CODAGENDAMENTOSPENDENTE.get(2));
    }//GEN-LAST:event_btnConfirmar3MouseClicked

    private void btnConfirmar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar4MouseClicked
        confirmarAtendimento(CODAGENDAMENTOSPENDENTE.get(3));
    }//GEN-LAST:event_btnConfirmar4MouseClicked

    private void btnConfirmar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar5MouseClicked
        confirmarAtendimento(CODAGENDAMENTOSPENDENTE.get(4));
    }//GEN-LAST:event_btnConfirmar5MouseClicked

    private void btnDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiarioActionPerformed
        extratoOp=1;
        labelOpcao.setText("Diario");
        listarExtrato();
    }//GEN-LAST:event_btnDiarioActionPerformed

    private void btnSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSemanalActionPerformed
        extratoOp=2;
        labelOpcao.setText("Semanal");
        listarExtrato();
    }//GEN-LAST:event_btnSemanalActionPerformed

    private void btnMenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenalActionPerformed
        extratoOp=3;
        labelOpcao.setText("Mensal");
        listarExtrato();
    }//GEN-LAST:event_btnMenalActionPerformed

    private void btnConfirmar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmar6MouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaCaixa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgendamentoPen1;
    private javax.swing.JPanel AgendamentoPen2;
    private javax.swing.JPanel AgendamentoPen3;
    private javax.swing.JPanel AgendamentoPen4;
    private javax.swing.JPanel AgendamentoPen5;
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Esquerda;
    private javax.swing.JPanel Pendentes;
    private javax.swing.JLabel btnConfirmar1;
    private javax.swing.JLabel btnConfirmar2;
    private javax.swing.JLabel btnConfirmar3;
    private javax.swing.JLabel btnConfirmar4;
    private javax.swing.JLabel btnConfirmar5;
    private javax.swing.JLabel btnConfirmar6;
    private javax.swing.JButton btnDiario;
    private javax.swing.JButton btnMenal;
    private javax.swing.JButton btnSemanal;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneDiario;
    private javax.swing.JTable jTableDiario;
    private javax.swing.JLabel labelConfirmacao;
    private javax.swing.JLabel labelExtratos;
    private javax.swing.JLabel labelOpcao;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotal1;
    private javax.swing.JLabel pendentes;
    private javax.swing.JLabel seta1;
    private javax.swing.JLabel seta2;
    private javax.swing.JLabel seta3;
    private javax.swing.JLabel seta4;
    private javax.swing.JLabel seta5;
    private javax.swing.JLabel titulo;
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
