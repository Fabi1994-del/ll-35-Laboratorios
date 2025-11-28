/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import archivos.Archivo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabián
 */
public class FormularioContacto extends javax.swing.JFrame {

    final int INITIAL_WEIGHT = 450; // Ancho inicial de la ventana
    final int INITIAL_HEIGHT = 400; // Alto inicial de la ventana
    final String TITLE = "Contactos Taller Torres S.A"; // Título de la ventana
    final String SEARCH = "Buscar"; // Texto de búsqueda por defecto

    private Archivo archivo; // Manejo de archivos para guardar y cargar contactos
    private Contacto contacto; // Objeto Contacto que se manipulará
    private Libreta libreta; // Lista de contactos
    private String[] stringContactos; // Arreglo para almacenar los contactos como cadenas
    private String cedula; // Cédula del contacto
    private Queue<Contacto> cola = new LinkedList<>(); // Cola para manejar contactos pendientes de atender
    private Stack<Contacto> pila = new Stack<>(); //  Pila para manejar contactos atendidos
    private DefaultListModel<String> lmPendientes = new DefaultListModel<>(); //modelo de lista pendientes
    private DefaultListModel<String> lmAtendidos = new DefaultListModel<>();  // modelo de lista atendidos, manejan la info que esta en la lista
    private boolean estadoB = false; // Estado del botón
    private boolean estadoPanel = true; // Estado del panel
    private int selTipo = 0; // Tipo de selección (mostrar cédulas o todo)
    private javax.swing.Timer tiempo; // contador de tiempo 
    private int segundos = 0; // variable segundos que inicia en 0 
    private int minutos = 0;
    private int horas = 0;
    private boolean enLlamada = false;  //controla si hay una llamada activa

    public FormularioContacto() {
        initComponents();
        archivo = new Archivo();
        libreta = new Libreta();

        setLocationRelativeTo(null);
        super.setSize(INITIAL_WEIGHT, INITIAL_HEIGHT); //redimenciona la ventana 
        super.setTitle(TITLE);
    }

    public void limpiar() {
        textCedula.setText("");
        textNombre.setText("");
        textApellidos.setText("");
        textFechaNac.setText("");
        textTelefono.setText("");
        textCorreo.setText("");
    }

    public void listar() {
        listar(this.selTipo);
    }

    /**
     * Lista los contactos según el tipo especificado.
     *
     * @param tipo Tipo de listado (0: mostrar cédulas, 1: mostrar todos).
     */
    public void listar(int tipo) {
        String search = searchText.getText();
        if (!search.equals(SEARCH)) {
            this.libreta.buscarArchivos(searchText.getText()); // Busca contactos que coincidan con el texto
        }

        switch (tipo) {
            case 0: {
                this.stringContactos = libreta.listarCedulas(); // Lista solo cédulas
                listaContactos.setListData(this.stringContactos);
            }
            break;
            case 1: {
                this.stringContactos = libreta.listarLibreta(); // Lista todos los contactos
                listaContactos.setListData(this.stringContactos);
            }
            break;
        }
    }
    //metodo para iniciar el contador del tiempo

    public void iniciarContador() {
        if (tiempo != null && tiempo.isRunning()) {  //revisar si existe un tiempo funcionando, si ya ya hay contador corriendo, lo detiene para iniciar uno nuevo
            tiempo.stop();
        }

        horas = 0; // variables inician en 0
        minutos = 0;
        segundos = 0;

        tiempo = new javax.swing.Timer(1000, new java.awt.event.ActionListener() { //se crea el tiempo utilizando un java.awt.tiempo para ejecutar una accion cada cierto tiempo 
            @Override                                                              //1000 son los milisegundos que equivale a un segundos y los segundos se ejecutaran utilizando 
            public void actionPerformed(java.awt.event.ActionEvent e) {           //el codigo interno actionlistener 
                segundos++;

                if (segundos == 60) {
                    segundos = 0;
                    minutos++;
                }

                if (minutos == 60) {
                    minutos = 0;
                    horas++;
                }

                String tiempo = String.format("%02d:%02d:%02d", horas, minutos, segundos); //%02d quiere decir que va a mostrar siempre 2 digitos 
                jLTiempo.setText(tiempo);
            }
        });

        tiempo.start();// inicia el contador 
    }

    public void detenerContador() {
        if (tiempo != null) {
            tiempo.stop();
        }
        horas = 0;
        minutos = 0;
        segundos = 0;

        jLTiempo.setText("00:00:00"); //restablece el contador visual pero no pone las variables en 0 
    }

    public void reiniciarContador() { //Limpia el contador totalmente 
        detenerContador();
        segundos = 0;
        minutos = 0;
        horas = 0;
        jLTiempo.setText("00:00:00");
    }

    //Metodo que agrega un contacto a la lista de contactos atendidos y se usa cuando una llamada finaliza
    private void agregarAtendido(Contacto c) { //contacto c es el cliente que esta o atendio 
        if (c != null) {
            pila.push(c); // Guarda en la pila de atendidos
            lmAtendidos.addElement(c.getNombre() + " " + c.getApellidos() + " - " + c.getTelefono());
            listAtendidos.setModel(lmAtendidos);
        }
    }

    /**
     * Llena los campos del formulario con la información del contacto
     * seleccionado.
     */
    public void llenarCampos() {
        textCedula.setText(this.contacto.getCedula());
        textNombre.setText(this.contacto.getNombre());
        textApellidos.setText(this.contacto.getApellidos());
        textFechaNac.setText(this.contacto.getfNacimiento());
        textTelefono.setText(this.contacto.getTelefono());
        textCorreo.setText(this.contacto.getCorreo());
        provinciasComboBox.setSelectedItem(this.contacto.getProvincia());
    }

    /**
     * Método generado automáticamente para inicializar los componentes del
     * formulario.
     *
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gMostrar = new javax.swing.ButtonGroup();
        panelListaCont = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bGuardar = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        textFechaNac = new javax.swing.JTextField();
        textApellidos = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bLimpiar = new javax.swing.JButton();
        textCorreo = new javax.swing.JTextField();
        bBusqueA = new javax.swing.JToggleButton();
        textCedula = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        provinciasComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        bAbrir = new javax.swing.JButton();
        bImportar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        mostrarCed = new javax.swing.JRadioButton();
        mostrarTodo = new javax.swing.JRadioButton();
        bLimpiarBuscar = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaContactos = new javax.swing.JList();
        btnContactar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtfAtendiendo = new javax.swing.JTextField();
        btnLlamar = new javax.swing.JButton();
        btnColgar = new javax.swing.JButton();
        jLTiempo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPendientes = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listAtendidos = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(412, 634));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 312));

        bGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/add.png"))); // NOI18N
        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/search.png"))); // NOI18N
        bBuscar.setToolTipText("Busqueda por cedula");
        bBuscar.setAlignmentY(0.0F);
        bBuscar.setMargin(new java.awt.Insets(1, 5, 1, 5));
        bBuscar.setPreferredSize(new java.awt.Dimension(26, 23));
        bBuscar.setRequestFocusEnabled(false);
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/remove.png"))); // NOI18N
        bEliminar.setToolTipText("Eliminar");
        bEliminar.setAlignmentY(0.0F);
        bEliminar.setMargin(new java.awt.Insets(1, 5, 1, 5));
        bEliminar.setPreferredSize(new java.awt.Dimension(26, 23));
        bEliminar.setRequestFocusEnabled(false);
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        jLabel4.setText("Fecha Nacimiento");

        jLabel3.setText("Apellidos");

        jLabel5.setText("Provincia");

        jLabel6.setText("Teléfono");

        jLabel7.setText("Correo");

        bLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/page.png"))); // NOI18N
        bLimpiar.setText("Nuevo");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        bBusqueA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/database_search.png"))); // NOI18N
        bBusqueA.setText("Busqueda Avanzada");
        bBusqueA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBusqueAActionPerformed(evt);
            }
        });

        textCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCedulaKeyReleased(evt);
            }
        });

        provinciasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textCorreo)
                                    .addComponent(textTelefono)
                                    .addComponent(textApellidos)
                                    .addComponent(textFechaNac)
                                    .addComponent(textNombre)
                                    .addComponent(textCedula)
                                    .addComponent(provinciasComboBox, 0, 259, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bBusqueA)
                        .addGap(18, 18, 18)
                        .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bGuardar)
                        .addGap(146, 146, 146))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(provinciasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGuardar)
                    .addComponent(bLimpiar)
                    .addComponent(bBusqueA))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        bAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/folder_edit.png"))); // NOI18N
        bAbrir.setText("Abrir");
        bAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAbrirActionPerformed(evt);
            }
        });

        bImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/page_down.png"))); // NOI18N
        bImportar.setText("Importar");
        bImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImportarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mostar:"));

        gMostrar.add(mostrarCed);
        mostrarCed.setSelected(true);
        mostrarCed.setText("Por cedulas");
        mostrarCed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mostrarCedItemStateChanged(evt);
            }
        });

        gMostrar.add(mostrarTodo);
        mostrarTodo.setText("Todo");
        mostrarTodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mostrarTodoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(mostrarCed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(mostrarTodo))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrarCed)
                    .addComponent(mostrarTodo))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        bLimpiarBuscar.setText("Limpiar");
        bLimpiarBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarBuscarActionPerformed(evt);
            }
        });

        searchText.setForeground(java.awt.Color.gray);
        searchText.setText(SEARCH);
        searchText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFocusLost(evt);
            }
        });
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(bLimpiarBuscar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bImportar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bAbrir)
                            .addComponent(bImportar)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLimpiarBuscar)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        listaContactos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaContactosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaContactos);

        btnContactar.setText("Contactar");
        btnContactar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactarActionPerformed(evt);
            }
        });

        jLabel8.setText("Atendiendo a:");

        jtfAtendiendo.setEnabled(false);
        jtfAtendiendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAtendiendoActionPerformed(evt);
            }
        });

        btnLlamar.setText("Llamar");
        btnLlamar.setEnabled(false);
        btnLlamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlamarActionPerformed(evt);
            }
        });

        btnColgar.setText("Colgar");
        btnColgar.setEnabled(false);
        btnColgar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColgarActionPerformed(evt);
            }
        });

        jLTiempo.setText("00:00:00");

        jScrollPane2.setViewportView(listPendientes);

        jScrollPane3.setViewportView(listAtendidos);

        jLabel10.setText("Pendientes");

        jLabel11.setText("Atendidos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnLlamar)
                        .addGap(160, 160, 160)
                        .addComponent(btnColgar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jtfAtendiendo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel11))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfAtendiendo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLlamar)
                            .addComponent(btnColgar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jLTiempo)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
        );

        btnSiguiente.setText("Siguiente");
        btnSiguiente.setEnabled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListaContLayout = new javax.swing.GroupLayout(panelListaCont);
        panelListaCont.setLayout(panelListaContLayout);
        panelListaContLayout.setHorizontalGroup(
            panelListaContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListaContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListaContLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelListaContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelListaContLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelListaContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelListaContLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelListaContLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnContactar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSiguiente)
                                        .addGap(58, 58, 58))))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelListaContLayout.setVerticalGroup(
            panelListaContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListaContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelListaContLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelListaContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnContactar)
                            .addComponent(btnSiguiente))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelListaCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelListaCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        //Cedula// funcion de textCedula actuliza cedula al digitar
        String provincia = String.valueOf(provinciasComboBox.getSelectedItem());
        contacto = new Contacto(cedula,
                textNombre.getText(),
                textApellidos.getText(),
                textFechaNac.getText(),
                provincia,
                textTelefono.getText(),
                textCorreo.getText());
        libreta.actualizarContacto(contacto);

        //Listar contactos en Jlist
        this.cedula = contacto.getCedula();

        bLimpiarActionPerformed(evt);
        listar();
        listaContactos.setSelectedValue(cedula, true);
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        if (libreta.eliminarContacto(textCedula.getText())) {
            bLimpiarActionPerformed(evt);
            listar();
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        this.cedula = textCedula.getText();
        if (!(cedula.equals(""))) {
            archivo = new Archivo(cedula);
            this.contacto = archivo.consulta(cedula);

            if (archivo.existe(textCedula.getText())) {
                llenarCampos();
            }
        } else {

            JOptionPane.showMessageDialog(null, "Digite una cedula para buscar la informacion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        limpiar();
        super.setTitle(TITLE);
        listaContactos.setSelectedValue(null, true);
    }//GEN-LAST:event_bLimpiarActionPerformed
    private void listaContactosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaContactosValueChanged
        if (!(listaContactos.getSelectedIndex() == -1)) {

            archivo = new Archivo();
            if (mostrarCed.isSelected()) {

                super.setTitle(TITLE + " - " + cedula);

                this.cedula = (listaContactos.getSelectedValue().toString());
                //Llenar campos
                this.contacto = archivo.consulta(cedula);
                llenarCampos();
            } else {

                this.cedula = (listaContactos.getSelectedValue().toString());
                StringTokenizer tokens = new StringTokenizer(cedula);
                this.cedula = tokens.nextToken(",");

                //Llenar campos
                this.contacto = archivo.consulta(cedula);
                llenarCampos();
            }

        } else {
            limpiar();
        }
        if(enLlamada){
            JOptionPane.showMessageDialog(this," No puede cambiar de contacto mientras esta en una llamada");
            listaContactos.clearSelection();
        }

    }//GEN-LAST:event_listaContactosValueChanged

    private void bBusqueAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBusqueAActionPerformed
        this.estadoB = !estadoB;

        if (estadoB) {
            int h = INITIAL_HEIGHT + jPanel5.getHeight() + 5; //valor de alto
            int w = INITIAL_WEIGHT + jPanel3.getWidth() + 5;
            super.setSize(w, h);
            setLocationRelativeTo(null);
            //Llenar lista de contactos//
            //Las siguientes validaciones evitan que se limpie la infomacion en pantalla al esconder la lista
            if (stringContactos != null) {
                if (stringContactos[0].equals("")) {
                    listar();
                }
            } else {
                listar();
            }
        } else {
            super.setSize(INITIAL_WEIGHT, INITIAL_HEIGHT);
        }
    }//GEN-LAST:event_bBusqueAActionPerformed

    private void textCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCedulaKeyReleased
        this.cedula = textCedula.getText();
    }//GEN-LAST:event_textCedulaKeyReleased

    private void mostrarCedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mostrarCedItemStateChanged
        this.selTipo = 0;
        listar();
    }//GEN-LAST:event_mostrarCedItemStateChanged

    private void mostrarTodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mostrarTodoItemStateChanged
        this.libreta = new Libreta();
        this.selTipo = 1;
        listar();
    }//GEN-LAST:event_mostrarTodoItemStateChanged

    private void bImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImportarActionPerformed
        this.contacto = archivo.consultaImportar();
        bLimpiarActionPerformed(evt);
        llenarCampos();
        this.cedula = textCedula.getText();
    }//GEN-LAST:event_bImportarActionPerformed

    private void bAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAbrirActionPerformed
        try {
            archivo.abrir(cedula);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_bAbrirActionPerformed

    private void searchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFocusGained
        if (searchText.getText().equals(SEARCH)) {
            searchText.setText("");
            searchText.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchTextFocusGained

    private void searchTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFocusLost
        if (searchText.getText().isEmpty()) {
            searchText.setForeground(Color.GRAY);
            searchText.setText(SEARCH);
        }
    }//GEN-LAST:event_searchTextFocusLost

    private void bLimpiarBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarBuscarActionPerformed
        searchText.setText(SEARCH);
        searchText.setForeground(Color.GRAY);
        listar();
    }//GEN-LAST:event_bLimpiarBuscarActionPerformed

    private void searchTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyTyped
        listar();
    }//GEN-LAST:event_searchTextKeyTyped

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        listar();
    }//GEN-LAST:event_searchTextKeyReleased

    private void btnContactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactarActionPerformed
        //llena la lista de pendientes
        lmPendientes.clear(); // limpia al dasrle click al boton 
        lmAtendidos.clear();

        for (Contacto contacto : libreta.getLibreta()) {
            cola.add(contacto); //llena la cola y llena la lista 
            lmPendientes.addElement(contacto.getNombre() + " " + contacto.getApellidos());
        }

        listPendientes.setModel(lmPendientes);
        if (!cola.isEmpty()) { // sino esta vacio 
            btnContactar.setEnabled(false);
            btnSiguiente.setEnabled(true);
        }
    }//GEN-LAST:event_btnContactarActionPerformed

    private void actualizarComponentes() {
        lmPendientes.clear();
        for (Contacto contacto : cola) {
            lmPendientes.addElement(contacto.getNombre() + " " + contacto.getApellidos());
        }
        listPendientes.setModel(lmPendientes);

    }
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        // contacto llena la lista de atendidos, y progresivamente va mostrando los elementos de la cola
        //llena la lista de pendientes
        if (!cola.isEmpty()) {
            Contacto siguiente = cola.poll();

            lmPendientes.remove(0);
            listPendientes.setModel(lmPendientes);

            jtfAtendiendo.setText(siguiente.getNombre() + " " + siguiente.getApellidos());
            this.contacto = siguiente;

            btnLlamar.setEnabled(true);
            btnColgar.setEnabled(false);

            reiniciarContador();
        }

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void jtfAtendiendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAtendiendoActionPerformed

    }//GEN-LAST:event_jtfAtendiendoActionPerformed

    private void btnLlamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlamarActionPerformed
        if (enLlamada) { //pregunta si la llamada esta activa, si es asi muestra un mensj de que debe de colgar para hacer otra llamada
            JOptionPane.showMessageDialog(this, " Ya hay una llamada en curso. Debe colga para iniciar otra llamada");
            return;
        }
        enLlamada = true;
        btnColgar.setEnabled(true); //activa 
        btnLlamar.setEnabled(true);
        btnSiguiente.setEnabled(false); // no permite continuar 
        reiniciarContador();
        iniciarContador();


    }//GEN-LAST:event_btnLlamarActionPerformed

    private void btnColgarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColgarActionPerformed
        if (!jtfAtendiendo.getText().isEmpty()) {
            //Se tiene el contacto que estaba siendo atendido
            Contacto atendido = this.contacto;

            // Se pasa a la lista de atendidos(PILA)
            agregarAtendido(atendido);

            //Limpieza visual
            enLlamada = false;
            jtfAtendiendo.setText(" ");
            btnColgar.setEnabled(false);
            btnLlamar.setEnabled(true);
            btnSiguiente.setEnabled(true);
            
            detenerContador();
            reiniciarContador();

            JOptionPane.showMessageDialog(this, "LLamada finalizada y Registrada ");
        }
    }//GEN-LAST:event_btnColgarActionPerformed
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioContacto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioContacto().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAbrir;
    private javax.swing.JButton bBuscar;
    private javax.swing.JToggleButton bBusqueA;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bImportar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bLimpiarBuscar;
    private javax.swing.JButton btnColgar;
    private javax.swing.JButton btnContactar;
    private javax.swing.JButton btnLlamar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.ButtonGroup gMostrar;
    private javax.swing.JLabel jLTiempo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jtfAtendiendo;
    private javax.swing.JList<String> listAtendidos;
    private javax.swing.JList<String> listPendientes;
    private javax.swing.JList listaContactos;
    private javax.swing.JRadioButton mostrarCed;
    private javax.swing.JRadioButton mostrarTodo;
    private javax.swing.JPanel panelListaCont;
    private javax.swing.JComboBox<String> provinciasComboBox;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textCedula;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textFechaNac;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
