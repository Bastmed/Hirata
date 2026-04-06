package Views;

import Model.RegistrarKm;
import Db.RegistrarKmDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.RegisCamion;
import Db.CamionDao;
import Db.ConductorDao;
import Db.Conexion;
import Model.RegisMantenimiento;
import Db.MantenimientoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CamionVisual extends javax.swing.JFrame {

    public CamionVisual() {
        initComponents();

        // Cargar tablas principales
        cargarTablaCamiones();
        cargarTablaKm();
        cargarTablaConductores();
        cargarTablaMantenimiento();

        // Configurar eventos de selección en tablas
        configurarEventosTabla();
        configurarEventosTablaKm();
        configurarEventosTablaCamiones();
        configurarEventosTablaConductores();
        

        // Llenar combo de conductores desde BD
        cargarConductoresEnCombo();

        // Ajustes de campos
        

        // Timer que actualiza cada 1 segundo
        timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                cargarTablaCamiones();
                cargarTablaKm();
                cargarTablaMantenimiento();
            }
        });
        timer.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblNombreConducRegis = new javax.swing.JLabel();
        lblRutConducRegis = new javax.swing.JLabel();
        txtRutConRegis = new javax.swing.JTextField();
        txtNombreConRegis = new javax.swing.JTextField();
        JSpaneConduc = new javax.swing.JScrollPane();
        JtableConduc = new javax.swing.JTable();
        btnSalirConduc = new javax.swing.JButton();
        btnRegistrarConductor = new javax.swing.JButton();
        btnEliminarConductor = new javax.swing.JButton();
        btnActualizarConductor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jpanelRegistroCam = new javax.swing.JLayeredPane();
        JSpaneCam = new javax.swing.JScrollPane();
        jTableCam = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtMarcaCam = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtModeloCam = new javax.swing.JTextPane();
        btnregistrarCam = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtPatenteCam = new javax.swing.JTextPane();
        lblconductorCam = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtAnioCam = new javax.swing.JTextPane();
        lblmarcaCam = new javax.swing.JLabel();
        lblmodeloCam = new javax.swing.JLabel();
        lblanioCam = new javax.swing.JLabel();
        lblpatenteCam = new javax.swing.JLabel();
        btnactualizarCam = new javax.swing.JButton();
        btneliminarCam = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        comboConductores = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtGasolina = new javax.swing.JTextPane();
        lblGasolina = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        JSpaneKm = new javax.swing.JScrollPane();
        JTableKm = new javax.swing.JTable();
        btnRegistrarKm = new javax.swing.JButton();
        lblKilometraje = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtKilometrajeKm = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtPatenteKm = new javax.swing.JTextPane();
        lblPatenteKm = new javax.swing.JLabel();
        btnSalirKm = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCamionMant = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPatenteMant = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtTipo = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        btnSalirMan = new javax.swing.JButton();
        btnActualizarMan = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableMan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtKmMant = new javax.swing.JTextPane();
        jDateMan = new com.toedter.calendar.JDateChooser();
        btnAgregarMan = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreConducRegis.setText("Nombre:");
        jLayeredPane1.add(lblNombreConducRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lblRutConducRegis.setText("Rut:");
        jLayeredPane1.add(lblRutConducRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jLayeredPane1.add(txtRutConRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 90, -1));
        jLayeredPane1.add(txtNombreConRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 90, -1));

        JtableConduc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JSpaneConduc.setViewportView(JtableConduc);

        jLayeredPane1.add(JSpaneConduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 530, 380));

        btnSalirConduc.setText("Salir");
        btnSalirConduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirConducActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnSalirConduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        btnRegistrarConductor.setText("Registrar");
        btnRegistrarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarConductorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnRegistrarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        btnEliminarConductor.setText("Eliminar");
        btnEliminarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConductorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnEliminarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        btnActualizarConductor.setText("Actualizar");
        btnActualizarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarConductorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnActualizarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        jTabbedPane1.addTab("Gestionar Conductores", jPanel3);

        jpanelRegistroCam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JSpaneCam.setViewportView(jTableCam);

        jpanelRegistroCam.add(JSpaneCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 680, 380));

        jScrollPane9.setViewportView(txtMarcaCam);

        jpanelRegistroCam.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 110, -1));

        jScrollPane10.setViewportView(txtModeloCam);

        jpanelRegistroCam.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 110, -1));

        btnregistrarCam.setText("Registrar");
        btnregistrarCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarCamActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(btnregistrarCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jScrollPane13.setViewportView(txtPatenteCam);

        jpanelRegistroCam.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 110, -1));

        lblconductorCam.setText("Conductor");
        jpanelRegistroCam.add(lblconductorCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jScrollPane11.setViewportView(txtAnioCam);

        jpanelRegistroCam.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 110, -1));

        lblmarcaCam.setText("Marca:");
        jpanelRegistroCam.add(lblmarcaCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lblmodeloCam.setText("Modelo");
        jpanelRegistroCam.add(lblmodeloCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lblanioCam.setText("Año");
        jpanelRegistroCam.add(lblanioCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lblpatenteCam.setText("Patente:");
        jpanelRegistroCam.add(lblpatenteCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        btnactualizarCam.setText("Actualizar");
        btnactualizarCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarCamActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(btnactualizarCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        btneliminarCam.setText("Eliminar");
        btneliminarCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarCamActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(btneliminarCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 80, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 80, -1));

        comboConductores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboConductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConductoresActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(comboConductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 110, -1));

        jScrollPane12.setViewportView(txtGasolina);

        jpanelRegistroCam.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 110, -1));

        lblGasolina.setText("Gasolina");
        jpanelRegistroCam.add(lblGasolina, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpanelRegistroCam, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpanelRegistroCam, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro camiones", jPanel1);

        jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableKm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JSpaneKm.setViewportView(JTableKm);

        jLayeredPane3.add(JSpaneKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 550, 380));

        btnRegistrarKm.setText("Actualizar");
        btnRegistrarKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarKmActionPerformed(evt);
            }
        });
        jLayeredPane3.add(btnRegistrarKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        lblKilometraje.setText("Kilometraje:");
        jLayeredPane3.add(lblKilometraje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jScrollPane8.setViewportView(txtKilometrajeKm);

        jLayeredPane3.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 120, -1));

        jScrollPane15.setViewportView(txtPatenteKm);

        jLayeredPane3.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 120, -1));

        lblPatenteKm.setText("Patente:");
        jLayeredPane3.add(lblPatenteKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        btnSalirKm.setText("Salir");
        btnSalirKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirKmActionPerformed(evt);
            }
        });
        jLayeredPane3.add(btnSalirKm, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 80, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Registrar km", jPanel2);

        jLabel1.setText("Camion:");

        jLabel2.setText("Patente:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Descripcion:");

        jScrollPane1.setViewportView(txtCamionMant);

        jScrollPane2.setViewportView(txtPatenteMant);

        jScrollPane4.setViewportView(txtTipo);

        jScrollPane5.setViewportView(txtDescripcion);

        btnSalirMan.setText("Salir");
        btnSalirMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirManActionPerformed(evt);
            }
        });

        btnActualizarMan.setText("Actualizar");
        btnActualizarMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarManActionPerformed(evt);
            }
        });

        jTableMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableManMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableMan);

        jLabel6.setText("Kilometraje:");

        jScrollPane7.setViewportView(txtKmMant);

        btnAgregarMan.setText("Agregar");
        btnAgregarMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarManActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");

        jLayeredPane4.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnSalirMan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnActualizarMan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jDateMan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnAgregarMan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(46, 46, 46)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane7)))
                        .addGap(73, 73, 73))
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(55, 55, 55)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                                .addComponent(jDateMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizarMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalirMan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDateMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarMan)
                    .addComponent(btnAgregarMan))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalirMan)
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4)
        );

        jTabbedPane1.addTab("Mantenimiento", jPanel4);

        jLayeredPane2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Variables
    private String patenteOriginalSeleccionada = null;
    private int idCamionSeleccionado = -1;
    private int idConductorSeleccionado = -1;
    private java.util.Map<Integer, Integer> temperaturaMap = new java.util.HashMap<>();
    private java.util.Map<Integer, Integer> gasolinaMap = new java.util.HashMap<>();
    private javax.swing.Timer timer;
    private java.util.Map<Integer, Boolean> alertaMostrada = new java.util.HashMap<>();
    private java.util.Map<Integer, Integer> kilometrajeMap = new java.util.HashMap<>();
    private java.util.Map<Integer, Boolean> alertaGasolinaMostrada = new java.util.HashMap<>();

    

// Cargar tabla de conductores con nombre y RUT
    protected CamionDao crearCamionDao() {
        return new CamionDao();
    }

    private void resetearTodo() {

        //  TABLAS
        if (jTableCam != null) {
            jTableCam.clearSelection();
        }
        if (JtableConduc != null) {
            JtableConduc.clearSelection();
        }
        if (JTableKm != null) {
            JTableKm.clearSelection(); // si tienes
        }
        //  VARIABLES
        idCamionSeleccionado = -1;
        idConductorSeleccionado = -1; // si usas esta

        // CAMPOS CAMIONES
        txtPatenteCam.setText("");
        txtMarcaCam.setText("");
        txtModeloCam.setText("");
        txtAnioCam.setText("");

        //  CAMPOS CONDUCTORES
        txtNombreConRegis.setText("");
        txtRutConRegis.setText("");

        //CAMPOS KM (si tienes)
        txtKmMant.setText("");

        // COMBOBOX
        if (comboConductores != null) {
            comboConductores.setSelectedIndex(-1);
        }
    }

    private void cargarTablaConductores() {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("RUT");

        try {
            Db.ConductorDao dao = new Db.ConductorDao();
            java.util.List<String[]> lista = dao.listarConductoresCompleto();

            for (String[] fila : lista) {
                modelo.addRow(new Object[]{fila[0], fila[1], fila[2]});
            }

            JtableConduc.setModel(modelo);

            // ocultar ID
            JtableConduc.getColumnModel().getColumn(0).setMinWidth(0);
            JtableConduc.getColumnModel().getColumn(0).setMaxWidth(0);
            JtableConduc.getColumnModel().getColumn(0).setWidth(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar conductores:\n" + ex.getMessage(),
                    "Error BD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarConductoresEnCombo() {
        comboConductores.removeAllItems();
        try {
            ConductorDao dao = new ConductorDao();
            java.util.List<String> lista = dao.listarNombresConductores();
            for (String nombre : lista) {
                comboConductores.addItem(nombre);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar conductores:\n" + ex.getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configurarEventosTablaCamiones() {

        jTableCam.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {

                int fila = jTableCam.getSelectedRow();

                if (fila != -1) {

                    String patente = jTableCam.getValueAt(fila, 0).toString();

                    txtPatenteMant.setText(patente);
                }
            }
        });
    }

    private void configurarEventosTabla() {
        jTableCam.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = jTableCam.getSelectedRow();
                if (fila >= 0) {
                    // idCamion está en la columna 0 (oculta)
                    Object idObj = jTableCam.getValueAt(fila, 0);
                    if (idObj != null) {
                        try {
                            idCamionSeleccionado = Integer.parseInt(idObj.toString());
                        } catch (NumberFormatException e) {
                            idCamionSeleccionado = -1;
                        }
                    } else {
                        idCamionSeleccionado = -1;
                    }

                    String patente = jTableCam.getValueAt(fila, 1) != null ? jTableCam.getValueAt(fila, 1).toString() : "";
                    String marca = jTableCam.getValueAt(fila, 2) != null ? jTableCam.getValueAt(fila, 2).toString() : "";
                    String modelo = jTableCam.getValueAt(fila, 3) != null ? jTableCam.getValueAt(fila, 3).toString() : "";
                    String anio = jTableCam.getValueAt(fila, 4) != null ? jTableCam.getValueAt(fila, 4).toString() : "";
                    String kilometraje = jTableCam.getValueAt(fila, 5) != null ? jTableCam.getValueAt(fila, 5).toString() : "";
                    String conductor = jTableCam.getValueAt(fila, 6) != null ? jTableCam.getValueAt(fila, 6).toString() : "";

                    // Cargar en los JTextPane (patente editable)
                    txtPatenteCam.setText(patente);
                    txtMarcaCam.setText(marca);
                    txtModeloCam.setText(modelo);
                    txtAnioCam.setText(anio);
                    comboConductores.setSelectedItem(conductor);

                }
            }
        });
    }

    private void cargarTablaCamiones() {

        int filaSeleccionada = jTableCam.getSelectedRow();

        CamionDao dao = new CamionDao();

        try {
            java.util.List<Model.RegisCamion> lista = dao.listarTodos();

            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            modelo.addColumn("idCamion");
            modelo.addColumn("Patente");
            modelo.addColumn("Marca");
            modelo.addColumn("Modelo");
            modelo.addColumn("Año");
            modelo.addColumn("Kilometraje");
            modelo.addColumn("Conductor");
            modelo.addColumn("Motor °C");
            modelo.addColumn("Gasolina L");

            for (Model.RegisCamion c : lista) {

                int id = c.getIdCamion();

                // TEMPERATURA (simulación con límite)
                int temp = temperaturaMap.getOrDefault(id, 20);
                temp += 10;

                //limitar la temperatura
                if (temp > 120) {
                    temp = 120; // se queda en el máximo permitido
                }

                temperaturaMap.put(id, temp);

                //GASOLINA (solo baja si existe, no reinicia sola)
                int gasolina = gasolinaMap.getOrDefault(id, -1);

                if (gasolina == -1) {
                    gasolina = 100; // valor inicial solo la primera vez
                } else {
                    gasolina -= 3;
                    if (gasolina < 0) {
                        gasolina = 0;
                    }
                }

                gasolinaMap.put(id, gasolina);

                // alerta solo una vez hasta que se reinicie manualmente
                boolean yaMostrada = alertaMostrada.getOrDefault(id, false);

                if (temp >= 100) {
                    if (!yaMostrada) {
                        JOptionPane.showMessageDialog(this,
                                "Temperatura alta en camión " + c.getPatente() + ": " + temp + "°C");
                        alertaMostrada.put(id, true);
                    }
                } else {
                    alertaMostrada.put(id, false);
                }
                
                // alerta solo una vez hasta que se reinicie pero para gasolina
                boolean yaMostradaB = alertaGasolinaMostrada.getOrDefault(id,false);
                
                if (gasolina <= 0){
                    if (!yaMostradaB){
                        JOptionPane.showMessageDialog(this,
                                "El camion con patente " + c.getPatente() + ": " + "Se quedo sin gasolina");
                        alertaGasolinaMostrada.put(id, true);
                    
                    }
                    else{
                        alertaGasolinaMostrada.put(id, false);
                    }
                
                }

                modelo.addRow(new Object[]{
                    c.getIdCamion(),
                    c.getPatente(),
                    c.getMarca(),
                    c.getModelo(),
                    c.getAnio(),
                    c.getKilometraje(),
                    c.getNombreConductor(),
                    temp,
                    gasolina
                });
            }

            jTableCam.setModel(modelo);

            // restaurar selección
            if (filaSeleccionada != -1 && filaSeleccionada < jTableCam.getRowCount()) {
                jTableCam.setRowSelectionInterval(filaSeleccionada, filaSeleccionada);
            }

            // ocultar id
            if (jTableCam.getColumnModel().getColumnCount() > 0) {
                jTableCam.getColumnModel().getColumn(0).setMinWidth(0);
                jTableCam.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableCam.getColumnModel().getColumn(0).setWidth(0);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar camiones:\n" + ex.getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public void verificarMantenimiento() {
        CamionDao dao = crearCamionDao();

        try {
            List<RegisCamion> lista = dao.listarTodos();

            for (RegisCamion c : lista) {
                int km = c.getKilometraje();
                System.out.println("Camión " + c.getPatente() + " tiene " + km + " km");

                if (km >= 5000) {
                // Inserta alerta simple
                    String sql = "INSERT INTO alertas_mantenimiento (id_camion, kilometraje) VALUES (?, ?)";

                    try (Connection con = Conexion.conectarDb();
                        PreparedStatement ps = con.prepareStatement(sql)) {
                        ps.setInt(1, c.getIdCamion());
                        ps.setInt(2, km);
                        ps.executeUpdate();
                    }

                // Mostrar alerta visual
                    JOptionPane.showMessageDialog(null,
                            "Camión " + c.getPatente() +
                            " tiene " + km + " km.\nMantenimiento requerido.",
                            "Alerta",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Error:\n" + ex.getMessage());
        }

    }


    private void btnregistrarCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarCamActionPerformed

        String conductor = (String) comboConductores.getSelectedItem();
        String patente = txtPatenteCam.getText().trim();
        String marca = txtMarcaCam.getText().trim();
        String modelo = txtModeloCam.getText().trim();
        String anioStr = txtAnioCam.getText().trim();
        String gasolinaStr = txtGasolina.getText().trim();

        // validar campos
        if (conductor == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un conductor.");
            return;
        }

        if (patente.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresa patente.");
            return;
        }

        if (marca.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresa marca.");
            return;
        }

        if (modelo.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresa modelo.");
            return;
        }

        if (anioStr.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresa año.");
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "El año debe ser número.");
            return;
        }

        // gasolina
        int gasolina = 100;
        try {
            gasolina = Integer.parseInt(gasolinaStr);
        } catch (Exception e) {
            gasolina = 100;
        }

        RegisCamion c = new RegisCamion();
        c.setPatente(patente);
        c.setMarca(marca);
        c.setModelo(modelo);
        c.setAnio(anio);
        c.setNombreConductor(conductor);

        CamionDao dao = new CamionDao();

        try {
            dao.insertar(c);

            // recargar para obtener ID
            java.util.List<Model.RegisCamion> lista = dao.listarTodos();

            for (Model.RegisCamion cam : lista) {
                if (cam.getPatente().equals(patente)) {
                    gasolinaMap.put(cam.getIdCamion(), gasolina);
                    break;
                }
            }

            JOptionPane.showMessageDialog(this, "Camión registrado.");

            cargarTablaCamiones();
            cargarTablaKm();

            txtPatenteCam.setText("");
            txtMarcaCam.setText("");
            txtModeloCam.setText("");
            txtAnioCam.setText("");
            txtGasolina.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error:\n" + ex.getMessage());
        }
    }//GEN-LAST:event_btnregistrarCamActionPerformed
    private void cargarTablaKm() {
        Db.CamionDao dao = new Db.CamionDao();
        try {
            java.util.List<Model.RegisCamion> lista = dao.listarTodos();

            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
            modelo.addColumn("Patente");
            modelo.addColumn("Marca");
            modelo.addColumn("Modelo");
            modelo.addColumn("Año");
            modelo.addColumn("Kilometraje");
            modelo.addColumn("Conductor");

            for (Model.RegisCamion c : lista) {
              
                int id = c.getIdCamion();
                // Obtener kilometraje actual desde el mapa o BD
                int km = kilometrajeMap.getOrDefault(id, c.getKilometraje());
                // Incrementar de 2 en 2
                km += 2;
                kilometrajeMap.put(id, km);
                // Persistir en BD
                try (Connection con = Conexion.conectarDb(); 
                        PreparedStatement ps = con.prepareStatement(  
                                "UPDATE camiones SET kilometraje = ? "
                                        + "WHERE idCamion = ?")) {
                    ps.setInt(1, km);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                }
                modelo.addRow(new Object[]{
                    c.getPatente(),
                    c.getMarca(),
                    c.getModelo(),
                    c.getAnio(),
                    km,
                    c.getNombreConductor()
                });
            }

            JTableKm.setModel(modelo);
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar camiones:\n" + ex.getMessage(),
                    "Error BD", javax.swing.JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void configurarEventosTablaConductores() {
        JtableConduc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = JtableConduc.getSelectedRow();

                if (fila >= 0) {
                    idConductorSeleccionado = Integer.parseInt(
                            JtableConduc.getValueAt(fila, 0).toString()
                    );

                    String nombre = JtableConduc.getValueAt(fila, 1).toString();
                    String rut = JtableConduc.getValueAt(fila, 2).toString();

                    txtNombreConRegis.setText(nombre);
                    txtRutConRegis.setText(rut);
                }
            }
        });
    }

    private void configurarEventosTablaKm() {
    JTableKm.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int fila = JTableKm.getSelectedRow();

            if (fila >= 0) {

                Object patente = JTableKm.getValueAt(fila, 0);
                Object kilometraje = JTableKm.getValueAt(fila, 4);
                

                txtPatenteKm.setText(patente != null ? patente.toString() : "");
                txtKilometrajeKm.setText(kilometraje != null ? kilometraje.toString() : "");
               
            }
        }
    });
}

    private void btnRegistrarKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarKmActionPerformed

        String patente = txtPatenteKm.getText().trim();
        String kilometrajeStr = txtKilometrajeKm.getText().trim();

        if (patente.equals("") || kilometrajeStr.equals("")) {
            JOptionPane.showMessageDialog(this, "Patente y kilometraje son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int nuevoKm;
        try {
            nuevoKm = Integer.parseInt(kilometrajeStr);
            if (nuevoKm < 0) {
                JOptionPane.showMessageDialog(this, "El kilometraje debe ser positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El kilometraje debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            CamionDao camionDao = new CamionDao();
            RegisCamion camion = camionDao.buscarPorPatente(patente);

            if (camion != null) {
                int idCamion = camion.getIdCamion();

            // Reemplazar directamente en BD
                camionDao.actualizarKilometraje(patente, nuevoKm);

            // Actualizar mapa en memoria
                kilometrajeMap.put(idCamion, nuevoKm);

            // Registrar en historial (solo patente y km)
                RegistrarKm registro = new RegistrarKm();
                registro.setPatenteCamion(patente);
                registro.setKilometraje(nuevoKm);

                RegistrarKmDao regDao = new RegistrarKmDao();
                regDao.insertar(registro);

                JOptionPane.showMessageDialog(this, "Kilometraje actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                cargarTablaMantenimiento();
                cargarTablaKm();
                cargarTablaCamiones();
                verificarMantenimiento();

            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el camión con patente: " + patente, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(this, "Error al actualizar km:\n" + sqle.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRegistrarKmActionPerformed

    private void btnactualizarCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarCamActionPerformed

        String patente = txtPatenteCam.getText().trim();
        String marca = txtMarcaCam.getText().trim();
        String modelo = txtModeloCam.getText().trim();
        String anioStr = txtAnioCam.getText().trim();
        String conductor = (String) comboConductores.getSelectedItem();
        String gasolinaStr = txtGasolina.getText().trim();

        if (idCamionSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona primero un camión de la tabla.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (patente.isEmpty() || marca.isEmpty() || modelo.isEmpty() || anioStr.isEmpty() || conductor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El año debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // GASOLINA 
        int gasolina = 100;
        try {
            gasolina = Integer.parseInt(gasolinaStr);
        } catch (Exception e) {
            gasolina = 100;
        }

        RegisCamion c = new RegisCamion();
        c.setPatente(patente);
        c.setMarca(marca);
        c.setModelo(modelo);
        c.setAnio(anio);
        c.setNombreConductor(conductor);

        CamionDao dao = new CamionDao();
        try {
            // Validar duplicado de patente
            RegisCamion existente = dao.buscarPorPatente(patente);
            if (existente != null && existente.getIdCamion() != idCamionSeleccionado) {
                JOptionPane.showMessageDialog(this, "Ya existe un camión con la patente " + patente, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ACTUALIZAR CAMIÓN EN BD
            dao.actualizarPorId(idCamionSeleccionado, c);

            //Reiniciar valores de simulación al actualizar
            temperaturaMap.put(idCamionSeleccionado, 20);   // reinicia temperatura
            gasolinaMap.put(idCamionSeleccionado, gasolina); // reinicia gasolina
            alertaMostrada.put(idCamionSeleccionado, false); // permite futuras alertas
             // permite futuras alertas

            JOptionPane.showMessageDialog(this, "Camión actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // REFRESCAR TABLAS
            cargarTablaCamiones();
            cargarTablaKm();

            // reset selección
            idCamionSeleccionado = -1;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar camión:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnactualizarCamActionPerformed

    private void btneliminarCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarCamActionPerformed

        String patente = txtPatenteCam.getText().trim();

        if (patente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la patente del camión a eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        CamionDao dao = new CamionDao();
        try {
            dao.eliminar(patente);
            JOptionPane.showMessageDialog(this, "Camión eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // REFRESCAR ambas tablas
            cargarTablaCamiones();
            cargarTablaKm();

            // limpiar campos
            txtPatenteCam.setText("");
            txtMarcaCam.setText("");
            txtModeloCam.setText("");
            txtAnioCam.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar camión:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        temperaturaMap.remove(idCamionSeleccionado);
        gasolinaMap.remove(idCamionSeleccionado);


    }//GEN-LAST:event_btneliminarCamActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void comboConductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboConductoresActionPerformed

    }//GEN-LAST:event_comboConductoresActionPerformed

    private void btnRegistrarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarConductorActionPerformed
        String nombre = txtNombreConRegis.getText().trim();
        String rut = txtRutConRegis.getText().trim();

        if (nombre.equals("") || rut.equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre y RUT son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Db.ConductorDao dao = new Db.ConductorDao();
        try {
            dao.insertarConductor(nombre, rut);
            JOptionPane.showMessageDialog(this, "Conductor registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // refrescar combo de conductores
            cargarConductoresEnCombo();
            cargarTablaConductores();
            txtNombreConRegis.setText("");
            txtRutConRegis.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarConductorActionPerformed

    private void btnEliminarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarConductorActionPerformed
        if (idConductorSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un conductor de la tabla.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas eliminar este conductor?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try (java.sql.Connection con = Db.Conexion.conectarDb(); java.sql.PreparedStatement ps = con.prepareStatement(
                "DELETE FROM conductores WHERE id_conductor=?"
        )) {

            ps.setInt(1, idConductorSeleccionado);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(this, "Conductor eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarConductoresEnCombo();
                cargarTablaConductores();
                cargarTablaCamiones();
                cargarTablaKm();
                cargarDatosDesdeTablaMantenimiento();
                cargarTablaMantenimiento();
                txtNombreConRegis.setText("");
                txtRutConRegis.setText("");
                idConductorSeleccionado = -1;
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarConductorActionPerformed

    private void cargarTablaMantenimiento() {

        Db.MantenimientoDao dao = new Db.MantenimientoDao();

        try {
            java.util.List<Model.RegisMantenimiento> lista = dao.listarMantenimientos();

            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();

            modelo.addColumn("Camión");
            modelo.addColumn("Patente");
            modelo.addColumn("Fecha");
            modelo.addColumn("Tipo");
            modelo.addColumn("Descripción");
            modelo.addColumn("Kilometraje");

            for (Model.RegisMantenimiento m : lista) {
                modelo.addRow(new Object[]{
                    m.getModelo(),
                    m.getPatente(),
                    m.getFecha(),
                    m.getTipo(),
                    m.getDescripcion(),
                    m.getKilometraje()
                });
            }

            jTableMan.setModel(modelo);

        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al cargar mantenimientos:\n" + ex.getMessage(),
                    "Error BD",
                    javax.swing.JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();
        }
    }


    private void btnSalirConducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirConducActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirConducActionPerformed

    private void btnSalirKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirKmActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirKmActionPerformed

    private void btnSalirManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirManActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnSalirManActionPerformed

    private void btnActualizarManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarManActionPerformed
        // TODO add your handling code here:

        try {

            String patente = txtPatenteMant.getText().trim();

            if (patente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un camión");
                return;
            }

            CamionDao camionDao = new CamionDao();
            int idCamion = camionDao.obtenerIdPorPatente(patente);

            // Fecha
            java.util.Date fechaUtil = jDateMan.getDate();
            if (fechaUtil == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha");
                return;
            }

            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());

            // Kilometraje
            int kilometraje = Integer.parseInt(txtKmMant.getText());

            //  Objeto mantenimiento
            RegisMantenimiento m = new RegisMantenimiento();
            m.setIdCamion(idCamion);
            m.setFecha(fechaSql);
            m.setTipo(txtTipo.getText().trim());
            m.setDescripcion(txtDescripcion.getText().trim());

            //  DAO
            MantenimientoDao manDao = new MantenimientoDao();
            CamionDao camDao = new CamionDao();

            //  UPDATE DOBLE
            manDao.actualizar(m);
            camDao.actualizarKilometraje(idCamion, kilometraje);

            JOptionPane.showMessageDialog(this, "Mantenimiento y kilometraje actualizados");

            cargarTablaMantenimiento();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kilometraje inválido");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarManActionPerformed

    private void cargarDatosDesdeTablaMantenimiento() {

        int fila = jTableMan.getSelectedRow();

        if (fila == -1) {
            return;
        }

        try {
            // Obtener valores desde la tabla
            String patente = jTableMan.getValueAt(fila, 0).toString();
            String modelo = jTableMan.getValueAt(fila, 2).toString();
            String tipo = jTableMan.getValueAt(fila, 5) != null ? jTableMan.getValueAt(fila, 5).toString() : "";
            String descripcion = jTableMan.getValueAt(fila, 6) != null ? jTableMan.getValueAt(fila, 6).toString() : "";
            Object fechaObj = jTableMan.getValueAt(fila, 4);

            //  Cargar en los campos
            txtPatenteMant.setText(patente);
            txtTipo.setText(tipo);
            txtDescripcion.setText(descripcion);

            //  Fecha
            if (fechaObj != null) {
                if (fechaObj instanceof java.util.Date) {
                    jDateMan.setDate((java.util.Date) fechaObj);
                } else {
                    // por si viene como String
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fecha = sdf.parse(fechaObj.toString());
                    jDateMan.setDate(fecha);
                }
            } else {
                jDateMan.setDate(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos desde la tabla");
        }
    }
    private void jTableManMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableManMouseClicked
        // TODO add your handling code here:
        int fila = jTableMan.getSelectedRow();

        btnAgregarMan.setEnabled(true);
        btnActualizarMan.setEnabled(true);

        if (fila == -1) {
            JOptionPane.showMessageDialog(null,
                    "Debe seleccionar una fila de la tabla.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // :pushpin: Obtener datos según tu orden real
            String camion = jTableMan.getValueAt(fila, 0).toString();
            String patente = jTableMan.getValueAt(fila, 1).toString();
            Object fechaObj = jTableMan.getValueAt(fila, 2);
            String tipo = jTableMan.getValueAt(fila, 3) != null ? jTableMan.getValueAt(fila, 3).toString() : "";
            String descripcion = jTableMan.getValueAt(fila, 4) != null ? jTableMan.getValueAt(fila, 4).toString() : "";
            String kilometraje = jTableMan.getValueAt(fila, 5).toString();

            // :pushpin: Setear en los campos
            txtCamionMant.setText(camion);
            txtPatenteMant.setText(patente);
            txtTipo.setText(tipo);
            txtDescripcion.setText(descripcion);
            txtKmMant.setText(kilometraje); // si tienes este campo

            // :date: Fecha
            if (fechaObj != null) {
                if (fechaObj instanceof java.util.Date) {
                    jDateMan.setDate((java.util.Date) fechaObj);
                } else {
                    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date fecha = sdf.parse(fechaObj.toString());
                    jDateMan.setDate(fecha);
                }
            } else {
                jDateMan.setDate(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error al seleccionar datos de la tabla",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jTableManMouseClicked

    private void btnAgregarManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarManActionPerformed
        // TODO add your handling code here:
        try {
            String patente = txtPatenteMant.getText().trim();

            if (patente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese una patente");
                return;
            }

            CamionDao camionDao = new CamionDao();
            RegisCamion camion = camionDao.buscarPorPatente(patente);

            if (camion == null) {
                JOptionPane.showMessageDialog(this, "Camión no encontrado");
                return;
            }

            // Validación de kilometraje
            if (camion.getKilometraje() < 5000) {
                JOptionPane.showMessageDialog(this, "El camión no supera los 5000 km");
                return;
            }

            // Fecha
            java.util.Date fechaUtil = jDateMan.getDate();
            if (fechaUtil == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha");
                return;
            }

            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());

            //  Crear objeto
            RegisMantenimiento m = new RegisMantenimiento();
            m.setFecha(fechaSql);
            m.setTipo(txtTipo.getText().trim());
            m.setDescripcion(txtDescripcion.getText().trim());

            // Insertar
            MantenimientoDao dao = new MantenimientoDao();
            dao.insertarMantenimiento(camion.getIdCamion(), m);

            JOptionPane.showMessageDialog(this, "Mantenimiento agregado correctamente");

            cargarTablaMantenimiento();

            // 🧹 Limpiar campos
            txtTipo.setText("");
            txtDescripcion.setText("");
            jDateMan.setDate(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error:\n" + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarManActionPerformed

    private void btnActualizarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarConductorActionPerformed

        String nombre = txtNombreConRegis.getText().trim();
        String rut = txtRutConRegis.getText().trim();

        // validar selección
        if (idConductorSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un conductor de la tabla.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // validar campos vacíos
        if (nombre.equals("") || rut.equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre y RUT son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        ConductorDao dao = new ConductorDao();

        // validar rut
        if (!dao.esRutValido(rut)) {
            JOptionPane.showMessageDialog(this, "El RUT no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (java.sql.Connection con = Db.Conexion.conectarDb(); java.sql.PreparedStatement ps = con.prepareStatement(
                "UPDATE conductores SET nombre=?, rut=? WHERE id_conductor=?"
        )) {

            ps.setString(1, nombre);
            ps.setString(2, rut);
            ps.setInt(3, idConductorSeleccionado);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                JOptionPane.showMessageDialog(this, "Conductor actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                cargarConductoresEnCombo();
                cargarTablaConductores();

                idConductorSeleccionado = -1;
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {

            // error por duplicado
            if (ex.getMessage().contains("Duplicate")) {
                JOptionPane.showMessageDialog(this, "El nombre o RUT ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
            }
            txtNombreConRegis.setText("");
            txtRutConRegis.setText("");
        }
    }//GEN-LAST:event_btnActualizarConductorActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        resetearTodo();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisCamion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisCamion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisCamion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisCamion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CamionVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JSpaneCam;
    private javax.swing.JScrollPane JSpaneConduc;
    private javax.swing.JScrollPane JSpaneKm;
    private javax.swing.JTable JTableKm;
    private javax.swing.JTable JtableConduc;
    private javax.swing.JButton btnActualizarConductor;
    private javax.swing.JButton btnActualizarMan;
    private javax.swing.JButton btnAgregarMan;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarConductor;
    private javax.swing.JButton btnRegistrarConductor;
    private javax.swing.JButton btnRegistrarKm;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirConduc;
    private javax.swing.JButton btnSalirKm;
    private javax.swing.JButton btnSalirMan;
    private javax.swing.JButton btnactualizarCam;
    private javax.swing.JButton btneliminarCam;
    private javax.swing.JButton btnregistrarCam;
    private javax.swing.JComboBox<String> comboConductores;
    private com.toedter.calendar.JDateChooser jDateMan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCam;
    private javax.swing.JTable jTableMan;
    private javax.swing.JLayeredPane jpanelRegistroCam;
    private javax.swing.JLabel lblGasolina;
    private javax.swing.JLabel lblKilometraje;
    private javax.swing.JLabel lblNombreConducRegis;
    private javax.swing.JLabel lblPatenteKm;
    private javax.swing.JLabel lblRutConducRegis;
    private javax.swing.JLabel lblanioCam;
    private javax.swing.JLabel lblconductorCam;
    private javax.swing.JLabel lblmarcaCam;
    private javax.swing.JLabel lblmodeloCam;
    private javax.swing.JLabel lblpatenteCam;
    private javax.swing.JTextPane txtAnioCam;
    private javax.swing.JTextPane txtCamionMant;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextPane txtGasolina;
    private javax.swing.JTextPane txtKilometrajeKm;
    private javax.swing.JTextPane txtKmMant;
    private javax.swing.JTextPane txtMarcaCam;
    private javax.swing.JTextPane txtModeloCam;
    private javax.swing.JTextField txtNombreConRegis;
    private javax.swing.JTextPane txtPatenteCam;
    private javax.swing.JTextPane txtPatenteKm;
    private javax.swing.JTextPane txtPatenteMant;
    private javax.swing.JTextField txtRutConRegis;
    private javax.swing.JTextPane txtTipo;
    // End of variables declaration//GEN-END:variables
}
