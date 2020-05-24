package Controlador;

import Modelo.Producto;
import ModeloDAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Controlador extends HttpServlet {
    
    int id_producto;
    Producto p=new Producto();
    ProductoDAO dao= new ProductoDAO();
    String listar ="vitas/listar.jsp";
    String add="vitas/add.jsp";
    String editar="vitas/edit.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String acceso="";
        String accion=request.getParameter("accion");
        
        //Mostrar los elementos de la tabla
        if(accion.equalsIgnoreCase("listar")){
            acceso=listar;
        }else if(accion.equalsIgnoreCase("add")){
            acceso=add;
            
            
        //agregar elementos a la tabla
        }else if(accion.equalsIgnoreCase("agregar")){
            String nombre=request.getParameter("txtNombre");
            int stock=Integer.parseInt(request.getParameter("txtStock"));
            double precio_compra=Double.parseDouble(request.getParameter("txtPrecioCompra"));
            double precio_venta=Double.parseDouble(request.getParameter("txtPrecioVenta"));
            p.setNombre(nombre);
            p.setStock(stock);
            p.setPrecio_compra(precio_compra);
            p.setPrecio_venta(precio_venta);
            dao.add(p);
            acceso=listar;
            
            
        //editar los datos de la tabla productos
        }else if(accion.equalsIgnoreCase("editar")){
            request.setAttribute("idpro", request.getParameter("id_producto"));
            acceso=editar;
            
        //confirmamos la edicion del dato seleccionado
        }else if(accion.equalsIgnoreCase("actualizar")){
            id_producto = Integer.parseInt(request.getParameter("txtId"));
            String nombre=request.getParameter("txtNombre");
            int stock=Integer.parseInt(request.getParameter("txtStock"));
            double precio_compra=Double.parseDouble(request.getParameter("txtPrecioCompra"));
            double precio_venta=Double.parseDouble(request.getParameter("txtPrecioVenta"));
            p.setId_producto(id_producto);
            p.setNombre(nombre);
            p.setStock(stock);
            p.setPrecio_compra(precio_compra);
            p.setPrecio_venta(precio_venta);
            dao.edit(p);
            acceso=listar;
        }
        
        //Eliminar datos de la tabla producto.
        
        else if(accion.equalsIgnoreCase("eliminar")){
            id_producto = Integer.parseInt(request.getParameter("id_producto"));
            p.setId_producto(id_producto);
            dao.eliminar(id_producto);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
