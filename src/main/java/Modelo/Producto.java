package Modelo;
public class Producto {
    
    
    private int id_producto;
    private String nombre;
    private int stock;
    private double precio_compra;
    private double precio_venta;

    public Producto() {
    }

    public Producto(int id_producto, String nombre, int stock, double precio_compra, double precio_venta) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.stock = stock;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }
}
