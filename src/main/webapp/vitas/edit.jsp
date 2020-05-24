<%-- 
    Document   : edit
    Created on : 22 may. 2020, 17:10:32
    Author     : Usuario
--%>

<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
                ProductoDAO dao=new ProductoDAO();
                int id_producto= Integer.parseInt((String)request.getAttribute("idpro"));
                Producto p= (Producto)dao.list(id_producto);
            
            %>
            <h1>Modificar Producto</h1>
            <form action="Controlador">
                ID:<br>
                <input type="hidden" name="txtId" value="<%= p.getId_producto() %>">
                Nombre:<br>
                <input type="text" name="txtNombre" value="<%= p.getNombre()%>"><br>
                Stock:<br>
                <input type="text" name="txtStock" value="<%= p.getStock()%>"><br>
                Precio de la compra:<br>
                <input type="text" name="txtPrecioCompra" value="<%= p.getPrecio_compra()%>"><br>
                Precio de la venta:<br>
                <input type="text" name="txtPrecioVenta" value="<%= p.getPrecio_venta()%>"><br><br>
                <input type="submit" name="accion" value="actualizar">
            </form>
        </div>
    </body>
</html>
