package com.cafeteria.frontend.window;

import com.cafeteria.frontend.dtos.ClienteDTO;
import com.cafeteria.frontend.dtos.ProductoDTO;
import com.cafeteria.frontend.dtos.PedidoDTO;
import com.cafeteria.frontend.webservicesclient.ClienteApiClient;
import com.cafeteria.frontend.webservicesclient.PedidoApiClient;
import com.cafeteria.frontend.webservicesclient.ProductoApiClient;
import com.cafeteria.frontend.dtos.PedidoRequest; // Import el DTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MainFrame extends JFrame {

    // Inyección de dependencias
    @Autowired
    private ClienteApiClient clienteService;
    @Autowired
    private ProductoApiClient productoService;
    @Autowired
    private PedidoApiClient pedidoService;

    // Elementos Swing
    private JComboBox<String> comboClientes;
    private JComboBox<String> comboProductos;
    private final JSpinner spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private final JTextArea txtOutput = new JTextArea(10, 50);

    // Mapas para rastrear IDs
    private final Map<String, String> clienteDocMap = new HashMap<>();
    private final Map<String, Integer> productoIdMap = new HashMap<>();

    public MainFrame() {
        setSize(600, 400);
    }

    public void initializeUI() {
        setTitle("Gestión de Pedidos de Cafetería (Swing + Spring)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Cargar datos (idealmente en un hilo separado, pero simple por ahora)
        List<ClienteDTO> clienteDTOList = clienteService.getClientes();
        //List<ClienteDTO> clienteDTOList = List.of(new ClienteDTO("Richard Rendón", "123"), new ClienteDTO("Diana Ruiz", "456")); // <-- Elimina o comenta esta línea
        List<ProductoDTO> productoDTOList = productoService.getProductos();
        // Llenar ComboBox de Clientes
        DefaultComboBoxModel<String> modeloClientes = new DefaultComboBoxModel<>();
        for (ClienteDTO cliente : clienteDTOList) {
            String displayKey = String.format("%s (%s)", cliente.getNombre(), cliente.getDocumento());
            modeloClientes.addElement(displayKey);
            clienteDocMap.put(displayKey, cliente.getDocumento());
        }
        comboClientes = new JComboBox<>(modeloClientes);

        // Llenar ComboBox de Productos
        DefaultComboBoxModel<String> modeloProductos = new DefaultComboBoxModel<>();
        for (ProductoDTO p : productoDTOList) {
            String displayKey = String.format("%s - $%.2f", p.getNombre(), p.getPrecio());
            modeloProductos.addElement(displayKey);
            productoIdMap.put(displayKey, p.getId());
        }
        comboProductos = new JComboBox<>(modeloProductos);

        // --- Panel de Entradas (TOP) ---
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Seleccionar Cliente:"));
        inputPanel.add(comboClientes);

        inputPanel.add(new JLabel("Seleccionar Producto:"));
        inputPanel.add(comboProductos);

        inputPanel.add(new JLabel("Cantidad:"));
        inputPanel.add(spinnerCantidad);

        JButton btnCrearPedido = new JButton("Crear Pedido");
        btnCrearPedido.addActionListener(e -> crearPedido());
        inputPanel.add(btnCrearPedido);

        add(inputPanel, BorderLayout.NORTH);

        // --- Panel de Salida (CENTER) ---
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Registro de Pedidos"));
        add(scrollPane, BorderLayout.CENTER);

        // --- Configuración final de la ventana ---
        pack();
        setLocationRelativeTo(null);
    }

    private void crearPedido() {
        String result;
        try {
            // 1. Obtener IDs seleccionados de los mapas
            String selectedClienteKey = (String) comboClientes.getSelectedItem();
            String selectedProductoKey = (String) comboProductos.getSelectedItem();

            String documentoCliente = clienteDocMap.get(selectedClienteKey);
            Integer productoId = productoIdMap.get(selectedProductoKey);
            Integer cantidad = (Integer) spinnerCantidad.getValue();

            if (documentoCliente == null || productoId == null) {
                throw new Exception("Selección inválida.");
            }

            // 2. Crear el objeto de solicitud
            PedidoRequest request = new PedidoRequest(documentoCliente, productoId, cantidad);

            // 3. Llamar al servicio API
            PedidoDTO pedidoCreado = pedidoService.crearPedido(request);

            result = String.format("ÉXITO: Pedido #%d creado para %s (Producto: %s)",
                    pedidoCreado.getId(),
                    pedidoCreado.getCliente().getNombre(),
                    pedidoCreado.getProducto().getNombre());

            JOptionPane.showMessageDialog(this, result, "Pedido Creado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            result = "ERROR: " + e.getMessage();
            JOptionPane.showMessageDialog(this, result, "Error en Pedido", JOptionPane.ERROR_MESSAGE);
        }

        // 4. Mostrar resultado en el log
        txtOutput.append(result + "\n");
        txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
    }
}