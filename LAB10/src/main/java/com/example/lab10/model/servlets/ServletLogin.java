package com.example.lab10.model.servlets;

import com.example.lab10.model.Beans.Credentials;
import com.example.lab10.model.Daos.DaoClientes;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher vista;
        vista = request.getRequestDispatcher("login.jsp");
        vista.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String numeroDocumento = request.getParameter("numeroDocumento");
        String password = request.getParameter("password");

        RequestDispatcher vista;

        DaoClientes daoClientes = new DaoClientes();
        Credentials credentials = daoClientes.buscarUsuario(numeroDocumento, password);

        if (credentials != null){
            switch (credentials.getTipoUsuario()){
                case 1:
                    request.setAttribute("numeroDocumento", credentials.getNumeroDocumento());
                    vista = request.getRequestDispatcher("cliente.jsp");
                    vista.forward(request, response);
                    break;
                case 2:
                    vista = request.getRequestDispatcher("crearCliente.jsp");
                    vista.forward(request, response);
                    break;
            }
        }
        else {

            HttpSession session = request.getSession();
            session.setAttribute("msg", "Datos erróneos");
            vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request, response);
        }


    }
}
