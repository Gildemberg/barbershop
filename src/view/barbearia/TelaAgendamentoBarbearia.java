package view.barbearia;

import dao.AgendamentoDAO;
import java.awt.Toolkit;
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
    ArrayList<Integer> CODCLIENTESABERTO = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOSABERTO = new ArrayList<>();
    List<Agendamento> agendamentosAbertos = new ArrayList();
    ArrayList<Integer> CODCLIENTESCANCELADO = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOSCANCELADO = new ArrayList<>();
    List<Agendamento> agendamentosCancelados = new ArrayList();
    ArrayList<Integer> CODCLIENTESCONCLUIDO = new ArrayList<>();
    ArrayList<Integer> CODAGENDAMENTOSCONCLUIDO = new ArrayList<>();
    List<Agendamento> agendamentosConcluidos = new ArrayList();
    
    //FORMATOS
    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
    
    //INSTANCIAS
    AgendamentoDAO agendamentoDao = new AgendamentoDAO();
    
    public TelaAgendamentoBarbearia() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
    }
    
    public void receberCodUsr(int CODBARBEARIA, String NOMEBARBEARIA){//receber o cod EMPRESA
        this.CODBARBEARIA = CODBARBEARIA;
        consultarAgendamentosEmAberto();
        consultarAgendamentosCancelados();
        consultarAgendamentosRealizados();
    }
    
    public void confirmarAgendamento(int CODAGENDAMENTO){
        if(JOptionPane.showConfirmDialog(this, "Confirma a conclusão do serviço?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            agendamentoDao.confirmarAgendamentoCliente(CODAGENDAMENTO, 3, "Serviço Realizado");
            consultarAgendamentosEmAberto();
            consultarAgendamentosCancelados();
            consultarAgendamentosRealizados();
        }
    }
    
    public void consultarAgendamentosEmAberto(){       
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        
        agendamentosAbertos = agendDAO.consultarAgendamentosAbertoBarbearia(CODBARBEARIA, 1);
        

        JPanel[] paineisAgendamento = {AgendamentoAbe1, AgendamentoAbe2, AgendamentoAbe3, AgendamentoAbe4, AgendamentoAbe5};
        JLabel[] labelsCliente = {txtCliente1, txtCliente2, txtCliente3, txtCliente4, txtCliente5};
        JLabel[] labelsHorario = {txtHorario1, txtHorario2, txtHorario3, txtHorario4, txtHorario5};
        JLabel[] labelsServico = {txtServico1, txtServico2, txtServico3, txtServico4, txtServico5};
        JLabel[] labelsConfirmar = {btnConfirmar1, btnConfirmar2, btnConfirmar3, btnConfirmar4, btnConfirmar5};

        // Loop pelos agendamentosAbertos e configuração dos componentes
        for (int i = 0; i < agendamentosAbertos.size() && i < paineisAgendamento.length; i++) {
            Agendamento agendamento = agendamentosAbertos.get(i);
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
            CODCLIENTESABERTO.add(agendamento.getCodcliente());
            CODAGENDAMENTOSABERTO.add(agendamento.getCodagendamento());
        }

        // Ocultar os painéis de agendamento restantes (caso o número de agendamentosAbertos seja menor que 4)
        for (int i = agendamentosAbertos.size(); i < paineisAgendamento.length; i++) {
            paineisAgendamento[i].setVisible(false);
        }
    }
    
    public void consultarAgendamentosCancelados(){
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        
        agendamentosCancelados = agendDAO.consultarAgendamentosBarbearia(CODBARBEARIA, 2);
        

        JPanel[] paineisAgendamentoCancelados = {AgendamentoCan1, AgendamentoCan2, AgendamentoCan3, AgendamentoCan4, AgendamentoCan5};
        JLabel[] labelsCliente = {txtClienteCan1, txtClienteCan2, txtClienteCan3, txtClienteCan4, txtClienteCan5};
        JLabel[] labelsHorario = {txtHorarioCan1, txtHorarioCan2, txtHorarioCan3, txtHorarioCan4, txtHorarioCan5};
        JLabel[] labelsServico = {txtServicoCan1, txtServicoCan2, txtServicoCan3, txtServicoCan4, txtServicoCan5};

        // Loop pelos agendamentosAbertos e configuração dos componentes
        for (int i = 0; i < agendamentosCancelados.size() && i < paineisAgendamentoCancelados.length; i++) {
            Agendamento agendamento = agendamentosCancelados.get(i);
            JPanel painelAgendamentoCancelado = paineisAgendamentoCancelados[i];
            JLabel labelCliente = labelsCliente[i];
            JLabel labelHorario = labelsHorario[i];
            JLabel labelServico = labelsServico[i];

            // Exibir o painel de agendamento correspondente
            painelAgendamentoCancelado.setVisible(true);

            // Configurar os textos nos labels
            labelCliente.setText(agendamento.getNomecliente());
            labelHorario.setText(dataFormat.format(agendamento.getData()) +" às "+ horaFormat.format(agendamento.getHora()) + "h");
            labelServico.setText("Serviço: "+agendamento.getNomeservico());

            // Adicionar os códigos de barbearia e agendamento às listas correspondentes
            CODCLIENTESCANCELADO.add(agendamento.getCodcliente());
            CODAGENDAMENTOSCANCELADO.add(agendamento.getCodagendamento());
        }

        // Ocultar os painéis de agendamento restantes (caso o número de agendamentosAbertos seja menor que 4)
        for (int i = agendamentosCancelados.size(); i < paineisAgendamentoCancelados.length; i++) {
            paineisAgendamentoCancelados[i].setVisible(false);
        }
    }
    
    public void consultarAgendamentosRealizados(){
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        
        agendamentosConcluidos = agendDAO.consultarAgendamentosBarbearia(CODBARBEARIA, 3);
        

        JPanel[] paineisAgendamentoConcluidos = {AgendamentoCon1, AgendamentoCon2, AgendamentoCon3, AgendamentoCon4, AgendamentoCon5};
        JLabel[] labelsCliente = {txtClienteCon1, txtClienteCon2, txtClienteCon3, txtClienteCon4, txtClienteCon5};
        JLabel[] labelsHorario = {txtHorarioCon1, txtHorarioCon2, txtHorarioCon3, txtHorarioCon4, txtHorarioCon5};
        JLabel[] labelsServico = {txtServicoCon1, txtServicoCon2, txtServicoCon3, txtServicoCon4, txtServicoCon5};

        // Loop pelos agendamentosAbertos e configuração dos componentes
        for (int i = 0; i < agendamentosConcluidos.size() && i < paineisAgendamentoConcluidos.length; i++) {
            Agendamento agendamento = agendamentosConcluidos.get(i);
            JPanel painelAgendamentoCancelado = paineisAgendamentoConcluidos[i];
            JLabel labelCliente = labelsCliente[i];
            JLabel labelHorario = labelsHorario[i];
            JLabel labelServico = labelsServico[i];

            // Exibir o painel de agendamento correspondente
            painelAgendamentoCancelado.setVisible(true);

            // Configurar os textos nos labels
            labelCliente.setText(agendamento.getNomecliente());
            labelHorario.setText(dataFormat.format(agendamento.getData()) +" às "+ horaFormat.format(agendamento.getHora()) + "h");
            labelServico.setText("Serviço: "+agendamento.getNomeservico());

            // Adicionar os códigos de barbearia e agendamento às listas correspondentes
            CODCLIENTESCONCLUIDO.add(agendamento.getCodcliente());
            CODAGENDAMENTOSCONCLUIDO.add(agendamento.getCodagendamento());
        }

        // Ocultar os painéis de agendamento restantes (caso o número de agendamentosAbertos seja menor que 4)
        for (int i = agendamentosConcluidos.size(); i < paineisAgendamentoConcluidos.length; i++) {
            paineisAgendamentoConcluidos[i].setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cima = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        Centro = new javax.swing.JPanel();
        EmAberto = new css.JPanelArredondadoBarbearias(20);
        emaberto = new javax.swing.JLabel();
        AgendamentoAbe1 = new css.JPanelArredondadoAgendamentos(30);
        seta1 = new javax.swing.JLabel();
        txtCliente1 = new javax.swing.JLabel();
        txtHorario1 = new javax.swing.JLabel();
        txtServico1 = new javax.swing.JLabel();
        btnConfirmar1 = new javax.swing.JLabel();
        AgendamentoAbe2 = new css.JPanelArredondadoAgendamentos(30);
        seta2 = new javax.swing.JLabel();
        txtCliente2 = new javax.swing.JLabel();
        txtHorario2 = new javax.swing.JLabel();
        txtServico2 = new javax.swing.JLabel();
        btnConfirmar2 = new javax.swing.JLabel();
        AgendamentoAbe3 = new css.JPanelArredondadoAgendamentos(30);
        seta3 = new javax.swing.JLabel();
        txtCliente3 = new javax.swing.JLabel();
        txtHorario3 = new javax.swing.JLabel();
        txtServico3 = new javax.swing.JLabel();
        btnConfirmar3 = new javax.swing.JLabel();
        AgendamentoAbe4 = new css.JPanelArredondadoAgendamentos(30);
        seta4 = new javax.swing.JLabel();
        txtCliente4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        txtServico4 = new javax.swing.JLabel();
        btnConfirmar4 = new javax.swing.JLabel();
        AgendamentoAbe5 = new css.JPanelArredondadoAgendamentos(30);
        seta5 = new javax.swing.JLabel();
        txtCliente5 = new javax.swing.JLabel();
        txtHorario5 = new javax.swing.JLabel();
        txtServico5 = new javax.swing.JLabel();
        btnConfirmar5 = new javax.swing.JLabel();
        Cancelado = new css.JPanelArredondadoBarbearias(20);
        cancelado = new javax.swing.JLabel();
        AgendamentoCan1 = new css.JPanelArredondadoAgendamentos(30);
        seta6 = new javax.swing.JLabel();
        txtClienteCan1 = new javax.swing.JLabel();
        txtHorarioCan1 = new javax.swing.JLabel();
        txtServicoCan1 = new javax.swing.JLabel();
        AgendamentoCan3 = new css.JPanelArredondadoAgendamentos(30);
        seta7 = new javax.swing.JLabel();
        txtClienteCan3 = new javax.swing.JLabel();
        txtHorarioCan3 = new javax.swing.JLabel();
        txtServicoCan3 = new javax.swing.JLabel();
        AgendamentoCan2 = new css.JPanelArredondadoAgendamentos(30);
        seta8 = new javax.swing.JLabel();
        txtClienteCan2 = new javax.swing.JLabel();
        txtHorarioCan2 = new javax.swing.JLabel();
        txtServicoCan2 = new javax.swing.JLabel();
        AgendamentoCan4 = new css.JPanelArredondadoAgendamentos(30);
        seta9 = new javax.swing.JLabel();
        txtClienteCan4 = new javax.swing.JLabel();
        txtHorarioCan4 = new javax.swing.JLabel();
        txtServicoCan4 = new javax.swing.JLabel();
        AgendamentoCan5 = new css.JPanelArredondadoAgendamentos(30);
        seta10 = new javax.swing.JLabel();
        txtClienteCan5 = new javax.swing.JLabel();
        txtHorarioCan5 = new javax.swing.JLabel();
        txtServicoCan5 = new javax.swing.JLabel();
        Concluido = new css.JPanelArredondadoBarbearias(20);
        concluido = new javax.swing.JLabel();
        AgendamentoCon1 = new css.JPanelArredondadoAgendamentos(30);
        seta11 = new javax.swing.JLabel();
        txtClienteCon1 = new javax.swing.JLabel();
        txtHorarioCon1 = new javax.swing.JLabel();
        txtServicoCon1 = new javax.swing.JLabel();
        AgendamentoCon4 = new css.JPanelArredondadoAgendamentos(30);
        seta12 = new javax.swing.JLabel();
        txtClienteCon4 = new javax.swing.JLabel();
        txtHorarioCon4 = new javax.swing.JLabel();
        txtServicoCon4 = new javax.swing.JLabel();
        AgendamentoCon2 = new css.JPanelArredondadoAgendamentos(30);
        seta13 = new javax.swing.JLabel();
        txtClienteCon2 = new javax.swing.JLabel();
        txtHorarioCon2 = new javax.swing.JLabel();
        txtServicoCon2 = new javax.swing.JLabel();
        AgendamentoCon5 = new css.JPanelArredondadoAgendamentos(30);
        seta14 = new javax.swing.JLabel();
        txtClienteCon5 = new javax.swing.JLabel();
        txtHorarioCon5 = new javax.swing.JLabel();
        txtServicoCon5 = new javax.swing.JLabel();
        AgendamentoCon3 = new css.JPanelArredondadoAgendamentos(30);
        seta15 = new javax.swing.JLabel();
        txtClienteCon3 = new javax.swing.JLabel();
        txtHorarioCon3 = new javax.swing.JLabel();
        txtServicoCon3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        emaberto1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal Barbearia");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        titulo.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Consultar Agenda");
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
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        Centro.setPreferredSize(new java.awt.Dimension(1920, 930));

        EmAberto.setBackground(new java.awt.Color(30, 113, 218));
        EmAberto.setMaximumSize(new java.awt.Dimension(500, 45));
        EmAberto.setMinimumSize(new java.awt.Dimension(500, 45));
        EmAberto.setPreferredSize(new java.awt.Dimension(550, 45));

        emaberto.setBackground(new java.awt.Color(30, 113, 218));
        emaberto.setFont(new java.awt.Font("Caladea", 1, 28)); // NOI18N
        emaberto.setForeground(new java.awt.Color(255, 255, 255));
        emaberto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emaberto.setText("Em Aberto");

        javax.swing.GroupLayout EmAbertoLayout = new javax.swing.GroupLayout(EmAberto);
        EmAberto.setLayout(EmAbertoLayout);
        EmAbertoLayout.setHorizontalGroup(
            EmAbertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emaberto, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        EmAbertoLayout.setVerticalGroup(
            EmAbertoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emaberto, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        AgendamentoAbe1.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe1.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe1.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe1.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtCliente1.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente1.setToolTipText("");
        txtCliente1.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorario1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoAbe1Layout = new javax.swing.GroupLayout(AgendamentoAbe1);
        AgendamentoAbe1.setLayout(AgendamentoAbe1Layout);
        AgendamentoAbe1Layout.setHorizontalGroup(
            AgendamentoAbe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe1Layout.createSequentialGroup()
                .addComponent(seta1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addComponent(btnConfirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoAbe1Layout.setVerticalGroup(
            AgendamentoAbe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe1Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AgendamentoAbe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AgendamentoAbe1Layout.createSequentialGroup()
                                .addComponent(txtCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe2.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe2.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe2.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe2.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe2.setPreferredSize(new java.awt.Dimension(400, 100));

        seta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtCliente2.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente2.setToolTipText("");
        txtCliente2.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorario2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario2.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoAbe2Layout = new javax.swing.GroupLayout(AgendamentoAbe2);
        AgendamentoAbe2.setLayout(AgendamentoAbe2Layout);
        AgendamentoAbe2Layout.setHorizontalGroup(
            AgendamentoAbe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe2Layout.createSequentialGroup()
                .addComponent(seta2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 67, Short.MAX_VALUE)
                .addComponent(btnConfirmar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoAbe2Layout.setVerticalGroup(
            AgendamentoAbe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe2Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AgendamentoAbe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AgendamentoAbe2Layout.createSequentialGroup()
                                .addComponent(txtCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe3.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe3.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe3.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe3.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe3.setPreferredSize(new java.awt.Dimension(400, 100));

        seta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtCliente3.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente3.setToolTipText("");
        txtCliente3.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorario3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario3.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoAbe3Layout = new javax.swing.GroupLayout(AgendamentoAbe3);
        AgendamentoAbe3.setLayout(AgendamentoAbe3Layout);
        AgendamentoAbe3Layout.setHorizontalGroup(
            AgendamentoAbe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe3Layout.createSequentialGroup()
                .addComponent(seta3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 67, Short.MAX_VALUE)
                .addComponent(btnConfirmar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoAbe3Layout.setVerticalGroup(
            AgendamentoAbe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe3Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AgendamentoAbe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AgendamentoAbe3Layout.createSequentialGroup()
                                .addComponent(txtCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe4.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe4.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe4.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe4.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe4.setPreferredSize(new java.awt.Dimension(400, 100));

        seta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtCliente4.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente4.setToolTipText("");
        txtCliente4.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorario4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario4.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoAbe4Layout = new javax.swing.GroupLayout(AgendamentoAbe4);
        AgendamentoAbe4.setLayout(AgendamentoAbe4Layout);
        AgendamentoAbe4Layout.setHorizontalGroup(
            AgendamentoAbe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe4Layout.createSequentialGroup()
                .addComponent(seta4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 67, Short.MAX_VALUE)
                .addComponent(btnConfirmar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoAbe4Layout.setVerticalGroup(
            AgendamentoAbe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe4Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AgendamentoAbe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AgendamentoAbe4Layout.createSequentialGroup()
                                .addComponent(txtCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe5.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe5.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe5.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe5.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe5.setPreferredSize(new java.awt.Dimension(400, 100));

        seta5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtCliente5.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente5.setToolTipText("");
        txtCliente5.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorario5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout AgendamentoAbe5Layout = new javax.swing.GroupLayout(AgendamentoAbe5);
        AgendamentoAbe5.setLayout(AgendamentoAbe5Layout);
        AgendamentoAbe5Layout.setHorizontalGroup(
            AgendamentoAbe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe5Layout.createSequentialGroup()
                .addComponent(seta5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 67, Short.MAX_VALUE)
                .addComponent(btnConfirmar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AgendamentoAbe5Layout.setVerticalGroup(
            AgendamentoAbe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe5Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AgendamentoAbe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirmar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AgendamentoAbe5Layout.createSequentialGroup()
                                .addComponent(txtCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHorario5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(seta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Cancelado.setBackground(new java.awt.Color(153, 0, 0));
        Cancelado.setMaximumSize(new java.awt.Dimension(500, 45));
        Cancelado.setMinimumSize(new java.awt.Dimension(500, 45));
        Cancelado.setPreferredSize(new java.awt.Dimension(550, 45));

        cancelado.setBackground(new java.awt.Color(255, 102, 102));
        cancelado.setFont(new java.awt.Font("Caladea", 1, 28)); // NOI18N
        cancelado.setForeground(new java.awt.Color(255, 255, 255));
        cancelado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelado.setText("Cancelados");

        javax.swing.GroupLayout CanceladoLayout = new javax.swing.GroupLayout(Cancelado);
        Cancelado.setLayout(CanceladoLayout);
        CanceladoLayout.setHorizontalGroup(
            CanceladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelado, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        CanceladoLayout.setVerticalGroup(
            CanceladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelado, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        AgendamentoCan1.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan1.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan1.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan1.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCan1.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan1.setToolTipText("");
        txtClienteCan1.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCan1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCan1.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan1.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan1.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan1Layout = new javax.swing.GroupLayout(AgendamentoCan1);
        AgendamentoCan1.setLayout(AgendamentoCan1Layout);
        AgendamentoCan1Layout.setHorizontalGroup(
            AgendamentoCan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan1Layout.createSequentialGroup()
                .addComponent(seta6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan1Layout.setVerticalGroup(
            AgendamentoCan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan1Layout.createSequentialGroup()
                .addGroup(AgendamentoCan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan3.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan3.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan3.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan3.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan3.setPreferredSize(new java.awt.Dimension(400, 100));

        seta7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCan3.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan3.setToolTipText("");
        txtClienteCan3.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCan3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan3.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCan3.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan3.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan3.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan3Layout = new javax.swing.GroupLayout(AgendamentoCan3);
        AgendamentoCan3.setLayout(AgendamentoCan3Layout);
        AgendamentoCan3Layout.setHorizontalGroup(
            AgendamentoCan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan3Layout.createSequentialGroup()
                .addComponent(seta7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan3Layout.setVerticalGroup(
            AgendamentoCan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan3Layout.createSequentialGroup()
                .addGroup(AgendamentoCan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan2.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan2.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan2.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan2.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan2.setPreferredSize(new java.awt.Dimension(400, 100));

        seta8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCan2.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan2.setToolTipText("");
        txtClienteCan2.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCan2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan2.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCan2.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan2.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan2.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan2Layout = new javax.swing.GroupLayout(AgendamentoCan2);
        AgendamentoCan2.setLayout(AgendamentoCan2Layout);
        AgendamentoCan2Layout.setHorizontalGroup(
            AgendamentoCan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan2Layout.createSequentialGroup()
                .addComponent(seta8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan2Layout.setVerticalGroup(
            AgendamentoCan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan2Layout.createSequentialGroup()
                .addGroup(AgendamentoCan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan4.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan4.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan4.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan4.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan4.setPreferredSize(new java.awt.Dimension(400, 100));

        seta9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCan4.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan4.setToolTipText("");
        txtClienteCan4.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCan4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan4.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCan4.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan4.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan4.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan4Layout = new javax.swing.GroupLayout(AgendamentoCan4);
        AgendamentoCan4.setLayout(AgendamentoCan4Layout);
        AgendamentoCan4Layout.setHorizontalGroup(
            AgendamentoCan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan4Layout.createSequentialGroup()
                .addComponent(seta9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan4Layout.setVerticalGroup(
            AgendamentoCan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan4Layout.createSequentialGroup()
                .addGroup(AgendamentoCan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan5.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan5.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan5.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan5.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan5.setPreferredSize(new java.awt.Dimension(400, 100));

        seta10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCan5.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan5.setToolTipText("");
        txtClienteCan5.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCan5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCan5.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan5.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan5.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan5Layout = new javax.swing.GroupLayout(AgendamentoCan5);
        AgendamentoCan5.setLayout(AgendamentoCan5Layout);
        AgendamentoCan5Layout.setHorizontalGroup(
            AgendamentoCan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan5Layout.createSequentialGroup()
                .addComponent(seta10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan5Layout.setVerticalGroup(
            AgendamentoCan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan5Layout.createSequentialGroup()
                .addGroup(AgendamentoCan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Concluido.setBackground(new java.awt.Color(0, 102, 0));
        Concluido.setMaximumSize(new java.awt.Dimension(500, 45));
        Concluido.setMinimumSize(new java.awt.Dimension(500, 45));
        Concluido.setPreferredSize(new java.awt.Dimension(550, 45));

        concluido.setBackground(new java.awt.Color(30, 113, 218));
        concluido.setFont(new java.awt.Font("Caladea", 1, 28)); // NOI18N
        concluido.setForeground(new java.awt.Color(255, 255, 255));
        concluido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        concluido.setText("Realizados");

        javax.swing.GroupLayout ConcluidoLayout = new javax.swing.GroupLayout(Concluido);
        Concluido.setLayout(ConcluidoLayout);
        ConcluidoLayout.setHorizontalGroup(
            ConcluidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(concluido, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        ConcluidoLayout.setVerticalGroup(
            ConcluidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(concluido, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        AgendamentoCon1.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon1.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon1.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon1.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCon1.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon1.setToolTipText("");
        txtClienteCon1.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCon1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon1.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCon1.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon1.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon1.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon1Layout = new javax.swing.GroupLayout(AgendamentoCon1);
        AgendamentoCon1.setLayout(AgendamentoCon1Layout);
        AgendamentoCon1Layout.setHorizontalGroup(
            AgendamentoCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon1Layout.createSequentialGroup()
                .addComponent(seta11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon1Layout.setVerticalGroup(
            AgendamentoCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon1Layout.createSequentialGroup()
                .addGroup(AgendamentoCon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon4.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon4.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon4.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon4.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon4.setPreferredSize(new java.awt.Dimension(400, 100));

        seta12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCon4.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon4.setToolTipText("");
        txtClienteCon4.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCon4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon4.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon4.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCon4.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon4.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon4.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon4Layout = new javax.swing.GroupLayout(AgendamentoCon4);
        AgendamentoCon4.setLayout(AgendamentoCon4Layout);
        AgendamentoCon4Layout.setHorizontalGroup(
            AgendamentoCon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon4Layout.createSequentialGroup()
                .addComponent(seta12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon4Layout.setVerticalGroup(
            AgendamentoCon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon4Layout.createSequentialGroup()
                .addGroup(AgendamentoCon4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon2.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon2.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon2.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon2.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon2.setPreferredSize(new java.awt.Dimension(400, 100));

        seta13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCon2.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon2.setToolTipText("");
        txtClienteCon2.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCon2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon2.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon2.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCon2.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon2.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon2.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon2Layout = new javax.swing.GroupLayout(AgendamentoCon2);
        AgendamentoCon2.setLayout(AgendamentoCon2Layout);
        AgendamentoCon2Layout.setHorizontalGroup(
            AgendamentoCon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon2Layout.createSequentialGroup()
                .addComponent(seta13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon2Layout.setVerticalGroup(
            AgendamentoCon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon2Layout.createSequentialGroup()
                .addGroup(AgendamentoCon2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon5.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon5.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon5.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon5.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon5.setPreferredSize(new java.awt.Dimension(400, 100));

        seta14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCon5.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon5.setToolTipText("");
        txtClienteCon5.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCon5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon5.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCon5.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon5.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon5.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon5Layout = new javax.swing.GroupLayout(AgendamentoCon5);
        AgendamentoCon5.setLayout(AgendamentoCon5Layout);
        AgendamentoCon5Layout.setHorizontalGroup(
            AgendamentoCon5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon5Layout.createSequentialGroup()
                .addComponent(seta14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon5Layout.setVerticalGroup(
            AgendamentoCon5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon5Layout.createSequentialGroup()
                .addGroup(AgendamentoCon5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon3.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon3.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon3.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon3.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon3.setPreferredSize(new java.awt.Dimension(400, 100));

        seta15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtClienteCon3.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon3.setToolTipText("");
        txtClienteCon3.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtHorarioCon3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon3.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon3.setFont(new java.awt.Font("Caladea", 0, 18)); // NOI18N
        txtServicoCon3.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon3.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon3.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon3Layout = new javax.swing.GroupLayout(AgendamentoCon3);
        AgendamentoCon3.setLayout(AgendamentoCon3Layout);
        AgendamentoCon3Layout.setHorizontalGroup(
            AgendamentoCon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon3Layout.createSequentialGroup()
                .addComponent(seta15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon3Layout.setVerticalGroup(
            AgendamentoCon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon3Layout.createSequentialGroup()
                .addGroup(AgendamentoCon3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtClienteCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        emaberto1.setBackground(new java.awt.Color(30, 113, 218));
        emaberto1.setFont(new java.awt.Font("Caladea", 1, 48)); // NOI18N
        emaberto1.setForeground(new java.awt.Color(0, 0, 0));
        emaberto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emaberto1.setText("Agendamentos");

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgendamentoAbe5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AgendamentoAbe1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EmAberto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoAbe2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoAbe3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoAbe4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(72, 72, 72)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancelado, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AgendamentoCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Concluido, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AgendamentoCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AgendamentoCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
            .addGroup(CentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emaberto1, javax.swing.GroupLayout.DEFAULT_SIZE, 1908, Short.MAX_VALUE)
                .addContainerGap())
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(emaberto1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(EmAberto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cancelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Concluido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(AgendamentoAbe1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoAbe2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoAbe3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoAbe4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoAbe5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(AgendamentoCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(AgendamentoCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AgendamentoCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar1MouseClicked
        confirmarAgendamento(CODAGENDAMENTOSABERTO.get(0));
    }//GEN-LAST:event_btnConfirmar1MouseClicked

    private void btnConfirmar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar2MouseClicked
        confirmarAgendamento(CODAGENDAMENTOSABERTO.get(1));
    }//GEN-LAST:event_btnConfirmar2MouseClicked

    private void btnConfirmar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar3MouseClicked
        confirmarAgendamento(CODAGENDAMENTOSABERTO.get(2));
    }//GEN-LAST:event_btnConfirmar3MouseClicked

    private void btnConfirmar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar4MouseClicked
        confirmarAgendamento(CODAGENDAMENTOSABERTO.get(3));
    }//GEN-LAST:event_btnConfirmar4MouseClicked

    private void btnConfirmar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar5MouseClicked
        confirmarAgendamento(CODAGENDAMENTOSABERTO.get(4));
    }//GEN-LAST:event_btnConfirmar5MouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

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
    private javax.swing.JPanel AgendamentoAbe1;
    private javax.swing.JPanel AgendamentoAbe2;
    private javax.swing.JPanel AgendamentoAbe3;
    private javax.swing.JPanel AgendamentoAbe4;
    private javax.swing.JPanel AgendamentoAbe5;
    private javax.swing.JPanel AgendamentoCan1;
    private javax.swing.JPanel AgendamentoCan2;
    private javax.swing.JPanel AgendamentoCan3;
    private javax.swing.JPanel AgendamentoCan4;
    private javax.swing.JPanel AgendamentoCan5;
    private javax.swing.JPanel AgendamentoCon1;
    private javax.swing.JPanel AgendamentoCon2;
    private javax.swing.JPanel AgendamentoCon3;
    private javax.swing.JPanel AgendamentoCon4;
    private javax.swing.JPanel AgendamentoCon5;
    private javax.swing.JPanel Cancelado;
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Concluido;
    private javax.swing.JPanel EmAberto;
    private javax.swing.JLabel btnConfirmar1;
    private javax.swing.JLabel btnConfirmar2;
    private javax.swing.JLabel btnConfirmar3;
    private javax.swing.JLabel btnConfirmar4;
    private javax.swing.JLabel btnConfirmar5;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel cancelado;
    private javax.swing.JLabel concluido;
    private javax.swing.JLabel emaberto;
    private javax.swing.JLabel emaberto1;
    private javax.swing.JLabel icon;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel seta1;
    private javax.swing.JLabel seta10;
    private javax.swing.JLabel seta11;
    private javax.swing.JLabel seta12;
    private javax.swing.JLabel seta13;
    private javax.swing.JLabel seta14;
    private javax.swing.JLabel seta15;
    private javax.swing.JLabel seta2;
    private javax.swing.JLabel seta3;
    private javax.swing.JLabel seta4;
    private javax.swing.JLabel seta5;
    private javax.swing.JLabel seta6;
    private javax.swing.JLabel seta7;
    private javax.swing.JLabel seta8;
    private javax.swing.JLabel seta9;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCliente1;
    private javax.swing.JLabel txtCliente2;
    private javax.swing.JLabel txtCliente3;
    private javax.swing.JLabel txtCliente4;
    private javax.swing.JLabel txtCliente5;
    private javax.swing.JLabel txtClienteCan1;
    private javax.swing.JLabel txtClienteCan2;
    private javax.swing.JLabel txtClienteCan3;
    private javax.swing.JLabel txtClienteCan4;
    private javax.swing.JLabel txtClienteCan5;
    private javax.swing.JLabel txtClienteCon1;
    private javax.swing.JLabel txtClienteCon2;
    private javax.swing.JLabel txtClienteCon3;
    private javax.swing.JLabel txtClienteCon4;
    private javax.swing.JLabel txtClienteCon5;
    private javax.swing.JLabel txtHorario1;
    private javax.swing.JLabel txtHorario2;
    private javax.swing.JLabel txtHorario3;
    private javax.swing.JLabel txtHorario4;
    private javax.swing.JLabel txtHorario5;
    private javax.swing.JLabel txtHorarioCan1;
    private javax.swing.JLabel txtHorarioCan2;
    private javax.swing.JLabel txtHorarioCan3;
    private javax.swing.JLabel txtHorarioCan4;
    private javax.swing.JLabel txtHorarioCan5;
    private javax.swing.JLabel txtHorarioCon1;
    private javax.swing.JLabel txtHorarioCon2;
    private javax.swing.JLabel txtHorarioCon3;
    private javax.swing.JLabel txtHorarioCon4;
    private javax.swing.JLabel txtHorarioCon5;
    private javax.swing.JLabel txtServico1;
    private javax.swing.JLabel txtServico2;
    private javax.swing.JLabel txtServico3;
    private javax.swing.JLabel txtServico4;
    private javax.swing.JLabel txtServico5;
    private javax.swing.JLabel txtServicoCan1;
    private javax.swing.JLabel txtServicoCan2;
    private javax.swing.JLabel txtServicoCan3;
    private javax.swing.JLabel txtServicoCan4;
    private javax.swing.JLabel txtServicoCan5;
    private javax.swing.JLabel txtServicoCon1;
    private javax.swing.JLabel txtServicoCon2;
    private javax.swing.JLabel txtServicoCon3;
    private javax.swing.JLabel txtServicoCon4;
    private javax.swing.JLabel txtServicoCon5;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
