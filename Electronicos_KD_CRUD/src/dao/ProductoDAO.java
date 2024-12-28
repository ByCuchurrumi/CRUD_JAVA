package dao;

import modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public void crearProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripcion, precioBase, precioVenta, categoria, cantidadDisponible) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecioBase());
            pstmt.setDouble(4, producto.getPrecioVenta());
            pstmt.setString(5, producto.getCategoria());
            pstmt.setInt(6, producto.getCantidadDisponible());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Producto leerProducto(int codigoProducto) {
        String sql = "SELECT * FROM productos WHERE codigoProducto = ?";
        Producto producto = null;

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigoProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setCodigoProducto(rs.getInt("codigoProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioBase(rs.getDouble("precioBase"));
                producto.setPrecioVenta(rs.getDouble("precioVenta"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setCantidadDisponible(rs.getInt("cantidadDisponible"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    public List<Producto> leerTodosLosProductos() {
        String sql = "SELECT * FROM productos";
        List<Producto> productos = new ArrayList<>();

        try (Connection conn = ConexionDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigoProducto(rs.getInt("codigoProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioBase(rs.getDouble("precioBase"));
                producto.setPrecioVenta(rs.getDouble("precioVenta"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setCantidadDisponible(rs.getInt("cantidadDisponible"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precioBase = ?, precioVenta = ?, categoria = ?, cantidadDisponible = ? WHERE codigoProducto = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecioBase());
            pstmt.setDouble(4, producto.getPrecioVenta());
            pstmt.setString(5, producto.getCategoria());
            pstmt.setInt(6, producto.getCantidadDisponible());
            pstmt.setInt(7, producto.getCodigoProducto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int codigoProducto) {
        String sql = "DELETE FROM productos WHERE codigoProducto = ?";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigoProducto);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}