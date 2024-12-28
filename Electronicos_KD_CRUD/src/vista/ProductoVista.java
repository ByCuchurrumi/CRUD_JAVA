package vista;

import modelo.Producto;
import servicio.ProductoServicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoVista extends JFrame {
    private ProductoServicio productoServicio;
    private JTextField codigoProductoField;
    private JTextField nombreField;
    private JTextField descripcionField;
    private JTextField precioBaseField;
    private JTextField precioVentaField;
    private JTextField categoriaField;
    private JTextField cantidadDisponibleField;

    public ProductoVista() {
        productoServicio = new ProductoServicio();
        initUI();
    }

    private void initUI() {
        setTitle("Gestión de Productos");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel codigoProductoLabel = new JLabel("Código Producto:");
        codigoProductoLabel.setBounds(20, 20, 120, 25);
        add(codigoProductoLabel);

        codigoProductoField = new JTextField();
        codigoProductoField.setBounds(140, 20, 200, 25);
        add(codigoProductoField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20, 60, 120, 25);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(140, 60, 200, 25);
        add(nombreField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setBounds(20, 100, 120, 25);
        add(descripcionLabel);

        descripcionField = new JTextField();
        descripcionField.setBounds(140, 100, 200, 25);
        add(descripcionField);

        JLabel precioBaseLabel = new JLabel("Precio Base:");
        precioBaseLabel.setBounds(20, 140, 120, 25);
        add(precioBaseLabel);

        precioBaseField = new JTextField();
        precioBaseField.setBounds(140, 140, 200, 25);
        add(precioBaseField);

        JLabel precioVentaLabel = new JLabel("Precio Venta:");
        precioVentaLabel.setBounds(20, 180, 120, 25);
        add(precioVentaLabel);

        precioVentaField = new JTextField();
        precioVentaField.setBounds(140, 180, 200, 25);
        add(precioVentaField);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setBounds(20, 220, 120, 25);
        add(categoriaLabel);

        categoriaField = new JTextField();
        categoriaField.setBounds(140, 220, 200, 25);
        add(categoriaField);

        JLabel cantidadDisponibleLabel = new JLabel("Cantidad Disponible:");
        cantidadDisponibleLabel.setBounds(20, 260, 120, 25);
        add(cantidadDisponibleLabel);

        cantidadDisponibleField = new JTextField();
        cantidadDisponibleField.setBounds(140, 260, 200, 25);
        add(cantidadDisponibleField);

        JButton crearButton = new JButton("Crear");
        crearButton.setBounds(20, 300, 100, 25);
        add(crearButton);

        JButton leerButton = new JButton("Leer");
        leerButton.setBounds(130, 300, 100, 25);
        add(leerButton);

        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.setBounds(240, 300, 100, 25);
        add(actualizarButton);

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(20, 340, 320, 25);
        add(eliminarButton);

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = new Producto();
                producto.setCodigoProducto(Integer.parseInt(codigoProductoField.getText()));
                producto.setNombre(nombreField.getText());
                producto.setDescripcion(descripcionField.getText());
                producto.setPrecioBase(Double.parseDouble(precioBaseField.getText()));
                producto.setPrecioVenta(Double.parseDouble(precioVentaField.getText()));
                producto.setCategoria(categoriaField.getText());
                producto.setCantidadDisponible(Integer.parseInt(cantidadDisponibleField.getText()));
                productoServicio.crearProducto(producto);
                JOptionPane.showMessageDialog(null, "Producto creado con éxito");
            }
        });

        leerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoProducto = Integer.parseInt(codigoProductoField.getText());
                Producto producto = productoServicio.leerProducto(codigoProducto);
                if (producto != null) {
                    nombreField.setText(producto.getNombre());
                    descripcionField.setText(producto.getDescripcion());
                    precioBaseField.setText(String.valueOf(producto.getPrecioBase()));
                    precioVentaField.setText(String.valueOf(producto.getPrecioVenta()));
                    categoriaField.setText(producto.getCategoria());
                    cantidadDisponibleField.setText(String.valueOf(producto.getCantidadDisponible()));
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = new Producto();
                producto.setCodigoProducto(Integer.parseInt(codigoProductoField.getText()));
                producto.setNombre(nombreField.getText());
                producto.setDescripcion(descripcionField.getText());
                producto.setPrecioBase(Double.parseDouble(precioBaseField.getText()));
                producto.setPrecioVenta(Double.parseDouble(precioVentaField.getText()));
                producto.setCategoria(categoriaField.getText());
                producto.setCantidadDisponible(Integer.parseInt(cantidadDisponibleField.getText()));
                productoServicio.actualizarProducto(producto);
                JOptionPane.showMessageDialog(null, "Producto actualizado con éxito");
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoProducto = Integer.parseInt(codigoProductoField.getText());
                productoServicio.eliminarProducto(codigoProducto);
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProductoVista ex = new ProductoVista();
                ex.setVisible(true);
            }
        });
    }
}