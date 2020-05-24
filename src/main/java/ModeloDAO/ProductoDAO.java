package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Producto p=new Producto();
    
    @Override
    public List listar() {
        ArrayList<Producto>list=new ArrayList<>();
        String sql = "select * from productos";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pro = new Producto();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio_compra(rs.getDouble("precio_compra"));
                pro.setPrecio_venta(rs.getDouble("precio_venta"));
                list.add(pro);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Producto list(int id_producto) {
        String sql="select * from productos where id_producto="+id_producto;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setId_producto(rs.getInt("id_producto"));
                p.setNombre(rs.getString("nombre"));
                p.setStock(rs.getInt("stock"));
                p.setPrecio_compra(rs.getDouble("precio_compra"));
                p.setPrecio_venta(rs.getDouble("precio_venta"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Producto pro) {
        String sql="insert into productos(nombre, stock, precio_compra, precio_venta)"
                + "values('"+pro.getNombre()+
                "','"+pro.getStock()+
                "','"+pro.getPrecio_compra()+
                "','"+pro.getPrecio_venta()+"')";
        try {
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Producto pro) {
        String sql="update productos set nombre='"+pro.getNombre()+
                "',stock='"+pro.getStock()+
                "',precio_compra='"+pro.getPrecio_compra()+
                "',precio_venta='"+pro.getPrecio_venta()+
                "'where id_producto="+pro.getId_producto();
        try {
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id_producto) {
        String sql="delete from productos where id_producto="+id_producto;
        try {
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
