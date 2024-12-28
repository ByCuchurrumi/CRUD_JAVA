package servicio;

import dao.ProductoDAO;
import modelo.Producto;
import java.util.List;

public class ProductoServicio {
    private ProductoDAO productoDAO;

    public ProductoServicio() {
        this.productoDAO = new ProductoDAO();
    }

    public void crearProducto(Producto producto) {
        productoDAO.crearProducto(producto);
    }

    public Producto leerProducto(int codigoProducto) {
        return productoDAO.leerProducto(codigoProducto);
    }

    public List<Producto> leerTodosLosProductos() {
        return productoDAO.leerTodosLosProductos();
    }

    public void actualizarProducto(Producto producto) {
        productoDAO.actualizarProducto(producto);
    }

    public void eliminarProducto(int codigoProducto) {
        productoDAO.eliminarProducto(codigoProducto);
    }
}