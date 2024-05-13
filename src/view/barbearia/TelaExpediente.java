package view.barbearia;

import com.raven.datechooser.EventDateChooser;
import com.raven.datechooser.SelectedAction;
import com.raven.datechooser.SelectedDate;
import controller.ExpedienteController;
import css.BordaArredondada;
import dao.ExpedienteDAO;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import model.Expediente;

public class TelaExpediente extends javax.swing.JFrame {
    String dataString;
    String horaIniString;
    String horaFimString;
    int opcao=1, periodo=1;
    int CODBARBEARIA;
    Expediente modelExpediente = new Expediente();
    ExpedienteDAO expedienteDao = new ExpedienteDAO();
    ExpedienteController expedienteController = new ExpedienteController();
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    
    public TelaExpediente() {
        initComponents();
        setExtendedState (MAXIMIZED_BOTH);
        setIcon();
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Verifica se foi um clique duplo (ou apenas um clique simples)
                if (e.getClickCount() == 1) {
                    txtDataInicial.setText("");
                    txtHoraIni.setText("");
                    txtHoraFim.setText("");
                    
                    int row = jTable1.getSelectedRow(); // Índice da linha selecionada

                    // Obter os dados da linha selecionada
                    Date data = (Date) jTable1.getValueAt(row, 0);
                    Time horaIni = (Time) jTable1.getValueAt(row, 1);
                    Time horaFim = (Time) jTable1.getValueAt(row, 2);
                    
                    SimpleDateFormat dataS = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat horaS = new SimpleDateFormat("HH:mm:ss");
                    String dataStringg = dataS.format(data);
                    String horaIniStringg = horaS.format(horaIni);
                    String horaFimStringg = horaS.format(horaFim);
                    
                    dataString = dataStringg;
                    horaIniString = horaIniStringg;
                    horaFimString = horaFimStringg;
                }
            }
        });
        
        txtDataFinal.setVisible(false);
        labelDataFim.setVisible(false);
    }
    
    public void receberCodBarbearia(int CODBARBEARIA){
        this.CODBARBEARIA = CODBARBEARIA;
        listarExpedientes();
    }
    
    public void listarExpedientes(){
        ExpedienteDAO expedienteDao = new ExpedienteDAO();
        List<Expediente> expedientes = expedienteDao.read(CODBARBEARIA);
        
        String[] colunas = {"Data", "Inicio do Expediente", "Fim do Expediente"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
        
        Set<Date> datasAdicionadas = new HashSet<>();
        
        for (Expediente e : expedientes) {
            Date data = e.getDataInicial();
        
            if (!datasAdicionadas.contains(data)) {
                datasAdicionadas.add(data);
                
                Object[] row = {
                    data,
                    e.getHoraInicial(),
                    e.getHoraFinal()
                };
                tableModel.addRow(row);
            }
        }
        jTable1.setModel(tableModel);
    }
   
    public void cadastrarExpediente(){
        try {
            if(periodo==2){ //2 é por periodo
                String dataFinalString = txtDataFinal.getText(); 
                if ("  /  /    ".equals(dataFinalString)) {
                JOptionPane.showMessageDialog(null, "Preencha a data", "Mensagem", JOptionPane.ERROR_MESSAGE);
                return;
                }
                Date dataFinal = new Date(dataFormatada.parse(dataFinalString).getTime());
                modelExpediente.setDataFinal(dataFinal);
                modelExpediente.setPeriodo(2);
            }else{                
                modelExpediente.setPeriodo(1);
            }
            String dataInicialString = txtDataInicial.getText(); 
            
            String horaInicialString = txtHoraIni.getText(); 
            String horaFinalString = txtHoraFim.getText(); 
            
            if ("  :  ".equals(horaInicialString) || "  :  ".equals(horaFinalString)) {
                JOptionPane.showMessageDialog(null, "Preencha o horário", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return;
            }
            if ("  /  /    ".equals(dataInicialString)) {
                JOptionPane.showMessageDialog(null, "Preencha a data", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return;
            }
            //convertendo a String data para DATE
            Date dataInicial = new Date(dataFormatada.parse(dataInicialString).getTime());
            
            
            Date HorarioInicial = new Date(horaFormatada.parse(horaInicialString).getTime()); //TIME DATE
            Time horaInicial = new Time(HorarioInicial.getTime()); //Pegando o TIME da DATE
            
            Date HorarioFinal = new Date(horaFormatada.parse(horaFinalString).getTime()); //TIME DATE
            Time horaFinal = new Time(HorarioFinal.getTime()); //Pegando o TIME da DATE
            
            modelExpediente.setCodbarbearia(CODBARBEARIA);
            modelExpediente.setDataInicial(dataInicial);
            modelExpediente.setHoraInicial(horaInicial);
            modelExpediente.setHoraFinal(horaFinal);
            
            
            if(expedienteController.controller(modelExpediente)){
                txtDataInicial.setText("");
                txtDataFinal.setText("");
                txtHoraIni.setText("");
                txtHoraFim.setText("");
                listarExpedientes();
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(TelaExpediente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void alterarExpediente(){
        try {
            Date dataInicial = new Date(dataFormatada.parse(dataString).getTime());
            Date HorarioInicial = new Date(horaFormatada.parse(horaIniString).getTime()); //TIME DATE
            Date HorarioFinal = new Date(horaFormatada.parse(horaFimString).getTime()); //TIME DATE
            Time horaInicial = new Time(HorarioInicial.getTime()); //Pegando o TIME da DATE
            Time horaFinal = new Time(HorarioFinal.getTime()); //Pegando o TIME da DATE
            
            modelExpediente.setCodbarbearia(CODBARBEARIA);
            modelExpediente.setDataInicial(dataInicial);
            modelExpediente.setHoraInicial(horaInicial);
            modelExpediente.setHoraFinal(horaFinal);
            
            if(expedienteDao.removeExpediente(modelExpediente)){
                txtDataInicial.setEditable(true);
                txtHoraIni.setEditable(true);
                txtHoraFim.setEditable(true);
                cadastrarExpediente();
                txtDataInicial.setText("");
                txtDataFinal.setText("");
                txtHoraIni.setText("");
                txtHoraFim.setText("");             
            }
                    listarExpedientes();
        } catch (ParseException ex) {
            Logger.getLogger(TelaExpediente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void deletarExpediente(){
        try {
            String dataInicialString = txtDataInicial.getText(); 
            
            if ("  /  /    ".equals(dataInicialString)) {
                JOptionPane.showMessageDialog(null, "Preencha a data", "Mensagem", JOptionPane.ERROR_MESSAGE);
            return;
            }
            
            //convertendo a String data para DATE
            SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInicial = new Date(dataFormatada.parse(dataInicialString).getTime());
            
            
                String horaInicialString = txtHoraIni.getText(); 
                String horaFinalString = txtHoraFim.getText();
                if ("  :  ".equals(horaInicialString) || "  :  ".equals(horaFinalString)) {
                    JOptionPane.showMessageDialog(null, "Preencha o horário", "Mensagem", JOptionPane.ERROR_MESSAGE);
                return;
                }
                Date HorarioInicial = new Date(horaFormatada.parse(horaInicialString).getTime()); //TIME DATE
                Time horaInicial = new Time(HorarioInicial.getTime()); //Pegando o TIME da DATE

                Date HorarioFinal = new Date(horaFormatada.parse(horaFinalString).getTime()); //TIME DATE
                Time horaFinal = new Time(HorarioFinal.getTime()); //Pegando o TIME da DATE
                modelExpediente.setHoraInicial(horaInicial);
                modelExpediente.setHoraFinal(horaFinal);

            
            
            modelExpediente.setDataInicial(dataInicial);
            modelExpediente.setCodbarbearia(CODBARBEARIA);
            
            if(expedienteDao.removeExpediente(modelExpediente)){
                txtDataInicial.setText("");
                txtDataFinal.setText("");
                txtHoraIni.setText("");
                txtHoraFim.setText("");
                listarExpedientes();
            }
        } catch (ParseException ex) {
            Logger.getLogger(TelaExpediente.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new css.ScrollPaneWin11();
        jTable1 = new css.TableDark();
        labelExpedientes = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        labelFunExpediente = new javax.swing.JLabel();
        labelDataIni = new javax.swing.JLabel();
        txtDataInicial = new javax.swing.JFormattedTextField();
        labelDataFim = new javax.swing.JLabel();
        txtDataFinal = new javax.swing.JFormattedTextField();
        horarioInicio = new javax.swing.JLabel();
        txtHoraIni = new css.ArrendondarBordas();
        horarioFim = new javax.swing.JLabel();
        txtHoraFim = new css.ArrendondarBordas();
        btnCadastrar = new javax.swing.JButton();
        btnCadastrarPeriodo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Definir Expediente");
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(0, 51, 102));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 150));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 150));
        Cima.setPreferredSize(new java.awt.Dimension(1920, 150));

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_Barbeiro_valor.png"))); // NOI18N

        titulo.setFont(new java.awt.Font("Caladea", 1, 90)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Expediente");
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

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jTable1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Data", "Inicio do Expediente", "Fim do Expediente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Fim do Expediente");
        }

        labelExpedientes.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        labelExpedientes.setForeground(new java.awt.Color(255, 255, 255));
        labelExpedientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExpedientes.setText("Expedientes cadastrados");
        labelExpedientes.setBorder(new javax.swing.border.MatteBorder(null));

        btnAlterar.setBackground(new java.awt.Color(255, 204, 0));
        btnAlterar.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(0, 0, 0));
        btnAlterar.setText("Alterar");
        btnAlterar.setBorderPainted(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setBackground(new java.awt.Color(153, 0, 51));
        btnDeletar.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnDeletar.setForeground(new java.awt.Color(0, 0, 0));
        btnDeletar.setText("Deletar");
        btnDeletar.setBorderPainted(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
                    .addComponent(labelExpedientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(labelExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));

        labelFunExpediente.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        labelFunExpediente.setForeground(new java.awt.Color(0, 51, 102));
        labelFunExpediente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFunExpediente.setText("Cadastre aqui um novo expediente");
        labelFunExpediente.setBorder(new javax.swing.border.MatteBorder(null));

        labelDataIni.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        labelDataIni.setForeground(new java.awt.Color(0, 51, 102));
        labelDataIni.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataIni.setText("Data");

        txtDataInicial.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataInicial.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtDataInicial.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        BordaArredondada borda = new BordaArredondada(new Color(0, 51, 102), 3, 10);
        Border bordaInterna = BorderFactory.createEmptyBorder(0, 10, 0, 0);
        Border bordaComposta = BorderFactory.createCompoundBorder(borda, bordaInterna);

        txtDataInicial.setBackground(new Color(222, 222, 222, 222));
        txtDataInicial.setBorder(bordaComposta);

        labelDataFim.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        labelDataFim.setForeground(new java.awt.Color(0, 51, 102));
        labelDataFim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDataFim.setText("Data fim");

        txtDataFinal.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataFinal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataFinal.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtDataFinal.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtDataFinal.setBackground(new Color(222, 222, 222, 222));
        txtDataFinal.setBorder(bordaComposta);

        horarioInicio.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        horarioInicio.setForeground(new java.awt.Color(0, 51, 102));
        horarioInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horarioInicio.setText("Início do Expediente");

        txtHoraIni.setBorder(null);
        txtHoraIni.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHoraIni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraIni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraIni.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtHoraIni.setBackground(new Color(222, 222, 222, 222));
        txtHoraIni.setBorder(bordaComposta);

        horarioFim.setFont(new java.awt.Font("Caladea", 1, 24)); // NOI18N
        horarioFim.setForeground(new java.awt.Color(0, 51, 102));
        horarioFim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horarioFim.setText("Fim do Expediente");

        txtHoraFim.setBorder(null);
        txtHoraFim.setForeground(new java.awt.Color(0, 51, 102));
        try {
            txtHoraFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHoraFim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraFim.setFont(new java.awt.Font("DejaVu Sans Light", 0, 24)); // NOI18N
        txtHoraFim.setBackground(new Color(222, 222, 222, 222));
        txtHoraFim.setBorder(bordaComposta);

        btnCadastrar.setBackground(new java.awt.Color(0, 51, 102));
        btnCadastrar.setFont(new java.awt.Font("Caladea", 1, 36)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCadastrarPeriodo.setFont(new java.awt.Font("Caladea", 0, 24)); // NOI18N
        btnCadastrarPeriodo.setForeground(new java.awt.Color(0, 51, 102));
        btnCadastrarPeriodo.setText("Cadastrar um período");
        btnCadastrarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CentroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelFunExpediente)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtHoraIni)
                                    .addComponent(horarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(horarioFim, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(txtHoraFim)))
                            .addComponent(txtDataInicial)
                            .addComponent(labelDataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDataFinal)
                            .addComponent(labelDataIni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrarPeriodo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(196, Short.MAX_VALUE))))
        );
        CentroLayout.setVerticalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(labelFunExpediente)
                .addGap(51, 51, 51)
                .addComponent(labelDataIni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(labelDataFim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarPeriodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horarioInicio)
                    .addComponent(horarioFim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraIni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();
        if(linhaSelecionada==-1){
            JOptionPane.showMessageDialog(null, "Selecione um expediente.");
        }else{
            labelFunExpediente.setText("Alterar expediente");
            btnCadastrar.setText("Alterar");
            opcao=2;
            labelDataFim.setVisible(false);
            txtDataFinal.setVisible(false);
            btnCadastrarPeriodo.setVisible(false);
            labelDataIni.setText("Data");
            txtDataInicial.setText(dataString);
            txtHoraIni.setText(horaIniString);
            txtHoraFim.setText(horaFimString);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipalBarbearia TP = new TelaPrincipalBarbearia();
        TP.receberCodBarbearia(CODBARBEARIA);
        TP.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        switch (opcao) {
            case 1 -> cadastrarExpediente();
            case 2 -> alterarExpediente();
            default -> deletarExpediente();
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();
        if(linhaSelecionada==-1){
            JOptionPane.showMessageDialog(null, "Selecione um expediente.");
        }else{  
            labelFunExpediente.setText("Realmente deseja deletar o expediente?");
            btnCadastrar.setText("Deletar");
            opcao=3;
            labelDataFim.setVisible(false);
            txtDataFinal.setVisible(false);
            btnCadastrarPeriodo.setVisible(false);
            labelDataIni.setText("Data");
            txtDataInicial.setText(dataString);
            txtDataInicial.setEditable(false);
            txtHoraIni.setText(horaIniString);
            txtHoraIni.setEditable(false);
            txtHoraFim.setText(horaFimString);
            txtHoraFim.setEditable(false);
            txtDataInicial.setEditable(false);
            txtHoraIni.setEditable(false);
            txtHoraFim.setEditable(false);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnCadastrarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPeriodoActionPerformed
        if(btnCadastrarPeriodo.isSelected()){
            txtDataFinal.setVisible(true);
            labelDataFim.setVisible(true);
            labelDataIni.setText("Data Inicio");
            periodo = 2;
        }else{
            txtDataFinal.setVisible(false);
            labelDataFim.setVisible(false);
            labelDataIni.setText("Data");
            periodo = 1;
        }
    }//GEN-LAST:event_btnCadastrarPeriodoActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExpediente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new TelaExpediente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JRadioButton btnCadastrarPeriodo;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel horarioFim;
    private javax.swing.JLabel horarioInicio;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelDataFim;
    private javax.swing.JLabel labelDataIni;
    private javax.swing.JLabel labelExpedientes;
    private javax.swing.JLabel labelFunExpediente;
    private javax.swing.JLabel titulo;
    private javax.swing.JFormattedTextField txtDataFinal;
    private javax.swing.JFormattedTextField txtDataInicial;
    private javax.swing.JFormattedTextField txtHoraFim;
    private javax.swing.JFormattedTextField txtHoraIni;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/icone.png")));
    }
}
