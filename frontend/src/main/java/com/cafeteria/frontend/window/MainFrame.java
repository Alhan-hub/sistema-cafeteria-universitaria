package com.cafeteria.frontend.window;

import com.cafeteria.frontend.dtos.*;
import com.cafeteria.frontend.webservicesclient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MainFrame extends JFrame {

    @Autowired
    private ClienteApiClient clienteService;
    @Autowired
    private ProductoApiClient productoService;
    @Autowired
    private PedidoApiClient pedidoService;

    // --- PESTAÑA 1: CREAR PEDIDO ---
    private JComboBox<String> comboClientes;
    private JComboBox<String> comboProductos;
    private JSpinner spinnerCantidad;
    private JTextArea txtOutput;
    private Map<String, String> clienteDocMap = new HashMap<>();
    private Map<String, Integer> productoIdMap = new HashMap<>();

    // --- PESTAÑA 2: GESTIÓN CLIENTES ---
    private JTable tableClientes;
    private DefaultTableModel modelClientes;
    private JTextField txtCliDoc, txtCliNombre;

    // --- PESTAÑA 3: HISTORIAL PEDIDOS ---
    private JTable tablePedidos;
    private DefaultTableModel modelPedidos;

    // --- PESTAÑA 4: GESTIÓN PRODUCTOS (NUEVO) ---
    private JTable tableProductos;
    private DefaultTableModel modelProductos;
    private JTextField txtProdNombre, txtProdPrecio, txtProdStock;

    public MainFrame() {
        setSize(900, 650);
        setTitle("Sistema Cafetería Universitaria - Panel de Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void initializeUI() {
        JTabbedPane tabbedPane = new JTabbedPane();

        // Agregar las 4 pestañas
        tabbedPane.addTab("Nuevo Pedido", crearPanelNuevoPedido());
        tabbedPane.addTab("Gestión Clientes", crearPanelGestionClientes());
        tabbedPane.addTab("Historial Pedidos", crearPanelHistorialPedidos());
        tabbedPane.addTab("Gestión Productos", crearPanelGestionProductos()); // <--- NUEVA

        // Refrescar datos al cambiar de pestaña
        tabbedPane.addChangeListener(e -> {
            cargarDatosClientes();
            cargarDatosPedidos();
            cargarDatosProductos();
            cargarCombosPedido();
        });

        add(tabbedPane);

        // Carga inicial
        cargarCombosPedido();
        cargarDatosClientes();
        cargarDatosPedidos();
        cargarDatosProductos();
    }

    // ==========================================
    // PESTAÑA 1: NUEVO PEDIDO
    // ==========================================
    private JPanel crearPanelNuevoPedido() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        comboClientes = new JComboBox<>();
        comboProductos = new JComboBox<>();
        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        inputPanel.add(new JLabel("Cliente:"));     inputPanel.add(comboClientes);
        inputPanel.add(new JLabel("Producto:"));    inputPanel.add(comboProductos);
        inputPanel.add(new JLabel("Cantidad:"));    inputPanel.add(spinnerCantidad);

        JButton btnCrear = new JButton("Crear Pedido");
        btnCrear.addActionListener(e -> crearPedido());
        inputPanel.add(btnCrear);

        txtOutput = new JTextArea(10, 30);
        txtOutput.setEditable(false);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtOutput), BorderLayout.CENTER);
        return panel;
    }

    private void cargarCombosPedido() {
        try {
            // Clientes
            List<ClienteDTO> clientes = clienteService.getClientes();
            comboClientes.removeAllItems();
            clienteDocMap.clear();
            for (ClienteDTO c : clientes) {
                String key = c.getNombre() + " (" + c.getDocumento() + ")";
                comboClientes.addItem(key);
                clienteDocMap.put(key, c.getDocumento());
            }
            // Productos
            List<ProductoDTO> productos = productoService.getProductos();
            comboProductos.removeAllItems();
            productoIdMap.clear();
            for (ProductoDTO p : productos) {
                String key = p.getNombre() + " - $" + p.getPrecio();
                comboProductos.addItem(key);
                productoIdMap.put(key, p.getId());
            }
        } catch (Exception e) {

        }
    }

    private void crearPedido() {
        try {
            String clienteKey = (String) comboClientes.getSelectedItem();
            String productoKey = (String) comboProductos.getSelectedItem();
            if(clienteKey == null || productoKey == null) return;

            PedidoRequest req = new PedidoRequest(
                    clienteDocMap.get(clienteKey),
                    productoIdMap.get(productoKey),
                    (Integer) spinnerCantidad.getValue()
            );

            PedidoDTO dto = pedidoService.crearPedido(req);
            txtOutput.append("Pedido #" + dto.getId() + " creado con éxito.\n");
            JOptionPane.showMessageDialog(this, "Pedido Creado!");
            cargarDatosPedidos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // ==========================================
    // PESTAÑA 2: GESTIÓN CLIENTES
    // ==========================================
    private JPanel crearPanelGestionClientes() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new FlowLayout());

        txtCliDoc = new JTextField(8);
        txtCliNombre = new JTextField(12);
        JButton btnAdd = new JButton("Agregar");
        JButton btnDel = new JButton("Eliminar");

        btnAdd.addActionListener(e -> agregarCliente());
        btnDel.addActionListener(e -> eliminarCliente());

        formPanel.add(new JLabel("Doc:")); formPanel.add(txtCliDoc);
        formPanel.add(new JLabel("Nom:")); formPanel.add(txtCliNombre);
        formPanel.add(btnAdd); formPanel.add(btnDel);

        modelClientes = new DefaultTableModel(new String[]{"Documento", "Nombre"}, 0);
        tableClientes = new JTable(modelClientes);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(tableClientes), BorderLayout.CENTER);
        return panel;
    }

    private void cargarDatosClientes() {
        try {
            modelClientes.setRowCount(0);
            for (ClienteDTO c : clienteService.getClientes()) {
                modelClientes.addRow(new Object[]{c.getDocumento(), c.getNombre()});
            }
        } catch (Exception e) {}
    }

    private void agregarCliente() {
        try {
            clienteService.registrar(new ClienteDTO(txtCliDoc.getText(), txtCliNombre.getText()));
            txtCliDoc.setText(""); txtCliNombre.setText("");
            cargarDatosClientes();
            JOptionPane.showMessageDialog(this, "Cliente Agregado");
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    private void eliminarCliente() {
        int row = tableClientes.getSelectedRow();
        if (row == -1) return;
        try {
            clienteService.eliminar((String) modelClientes.getValueAt(row, 0));
            cargarDatosClientes();
            JOptionPane.showMessageDialog(this, "Eliminado");
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    // ==========================================
    // PESTAÑA 3: HISTORIAL PEDIDOS
    // ==========================================
    private JPanel crearPanelHistorialPedidos() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JButton btnDel = new JButton("Eliminar Pedido Seleccionado");
        btnDel.addActionListener(e -> eliminarPedido());

        modelPedidos = new DefaultTableModel(new String[]{"ID", "Cliente", "Producto", "Cant", "Fecha"}, 0);
        tablePedidos = new JTable(modelPedidos);

        panel.add(new JScrollPane(tablePedidos), BorderLayout.CENTER);
        panel.add(btnDel, BorderLayout.SOUTH);
        return panel;
    }

    private void cargarDatosPedidos() {
        try {
            modelPedidos.setRowCount(0);
            for (PedidoDTO p : pedidoService.listarPedidos()) {
                modelPedidos.addRow(new Object[]{p.getId(), p.getCliente().getNombre(), p.getProducto().getNombre(), p.getCantidad(), p.getFechaPedido()});
            }
        } catch (Exception e) {}
    }

    private void eliminarPedido() {
        int row = tablePedidos.getSelectedRow();
        if (row == -1) return;
        try {
            pedidoService.eliminar((Long) modelPedidos.getValueAt(row, 0));
            cargarDatosPedidos();
            JOptionPane.showMessageDialog(this, "Eliminado");
        } catch (Exception e) { JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); }
    }

    // ==========================================
    // PESTAÑA 4: GESTIÓN PRODUCTOS
    // ==========================================
    private JPanel crearPanelGestionProductos() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel formPanel = new JPanel(new FlowLayout());

        txtProdNombre = new JTextField(10);
        txtProdPrecio = new JTextField(6);
        txtProdStock = new JTextField(4);
        JButton btnAdd = new JButton("Agregar");
        JButton btnDel = new JButton("Eliminar");

        btnAdd.addActionListener(e -> agregarProducto());
        btnDel.addActionListener(e -> eliminarProducto());

        formPanel.add(new JLabel("Nombre:")); formPanel.add(txtProdNombre);
        formPanel.add(new JLabel("Precio:")); formPanel.add(txtProdPrecio);
        formPanel.add(new JLabel("Stock:"));  formPanel.add(txtProdStock);
        formPanel.add(btnAdd); formPanel.add(btnDel);

        modelProductos = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Stock"}, 0);
        tableProductos = new JTable(modelProductos);

        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(tableProductos), BorderLayout.CENTER);
        return panel;
    }

    private void cargarDatosProductos() {
        try {
            modelProductos.setRowCount(0);
            for (ProductoDTO p : productoService.getProductos()) {
                modelProductos.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getStock()});
            }
        } catch (Exception e) {}
    }

    private void agregarProducto() {
        try {
            ProductoDTO nuevo = ProductoDTO.builder()
                    .nombre(txtProdNombre.getText())
                    .precio(Double.parseDouble(txtProdPrecio.getText()))
                    .stock(Integer.parseInt(txtProdStock.getText()))
                    .build();
            productoService.registrar(nuevo);
            txtProdNombre.setText(""); txtProdPrecio.setText(""); txtProdStock.setText("");
            cargarDatosProductos();
            JOptionPane.showMessageDialog(this, "Producto Agregado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error (Verifica números): " + e.getMessage());
        }
    }

    private void eliminarProducto() {
        int row = tableProductos.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un producto");
            return;
        }
        Integer id = (Integer) modelProductos.getValueAt(row, 0);
        try {
            productoService.eliminar(id);
            cargarDatosProductos();
            JOptionPane.showMessageDialog(this, "Producto Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error (Quizás está en un pedido?): " + e.getMessage());
        }
    }
}