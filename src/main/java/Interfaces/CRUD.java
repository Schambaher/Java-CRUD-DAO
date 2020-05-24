package Interfaces;

import Modelo.Producto;
import java.util.List;

public interface CRUD {
    
    public List listar();
    public Producto list(int id_producto);
    public boolean add(Producto pro);
    public boolean edit(Producto pro);
    public boolean eliminar(int id_producto);
    
}
