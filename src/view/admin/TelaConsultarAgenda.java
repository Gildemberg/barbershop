package view.admin;

import dao.AgendamentoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Agendamento;

public class TelaConsultarAgenda extends javax.swing.JFrame {

    int COD_EMP;
    String NOME_EMP, horario;
    
    public TelaConsultarAgenda() {
        initComponents();
        
        Agendamento1.setVisible(false);
        Agendamento2.setVisible(false);
        Agendamento3.setVisible(false);
        Agendamento4.setVisible(false);
        Agendamento5.setVisible(false);
        Agendamento6.setVisible(false);
        Agendamento7.setVisible(false);
        Agendamento8.setVisible(false);
        Agendamento9.setVisible(false);
    }
    
    public void receberCodUsr(int TCE, String NOME_EMP, String horario){//receber o cod EMPRESA
        this.COD_EMP = TCE; //recebendo o cod emp]
        this.NOME_EMP = NOME_EMP;
        nome_emp.setText(NOME_EMP);
        this.horario = horario;
        dataAtual.setText(horario);
        consultarAgenda();
    }
    
    public void consultarAgenda(){
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        List<Agendamento> agendamentos = new ArrayList();
        agendamentos = agendDAO.readEmp(COD_EMP);
        if(!agendamentos.isEmpty()){//so executa se a lista nao tiver vazia
            if(agendamentos.size() >= 1){  //so executa se tiver um item     
                Agendamento1.setVisible(true);
                txtCliente1.setText(agendamentos.get(0).getNome_usr());
                txtHorario1.setText(agendamentos.get(0).getHora()+"h  "+ agendamentos.get(0).getData());
                btnConfirmar1.setText(String.valueOf(agendamentos.get(0).getId()));
                txtCod_usr1.setText(String.valueOf(agendamentos.get(0).getCod_usr()));
            }else{
                Agendamento1.setVisible(false);
                txtCliente1.setText("");
                txtHorario1.setText("");
                btnConfirmar1.setText("");
                txtCod_usr1.setText("");
            } if(agendamentos.size() >= 2){ //so executa se tiver dois item             
                Agendamento2.setVisible(true);
                txtCliente2.setText(agendamentos.get(1).getNome_usr());
                txtHorario2.setText(agendamentos.get(1).getHora()+"h  "+ agendamentos.get(1).getData());
                btnConfirmar2.setText(String.valueOf(agendamentos.get(1).getId()));
                txtCod_usr2.setText(String.valueOf(agendamentos.get(1).getCod_usr()));
            }else{
                Agendamento2.setVisible(false);
                txtCliente2.setText("");
                txtHorario2.setText("");
                btnConfirmar2.setText("");
                txtCod_usr2.setText("");
            }if(agendamentos.size() >= 3){ //so executa se tiver tres item                    
                Agendamento3.setVisible(true);
                txtCliente3.setText(agendamentos.get(2).getNome_usr());
                txtHorario3.setText(agendamentos.get(2).getHora()+"h  "+ agendamentos.get(2).getData());
                btnConfirmar3.setText(String.valueOf(agendamentos.get(2).getId()));
                txtCod_usr3.setText(String.valueOf(agendamentos.get(2).getCod_usr()));
            }else{
                Agendamento3.setVisible(false);
                txtCliente3.setText("");
                txtHorario3.setText("");
                btnConfirmar3.setText("");
                txtCod_usr3.setText("");
            } if(agendamentos.size() >= 4){ //so executa se tiver tres item                    
                Agendamento4.setVisible(true);
                txtCliente4.setText(agendamentos.get(3).getNome_usr());
                txtHorario4.setText(agendamentos.get(3).getHora()+"h  "+ agendamentos.get(3).getData());
                btnConfirmar4.setText(String.valueOf(agendamentos.get(3).getId()));
                txtCod_usr4.setText(String.valueOf(agendamentos.get(3).getCod_usr()));
            }else{
                Agendamento4.setVisible(false);
                txtCliente4.setText("");
                txtHorario4.setText("");
                btnConfirmar4.setText("");
                txtCod_usr4.setText("");
            }if(agendamentos.size() >= 5){ //so executa se tiver tres item                    
                Agendamento5.setVisible(true);
                txtCliente5.setText(agendamentos.get(4).getNome_usr());
                txtHorario5.setText(agendamentos.get(4).getHora()+"h  "+ agendamentos.get(4).getData());
                btnConfirmar5.setText(String.valueOf(agendamentos.get(4).getId()));
                txtCod_usr5.setText(String.valueOf(agendamentos.get(4).getCod_usr()));
            }else{
                Agendamento5.setVisible(false);
                txtCliente5.setText("");
                txtHorario5.setText("");
                btnConfirmar5.setText("");
                txtCod_usr5.setText("");
            }if(agendamentos.size() >= 6){ //so executa se tiver tres item                    
                Agendamento6.setVisible(true);
                txtCliente6.setText(agendamentos.get(5).getNome_usr());
                txtHorario6.setText(agendamentos.get(5).getHora()+"h  "+ agendamentos.get(5).getData());
                btnConfirmar6.setText(String.valueOf(agendamentos.get(5).getId()));
                txtCod_usr6.setText(String.valueOf(agendamentos.get(5).getCod_usr()));
            }else{
                Agendamento6.setVisible(false);
                txtCliente6.setText("");
                txtHorario6.setText("");
                btnConfirmar6.setText("");
                txtCod_usr6.setText("");
            }
        }
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
        nome_emp = new javax.swing.JLabel();
        localizacao = new javax.swing.JLabel();
        Agendamento1 = new javax.swing.JPanel();
        txtCliente1 = new javax.swing.JLabel();
        txtHorario1 = new javax.swing.JLabel();
        btnConfirmar1 = new javax.swing.JLabel();
        txtCod_usr1 = new javax.swing.JLabel();
        Agendamento2 = new javax.swing.JPanel();
        txtCliente2 = new javax.swing.JLabel();
        txtHorario2 = new javax.swing.JLabel();
        btnConfirmar2 = new javax.swing.JLabel();
        txtCod_usr2 = new javax.swing.JLabel();
        Agendamento3 = new javax.swing.JPanel();
        txtCliente3 = new javax.swing.JLabel();
        txtHorario3 = new javax.swing.JLabel();
        btnConfirmar3 = new javax.swing.JLabel();
        txtCod_usr3 = new javax.swing.JLabel();
        Agendamento4 = new javax.swing.JPanel();
        txtCliente4 = new javax.swing.JLabel();
        txtHorario4 = new javax.swing.JLabel();
        btnConfirmar4 = new javax.swing.JLabel();
        txtCod_usr4 = new javax.swing.JLabel();
        Agendamento5 = new javax.swing.JPanel();
        txtCliente5 = new javax.swing.JLabel();
        txtHorario5 = new javax.swing.JLabel();
        btnConfirmar5 = new javax.swing.JLabel();
        txtCod_usr5 = new javax.swing.JLabel();
        Agendamento6 = new javax.swing.JPanel();
        txtCliente6 = new javax.swing.JLabel();
        txtHorario6 = new javax.swing.JLabel();
        btnConfirmar6 = new javax.swing.JLabel();
        txtCod_usr6 = new javax.swing.JLabel();
        Agendamento7 = new javax.swing.JPanel();
        txtCliente7 = new javax.swing.JLabel();
        txtHorario7 = new javax.swing.JLabel();
        btnConfirmar7 = new javax.swing.JLabel();
        txtCod_usr7 = new javax.swing.JLabel();
        Agendamento8 = new javax.swing.JPanel();
        txtCliente8 = new javax.swing.JLabel();
        txtHorario8 = new javax.swing.JLabel();
        btnConfirmar8 = new javax.swing.JLabel();
        txtCod_usr8 = new javax.swing.JLabel();
        Agendamento9 = new javax.swing.JPanel();
        txtCliente9 = new javax.swing.JLabel();
        txtHorario9 = new javax.swing.JLabel();
        btnConfirmar9 = new javax.swing.JLabel();
        txtCod_usr9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));

        Cima.setBackground(new java.awt.Color(29, 93, 183));
        Cima.setMaximumSize(new java.awt.Dimension(1920, 100));
        Cima.setMinimumSize(new java.awt.Dimension(1920, 100));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1154, Short.MAX_VALUE)
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

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_user.png"))); // NOI18N

        ola.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        ola.setForeground(new java.awt.Color(0, 51, 204));
        ola.setText("Olá,");

        nome_emp.setFont(new java.awt.Font("Mongolian Baiti", 0, 24)); // NOI18N
        nome_emp.setForeground(new java.awt.Color(0, 51, 204));
        nome_emp.setBorder(new javax.swing.border.MatteBorder(null));

        localizacao.setFont(new java.awt.Font("Mongolian Baiti", 0, 18)); // NOI18N
        localizacao.setForeground(new java.awt.Color(0, 51, 204));
        localizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone_local.png"))); // NOI18N
        localizacao.setText("Paulo Afonso - BA");

        Agendamento1.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento1.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente1.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente1.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente1.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario1.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario1.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario1.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar1.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar1MouseClicked(evt);
            }
        });

        txtCod_usr1.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr1.setText("jLabel2");
        txtCod_usr1.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr1.setFocusable(false);
        txtCod_usr1.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr1.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr1.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento1Layout = new javax.swing.GroupLayout(Agendamento1);
        Agendamento1.setLayout(Agendamento1Layout);
        Agendamento1Layout.setHorizontalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                    .addComponent(txtHorario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar1)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento1Layout.setVerticalGroup(
            Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento1Layout.createSequentialGroup()
                .addComponent(txtCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Agendamento1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod_usr1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento2.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento2.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente2.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente2.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente2.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario2.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario2.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario2.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar2.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar2MouseClicked(evt);
            }
        });

        txtCod_usr2.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr2.setText("jLabel2");
        txtCod_usr2.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr2.setFocusable(false);
        txtCod_usr2.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr2.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr2.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento2Layout = new javax.swing.GroupLayout(Agendamento2);
        Agendamento2.setLayout(Agendamento2Layout);
        Agendamento2Layout.setHorizontalGroup(
            Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar2)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento2Layout.setVerticalGroup(
            Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento2Layout.createSequentialGroup()
                .addComponent(txtCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCod_usr2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento3.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento3.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente3.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente3.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente3.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario3.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario3.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario3.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar3.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar3MouseClicked(evt);
            }
        });

        txtCod_usr3.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr3.setText("jLabel2");
        txtCod_usr3.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr3.setFocusable(false);
        txtCod_usr3.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr3.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr3.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento3Layout = new javax.swing.GroupLayout(Agendamento3);
        Agendamento3.setLayout(Agendamento3Layout);
        Agendamento3Layout.setHorizontalGroup(
            Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar3)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento3Layout.setVerticalGroup(
            Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento3Layout.createSequentialGroup()
                .addComponent(txtCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(Agendamento3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod_usr3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento4.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento4.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente4.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente4.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente4.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario4.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario4.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario4.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar4.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar4MouseClicked(evt);
            }
        });

        txtCod_usr4.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr4.setText("jLabel2");
        txtCod_usr4.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr4.setFocusable(false);
        txtCod_usr4.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr4.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr4.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento4Layout = new javax.swing.GroupLayout(Agendamento4);
        Agendamento4.setLayout(Agendamento4Layout);
        Agendamento4Layout.setHorizontalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar4)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento4Layout.setVerticalGroup(
            Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento4Layout.createSequentialGroup()
                .addComponent(txtCliente4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Agendamento4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod_usr4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento5.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento5.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente5.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente5.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente5.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario5.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario5.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario5.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar5.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar5MouseClicked(evt);
            }
        });

        txtCod_usr5.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr5.setText("jLabel2");
        txtCod_usr5.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr5.setFocusable(false);
        txtCod_usr5.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr5.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr5.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento5Layout = new javax.swing.GroupLayout(Agendamento5);
        Agendamento5.setLayout(Agendamento5Layout);
        Agendamento5Layout.setHorizontalGroup(
            Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar5)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento5Layout.setVerticalGroup(
            Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento5Layout.createSequentialGroup()
                .addComponent(txtCliente5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCod_usr5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento6.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento6.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente6.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente6.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente6.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario6.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario6.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario6.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar6.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar6MouseClicked(evt);
            }
        });

        txtCod_usr6.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr6.setText("jLabel2");
        txtCod_usr6.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr6.setFocusable(false);
        txtCod_usr6.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr6.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr6.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento6Layout = new javax.swing.GroupLayout(Agendamento6);
        Agendamento6.setLayout(Agendamento6Layout);
        Agendamento6Layout.setHorizontalGroup(
            Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar6)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento6Layout.setVerticalGroup(
            Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento6Layout.createSequentialGroup()
                .addComponent(txtCliente6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Agendamento6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod_usr6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento7.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento7.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente7.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente7.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente7.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario7.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario7.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario7.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar7.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar7MouseClicked(evt);
            }
        });

        txtCod_usr7.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr7.setText("jLabel2");
        txtCod_usr7.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr7.setFocusable(false);
        txtCod_usr7.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr7.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr7.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento7Layout = new javax.swing.GroupLayout(Agendamento7);
        Agendamento7.setLayout(Agendamento7Layout);
        Agendamento7Layout.setHorizontalGroup(
            Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar7)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento7Layout.setVerticalGroup(
            Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento7Layout.createSequentialGroup()
                .addComponent(txtCliente7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Agendamento7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCod_usr7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento8.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento8.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente8.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente8.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente8.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario8.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario8.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario8.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar8.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar8MouseClicked(evt);
            }
        });

        txtCod_usr8.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr8.setText("jLabel2");
        txtCod_usr8.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr8.setFocusable(false);
        txtCod_usr8.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr8.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr8.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento8Layout = new javax.swing.GroupLayout(Agendamento8);
        Agendamento8.setLayout(Agendamento8Layout);
        Agendamento8Layout.setHorizontalGroup(
            Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar8)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento8Layout.setVerticalGroup(
            Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento8Layout.createSequentialGroup()
                .addComponent(txtCliente8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCod_usr8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Agendamento9.setBackground(new java.awt.Color(30, 144, 255));
        Agendamento9.setForeground(new java.awt.Color(255, 255, 255));

        txtCliente9.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        txtCliente9.setForeground(new java.awt.Color(255, 255, 255));
        txtCliente9.setBorder(new javax.swing.border.MatteBorder(null));

        txtHorario9.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        txtHorario9.setForeground(new java.awt.Color(255, 255, 255));
        txtHorario9.setBorder(new javax.swing.border.MatteBorder(null));

        btnConfirmar9.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        btnConfirmar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/confirmar.png"))); // NOI18N
        btnConfirmar9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmar9MouseClicked(evt);
            }
        });

        txtCod_usr9.setFont(new java.awt.Font("Dialog", 0, 1)); // NOI18N
        txtCod_usr9.setText("jLabel2");
        txtCod_usr9.setBorder(new javax.swing.border.MatteBorder(null));
        txtCod_usr9.setFocusable(false);
        txtCod_usr9.setMaximumSize(new java.awt.Dimension(0, 0));
        txtCod_usr9.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCod_usr9.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout Agendamento9Layout = new javax.swing.GroupLayout(Agendamento9);
        Agendamento9.setLayout(Agendamento9Layout);
        Agendamento9Layout.setHorizontalGroup(
            Agendamento9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Agendamento9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorario9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar9)
                .addGap(18, 18, 18)
                .addComponent(txtCod_usr9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Agendamento9Layout.setVerticalGroup(
            Agendamento9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento9Layout.createSequentialGroup()
                .addComponent(txtCliente9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHorario9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Agendamento9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Agendamento9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCod_usr9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout CentroLayout = new javax.swing.GroupLayout(Centro);
        Centro.setLayout(CentroLayout);
        CentroLayout.setHorizontalGroup(
            CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CentroLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CentroLayout.createSequentialGroup()
                        .addComponent(img)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CentroLayout.createSequentialGroup()
                                .addComponent(ola)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nome_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(localizacao)))
                    .addComponent(Agendamento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Agendamento9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(nome_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localizacao)))
                .addGap(68, 68, 68)
                .addComponent(Agendamento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agendamento9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Centro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        this.dispose();
        new TelaAdmin().setVisible(true);
    }//GEN-LAST:event_sairMouseClicked

    private void btnConfirmar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar1MouseClicked
        int AGEND_COD = Integer.parseInt(btnConfirmar1.getText());
        AgendamentoDAO agendDAO = new AgendamentoDAO();
        //agendDAO.delete(AGEND_COD);
    }//GEN-LAST:event_btnConfirmar1MouseClicked

    private void btnConfirmar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar2MouseClicked

    }//GEN-LAST:event_btnConfirmar2MouseClicked

    private void btnConfirmar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar3MouseClicked
        
    }//GEN-LAST:event_btnConfirmar3MouseClicked

    private void btnConfirmar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmar4MouseClicked

    private void btnConfirmar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmar5MouseClicked

    private void btnConfirmar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmar6MouseClicked

    private void btnConfirmar7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmar7MouseClicked

    private void btnConfirmar8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmar8MouseClicked

    private void btnConfirmar9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmar9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConfirmar9MouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultarAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agendamento1;
    private javax.swing.JPanel Agendamento10;
    private javax.swing.JPanel Agendamento2;
    private javax.swing.JPanel Agendamento3;
    private javax.swing.JPanel Agendamento4;
    private javax.swing.JPanel Agendamento5;
    private javax.swing.JPanel Agendamento6;
    private javax.swing.JPanel Agendamento7;
    private javax.swing.JPanel Agendamento8;
    private javax.swing.JPanel Agendamento9;
    private javax.swing.JPanel Centro;
    private javax.swing.JPanel Cima;
    private javax.swing.JLabel btnConfirmar1;
    private javax.swing.JLabel btnConfirmar10;
    private javax.swing.JLabel btnConfirmar2;
    private javax.swing.JLabel btnConfirmar3;
    private javax.swing.JLabel btnConfirmar4;
    private javax.swing.JLabel btnConfirmar5;
    private javax.swing.JLabel btnConfirmar6;
    private javax.swing.JLabel btnConfirmar7;
    private javax.swing.JLabel btnConfirmar8;
    private javax.swing.JLabel btnConfirmar9;
    private javax.swing.JLabel dataAtual;
    private javax.swing.JLabel img;
    private javax.swing.JLabel localizacao;
    private javax.swing.JLabel nome_emp;
    private javax.swing.JLabel ola;
    private javax.swing.JLabel sair;
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
    private javax.swing.JLabel txtCod_usr1;
    private javax.swing.JLabel txtCod_usr2;
    private javax.swing.JLabel txtCod_usr3;
    private javax.swing.JLabel txtCod_usr4;
    private javax.swing.JLabel txtCod_usr5;
    private javax.swing.JLabel txtCod_usr6;
    private javax.swing.JLabel txtCod_usr7;
    private javax.swing.JLabel txtCod_usr8;
    private javax.swing.JLabel txtCod_usr9;
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
    // End of variables declaration//GEN-END:variables
}
