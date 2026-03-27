package Views;

import Model.RegistrarKm;
import Db.RegistrarKmDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.RegisCamion;
import Db.CamionDao;
import Db.ConductorDao;

public class CamionVisual extends javax.swing.JFrame {

    public CamionVisual() {
        initComponents();

        // Cargar tablas principales
        cargarTablaCamiones();
        cargarTablaKm();
        cargarTablaConductores();

        // Configurar eventos de selección en tablas
        configurarEventosTabla();
        configurarEventosTablaKm();

        // Llenar combo de conductores desde BD
        cargarConductoresEnCombo();

        // Ajustes de campos
        txtPatenteKm.setEditable(false);
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
        btnActualizarConductor = new javax.swing.JButton();
        btnEliminarConductor = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreConducRegis.setText("Nombre:");
        jLayeredPane1.add(lblNombreConducRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lblRutConducRegis.setText("Rut:");
        jLayeredPane1.add(lblRutConducRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jLayeredPane1.add(txtRutConRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, -1));
        jLayeredPane1.add(txtNombreConRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 90, -1));

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
        jLayeredPane1.add(btnRegistrarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        btnActualizarConductor.setText("Actualizar");
        btnActualizarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarConductorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnActualizarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        btnEliminarConductor.setText("Eliminar");
        btnEliminarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConductorActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnEliminarConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

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

        jpanelRegistroCam.add(JSpaneCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 620, 380));

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
        jpanelRegistroCam.add(btnregistrarCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

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
        jpanelRegistroCam.add(btnactualizarCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        btneliminarCam.setText("Eliminar");
        btneliminarCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarCamActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(btneliminarCam, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 80, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 80, -1));

        comboConductores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboConductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConductoresActionPerformed(evt);
            }
        });
        jpanelRegistroCam.add(comboConductores, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 110, -1));

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
    private String patenteOriginalSeleccionada = null;
    private int idCamionSeleccionado = -1;
// Cargar tabla de conductores con nombre y RUT

    private void cargarTablaConductores() {
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("RUT");

        try {
            Db.ConductorDao dao = new Db.ConductorDao();
            java.util.List<String[]> lista = dao.listarConductoresCompleto();
            for (String[] fila : lista) {
                modelo.addRow(new Object[]{fila[0], fila[1]});
            }
            JtableConduc.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar conductores:\n" + ex.getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
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
        CamionDao dao = new CamionDao();
        try {
            java.util.List<Model.RegisCamion> lista = dao.listarTodos();

            // Modelo con columna idCamion oculta en la posición 0
            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            modelo.addColumn("idCamion"); // columna oculta
            modelo.addColumn("Patente");
            modelo.addColumn("Marca");
            modelo.addColumn("Modelo");
            modelo.addColumn("Año");
            modelo.addColumn("Kilometraje");
            modelo.addColumn("Conductor");

            for (Model.RegisCamion c : lista) {
                modelo.addRow(new Object[]{
                    c.getIdCamion(),
                    c.getPatente(),
                    c.getMarca(),
                    c.getModelo(),
                    c.getAnio(),
                    c.getKilometraje(),
                    c.getNombreConductor()
                });
            }

            jTableCam.setModel(modelo);

            // Ocultar la columna idCamion (índice 0)
            if (jTableCam.getColumnModel().getColumnCount() > 0) {
                jTableCam.getColumnModel().getColumn(0).setMinWidth(0);
                jTableCam.getColumnModel().getColumn(0).setMaxWidth(0);
                jTableCam.getColumnModel().getColumn(0).setWidth(0);
            }

        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Error al cargar camiones:\n" + ex.getMessage(),
                    "Error BD", javax.swing.JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void verificarMantenimiento() {
        CamionDao dao = new CamionDao();
        try {
            java.util.List<RegisCamion> lista = dao.listarTodos();
            for (RegisCamion c : lista) {
                int km = c.getKilometraje();

                // Revisamos si el camión ya pasó los 5000 km
                if (km >= 5000) {
                    // Calculamos cuántos bloques de 5000 km ha recorrido
                    int bloques = km / 5000;

                    // Si está en el primer bloque o más, mostramos alerta
                    JOptionPane.showMessageDialog(this,
                            "El camión con patente " + c.getPatente()
                            + " tiene " + km + " km.\nDebe realizar mantenimiento (bloque " + bloques + " de 5000 km).",
                            "Alerta de Mantenimiento",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al verificar mantenimiento:\n" + ex.getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void btnregistrarCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarCamActionPerformed

        String conductor = (String) comboConductores.getSelectedItem();
        String patente = txtPatenteCam.getText().trim();
        String marca = txtMarcaCam.getText().trim();
        String modelo = txtModeloCam.getText().trim();
        String anioStr = txtAnioCam.getText().trim();

        if (conductor == null || conductor.equals("") || patente.equals("") || marca.equals("") || modelo.equals("") || anioStr.equals("")) {
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

        RegisCamion c = new RegisCamion();
        c.setPatente(patente);
        c.setMarca(marca);
        c.setModelo(modelo);
        c.setAnio(anio);
        c.setNombreConductor(conductor);

        CamionDao dao = new CamionDao();
        try {
            dao.insertar(c);
            JOptionPane.showMessageDialog(this, "Camión registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaCamiones();
            cargarTablaKm();
            txtPatenteCam.setText("");
            txtMarcaCam.setText("");
            txtModeloCam.setText("");
            txtAnioCam.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
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
                modelo.addRow(new Object[]{
                    c.getPatente(),
                    c.getMarca(),
                    c.getModelo(),
                    c.getAnio(),
                    c.getKilometraje(),
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

    private void configurarEventosTablaKm() {
        JTableKm.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int fila = JTableKm.getSelectedRow();
                if (fila >= 0) {
                    String patente = JTableKm.getValueAt(fila, 0).toString();
                    String kilometraje = JTableKm.getValueAt(fila, 4).toString();
                    String conductor = JTableKm.getValueAt(fila, 5).toString();

                    txtPatenteKm.setText(patente);
                    txtKilometrajeKm.setText(kilometraje);
                    comboConductores.setSelectedItem(conductor);
                }
            }
        });
    }

    private void btnRegistrarKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarKmActionPerformed

        String patente = txtPatenteKm.getText().trim();
        String conductor = (String) comboConductores.getSelectedItem();
        String kilometrajeStr = txtKilometrajeKm.getText().trim();

        if (patente.equals("") || conductor == null || conductor.equals("") || kilometrajeStr.equals("")) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
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
            camionDao.actualizarKilometraje(patente, nuevoKm);

            RegistrarKm registro = new RegistrarKm();
            registro.setPatenteCamion(patente);
            registro.setNombreConductor(conductor);
            registro.setKilometraje(nuevoKm);

            RegistrarKmDao regDao = new RegistrarKmDao();
            regDao.insertar(registro);

            JOptionPane.showMessageDialog(this, "Kilometraje actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTablaKm();
            cargarTablaCamiones();
            verificarMantenimiento();
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

        RegisCamion c = new RegisCamion();
        c.setPatente(patente); // nueva patente posible
        c.setMarca(marca);
        c.setModelo(modelo);
        c.setAnio(anio);
        c.setNombreConductor(conductor);

        CamionDao dao = new CamionDao();
        try {
            // Validar duplicado de patente (si cambió)
            RegisCamion existente = dao.buscarPorPatente(patente);
            if (existente != null && existente.getIdCamion() != idCamionSeleccionado) {
                JOptionPane.showMessageDialog(this, "Ya existe un camión con la patente " + patente, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar por idCamion
            dao.actualizarPorId(idCamionSeleccionado, c);
            JOptionPane.showMessageDialog(this, "Camión actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // REFRESCAR ambas tablas
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

    private void btnActualizarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarConductorActionPerformed
        String nombre = txtNombreConRegis.getText().trim();
        String rut = txtRutConRegis.getText().trim();

        if (nombre.equals("") || rut.equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre y RUT son obligatorios.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (java.sql.Connection con = Db.Conexion.conectarDb(); java.sql.PreparedStatement ps = con.prepareStatement("UPDATE conductores SET rut=? WHERE nombre=?")) {
            ps.setString(1, rut);
            ps.setString(2, nombre);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(this, "Conductor actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarConductoresEnCombo();     // refrescar combo
                cargarTablaConductores();       // refrescar tabla
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró conductor con ese nombre.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarConductorActionPerformed

    private void btnEliminarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarConductorActionPerformed
        String nombre = txtNombreConRegis.getText().trim();

        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del conductor a eliminar.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (java.sql.Connection con = Db.Conexion.conectarDb(); java.sql.PreparedStatement ps = con.prepareStatement("DELETE FROM conductores WHERE nombre=?")) {
            ps.setString(1, nombre);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(this, "Conductor eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarConductoresEnCombo();     // refrescar combo
                cargarTablaConductores();       // refrescar tabla
                txtNombreConRegis.setText("");
                txtRutConRegis.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró conductor con ese nombre.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar:\n" + ex.getMessage(), "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarConductorActionPerformed

    private void btnSalirConducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirConducActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirConducActionPerformed

    private void btnSalirKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirKmActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirKmActionPerformed

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
            java.util.logging.Logger.getLogger(RegisCamion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisCamion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisCamion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisCamion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnEliminarConductor;
    private javax.swing.JButton btnRegistrarConductor;
    private javax.swing.JButton btnRegistrarKm;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirConduc;
    private javax.swing.JButton btnSalirKm;
    private javax.swing.JButton btnactualizarCam;
    private javax.swing.JButton btneliminarCam;
    private javax.swing.JButton btnregistrarCam;
    private javax.swing.JComboBox<String> comboConductores;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCam;
    private javax.swing.JLayeredPane jpanelRegistroCam;
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
    private javax.swing.JTextPane txtKilometrajeKm;
    private javax.swing.JTextPane txtMarcaCam;
    private javax.swing.JTextPane txtModeloCam;
    private javax.swing.JTextField txtNombreConRegis;
    private javax.swing.JTextPane txtPatenteCam;
    private javax.swing.JTextPane txtPatenteKm;
    private javax.swing.JTextField txtRutConRegis;
    // End of variables declaration//GEN-END:variables
}
