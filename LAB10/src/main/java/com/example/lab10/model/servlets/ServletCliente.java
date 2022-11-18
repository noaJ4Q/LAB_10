package com.example.lab10.model.servlets;

import com.example.lab10.model.Beans.Clientes;
import com.example.lab10.model.Beans.Contratos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCliente", value = "/inicio")
public class ServletCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        RequestDispatcher vista;
        String action = request.getParameter("action")==null? "misDatos":request.getParameter("action");

        switch (action){
            case "misDatos":
                //Clientes cliente = (Clientes) session.getAttribute("cliente");
                //request.setAttribute("cliente", cliente);
                vista = request.getRequestDispatcher("clienteMisDatos.jsp");
                vista.forward(request, response);

            case "contratos":

                break;
            case "contratosPorEstado":
                break;
            case "puntaje":
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
