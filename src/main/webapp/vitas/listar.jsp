<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inventario Productos</h1>
        <a href="Controlador?accion=add">Agregar Nuevo producto</a>
        <table border="1">
            <thead>
                <tr>
                    <th>id_producto</th>
                    <th>Nombre</th>
                    <th>stock</th>
                    <th>precio_compra</th>
                    <th>precio_venta</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <%
                ProductoDAO dao = new ProductoDAO();
                List<Producto>list = dao.listar();
                Iterator<Producto>iter=list.iterator();
                Producto pro=null;
                while(iter.hasNext()){
                    pro=iter.next();
                
            %>
            <tbody>
                <tr>
                    <td><%= pro.getId_producto() %></td>
                    <td><%= pro.getNombre()%></td>
                    <td><%= pro.getStock()%></td>
                    <td><%= pro.getPrecio_compra()%></td>
                    <td><%= pro.getPrecio_venta()%></td>
                    <td>
                        <a href="Controlador?accion=editar&id_producto=<%= pro.getId_producto() %>">Editar</a>
                        <a href="Controlador?accion=eliminar&id_producto=<%= pro.getId_producto() %>">Eliminar</a>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
