<%--
  Created by IntelliJ IDEA.
  User: noqe2
  Date: 16/11/2022
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cliente" type="com.example.lab10.model.Beans.Clientes" class="com.example.lab10.model.Beans.Clientes" scope="session"></jsp:useBean>
<html>
    <head>
        <title>Cliente</title>

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="assets/headers.css" rel="stylesheet">


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
    </head>
    <body>

        <div class="b-example-divider"></div>

        <div class="container">
            <header class="d-flex justify-content-center py-3 border-bottom">
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/inicio" class="nav-link active" aria-current="page">Mis Datos</a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/inicio?action=contratos" class="nav-link">Contratos</a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/inicio?action=contratosxe" class="nav-link">Contratos por Estado</a></li>
                    <li class="nav-item"><a href="<%=request.getContextPath()%>/inicio?action=puntaje" class="nav-link">Puntaje máximo de Expected Loss</a></li>
                </ul>
            </header>
        </div>

        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Tipo de Persona</th>
                        <th scope="col">Número de Documento</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th><%=cliente.getNombreCliente()%></th>
                        <td><%=cliente.getEdad()%></td>
                        <td><%=cliente.getTipoCliente()%></td>
                        <td><%=cliente.getNumeroDocumento()%></td>
                    </tr>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>

    </body>
</html>
