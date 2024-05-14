package view.barbearia;

import dao.AgendamentoDAO;
import java.awt.Color;
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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Agendamento;

public class TelaAgendamentos extends javax.swing.JFrame {
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
    
    public TelaAgendamentos() {
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
        

        JPanel[] paineisAgendamento = {AgendamentoAbe1, AgendamentoAbe2, AgendamentoAbe3, AgendamentoAbe4, AgendamentoAbe5, AgendamentoAbe6, AgendamentoAbe7, AgendamentoAbe8, AgendamentoAbe9, AgendamentoAbe10};
        JLabel[] labelsCliente = {txtCliente1, txtCliente2, txtCliente3, txtCliente4, txtCliente5, txtCliente6, txtCliente7, txtCliente8, txtCliente9, txtCliente10};
        JLabel[] labelsHorario = {txtHorario1, txtHorario2, txtHorario3, txtHorario4, txtHorario5, txtHorario6, txtHorario7, txtHorario8, txtHorario9, txtHorario10};
        JLabel[] labelsServico = {txtServico1, txtServico2, txtServico3, txtServico4, txtServico5, txtServico6, txtServico7, txtServico8, txtServico9, txtServico10};

        // Loop pelos agendamentosAbertos e configuração dos componentes
        for (int i = 0; i < agendamentosAbertos.size() && i < paineisAgendamento.length; i++) {
            Agendamento agendamento = agendamentosAbertos.get(i);
            JPanel painelAgendamento = paineisAgendamento[i];
            JLabel labelCliente = labelsCliente[i];
            JLabel labelHorario = labelsHorario[i];
            JLabel labelServico = labelsServico[i];

            // Exibir o painel de agendamento correspondente
            painelAgendamento.setVisible(true);

            // Configurar os textos nos labels
            labelCliente.setText(agendamento.getNomecliente());
            labelHorario.setText(dataFormat.format(agendamento.getData()) +" às "+ horaFormat.format(agendamento.getHora()) + "h");
            labelServico.setText("Serviço: "+agendamento.getNomeservico());
            

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
        

        JPanel[] paineisAgendamentoCancelados = {AgendamentoCan1, AgendamentoCan2, AgendamentoCan3, AgendamentoCan4, AgendamentoCan5, AgendamentoCan6, AgendamentoCan7, AgendamentoCan8, AgendamentoCan9, AgendamentoCan10};
        JLabel[] labelsCliente = {txtClienteCan1, txtClienteCan2, txtClienteCan3, txtClienteCan4, txtClienteCan5, txtClienteCan6, txtClienteCan7, txtClienteCan8, txtClienteCan9, txtClienteCan10};
        JLabel[] labelsHorario = {txtHorarioCan1, txtHorarioCan2, txtHorarioCan3, txtHorarioCan4, txtHorarioCan5, txtHorarioCan6, txtHorarioCan7, txtHorarioCan8, txtHorarioCan9, txtHorarioCan10};
        JLabel[] labelsServico = {txtServicoCan1, txtServicoCan2, txtServicoCan3, txtServicoCan4, txtServicoCan5, txtServicoCan6, txtServicoCan7, txtServicoCan8, txtServicoCan9, txtServicoCan10};

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
        

        JPanel[] paineisAgendamentoConcluidos = {AgendamentoCon1, AgendamentoCon2, AgendamentoCon3, AgendamentoCon4, AgendamentoCon5, AgendamentoCon6, AgendamentoCon7, AgendamentoCon8, AgendamentoCon9, AgendamentoCon10};
        JLabel[] labelsCliente = {txtClienteCon1, txtClienteCon2, txtClienteCon3, txtClienteCon4, txtClienteCon5, txtClienteCon6, txtClienteCon7, txtClienteCon8, txtClienteCon9, txtClienteCon10};
        JLabel[] labelsHorario = {txtHorarioCon1, txtHorarioCon2, txtHorarioCon3, txtHorarioCon4, txtHorarioCon5, txtHorarioCon6, txtHorarioCon7, txtHorarioCon8, txtHorarioCon9, txtHorarioCon10};
        JLabel[] labelsServico = {txtServicoCon1, txtServicoCon2, txtServicoCon3, txtServicoCon4, txtServicoCon5, txtServicoCon6, txtServicoCon7, txtServicoCon8, txtServicoCon9, txtServicoCon10};

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
        jScrollPaneAbe = new css.ScrollPaneWin11();
        jPanelAbe = new javax.swing.JPanel();
        AgendamentoAbe1 = new css.JPanelArredondadoAgendamentos(30);
        seta1 = new javax.swing.JLabel();
        txtCliente1 = new javax.swing.JLabel();
        txtHorario1 = new javax.swing.JLabel();
        txtServico1 = new javax.swing.JLabel();
        AgendamentoAbe2 = new css.JPanelArredondadoAgendamentos(30);
        seta2 = new javax.swing.JLabel();
        txtCliente2 = new javax.swing.JLabel();
        txtHorario2 = new javax.swing.JLabel();
        txtServico2 = new javax.swing.JLabel();
        AgendamentoAbe3 = new css.JPanelArredondadoAgendamentos(30);
        seta3 = new javax.swing.JLabel();
        txtCliente3 = new javax.swing.JLabel();
        txtHorario3 = new javax.swing.JLabel();
        txtServico3 = new javax.swing.JLabel();
        AgendamentoAbe4 = new css.JPanelArredondadoAgendamentos(30);
        seta4 = new javax.swing.JLabel();
        txtCliente4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        txtServico4 = new javax.swing.JLabel();
        AgendamentoAbe5 = new css.JPanelArredondadoAgendamentos(30);
        seta5 = new javax.swing.JLabel();
        txtCliente5 = new javax.swing.JLabel();
        txtHorario5 = new javax.swing.JLabel();
        txtServico5 = new javax.swing.JLabel();
        AgendamentoAbe6 = new css.JPanelArredondadoAgendamentos(30);
        seta16 = new javax.swing.JLabel();
        txtCliente6 = new javax.swing.JLabel();
        txtHorario6 = new javax.swing.JLabel();
        txtServico6 = new javax.swing.JLabel();
        AgendamentoAbe7 = new css.JPanelArredondadoAgendamentos(30);
        seta17 = new javax.swing.JLabel();
        txtCliente7 = new javax.swing.JLabel();
        txtHorario7 = new javax.swing.JLabel();
        txtServico7 = new javax.swing.JLabel();
        AgendamentoAbe8 = new css.JPanelArredondadoAgendamentos(30);
        seta18 = new javax.swing.JLabel();
        txtCliente8 = new javax.swing.JLabel();
        txtHorario8 = new javax.swing.JLabel();
        txtServico8 = new javax.swing.JLabel();
        AgendamentoAbe9 = new css.JPanelArredondadoAgendamentos(30);
        seta19 = new javax.swing.JLabel();
        txtCliente9 = new javax.swing.JLabel();
        txtHorario9 = new javax.swing.JLabel();
        txtServico9 = new javax.swing.JLabel();
        AgendamentoAbe10 = new css.JPanelArredondadoAgendamentos(30);
        seta20 = new javax.swing.JLabel();
        txtCliente10 = new javax.swing.JLabel();
        txtHorario10 = new javax.swing.JLabel();
        txtServico10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Cancelado = new css.JPanelArredondadoBarbearias(20);
        cancelado = new javax.swing.JLabel();
        jScrollPaneCan = new css.ScrollPaneWin11();
        jPanelCan = new javax.swing.JPanel();
        AgendamentoCan2 = new css.JPanelArredondadoAgendamentos(30);
        seta8 = new javax.swing.JLabel();
        txtClienteCan2 = new javax.swing.JLabel();
        txtHorarioCan2 = new javax.swing.JLabel();
        txtServicoCan2 = new javax.swing.JLabel();
        AgendamentoCan3 = new css.JPanelArredondadoAgendamentos(30);
        seta7 = new javax.swing.JLabel();
        txtClienteCan3 = new javax.swing.JLabel();
        txtHorarioCan3 = new javax.swing.JLabel();
        txtServicoCan3 = new javax.swing.JLabel();
        AgendamentoCan1 = new css.JPanelArredondadoAgendamentos(30);
        seta6 = new javax.swing.JLabel();
        txtClienteCan1 = new javax.swing.JLabel();
        txtHorarioCan1 = new javax.swing.JLabel();
        txtServicoCan1 = new javax.swing.JLabel();
        AgendamentoCan5 = new css.JPanelArredondadoAgendamentos(30);
        seta10 = new javax.swing.JLabel();
        txtClienteCan5 = new javax.swing.JLabel();
        txtHorarioCan5 = new javax.swing.JLabel();
        txtServicoCan5 = new javax.swing.JLabel();
        AgendamentoCan4 = new css.JPanelArredondadoAgendamentos(30);
        seta9 = new javax.swing.JLabel();
        txtClienteCan4 = new javax.swing.JLabel();
        txtHorarioCan4 = new javax.swing.JLabel();
        txtServicoCan4 = new javax.swing.JLabel();
        AgendamentoCan6 = new css.JPanelArredondadoAgendamentos(30);
        seta21 = new javax.swing.JLabel();
        txtClienteCan6 = new javax.swing.JLabel();
        txtHorarioCan6 = new javax.swing.JLabel();
        txtServicoCan6 = new javax.swing.JLabel();
        AgendamentoCan7 = new css.JPanelArredondadoAgendamentos(30);
        seta22 = new javax.swing.JLabel();
        txtClienteCan7 = new javax.swing.JLabel();
        txtHorarioCan7 = new javax.swing.JLabel();
        txtServicoCan7 = new javax.swing.JLabel();
        AgendamentoCan8 = new css.JPanelArredondadoAgendamentos(30);
        seta23 = new javax.swing.JLabel();
        txtClienteCan8 = new javax.swing.JLabel();
        txtHorarioCan8 = new javax.swing.JLabel();
        txtServicoCan8 = new javax.swing.JLabel();
        AgendamentoCan9 = new css.JPanelArredondadoAgendamentos(30);
        seta24 = new javax.swing.JLabel();
        txtClienteCan9 = new javax.swing.JLabel();
        txtHorarioCan9 = new javax.swing.JLabel();
        txtServicoCan9 = new javax.swing.JLabel();
        AgendamentoCan10 = new css.JPanelArredondadoAgendamentos(30);
        seta25 = new javax.swing.JLabel();
        txtClienteCan10 = new javax.swing.JLabel();
        txtHorarioCan10 = new javax.swing.JLabel();
        txtServicoCan10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Concluido = new css.JPanelArredondadoBarbearias(20);
        concluido = new javax.swing.JLabel();
        jScrollPaneRea = new css.ScrollPaneWin11();
        jPanelRea = new javax.swing.JPanel();
        AgendamentoCon1 = new css.JPanelArredondadoAgendamentos(30);
        seta11 = new javax.swing.JLabel();
        txtClienteCon1 = new javax.swing.JLabel();
        txtHorarioCon1 = new javax.swing.JLabel();
        txtServicoCon1 = new javax.swing.JLabel();
        AgendamentoCon2 = new css.JPanelArredondadoAgendamentos(30);
        seta13 = new javax.swing.JLabel();
        txtClienteCon2 = new javax.swing.JLabel();
        txtHorarioCon2 = new javax.swing.JLabel();
        txtServicoCon2 = new javax.swing.JLabel();
        AgendamentoCon3 = new css.JPanelArredondadoAgendamentos(30);
        seta15 = new javax.swing.JLabel();
        txtClienteCon3 = new javax.swing.JLabel();
        txtHorarioCon3 = new javax.swing.JLabel();
        txtServicoCon3 = new javax.swing.JLabel();
        AgendamentoCon4 = new css.JPanelArredondadoAgendamentos(30);
        seta12 = new javax.swing.JLabel();
        txtClienteCon4 = new javax.swing.JLabel();
        txtHorarioCon4 = new javax.swing.JLabel();
        txtServicoCon4 = new javax.swing.JLabel();
        AgendamentoCon5 = new css.JPanelArredondadoAgendamentos(30);
        seta14 = new javax.swing.JLabel();
        txtClienteCon5 = new javax.swing.JLabel();
        txtHorarioCon5 = new javax.swing.JLabel();
        txtServicoCon5 = new javax.swing.JLabel();
        AgendamentoCon6 = new css.JPanelArredondadoAgendamentos(30);
        seta26 = new javax.swing.JLabel();
        txtClienteCon6 = new javax.swing.JLabel();
        txtHorarioCon6 = new javax.swing.JLabel();
        txtServicoCon6 = new javax.swing.JLabel();
        AgendamentoCon7 = new css.JPanelArredondadoAgendamentos(30);
        seta27 = new javax.swing.JLabel();
        txtClienteCon7 = new javax.swing.JLabel();
        txtHorarioCon7 = new javax.swing.JLabel();
        txtServicoCon7 = new javax.swing.JLabel();
        AgendamentoCon8 = new css.JPanelArredondadoAgendamentos(30);
        seta28 = new javax.swing.JLabel();
        txtClienteCon8 = new javax.swing.JLabel();
        txtHorarioCon8 = new javax.swing.JLabel();
        txtServicoCon8 = new javax.swing.JLabel();
        AgendamentoCon9 = new css.JPanelArredondadoAgendamentos(30);
        seta29 = new javax.swing.JLabel();
        txtClienteCon9 = new javax.swing.JLabel();
        txtHorarioCon9 = new javax.swing.JLabel();
        txtServicoCon9 = new javax.swing.JLabel();
        AgendamentoCon10 = new css.JPanelArredondadoAgendamentos(30);
        seta30 = new javax.swing.JLabel();
        txtClienteCon10 = new javax.swing.JLabel();
        txtHorarioCon10 = new javax.swing.JLabel();
        txtServicoCon10 = new javax.swing.JLabel();

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
        titulo.setText("Agendamentos");
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

        jScrollPaneAbe.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneAbe.setMaximumSize(new java.awt.Dimension(600, 500));
        jScrollPaneAbe.setMinimumSize(new java.awt.Dimension(600, 500));
        jScrollPaneAbe.setPreferredSize(new java.awt.Dimension(600, 650));

        jPanelAbe.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAbe.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanelAbe.setMinimumSize(new java.awt.Dimension(600, 500));
        jPanelAbe.setPreferredSize(new java.awt.Dimension(600, 1050));

        AgendamentoAbe1.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe1.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe1.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe1.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

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
                .addContainerGap(122, Short.MAX_VALUE))
        );
        AgendamentoAbe1Layout.setVerticalGroup(
            AgendamentoAbe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe1Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe1Layout.createSequentialGroup()
                        .addComponent(txtCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe2Layout.setVerticalGroup(
            AgendamentoAbe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe2Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe2Layout.createSequentialGroup()
                        .addComponent(txtCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe3Layout.setVerticalGroup(
            AgendamentoAbe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe3Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe3Layout.createSequentialGroup()
                        .addComponent(txtCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe4Layout.setVerticalGroup(
            AgendamentoAbe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe4Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe4Layout.createSequentialGroup()
                        .addComponent(txtCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe5Layout.setVerticalGroup(
            AgendamentoAbe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe5Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe5Layout.createSequentialGroup()
                        .addComponent(txtCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe6.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe6.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe6.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe6.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe6.setPreferredSize(new java.awt.Dimension(400, 100));

        seta16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente6.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente6.setToolTipText("");
        txtCliente6.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente6.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario6.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario6.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario6.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServico6.setForeground(new java.awt.Color(255, 255, 255));
        txtServico6.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico6.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoAbe6Layout = new javax.swing.GroupLayout(AgendamentoAbe6);
        AgendamentoAbe6.setLayout(AgendamentoAbe6Layout);
        AgendamentoAbe6Layout.setHorizontalGroup(
            AgendamentoAbe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe6Layout.createSequentialGroup()
                .addComponent(seta16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente6, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe6Layout.setVerticalGroup(
            AgendamentoAbe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe6Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe6Layout.createSequentialGroup()
                        .addComponent(txtCliente6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe7.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe7.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe7.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe7.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe7.setPreferredSize(new java.awt.Dimension(400, 100));

        seta17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente7.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente7.setToolTipText("");
        txtCliente7.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente7.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario7.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario7.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario7.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServico7.setForeground(new java.awt.Color(255, 255, 255));
        txtServico7.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico7.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoAbe7Layout = new javax.swing.GroupLayout(AgendamentoAbe7);
        AgendamentoAbe7.setLayout(AgendamentoAbe7Layout);
        AgendamentoAbe7Layout.setHorizontalGroup(
            AgendamentoAbe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe7Layout.createSequentialGroup()
                .addComponent(seta17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente7, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe7Layout.setVerticalGroup(
            AgendamentoAbe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe7Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe7Layout.createSequentialGroup()
                        .addComponent(txtCliente7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe8.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe8.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe8.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe8.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe8.setPreferredSize(new java.awt.Dimension(400, 100));

        seta18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente8.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente8.setToolTipText("");
        txtCliente8.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente8.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario8.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario8.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario8.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServico8.setForeground(new java.awt.Color(255, 255, 255));
        txtServico8.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico8.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoAbe8Layout = new javax.swing.GroupLayout(AgendamentoAbe8);
        AgendamentoAbe8.setLayout(AgendamentoAbe8Layout);
        AgendamentoAbe8Layout.setHorizontalGroup(
            AgendamentoAbe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe8Layout.createSequentialGroup()
                .addComponent(seta18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente8, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe8Layout.setVerticalGroup(
            AgendamentoAbe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe8Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe8Layout.createSequentialGroup()
                        .addComponent(txtCliente8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe9.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe9.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe9.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe9.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe9.setPreferredSize(new java.awt.Dimension(400, 100));

        seta19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente9.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente9.setToolTipText("");
        txtCliente9.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente9.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario9.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario9.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario9.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServico9.setForeground(new java.awt.Color(255, 255, 255));
        txtServico9.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico9.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoAbe9Layout = new javax.swing.GroupLayout(AgendamentoAbe9);
        AgendamentoAbe9.setLayout(AgendamentoAbe9Layout);
        AgendamentoAbe9Layout.setHorizontalGroup(
            AgendamentoAbe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe9Layout.createSequentialGroup()
                .addComponent(seta19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        AgendamentoAbe9Layout.setVerticalGroup(
            AgendamentoAbe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe9Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe9Layout.createSequentialGroup()
                        .addComponent(txtCliente9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoAbe10.setBackground(new java.awt.Color(30, 113, 218));
        AgendamentoAbe10.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoAbe10.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe10.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoAbe10.setPreferredSize(new java.awt.Dimension(400, 100));

        seta20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta.png"))); // NOI18N

        txtCliente10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtCliente10.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente10.setToolTipText("");
        txtCliente10.setBorder(new javax.swing.border.MatteBorder(null));
        txtCliente10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCliente10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtCliente10.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorario10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorario10.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario10.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorario10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorario10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorario10.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorario10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServico10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServico10.setForeground(new java.awt.Color(255, 255, 255));
        txtServico10.setBorder(new javax.swing.border.MatteBorder(null));
        txtServico10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServico10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServico10.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoAbe10Layout = new javax.swing.GroupLayout(AgendamentoAbe10);
        AgendamentoAbe10.setLayout(AgendamentoAbe10Layout);
        AgendamentoAbe10Layout.setHorizontalGroup(
            AgendamentoAbe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe10Layout.createSequentialGroup()
                .addComponent(seta20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoAbe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtHorario10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtCliente10, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServico10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        AgendamentoAbe10Layout.setVerticalGroup(
            AgendamentoAbe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoAbe10Layout.createSequentialGroup()
                .addGroup(AgendamentoAbe10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoAbe10Layout.createSequentialGroup()
                        .addComponent(txtCliente10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorario10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServico10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelAbeLayout = new javax.swing.GroupLayout(jPanelAbe);
        jPanelAbe.setLayout(jPanelAbeLayout);
        jPanelAbeLayout.setHorizontalGroup(
            jPanelAbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAbeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelAbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelAbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AgendamentoAbe7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelAbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AgendamentoAbe9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgendamentoAbe10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgendamentoAbe6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgendamentoAbe8, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelAbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AgendamentoAbe5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelAbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AgendamentoAbe1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgendamentoAbe2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgendamentoAbe3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgendamentoAbe4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelAbeLayout.setVerticalGroup(
            jPanelAbeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAbeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AgendamentoAbe1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoAbe7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPaneAbe.setViewportView(jPanelAbe);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        jScrollPaneCan.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneCan.setMaximumSize(new java.awt.Dimension(600, 500));
        jScrollPaneCan.setMinimumSize(new java.awt.Dimension(600, 500));
        jScrollPaneCan.setName(""); // NOI18N
        jScrollPaneCan.setPreferredSize(new java.awt.Dimension(600, 650));

        jPanelCan.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCan.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanelCan.setMinimumSize(new java.awt.Dimension(600, 500));
        jPanelCan.setPreferredSize(new java.awt.Dimension(600, 1050));

        AgendamentoCan2.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan2.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan2.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan2.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan2.setPreferredSize(new java.awt.Dimension(400, 100));

        seta8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan2.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan2.setToolTipText("");
        txtClienteCan2.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan2.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan3.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan3.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan3.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan3.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan3.setPreferredSize(new java.awt.Dimension(400, 100));

        seta7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan3.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan3.setToolTipText("");
        txtClienteCan3.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan3.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan1.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan1.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan1.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan1.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan1.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan1.setToolTipText("");
        txtClienteCan1.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan5.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan5.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan5.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan5.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan5.setPreferredSize(new java.awt.Dimension(400, 100));

        seta10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan5.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan5.setToolTipText("");
        txtClienteCan5.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan4.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan4.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan4.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan4.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan4.setPreferredSize(new java.awt.Dimension(400, 100));

        seta9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan4.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan4.setToolTipText("");
        txtClienteCan4.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan4.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan6.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan6.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan6.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan6.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan6.setPreferredSize(new java.awt.Dimension(400, 100));

        seta21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan6.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan6.setToolTipText("");
        txtClienteCan6.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan6.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan6.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan6.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan6.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCan6.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan6.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan6.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan6Layout = new javax.swing.GroupLayout(AgendamentoCan6);
        AgendamentoCan6.setLayout(AgendamentoCan6Layout);
        AgendamentoCan6Layout.setHorizontalGroup(
            AgendamentoCan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan6Layout.createSequentialGroup()
                .addComponent(seta21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan6Layout.setVerticalGroup(
            AgendamentoCan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan6Layout.createSequentialGroup()
                .addGroup(AgendamentoCan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan6Layout.createSequentialGroup()
                        .addComponent(txtClienteCan6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan7.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan7.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan7.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan7.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan7.setPreferredSize(new java.awt.Dimension(400, 100));

        seta22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan7.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan7.setToolTipText("");
        txtClienteCan7.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan7.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan7.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan7.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan7.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCan7.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan7.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan7.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan7Layout = new javax.swing.GroupLayout(AgendamentoCan7);
        AgendamentoCan7.setLayout(AgendamentoCan7Layout);
        AgendamentoCan7Layout.setHorizontalGroup(
            AgendamentoCan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan7Layout.createSequentialGroup()
                .addComponent(seta22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan7Layout.setVerticalGroup(
            AgendamentoCan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan7Layout.createSequentialGroup()
                .addGroup(AgendamentoCan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan7Layout.createSequentialGroup()
                        .addComponent(txtClienteCan7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan8.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan8.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan8.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan8.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan8.setPreferredSize(new java.awt.Dimension(400, 100));

        seta23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan8.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan8.setToolTipText("");
        txtClienteCan8.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan8.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan8.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan8.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan8.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCan8.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan8.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan8.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan8Layout = new javax.swing.GroupLayout(AgendamentoCan8);
        AgendamentoCan8.setLayout(AgendamentoCan8Layout);
        AgendamentoCan8Layout.setHorizontalGroup(
            AgendamentoCan8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan8Layout.createSequentialGroup()
                .addComponent(seta23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan8Layout.setVerticalGroup(
            AgendamentoCan8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan8Layout.createSequentialGroup()
                .addGroup(AgendamentoCan8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan8Layout.createSequentialGroup()
                        .addComponent(txtClienteCan8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan9.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan9.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan9.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan9.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan9.setPreferredSize(new java.awt.Dimension(400, 100));

        seta24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan9.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan9.setToolTipText("");
        txtClienteCan9.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan9.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan9.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan9.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan9.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCan9.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan9.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan9.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan9Layout = new javax.swing.GroupLayout(AgendamentoCan9);
        AgendamentoCan9.setLayout(AgendamentoCan9Layout);
        AgendamentoCan9Layout.setHorizontalGroup(
            AgendamentoCan9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan9Layout.createSequentialGroup()
                .addComponent(seta24, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan9Layout.setVerticalGroup(
            AgendamentoCan9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan9Layout.createSequentialGroup()
                .addGroup(AgendamentoCan9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan9Layout.createSequentialGroup()
                        .addComponent(txtClienteCan9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCan10.setBackground(new java.awt.Color(153, 0, 0));
        AgendamentoCan10.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCan10.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan10.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCan10.setPreferredSize(new java.awt.Dimension(400, 100));

        seta25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta2.png"))); // NOI18N

        txtClienteCan10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCan10.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCan10.setToolTipText("");
        txtClienteCan10.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCan10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCan10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCan10.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCan10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCan10.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCan10.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCan10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCan10.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCan10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCan10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCan10.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCan10.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCan10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCan10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCan10.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCan10Layout = new javax.swing.GroupLayout(AgendamentoCan10);
        AgendamentoCan10.setLayout(AgendamentoCan10Layout);
        AgendamentoCan10Layout.setHorizontalGroup(
            AgendamentoCan10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan10Layout.createSequentialGroup()
                .addComponent(seta25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCan10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCan10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCan10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCan10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCan10Layout.setVerticalGroup(
            AgendamentoCan10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCan10Layout.createSequentialGroup()
                .addGroup(AgendamentoCan10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCan10Layout.createSequentialGroup()
                        .addComponent(txtClienteCan10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCan10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCan10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelCanLayout = new javax.swing.GroupLayout(jPanelCan);
        jPanelCan.setLayout(jPanelCanLayout);
        jPanelCanLayout.setHorizontalGroup(
            jPanelCanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelCanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AgendamentoCan6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan8, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelCanLayout.setVerticalGroup(
            jPanelCanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AgendamentoCan1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCan9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPaneCan.setViewportView(jPanelCan);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        jScrollPaneRea.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneRea.setMaximumSize(new java.awt.Dimension(600, 500));
        jScrollPaneRea.setMinimumSize(new java.awt.Dimension(600, 500));
        jScrollPaneRea.setPreferredSize(new java.awt.Dimension(600, 650));

        jPanelRea.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRea.setMaximumSize(new java.awt.Dimension(600, 500));
        jPanelRea.setMinimumSize(new java.awt.Dimension(600, 500));
        jPanelRea.setPreferredSize(new java.awt.Dimension(600, 1050));

        AgendamentoCon1.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon1.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon1.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon1.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon1.setPreferredSize(new java.awt.Dimension(400, 100));

        seta11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon1.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon1.setToolTipText("");
        txtClienteCon1.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon1.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon1.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon1.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon1.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon1.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon2.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon2.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon2.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon2.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon2.setPreferredSize(new java.awt.Dimension(400, 100));

        seta13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon2.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon2.setToolTipText("");
        txtClienteCon2.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon2.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon2.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon2.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon2.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon2.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon2.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon3.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon3.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon3.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon3.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon3.setPreferredSize(new java.awt.Dimension(400, 100));

        seta15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon3.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon3.setToolTipText("");
        txtClienteCon3.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon3.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon3.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon3.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon3.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon3.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon3.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon4.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon4.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon4.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon4.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon4.setPreferredSize(new java.awt.Dimension(400, 100));

        seta12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon4.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon4.setToolTipText("");
        txtClienteCon4.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon4.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon4.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon4.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon4.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon4.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon4.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon5.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon5.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon5.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon5.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon5.setPreferredSize(new java.awt.Dimension(400, 100));

        seta14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon5.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon5.setToolTipText("");
        txtClienteCon5.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon5.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon5.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon5.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon5.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon5.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon5.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
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
                        .addComponent(txtClienteCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon6.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon6.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon6.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon6.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon6.setPreferredSize(new java.awt.Dimension(400, 100));

        seta26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon6.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon6.setToolTipText("");
        txtClienteCon6.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon6.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon6.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon6.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon6.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon6.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCon6.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon6.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon6.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon6.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon6.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon6Layout = new javax.swing.GroupLayout(AgendamentoCon6);
        AgendamentoCon6.setLayout(AgendamentoCon6Layout);
        AgendamentoCon6Layout.setHorizontalGroup(
            AgendamentoCon6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon6Layout.createSequentialGroup()
                .addComponent(seta26, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon6Layout.setVerticalGroup(
            AgendamentoCon6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon6Layout.createSequentialGroup()
                .addGroup(AgendamentoCon6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon6Layout.createSequentialGroup()
                        .addComponent(txtClienteCon6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon7.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon7.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon7.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon7.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon7.setPreferredSize(new java.awt.Dimension(400, 100));

        seta27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon7.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon7.setToolTipText("");
        txtClienteCon7.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon7.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon7.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon7.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon7.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon7.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCon7.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon7.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon7.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon7.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon7.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon7Layout = new javax.swing.GroupLayout(AgendamentoCon7);
        AgendamentoCon7.setLayout(AgendamentoCon7Layout);
        AgendamentoCon7Layout.setHorizontalGroup(
            AgendamentoCon7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon7Layout.createSequentialGroup()
                .addComponent(seta27, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon7Layout.setVerticalGroup(
            AgendamentoCon7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon7Layout.createSequentialGroup()
                .addGroup(AgendamentoCon7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon7Layout.createSequentialGroup()
                        .addComponent(txtClienteCon7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon8.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon8.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon8.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon8.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon8.setPreferredSize(new java.awt.Dimension(400, 100));

        seta28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon8.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon8.setToolTipText("");
        txtClienteCon8.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon8.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon8.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon8.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon8.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon8.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCon8.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon8.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon8.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon8.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon8.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon8Layout = new javax.swing.GroupLayout(AgendamentoCon8);
        AgendamentoCon8.setLayout(AgendamentoCon8Layout);
        AgendamentoCon8Layout.setHorizontalGroup(
            AgendamentoCon8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon8Layout.createSequentialGroup()
                .addComponent(seta28, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon8Layout.setVerticalGroup(
            AgendamentoCon8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon8Layout.createSequentialGroup()
                .addGroup(AgendamentoCon8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon8Layout.createSequentialGroup()
                        .addComponent(txtClienteCon8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon9.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon9.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon9.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon9.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon9.setPreferredSize(new java.awt.Dimension(400, 100));

        seta29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon9.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon9.setToolTipText("");
        txtClienteCon9.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon9.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon9.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon9.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon9.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon9.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCon9.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon9.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon9.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon9.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon9.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon9Layout = new javax.swing.GroupLayout(AgendamentoCon9);
        AgendamentoCon9.setLayout(AgendamentoCon9Layout);
        AgendamentoCon9Layout.setHorizontalGroup(
            AgendamentoCon9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon9Layout.createSequentialGroup()
                .addComponent(seta29, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon9Layout.setVerticalGroup(
            AgendamentoCon9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon9Layout.createSequentialGroup()
                .addGroup(AgendamentoCon9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon9Layout.createSequentialGroup()
                        .addComponent(txtClienteCon9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AgendamentoCon10.setBackground(new java.awt.Color(0, 102, 0));
        AgendamentoCon10.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoCon10.setMaximumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon10.setMinimumSize(new java.awt.Dimension(450, 70));
        AgendamentoCon10.setPreferredSize(new java.awt.Dimension(400, 100));

        seta30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seta30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/setta3.png"))); // NOI18N

        txtClienteCon10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtClienteCon10.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteCon10.setToolTipText("");
        txtClienteCon10.setBorder(new javax.swing.border.MatteBorder(null));
        txtClienteCon10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtClienteCon10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtClienteCon10.setPreferredSize(new java.awt.Dimension(300, 30));

        txtHorarioCon10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtHorarioCon10.setForeground(new java.awt.Color(255, 255, 255));
        txtHorarioCon10.setBorder(new javax.swing.border.MatteBorder(null));
        txtHorarioCon10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtHorarioCon10.setPreferredSize(new java.awt.Dimension(300, 30));
        txtHorarioCon10.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtServicoCon10.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        txtServicoCon10.setForeground(new java.awt.Color(255, 255, 255));
        txtServicoCon10.setBorder(new javax.swing.border.MatteBorder(null));
        txtServicoCon10.setMaximumSize(new java.awt.Dimension(300, 30));
        txtServicoCon10.setMinimumSize(new java.awt.Dimension(300, 30));
        txtServicoCon10.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout AgendamentoCon10Layout = new javax.swing.GroupLayout(AgendamentoCon10);
        AgendamentoCon10.setLayout(AgendamentoCon10Layout);
        AgendamentoCon10Layout.setHorizontalGroup(
            AgendamentoCon10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon10Layout.createSequentialGroup()
                .addComponent(seta30, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AgendamentoCon10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHorarioCon10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoCon10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteCon10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        AgendamentoCon10Layout.setVerticalGroup(
            AgendamentoCon10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AgendamentoCon10Layout.createSequentialGroup()
                .addGroup(AgendamentoCon10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AgendamentoCon10Layout.createSequentialGroup()
                        .addComponent(txtClienteCon10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHorarioCon10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtServicoCon10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(seta30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelReaLayout = new javax.swing.GroupLayout(jPanelRea);
        jPanelRea.setLayout(jPanelReaLayout);
        jPanelReaLayout.setHorizontalGroup(
            jPanelReaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanelReaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AgendamentoCon9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon8, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgendamentoCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelReaLayout.setVerticalGroup(
            jPanelReaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AgendamentoCon1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendamentoCon10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jScrollPaneRea.setViewportView(jPanelRea);

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                        .addComponent(jScrollPaneAbe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneCan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPaneRea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(EmAberto, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(Cancelado, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(Concluido, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmAberto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Concluido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPaneCan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneAbe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPaneRea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jScrollPaneAbe.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        jScrollPaneCan.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        jScrollPaneRea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Cima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Centro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaAgendamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaAgendamentos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AgendamentoAbe1;
    private javax.swing.JPanel AgendamentoAbe10;
    private javax.swing.JPanel AgendamentoAbe2;
    private javax.swing.JPanel AgendamentoAbe3;
    private javax.swing.JPanel AgendamentoAbe4;
    private javax.swing.JPanel AgendamentoAbe5;
    private javax.swing.JPanel AgendamentoAbe6;
    private javax.swing.JPanel AgendamentoAbe7;
    private javax.swing.JPanel AgendamentoAbe8;
    private javax.swing.JPanel AgendamentoAbe9;
    private javax.swing.JPanel AgendamentoCan1;
    private javax.swing.JPanel AgendamentoCan10;
    private javax.swing.JPanel AgendamentoCan2;
    private javax.swing.JPanel AgendamentoCan3;
    private javax.swing.JPanel AgendamentoCan4;
    private javax.swing.JPanel AgendamentoCan5;
    private javax.swing.JPanel AgendamentoCan6;
    private javax.swing.JPanel AgendamentoCan7;
    private javax.swing.JPanel AgendamentoCan8;
    private javax.swing.JPanel AgendamentoCan9;
    private javax.swing.JPanel AgendamentoCon1;
    private javax.swing.JPanel AgendamentoCon10;
    private javax.swing.JPanel AgendamentoCon2;
    private javax.swing.JPanel AgendamentoCon3;
    private javax.swing.JPanel AgendamentoCon4;
    private javax.swing.JPanel AgendamentoCon5;
    private javax.swing.JPanel AgendamentoCon6;
    private javax.swing.JPanel AgendamentoCon7;
    private javax.swing.JPanel AgendamentoCon8;
    private javax.swing.JPanel AgendamentoCon9;
    private javax.swing.JPanel Cancelado;
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JPanel Concluido;
    private javax.swing.JPanel EmAberto;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel cancelado;
    private javax.swing.JLabel concluido;
    private javax.swing.JLabel emaberto;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanelAbe;
    private javax.swing.JPanel jPanelCan;
    private javax.swing.JPanel jPanelRea;
    private javax.swing.JScrollPane jScrollPaneAbe;
    private javax.swing.JScrollPane jScrollPaneCan;
    private javax.swing.JScrollPane jScrollPaneRea;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel seta1;
    private javax.swing.JLabel seta10;
    private javax.swing.JLabel seta11;
    private javax.swing.JLabel seta12;
    private javax.swing.JLabel seta13;
    private javax.swing.JLabel seta14;
    private javax.swing.JLabel seta15;
    private javax.swing.JLabel seta16;
    private javax.swing.JLabel seta17;
    private javax.swing.JLabel seta18;
    private javax.swing.JLabel seta19;
    private javax.swing.JLabel seta2;
    private javax.swing.JLabel seta20;
    private javax.swing.JLabel seta21;
    private javax.swing.JLabel seta22;
    private javax.swing.JLabel seta23;
    private javax.swing.JLabel seta24;
    private javax.swing.JLabel seta25;
    private javax.swing.JLabel seta26;
    private javax.swing.JLabel seta27;
    private javax.swing.JLabel seta28;
    private javax.swing.JLabel seta29;
    private javax.swing.JLabel seta3;
    private javax.swing.JLabel seta30;
    private javax.swing.JLabel seta4;
    private javax.swing.JLabel seta5;
    private javax.swing.JLabel seta6;
    private javax.swing.JLabel seta7;
    private javax.swing.JLabel seta8;
    private javax.swing.JLabel seta9;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCliente1;
    private javax.swing.JLabel txtCliente10;
    private javax.swing.JLabel txtCliente2;
    private javax.swing.JLabel txtCliente3;
    private javax.swing.JLabel txtCliente4;
    private javax.swing.JLabel txtCliente5;
    private javax.swing.JLabel txtCliente6;
    private javax.swing.JLabel txtCliente7;
    private javax.swing.JLabel txtCliente8;
    private javax.swing.JLabel txtCliente9;
    private javax.swing.JLabel txtClienteCan1;
    private javax.swing.JLabel txtClienteCan10;
    private javax.swing.JLabel txtClienteCan2;
    private javax.swing.JLabel txtClienteCan3;
    private javax.swing.JLabel txtClienteCan4;
    private javax.swing.JLabel txtClienteCan5;
    private javax.swing.JLabel txtClienteCan6;
    private javax.swing.JLabel txtClienteCan7;
    private javax.swing.JLabel txtClienteCan8;
    private javax.swing.JLabel txtClienteCan9;
    private javax.swing.JLabel txtClienteCon1;
    private javax.swing.JLabel txtClienteCon10;
    private javax.swing.JLabel txtClienteCon2;
    private javax.swing.JLabel txtClienteCon3;
    private javax.swing.JLabel txtClienteCon4;
    private javax.swing.JLabel txtClienteCon5;
    private javax.swing.JLabel txtClienteCon6;
    private javax.swing.JLabel txtClienteCon7;
    private javax.swing.JLabel txtClienteCon8;
    private javax.swing.JLabel txtClienteCon9;
    private javax.swing.JLabel txtHorario1;
    private javax.swing.JLabel txtHorario10;
    private javax.swing.JLabel txtHorario2;
    private javax.swing.JLabel txtHorario3;
    private javax.swing.JLabel txtHorario4;
    private javax.swing.JLabel txtHorario5;
    private javax.swing.JLabel txtHorario6;
    private javax.swing.JLabel txtHorario7;
    private javax.swing.JLabel txtHorario8;
    private javax.swing.JLabel txtHorario9;
    private javax.swing.JLabel txtHorarioCan1;
    private javax.swing.JLabel txtHorarioCan10;
    private javax.swing.JLabel txtHorarioCan2;
    private javax.swing.JLabel txtHorarioCan3;
    private javax.swing.JLabel txtHorarioCan4;
    private javax.swing.JLabel txtHorarioCan5;
    private javax.swing.JLabel txtHorarioCan6;
    private javax.swing.JLabel txtHorarioCan7;
    private javax.swing.JLabel txtHorarioCan8;
    private javax.swing.JLabel txtHorarioCan9;
    private javax.swing.JLabel txtHorarioCon1;
    private javax.swing.JLabel txtHorarioCon10;
    private javax.swing.JLabel txtHorarioCon2;
    private javax.swing.JLabel txtHorarioCon3;
    private javax.swing.JLabel txtHorarioCon4;
    private javax.swing.JLabel txtHorarioCon5;
    private javax.swing.JLabel txtHorarioCon6;
    private javax.swing.JLabel txtHorarioCon7;
    private javax.swing.JLabel txtHorarioCon8;
    private javax.swing.JLabel txtHorarioCon9;
    private javax.swing.JLabel txtServico1;
    private javax.swing.JLabel txtServico10;
    private javax.swing.JLabel txtServico2;
    private javax.swing.JLabel txtServico3;
    private javax.swing.JLabel txtServico4;
    private javax.swing.JLabel txtServico5;
    private javax.swing.JLabel txtServico6;
    private javax.swing.JLabel txtServico7;
    private javax.swing.JLabel txtServico8;
    private javax.swing.JLabel txtServico9;
    private javax.swing.JLabel txtServicoCan1;
    private javax.swing.JLabel txtServicoCan10;
    private javax.swing.JLabel txtServicoCan2;
    private javax.swing.JLabel txtServicoCan3;
    private javax.swing.JLabel txtServicoCan4;
    private javax.swing.JLabel txtServicoCan5;
    private javax.swing.JLabel txtServicoCan6;
    private javax.swing.JLabel txtServicoCan7;
    private javax.swing.JLabel txtServicoCan8;
    private javax.swing.JLabel txtServicoCan9;
    private javax.swing.JLabel txtServicoCon1;
    private javax.swing.JLabel txtServicoCon10;
    private javax.swing.JLabel txtServicoCon2;
    private javax.swing.JLabel txtServicoCon3;
    private javax.swing.JLabel txtServicoCon4;
    private javax.swing.JLabel txtServicoCon5;
    private javax.swing.JLabel txtServicoCon6;
    private javax.swing.JLabel txtServicoCon7;
    private javax.swing.JLabel txtServicoCon8;
    private javax.swing.JLabel txtServicoCon9;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
