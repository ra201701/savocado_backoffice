<%-- 
    Document   : index
    Created on : Aug 21, 2020, 6:42:36 PM
    Author     : edgarrenderos
--%>

<%@page import="crud.model.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <title>Editar empleado</title>
    </head>
    <body>
        <% Empleado empleado = (Empleado) request.getAttribute("employee");%>
    <center>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-md-6">
                    <div style="height: 30px"></div>
                    <h4 class="text-center">Editar empleado</h4>
                    <form action="EditEmployee" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" required name="id" value="<%=empleado.getId()%>">
                        </div>
                        <div class="form-group">
                            <label for="name">Nombre:</label>
                            <input type="text" class="form-control" required name="name" value="<%=empleado.getName()%>">
                        </div>
                        <div class="form-group">
                            <label for="pass">Contraseña:</label>
                            <input type="text" class="form-control" name="pass" required value="<%=empleado.getPassword()%>">
                        </div>
                        <div class="form-group">
                            <label for="email">Correo:</label>
                            <input type="text" class="form-control" name="email" required value="<%=empleado.getEmail()%>">
                        </div>
                        
                        <div class="form-group">
                            <label for="country">Pais:</label>
                            <select class="form-control" name="country" required>
                                <option selected='<%=empleado.getCountry().equals("India")?"selected":""%>'>India</option>
                                <option selected='<%=empleado.getCountry().equals("Perú")?"selected":""%>'>Perú</option>
                                <option selected='<%=empleado.getCountry().equals("USA")?"selected":""%>'>USA</option>
                                <option selected='<%=empleado.getCountry().equals("El Salvador")?"selected":""%>'>El Salvador</option>
                                <option selected='<%=empleado.getCountry().equals("UK")?"selected":""%>'>UK</option>
                                <option selected='<%=empleado.getCountry().equals("Otro")?"selected":""%>'>Otro</option>
                                
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <input type="submit" class="btn btn-success" value="Editar empleado"/>
                        </div>
                    </form>
                    <br>
                    <a href="ViewEmployee">Ver empleados</a>
                </div>
            </div>
        </div>
    </center>
    </body>
</html>
