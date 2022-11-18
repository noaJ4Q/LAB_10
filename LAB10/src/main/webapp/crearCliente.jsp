<%--
  Created by IntelliJ IDEA.
  User: noqe2
  Date: 17/11/2022
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Crear Cliente</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.84.0">
        <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

        <!-- Bootstrap core CSS -->
        <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <meta name="theme-color" content="#7952b3">
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
        <link href="assets/signin.css" rel="stylesheet">

    </head>
    <body class="text-center">

        <main class="form-signin">
            <form method="post">
                <h1 class="h3 mb-3 fw-normal">Crear Cliente</h1>

                <div class="form-floating">
                    <select required class="form-select" id="usuario" name="numeroDocumento">
                        <option value="">Seleccione un documento</option>

                    </select>

                    <label for="usuario">Número de Documento</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" name="contrasena" placeholder="Ingrese una contraseña" required>
                    <label for="floatingPassword">Contraseña</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Crear</button>
            </form>
        </main>



    </body>
</html>
