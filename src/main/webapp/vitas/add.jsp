<%-- 
    Document   : add
    Created on : 22 may. 2020, 17:10:22
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Agregar Producto</h1>
            <form action="Controlador">
                Nombre:<br>
                <input type="text" name="txtNombre"><br>
                Stock:<br>
                <input type="text" name="txtStock"><br>
                Precio de la compra:<br>
                <input type="text" name="txtPrecioCompra"><br>
                Precio de la venta:<br>
                <input type="text" name="txtPrecioVenta"><br><br>
                <input type="submit" name="accion" value="agregar">
            </form>
        </div>
    </body>
</html>
